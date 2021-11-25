package kur.alexei.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import kur.alexei.helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestBase {

    @BeforeAll
    public static void beforeTest() {

        Configuration.browserSize="1200x800";
//        Configuration.proxyEnabled = true; // только для отдельных тестов, а не в общие настройки
//        Configuration.fileDownload = FileDownloadMode.PROXY; // для скачивания файлов без href, только для отдельных тестов, а не в общие настройки

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
