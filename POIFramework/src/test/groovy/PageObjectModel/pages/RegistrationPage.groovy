package PageObjectModel.pages

import PageObjectModel.utils.WebDriverUtils
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.Select

import java.text.DateFormat
import java.text.SimpleDateFormat

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 15/03/14
 * Time: 21:56
 * To change this template use File | Settings | File Templates.
 */
class RegistrationPage extends WebDriverUtils implements Page{

    void acceptAdvisorChecks(){
        driver.findElement(By.id("customerDetailsProceedButton")).click()
    }

    Random generator = new Random()
    String emailId = "abc${(generator.nextInt(9000000) + 1000000)}@email.com"

    void enterCreditCheckDetailsSection() {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        Date date = new Date();
        String newDate = dateFormat.format(date)
        //System.out.println(newDate);
        String dob = newDate.replace("2014","1907")

        new Select(driver.findElement(By.id("ccTitle"))).selectByIndex(1);
        driver.findElement(By.id("ccFirstName")).sendKeys("First Name")
        driver.findElement(By.id("ccLastname")).sendKeys("Last Name")
        driver.findElement(By.id("ccEmail")).sendKeys(emailId)
        driver.findElement(By.id("ccDob")).sendKeys(dob)
        driver.findElement(By.id("ccMobile")).sendKeys("07123456789")
        driver.findElement(By.cssSelector("input[name='houseNum']")).sendKeys("260")
        driver.findElement(By.cssSelector("input[name='postcode']")).sendKeys("SL1 4DX")
        driver.findElement(By.cssSelector("input.findAddressBtn")).click()
        sleep(5000)
        driver.findElements(By.cssSelector("input.selectAddrBtn")).get(0).click()
        driver.findElement(By.id("yearsAtCurrentAddress")).sendKeys("9")
        driver.findElement(By.id("monthsAtCurrentAddress")).sendKeys("5")
        driver.findElement(By.id("accountName")).sendKeys("name")
        driver.findElement(By.id("sortCode")).sendKeys("201596")
        driver.findElement(By.id("accountNumber")).sendKeys("10207136")

        captureCreditCardDetails()

        assert driver.findElement(By.id("cardCaptureStatus")).getText() == "Card capture completed successfully."

        driver.findElement(By.id("agreeToCreditCheck")).click()
        driver.findElement(By.cssSelector("input.performCreditCheckBtn")).click()
        sleep(7000)

        driver.findElement(By.id("regPassword")).sendKeys("password-1")
        driver.findElement(By.id("regConfirmPswd")).sendKeys("password-1")

        new Select(driver.findElement(By.id("securityQuestion"))).selectByIndex(1);
        driver.findElement(By.id("securityAnswer")).sendKeys("test")
        driver.findElement(By.name("submitCheck")).click()

    }


    OrderConfirmationPage setDeliveryDateAndClickOnPayNow(){
       driver.findElement(By.cssSelector("td.selectedSlot")).click()
       driver.findElement(By.cssSelector(".payByCard")).click()
       sleep(5000)
       driver.findElement(By.cssSelector("INPUT#txtCardSecurityCode.textField.cvvField")).sendKeys("1234")
       driver.findElement(By.cssSelector("#btnPayNow")).click()
       new OrderConfirmationPage()
    }


    void captureCreditCardDetails(){

        String winHandleBefore = driver.getWindowHandle();

        driver.findElement(By.id("captureCardDetails")).click()

        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        sleep(5000)

        driver.findElement(By.id("txtCardHolderName")).sendKeys("name")
        new Select(driver.findElement(By.id("ddlCardType"))).selectByIndex(1);
        driver.findElement(By.id("txtCardNumber")).sendKeys("374245455400001")
        new Select(driver.findElement(By.id("ddlMonth"))).selectByIndex(1);
        new Select(driver.findElement(By.id("ddlYr"))).selectByIndex(2);
        driver.findElement(By.id("txtSecurityCode")).sendKeys("1234")
        driver.findElement(By.id("btnPayNow")).click()

        driver.switchTo().window(winHandleBefore);

    }

    void updateEmailAddressSection(){
        driver.findElement(By.id("updateEmailAddressProceedButton")).click()
    }

    void acceptRefreshDealSummary(){
        driver.findElement(By.id("secciYesButton")).click()
    }



    CCALinkPage generateCCA(){
        driver.findElement(By.cssSelector(".generateCca")).click()
        return new OrderConfirmationPage()
    }


}
