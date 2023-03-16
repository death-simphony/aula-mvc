package service;
import controller.ControlePrincipal;
import javax.swing.JOptionPane;
import model.Usuario;
import model.UsuarioDAO;
import view.TelaLogin;

/**
 *
 * @author gabriel
 */
public class ServiceLogin { //a classe serve para oferecer serviços a outras classes
    
    //instancia a tela e o dao
    private TelaLogin telaLogin;
    private UsuarioDAO usuarioDAO;
    
    public ServiceLogin(TelaLogin tela) { //service gerencia a tela e o DAO
        this.telaLogin = tela;
        this.usuarioDAO = new UsuarioDAO();
    }
    
    public void entrar() {
        String usuario = telaLogin.getjTextFieldLogin().getText();
        String senha = String.valueOf(telaLogin.getjPasswordFieldSenha().getPassword());;
        
        Usuario usuarioLogin = usuarioDAO.acesso(usuario, senha);
        
        if (usuarioLogin.getId() > 0) {
            telaLogin.dispose(); //fecha a janela
            ControlePrincipal cp = new ControlePrincipal();
        } else {
            JOptionPane.showMessageDialog(telaLogin, "Usuário ou Senha incorretos!");
        }
    }
    
}
