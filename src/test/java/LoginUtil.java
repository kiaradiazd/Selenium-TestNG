import org.openqa.selenium.WebDriver;

public class LoginUtil {
    private WebDriver driver;
    private static LoginPage loginPage;

    public LoginUtil(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver); // Inicializa una instancia de LoginPage
    }

    public static void iniciarSesion(String usuario, String contrasena) {
        loginPage.getCampoNombreUsuario().sendKeys(usuario);
        loginPage.getCampoContrasena().sendKeys(contrasena);
        loginPage.getBotonIniciarSesion().click();
    }
}
