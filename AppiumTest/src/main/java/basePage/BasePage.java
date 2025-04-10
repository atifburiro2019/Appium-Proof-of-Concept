package basePage;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import pages.DashboardPage;
import pages.LoginPage;
//import pages.MomShiftSchedularPage;
import pages.MorePage;

public class BasePage {
    public AndroidDriver driver;
    public By continueBtn = By.id("btnContinue");
    public By tableLayout = By.id("rvTableLayouts");
    public By splitTicketBtn = By.id("btnSplitTicket");
    public By doneBtn = By.id("btnDone");
    public By noteLabel = By.id("tvNote");
    public By numpadDoneBtn = By.id("btn_done");
    public By backBtn = By.id("ivBack");
    public By backMOMBtn = AppiumBy.accessibilityId("Go Back");
    public By btn1 = By.id("btn_1");
    public By btn2 = By.id("btn_2");
    public By btn0 = By.id("btn_0");
    public By noReceiptBtn = By.id("noReceiptBtn");
    public By profileIcon = By.id("ivDummy");
    public By cashDrawerBtn = By.id("tvCashDrawer");
    public By cashLogs = By.xpath("//android.widget.TextView[@text='Cash Logs']");
    public By hamburgerMenu = By.id("ivHamburgerMenu");
    public By ordersHubBtn = By.id("clOrderHub");
    public By tableView = By.id("frameLayout");
    public By tables = By.id("clMain");
    public By dashboardBtn = By.id("tvDashBoard");
    public By modifierPrice = By.id("tvModifierPrice");
    public By tableServeOption = By.xpath("//android.widget.TextView[@text='Table Serve']");
    public By confirmationMessage = By.id("tvMessage");
    public By cancelBtn = By.id("btnCancel");
    public By serverName = By.id("tvServerName");
    private static final Logger baseLogger = LoggerFactory.getLogger(BasePage.class);
    public By modifier = By.id("tvModifier");
    public By emailField = AppiumBy.accessibilityId("textInput-Email address");
    public By nextButton = AppiumBy.accessibilityId("Next");
    public By passwordField = AppiumBy.accessibilityId("textInput-Password");
    public By profileTab = AppiumBy.accessibilityId("Profile");
    public By docTab = AppiumBy.accessibilityId("Documents");
    public By pageTitle = AppiumBy.accessibilityId("title");
    public By submitBtn = AppiumBy.accessibilityId("Submit");
    public By saveBtn = AppiumBy.accessibilityId("Save");
    public By titleOfMom = AppiumBy.accessibilityId("appName");
    public By loginButton = AppiumBy.accessibilityId("Log in");
    public By loginButtonAgain = AppiumBy.accessibilityId("Log In");
    protected By checkoutBtn = By.id("vCheckout");
    public By kioskSubtotal = By.id("tvAmount");
    private By completePaymentBtn = By.id("completePaymentBtn");
    public By payBtn = By.id("btnPay");
    public By sendAndProceedBtn = By.id("sendProceedBtn");
    public By stayBtn = By.id("btnStay");
    public By activityStatus = By.id("tvActivityStatus");
    public By sendBtn = By.id("btnSend");
    public By splitTicketScreen = By.id("TvSplitTicket");
    public By readyBtn = By.id("tvReady");
    public By getCallServerText = By.xpath("//android.widget.TextView[contains(@text, 'Chef')]");
    public By MoreBtn = AppiumBy.accessibilityId("More");
    public By emailEmployee = AppiumBy.accessibilityId("textInput-Email Address");
    public By autoGratuity = By.xpath("//android.widget.CheckBox[contains(@text,'Auto Gratuity')]");
    public By shiftSchedular = By.xpath("//android.widget.TextView[@text='Shifts']");
    public By addBtn = AppiumBy.accessibilityId("addMoreBtn");
    public By QSRbtn = By.xpath("//android.widget.TextView[@text='Quick Serve']");
    public By phoneNumber = By.id("etPhoneNumber");
    private By pinScreen = By.id("tvEnter");
    protected By mposSplash = By.id("clSplash");
    protected By noBtn = By.id("btnNo");
	public By exactAmount=By.xpath("//android.widget.Button[contains(@resource-id,'suggestionText')]");
    public By balanceDueText = By.id("balanceDue");


    public BasePage(AndroidDriver driver) {
        this.driver = driver;
    }

    protected Logger getLogger() {
        return LoggerFactory.getLogger(this.getClass());
    }

