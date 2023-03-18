import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(enabled = true, priority = 0, description = "LoginEmptyEmailPasswordTest")
    public  void LoginEmptyEmailPasswordTest () {

        navigateToPage();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test(enabled = true, priority = 1, description = "LoginValidEmailValidPasswordTest")
    public  void LoginValidEmailValidPasswordTest () throws InterruptedException {

        navigateToPage();

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Thread.sleep(2000);
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }
    @Test(enabled = true, priority = 2, description = "LoginInvalidEmailValidPasswordTest")
    public void LoginInvalidEmailValidPasswordTest () throws InterruptedException {

        navigateToPage();

        provideEmail("invalid@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url);

    }
}