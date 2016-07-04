package inserir.viagem;

import static org.junit.Assert.assertTrue;
//biblioteca para métodos depois do método de teste  
import org.junit.After;
//biblioteca para métodos antes do método de teste 
import org.junit.Before;
//biblioteca para métodos de teste 
import org.junit.Test;
// biblioteca responsavel por localizadores de elementos
import org.openqa.selenium.By;
// biblioteca para utilizar a interface WebDriver
import org.openqa.selenium.WebDriver;

//biblioteca para usar o navegador firefox 
import org.openqa.selenium.firefox.FirefoxDriver;

//biblioteca para usar o navegador internet explorer
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InserirViagemTest {

    private WebDriver driver;
    //Quando realizo uma associação na classe de test para esta classe , 
    // é instanciado o driver desejado
    private InserirViagem viagem;

    /**
     * Inicializa os testes criando o Driver e a página a ser testada
     */
    @Before
    public void inicializa() throws Exception {

        // Cria uma instância para o Firefox
        this.driver = new FirefoxDriver();
        // Passa o driver para um objeto de associação
        this.viagem = new InserirViagem(driver);

    }

    @Test
    public void deveInserirViagem() throws Exception {
        // Chama o método da url inicial 
        viagem.paginaInicial();
        // Chama o método para maximizar a tela
        viagem.maximizarTela();
        // Digita o login e a senha do administrador
        viagem.fazerLogin();
        // Insere viagem
        viagem.inserirViagem();
        // Verifica a mensagem e retorna true ou false
        assertTrue(viagem.existe("Cadastro realizado com sucesso"));
    }

    @After
    public void finaliza() throws Exception {
        // No driver do firefox , este comando encerra o servidor de teste , porém
        // preciso fechar as duas janelas de teste , para o teste ser totalmente finalizado
        // No chrome driver , está ocorrendo falhas para encerrar o teste , ele fica abeerto até sair do netbeans
        driver.quit();
    }

    public static void main(String[] args) throws Exception {

        // Cria-se uma nova instância desta classe , para chamar os métodos responsáveis por 
        // realizar o teste
        InserirViagemTest teste = new InserirViagemTest();
        // Chama os métodos para realizar o login
        teste.inicializa();
        //Chama os métodos para inserir viagem
        teste.deveInserirViagem();
        //Chama o método para encerrar o servidor de teste
        teste.finaliza();

    }
}
