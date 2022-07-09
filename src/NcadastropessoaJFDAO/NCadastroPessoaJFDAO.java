/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NcadastropessoaJFDAO;

import br.com.senactech.NCadastroPessoa.controllerDAO.CCarro;
import br.com.senactech.NCadastroPessoa.controllerDAO.CPessoa;
import br.com.senactech.NCadastroPessoa.viewDAO.carroCadastro;
import br.com.senactech.NCadastroPessoa.viewDAO.pessoaCadastro;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jairb
 */
public class NCadastroPessoaJFDAO implements ActionListener {

    public static CPessoa cadPessoas = new CPessoa();
    public static CCarro cadCarros = new CCarro();

    //Criar JFrame e seus componentes
    JFrame janela = new JFrame("Menu Principal");
    JPanel painel = new JPanel();
    JButton btnCadPessoa = new JButton("Cad. Pessoas");
    JButton btnCadCarros = new JButton("Cad. Carros");

    private NCadastroPessoaJFDAO() {
        janela.setSize(350, 100);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
        painel.add(btnCadPessoa);
        painel.add(btnCadCarros);
        janela.add(painel);
        janela.setVisible(true);
        btnCadPessoa.addActionListener(this);
        btnCadCarros.addActionListener(this);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        cadPessoas.mokPessoas();
        cadCarros.mokCarro();
        new NCadastroPessoaJFDAO();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCadPessoa) {
            pessoaCadastro pcad = new pessoaCadastro();
            pcad.setVisible(true);
            pcad.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }
        if (e.getSource() == btnCadCarros) {
            carroCadastro cCad = new carroCadastro();
            cCad.setVisible(true);
            cCad.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }
    }

}
