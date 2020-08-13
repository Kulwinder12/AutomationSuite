package Benicomp.Tests.Client;

import Benicomp.Modules.Client;
import Benicomp.Modules.LoginOut;
import Benicomp.TestData.GlobalTestData;
import Benicomp.Utils.TestBase;
import Benicomp.Utils.WaitTool;
import org.testng.annotations.Test;

public class BCP010_Test extends TestBase {

    LoginOut objLoginOut = new LoginOut();

    WaitTool wt = new WaitTool();

    @Test(description = "To verify that there can't be more that one primary contact for a client.", groups = {"Client"})
    public void BCP010() throws Exception {

        GlobalTestData.Client_Users.GetData(getClass().getSimpleName());
        GlobalTestData.Contact_Users.GetData(getClass().getSimpleName());
        logTestStep("Log in to application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);

        wt.implicitwait();
        Client objClient = new Client();
        objClient.verifyMultiplePrimaryContacts();

    }
}