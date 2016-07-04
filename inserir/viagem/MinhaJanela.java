package inserir.viagem;


import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.Scanner;
import javax.swing.JFrame;

import javax.swing.JLabel;


public class MinhaJanela extends JFrame {
    /* Componentes devem estar no contexto da instância, 
     para que possam ser acessados em todos os métodos  
     não-estáticos da classe 
     */

    // pagina fonte http://www.guj.com.br/java/231347-escrever-um-texto-dentro-de-uma-janela
    // outra pagina http://luiztorreslinguagemjava.blogspot.com.br/2009/08/criar-tela-em-java-swing.html
    // ultima pagina seguida http://javainterface.wikidot.com/interfacejava
    // private JTextArea texto = new JTextArea();
    // private JLabel dentroCaixa = new JLabel();
    JLabel label1;
    JLabel label2;
    JLabel label4;

    public MinhaJanela() {
       
        label1 = new JLabel("Menu para escolha de driver p/ ser usado em testes de integração:"); //texto no construtor
        this.setContentPane(label1); //define um container para o JFrame
        label2 = new JLabel("Digite 1 - para FirefoxDriver: " + "Digite 2 - para ChromeDriver:"
        + "Digite 3 - para SafariDriver:" + "Digite 4 - para OperaDriver:",
        JLabel.CENTER);//texto com posição definida
        label4 = new JLabel("Rótulo 4", JLabel.CENTER);
        Container pane = this.getContentPane(); //captura o painel do JFrame
        pane.setLayout(new GridLayout(4, 1)); //define o layout do painel
        pane.add(label1);
        pane.add(label2);
        pane.add(label4);
        
        setTitle(" Bem vindo para a escolha do Driver : "); //Define titulo p/ janela
        setVisible(true);   // Tornar a janela criada visível
        setSize(640, 480);  //Definir o tamanho p/ janela
         //Assim como os componentes são adicionados ao content pane, 
        //é o background do content pane que deve ser setado
        setBackground(Color.WHITE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) throws Exception {
        JFrame janela = new JFrame();

       
        int driverDeTeste = 1;
        
        Scanner entrada = new Scanner(System.in); // Classe scanner pega entrada do teclado
        String procurandoDriver = entrada.next();
        /*  System.out.println(" Menu para escolha de driver p/ ser usado em testes de integração: ");
         System.out.println(" Digite 1 - para FirefoxDriver: ");
         System.out.println(" Digite 2 - para ChromeDriver:  ");
         System.out.println(" Digite 3 - para OperaDriver:   ");
         System.out.println(" Digite 4 - para SafariDriver:  ");*/
        
        // switch para escolher o driver para executar os testes automatizados
        switch (driverDeTeste) {
            case 1:

                InserirViagemTest teste = new InserirViagemTest();
                teste.inicializa();
                teste.deveInserirViagem();
                teste.finaliza();
                break;
            case 2:
                System.out.println(" Ainda não foi implementado");
                break;
            case 3:
                System.out.println(" Ainda não foi implementado");
                break;
            case 4:
                System.out.println(" Ainda não foi implementado");
                break;
            default:
                System.out.println("Este não é um driver de testes válido!");
        }
    }
}