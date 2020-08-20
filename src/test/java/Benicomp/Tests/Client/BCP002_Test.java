package Benicomp.Tests.Client;

import Benicomp.Locators.ClientRepo;
import Benicomp.Modules.Client;
import Benicomp.Modules.HelpCenter;
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
import static Benicomp.Utils.Common.moveToElement;
import static com.codeborne.selenide.Selenide.*;

public class BCP002_Test extends TestBase {

    LoginOut objLoginOut = new LoginOut();
    HelpCenter helpCenter = new HelpCenter();

    WaitTool wt = new WaitTool();


    @Test(description = "To verify that Client is Created with Incenticare Product Successfully", groups = {"Client"})
    public void BCP002() throws Exception {

        GlobalTestData.Client_Users.GetData(getClass().getSimpleName());
        GlobalTestData.Contact_Users.GetData("ContactData",getClass().getSimpleName());
        GlobalTestData.Divison_Users.GetData(getClass().getSimpleName());
        GlobalTestData.Agent_Users.GetData(getClass().getSimpleName());

        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);

        wt.implicitwait();
        Client objClient = new Client();
        objClient.addUserWithIncenticare();
        logTestStep("Client Added Successfully");

        SelenideElement table = $$("div.table-responsive>table>tbody").filter(Condition.visible).first();
        String recordName = GlobalTestData.Client_Users.getClient_Name();
        Common.verifyAddedDataInTable(table ,recordName);
        logTestStepPass("Client with Incenticare Added and Verified");


        //Open the added record to check the other data
        $x("//table[@class='table table-fixed']/tbody/tr/td[2]").click();
        //Open contact Tab
        clickElement(ClientRepo.linkContact, "Open Contact Tab");
        SelenideElement table1 = $$("div.table-responsive>table>tbody").filter(Condition.visible).first();
        String recordName1 = GlobalTestData.Contact_Users.getFirst_name();
        Common.verifyAddedDataInTablewithOutSearch(table1 ,recordName1);
        logTestStepPass("Contact is  Added and Verified");

        //Open Divison tab
        clickElement(ClientRepo.linkDivison, "Open Divison Tab");
        SelenideElement table2 = $$("div.table-responsive>table>tbody").filter(Condition.visible).first();
        String recordName2 = GlobalTestData.Divison_Users.getDivison_Name();
        Common.verifyAddedDataInTablewithOutSearch(table2 ,recordName2);
        logTestStepPass("Divison is  Added and Verified");


        // Incenticare Product Tab
        clickElement(ClientRepo.linkIncenticare, "Open Incenticare Tab");
        SelenideElement table3 = $$("div.table-responsive>table>tbody").filter(Condition.visible).first();
       // String recordName3 = GlobalTestData.Agent_Users.getAgency_Name();
        String recordName3 = Common.getFieldData("AgencyName");
        Common.verifyAddedDataInTablewithOutSearch(table3 ,recordName3);
        logTestStepPass("Incenticare Product is  Added and Verified");

    }


}
