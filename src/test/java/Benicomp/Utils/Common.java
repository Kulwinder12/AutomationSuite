package Benicomp.Utils;

import Benicomp.Locators.HelpCenterRepo;
import Benicomp.Modules.HelpCenter;
import com.codeborne.selenide.*;
import Benicomp.Locators.LoginOutRepo;
import Benicomp.Start.Start;
import Benicomp.Urls.Urls;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static Benicomp.Utils.TestBase.logTestStep;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

/**
 * @author smartData
 * <h1>Common Functions</h1>
 * <p>Purpose: This class is for common function</p>
 * It is used to handle all the common functionalities which can be used in other classes
 */
public class Common extends Start {

    public static final long DEFAULT_WAIT = 10000;
    public static final long DEFAULT_IMPLICIT_WAIT_IN_SEC = 15;

    /**
     * <h1><h1/>
     * <p>Purpose:This method is used for browser initialization</p>
     */
    public static void Init() throws Exception {
        InitilizeBrowser();
    }

    /**
     * <h1>Login User <h1/>
     * <p>Purpose:This method is used for login to application</p>
     *
     * @param UserName,Password
     * @throws Exception
     */

    public static void loginUser(String UserName, String Password) throws Exception {
        Log.info("Start Log in to application");
        Log.info("Enter user name");
        findAnElement(LoginOutRepo.txtUsername).sendKeys(UserName);
        //clearAndSendKeys(LoginOutRepo.txtUsername,UserName,"Enter user name");
        Log.info("Enter password");
        findAnElement(LoginOutRepo.txtPassword).sendKeys(Password);
        //clearAndSendKeys(LoginOutRepo.txtPassword, Password,"Enter password");
      //  findAnElement(LoginOutRepo.buttonSignin).waitUntil(Condition.visible,DEFAULT_WAIT).click();
        $x("//button[@title='Sign In']").waitUntil(Condition.visible,DEFAULT_WAIT).click();
        //clickElement(By.id("Login"), "Login button");
        sleep(2000);
        waitForPageLoadToComplete();
        Log.info("User logged in successfully.");
    }


    /**
     * <h1>Verify Element Exists <h1/>
     * <p>Purpose:This method is used to verify is element exists </p>
     *
     * @param by
     * @throws Exception
     */

    public static boolean IsElementExists(By by) {
        try {
            sleep(2000);
            return $(by).exists();
        } catch (Exception e) {
            return false;
        }
    }




    public static void clickElement(By Element, String detail) throws Exception {
        try {
            Log.info("Clicking on:" + detail);
            $(Element)
                    .waitUntil(visible, DEFAULT_WAIT)
                    .click();
            sleep(4000);
        } catch (Exception e) {
            Log.error("Error on:" + detail);
            Log.error("There is exception: " + e.getMessage());
            throw e;
        }
    }

    /**
     * <h1>Click on Element <h1/>
     * <p>Purpose:This method is used to perform click functionality </p>
     *
     * @param Element,detail
     * @throws Exception
     */

    public static void clickElement(WebElement Element, String detail) {
        try {
            Log.info("Clicking on:" + detail);
            $(Element)
                    .waitUntil(appear, DEFAULT_WAIT)
                    .click();
        } catch (Exception e) {
            Log.error("There is an exception: " + e.toString());
        }
    }

    /**
     * <h1>Find All Elements<h1/>
     * <p>Purpose:This method is used to get all web elements </p>
     *
     * @param Element,timeOutInSeconds
     * @throws Exception
     */

    public static List<WebElement> findAllElements(By Element) throws Exception {
        List<WebElement> TempElement = null;
        try {
            WaitTool.waitForElementsPresentAndDisplay(Element);
            TempElement = WebDriverRunner.getWebDriver().findElements(Element);
            return TempElement;
        } catch (Exception e) {
            Log.error("There is exception: " + e.toString());
            throw e;
        }
    }

    /**
     * <h1>Find Elements By ExactText<h1/>
     * <p>Purpose:This method is used to find element by exacts text (String text) </p>
     *
     * @param text
     */


    public static WebElement FindAnElementByExactText(String text) {
        return $(byText(text)).waitUntil(appear, DEFAULT_WAIT).getWrappedElement();
    }

    public static WebElement FindAnElementByTextContains(String text) {
        return $(withText(text)).waitUntil(appear, DEFAULT_WAIT).getWrappedElement();
    }


