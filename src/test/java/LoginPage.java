import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void abrirPagina(String url) {
        driver.get(url);
    }

    public WebElement getCampoNombreUsuario() {
        return driver.findElement(By.id("user-name"));
    }

    public WebElement getCampoContrasena() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getBotonIniciarSesion() {
        return driver.findElement(By.id("login-button"));
    }

    public WebElement getMensajeError() {
        return driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
    }

    public String getMensajeBienv(){
        String textoMensajeBienvenida = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[2]/div")).getText();
        return textoMensajeBienvenida;
    }
}
