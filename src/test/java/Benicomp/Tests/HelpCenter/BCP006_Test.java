package Benicomp.Tests.HelpCenter;

import Benicomp.Locators.HomeRepo;
import Benicomp.Modules.HelpCenter;
import Benicomp.Modules.LoginOut;
import Benicomp.Utils.Common;
import Benicomp.Utils.TestBase;
import Benicomp.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static Benicomp.Utils.Common.clickElement;
import static com.codeborne.selenide.Selenide.$$;

public class BCP006_Test extends TestBase {

    LoginOut objLoginOut = new LoginOut();
    WaitTool waitTool = new WaitTool();

    HelpCenter helpCenter = new HelpCenter();

    @Test(description = "To verify that User is able to Delete an Article", groups = {"HelpCenter"})
    public void BCP006() throws Exception {


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
        Common.searchAddedRecord(recordName);
        logTestStep("Record Found");
        helpCenter.deleteArticle();

    }
}