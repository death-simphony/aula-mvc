package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaPrincipal;

/**
 *
 * @author gabriel
 */
public class ControlePrincipal implements ActionListener {

    //instanciar telaPrincipal
    private TelaPrincipal telaPrincipal;

    public ControlePrincipal() {
        telaPrincipal = new TelaPrincipal();
        telaPrincipal.getjMenuItemPessoa().addActionListener(this);
        telaPrincipal.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(telaPrincipal.getjMenuItemPessoa())) {
            //instancia a tela de cadastro caso clique no botao pessoa no menu bar
            ControlePessoa controlePessoa = new ControlePessoa(telaPrincipal);
        }
    }
    
}
