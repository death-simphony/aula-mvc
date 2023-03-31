package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import view.TelaLogin;
import service.ServiceLogin;

/**
 *
 * @author gabriel
 */
public class ControleLogin implements ActionListener, KeyListener{
    private TelaLogin telaLogin;
    private ServiceLogin serviceLogin;
    
    public ControleLogin() {
        telaLogin = new TelaLogin(null, true);
        serviceLogin = new ServiceLogin(telaLogin);
        telaLogin.getjButtonEntrar().addActionListener(this);
        telaLogin.getjTextFieldLogin().addKeyListener(this);
        telaLogin.getjPasswordFieldSenha().addKeyListener(this);
        telaLogin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(telaLogin.getjButtonEntrar())) {
            serviceLogin.entrar();
        }
    }
    
    
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
            serviceLogin.entrar();
        }  
    }
        
    @Override
    public void keyReleased(KeyEvent ke) {
    }

}
