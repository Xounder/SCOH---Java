/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author renan
 */
public class CadPessoas {

    private int id;
    private String nome;
    private String nascimento;
    private String sexo;
    private String cns;
    private String laudo;
    private String atendimentodthr;
    private Digitadores digitadores; //id_digitadores -- Chave estrangeira

    public CadPessoas() {
    }

    public CadPessoas(String nome, String nascimento, String sexo, String cns, String laudo, String atendimentodthr, Digitadores digitadores) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.cns = cns;
        this.laudo = laudo;
        this.atendimentodthr = atendimentodthr;
        this.digitadores = digitadores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCns() {
        return cns;
    }

    public void setCns(String cns) {
        this.cns = cns;
    }

    public String getLaudo() {
        return laudo;
    }

    public void setLaudo(String laudo) {
        this.laudo = laudo;
    }

    public String getAtendimentodthr() {
        return atendimentodthr;
    }

    public void setAtendimentodthr(String atendimentodthr) {
        this.atendimentodthr = atendimentodthr;
    }

    public Digitadores getDigitadores() {
        return digitadores;
    }

    public void setDigitadores(Digitadores digitadores) {
        this.digitadores = digitadores;
    }
}
