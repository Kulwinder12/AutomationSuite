package Benicomp.Locators;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$x;

public class ClientRepo {

    //Client Screen
    public static By btnAdduser = By.xpath("//button[@title='Add User']");
    public static By linkClient = By.xpath("//li[@class='dropdown-item'][text()='Client']");
    public static By txtClientName = By.xpath("//input[contains(@formcontrolname, 'ClientName')]");
    public static By txtGroupName = By.xpath("//input[contains(@formcontrolname, 'GroupNumber')]");
    public static By txtClientUrl = By.xpath("//input[contains(@formcontrolname, 'ClientUrl')]");
    public static By txtAddress1 = By.xpath("//input[contains(@formcontrolname, 'StreetAddress')]");
    public static By txtAddress2 = By.xpath("//input[contains(@formcontrolname, 'AddressLine2')]");
    public static By txtCity = By.xpath("//input[contains(@formcontrolname, 'City')]");
    public static By txtState = By.xpath("//input[contains(@formcontrolname, 'name')]");
    public static By txtZipCode = By.xpath("//input[contains(@formcontrolname, 'PostalCode')]");
    public static By selectCountry = By.xpath("//button[@class ='btn btn-dropdown form-control dropdown-toggle']");
    public static By txtFedredId = By.xpath("//input[contains(@formcontrolname, 'FederalId')]");
    public static By btnSave = By.xpath("//button[@type ='submit']");
    public static By btnCancel = By.xpath("//button[text()=' Cancel ']");
    public static By btnEdit = By.xpath("//button[@title='Edit']");
    public static By btnBack = By.xpath("//button[@title='Back']");
    public static By chkIncenticare = By.xpath("//span[contains(text(),'IncentiCare')]");
    public static By chkBenicompSelect = By.xpath("//span[contains(.,'BeniComp Select')]");
    public static By chkQSHERA = By.xpath("//span[contains(.,'QSEHRA')]");
    public static By linkProfile = By.xpath("//a[contains(@class,'nav-link')][contains(text(),'Profile')]");
    public static By linkContact = By.xpath("//a[contains(@class,'nav-link')][contains(text(),'Contacts')]");
    public static By linkDivison = By.xpath("//a[contains(@class,'nav-link')][contains(text(),'Divisions')]");
    public static By linkNotes = By.xpath("//a[contains(@class,'nav-link')][contains(text(),'Notes')]");
    public static By btnSendCredentials = By.xpath("//button[@class='btn green-btn'][text()=' Send Credentials ']");
    public static By linkIncenticare = By.xpath("//a[contains(@class,'nav-link')][contains(text(),'IncentiCare')]");
    public static By editSave  = By.xpath("//div[contains(@id,'profile')]//ancestor::div[1]//button[@type='submit'][contains(text(),'Save')]");


    //Contact Screen

   // public static By btnAddcontact = By.xpath("//button[@title='Add Contact']");
   public static By btnAddcontact = By.xpath("//button[contains(text(),'Add Contact ')]");

    public static By txtFirstName = By.xpath("//h4[text()='Create Contact']//ancestor::div[2]//child::input[contains(@formcontrolname, 'FirstName')]");
    public static By txtLastName = By.xpath("//h4[text()='Create Contact']//ancestor::div[2]//child::input[contains(@formcontrolname, 'LastName')]");
    public static By txtcntctPosition = By.xpath("//h4[text()='Create Contact']//ancestor::div[2]//child::input[contains(@formcontrolname, 'Position')]");
    public static By txtCntctEmail = By.xpath("//h4[text()='Create Contact']//ancestor::div[2]//child::input[contains(@formcontrolname, 'Email')]");
    public static By drpdwndivison = By.xpath("//h4[text()='Create Contact']//ancestor::div[2]//child::form//label[.=' Division ']");
    public static By chkPrimaryContact = By.xpath("//span[contains(.,'Primary Contact')]");
    public static By chkAccountingContact = By.xpath("//span[contains(.,'Accounting Contact')]");
    public static By chkMarketingContact = By.xpath("//span[contains(.,'Marketing Contact')]");
    public static By chkAdministrator = By.xpath("//span[contains(.,'Administrator')]");
    public static By btnContactCancel = By.xpath("//h4[text()='Create Contact']//ancestor::div[2]//child::button[contains(text(),' Cancel ')]");
    public static By btnContactsave = By.xpath("//h4[text()='Create Contact']//ancestor::div[2]//child::button[contains(text(),'Save')]");
    public static By btnEditCancel = By.xpath("//h4[text()='Create Contact']//ancestor::div[2]//child::button[contains(text(),' Cancel ')]");
    public static By btnEditSave = By.xpath("//h4[text()='Edit Contact']//ancestor::div[2]//child::button[contains(text(),'Save')]");

