package Benicomp.Modules;

import Benicomp.Locators.HelpCenterRepo;
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
import static Benicomp.Utils.TestBase.logTestStepPass;
import static Benicomp.Utils.TestBase.logTestStepPassOrFail;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class HelpCenter {



    public void addArticle() throws Exception {

        clickElement(HomeRepo.linkHelpCenter, "Click Help Center");
        WaitTool.waitForPageLoadToComplete();

        // moveToElement(HomeRepo.linkUserManager);
        clickElement(HomeRepo.linkKnowldgeBase, "Click Knowledge Base");
        WaitTool.waitForPageLoadToComplete();

        clickElement(HelpCenterRepo.btnaddArticle, "Click Add Article Button");
        WaitTool.waitForPageLoadToComplete();

        clearAndSendKeys(HelpCenterRepo.txtTitle, GlobalTestData.Article_TestData.getTitle(), " Add Title");
        clickElement(HelpCenterRepo.drpdownCategory, "Click Category");
        clickElement(HelpCenterRepo.selectHealthCoaching, "Select health Coaching");

        clearAndSendKeys(HelpCenterRepo.txtArticle, GlobalTestData.Article_TestData.getContent(), "Add Content");
        scrollandClick(HelpCenterRepo.btnCreate);
        logTestStepPass("Article " + GlobalTestData.Article_TestData.getTitle()+ " is addded");
        Common.saveFieldData("ArticleTitle",GlobalTestData.Article_TestData.getTitle(),"Article Title for scripts");


    }

    public static List<String> getAllArticles() {
        List<String> articles = new ArrayList<>();
        SelenideElement table = $("div.table");
        for (SelenideElement row : table.$$("tbody tr")) {
            articles.add(row.$("td", 1).text());
        }

        return articles;
    }




    public void editArticle() throws Exception {


        clickElement(HelpCenterRepo.btnEdit ,"Click Edit Button ");
        WaitTool.waitForPageLoadToComplete();


        clearAndSendKeys(HelpCenterRepo.txtTitle, GlobalTestData.Article_TestData.getTitle(), " Add Title");
        clickElement(HelpCenterRepo.drpdownCategory, "Click Category");
        clickElement(HelpCenterRepo.selectHealthCoaching, "Select health Coaching");

        clearAndSendKeys(HelpCenterRepo.TxtArticle1, GlobalTestData.Article_TestData.getContent(), "Add Content");
        scrollandClick(HelpCenterRepo.btnUpdate);


        logTestStepPass("Article" + GlobalTestData.Article_TestData.getTitle()+ " is addded");

    }
    public void deleteArticle() throws Exception {


        clickElement(HelpCenterRepo.btnDelete ,"Click Delete Button ");
        clickElement(HelpCenterRepo.dialogYes , "Click on Yes Button");

        Thread.sleep(5000);
        Common.RefreshPage();

        String AtricleToDelete =  Common.getFieldData("ArticleTitle");
        List<String> list = new ArrayList<>();
        for (SelenideElement elm : $$("tr:nth-child(1)>td").filter(visible)) {
            list.add(elm.text());
            System.out.println(list);


        }
        logTestStepPassOrFail(!list.contains(AtricleToDelete), "Verify Article " + AtricleToDelete + " deleted");

    }
    public void validationsCheckonAddArticles() throws Exception {

        // To check that Category is mandatory field
        clickElement(HomeRepo.linkHelpCenter, "Click Help Center");
        WaitTool.waitForPageLoadToComplete();

        clickElement(HomeRepo.linkKnowldgeBase, "Click Knowledge Base");
        WaitTool.waitForPageLoadToComplete();

        clickElement(HelpCenterRepo.btnaddArticle, "Click Add Article Button");
        WaitTool.waitForPageLoadToComplete();
        clearAndSendKeys(HelpCenterRepo.txtTitle, GlobalTestData.Article_TestData.getTitle(), " Add Title");
        clearAndSendKeys(HelpCenterRepo.txtArticle, GlobalTestData.Article_TestData.getContent(), "Add Content");
        moveToElement(HelpCenterRepo.btnCreate);

        SelenideElement btn= $x("//button[contains(@class,'m-0 btn add-user')][contains(text(),'CREATE')]");
        //boolean createButton = btn.isEnabled();
        boolean createButton = isClickable(HelpCenterRepo.btnCreate);
        Assert.assertEquals(createButton,false, "Create Button is enabled");
        logTestStepPass("Create Button is disbaled when Categoty is not selected");
        sleep(1000);


        // To check that Title Field is Mandatory
        moveToElement(HelpCenterRepo.txtTitle);
        doubleClick(HelpCenterRepo.txtTitle);

        $x("//input[@formcontrolname='title']").sendKeys(Keys.chord(Keys.CONTROL, "a",Keys.DELETE));



        clickElement(HelpCenterRepo.drpdownCategory, "Click Category");
        clickElement(HelpCenterRepo.selectHealthCoaching, "Select health Coaching");
        moveToElement(HelpCenterRepo.btnCreate);
        boolean createButton2 = isClickable(HelpCenterRepo.btnCreate);
        Assert.assertEquals(createButton2,false, "Create Button is enabled");
        logTestStepPass("Create Button is disbaled when Title is not selected");

        // To Check that Article text is mandatory.

        clearAndSendKeys(HelpCenterRepo.txtTitle, GlobalTestData.Article_TestData.getTitle(), " Add Title");
        $x("//div[@class='ql-editor']").sendKeys(Keys.chord(Keys.CONTROL, "a",Keys.DELETE));
        moveToElement(HelpCenterRepo.btnCreate);
        boolean createButton1 = isClickable(HelpCenterRepo.btnCreate);
        Assert.assertEquals(createButton1,false, "Create Button is enabled");
        logTestStepPass("Create Button is disbaled when Article Text is not selected");

    }

    public static void verifyFiltersonAtricle(){




    }

}

