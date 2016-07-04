package inserir.viagem;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.*;


/* Esta classe cria painéis na nossa janela , 
 * este painel sera uma caixa de texto 
 */
public class Painel extends JPanel {
    
    

    JLabel label2;
    //caixa de texto com tamanho especificado
    JTextField texto1 = new JTextField(10);

    public Painel() {
                 

        label2 = new JLabel("Digite 1 - para FirefoxDriver: " + "Digite 2 - para ChromeDriver:"
                + "Digite 3 - para SafariDriver:" + "Digite 4 - para OperaDriver:",
                JLabel.LEFT);//texto com posição definida
    
    }
}
