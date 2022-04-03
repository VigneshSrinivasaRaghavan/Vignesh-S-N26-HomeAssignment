package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BalancePage extends BasePage {
    @AndroidFindBy(id = "com.monefy.app.lite:id/textViewCategoryName") private MobileElement firstEntryCategory;
    @AndroidFindBy(id = "com.monefy.app.lite:id/textViewWholeAmount") private MobileElement firstEntryCategoryAmount;
    @AndroidFindBy(id = "com.monefy.app.lite:id/transaction_group_header") private MobileElement firstEntryHeader;
    @AndroidFindBy(id = "com.monefy.app.lite:id/textViewTransactionDate") private MobileElement firstEntryDetail;

    public String getFirstEntryCategory() {
        return firstEntryCategory.getText();
    }

    public String getFirstEntryAmount() {
        return firstEntryCategoryAmount.getText();
    }

    public BalancePage clickFirstEntryHeader() {
        click(firstEntryHeader, "First Entry Header");
        return this;
    }

    public EditIncomePage clickFirstEntryDetail() {
        click(firstEntryDetail, "First Entry Detail");
        return new EditIncomePage();
    }
}


