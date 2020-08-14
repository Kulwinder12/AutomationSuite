package Benicomp.Locators;

import org.openqa.selenium.By;

public class HelpCenterRepo {


    // Help Center
    // Add Articles
    public static By btnaddArticle = By.xpath("//button[@title='Create Article']");
    public static By txtTitle = By.xpath("//input[@formcontrolname='title']");
    public static By drpdownCategory = By.xpath("//button[@id='highlighttext1'][@type = 'button']");
    public static By selectHealthCoaching = By.xpath("//li[@class='dropdown-item '][2]");
    public static By txtArticle = By.xpath("//div[@class='ql-editor ql-blank']");
    public static By btnCreate = By.xpath("//button[contains(@class,'m-0 btn add-user')][contains(text(),'CREATE')]");
    public static By searchBox = By.xpath("//input[(@placeholder='Search for...')]");
    public static By btnEdit = By.xpath("//i[contains(@class,'fa fa-pencil')][@title='Edit']");
    public static By btnUpdate = By.xpath("//button[contains(@class,'m-0 btn add-user')][contains(text(),'UPDATE')]");
    public static By TxtArticle1 = By.xpath("//div[@class='ql-editor']");
    public static By btnDelete = By.xpath("//i[contains(@class,'icon-delete')][@title='Delete']");
    public static By dialogYes = By.xpath("//div[@role='dialog']//button[.='Yes']");
    public static By dialogNo = By.xpath("//div[@role='dialog']//button[.='No']");
    public static By filterCategory = By.xpath("//span[contains(@class,'filter-name')][contains(text(),' Category')]");
    public static By filterHealthCoaching = By.xpath("//span[contains(@class,'drop-name-text')][contains(text(),'Health Coaching')]");
    public static By filterAuthentication = By.xpath("//span[contains(@class,'filter-name')][contains(text(),'Athentication')]");


}
