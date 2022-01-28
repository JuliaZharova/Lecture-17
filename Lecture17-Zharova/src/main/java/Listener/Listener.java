package Listener;

import PageObject.BasePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.CheckLoginPopup;

import java.io.FileOutputStream;
import java.io.IOException;

public class Listener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        CheckLoginPopup checkLoginPopup = (CheckLoginPopup) result.getInstance();
      TakesScreenshot src = ((TakesScreenshot) BasePage.driver);
      byte[] screenshot = src.getScreenshotAs(OutputType.BYTES);

        String fileName = "screenshot.png";
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            fileOutputStream.write(screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
