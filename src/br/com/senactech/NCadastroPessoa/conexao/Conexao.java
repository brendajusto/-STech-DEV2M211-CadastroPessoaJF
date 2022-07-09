/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.NCadastroPessoa.conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
/**
 *
 * @author Marcia
 */
public class Conexao {
    //cria constante com endereço do bd e schema
    private static String url = "jdbc:mysql://localhost:3306/devn211";
    //criar uma constante com user do bd
    private static String user = "root";
    //cria uma contante com senha do bd
    private static String pass = "";
    
    public static Connection getConexao() throws SQLException{
       //inicia conexao nula, ainda nao estabelecida
        Connection c = null;
        //com o try tentar estabelecer a conexao
        try {
          c = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e){
            //caso haja alguma falha, entra no catch
            throw new SQLException("Erro ao conectar banco!\n" + e.getMessage()); //mostrando a mensagem de erro que deu
        }
        
        return c;
    }
}
