package Benicomp.Modules;

import Benicomp.Locators.ClientRepo;
import Benicomp.Locators.HomeRepo;
import Benicomp.TestData.GlobalTestData;
import Benicomp.Utils.Common;
import Benicomp.Utils.Log;
import Benicomp.Utils.WaitTool;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static Benicomp.Utils.Common.*;
import static Benicomp.Utils.TestBase.*;
import static com.codeborne.selenide.Selenide.*;

public class Client {



    public void addUserWithIncenticare() throws Exception {

        addClientDetails();
        addContactDetails();
        addDivisionDetails();
        addIncenticareDetails();





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


      public static void verifyPrimaryContactForsendCredentials() throws Exception {

          clickElement(HomeRepo.linkUserManager, "Click User Manager");
          clickElement(ClientRepo.btnAdduser, "Button Add User");
          clickElement(ClientRepo.linkClient, "Client Link");
          WaitTool.waitForPageLoadToComplete();
          clearAndSendKeys(ClientRepo.txtClientName, GlobalTestData.Client_Users.getClient_Name(), "Adding Client Name");
          clearAndSendKeys(ClientRepo.txtGroupName, GlobalTestData.Client_Users.getGroup_Number(), "Adding Group Number");
          clickElement(ClientRepo.btnSave, "Save button Clicked");
          WaitTool.waitForPageLoadToComplete();

          // Click on Send Credentials
          clickElement(ClientRepo.btnSendCredentials , "Click on Send Credentials Button");
          SelenideElement element = $x("//div[@class='error-message mb-10']");
          String errorMessage= element.text();
          Assert.assertEquals(errorMessage ,"Please add a primary contact");
         logScreenshot("Screen shot after Clicking Send Credentials Button");
         logTestStepPass("Primary contact is required to send credentials");

      }

       public static void addClientDetails() throws Exception {
        // Add Client Details

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
           Common.saveFieldData("ClientName" ,GlobalTestData.Client_Users.getClient_Name() ,"Saving it for other scripts");
           logTestStepPass("Client Created");



       }

       public static void addContactDetails() throws Exception {

        // Add 1st Contact Details

        scrollTo(ClientRepo.linkContact);
        clickElement(ClientRepo.linkContact, "Contact Link");
        clickElement(ClientRepo.btnAddcontact, "Add Contact Button Clicked");
        clearAndSendKeys(ClientRepo.txtFirstName, GlobalTestData.Contact_Users.getFirst_name(), "Adding First Name");
        clearAndSendKeys(ClientRepo.txtLastName, GlobalTestData.Contact_Users.getLast_name(), "Adding Last Name");
        clearAndSendKeys(ClientRepo.txtcntctPosition, GlobalTestData.Contact_Users.getContact_Position(), "Adding Contact Position");
        clearAndSendKeys(ClientRepo.txtCntctEmail, GlobalTestData.Contact_Users.getContact_Email(), "Adding Contact Email");
        clickElement(ClientRepo.chkPrimaryContact, "Primary Contact");
        clickElement(ClientRepo.btnContactsave, "Save Contact");
        Common.saveFieldData("ContactName" ,GlobalTestData.Contact_Users.getFirst_name() ,"Saving it for other scripts");
        logTestStepPass("Contact Added");




    }

    public static void addDivisionDetails() throws Exception {

        clickElement(ClientRepo.linkDivison ,"Divison Link");
        clickElement(ClientRepo.btnADivision ,"Add Division Button");
        waitForPageLoadToComplete();
        clearAndSendKeys(ClientRepo.txtDivisonName,GlobalTestData.Divison_Users.getDivison_Name(),"Add Divison Name");
        clearAndSendKeys(ClientRepo.txtNumberofEmp ,GlobalTestData.Divison_Users.getNoOfEmployees(),"Add Number Of Employees");
        clickElement(ClientRepo.btnDivisionSave ,"Click Save Button");
        Common.saveFieldData("DivisonName" ,GlobalTestData.Divison_Users.getDivison_Name() ,"Saving it for other scripts");
        logTestStepPass("Divison Added");



    }

    public static void addIncenticareDetails() throws Exception {



      clickElement(ClientRepo.linkProfile ,"Click Profile Link");
        moveToElement(ClientRepo.chkIncenticare);
        clickElement(ClientRepo.chkIncenticare , "Check incenticare");
        waitForPageLoadToComplete();
        clearAndSendKeys(ClientRepo.txtPolicyIssueState,"Arizona" , "Policy Issue State ");
        SendKeys(ClientRepo.txtPolicyIssueState, Keys.chord(Keys.TAB) ,"Selecting the added state");
        SendKeys(ClientRepo.txtPolicyIssueState, Keys.chord(Keys.TAB) ,"Selecting the added state");
        String CurrentDate = Common.getTodayDate();
        clearAndSendKeys(ClientRepo.effectiveDate ,CurrentDate ,"Today date added");
        SendKeys(ClientRepo.effectiveDate, Keys.chord(Keys.TAB ,"Click Tab"),"Press Tab");
        clickElement(ClientRepo.radioselectEmp1 , "Click 1st Employee");
        clickElement(ClientRepo.btnAddBenifitYear , "Add Benifit Year");
        moveToElement(ClientRepo.spouseYes);
        clickElement(ClientRepo.spouseYes ,"Spouse Yes");
        clickElement(ClientRepo.selectPlan1 , "Select Plan 1");
        clearAndSendKeys(ClientRepo.txtSinglePlan ,"20" ,"Add Single Plan Cost");
        clearAndSendKeys(ClientRepo.txtFamilyPlan ,"30" ,"Add Family Plan");
        clickElement(ClientRepo.chkBloodGlucode , "Check blood Glucose");
        clickElement(ClientRepo.ldlCholestrol ,"Check LDL Cholestrol");
        clearAndSendKeys(ClientRepo.employeeBSR ,"20" ,"Add Single Plan Cost");
        clearAndSendKeys(ClientRepo.familyBSR ,"30" ,"Add Family Plan");
        clearAndSendKeys(ClientRepo.employeeLDL ,"20" ,"Add Single Plan Cost");
        clearAndSendKeys(ClientRepo.familyLDL ,"30" ,"Add Family Plan");

        clickElement(ClientRepo.addCurrentAgent ,"Adding Current Agent");
        waitForPageLoadToComplete();
        String AgentName = Common.getFieldData("AgentName");
        clearAndSendKeys(ClientRepo.addAgentName ,AgentName ,"Adding agent name from Property File");
        clickElement(ClientRepo.selectAgentName , "Click on Agent Name");
       // SendKeys(ClientRepo.addAgentName ,Keys.chord(Keys.TAB) ,"Press TAB");
        clearAndSendKeys(ClientRepo.agentAssociationDate ,CurrentDate ,"Add Association Date");

       SendKeys(ClientRepo.agentAssociationDate ,Keys.chord(Keys.TAB) ,"Press TAB");
       // clickElement(ClientRepo.addAgentName ,"Click Date");
        clickElement(ClientRepo.agentsave ,"Save Agent");
        clickElement(ClientRepo.incentiveSave ,"Save Incentive product");
        logTestStepPass("Inceticare Linked with Client");







    }

    public static void add2ContactDetails() throws Exception {

        // Add 2nd Contact Details

        scrollTo(ClientRepo.linkContact);
        clickElement(ClientRepo.linkContact, "Contact Link");
        clickElement(ClientRepo.btnAddcontact, "Add Contact Button Clicked");
        clearAndSendKeys(ClientRepo.txtFirstName, GlobalTestData.Contact2_Users.getFirst_name(), "Adding First Name");
        clearAndSendKeys(ClientRepo.txtLastName, GlobalTestData.Contact2_Users.getLast_name(), "Adding Last Name");
        clearAndSendKeys(ClientRepo.txtcntctPosition, GlobalTestData.Contact2_Users.getContact_Position(), "Adding Contact Position");
        clearAndSendKeys(ClientRepo.txtCntctEmail, GlobalTestData.Contact2_Users.getContact_Email(), "Adding Contact Email");
        clickElement(ClientRepo.chkPrimaryContact, "Primary Contact");
        clickElement(ClientRepo.btnContactsave, "Save Contact");


    }

       public static void verifyMultiplePrimaryContacts() throws Exception {

        //Adding Client Details
        addClientDetails();

        //Adding 1st Primary Contact Details
        addContactDetails();

        //Adding 2nd Primary Contact Details
           add2ContactDetails();


           SelenideElement element = $x("//p[@class='error-message']");
           String errorMessage= element.text();
           Assert.assertEquals(errorMessage ,"There cannot be more than one primary contact at a time");
           logScreenshot("Screen shot after Clicking Save Button");
           logTestStepPass("There cannot be more than one primary contact at a time");

           // Unchecking the Primary Contact Button to Save 2nd contact
            clickElement(ClientRepo.chkPrimaryContact ,"Uncheck Primary Contact");
            clickElement(ClientRepo.btnContactsave ,"Click Save Button");
            Log.info("Uncheck the Primary Checkbox to save the 2nd Contact");

           // Unchecking the Primary CheckBox from 1st contact
           $$x("//button[@class='action']").first().click();
           clickElement(ClientRepo.chkPrimaryContact ,"Uncheck Primary Contact");
           clickElement(ClientRepo.btnEditSave ,"Click Save Button");
           Log.info("Uncheck the Primary Checkbox to save the 1st Contact");

           //Checking the Primary Checkbox to check that it can be checked after unchecking the primary contact button from 1st contact
           $$x("//button[@class='action']").last().click();
           clickElement(ClientRepo.chkPrimaryContact ,"Uncheck Primary Contact");
           clickElement(ClientRepo.btnEditSave ,"Click Save Button");
           Log.info("Check the Primary Checkbox of save 2nd Contact");
           logScreenshot("Check Primary Contact");
           logTestStepPass("Primary Checkbox can be checked  after unchecking the primary contact from 1st contact");
       }

        public static void addAgent() throws Exception {

            clickElement(HomeRepo.linkUserManager, "Click User Manager");
            clickElement(ClientRepo.btnAdduser, "Button Add User");
            clickElement(ClientRepo.linkAddAgent, "Client Link");
            WaitTool.waitForPageLoadToComplete();
            clearAndSendKeys(ClientRepo.agentFirstName, GlobalTestData.Agent_Users.getFirst_name(), "Adding First Name");
            clearAndSendKeys(ClientRepo.agentLastName, GlobalTestData.Agent_Users.getLast_name(), "Adding Last Name");
            clearAndSendKeys(ClientRepo.agencyName, GlobalTestData.Agent_Users.getAgency_Name(), "Adding Agency Name");
            clearAndSendKeys(ClientRepo.agentEmail, GlobalTestData.Agent_Users.getAgent_Email(), "Adding Agent Email");
            clearAndSendKeys(ClientRepo.agentNPN , GlobalTestData.Agent_Users.getNPN() ,"Adding Agency Name");
            //clearAndSendKeys(ClientRepo.agencyName , GlobalTestData.Agent_Users.getAgency_Name() ,"Adding Agency Name");
            Common.saveFieldData("AgentName",GlobalTestData.Agent_Users.getFirst_name() +" "+ GlobalTestData.Agent_Users.getLast_name(),"Saved for scripts");
            Common.saveFieldData("AgentEmail",GlobalTestData.Agent_Users.getAgent_Email(),"Saved for scripts");
            clickElement(ClientRepo.btnAgentSave ,"Save Agent");
             logTestStepPass("Agent Added Successfully");


        }

}