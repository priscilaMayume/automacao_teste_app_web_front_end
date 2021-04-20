import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastro {

    @Test
    public void deveInteragirComAlertPrompt() {
        System.setProperty("webdriver.gecko.driver", "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/testeSelium/src/main/resources/firefox/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/campo_treinamento/componentes.html");

        driver.findElement(By.id("elementosForm:nome")).sendKeys("Priscila Mayume");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Santos Hirotsu");
        driver.findElement(By.id("elementosForm:sexo:1")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();

        //identificar o campo do combo
        WebElement elementEscolaridade = driver.findElement(By.id("elementosForm:escolaridade"));
        //selecionar um elemento do combo
        Select comboEscolaridade = new Select(elementEscolaridade);
        comboEscolaridade.selectByVisibleText("Superior");

        //identificar o campo do combo
        WebElement elementEsporte = driver.findElement(By.id("elementosForm:esportes"));
        //selecionar um elemento do combo
        Select comboEsporte = new Select(elementEsporte);
        //fazer a seleção do elemento
        comboEsporte.selectByVisibleText("Natacao");

        driver.findElement(By.id("elementosForm:cadastrar")).click();

        Assert.assertTrue( driver.findElement(By.id("resultado")).getText().contains("Cadastrado!"));
        Assert.assertEquals("Nome: Priscila Mayume", driver.findElement(By.id("descNome")).getText());
        Assert.assertEquals("Sobrenome: Santos Hirotsu", driver.findElement(By.id("descSobrenome")).getText());
        Assert.assertTrue( driver.findElement(By.id("descSexo")).getText().endsWith("Feminino"));
        Assert.assertEquals("Comida: Pizza", driver.findElement(By.id("descComida")).getText());
        Assert.assertEquals("Escolaridade: superior", driver.findElement(By.id("descEscolaridade")).getText());
        Assert.assertTrue(driver.findElement(By.id("descEsportes")).getText().endsWith("Natacao"));

        driver.quit();
    }
}
