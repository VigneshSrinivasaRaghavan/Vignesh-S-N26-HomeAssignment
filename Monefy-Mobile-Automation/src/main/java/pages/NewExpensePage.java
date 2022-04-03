package pages;

import base.BasePage;
import driver.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class NewExpensePage extends BasePage {
    @AndroidFindBy(accessibility = "Navigate up") private MobileElement backButton;
    @AndroidFindBy(id = "com.monefy.app.lite:id/keyboard_action_button") private MobileElement chooseCategoryButton;
    @AndroidFindBy(xpath ="//*[@text='Bills']") private MobileElement BillsCategory;
    @AndroidFindBy(id ="com.monefy.app.lite:id/amount_text") private MobileElement amountTextBox;

    public DashboardPage clickBackButton() {
        click(backButton, "Back Button");
        return new DashboardPage();
    }

    public NewExpensePage clickKeyboardButton(String buttonToClick) {
        String locator = constructKeyboardNumber(buttonToClick);
        MobileElement element = (MobileElement) DriverManager.getDriver().findElement(By.id(locator));
        click(element, buttonToClick);
        return this;
    }

    public NewExpensePage clickExpenseCategory() {
        click(chooseCategoryButton, "Choose Category Button");
        return this;
    }

    public DashboardPage clickBillCategory() {
        click(BillsCategory, "Bills Category");
        return new DashboardPage();
    }

    public NewExpensePage clickAmountTextBox(){
        click(amountTextBox,"Amount Text Box");
        return this;
    }

    private String constructKeyboardNumber(String value) {
        return "com.monefy.app.lite:id/buttonKeyboard" + value;
    }
}


