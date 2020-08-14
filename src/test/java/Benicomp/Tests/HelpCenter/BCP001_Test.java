package Benicomp.Tests.HelpCenter;


import Benicomp.Modules.LoginOut;
import Benicomp.Utils.TestBase;
import Benicomp.Utils.WaitTool;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static Benicomp.Utils.Common.DEFAULT_WAIT;
import static Benicomp.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.*;

public class BCP001_Test extends TestBase {

    LoginOut objLoginOut = new LoginOut();
    WaitTool wt = new WaitTool();


    @Test(description = "To verify that User is able to Login and Logout", groups = {"HelpCenter"})
    public void BCP001() throws Exception {

        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);

        wt.implicitwait();

        String svalue=$x("//img[@title='Benicomp']").waitUntil(Condition.visible,DEFAULT_WAIT).getAttribute("title");
        assertText(svalue,"Benicomp");
        logTestStep("HelpCenter page loaded successfully");
        objLoginOut.logout();
        logTestStep("Click log out");
        String value= $x("//p[.='Sign in to manage your account']").getText();
        assertText(value,"Sign in to manage your account");
        logTestStepPass("User logout successfully");
    }
}
