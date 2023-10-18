import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

public class MenuHambur {

    public static HomePage homePage;
    public static WebDriver driver;
    private LoginPage loginPage;
    private List<WebDriver> drivers = new ArrayList<>();

    @Parameters({"navegador"})
    @BeforeMethod
    void configuracionInicial(@Optional("chrome") String navegador) {
        driver = TestUtil.crearWebDriver(navegador);
        drivers.add(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.abrirPagina("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        loginPage.getCampoNombreUsuario().sendKeys("standard_user");
        loginPage.getCampoContrasena().sendKeys("secret_sauce");
        loginPage.getBotonIniciarSesion().click();

        homePage.getMenuHambur().click();


    }

    @Test
    void itemUno() throws InterruptedException{

        homePage.getCarrito().click();
        Thread.sleep(5000);
        homePage.getMenuHambur().click();
        String urlAntesDeClic = driver.getCurrentUrl();
        homePage.getItemUno().click();
        String urlDespuesDeClic = driver.getCurrentUrl();

        Assert.assertNotEquals(urlAntesDeClic, urlDespuesDeClic);

    }

    @Test
    void itemDos() throws InterruptedException{

        String urlAntesDeClic = driver.getCurrentUrl();
        Thread.sleep(5000);
        homePage.getItemDos().click();
        String urlDespuesDeClic = driver.getCurrentUrl();
        Assert.assertNotEquals(urlAntesDeClic, urlDespuesDeClic);

    }

    @Test
    void itemTres() throws InterruptedException{

        String urlAntesDeClic = driver.getCurrentUrl();
        Thread.sleep(5000);
        homePage.getItemTres().click();
        String urlDespuesDeClic = driver.getCurrentUrl();

        Assert.assertNotEquals(urlAntesDeClic, urlDespuesDeClic);

    }

    @Test
    void itemCuatro() throws InterruptedException{

        homePage.getAgregarProducto().click();
        WebElement elementoAEliminar = homePage.getItemCarrito();
        Assert.assertTrue(elementoAEliminar.isDisplayed());
        Thread.sleep(3000);
        homePage.getItemCuatro().click();

        WebElement elementoEliminado = homePage.getItemCarrito();
        Assert.assertFalse(elementoEliminado.isDisplayed());

    }

    @AfterTest
    public void despuesPruebas(){
        for (WebDriver driver : drivers) {
            if (driver != null) {
                driver.quit();
            }
        }
    }

}
