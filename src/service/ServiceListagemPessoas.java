package service;

import java.util.ArrayList;
import model.Pessoa;
import model.PessoaDAO;
import view.TelaListagemPessoas;

/**
 *
 * @author gabriel
 */
public class ServiceListagemPessoas {
    //contém os métodos da telaListagemPessoas
    
    //atributos
    private TelaListagemPessoas telaListagemPessoas;
    private PessoaDAO pessoaDAO;
    private ArrayList<Pessoa> lista;
    
    
    //construtor
    public ServiceListagemPessoas(TelaListagemPessoas telaListagemPessoas) {
        this.telaListagemPessoas = telaListagemPessoas;
        this.pessoaDAO = new PessoaDAO();
        this.lista = new ArrayList<>();
    }
    
    public void listar(){ //adiciona as pessoas do banco a uma ArrayList
        lista = this.pessoaDAO.listar();
        preencherTabela();
    }
    
    public void preencherTabela(){
        limparTabela(); //refresh
        for (int i=0; i<lista.size(); i++) {
            telaListagemPessoas.getDefaultTableModel().addRow(
                new Object[]{lista.get(i).getNome(),
                             lista.get(i).getEndereco(),
                             lista.get(i).getTelefone(),
                             lista.get(i).getCpf()});
        }
    }
    
    public void limparTabela(){
        int linhas = telaListagemPessoas.getDefaultTableModel().getRowCount();
        for (int i=0; i<linhas; i++) {
            telaListagemPessoas.getDefaultTableModel().removeRow(0);
            //sempre remove a linha 0
        }
    }
    
    public void novo(){
    
    }
    
    public void editar(){
    
    }
    
    public void excluir(){
    
    }
    
}
