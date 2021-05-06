import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteCadastro {
    private WebDriver driver;
    private DSL dsl;

    @Before
    public void inicializa() {
        System.setProperty("webdriver.gecko.driver", "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/testeSelium/src/main/resources/firefox/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/campo_treinamento/componentes.html");
        dsl = new DSL(driver);
    }

    @After
    public void finaliza() {
        driver.quit();
    }

    @Test
    public void deveInteragirComAlertPrompt() {
        dsl.escrever("elementosForm:nome","Priscila Mayume");
        dsl.escrever("elementosForm:sobrenome","Santos Hirotsu");
        dsl.clicarRadioButton("elementosForm:sexo:1");
        dsl.clicarRadioButton("elementosForm:comidaFavorita:2");

        //identificar o campo do combo        //selecionar um elemento do combo
        dsl.selecionarCombo("elementosForm:escolaridade", "Mestrado");
        dsl.selecionarCombo("elementosForm:esportes", "Natacao");
        dsl.clicarBotao("elementosForm:cadastrar");

        Assert.assertTrue(dsl.obterTexto("resultado").startsWith("Cadastrado!"));
        Assert.assertTrue(dsl.obterTexto("descNome").endsWith("Mayume"));
        Assert.assertEquals("Sobrenome: Santos Hirotsu", dsl.obterTexto("descSobrenome"));
        Assert.assertEquals("Sexo: Feminino", dsl.obterTexto("descSexo"));
        Assert.assertEquals("Comida: Pizza", dsl.obterTexto("descComida"));
        Assert.assertEquals("Escolaridade: mestrado", dsl.obterTexto("descEscolaridade"));
        Assert.assertTrue(dsl.obterTexto("descEsportes").endsWith("Natacao"));

    }
}
