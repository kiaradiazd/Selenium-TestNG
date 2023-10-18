import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void abrirPagina(String url) {
        driver.get(url);
    }

    public WebElement getMenuHambur() {
        return driver.findElement(By.id("react-burger-menu-btn"));
    }

    public WebElement getItemUno() {
        return driver.findElement(By.id("inventory_sidebar_link"));
    }

    public WebElement getItemDos() {
        return driver.findElement(By.id("about_sidebar_link"));
    }

    public WebElement getItemTres() {
        return driver.findElement(By.id("logout_sidebar_link"));
    }

    public WebElement getItemCuatro() {
        return driver.findElement(By.id("reset_sidebar_link"));
    }

    public WebElement getCarrito(){
        return driver.findElement(By.className("shopping_cart_link"));
    }

    public WebElement getItemCarrito(){
        return driver.findElement(By.className("shopping_cart_badge"));
    }

    public WebElement getAgregarProducto(){
        return driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
    }




}
