package Benicomp.Tests.HelpCenter;


import Benicomp.Modules.HelpCenter;
import Benicomp.Modules.Home;
import Benicomp.Modules.LoginOut;
import Benicomp.TestData.GlobalTestData;

import Benicomp.Utils.TestBase;
import Benicomp.Utils.WaitTool;

import org.testng.annotations.Test;

public class BCP007_Test extends TestBase {

    LoginOut objLoginOut = new LoginOut();
    WaitTool waitTool = new WaitTool();

    HelpCenter helpCenter = new HelpCenter();


    @Test(description = "To verify the validations on Add Article Page", groups = {"HelpCenter"})
    public void BCP007() throws Exception {

        GlobalTestData.Article_TestData.GetData(getClass().getSimpleName());
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        waitTool.implicitwait();

        helpCenter.validationsCheckonAddArticles();
        logTestStepPass("All the Validations are Verified");

    }
}