package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.TelaLogin;
import service.ServiceLogin;

/**
 *
 * @author gabriel
 */
public class ControleLogin implements ActionListener{
    private TelaLogin telaLogin;
    private ServiceLogin serviceLogin;
    
    public ControleLogin() {
        telaLogin = new TelaLogin(null, true);
        serviceLogin = new ServiceLogin(telaLogin);
        telaLogin.getjButtonEntrar().addActionListener(this);
        telaLogin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(telaLogin.getjButtonEntrar())) {
            serviceLogin.entrar();
            
        }
    }

}
