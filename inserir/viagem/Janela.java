package inserir.viagem;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.*;

/* Esta classe apenas cria a janela , com um título e se realizar 
 * um clique no botão fechar(x) , fecha a janela
 */
public class Janela extends JFrame {

    public Janela() {





        this.setTitle(" Menu para escolha de driver de teste ");
        this.getContentPane().setBackground(new Color(255, 255, 255));// cor de fundo
        //this.setLayout(new SpringLayout());// definindo layout
        this.setFont(new Font("SansSerif", Font.PLAIN, 16));

        /*   JPanel painel = new JPanel();  
  
         painel.setLayout(new GridBagLayout());  
  
         GridBagConstraints cons = new GridBagConstraints();  
  
         cons.gridx = 0; //Coluna  
         cons.gridy = 0; //Linha  
         cons.gridwidth = 1;  
         cons.weighty = 0.00; //adicionado para ocupar 5% do espaço  
         painel.add(new JLabel("Digite"), cons);  
         cons.gridx = 0; //Coluna  
         cons.gridy = 2; //Linha  
         cons.gridwidth = 1;  
         cons.weighty = 0.05; //adicionado para ocupar 5% do espaço 
         painel.add(new JLabel(" 1 - para FirefoxDriver"), cons); 
         cons.gridx = 2; //Coluna  
         cons.gridy = 3; //Linha  
         cons.gridwidth = 3;  
         cons.weighty = 0.05; //adicionado para ocupar 5% do espaço 
         painel.add(new JLabel(" 2 - para ChromeDriver"), cons); 
         painel.add(new JLabel(" 3 - para SafariDriver"), cons); 
         painel.add(new JLabel(" 4 - para OperaDriver"), cons); 
         painel.add(new TextField(),cons);
         painel.add(new Button("Gerar Teste"),cons);
  
         cons.weighty = 0.95; //adicionado um panel vazio para ocupar 95% do espaço, completando 100%  
         //Observar que está na linha 1 (gridy=1), e o anterior na linha 0 (gridy=0)  
         cons.gridy = 1;  
         painel.add(new JPanel(),cons);  
  
         this.add(painel);*/

        SpringLayout layout = new SpringLayout();
        Container cp;
        JPanel main = new JPanel();

        JLabel label0 = new JLabel(" Digite ");

        // add(label0);
        // label0.setBounds(150, 15, 200, 46);//alinhando o texto




        JLabel opcao1 = new JLabel(" 1 - FirefoxDriver: ");
        // add(label1);
        //  label1.setBounds(150, 40, 200, 46);//alinhando a escrita


        JLabel opcao2 = new JLabel(" 2 - ChromeDriver:  ");
        // add(label2);
        // label2.setBounds(150, 60, 250, 46);//alinhando a escrita , segundo parametro distancia da linha

        JLabel opcao3 = new JLabel(" 3 - SafariDriver:  ");
        // add(label3);
        //  label3.setBounds(150, 80, 300, 46);

        JLabel opcao4 = new JLabel(" 4 - OperaDriver:  ");
        //  add(label4);
        //  label4.setBounds(150, 100, 350, 46);






        //caixa de texto com tamanho especificado
        JTextField texto = new JTextField(10);
        // add(texto);
        //  texto.setBounds(100, 160, 170, 20);//alinhando o texto ,quarto paramentro largura


        // Declarando um botão
        JButton teste = new JButton("Gerar Teste");

        // add(bt1);
        //bt1.setBounds(100, 200, 100, 15);//alinhando o botão 

        cp = getContentPane();
        main.setLayout(layout);

        main.add(label0);
        layout.putConstraint(SpringLayout.NORTH, label0, 30, SpringLayout.NORTH, main);

        layout.putConstraint(SpringLayout.WEST, label0, 160, SpringLayout.WEST, main);

        main.add(opcao1);
        layout.putConstraint(SpringLayout.NORTH, opcao1, 50, SpringLayout.NORTH, main);
        layout.putConstraint(SpringLayout.WEST, opcao1, 160, SpringLayout.WEST, main);

        main.add(opcao2);
        layout.putConstraint(SpringLayout.BASELINE, opcao2, 90, SpringLayout.BASELINE, main);
        layout.putConstraint(SpringLayout.WEST, opcao2, 160, SpringLayout.WEST, main);

        main.add(opcao3);
        layout.putConstraint(SpringLayout.BASELINE, opcao3, 120, SpringLayout.BASELINE, main);
        layout.putConstraint(SpringLayout.WEST, opcao3, 160, SpringLayout.WEST, main);

        main.add(opcao4);
        layout.putConstraint(SpringLayout.BASELINE, opcao4, 150, SpringLayout.BASELINE, main);
        layout.putConstraint(SpringLayout.WEST, opcao4, 160, SpringLayout.WEST, main);

        main.add(texto);
        layout.putConstraint(SpringLayout.NORTH, texto, 180, SpringLayout.NORTH, main);
        layout.putConstraint(SpringLayout.WEST, texto, 165, SpringLayout.WEST, main);
        int textoDigitado=1;
        
        // Tentando pegar a opção escolhida
       // Integer.toString(textoDigitado) ;
        //textoDigitado = texto.getText();
        //System.out.println(textoDigitado);
        /*int driverDeTeste = 1;
         switch (driverDeTeste) {
             case 1:
                 System.out.println(" oiii");
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
        }*/
              
        
        main.add(teste);
        layout.putConstraint(SpringLayout.NORTH, teste, 230, SpringLayout.NORTH, main);
        layout.putConstraint(SpringLayout.WEST, teste, 165, SpringLayout.WEST, main);

        cp.add(main);

        this.setSize(500, 350);// tamanho da janela
        this.setLocation(200, 200); // localização da janela
        this.setVisible(true);// tornar a janela visível
         /*setDefaultCloseOperation defini o que fazer quando
         * a janela for fechada:
         * EXIT_ON_CLOSE finaliza o aplicativo
         * DISPOSE_ON_CLOSE devolve os recursos ao sistema
         * HIDE_ON_CLOSE oculta a janela
         * DO_NOTHING_ON_CLOSE usuário indica se a janela será fechada*/
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }

    public static void main(String[] args) throws Exception {

        //Declaramos o visual do nosso frame
        JFrame.setDefaultLookAndFeelDecorated(true);
        //instancia um objeto do tipo JFrame
        Janela minhaJanela = new Janela();


      /*  int driverDeTeste = 1;

        switch (driverDeTeste) {
            case 1:

                ViagemPageTest teste = new ViagemPageTest();
                teste.inicializa();
                teste.deveCadastrarUmaNovaViagem();
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
        }*/

    }
}

