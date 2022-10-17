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
import modelos.CadPessoas;
import modelos.Digitadores;

/**
 *
 * @author renan
 */
public class CadPessoasBanco {

    Connection con = null;

    public CadPessoasBanco() {
        con = Conexao.getConexao();
    }

    /**
     * Coloca no banco os dados do paciente cadastrado
     *
     * @param cdp
     * @return
     */
    public boolean inserir(CadPessoas cdp) {
        String sql = "INSERT INTO cad_pessoas (nome, nascimento, sexo, cns, laudo, atendimentodthr, digitadores_id) "
                + "VALUES (?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cdp.getNome());
            stmt.setString(2, cdp.getNascimento());
            stmt.setString(3, cdp.getSexo());
            stmt.setString(4, cdp.getCns());
            stmt.setString(5, cdp.getLaudo());
            stmt.setString(6, cdp.getAtendimentodthr());
            stmt.setInt(7, cdp.getDigitadores().getId());
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
     * Atualiza os dados do paciente cadastrado
     *
     * @param cdp
     * @return
     */
    public boolean atualizar(CadPessoas cdp) {
        String sql = "UPDATE cad_pessoas SET nome=?, nascimento=?, sexo=?, cns=?, laudo=?, atendimentodthr=? WHERE id=?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cdp.getNome());
            stmt.setString(2, cdp.getNascimento());
            stmt.setString(3, cdp.getSexo());
            stmt.setString(4, cdp.getCns());
            stmt.setString(5, cdp.getLaudo());
            stmt.setString(6, cdp.getAtendimentodthr());
            stmt.setInt(7, cdp.getId());
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
     * Busca todos os registros da tabela cad_pessoas
     *
     * @return
     */
    public List<CadPessoas> procurar() {
        String sql = "SELECT * FROM cad_pessoas";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<CadPessoas> cadpessoas = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                CadPessoas cdp = new CadPessoas();
                Digitadores digi = new Digitadores();    //  teste
                cdp.setDigitadores(digi);    //  teste
                
                cdp.setId(rs.getInt("id"));
                cdp.setNome(rs.getString("nome"));
                cdp.setNascimento(rs.getString("nascimento"));
                cdp.setSexo(rs.getString("sexo"));
                cdp.setCns(rs.getString("cns"));
                cdp.setLaudo(rs.getString("laudo"));
                cdp.setAtendimentodthr(rs.getString("atendimentodthr"));
                cdp.getDigitadores().setId(rs.getInt("digitadores_id"));    //  teste
                cadpessoas.add(cdp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DigitadoresBanco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConexao(con, stmt, rs);
        }

        return cadpessoas;
    }

    /**
     * Procura os registros específicos do Digitador e entrega todas as
     * informações do paciente
     *
     * @param digitador
     * @return
     */
    public List<CadPessoas> procurarEspecificoDigit(Digitadores digitador) {
        String sql = "SELECT cad.id, cad.nome, cad.nascimento, cad.sexo, cad.cns, cad.laudo, cad.atendimentodthr "
                + "FROM cad_pessoas cad INNER JOIN digitadores dig ON cad.digitadores_id = ? WHERE dig.id = ?";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<CadPessoas> cadpessoas = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, digitador.getId());
            stmt.setInt(2, digitador.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                CadPessoas cdp = new CadPessoas();
                cdp.setId(rs.getInt("id"));
                cdp.setNome(rs.getString("nome"));
                cdp.setNascimento(rs.getString("nascimento"));
                cdp.setSexo(rs.getString("sexo"));
                cdp.setCns(rs.getString("cns"));
                cdp.setLaudo(rs.getString("laudo"));
                cdp.setAtendimentodthr(rs.getString("atendimentodthr"));
                cadpessoas.add(cdp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DigitadoresBanco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConexao(con, stmt, rs);
        }

        return cadpessoas;
    }

    /**
     * Deleta o registro informado
     *
     * @param cdp
     * @return
     */
    public boolean deletar(CadPessoas cdp) {
        String sql = "DELETE FROM cad_pessoas WHERE id = ?";

        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, cdp.getId());
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
     * Verifica se o Cns/Cpf já existe
     *
     * @param id
     * @param cnsOrCpf
     * @return
     */
    public boolean validarCnsOrCpf(int id, String cnsOrCpf) {
        String sql = "SELECT id, cns FROM cad_pessoas";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                if (id != -1) {     //atualização
                    if (rs.getInt("id") != id && rs.getString("cns").equals(cnsOrCpf)) {
                        return false;
                    }
                } else {    //cadastro
                    if (rs.getString("cns").equals(cnsOrCpf)) {
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
}
