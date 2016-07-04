package inserir.viagem;

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

public class InserirViagem {

    private WebDriver driver;

    public InserirViagem(WebDriver driver) {
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
    public void inserirViagem() throws Exception

    {
        // Clicar na ferramenta viagens
        driver.findElement(By.id("viagensLink")).click();
        // Clicar na funcionalidade inserir nova viagem
        driver.findElement(By.xpath("//ul[6]/a[2]/li")).click();

        // Seleciona um curso p/ viagem
        Select curso = new Select(driver.findElement(By.id("curso")));
        curso.selectByVisibleText("Estética");

        // Seleciona um polo p/ viagem
        Select polo = new Select(driver.findElement(By.cssSelector("#polo")));
        // Esta opção é selecionada quando se quer escolher um polo que não consta na lista de 
        //polos existentes , assim o polo é digitado manualmente
        polo.selectByVisibleText("Outro destino");
        driver.findElement(By.id("destinoManual")).sendKeys("Campinas");

        // Tratamento para selecionar um responsável
        //Select é a opção p/ selecionar um elemento de uma caixa de listagem
        WebElement responsavel = driver.findElement(By.className("chosen-single"));
        //Realiza um clique no elemento
        responsavel.click();
        // Select dropDown3;
        // dropDown3 = new Select(driver.findElement(By.xpath(".//*[@id='responsavel_chosen']/a/div/b")));
        //Seleciono pelo texto , mas pode ser pelo índice ou código
        //  dropDown3.selectByIndex(1);

        // A data é capturada pelo selenium Ide , através do id e depois do link texto
        //Clica na janela dropDown para abrir o calendário
        driver.findElement(By.id("dataIda")).click();
        // Espera após clicar na janela drop down da data  
        driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);

        // Clica no dia desejado p/ ida da viagem
        driver.findElement(By.linkText("23")).click();

        //Clica na janela p/ seleciona a hora
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[1]")).click();

        // ponteiro é o quadrado responsável por mudar a hora , esta no inicio
        WebElement ponteiro = driver.findElement(By.cssSelector(".ui_tpicker_hour_slider.ui-slider.ui-slider-horizontal.ui-widget.ui-widget-content.ui-corner-all"));
        // ponteiro2 é o quadrado responsável por selecionar os minutos 
        WebElement ponteiro2 = driver.findElement(By.cssSelector(".ui-timepicker-div>dl"));


        // A classe action é a classe responsável pelo movimentos com o mouse , selecionar elementos na caixa de texto ,
        // preencher campos em formulários
        // O método perform é o responsavel por realizar a ação
        Actions acao = new Actions(driver);
        acao.dragAndDrop(ponteiro, ponteiro2).perform();


        // botão ok da data de ida
        driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[3]/button[2]"));

        //Clica na janela dropDown para abrir o calendário da data de volta
        driver.findElement(By.id("dataVolta")).click();

        // Espera após clicar na janela dropDown da data 
        driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
        // Clica no dia desejado p/ volta da viagem
        driver.findElement(By.linkText("24")).click();
        // ponteiro de minutos
        WebElement minutos = driver.findElement(By.cssSelector(".ui_tpicker_hour_slider.ui-slider.ui-slider-horizontal.ui-widget.ui-widget-content.ui-corner-all"));
        // ponteiro de horas
        WebElement horas = driver.findElement(By.cssSelector(".ui-timepicker-div>dl"));
        Actions acao2 = new Actions(driver);
        acao2.dragAndDrop(minutos, horas).perform();

        // Localiza o quadrado de horas
        WebElement horasVolta = driver.findElement(By.cssSelector(".ui_tpicker_hour_slider.ui-slider.ui-slider-horizontal.ui-widget.ui-widget-content.ui-corner-all"));
        // Localiza o quadrado de minutos
        WebElement minutosVolta = driver.findElement(By.cssSelector(".ui-timepicker-div>dl"));

        //  WebElement ponteiro7 = driver.findElement(By.cssSelector(".ui_tpicker_hour_slider.ui-slider.ui-slider-horizontal.ui-widget.ui-widget-content.ui-corner-all"));

        // WebElement ponteiro8 = driver.findElement(By.cssSelector(".ui-timepicker-div>dl"));

        // A classe action é a classe responsável pelo movimentos com o mouse , selecionar elementos na caixa de texto ,
        // preencher campos em formulários
        // O método perform é o responsavel por realizar a ação
        Actions acao3 = new Actions(driver);
        acao3.dragAndDrop(horasVolta, minutosVolta).perform();

        //   Actions action4 = new Actions(driver);
        //    action4.dragAndDrop(ponteiro7, ponteiro8).perform();

        // Clique no botão ok , da caixa dropDown com horas e minutos da data de volta
        driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[3]/button[2]"));

        //Seleciona o motivo da viagem
        Select motivo = new Select(driver.findElement(By.id("motivo")));
        motivo.selectByVisibleText("Aula");

        //Seleciona o estado da viagem
        Select estado = new Select(driver.findElement(By.id("estado")));
        estado.selectByVisibleText("Planejada");

        //Digita a quantidade de diarias
        driver.findElement(By.id("diarias")).sendKeys("2");

        // Mais uma caixa diferenciada , ver o tratamento

        //Seleciona o passageiro Cead Ead
        Select passageiros = new Select(driver.findElement(By.xpath("//[@id='passageiros_chosen']/ul/li[1]/span")));
        passageiros.selectByVisibleText("Cead Ead (admin@cead.com)");

        //Clicar no botão cadastrar
        driver.findElement(By.xpath(".//*[@id='passageiros_chosen']/ul")).submit();

        // Teste para ter certeza que a viagem foi cadastrada e o sistema emitiu a mensagem , 
        //cadastro realizado com sucesso
        for (int second = 0;; second++) {
            if (second >= 70) {
                fail("timeout");
            }
            try {
                if ("Cadastro com sucesso".equals(driver.findElement(By.cssSelector("p.popUpContent.centeredText")).getText())) {
                    System.out.println("Viagem cadastrada com sucesso");
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            // Comando de espera ,30 segundos para uma nova página ser carregada
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    public boolean existe(String string) {
        return driver.getPageSource().contains(string);
    }
}