    //Divison Screen
    public static By btnADivision = By.xpath("//button[contains(text(),'Add Division')]");
    public static By txtDivisonName = By.xpath("//h4[text()='Create Division']//ancestor::div[2]//child::input[contains(@formcontrolname, 'ClientName')]");
    public static By txtNumberofEmp = By.xpath("//h4[text()='Create Division']//ancestor::div[2]//child::input[contains(@formcontrolname, 'NoOfEmployee')]");
    public static By btnDivisionCancel = By.xpath("//h4[text()='Create Division']//ancestor::div[2]//child::button[text()=' Cancel ']");
    public static By btnDivisionSave = By.xpath("//h4[text()='Create Division']//ancestor::div[2]//child::button[text()=' Save ']");


    //IncentiCare Screen
    public static By txtPolicyIssueState = By.xpath("//label[text()='Policy Issue State ']//ancestor::div[1]//child::input[contains(@formcontrolname, 'name')]");
    public static By effectiveDate = By.xpath("//input[contains(@formcontrolname, 'IncenticarebenefitYear')]");
    public static By radioselectEmp1 = By.xpath("//ul[contains(@class,'enrollment-level-options')]//ancestor::div[2]//child::div[1]//span[contains(text(),'Employee')]");
    public static By radioselectEmp2 = By.xpath("//ul[contains(@class,'enrollment-level-options')]//ancestor::div[2]//child::div[2]//span[contains(text(),'Employee')]");
    public static By radioselectEmp3 = By.xpath("//ul[contains(@class,'enrollment-level-options')]//ancestor::div[2]//child::div[3]//span[contains(text(),'Employee')]");
    public static By radioselectEmp4 = By.xpath("//ul[contains(@class,'enrollment-level-options')]//ancestor::div[2]//child::div[4]//span[contains(text(),'Employee')]");
    public static By btnAddBenifitYear = By.xpath("//div[@class='row row-mmd-5 mt-10']//button[@class='btn green-btn'][contains(text(),'Add Benefit Year')][contains(text(),'Benefit Year')]");
    public static By selectPlan1 = By.xpath("//span[contains(text(),'Plan 1')]");
    public static By spouseYes = By.xpath("//span[contains(text(),'Yes')]");
    public static By txtSinglePlan = By.xpath("//body[@id='page-top']//div[@id='benicompAdvanage']//div//div//div[2]//div[1]//div[1]//input[1]");
    public static By targetOptions = By.xpath("//button[text()=' NIH Level ']");
    public static By selectStandardOption = By.xpath("//div[@class='dropdown field-dropdown show']//li[2]");
    public static By txtFamilyPlan = By.xpath("//body[@id='page-top']//div[@id='benicompAdvanage']//div//div//div[3]//div[1]//div[1]//input[1]");
    public static By chkBloodGlucode = By.xpath("//span[contains(text(),'Blood Glucose')]");
    public static By ldlCholestrol = By.xpath("//span[contains(text(),'LDL Cholesterol')]");
    public static By employeeBSR = By.xpath(" //div[contains(text(),'Blood Sugar Reward')]//ancestor::div[1]//child::label[contains(text(),'Employee')]//ancestor::div[1]//child::input");
    public static By familyBSR = By.xpath(" //div[contains(text(),'Blood Sugar Reward')]//ancestor::div[1]//child::label[contains(text(),'Family')]//ancestor::div[1]//child::input");
    public static By employeeLDL = By.xpath(" //div[contains(text(),'LDL Cholesterol Reward')]//ancestor::div[1]//child::label[contains(text(),'Employee')]//ancestor::div[1]//child::input");
    public static By familyLDL = By.xpath(" //div[contains(text(),'LDL Cholesterol Reward')]//ancestor::div[1]//child::label[contains(text(),'Family')]//ancestor::div[1]//child::input");
    public static By addNewAgent = By.xpath("//button[contains(text(),'Add New Agent')]");
    public static By addCurrentAgent = By.xpath("//div[@class='row row-mmd-5 mt-10']//button[@class='mb-10 mb-md-0 btn green-btn mt-2 mt-lg-0'][contains(text(),'Add Current Agent ')]");
    public static By addAgentName = By.xpath("//h4[text()='Add Agent']//ancestor::div[3]//child::input[@formcontrolname='agentName']");
    public static By selectAgentName = By.xpath("//input[contains(@formcontrolname,'agentName')]//ancestor::div[1]//child::button[1]");
    public static By agentAssociationDate =By.xpath("//h4[text()='Add Agent']//ancestor::div[3]//child::input[@formcontrolname='associationDate']");
    public static By agentsave = By.xpath("//h4[text()='Add Agent']//ancestor::div[3]//child::button[contains(text(),' Save')]");
    public static By incentiveSave = By.xpath("//div[@class='d-flex form-group justify-content-end right-btn-wrap']//button[@class='btn shadow-none green-btn'][contains(text(),'Save')]");
    public static By agentInfoTable = By.xpath("//div[contains(text(),'Agent Information')]");
    public static By contactUs = By.xpath("//a[text()='Contact Us']");

