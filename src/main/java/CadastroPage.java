import org.openqa.selenium.WebDriver;

public class CadastroPage {

    private DSL dsl;

    //construtor
    public CadastroPage(WebDriver driver) {
        dsl = new DSL(driver);
    }

    public void setNome(String nome) {
        dsl.escrever("elementosForm:nome", nome);
    }

    public void setSobrenome(String sobrenome) {
        dsl.escrever("elementosForm:sobrenome", sobrenome);
    }

    public void setSexoFeminino() {
        dsl.clicarRadio("elementosForm:sexo:1");
    }

    public void setComidaFavoritaPizza() {
        dsl.clicarRadio("elementosForm:comidaFavorita:2");
    }

    public void setEscolaridadeMestrado() {
        dsl.selecionarCombo("elementosForm:escolaridade", "Mestrado");
    }

    public void setEsporteNatacao() {
        dsl.selecionarCombo("elementosForm:esportes", "Natacao");
    }

    public void setBotaoCadastrar() {
        dsl.clicarBotao("elementosForm:cadastrar");
    }

    /********Asserts * @return********/

    public String obterResultadoCadastro() {
        return dsl.obterTexto("resultado");
    }

    public String obterNomeCadastro() {
        return dsl.obterTexto("descNome");
    }

    public String obterSobreNomeCadastro() {
        return dsl.obterTexto("descSobrenome");
    }

    public String obterSexoCadastro() {
        return dsl.obterTexto("descSexo");
    }

    public String obterComidaCadastro() {
        return dsl.obterTexto("descComida");
    }

    public String obterEscolaridadeCadastro() {
        return dsl.obterTexto("descEscolaridade");
    }

    public String obterEsporteCadastro() {
        return dsl.obterTexto("descEsportes"); }
}
