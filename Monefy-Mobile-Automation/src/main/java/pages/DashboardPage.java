package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DashboardPage extends BasePage {
    @AndroidFindBy(id = "com.monefy.app.lite:id/expense_button") private MobileElement expenseButton;
    @AndroidFindBy(id = "com.monefy.app.lite:id/income_button") private MobileElement incomeButton;
    @AndroidFindBy(id = "com.monefy.app.lite:id/balance_amount") private MobileElement balanceButton;
    

    public NewExpensePage clickExpenseButton(){
        click(expenseButton,"Expense Button");
        return new NewExpensePage();
    }

    public NewIncomePage clickIncomeButton(){
        click(incomeButton,"Income Button");
        return new NewIncomePage();
    }

    public BalancePage clickBalanceButton(){
        click(balanceButton,"Income Button");
        return new BalancePage();
    }
}


