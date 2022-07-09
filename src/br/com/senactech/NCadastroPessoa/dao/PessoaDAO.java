/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.NCadastroPessoa.dao;
import br.com.senactech.NCadastroPessoa.conexao.Conexao;
import br.com.senactech.NCadastroPessoa.modelDAO.Pessoa;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet; //vai receber o resultado de um select
import java.util.ArrayList;
/**
 *
 * @author Marcia
 */
public class PessoaDAO {
    public void cadastrarPessoa(Pessoa pVO) throws SQLException{
        //buscar conexao do bd
        
        Connection con = Conexao.getConexao();
        //cria espaço de trabalho sql, é a area no java onde vamos executar os scripts sql
        
        Statement sta = con.createStatement();
        
        try{
          String sql;
          sql = "insert into pessoa values(null, '" + pVO.getNomePessoa() + "', '"
                  + pVO.getCpf() + "', '" + pVO.getEndereco() + "', '"
          +pVO.getTelefone()+ ");";
          //e ai executa no bd o sql criado acima
          sta.execute(sql);
        } catch (SQLException e){
            throw new SQLException("Erro ao inserir pessoa!" + e.getMessage());
            //tratou um possivel erro
        } finally {
            con.close();
            sta.close(); //fecha tudo depois, para evitar invasões
        }
    }
    
    public ArrayList<Pessoa> listarPessoas() throws SQLException{
        Connection con = Conexao.getConexao();
        //cria espaço de trabalho sql, é a area no java onde vamos executar os scripts sql
        
        Statement sta = con.createStatement();
        
        try {
           String sql;
           sql = "select * from pessoa";
           ResultSet rs = sta.executeQuery(sql);
           ArrayList<Pessoa> pessoas = new ArrayList();
           while (rs.next()){
               Pessoa p = new Pessoa();
               //lado java /x/ lado banco
               p.setIdPessoa(rs.getInt("idPessoa"));
               p.setNomePessoa(rs.getString("nomePessoa"));
               p.setCpf(rs.getString("Cpf"));
               p.setEndereco(rs.getString("endereco"));
               //popula o arraylist
               pessoas.add(p);
               
           } return pessoas;
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar pessoas!" + e.getMessage());
        } finally {
           con.close();
           sta.close();
        }
    }
}
