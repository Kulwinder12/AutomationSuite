package Benicomp.Tests.HelpCenter;

import Benicomp.Locators.HomeRepo;
import Benicomp.Modules.HelpCenter;
import Benicomp.Modules.Home;
import Benicomp.Modules.LoginOut;
import Benicomp.TestData.GlobalTestData;
import Benicomp.Utils.Common;
import Benicomp.Utils.TestBase;
import Benicomp.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Benicomp.Utils.Common.clickElement;
import static com.codeborne.selenide.Selenide.$$;

public class BCP005_Test extends TestBase {

    LoginOut objLoginOut = new LoginOut();
    WaitTool waitTool = new WaitTool();

    HelpCenter helpCenter = new HelpCenter();


    @Test(description = "To verify that User is able to Edit an Article", groups = {"HelpCenter"})
    public void BCP005() throws Exception {

        GlobalTestData.Article_TestData.GetData(getClass().getSimpleName());

        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        waitTool.implicitwait();

        clickElement(HomeRepo.linkHelpCenter, "Click Help Center");
        WaitTool.waitForPageLoadToComplete();

        clickElement(HomeRepo.linkKnowldgeBase, "Click Knowledge Base");
        WaitTool.waitForPageLoadToComplete();

        Thread.sleep(5000);

        SelenideElement table = $$("div.table>table>tbody").filter(Condition.visible).first();
        String recordName = Common.getFieldData("ArticleTitle");
        logTestStep("Search the Added Article");
        helpCenter.searchAddedRecord(recordName);
        logTestStep("Record Found");
        helpCenter.editArticle();

        Thread.sleep(5000);

        String recordName1 = Common.getFieldData("ArticleTitle");
        logTestStep("Search the Added Article");
        helpCenter.searchAddedRecord(recordName1);
        logTestStep("Record Found");
        boolean resultPresent = HelpCenter.getAddedData(table, recordName1);

        Assert.assertEquals(resultPresent,true, "added new record");
        logTestStepPass("Article Updated and Verified");
    }
}