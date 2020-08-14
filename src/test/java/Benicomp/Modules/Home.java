package Benicomp.Modules;

import Benicomp.Locators.HomeRepo;
import Benicomp.TestData.GlobalTestData;
import Benicomp.Utils.Common;
import Benicomp.Utils.Log;
import Benicomp.Utils.WaitTool;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static Benicomp.Utils.Common.*;
import static Benicomp.Utils.Common.assertText;
import static Benicomp.Utils.TestBase.logTestStepPass;
import static Benicomp.Utils.TestBase.logTestStepPassOrFail;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class Home {

    public void navigateAllLeftMenuLinks() throws Exception {

        clickElement(HomeRepo.linkUserManager, "Click User Manager");
        WaitTool.waitForPageLoadToComplete();


        WebElement elm = $$x("//h1[contains(@class,'page-heading')]").filter(visible).last();

        String tvalue1 = elm.getText();
        assertText(tvalue1, "User Manager");
        logTestStepPass("User can see User Manager page ");

        clickElement(HomeRepo.linkHealthData, "Click Heath Data");

        clickElement(HomeRepo.linkManageHealthData, "Click Manage Health");
        String tvalue2 = elm.getText();
        assertText(tvalue2, "Health Data");
        logTestStepPass("User can see Health page ");

        clickElement(HomeRepo.linkmanageClaims, "Click Manage Claim");
        String tvalue3 = elm.getText();
        assertText(tvalue3, "Claims");
        logTestStepPass("User can see Claims page ");

        clickElement(HomeRepo.linkClaims, "Click Claims");
        WaitTool.waitForPageLoadToComplete();
        String tvalue5 = elm.getText();
        assertText(tvalue5, "Claims Manager");
        logTestStepPass("User can see Claims Manager page ");


        clickElement(HomeRepo.linkImportantDocuments, "Click Important Documents");
        String tvalue6 = elm.getText();
        assertText(tvalue6, "Important Documents");
        logTestStepPass("User can see Important Documents page ");

        clickElement(HomeRepo.linkforms, "Click Forms");
        WaitTool.waitForPageLoadToComplete();


        clickElement(HomeRepo.linkContactforms, "Click Contact Forms");
        String tvalue8 = elm.getText();
        assertText(tvalue8, "Contact Form Manager");
        logTestStepPass("User can see Contact Form Manager page ");

        clickElement(HomeRepo.linkAppealforms, "Click Appeal Forms");
        String tvalue9 = elm.getText();
        assertText(tvalue9, " Appeal Form Manager");
        logTestStepPass("User can see Appeal Form Manager Page ");

        clickElement(HomeRepo.linkChangeforms, "Click Change Forms");
        String tvalue10 = elm.getText();
        assertText(tvalue10, "Change Form");
        logTestStepPass("User can see Change Form Page");

        clickElement(HomeRepo.linkSurveysforms, "Click Survey Forms");
        String tvalue11 = elm.getText();
        assertText(tvalue11, "Surveys");
        logTestStepPass("User can see Surveys Page");

        clickElement(HomeRepo.linkaccounting, "Click Accounting");
        WaitTool.waitForPageLoadToComplete();


        clickElement(HomeRepo.linkinvoiceManager, "Click Invoice Manager");
        String tvalue13 = elm.getText();
        assertText(tvalue13, "Invoice Manager");
        logTestStepPass("User can see Invoice Manager Page");

        clickElement(HomeRepo.linkPayment, "Click Payment");
        String tvalue14 = elm.getText();
        assertText(tvalue14, "Manager");
        logTestStepPass("User can see Payment Manager Page");

        clickElement(HomeRepo.linkSystemMainntaince, "System Maintenance");
        WaitTool.waitForPageLoadToComplete();


     /*  clickElement(HomeRepo.linkFaq, "Click FAQ");
       String tvalue16=elm.getText();
       assertText(tvalue16,"User Manager");*/

        clickElement(HomeRepo.linkLoginLog, "Click Login Log");
        String tvalue17 = elm.getText();
        assertText(tvalue17, " Login Manager");
        logTestStepPass("User can see Login Manager Page");


        clickElement(HomeRepo.linkUploadManager, "Click Upload Manager");
        String tvalue18 = elm.getText();
        assertText(tvalue18, "Upload Manager");
        logTestStepPass("User can see Upload Manager Page");

        clickElement(HomeRepo.linkHelpCenter, "Click HelpCenter");
        WaitTool.waitForPageLoadToComplete();

        clickElement(HomeRepo.linkKnowldgeBase, "Click Knowledge Base");
        String tvalue20 = elm.getText();
        assertText(tvalue20, "Knowledge Base");
        logTestStepPass("User can see Knowledge Base Page");

        clickElement(HomeRepo.linkTickets, "Click Ticket");
        String tvalue21 = elm.getText();
        assertText(tvalue21, "Tickets");
        logTestStepPass("User can see Tickets Page");

        clickElement(HomeRepo.getLinkFaq2, "Click FAQ");
        String tvalue22 = elm.getText();
        assertText(tvalue22, "Frequently Asked Questions");
        logTestStepPass("User can see Frequently Asked Questions Page");


    }


}