    public void isMomPageDisplayed() {
        waitForElementPresent(titleOfMom, 60);
    }

    public LoginPage gotoLogin() {
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    public WebElement waitForElementPresent(By element, int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.presenceOfElementLocated(element));
    }
    
    public WebElement waitForElementToBeClickable(By element, int time) {
    	return new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForElementVisibility(By element, int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public List<WebElement> waitForElementsPresent(By element, int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
    }

    public boolean waitForElementInvisibility(By element, int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public boolean waitForElementInvisibility(WebElement element, int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.invisibilityOf(element));
    }

    public List<WebElement> waitForElementsVisibility(By element, int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
    }
    
    public void configureFluentWait(int timeInSeconds, int pollyingInMillis) {
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeInSeconds))
                .pollingEvery((Duration.ofMillis(pollyingInMillis)))
                .ignoring((Exception.class));
    }

    public WebElement scrollTo(String onText,String className) {
        baseLogger.info("Scrolling to " + onText);
     return driver.findElement(AppiumBy.androidUIAutomator(
        		"new UiScrollable(new UiSelector().scrollable(true).className(\"" + className + "\"))" +
        		".scrollIntoView(new UiSelector().textMatches(\"(?i)" + onText + "\"));"
        		));
    }
    
    public WebElement scrollToById(String onText, String resourceId) {
        baseLogger.info("Scrolling to text: " + onText + " within resourceId: " + resourceId);
        return driver.findElement(AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true).resourceId(\"" + resourceId + "\"))" +
            ".scrollIntoView(new UiSelector().textContains(\"" + onText + "\"));"
        ));
    }
   
    public boolean stay() {
        getLogger().info("Clicking Stay Button");
        boolean isClicked = false;
        int count=0;
        while (!isClicked&&count<5) {
            waitForElementVisibility(stayBtn, 5).click();
            getLogger().info("Waiting For Stay Status");
            if (driver.findElements(activityStatus).size() > 0) {
                isClicked = true;
            }
            count++;
        }
        return isClicked;
    }

    public String getCallServerText() {
        return driver.findElement(getCallServerText).getText();
    }

    public MorePage clickMoreBtn() {
        waitForElementVisibility(MoreBtn, 10).click();
        return new MorePage(driver);
    }
    public void clickBackButton() {
		driver.findElement(backMOMBtn).click();
	}

    public String generateRandomEmail() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        String baseEmail = "testuser";
        String domain = "@example.com";
        return baseEmail + dtf.format(now) + domain;
    }

    public String enterEmail() {
        String eEmail = generateRandomEmail();
        driver.findElement(emailEmployee).clear();
        driver.findElement(emailEmployee).sendKeys(eEmail);
        return eEmail;
    }

    public String getEmail() {
        return driver.findElement(emailEmployee).getText();
    }

    public void uncheckAutoGratuity() {
        driver.findElement(autoGratuity).click();
    }

    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder randomString = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }
        return randomString.toString();
    }

    public static String generateRandomPhoneNumber(int length) {
        String digits = "0123456789";
        Random random = new Random();
        StringBuilder phoneNumber = new StringBuilder("456");

        for (int i = 0; i < length - 3; i++) {
            int index = random.nextInt(digits.length());
            phoneNumber.append(digits.charAt(index));
        }
        return phoneNumber.toString();
    }


    public static String generateValidPhoneNumber() {
        Random random = new Random();
        StringBuilder phoneNumber = new StringBuilder();
        phoneNumber.append(random.nextInt(8) + 2); 
        phoneNumber.append(random.nextInt(10));
        phoneNumber.append(random.nextInt(10));
        int fourthDigit = random.nextInt(8) + 2;
        phoneNumber.append(fourthDigit);
        int fifthDigit;
        do {
            fifthDigit = random.nextInt(10); 
        } while (fourthDigit == 1 && fifthDigit == 1); 
        phoneNumber.append(fifthDigit);
        for (int i = 0; i < 5; i++) {
            phoneNumber.append(random.nextInt(10));
        }

        return phoneNumber.toString();
    }


    public void plusButton() {
        driver.findElement(addBtn).click();
    }

    public DashboardPage openDashboard() {
		getLogger().info("Opening Dashboard");
		driver.findElement(profileIcon).click();
		driver.findElement(dashboardBtn).click();
		return new DashboardPage(driver);
	}
  
}
