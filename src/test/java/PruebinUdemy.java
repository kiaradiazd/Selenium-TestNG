
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.ArrayList;
import java.util.List;

public class PruebinUdemy {
    public static WebDriver driver;
    public static Dimension dimension;
    private LoginPage loginPage;
    private List<WebDriver> drivers = new ArrayList<>();
    private TestUtil loginUtil;

    @BeforeTest
    void antesPruebas(){
    }


    @Parameters({"navegador"})
    @BeforeMethod
    void preparacionPrueba(@Optional("chrome") String navegador) {

        driver = TestUtil.crearWebDriver(navegador);
        loginPage = new LoginPage(driver);
        drivers.add(driver);
        loginPage.abrirPagina("https://www.saucedemo.com/");

    }

    @Test( priority = 1, description = "Inicio de sesion exitoso")
    void pruebaInicioSesionExistoso(){
        dimension = new Dimension(770,820);
        driver.manage().window().setSize(dimension);
        Point posicion = new Point(0, 0);
        driver.manage().window().setPosition(posicion);

        loginPage.getCampoNombreUsuario().sendKeys("standard_user");
        loginPage.getCampoContrasena().sendKeys("secret_sauce");
        loginPage.getBotonIniciarSesion().click();

        String textoMensajeBienvenida = loginPage.getMensajeBienv();
        Assert.assertEquals(textoMensajeBienvenida, "Swag Labs");

    }

    @Test( priority = 1, description = "Inicio de sesion exitoso")
    void pruebaInicioSesionAlterno(){


    }

    @Test( priority = 2, description = "Inicio de sesion incorrecto")
    public void pruebaInicioSesionCredencialesIncorrectas() {

        dimension = new Dimension(770,410);
        driver.manage().window().setSize(dimension);
        Point posicion = new Point(760, 0);
        driver.manage().window().setPosition(posicion);

        loginPage.getCampoNombreUsuario().sendKeys("dfgfh_user");
        loginPage.getCampoContrasena().sendKeys("sergrf_sauce");
        loginPage.getBotonIniciarSesion().click();

        WebElement mensajeError = loginPage.getMensajeError();
        Assert.assertTrue(mensajeError.isDisplayed());
    }

    @Test( priority = 3, description = "Inicio de sesion de usuario bloqueado")
    public void pruebaInicioSesionUsuarioBloqueado() {

        dimension = new Dimension(770,410);
        driver.manage().window().setSize(dimension);
        Point posicion = new Point(760, 410);
        driver.manage().window().setPosition(posicion);

        loginPage.getCampoNombreUsuario().sendKeys("locked_out_user");
        loginPage.getCampoContrasena().sendKeys("secret_sauce");
        loginPage.getBotonIniciarSesion().click();

        WebElement mensajeError = loginPage.getMensajeError();
        Assert.assertTrue(mensajeError.isDisplayed());
    }


    @AfterMethod
    public void despuesPrueba(){
        //driver.quit();
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