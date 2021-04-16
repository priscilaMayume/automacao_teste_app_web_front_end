import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {

    public static void main (String[] args) {
     System.setProperty("webdriver.gecko.driver", "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/testeSelium/src/main/resources/firefox/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");
        System.out.println(driver.getTitle());
    }
}
