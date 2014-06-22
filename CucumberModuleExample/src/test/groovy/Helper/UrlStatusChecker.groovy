package Helper

import com.sun.jersey.api.client.Client
import com.sun.jersey.api.client.ClientResponse
import org.apache.http.HttpResponse
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpRequestBase
import org.apache.http.client.params.ClientPNames
import org.apache.http.client.protocol.ClientContext
import org.apache.http.cookie.Cookie
import org.apache.http.impl.client.BasicCookieStore
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.impl.cookie.BasicClientCookie
import org.apache.http.params.HttpParams
import org.apache.http.protocol.BasicHttpContext
import org.apache.log4j.Logger
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import sun.rmi.server.UnicastRef

import javax.ws.rs.core.MediaType

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 20/06/14
 * Time: 23:14
 * To change this template use File | Settings | File Templates.
 */

//http://ardesco.lazerycode.com/index.php/2012/07/how-to-download-files-with-selenium-and-why-you-shouldnt/

class UrlStatusChecker {
    private static final logger = Logger.getLogger(UrlStatusChecker.class)
    private URI linkToCheck
    private WebDriver driver
    private boolean mimicWebDriverCookieState = true
    private boolean followRedirect = false
    private RequestMethod httpRequestMethod = RequestMethod.GET
    private String localDownloadPath = System.getProperty("/home/yusoof");

    public UrlStatusChecker(WebDriver driver) throws MalformedURLException{
        this.driver = driver
    }

    public void setURIToCheck(String linkToCheck) throws MalformedURLException, URISyntaxException{
        this.linkToCheck = new URI(linkToCheck)
    }

    public void setURIToCheck(URI linkToCheck) throws MalformedURLException {
        this.linkToCheck = linkToCheck;
    }

    public void setURIToCheck(URL linkToCheck) throws URISyntaxException {
        this.linkToCheck = linkToCheck.toURI();
    }

    public void setHTTPRequestMethod(RequestMethod requestMethod) {
        this.httpRequestMethod = requestMethod;
    }
                                          
    public void followRedirects(Boolean value) {
        this.followRedirect = value;
    }

    public int getHttpStatusCode(){
        HttpClient client = new DefaultHttpClient()
        BasicHttpContext localContext = new BasicHttpContext()
        logger.info("Mimic WebDriver cookie state: " + this.mimicWebDriverCookieState)
        if(this.mimicWebDriverCookieState){
            localContext.setAttribute(ClientContext.COOKIE_STORE, mimicCookieState(this.driver.manage().getCookies()));
        }
        HttpRequestBase requestMethod = this.httpRequestMethod.getRequestMethod()
        requestMethod.setURI(this.linkToCheck)
        HttpParams httpRequestParameters = requestMethod.getParams()
        httpRequestParameters.setParameter(ClientPNames.HANDLE_REDIRECTS, this.followRedirect)

        logger.info("Sending " + requestMethod.getMethod() + " request for: " + requestMethod.getURI())
        HttpResponse response = client.execute(requestMethod, localContext)
        logger.info("HTTP " + requestMethod.getMethod() + " request status: " + response.getStatusLine().getStatusCode())

        return response.getStatusLine().getStatusCode()
    }

    private BasicCookieStore mimicCookieState(Set seleniumCookieSet) {
        BasicCookieStore mimicWebDriverCookieStore = new BasicCookieStore();
        for (org.openqa.selenium.Cookie seleniumCookie : seleniumCookieSet) {
            BasicClientCookie duplicateCookie = new BasicClientCookie(seleniumCookie.getName(), seleniumCookie.getValue());
            duplicateCookie.setDomain(seleniumCookie.getDomain());
            duplicateCookie.setSecure(seleniumCookie.isSecure());
            duplicateCookie.setExpiryDate(seleniumCookie.expiry);
            duplicateCookie.setPath(seleniumCookie.getPath());
            mimicWebDriverCookieStore.addCookie(duplicateCookie);
        }

        return mimicWebDriverCookieStore;
    }
}
