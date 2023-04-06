package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import service.ServiceListagemPessoas;
import view.TelaListagemPessoas;
import view.TelaPrincipal;

/**
 *
 * @author gabriel
 */
public class ControleListaPessoas implements ActionListener, KeyListener {

    private TelaListagemPessoas telaListagemPessoas;
    private ServiceListagemPessoas serviceListagemPessoas;

    public ControleListaPessoas(TelaPrincipal telaPrincipal) {
        telaListagemPessoas = new TelaListagemPessoas(telaPrincipal, true);
        //listeners na tela
        telaListagemPessoas.getjTextFieldPesquisar().addActionListener(this);
        telaListagemPessoas.getjButtonNovo().addActionListener(this);
        telaListagemPessoas.getjButtonEditar().addActionListener(this);
        telaListagemPessoas.getjButtonExcluir().addActionListener(this);
        serviceListagemPessoas = new ServiceListagemPessoas(telaListagemPessoas);
        serviceListagemPessoas.listar();
        telaListagemPessoas.setVisible(true);
    }
    
    
    
    
    
    
    
    
    
    //métodos actionlistener e keylistener
    @Override
    public void actionPerformed(ActionEvent ae) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
}