   // Notes Screen
   public static By notesLink = By.xpath("//a[contains(text(),'Notes')]");
   public static By notesTextArea = By.xpath("//textarea[contains(@placeholder,'Type your Notes..')]");
   public static By addNoteButton = By.xpath("//img[@alt='Share Icon']");





    // agent Screen
    public static By linkAddAgent = By.xpath("//li[contains(text(),'Agent')]");
    public static By agentFirstName = By.xpath("//h6[text()='Create Agent']//ancestor::div[3]//child::input[contains(@formcontrolname, 'firstName')]");
    public static By agentLastName = By.xpath("//h6[text()='Create Agent']//ancestor::div[3]//child::input[contains(@formcontrolname, 'lastName')]");
    public static By agentEmail = By.xpath("//h6[text()='Create Agent']//ancestor::div[3]//child::input[contains(@formcontrolname, 'email')]");
    public static By agencyName = By.xpath("//h6[text()='Create Agent']//ancestor::div[3]//child::input[contains(@formcontrolname, 'agencyName')]");
    public static By agentNPN = By.xpath("//h6[text()='Create Agent']//ancestor::div[3]//child::input[contains(@formcontrolname, 'NPNNumber')]");
    public static By btnAgentSave = By.xpath("//h6[text()='Create Agent']//ancestor::div[3]//child::button[contains(text(), 'Save')]");
    public static By btnAgentCancel = By.xpath("//h6[text()='Create Agent']//ancestor::div[3]//child::button[contains(text(), 'Cancel')]");






    //Employee screen
    public static By linkAddEmployee = By.xpath("//li[@class='dropdown-item'][text()='Employee']");






    //Dependent Screen
    public static By linkAddDependent = By.xpath("//li[@class='dropdown-item'][text()='Dependent']");
    public static By linkDependentFirstName = By.xpath("//h6[text()='Create Dependent']//ancestor::div[3]//child::input[contains(@formcontrolname, 'FirstName')]");
    public static By linkDependentLastName = By.xpath("//h6[text()='Create Dependent']//ancestor::div[3]//child::input[contains(@formcontrolname, 'LastName')]");
    public static By dependentDOB = By.xpath("//h6[text()='Create Dependent']//ancestor::div[3]//child::input[contains(@formcontrolname, 'DateOfBirth')]");
    public static By dependedntGenderMale = By.xpath("//span[text()='Male']");
    public static By dependedntGenderFemale = By.xpath("//span[text()='Female']");
    public static By dependentSocialNumber = By.xpath("//h6[text()='Create Dependent']//ancestor::div[3]//child::input[contains(@formcontrolname, 'Ssn')]");
    public static By dependentType = By.xpath("//li[text()=' Spouse ']");
    public static By dependentParticipent = By.xpath("//h6[text()='Create Dependent']//ancestor::div[3]//child::input[contains(@formcontrolname, 'Participant')]");



}