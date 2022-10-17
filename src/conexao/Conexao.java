/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author renan
 */
public class Conexao {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/cadastros";
    private static final String USER = "root";
    private static final String PASS = "123456";

    /**
     * Faz a conexão com o Banco de Dados
     *
     * @return
     */
    public static Connection getConexao() {

        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na conexão: ", ex);
        }
    }

    /**
     * Fecha a Conexão com o Banco
     *
     * @param con
     */
    public static void closeConexao(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Fecha o Statement e a Conexão com o Banco
     *
     * @param con
     * @param stmt
     */
    public static void closeConexao(Connection con, PreparedStatement stmt) {

        closeConexao(con);
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Fecha a Statement, ResultSet e a Conexão com o Banco
     *
     * @param con
     * @param stmt
     * @param rs
     */
    public static void closeConexao(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConexao(con, stmt);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
