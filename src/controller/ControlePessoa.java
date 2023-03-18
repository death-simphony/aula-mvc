package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import service.ServicePessoa;
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
    ServicePessoa servicePessoa;
    
    public ControlePessoa(TelaPrincipal telaPrincipal) { //recebe uma classe telaPrincipal como argumento para se referir no parent
        telaPessoa = new TelaPessoa(telaPrincipal, true); //true = nao consegue clicar na tela de trás
        servicePessoa = new ServicePessoa(this.telaPessoa); //instancia objeto ServicePessoa
        telaPessoa.getjButtonCadastrar().addActionListener(this); //comeca a escutar o botao cadastrar
        telaPessoa.getjButtonLimpar().addActionListener(this); //comeca a escutar o botao limpar
        telaPessoa.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //sera executado caso haja um evento
        if (ae.getSource().equals(telaPessoa.getjButtonLimpar())) {
            servicePessoa.limpar();
        
        } else if (ae.getSource().equals(telaPessoa.getjButtonCadastrar())) {
            
            System.out.println("ola mundo");
            
            servicePessoa.cadastrar(telaPessoa.getjTextFieldNome().getText(), telaPessoa.getjTextFieldEndereco().getText(), 
                telaPessoa.getjTextFieldTelefone().getText(), Integer.parseInt(telaPessoa.getjTextFieldCPF().getText()));
         
            System.out.println("ola mundo");

            
        }
    }

}
