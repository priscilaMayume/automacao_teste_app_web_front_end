import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TesteCampoTreinamento {

    @Test
    public void testeTextField() {
        System.setProperty("webdriver.gecko.driver", "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/testeSelium/src/main/resources/firefox/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/campo_treinamento/componentes.html");
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");

        //Checar o que foi escrito
        Assert.assertEquals("Teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
        driver.quit();
    }

    @Test
    public void deveInteragiTextArea() {
        System.setProperty("webdriver.gecko.driver", "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/testeSelium/src/main/resources/firefox/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/campo_treinamento/componentes.html");
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste");

        Assert.assertEquals("teste", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
        driver.quit();

    }

    @Test
    public void deveInteragirComRadioButton() {
        System.setProperty("webdriver.gecko.driver", "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/testeSelium/src/main/resources/firefox/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/campo_treinamento/componentes.html");
        driver.findElement(By.id("elementosForm:sexo:0")).click();

        //Checar o que foi marcado
        Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
        driver.quit();
    }

    @Test
    public void deveInteragirComCheckBox() {
        System.setProperty("webdriver.gecko.driver", "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/testeSelium/src/main/resources/firefox/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/campo_treinamento/componentes.html");
        driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();

        //Checar o que foi marcado
        Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
        driver.quit();
    }

    @Test
    public void deveInteragirComCombo() {
        System.setProperty("webdriver.gecko.driver", "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/testeSelium/src/main/resources/firefox/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/campo_treinamento/componentes.html");

        //identificar o campo do combo
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        //selecionar um elemento do combo
        Select combo = new Select(element);
        //combo.selectByIndex(3);
        //combo.selectByValue("especializacao");
        combo.selectByVisibleText("Superior");

        //Checar o que foi marcado
        Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
        driver.quit();

    }

    @Test
    public void deveVerificarValoresCombo() {
        System.setProperty("webdriver.gecko.driver", "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/testeSelium/src/main/resources/firefox/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/campo_treinamento/componentes.html");

        //identificar o campo do combo
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        //selecionar um elemento do combo
        Select combo = new Select(element);
        //retorna uma lista de WebElements
        List<WebElement> options = combo.getOptions();

        //Checar quantidade de opções que possui
        Assert.assertEquals(8, options.size());

        //Se uma determinada opção está presente no combo
        boolean encontrou = false;
        for (WebElement option : options) {
            if (option.getText().equals("Mestrado")) {
                encontrou = true;
                break;
            }
        }
        Assert.assertTrue(encontrou);

        driver.quit();
    }

    @Test
    public void deveVerificarValoresComboMultiplo() {
        System.setProperty("webdriver.gecko.driver", "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/testeSelium/src/main/resources/firefox/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/campo_treinamento/componentes.html");

        //identificar o campo do combo
        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
        //selecionar um elemento do combo
        Select combo = new Select(element);
        //fazer a seleção do elemento
        combo.selectByVisibleText("O que eh esporte?");
        combo.selectByVisibleText("Natacao");
        combo.selectByVisibleText("Corrida");

        //Verificar se foram marcadas tres opções
        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        Assert.assertEquals(3, allSelectedOptions.size());

        //desmarcar opção do combo
        combo.deselectByVisibleText("Corrida");
        allSelectedOptions = combo.getAllSelectedOptions();
        Assert.assertEquals(2, allSelectedOptions.size());

        driver.quit();

    }

    @Test
    public void deveInteragirComBotoes() {
        System.setProperty("webdriver.gecko.driver", "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/testeSelium/src/main/resources/firefox/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/campo_treinamento/componentes.html");

        WebElement botao = driver.findElement(By.id("buttonSimple"));
        botao.click();

        Assert.assertEquals("Obrigado!", botao.getAttribute("value"));

        driver.quit();
    }

    @Test
    public void deveInteragirComLinks() {
        System.setProperty("webdriver.gecko.driver", "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/testeSelium/src/main/resources/firefox/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/campo_treinamento/componentes.html");

        WebElement link =driver.findElement(By.linkText("Voltar"));
        link.click();

        Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());

        driver.quit();
    }

    @Test
    public void deveBuscarTextosNaPagina() {
        System.setProperty("webdriver.gecko.driver", "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/testeSelium/src/main/resources/firefox/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/campo_treinamento/componentes.html");

        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
        Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());

        driver.quit();
    }
}