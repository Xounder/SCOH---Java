/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.banco;

import java.util.ArrayList;
import java.util.List;
import modelos.Digitadores;
import org.junit.Test;
import static org.junit.Assert.*;
import static sun.security.jgss.GSSUtil.login;

/**
 *
 * @author renan
 */
public class DigitadoresBancoTest {

    public DigitadoresBancoTest() {
    }

    /*@Test
    @Ignore
    public void insert() {
        Digitadores digi = new Digitadores("Julia Nascimento", "1999-10-05", "F", "123456789", "12345678911", "98988287575", "Rua dos Logradouros", "", "");
        DigitadoresBanco db = new DigitadoresBanco();
        if (db.inserir(digi)) {
            System.out.println("Inserido com sucesso");
        }else{
            fail("Erro ao inserir no banco");
        }
    }*/
 /*@Test
    public void update() {
        Digitadores digi = new Digitadores("Alberto Einsten", "1977-07-15", "M", "123456789", "12345676611", "98988285575", "Rua dos SHEHEHEM", "", "");
        digi.setId(4);
        DigitadoresBanco db = new DigitadoresBanco();
        if (db.atualizar(digi)) {
            System.out.println("atualizado com sucesso");
        } else {
            fail("Erro ao atualizar no banco");
        }*/
    /*@Test
    public void search() {
        //List<Digitadores> digi;
        DigitadoresBanco db = new DigitadoresBanco();
        //digi = db.procurarEspecificoDigit();
        
        for (Digitadores d : db.procurarEspecificoDigit()) {
                System.out.println("id: " + d.getId() + " Nome: " + d.getNome() + " Nascimento: " + d.getNascimento() + " Sexo: " + d.getSexo() + " Contato: " + d.getContato());
                System.out.printf("Id: %s Nome: %s Nascimento: %s Sexo: %s Contato: %s\n", d.getId(),d.getNome(), d.getNascimento(), d.getSexo(), d. getContato());
        }
    }*/
    /*@Test
    public void deletar(){
        Digitadores digi = new Digitadores();
        digi.setId(8);
        DigitadoresBanco db = new DigitadoresBanco();
        if(db.deletar(digi)){
            System.out.println("Deletado com sucesso");
        }else{
            fail("Erro ao deletar");
        }
    }*/
    @Test
    public void cpfFind(){
        Digitadores digi = new Digitadores();
        digi.setId(9);
        digi.setPin("8765431");
        DigitadoresBanco db = new DigitadoresBanco();
        if (db.validarPin(digi.getPin(), digi.getId())){
            System.out.println("SIm");
        }else{
            fail("nao");
        }
    }
}
