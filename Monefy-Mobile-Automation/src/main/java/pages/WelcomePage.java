package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WelcomePage extends BasePage {
    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonContinue") private MobileElement continueButton;
    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonClose") private MobileElement closeOffer;
    

    public WelcomePage clickGetStartedButton(){
        click(continueButton,"Get Started Button");
        return this;
    }

    public WelcomePage clickAmazingButton(){
        click(continueButton,"Amazing Button");
        return this;
    }

    public WelcomePage clickIAmReadyButton(){
        click(continueButton,"I am Ready Button");
        return this;
    }

    public DashboardPage closeOfferButton(){
        click(closeOffer,"Close Offer Button");
        return new DashboardPage();
    }
}


