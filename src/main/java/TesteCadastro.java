import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteCadastro {
    private WebDriver driver;
    private DSL dsl;
    private CadastroPage page;

    @Before
    public void inicializa() {
        System.setProperty("webdriver.gecko.driver", "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/testeSelium/src/main/resources/firefox/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/campo_treinamento/componentes.html");
        dsl = new DSL(driver);
        page = new CadastroPage(driver);
    }

    @After
    public void finaliza() {
        driver.quit();
    }

    @Test
    public void deveRealizarCadastroComSucesso() {
        page.setNome("Priscila Mayume");
        page.setSobrenome("Santos Hirotsu");
        page.setSexoFeminino();
        page.setComidaFavoritaPizza();
        //identificar o campo do combo        //selecionar um elemento do combo
        page.setEscolaridadeMestrado();
        page.setEsporteNatacao();
        page.setBotaoCadastrar();

        Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
        Assert.assertTrue(page.obterNomeCadastro().endsWith("Mayume"));
        Assert.assertEquals("Sobrenome: Santos Hirotsu", page.obterSobreNomeCadastro());
        Assert.assertEquals("Sexo: Feminino", page.obterSexoCadastro());
        Assert.assertEquals("Comida: Pizza", page.obterComidaCadastro());
        Assert.assertEquals("Escolaridade: mestrado", page.obterEscolaridadeCadastro());
        Assert.assertTrue(page.obterEsporteCadastro().endsWith("Natacao"));

    }
}