    public static void HighlightElement(By by) {
        WebElement elm = $(by).getWrappedElement();
        // draw a border around the found element
        executeJavaScript("arguments[0].style.backgroundColor='#80ff80'", elm);
    }

    public static void HighlightElement(ElementsCollection elm) {
        // draw a border around the found element
        executeJavaScript("arguments[0].style.backgroundColor='#80ff80'", elm);
    }

    public static WebElement findAnElement(By Element) {
        WebElement TempElement = null;
        try {
            TempElement = $(Element)
                    .waitUntil(appear, DEFAULT_WAIT).getWrappedElement();
        } catch (Exception e) {
            Log.error("There is an exception: " + e.toString());
            throw e;
        }
        return TempElement;
    }

    //Clear and Send Keys
    public static void clearAndSendKeys(By Element, String KeysToSend, String Detail) throws Exception {
        try {
            Log.info("Input " + Detail);
            WebElement inputElement=$(Element)
                    .waitUntil(appear, DEFAULT_WAIT)
                    .waitUntil(enabled, DEFAULT_WAIT).getWrappedElement();
            sleep(1000);
            inputElement.clear();

            inputElement.sendKeys(KeysToSend);
        } catch (Exception e) {
            Log.error("Error in setting a text value: " + e.toString());
            throw e;
        }
    }


    //TBD
    public static void ClickLink(String LinkToClick) {
        $(byLinkText(LinkToClick)).waitUntil(appear, DEFAULT_WAIT).click();
    }

    public static void ClickArrowIcon(By ArrowToClick) {
        try {
            WaitTool.waitForElementsPresentAndDisplay(ArrowToClick);
            List<WebElement> ArrowToOpenMenu = Common.findAllElements(ArrowToClick);

            if (ArrowToOpenMenu.size() > 0) {
                if (ArrowToOpenMenu.size() > 1) {
                    clickElement(ArrowToOpenMenu.get(1), "Arrow to open menu");
                } else {
                    clickElement(ArrowToOpenMenu.get(0), "Arrow to open menu");
                }
            }
        } catch (Exception e) {
            Log.error("Error in ClickArrowIcon: " + e.toString());
        }
    }

    public static void SelectDropdownText(By Dropdown, String TextToSelect) {
        try {
            WaitTool.waitForElementPresentAndDisplay(Dropdown);
            Select drpToSelectFrom = new Select(WebDriverRunner.getWebDriver().findElement(Dropdown));
            drpToSelectFrom.selectByVisibleText(TextToSelect);
        } catch (Exception e) {
            Log.error("There is an exception: " + e.toString());
        }
    }

    public static void SelectDropdownText(WebElement Dropdown, String TextToSelect) {
        try {
            Select drpToSelectFrom = new Select(Dropdown);
            drpToSelectFrom.selectByVisibleText(TextToSelect);
        } catch (Exception e) {
            Log.error("There is an exception: " + e.toString());
        }
    }

    //TBD
    public static void SwitchToDefaultContent(int Interval) {
        try {
            System.out.println("Switching default");
            WebDriverRunner.getWebDriver().switchTo().defaultContent();
            Thread.sleep(Interval);
        } catch (Exception e) {
            Log.error("There is an exception: " + e.toString());
        }
    }

    public static void RefreshPage(int Interval) {
        try {
            Thread.sleep(6000);
            WebDriverRunner.getWebDriver().navigate().refresh();
            Thread.sleep(Interval);
        } catch (Exception e) {
            Log.error("There is an exception: " + e.toString());
        }
    }

