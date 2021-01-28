import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest {

    @Test
    public void ZipCodeTest() {
        /*User can enter zip-code to proceed to sign up form*/
        open("https://www.sharelane.com/");
        $(By.xpath("//*[text()='ENTER']")).click();
        open("https://www.sharelane.com/cgi-bin/register.py");
        $(By.name("zip_code")).sendKeys("12345");
        $(By.cssSelector("[value=Continue]")).click();

        String result = $(By.cssSelector("[value=Register]")).getText();// изучить getAttribute
        Assert.assertEquals(result, "Register");
    }

    @Test
    public void zipcode4DigitsTest() {
        /*Error when 4 digits were entered*/
        open("https://www.sharelane.com/");
        $(By.xpath("//*[text()='ENTER']")).click();
        open("https://www.sharelane.com/cgi-bin/register.py");
        $(By.name("zip_code")).sendKeys("1234");
        $(By.cssSelector("[value=Continue]")).click();
        String result = $(By.cssSelector(".error_message")).getText();// изучить getAttribute
        Assert.assertEquals(result, "Oops, error on page. ZIP code should have 5 digits\n");
    }

    @Test//done
    public void zipcode6DigitsTest() {
        /*Error when 6 digits were entered*/
        open("https://www.sharelane.com/");
        $(By.xpath("//*[text()='ENTER']")).click();
        open("https://www.sharelane.com/cgi-bin/register.py");
        $(By.name("zip_code")).sendKeys("123456");
        $(By.cssSelector("[value=Continue]")).click();
        String result = $(By.cssSelector(".error_message")).getText();// изучить getAttribute
        Assert.assertEquals(result, "Oops, error on page. ZIP code should have 5 digits\n");
    }

    @Test//done
    public void emptyZipcodeTest() {
        /*Error when zip code field is empty*/
        open("https://www.sharelane.com/");
        $(By.xpath("//*[text()='ENTER']")).click();
        open("https://www.sharelane.com/cgi-bin/register.py");
        $(By.name("zip_code")).sendKeys("");
        $(By.cssSelector("[value=Continue]")).click();
        String result = $(By.cssSelector(".error_message")).getText();
        Assert.assertEquals(result, "Oops, error on page. ZIP code should have 5 digits\n");
    }

    @Test//done
    public void userCanSignUpTest() {
        /*userCanSignUp filling all required fields*/
        open("https://www.sharelane.com/");
        $(By.xpath("//*[text()='ENTER']")).click();
        open("https://www.sharelane.com/cgi-bin/register.py");
        $(By.name("zip_code")).sendKeys("12345");
        $(By.cssSelector("[value=Continue]")).click();
        $(By.name("first_name")).sendKeys("Luke");
        $(By.name("email")).sendKeys("1@mailinator.com");
        $(By.name("password1")).sendKeys("pswrd");
        $(By.name("password2")).sendKeys("pswrd");
        $(By.cssSelector("[value=Register]")).click();
        String result = $(By.cssSelector("[value=Continue]")).getText();
        Assert.assertEquals(result, "Account is created!\n");

    }

}
