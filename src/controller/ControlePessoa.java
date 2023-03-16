package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.TelaPessoa;
import view.TelaPrincipal;

/**
 *
 * @author gabriel
 */
public class ControlePessoa implements ActionListener{ 
//  implementa actionLIstener
    
    //atributo
    private TelaPessoa telaPessoa;
    
    public ControlePessoa() { 
        telaPessoa = new TelaPessoa(null, true); //true = nao consegue clicar na tela de trás
        telaPessoa.getjButtonCadastrar().addActionListener(this); //comeca a escutar o botao cadastrar
        telaPessoa.getjButtonLimpar().addActionListener(this); //comeca a escutar o botao limpar
        telaPessoa.setVisible(true);
    }

    ControlePessoa(TelaPrincipal telaPrincipal) { //recebe uma classe telaPrincipal como argumento para se referir no parent
        telaPessoa = new TelaPessoa(telaPrincipal, true); //true = nao consegue clicar na tela de trás
        telaPessoa.getjButtonCadastrar().addActionListener(this); //comeca a escutar o botao cadastrar
        telaPessoa.getjButtonLimpar().addActionListener(this); //comeca a escutar o botao limpar
        telaPessoa.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //sera executado caso haja um evento
        if (ae.getSource().equals(telaPessoa.getjButtonLimpar())) {
            limpar();
        
        } else if (ae.getSource().equals(telaPessoa.getjButtonCadastrar())) {
            cadastrar();
            
        }
    }

    private void limpar() {
        
        int ok = JOptionPane.showConfirmDialog(telaPessoa, "Limpar os campos?");
        if (ok == 0) {
            //limpa os campos de textfield na tela
            telaPessoa.getjTextFieldCPF().setText("");
            telaPessoa.getjTextFieldEndereco().setText("");
            telaPessoa.getjTextFieldNome().setText("");
            telaPessoa.getjTextFieldTelefone().setText("");

        } else if (ok == 1) {
            int ok2 = JOptionPane.showConfirmDialog(telaPessoa, "Tem certeza mesmo?");
            if (ok2 == 0) {
                JOptionPane.showMessageDialog(telaPessoa, "SIIIIIIIIIIIIIIIIIIIIIIIIII");
            } else if ( ok2 == 1) {
                JOptionPane.showMessageDialog(telaPessoa, "SIIIIIIIIIIIIIIIIIIIIIIIIII");
            } else {
                JOptionPane.showMessageDialog(telaPessoa, "SIIIIIIIIIIIIIIIIIIIIIIIIII");
            }
        } else {
            JOptionPane.showMessageDialog(telaPessoa, "SIIIIIIIIIIIIIIIIIIIIIIIIII");
        }
        
        
    }

    private void cadastrar() {
        
    }
    
}
