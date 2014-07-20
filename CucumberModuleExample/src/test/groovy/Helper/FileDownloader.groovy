package Helper

import org.apache.commons.io.FileUtils
import org.apache.http.HttpResponse
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpRequestBase
import org.apache.http.client.params.ClientPNames
import org.apache.http.client.protocol.ClientContext
import org.apache.http.impl.client.BasicCookieStore
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.impl.cookie.BasicClientCookie
import org.apache.http.params.HttpParams
import org.apache.http.protocol.BasicHttpContext
import org.apache.log4j.Logger
import org.openqa.selenium.Cookie
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 22/06/14
 * Time: 20:30
 * To change this template use File | Settings | File Templates.
 */
class FileDownloader {
    private static final Logger log = Logger.getLogger(FileDownloader.class)
    private WebDriver driver
    private String localDownloadPath = System.getProperty("java.io.tmpdir")
    private boolean followRedirects = true
    private boolean mimicWebDriverCookieState = true
    private int httpStatusOfLastDownloadAttempt = 0
    RequestMethod httpRequestMethod = RequestMethod.GET

    public FileDownloader(WebDriver driver){
        this.driver = driver
    }

    public void followRedirectsWhenDownloading(boolean value){
        this.followRedirects = value
    }

    public String localDownloadPath() {
        return this.localDownloadPath;
    }

    public void localDownloadPath(String filePath) {
        this.localDownloadPath = filePath;
    }

    public String downloadFile(WebElement element) throws Exception {
        return downloader(element, "href");
    }

    public String downloadImage(WebElement element) throws Exception {
        return downloader(element, "href");
    }

    public int getHTTPStatusOfLastDownloadAttempt() {
        return this.httpStatusOfLastDownloadAttempt;
    }

    public void mimicWebDriverCookieState(boolean value) {
        this.mimicWebDriverCookieState = value;
    }

    private BasicCookieStore mimicCookieState(Set seleniumCookieSet) {
        BasicCookieStore mimicWebDriverCookieStore = new BasicCookieStore();
        for (Cookie seleniumCookie : seleniumCookieSet) {
            BasicClientCookie duplicateCookie = new BasicClientCookie(seleniumCookie.getName(), seleniumCookie.getValue());
            duplicateCookie.setDomain(seleniumCookie.getDomain());
            duplicateCookie.setSecure(seleniumCookie.isSecure());
            duplicateCookie.setExpiryDate(seleniumCookie.getExpiry());
            duplicateCookie.setPath(seleniumCookie.getPath());
            mimicWebDriverCookieStore.addCookie(duplicateCookie);
        }

        return mimicWebDriverCookieStore;
    }

    private String downloader(WebElement element, String attribute){
        String fileToDownloadLocation = element.getAttribute(attribute)

        def fileName = fileToDownloadLocation =~ /(.*)\/(.*)/

        if(fileToDownloadLocation.trim().equals(""))
            throw new NullPointerException("The element you have specified does not link to anything!");

        URL fileToDownload = new URL(fileToDownloadLocation)
//        File downloadedFile = new File(this.localDownloadPath + fileName[0][2]);
        File downloadedFile = new File(ConfigurationHelper.getConfiguration().getProperty("localDownloadPath") + fileName[0][2]);
        if (downloadedFile.canWrite() == false) downloadedFile.setWritable(true);

        HttpClient client = new DefaultHttpClient()
        BasicHttpContext localContext = new BasicHttpContext()

        if(this.mimicWebDriverCookieState){
            localContext.setAttribute(ClientContext.COOKIE_STORE, mimicCookieState(this.driver.manage().getCookies()));
        }
        HttpRequestBase requestMethod = this.httpRequestMethod.getRequestMethod()
        requestMethod.setURI(fileToDownload.toURI())
        HttpParams httpRequestParameters = requestMethod.getParams();
        httpRequestParameters.setParameter(ClientPNames.HANDLE_REDIRECTS, this.followRedirects);
        requestMethod.setParams(httpRequestParameters);

        HttpResponse response = client.execute(requestMethod, localContext)
        this.httpStatusOfLastDownloadAttempt = response.getStatusLine().getStatusCode()
        FileUtils.copyInputStreamToFile(response.getEntity().getContent(), downloadedFile);
        response.getEntity().getContent().close();

        String downloadedFileAbsolutePath = downloadedFile.getAbsolutePath();
        assert new File(downloadedFileAbsolutePath).exists()
        return downloadedFileAbsolutePath
    }

}
