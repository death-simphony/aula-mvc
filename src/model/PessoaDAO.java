package model;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author gabriel
 */
public class PessoaDAO {

    public void inserir(Pessoa pessoa) { //inserir objeto pessoa no BD
        
        String insertSQL = "INSERT INTO pessoa (nome, endereço, telefone, cpf) values (?,?,?,?)";
        Pessoa pessoaObj = pessoa;
        PreparedStatement pst;
        
        try {
            pst = Conexao.getConexao().prepareStatement(insertSQL);
            pst.setString(1, pessoaObj.getNome());
            pst.setString(2, pessoaObj.getEndereco());
            pst.setString(3, pessoaObj.getTelefone());
            pst.setLong(4, pessoaObj.getCpf());
            
            pst.execute(); //executa a query
            pst.close();
            
            JOptionPane.showMessageDialog(null, "Sucesso!");
            System.out.println("sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados");
            System.out.println(ex);
        
        }
    
    }

    public ArrayList<Pessoa> listar(){ //retorna uma lista no formato ArrayList
        String sql = "SELECT * FROM pessoa ORDER BY nome";  //query
        
        ArrayList<Pessoa> lista = new ArrayList<>(); //objeto arraylist
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
                Pessoa p = new Pessoa();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setEndereco(rs.getString("endereço"));
                p.setTelefone(rs.getString("telefone"));
                p.setCpf(rs.getLong("cpf"));
                lista.add(p);
            }
            
            pst.close();
            rs.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a listagem!");
            System.out.println(e);
        }
        return lista;
        
    }
    
    public boolean excluir(int primaryKey) {
        String sql = "DELETE FROM pessoa WHERE id = ?";
        PreparedStatement pst;
        
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, primaryKey);
            pst.execute();
            pst.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir!");
            System.out.println(e);
            return false;
        }
        
        return true;
        
    }
    
}
