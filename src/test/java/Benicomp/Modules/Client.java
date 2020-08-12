package Benicomp.Modules;

import Benicomp.Locators.ClientRepo;
import Benicomp.Locators.HomeRepo;
import Benicomp.TestData.GlobalTestData;
import Benicomp.Utils.WaitTool;
import org.testng.Assert;

import static Benicomp.Utils.Common.*;
import static Benicomp.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.$x;

public class Client {

    public void addUser() throws Exception {


        clickElement(HomeRepo.linkUserManager, "Click User Manager");
        clickElement(ClientRepo.btnAdduser, "Button Add User");
        clickElement(ClientRepo.linkClient, "Client Link");
        WaitTool.waitForPageLoadToComplete();
        clearAndSendKeys(ClientRepo.txtClientName, GlobalTestData.Client_Users.getClient_Name(), "Adding Client Name");
        clearAndSendKeys(ClientRepo.txtGroupName, GlobalTestData.Client_Users.getGroup_Number(), "Adding Group Number");
        clearAndSendKeys(ClientRepo.txtClientUrl, GlobalTestData.Client_Users.getClient_URL(), "Adding Client URL");
        clearAndSendKeys(ClientRepo.txtAddress1, GlobalTestData.Client_Users.getAddress_Line_1(), "Adding Address");
        clearAndSendKeys(ClientRepo.txtCity, GlobalTestData.Client_Users.getCity(), "Adding City");
        clearAndSendKeys(ClientRepo.txtState, GlobalTestData.Client_Users.getState(), "Adding State");
        clearAndSendKeys(ClientRepo.txtZipCode, GlobalTestData.Client_Users.getZIP_Postal_Code(), "Adding Zip Code");
        clearAndSendKeys(ClientRepo.txtFedredId, GlobalTestData.Client_Users.getFederal_ID(), "Adding Fedral Id");
        clickElement(ClientRepo.btnSave, "Save button Click");

        // Add Contact Details

        scrollTo(ClientRepo.linkContact);
        clickElement(ClientRepo.linkContact, "Contact Link");
        clickElement(ClientRepo.btnAddcontact, "Add Contact Button Clicked");
        clearAndSendKeys(ClientRepo.txtFirstName, GlobalTestData.Contact_Users.getFirst_name(), "Adding First Name");
        clearAndSendKeys(ClientRepo.txtLastName, GlobalTestData.Contact_Users.getLast_name(), "Adding Last Name");
        clearAndSendKeys(ClientRepo.txtcntctPosition, GlobalTestData.Contact_Users.getContact_Position(), "Adding Contact Position");
        clickElement(ClientRepo.chkPrimaryContact, "Primary Contact");
        clickElement(ClientRepo.btnContactsave, "Save Contact");

        //Add Division Details

        scrollTo(ClientRepo.linkDivison);

    }


    public static void verifyQSERAwithOtherProducts() throws Exception {

        clickElement(HomeRepo.linkUserManager, "Click User Manager");
        clickElement(ClientRepo.btnAdduser, "Button Add User");
        clickElement(ClientRepo.linkClient, "Client Link");
        WaitTool.waitForPageLoadToComplete();
        clearAndSendKeys(ClientRepo.txtClientName, GlobalTestData.Client_Users.getClient_Name(), "Adding Client Name");
        clearAndSendKeys(ClientRepo.txtGroupName, GlobalTestData.Client_Users.getGroup_Number(), "Adding Group Number");
        clickElement(ClientRepo.btnSave, "Save button Clicked");
        WaitTool.waitForPageLoadToComplete();

        // Validated Incenticare CheckBox
        moveToElement(ClientRepo.chkIncenticare);
        clickCheckbox(ClientRepo.chkIncenticare,"Incenticare Checkbox");
        scrollandClick(ClientRepo.linkProfile);
        moveToElement(ClientRepo.chkIncenticare);
        boolean incentiChecked = $x("//span[@class='custom-checkbox-wrap']/input[contains(@formcontrolname, 'BeniCompAdvantage')]").isSelected();
        Assert.assertEquals(incentiChecked, true, "Incenticare Checkbox is True");

        // Validated BenicompSelect CheckBox
        moveToElement(ClientRepo.chkBenicompSelect);
        clickCheckbox(ClientRepo.chkBenicompSelect ,"BenicompSelect Checkbox");
        scrollandClick(ClientRepo.linkProfile);
        boolean beniSelectChecked = $x("//span[@class='custom-checkbox-wrap']/input[contains(@formcontrolname, 'BeniCompSelect')]").isSelected();
        Assert.assertEquals(beniSelectChecked, true, "BenicompSelect Checkbox is True");
        logTestStepPass("Both Incenticare and Benicomp can be selected at a time");

        // Validated QSHERA CheckBox
        moveToElement(ClientRepo.chkQSHERA);
        clickCheckbox(ClientRepo.chkQSHERA,"QSHERA Checkbox");
        scrollandClick(ClientRepo.linkProfile);
        moveToElement(ClientRepo.chkIncenticare);
        boolean QSHERAChecked = $x("//span[@class='custom-checkbox-wrap']/input[contains(@formcontrolname, 'qsehraSelect')]").isSelected();
        Assert.assertEquals(QSHERAChecked, true, "QSHERA Checkbox is True");

        boolean incentiChecked1 = $x("//span[@class='custom-checkbox-wrap']/input[contains(@formcontrolname, 'BeniCompAdvantage')]").isSelected();
        Assert.assertEquals(incentiChecked1, false, "Incenticare Checkbox is False");


        boolean beniSelectChecked1 = $x("//span[@class='custom-checkbox-wrap']/input[contains(@formcontrolname, 'BeniCompSelect')]").isSelected();
        Assert.assertEquals(beniSelectChecked1, false, "BenicompSelect Checkbox is False");

        logTestStepPass("When QSHERA is selected all the other products are getting deselected");
        logScreenshot("Screenshot");


    }





}