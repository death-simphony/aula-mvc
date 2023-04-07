package service;

import controller.ControlePessoa;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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
            telaListagemPessoas.getModel().addRow(
                new Object[]{lista.get(i).getId(),
                             lista.get(i).getNome(),
                             lista.get(i).getEndereco(),
                             lista.get(i).getTelefone(),
                             lista.get(i).getCpf()});
        }
    }
    
    public void limparTabela(){
        int linhas = telaListagemPessoas.getModel().getRowCount();
        for (int i=0; i < linhas; i++) {
            telaListagemPessoas.getModel().removeRow(0);
            //sempre remove a linha 0
        }
    }
    
    public void novo(TelaListagemPessoas tlp){
        boolean newEdit = true;
        ControlePessoa controlePessoa = new ControlePessoa(tlp, newEdit);
        listar();
        
    }
    
    public void editar(TelaListagemPessoas tlp){
        boolean newEdit = false;
        ControlePessoa controlePessoa = new ControlePessoa(tlp, newEdit);
        listar();
        
    }
    
    public void excluir(){
        int linha = telaListagemPessoas.getjTablePessoas().getSelectedRow();
        if (linha >= 0) { // -> verifica se há linha selecionada
            int escolha = JOptionPane.showConfirmDialog(telaListagemPessoas, "Deseja realmente excluir?", "Alerta!", JOptionPane.YES_NO_OPTION);
            switch (escolha) {
                case 0 -> {
                    //int tblRow = Integer.parseInt((String) telaListagemPessoas.getModel().getValueAt(linha, 0));
                    int tblRow = (int) telaListagemPessoas.getModel().getValueAt(linha, 0);
                    if (pessoaDAO.excluir(tblRow)){
                        telaListagemPessoas.getModel().removeRow(linha);
                    } else {
                        JOptionPane.showMessageDialog(telaListagemPessoas, "Não foi possível excluir!",
                                "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(telaListagemPessoas, "Selecione um item na tabela", 
                    "Item não selecionado", JOptionPane.WARNING_MESSAGE);
        }
        
        listar();
        
    }
    
}