    /**
     * <h1>Close Browser <h1/>
     * <p>Purpose:This method is used for close open browser after test executions</p>
     *
     * @throws Exception
     */
    public static void closeBrowser() {
        try {
            if (WebDriverRunner.getWebDriver() != null) {
                WebDriverRunner.getWebDriver().quit();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void assertText(By Element, String ExpectedText) {
        String actual = $(Element).waitUntil(appear, DEFAULT_WAIT).getText().trim();
        String message = "|Expected Text: " + ExpectedText + "| |Actual Text: " + actual + "|";
        String html = "<span style='color:blue;'>" + message + " </span>";
        logTestStep(html);
        Assert.assertEquals(actual.toUpperCase(), ExpectedText.toUpperCase().trim());
    }

    public static void assertText(String actualText, String ExpectedText) {
        String message = "|Expected Text: " + ExpectedText + "| |Actual Text: " + actualText + "|";
        String html = "<span style='color:blue;'>" + message + " </span>";
        logTestStep(html);
        Assert.assertEquals(actualText.toUpperCase(), ExpectedText.toUpperCase().trim());
    }




    public static boolean checkExistenceOfElement(By Element) {
        boolean elementStatus = false;
        try {
            WaitTool.waitForElementPresentAndDisplay(Element);
            elementStatus = WebDriverRunner.getWebDriver().findElements(Element).size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementStatus;
    }

    /**
     * <h1> Get Text<h1/>
     * <p>Purpose: If null is returned then the comparison fails and execution of fails </p>
     *
     * @param Element,timeOutInSeconds
     * @throws Exception
     */

    public static String getElementText(By Element, int timeOutInSeconds) {
        return $(Element).waitUntil(appear, DEFAULT_WAIT).getText();
    }

    /**
     * <h1>Select Duedate<h1/>
     * <p>Purpose: This method is used for select due date </p>
     *
     * @param element,Interval
     * @throws Exception
     */

    /**
     * <h1>ProjectDirectory<h1/>
     * <p>Purpose: This method is used for get project directory to get the file to upload document in document library </p>
     *
     * @throws Exception
     */

    public static String getProjectDirectory() {
        return System.getProperty("user.dir");
    }

    public static String getFileToUpload(String fileType) {
        String FS = File.separator;
        String filePath = getProjectDirectory() + FS + "src" + FS + "test" + FS + "resources" + FS + "DocumentTypes";

        switch (fileType) {
            case ".txt":
                filePath = filePath + FS + "textDoc.txt";
                break;
            case ".png":
                filePath = filePath + FS + "test.png";
                break;
            default:
                filePath = filePath + FS + "textDoc.txt";
                break;
        }
        return filePath;
    }

    public static void waitForPageLoadToComplete() throws Exception {
        WaitTool.waitForPageLoadToComplete();
    }



    public static void RefreshPage() throws Exception {
        WebDriverRunner.getWebDriver().navigate().refresh();
        WaitTool.waitForPageLoadToComplete();
    }

    /**
     * <h1>Click Element Using JS<h1/>
     * <p>Purpose: This method is used for click on any element using java scripts  </p>
     *
     * @throws Exception
     */

    public static void clickUsingJS(WebElement elm, String detail) throws Exception {
        try {
            Log.info("Click:" + detail);
            executeJavaScript("arguments[0].click();", elm);
        } catch (Exception e) {
            Log.error("Error in ClickUsingJs ");
            Log.error("Exception: " + e.getMessage());
            throw e;
        }
    }

    public static void setFocusUsingJS(WebElement elm) throws Exception {
        executeJavaScript("arguments[0].focus();", elm);
    }

    /**
     * Load all the  Properties File
     *
     * @param propsFilePath PropsFile which
     * @return Properties
     * return the properties loaded from the file .
     * @throws IOException Any IOException thrown , you will need to catch it.
     */
    private static Properties loadProperties(String propsFilePath) throws IOException {
        Properties props = null;
        try (FileInputStream fis = new FileInputStream(propsFilePath)) {
            props = new Properties();
            props.load(fis);
            fis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return props;
    }//End of loadProperties


    /**
     * <h1>Get Data From Property File<h1/>
     * <p>Purpose: This method is used to get form name from property file  </p>
     *
     * @param key
     * @throws Exception
     */
    public static String GetUserData(String key) {
        String value = "";
        String filePath = "src/test/resources/users.properties";
        try {
            value = (String) loadProperties(filePath).get(key);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return value;
    }

    public static String GetTestData(String key) {
        String value = "";
        String filePath = "src/test/resources/TestData.properties";
        try {
            value = (String) loadProperties(filePath).get(key);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return value;
    }

    public static void updateProperties(String filePath, Properties prop) {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            prop.store(fos, "Save data");
        } catch (Exception ex) {
            Log.error("Problem in data Saving ro property file> " + filePath);
            ex.printStackTrace();
        }
    }//End function


    public static String CaptureScreenForReport(String ImagesPath) {
        TakesScreenshot oScn = (TakesScreenshot) WebDriverRunner.getWebDriver();
        File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
        File oDest = new File(ImagesPath + ".jpg");
        try {
            FileUtils.copyFile(oScnShot, oDest);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //Create relative path
        return oDest.getName();
    }

    public static String CaptureScreenForReport_Base64() {
        TakesScreenshot oScn = (TakesScreenshot) WebDriverRunner.getWebDriver();
        return oScn.getScreenshotAs(OutputType.BASE64);
    }

    public static String GetTimeStamp() {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HHmmss").format(new Date());
        return timeStamp;
    }

    public static void executeStep(boolean result, String step) throws Exception {
        if (result) {
            Log.info("Execution of: " + step + "-PASS");
        } else {
            throw new Exception("Execution of: " + step + "-FAILED");
        }

    }

    public static void verifyStep(boolean result, String step) throws Exception {
        if (result) {
            Log.info("Verification of: " + step + "-PASS");
        } else {
            throw new Exception("Verification of: " + step + "-FAILED");
        }

    }



    public static void url() {
        WebDriverRunner.getWebDriver().get(Urls.baseUrl);
    }


    public static void switchToActiveFrame() throws InterruptedException {
        switchTo().defaultContent();
        Log.info("Switching to active frame");
        WebElement element = $(".active.oneContent").$("iframe").waitUntil(appear, DEFAULT_WAIT);
        sleep(2000);
        WebDriverRunner.getWebDriver().switchTo().frame(element);
        Log.info("Switched to active frame successfull");
    }





    public static String GetCurrentUrl() {
        if (WebDriverRunner.getWebDriver() != null) {
            return WebDriverRunner.getWebDriver().getCurrentUrl();
        } else
            return "";
    }

    public static void clickUsingJS(By by) throws Exception {
        try {
            executeJavaScript("arguments[0].click();",$(by).waitUntil(appear,DEFAULT_WAIT).getWrappedElement());
        } catch (Exception e) {
            Log.error("Error in ClickUsingJs ");
            Log.error("Exception: " + e.getMessage());
            throw e;
        }
    }

    /**
     * <h1>Select Due Date<h1/>
     *
     *
     *
     * @param element,element2,element3
     * @throws Exception
     */

    public static void selectDate(By element, By element2, By element3) throws Exception {

        Actions action = new Actions(WebDriverRunner.getWebDriver());
        Thread.sleep(1000);
        WaitTool.isElementPresentAndDisplay(element);
        action.moveToElement(WebDriverRunner.getWebDriver().findElement(element))
                .click(WebDriverRunner.getWebDriver().findElement(element2)).build().perform();
        Thread.sleep(1000);
        Common.clickElement(element3, "SelectData");

    }

    public static void moveToElement (By element ) throws Exception {
        Actions action = new Actions(WebDriverRunner.getWebDriver());
        Thread.sleep(1000);
        WaitTool.isElementPresentAndDisplay(element);
        action.moveToElement(WebDriverRunner.getWebDriver().findElement(element)).build().perform();
        Thread.sleep(1000);



    }

    /**
     * <h1>Click Search Items<h1/>
     * <p>Purpose:This method is used to click on search list(Ex Requests,Workflows etc </p>
     *
     * @param item
     * @throws Exception
     */







    /**
     * <h1>Click Element Using pixel points<h1/>
     * <p>Purpose: This method is used To click element using pixel points  </p>
     *
     * @throws Exception
     */

    public void clickElementPoint(By by) throws Exception {
        WaitTool.waitForElementToBeClickable(by);
        try {
            JavascriptExecutor jse = (JavascriptExecutor) WebDriverRunner.getWebDriver();
            jse.executeScript("window.scrollTo(" + WebDriverRunner.getWebDriver().findElement(by).getLocation().x + ",0)");
            Thread.sleep(1000);
            WebDriverRunner.getWebDriver().findElement(by).click();
        } catch (Exception e) {
            Log.error("Exception thrown: " + e.getMessage());
        }
    }


    /**
     * <h1>Set Focus on Web Element<h1/>
     * <p>Purpose:This method is used to set a focus on web element</p>
     */
    public void setFocus(By by) {
        executeJavaScript("arguments[0].focus();", $(by).getWrappedElement());
    }

    /**
     * <h1>Set Focus on Web Element<h1/>
     * <p>Purpose:This method is used to set a focus on web element</p>
     */
    public void setFocus(WebElement elm) {
        executeJavaScript("arguments[0].focus();", elm);
    }

    public static String GetOSName() {
        return System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
    }

    public static boolean isWindows() {
        return (GetOSName().indexOf("win") >= 0);
    }

    public static boolean isMac() {
        return (GetOSName().indexOf("mac") >= 0);
    }

    public static boolean isUnix() {
        return (GetOSName().indexOf("nix") >= 0 || GetOSName().indexOf("nux") >= 0 || GetOSName().indexOf("aix") > 0);
    }

    public static boolean isLinux() {
        return GetOSName().indexOf("nux") >= 0;
    }



    public static void KillChromeProcessForWindows() {
        if (isWindows()) {
            try {
                for (Integer pid : GetChromeProcessesForWindow()) {
                    Log.info("Kill Chrome Process Id#" +pid);
                    Runtime.getRuntime().exec("taskkill /F /PID " + pid);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }//End method



    public static Set<Integer> GetChromeProcessesForWindow() {
        Set<Integer> winChromeProcess = new HashSet<>();
        String out;
        Process p = null;
        if (Common.isWindows()) {
            try {
                p = Runtime.getRuntime().exec("tasklist /FI \"IMAGENAME eq chromedriver.exe*\"");
                BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
                while ((out = input.readLine()) != null) {
                    String[] items = StringUtils.split(out, " ");
                    if (items.length > 1 && StringUtils.isNumeric(items[1])) {
                        winChromeProcess.add(NumberUtils.toInt(items[1]));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }//End if
        return winChromeProcess;
    }

    public static String GetProjectNameFromMavenPOM(){
        String mavenProjectName="";
        try {
            MavenXpp3Reader reader = new MavenXpp3Reader();
            Model model = reader.read(new FileReader("pom.xml"));
            mavenProjectName=model.getGroupId();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return  mavenProjectName;
    }

    /**
     * <h1>Scroll to Element</h1>
     * <p>
     *
     * </p>
     * @param element
     */
    public static void scrollandClick(By element) throws Exception {
        WaitTool.waitForElementToBeClickable(element);
        try {
            JavascriptExecutor jse = (JavascriptExecutor) WebDriverRunner.getWebDriver();
            jse.executeScript("window.scrollTo(" + WebDriverRunner.getWebDriver().findElement(element).getLocation().x + ",0)");
            Thread.sleep(1000);
            WebDriverRunner.getWebDriver().findElement(element).click();
        } catch (Exception e) {
            Log.error("Exception thrown: " + e.getMessage());
        }

    }
    /**
     * <h1>Get Text By Label</h1>
     * <p>
     * This method will return Text based on Label internally it will find first form element that is under Related tab and then return a text
     * </p>
     */

      public static String getDocumentTypeToUpload(String fileType) {
        String FS = File.separator;
        String filePath = getProjectDirectory() + FS + "src" + FS + "test" + FS + "resources" + FS + "DocumentTypes";

        switch (fileType) {
            case ".txt":
                filePath = filePath + FS + "textDoc.txt";
                break;
            case ".jpg":
                filePath = filePath + FS + "jpegImage.jpeg";
                break;
            case ".jpeg":
                filePath = filePath + FS + "jpegImage.jpeg";
                break;
            case ".xml":
                filePath = filePath + FS + "xmlFile.xml";
                break;
            default:
                filePath = filePath + FS + "textDoc.txt";
                break;
        }
        return filePath;

    }

    public static void saveFieldData(String fieldTitle, String fieldData, String fieldComments) {

        String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "TestData.properties";
        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            Properties prop = new Properties();
            prop.load(inputStream);
            inputStream.close();

            FileOutputStream fos = new FileOutputStream(filePath);
            prop.setProperty(fieldTitle, fieldData);
            prop.store(fos, fieldComments);
            fos.close();
            Log.info("Form saved successfully: " + getFieldData(fieldTitle));

        } catch (Exception ex) {
            Log.error("Problem in Form save");
            ex.printStackTrace();
        }

    }

    public static String getFieldData(String fieldTitle){
            Properties prop = new Properties();
            String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "TestData.properties";
            try (FileInputStream fis = new FileInputStream(filePath)) {
                prop.load(fis);
                return prop.getProperty(fieldTitle);
            } catch (Exception ex) {
                ex.printStackTrace();
                return "NA";
            }

      }

    public static void scrollTo(By element) throws Exception {
         sleep(2000);
        try {
            JavascriptExecutor jse = (JavascriptExecutor) WebDriverRunner.getWebDriver();
            jse.executeScript("window.scrollTo(" + WebDriverRunner.getWebDriver().findElement(element).getLocation().x + ",0)");
            Thread.sleep(5000);
        } catch (Exception e) {
            Log.error("Exception thrown: " + e.getMessage());
        }

    }

    public static void Clearfield(By Element,  String Detail) throws Exception {
        try {
            Log.info("Input " + Detail);
            WebElement inputElement=$(Element)
                    .waitUntil(appear, DEFAULT_WAIT)
                    .waitUntil(enabled, DEFAULT_WAIT).getWrappedElement();

            inputElement.clear();
          //  inputElement.sendKeys(Keys.BACK_SPACE);
            inputElement.sendKeys("",Keys.TAB);

            sleep(3000);
        } catch (Exception e) {
            Log.error("Error in setting a text value: " + e.toString());
            throw e;
        }
    }

    public static void doubleClick (By element ) throws Exception {
        Actions action = new Actions(WebDriverRunner.getWebDriver());
        Thread.sleep(1000);
        WaitTool.isElementPresentAndDisplay(element);
        action.click(WebDriverRunner.getWebDriver().findElement(element)).build().perform();
        Thread.sleep(1000);



    }

    public static boolean isClickable(By by)
    {
        try
        {
            WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify implicitlyWait()
            WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), (Common.DEFAULT_WAIT / 1000));
            wait.until(ExpectedConditions.elementToBeClickable(by));
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

     public static void clickCheckbox(By by ,String detail){

         SelenideElement chkBoxelm = $(by);
         if (!$(by).isSelected()) {
             Log.info("Click on Check Box");
             chkBoxelm.click();
         }

     }

     public static String getTodayDate(){

         /*DateFormat dateFormat = new SimpleDateFormat("MMddyyyy ");
         Date date = new Date();
         System.out.println(dateFormat.format(date));*/

         String pattern = "MMddyyyy";
         DateFormat df = new SimpleDateFormat(pattern);
         Date today = Calendar.getInstance().getTime();
         String todayAsString = df.format(today);

         return todayAsString;
     }


     public static void getRandomNumber (int bound){

         Random rand = new Random();

         // Generate random integers in range 0 to 999
         int rand_int1 = rand.nextInt(bound);
         System.out.println("Random Integers: "+rand_int1);
     }

    public static void SendKeys(By Element, String KeysToSend, String Detail) throws Exception {
        try {
            Log.info("Input " + Detail);
            WebElement inputElement=$(Element)
                    .waitUntil(appear, DEFAULT_WAIT)
                    .waitUntil(enabled, DEFAULT_WAIT).getWrappedElement();
            sleep(1000);
            inputElement.sendKeys(KeysToSend);
        } catch (Exception e) {
            Log.error("Error in setting a text value: " + e.toString());
            throw e;
        }
    }
    public static Boolean getAddedData(SelenideElement ele, String recordName) {
        List<String> listData = ele.$$("tr:nth-child(1)>td").texts();
        boolean result = false;
        for (String strDocName : listData) {
            System.out.println(strDocName);
            if (strDocName.equalsIgnoreCase(recordName)) {
                result = true;
                break;
            } else continue;
        }
        return result;
    }

    public static void searchAddedRecord(String recordname) throws InterruptedException {

        WebElement txtSrc = $(HelpCenterRepo.searchBox).waitUntil(appear, DEFAULT_WAIT).getWrappedElement();
        txtSrc.click();
        Log.info("Search Box Clicked");
        txtSrc.sendKeys(recordname);
        Log.info("Search With Record Name");
        sleep(500);
        txtSrc.sendKeys(Keys.ENTER);
        sleep(500);


    }
    public static void verifyAddedDataInTable(SelenideElement table ,String recordName) throws InterruptedException {
        logTestStep("Search  Added record");
        searchAddedRecord(recordName);
        logTestStep("Record Found");
        sleep(2000);

        boolean resultPresent = getAddedData(table, recordName);

        Assert.assertEquals(resultPresent,true, "No record Added");


    }

    public static void verifyAddedDataInTablewithOutSearch(SelenideElement table ,String recordName) throws InterruptedException {


          boolean resultPresent = getAddedData(table, recordName);

        Assert.assertEquals(resultPresent,true, "No record Added");


    }
}