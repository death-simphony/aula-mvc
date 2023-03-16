package model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author gabriel
 */
public class UsuarioDAO {
    
    public Usuario acesso(String login, String senha) {
        //utilizando jdbc
        String sql = "SELECT * FROM user WHERE login = ? AND senha = ?";
        Usuario usuario = new Usuario();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, login);
            pst.setString(2, senha);
            rs = pst.executeQuery();
            
            /*verifica se há retorno na query enquanto verdadeiro*/ 
            while (rs.next()) {
                usuario.setId(rs.getInt("id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setLogin(rs.getString("senha"));
                usuario.setLogin(rs.getString("email"));
            }
            
            rs.close();
            pst.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a conexão com o Banco de Dados");
            System.out.println(ex);
        }
        
        return usuario;
        
    } 
    //explicacao
    /*
        Esse código é um DAO (Data Access Object) para acessar um banco de dados e buscar informações de um usuário com base no login e senha informados.
        A classe possui um método chamado "acesso", que recebe como parâmetros uma string com o login e outra com a senha do usuário. Dentro do método, é definida uma string "sql" com a query SQL a ser executada.
        Em seguida, é criado um objeto do tipo "Usuario" e inicializado com os valores padrão. Em seguida, são definidos os objetos "PreparedStatement" e "ResultSet" para executar a query e obter o resultado.
        A query SQL utiliza placeholders (?) para os valores de login e senha, e em seguida, os valores são definidos usando o método "setString" do objeto PreparedStatement. A query é executada através do método "executeQuery" do objeto PreparedStatement.
        Em seguida, é verificado se a query retornou algum resultado usando um loop "while" que percorre cada linha do resultado. Se houver pelo menos uma linha, os valores da linha são usados para definir as propriedades do objeto "Usuario".
        Por fim, os objetos "PreparedStatement" e "ResultSet" são fechados, e o objeto "Usuario" é retornado. Se houver algum erro durante a execução do método, uma mensagem de erro é exibida em uma caixa de diálogo.
    */
}