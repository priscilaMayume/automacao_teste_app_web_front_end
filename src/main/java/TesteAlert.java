import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAlert {
    public WebDriver driver;

    @Before
    public void inicializa() {
        System.setProperty("webdriver.gecko.driver", "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/testeSelium/src/main/resources/firefox/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/campo_treinamento/componentes.html");
    }

    @After
    public void finaliza() {
        driver.quit();
    }


    @Test
    public void deveInteragirComAlertSimples() {
        driver.findElement(By.id("alert")).click();
        //pegar elementos externos da pagina - Tem que pedir pra o Selenium mudar o foco da pagina
        Alert alert = driver.switchTo().alert();
        String texto = alert.getText();
        Assert.assertEquals("Alert Simples", texto);
        //Aceitar o alerta
        alert.accept();

        driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);

    }

    @Test
    public void deveInteragirComAlertConfirm() {
        driver.findElement(By.id("confirm")).click();
        //pegar elementos externos da pagina - Tem que pedir pra o Selenium mudar o foco da pagina
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Confirm Simples", alert.getText());
        //Aceitar o alerta
        alert.accept();
        Assert.assertEquals("Confirmado", alert.getText());
        alert.accept();

        driver.findElement(By.id("confirm")).click();
        //pegar elementos externos da pagina - Tem que pedir pra o Selenium mudar o foco da pagina
        alert = driver.switchTo().alert();
        Assert.assertEquals("Confirm Simples", alert.getText());
        //Negar o alerta
        alert.dismiss();
        Assert.assertEquals("Negado", alert.getText());
        alert.dismiss();

    }

    @Test
    public void deveInteragirComAlertPrompt() {
        driver.findElement(By.id("prompt")).click();
        //pegar elementos externos da pagina - Tem que pedir pra o Selenium mudar o foco da pagina
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Digite um numero", alert.getText());
        //Escrever no prompt do alerta
        alert.sendKeys("12");
        alert.accept();
        Assert.assertEquals("Era 12?", alert.getText());
        alert.accept();
        Assert.assertEquals(":D", alert.getText());
        alert.accept();
    }
}