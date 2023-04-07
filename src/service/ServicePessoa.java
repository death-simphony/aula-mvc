package service;
import javax.swing.JOptionPane;
import model.Pessoa;
import model.PessoaDAO;
import view.TelaPessoa;

/**
 *
 * @author gabriel
 */
public class ServicePessoa {
    
    TelaPessoa telaPessoa;
    PessoaDAO pessoaDAO;

    public ServicePessoa(TelaPessoa telaPessoa) {
        this.telaPessoa = telaPessoa;
        this.pessoaDAO = new PessoaDAO();
    }
    
    //vai possuir os metodos que estavam em ControlePessoa
    public void limpar() {
        int ok = JOptionPane.showConfirmDialog(telaPessoa, "Limpar os campos?");
        if (ok == 0) {
            //limpa os campos de textfield na tela
            telaPessoa.getjTextFieldCPF().setText("");
            telaPessoa.getjTextFieldEndereco().setText("");
            telaPessoa.getjTextFieldNome().setText("");
            telaPessoa.getjTextFieldTelefone().setText("");
        }
    }
    
    public void cadastrar(String nome, String endereço, String telefone, long cpf) {
        Pessoa pessoaCad; 
        pessoaCad = new Pessoa(nome, endereço, telefone, cpf);
        System.out.println("ola mundo");
        pessoaDAO.inserir(pessoaCad);
        telaPessoa.dispose();
    }
    
}
