package inserir.viagem;

import javax.swing.*;
import java.awt.*;

public class JanelaFrame extends JFrame {

     JLabel label1;
    JLabel label2;
    JLabel label4;
    //Definindo um container
    public JanelaFrame() {
       

        
       
       
         label1 = new JLabel("Menu para escolha de driver p/ ser usado em testes de integração:"); //texto no construtor
        this.setContentPane(label1); //define um container para o JFrame
        label2 = new JLabel("Digite 1 - para FirefoxDriver: " + 
                            "\nDigite 2 - para ChromeDriver:" + 
                            "\nDigite 3 - para SafariDriver:" + 
                            "\nDigite 4 - para OperaDriver:" + JLabel.CENTER);//texto com posição definida
        label4 = new JLabel("Rótulo 4", JLabel.CENTER);
         //define um container para o JFrame
        Container pane2 = this.getContentPane(); //captura o painel do JFrame
        pane2.setLayout(new GridLayout(4, 1)); //define o layout do painel
        pane2.add(label1);
        pane2.add(label2);
        pane2.add(label4);
        
        setTitle(" Bem vindo para a escolha do Driver : "); //Define titulo p/ janela
         //Assim como os componentes são adicionados ao content pane, 
        //é o background do content pane que deve ser setado
        setBackground(Color.WHITE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
   // Montando uma interface com o JLabel.

    public static void main(String[] args) {




//instancia um objeto do tip o JFrame
        JFrame janela = new JFrame("Minha Primeira Janela");
        JPanel painel = new JPanel();
        janela.add(painel);
       
        
    }
}
