import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
  private WebDriver driver;
    public DSL(WebDriver driver) {
        this.driver = driver;
    }

    public void escrever(String id_campo, String texto) {
        driver.findElement(By.id(id_campo)).sendKeys(texto);
    }

    public String obterValorCampo(String id_campo) {
       return driver.findElement(By.id(id_campo)).getAttribute("value");
    }

    public void clicarRadioButton(String id) {
        driver.findElement(By.id(id)).click();
    }

    public boolean isRadioMarcado(String id) {
        return driver.findElement(By.id(id)).isSelected();
    }

    public void selecionarCombo(String id, String valor) {
        //identificar o campo do combo
        WebElement element = driver.findElement(By.id(id));
        //selecionar um elemento do combo
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
        //combo.selectByIndex(3);
        //combo.selectByValue("especializacao");
    }

    public String obterValorCombo(String id) {
        //identificar o campo do combo
        WebElement element = driver.findElement(By.id(id));
        //selecionar um elemento do combo
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();

    }

    public void clicarBotao(String id) {
        driver.findElement(By.id(id)).click();

    }

    public void clicarLink(String id_link) {
        driver.findElement(By.linkText(id_link)).click();

    }

    public String obterTexto(String id) {
        return driver.findElement(By.id(id)).getText();
    }

    public String obterTexto(By by) {
        return driver.findElement(by).getText();
    }
}
