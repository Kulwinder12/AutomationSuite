package Benicomp.Tests.Client;

import Benicomp.Modules.Client;
import Benicomp.Modules.LoginOut;

import Benicomp.TestData.GlobalTestData;
import Benicomp.Utils.TestBase;
import Benicomp.Utils.WaitTool;
import org.testng.annotations.Test;

public class BCP002_Test extends TestBase {

    LoginOut objLoginOut = new LoginOut();

    WaitTool wt = new WaitTool();


    @Test(description = "To verify that User is added Successfully", groups = {"Client"})
    public void BCP002() throws Exception {

        GlobalTestData.Client_Users.GetData(getClass().getSimpleName());
        GlobalTestData.Contact_Users.GetData("ContactData",getClass().getSimpleName());

        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);

        wt.implicitwait();
        Client objClient = new Client();
        objClient.addUser();
        logTestStep("Client Added Successfully");
    }


}
