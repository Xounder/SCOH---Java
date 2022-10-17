/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.banco;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Digitadores;

/**
 * CRUD (Create, read, update, delete)
 *
 * @author renan
 */
public class DigitadoresBanco {

    private Connection con = null;
    private int digiUsoId;
    private String digiUsoNome;

    public DigitadoresBanco() {
        con = Conexao.getConexao();
    }

    public int getDigiUsoId() {
        return digiUsoId;
    }

    public void setDigiUsoId(int digiUsoId) {
        this.digiUsoId = digiUsoId;
    }

    public String getDigiUsoNome() {
        return digiUsoNome;
    }

    public void setDigiUsoNome(String digiUsoNome) {
        this.digiUsoNome = digiUsoNome;
    }

    /**
     * Insere no banco um Digitador cadastrado com as suas respectivas
     * informações
     *
     * @param digitadores
     * @return
     */
    public boolean inserir(Digitadores digitadores) {
        String sql = "INSERT INTO digitadores (nome, nascimento, sexo, rg, cpf, contato, endereco, login, senha) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";

        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, digitadores.getNome());
            stmt.setString(2, digitadores.getNascimento());
            stmt.setString(3, digitadores.getSexo());
            stmt.setString(4, digitadores.getRg());
            stmt.setString(5, digitadores.getCpf());
            stmt.setString(6, digitadores.getContato());
            stmt.setString(7, digitadores.getEndereco());
            if (digitadores.getNome().equals("Admin")) {
                stmt.setString(8, "admin");
                stmt.setString(9, "");
            } else {
                stmt.setString(8, digitadores.getCpf());
                stmt.setString(9, digitadores.getCpf());
            }
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DigitadoresBanco.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            Conexao.closeConexao(con, stmt);
        }

    }

    /**
     * Atualiza os dados de um Digitador
     *
     * @param digitadores
     * @return
     */
    public boolean atualizar(Digitadores digitadores) {
        String sql = "UPDATE digitadores SET nome=?, nascimento=?, sexo=?, rg=?, cpf=?, contato=?, endereco=? WHERE id=?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, digitadores.getNome());
            stmt.setString(2, digitadores.getNascimento());
            stmt.setString(3, digitadores.getSexo());
            stmt.setString(4, digitadores.getRg());
            stmt.setString(5, digitadores.getCpf());
            stmt.setString(6, digitadores.getContato());
            stmt.setString(7, digitadores.getEndereco());
            stmt.setInt(8, digitadores.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DigitadoresBanco.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            Conexao.closeConexao(con, stmt);
        }
    }

    /**
     * Busca tudo dos Digitadores
     *
     * @return
     */
    public List<Digitadores> procurar() {
        String sql = "SELECT * FROM digitadores";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Digitadores> digitadores = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Digitadores digi = new Digitadores();
                digi.setId(rs.getInt("id"));
                digi.setNome(rs.getString("nome"));
                digi.setNascimento(rs.getString("nascimento"));
                digi.setSexo(rs.getString("sexo"));
                digi.setRg(rs.getString("rg"));
                digi.setCpf(rs.getString("cpf"));
                digi.setContato(rs.getString("contato"));
                digi.setEndereco(rs.getString("endereco"));
                digitadores.add(digi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DigitadoresBanco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConexao(con, stmt, rs);
        }

        return digitadores;
    }

    /**
     * Busca tudo de um Digitador específico
     *
     * @param id
     * @return
     */
    public List<Digitadores> procurarEspecificoDigit(int id) {     //Seleciona tudo de um id específico
        String sql = "SELECT * FROM digitadores WHERE id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Digitadores> digitadores = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Digitadores digi = new Digitadores();
                digi.setNome(rs.getString("nome"));
                digi.setNascimento(rs.getString("nascimento"));
                digi.setSexo(rs.getString("sexo"));
                digi.setRg(rs.getString("rg"));
                digi.setCpf(rs.getString("cpf"));
                digi.setContato(rs.getString("contato"));
                digi.setEndereco(rs.getString("endereco"));
                digi.setLogin(rs.getString("login"));
                digi.setSenha(rs.getString("senha"));
                digi.setPin(rs.getString("pin"));
                digitadores.add(digi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DigitadoresBanco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConexao(con, stmt, rs);
        }

        return digitadores;
    }

    /**
     * Deleta primeiramente os registros e depois deleta o Digitador da tabela
     * Digitadores
     *
     * @param digitadores
     * @return
     */
    public boolean deletar(Digitadores digitadores) {
        String sql = "DELETE FROM digitadores WHERE id = ?";

        PreparedStatement stmt = null;
        DigitadoresBanco db = new DigitadoresBanco();
        //tem que deletar os registros primeiro, pois há uma conexão entre as tabelas
        if (db.deletarRegistros(digitadores)) {
            try {
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, digitadores.getId());
                stmt.executeUpdate();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(DigitadoresBanco.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            } finally {
                Conexao.closeConexao(con, stmt);
            }
        } else {
            return false;
        }
    }

    /**
     * Deleta os todos os registros do Digitador informado
     *
     * @param digitadores
     * @return
     */
    private boolean deletarRegistros(Digitadores digitadores) {
        String sql = "DELETE FROM cad_pessoas WHERE digitadores_id = ?;";

        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, digitadores.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DigitadoresBanco.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            Conexao.closeConexao(con, stmt);
        }
    }

    /**
     * Passa todos os registros de um Digitador para o Administrador
     *
     * @param digitadores
     * @param adm
     * @return
     */
    public boolean passarRegistros(Digitadores digitadores, Digitadores adm) {
        String sql = "UPDATE cad_pessoas SET digitadores_id = ? WHERE digitadores_id  = ?;";

        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, adm.getId());
            stmt.setInt(2, digitadores.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DigitadoresBanco.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            Conexao.closeConexao(con, stmt);
        }
    }

    /**
     * Verifica se Login e Senha informados estão corretos
     *
     * @param digitadores
     * @param adm
     * @return
     */
    public boolean validarConta(Digitadores digitadores, boolean adm) {
        String sql = "SELECT id, nome, login, senha FROM digitadores";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                if (adm) {
                    if (rs.getString("nome").equals("Admin")) { // Para que somente o  
                        if (rs.getString("login").equals(digitadores.getLogin()) //admin possa acessar a sua área
                                && rs.getString("senha").equals(digitadores.getSenha())) {

                            //armazena o id e nome do digitador atual
                            digiUsoId = rs.getInt("id");
                            digiUsoNome = rs.getString("nome");
                            check = true;
                            break;
                        }
                    }
                } else if (!"Admin".equals(rs.getString("nome"))) {
                    if (rs.getString("login").equals(digitadores.getLogin())
                            && rs.getString("senha").equals(digitadores.getSenha())) {

                        digiUsoId = rs.getInt("id");
                        digiUsoNome = rs.getString("nome");
                        check = true;
                        break;
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DigitadoresBanco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConexao(con, stmt, rs);
        }

        return check;
    }

    /**
     * Verifica se o Login está certo para fazer a recuperação da conta
     *
     * @param log
     * @return
     */
    public boolean validarLogin(String log) {
        String sql = "SELECT login FROM digitadores";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("login").equals(log)) {
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DigitadoresBanco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConexao(con, stmt, rs);
        }
        return true;
    }

    /**
     * Busca nome e id do Digitador ou Admin se o login informado for igual ao
     * login que está no banco
     *
     * @param log
     * @return
     */
    public String buscaNomeId(String log) {
        String sql = "SELECT id, nome, login FROM digitadores";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("login").equals(log)) {
                    return "" + rs.getInt("id") + "/" + rs.getString("nome");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DigitadoresBanco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConexao(con, stmt, rs);
        }
        return "-1/";
    }

    /**
     * Verifica se o Cpf e o Rg informados existem
     *
     * @param id
     * @param cpf
     * @param rg
     * @return
     */
    public boolean validarCpfRg(int id, String cpf, String rg) {
        String sql = "SELECT id, cpf, rg FROM digitadores";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                if (id != -1) {
                    if (rs.getInt("id") != id && (rs.getString("cpf").equals(cpf) || rs.getString("rg").equals(rg))) {
                        return false;
                    }
                } else {
                    if (rs.getString("cpf").equals(cpf) || rs.getString("rg").equals(rg)) {
                        return false;
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DigitadoresBanco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConexao(con, stmt, rs);
        }
        return true;
    }

//Admin
    /**
     * Verifica se o sistema já possui um Admin
     *
     * @param admin
     * @return
     */
    public boolean verificarAdmin(Digitadores admin) {
        String sql = "SELECT nome FROM digitadores";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        DigitadoresBanco db = new DigitadoresBanco();
        boolean check = false;

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("nome").equals(admin.getNome())) {
                    check = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DigitadoresBanco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConexao(con, stmt, rs);
        }

        return check;
    }

    /**
     * Modifica o primeiro Login e Senha criados do Admin e Digitador - Após a
     * criação da conta
     *
     * @param adm
     * @return
     */
    public boolean atualizarAdm(Digitadores adm) {
        String sql = "UPDATE digitadores SET login=?, senha=?, pin=? WHERE id=?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, adm.getLogin());
            stmt.setString(2, adm.getSenha());
            stmt.setString(3, adm.getPin());
            stmt.setInt(4, adm.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DigitadoresBanco.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            Conexao.closeConexao(con, stmt);
        }
    }

    /**
     * Atualiza a senha do Digitador informado
     *
     * @param adm
     * @return
     */
    //Admin Maybe Digitadores too
    public boolean atualizarSenha(Digitadores adm) {
        String sql = "UPDATE digitadores SET senha=? WHERE id=?";
        PreparedStatement stmt = null;

        DigitadoresBanco db = new DigitadoresBanco();

        if (db.validarPin(adm.getPin(), adm.getId())) { // verifica se o pin informado é igual o que contem no banco
            try {

                stmt = con.prepareStatement(sql);
                stmt.setString(1, adm.getSenha());
                stmt.setInt(2, adm.getId());
                stmt.executeUpdate();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(DigitadoresBanco.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            } finally {
                Conexao.closeConexao(con, stmt);
            }
        } else {
            return false;
        }
    }

    /**
     * Valida o pin do Digitador para poder modificar a senha
     *
     * @param pin
     * @param id
     * @return
     */
    //Admin Maybe Digitadores too
    public boolean validarPin(String pin, int id) {
        String sql = "SELECT pin FROM digitadores WHERE id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return pin.equals(rs.getString("pin"));
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DigitadoresBanco.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            Conexao.closeConexao(con, stmt, rs);
        }

    }

}
