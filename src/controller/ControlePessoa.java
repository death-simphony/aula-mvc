package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import service.ServicePessoa;
import view.TelaListagemPessoas;
import view.TelaPessoa;

/**
 *
 * @author gabriel
 */
public class ControlePessoa implements ActionListener{ 
//  implementa actionLIstener
    
    //atributo
    private TelaPessoa telaPessoa;
    ServicePessoa servicePessoa;
    
    public ControlePessoa(TelaListagemPessoas telaListagemPessoas, boolean newEdit) { //recebe uma classe telaPrincipal como argumento para se referir no parent
        telaPessoa = new TelaPessoa(telaListagemPessoas, true); //true = nao consegue clicar na tela de trás
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
            
            String nome = telaPessoa.getjTextFieldNome().getText();
            String endereco = telaPessoa.getjTextFieldEndereco().getText();
            String telefone = telaPessoa.getjTextFieldTelefone().getText();
            long cpf = Long.parseLong(telaPessoa.getjTextFieldCPF().getText());
            
            servicePessoa.cadastrar(nome, endereco, telefone, cpf);
         
            System.out.println("ola mundo");
            
        }
    }

}
