package gerenciar.viagem;

//biblioteca responsavel por uma espera em segundos para carregar uma pagina ou achar um elemento
import java.util.concurrent.TimeUnit;
// biblioteca responsavel por localizadores de elementos
import org.openqa.selenium.By;

// biblioteca para utilizar a interface WebDriver
import org.openqa.selenium.WebDriver;
//Representa um elemento HTML. Geralmente, todas as operações interessantes para fazer 
//interagir com uma página , será realizada através desta interface.
import org.openqa.selenium.WebElement;
//biblioteca para realizar ações como , comando mouseDown 
// A classe Actions é utilizada
import org.openqa.selenium.interactions.Actions;
//biblioteca para executar testes com a classe de seleção Select
import org.openqa.selenium.support.ui.Select;
// biblioteca para usar a função assert de um teste , verificar texto desejado
import static org.junit.Assert.*;
import org.junit.Test;

public class EditarViagem {

    private WebDriver driver;

    public EditarViagem(WebDriver driver) {
        //Quando realizo uma associação na classe de test para esta classe , 
        // é instanciado o driver desejado
        this.driver = driver;
    }

    public void paginaInicial() {
        // url para realizar o login
        driver.get("http://localhost/controle-cead/logar.php");
    }

    public void maximizarTela() {
        // Comando para maximixar a janela de teste
        driver.manage().window().maximize();
    }

    public void fazerLogin() {
        // Digito o login admin@cead.com - login de administrador
        driver.findElement(By.name("login")).sendKeys("admin@cead.com");
        // Digito o a senha do administrador
        driver.findElement(By.name("senha")).sendKeys("123");
        // Realizo um clique no botão entrar
        driver.findElement(By.cssSelector(".btn.btn-right.btn-info")).click();
        // Comando de espera ,30 segundos para uma nova página ser carregada
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void editarViagem() throws Exception {
        // Clica na ferramenta viagem
        driver.findElement(By.id("viagensLink")).click();
        // Clica na funcionalidade gerenciar viagem
        driver.findElement(By.xpath("html/body/div[1]/nav/div/div[2]/menu/ul[6]/a[1]/li")).click();

        
        // Clica na opção p/ editar viagem
        driver.findElement(By.xpath("html/body/div[1]/div[5]/div/div[1]/div/button")).click();
        
      // -->>>   COMECAR DAQUI QUANDO A FUNCIONALIDADE ESTIRVER PRONTA  <<--  //

        // Edita o nome do polo

        //Limpa o nome do polo cadastrado
        driver.findElement(By.xpath(".//*[@id='nomepolo']")).clear();
        //Digita o nome do polo desejado
        driver.findElement(By.xpath(".//*[@id='nomepolo']")).sendKeys("Flores");



        //Edita o estado do polo

        //Cria um objeto Select para selecionar outro estado p/ o polo
        Select estadoPolo = new Select(driver.findElement(By.id("estado")));
        //Desfaz a seleção do estado cadastrado
        estadoPolo.deselectByVisibleText("São Paulo");
        //Seleciona o estado desejado
        estadoPolo.selectByVisibleText("Rio de Janeiro");



        //Edita a cidade do polo

        //Cria um objeto Select p/ selecionar outra cidade p/ o polo
        Select cidadePolo = new Select(driver.findElement(By.id("cidade")));
        //Desfaz a seleção p/ a cidade cadastrada
        cidadePolo.deselectByVisibleText("Assis");
        //Seleciona a cidade desejada
        cidadePolo.selectByVisibleText("Rio de Janeiro");

        // Clica no botão atualizar dados
        driver.findElement(By.xpath(" .//*[@id='ajaxForm']/input")).submit();

        // Teste para verificar a mensagem atualização realizada com sucesso retornada pelo sistema
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            } else {
                try {
                    if ("Atualização concluída".equals(driver.findElement(By.cssSelector("p.popUpContent.centeredText")).getText())) {
                        System.out.println(" Atualização de polo realizada com sucesso");
                    }
                    break;
                } catch (Exception e) {
                }
                Thread.sleep(1000);
            }


        }
    }
}
