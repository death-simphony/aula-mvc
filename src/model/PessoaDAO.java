package model;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author gabriel
 */
public class PessoaDAO {

    public void inserir(Pessoa pessoa) {
        
        String insertSQL = "INSERT INTO pessoa (nome, endereço, telefone, cpf) values (?,?,?,?)";
        Pessoa pessoaObj = pessoa;
        PreparedStatement pst;
        
        try {
            pst = Conexao.getConexao().prepareStatement(insertSQL);
            pst.setString(1, pessoaObj.getNome());
            pst.setString(2, pessoaObj.getEndereco());
            pst.setString(3, pessoaObj.getTelefone());
            pst.setInt(4, pessoaObj.getCpf());
            
            pst.execute(); //executa a query
            pst.close();
            
            JOptionPane.showMessageDialog(null, "Sucesso!");
            System.out.println("sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados");
            System.out.println(ex);
        
        }
    
    }

}
