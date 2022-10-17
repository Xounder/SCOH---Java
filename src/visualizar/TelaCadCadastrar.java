/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualizar;

import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import modelos.CadPessoas;
import modelos.Digitadores;
import modelos.banco.CadPessoasBanco;

/**
 *
 * @author renan
 */
public class TelaCadCadastrar extends javax.swing.JInternalFrame {

    private int idDigitador;
    private CadPessoas cadastro;
    private boolean att;
    private int contadorLaudo = 0;

    /**
     * Creates new form TelaCadastrar
     */
    public TelaCadCadastrar() {
        initComponents();
    }

    public TelaCadCadastrar(int id) {
        initComponents();
        this.idDigitador = id;
        jContadorLaudo.setVisible(false);
        jAtualizar.setVisible(false);

        //Pega a borda atual e adiciona o nome nela
        Border linBorda = jPanel5.getBorder();
        TitledBorder titBorda;
        titBorda = BorderFactory.createTitledBorder(linBorda, "Cadastrar Dados");
        jPanel5.setBorder(titBorda);
    }

    public TelaCadCadastrar(CadPessoas cp, boolean atualizar) {
        initComponents();
        this.cadastro = cp;
        this.att = atualizar;

        setTitle("Cadastro: " + cp.getNome());
        //Pega a borda atual e adiciona o nome nela
        Border linBorda = jPanel5.getBorder();
        TitledBorder titBorda;
        if (atualizar) {
            titBorda = BorderFactory.createTitledBorder(linBorda, "Atualizar Cadastro");
        } else {
            titBorda = BorderFactory.createTitledBorder(linBorda, "Visualizar Cadastro");
        }
        jPanel5.setBorder(titBorda);

        jNome.setText(cp.getNome());
        jNascimento.setText(cp.getNascimento());
        if (cp.getSexo().equals("M")) {
            jSexoM.setSelected(true);
        } else {
            jSexoF.setSelected(true);
        }
        jCnsCpf.setText(cp.getCns());
        jLaudo.setText(cp.getLaudo());

        if (cp.getAtendimentodthr() != null) {
            String atendDtHr = cp.getAtendimentodthr();
            String newData = atendDtHr.substring(8, 10) + "/" + atendDtHr.substring(5, 7) + "/" + atendDtHr.substring(0, 4);
            String newHora = atendDtHr.substring(11);
            jAtendimentoDt.setText(newData);
            jAtendimentoHr.setText(newHora);
        }

        if (att) {
            jCadastrar.setVisible(false);
        } else {
            jNome.setEnabled(false);
            jNascimento.setEnabled(false);
            jSexoM.setEnabled(false);
            jSexoF.setEnabled(false);
            jCnsCpf.setEnabled(false);
            jLaudo.setEnabled(false);
            jAtendimentoDt.setEnabled(false);
            jAtendimentoHr.setEnabled(false);
            jContadorLaudo.setVisible(false);
            jAtualizar.setVisible(false);
            jCadastrar.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jNome = new javax.swing.JTextField();
        jNascimento = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jSexoM = new javax.swing.JCheckBox();
        jSexoF = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jAtendimentoDt = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jAtendimentoHr = new javax.swing.JFormattedTextField();
        jCadastrar = new javax.swing.JButton();
        jAtualizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLaudo = new javax.swing.JTextArea();
        jCnsCpf = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jContadorLaudo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Cadastro");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Nome*");

        jLabel2.setText("Nascimento*");

        try {
            jNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jNascimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jNascimentoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jNascimentoKeyReleased(evt);
            }
        });

        jLabel4.setText("Sexo*");

        jSexoM.setText("M");
        jSexoM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSexoMActionPerformed(evt);
            }
        });

        jSexoF.setText("F");
        jSexoF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSexoFActionPerformed(evt);
            }
        });

        jLabel5.setText("Motivo do Atendimento/Laudo*");

        jLabel6.setText("Atendimento:");

        try {
            jAtendimentoDt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jAtendimentoDt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAtendimentoDtActionPerformed(evt);
            }
        });
        jAtendimentoDt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jAtendimentoDtKeyPressed(evt);
            }
        });

        jLabel7.setText("Data");

        jLabel8.setText("Hora");

        try {
            jAtendimentoHr.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jAtendimentoHr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jAtendimentoHrKeyPressed(evt);
            }
        });

        jCadastrar.setText("Cadastrar");
        jCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCadastrarActionPerformed(evt);
            }
        });

        jAtualizar.setText("Atualizar");
        jAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAtualizarActionPerformed(evt);
            }
        });

        jLaudo.setColumns(5);
        jLaudo.setLineWrap(true);
        jLaudo.setRows(5);
        jLaudo.setTabSize(5);
        jLaudo.setMaximumSize(new java.awt.Dimension(270, 270));
        jLaudo.setName(""); // NOI18N
        jLaudo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLaudoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jLaudoKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jLaudo);

        jLabel9.setText("CNS/CPF*");

        jContadorLaudo.setText("(0)");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jContadorLaudo)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jNome, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2))
                        .addComponent(jLabel5)))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSexoM)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSexoF)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jCnsCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jAtendimentoDt, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addGap(10, 10, 10)
                                .addComponent(jAtendimentoHr, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jAtualizar)
                                .addGap(43, 43, 43)
                                .addComponent(jCadastrar)))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSexoM)
                    .addComponent(jSexoF)
                    .addComponent(jCnsCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jAtendimentoHr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jAtendimentoDt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCadastrar)
                            .addComponent(jAtualizar))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jContadorLaudo)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 64, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSexoMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSexoMActionPerformed
        // TODO add your handling code here:
        if (jSexoF.isSelected()) {
            jSexoF.setSelected(false);
        }
    }//GEN-LAST:event_jSexoMActionPerformed

    private void jSexoFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSexoFActionPerformed
        // TODO add your handling code here:
        if (jSexoM.isSelected()) {
            jSexoM.setSelected(false);
        }
    }//GEN-LAST:event_jSexoFActionPerformed

    /**
     * Verifica se tudo que foi digitado nas caixas de texto está nos conformes
     * do banco
     *
     * @return
     */
    private boolean checkCaixas() {
        String cnsOrCpf = jCnsCpf.getText().trim();
        String txtnome = jNome.getText().trim();

        if (txtnome.equals("")) {
            JOptionPane.showMessageDialog(this, "O Nome do paciente deve ser preenchido.", "Aviso",
                    JOptionPane.WARNING_MESSAGE);
        } else if (txtnome.matches("\\D+") == false) {     //verificar se o txtnome é somente letras
            JOptionPane.showMessageDialog(this, "O campo Nome não pode conter números ou símbolo.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } else if (txtnome.equals("Admin")) {
            JOptionPane.showMessageDialog(this, "O campo Nome não pode ser este", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } else if (txtnome.length() > 45) {
            JOptionPane.showMessageDialog(this, "O Nome do paciente não pode conter muitos caracteres.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } else if (jNascimento.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(this, "A data de Nascimento do paciente deve ser preenchida.", "Aviso",
                    JOptionPane.WARNING_MESSAGE);
        } else if (jSexoM.isSelected() == false && jSexoF.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "É necessário informar o Sexo do paciente.", "Aviso",
                    JOptionPane.WARNING_MESSAGE);
        } else if (cnsOrCpf.equals("")) {
            JOptionPane.showMessageDialog(this, "O campo CNS/CPF do paciente deve ser preenchido.", "Aviso",
                    JOptionPane.WARNING_MESSAGE);
        } else if (cnsOrCpf.matches("\\d+") == false) {   //verifica se o rg é somente números
            JOptionPane.showMessageDialog(this, "O campo CNS/CPF só pode conter números.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } else if (cnsOrCpf.length() != 15 & cnsOrCpf.length() != 9) {
            JOptionPane.showMessageDialog(this, "Preencha o campo com o CNS (15 dígitos) ou com o CPF (9 dígitos) do "
                    + "paciente.", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else if (jLaudo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "O campo Motivo do Atendimento/Laudo deve ser preenchido",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
        } else if ((jAtendimentoDt.getText().equals("  /  /    ") && !"  :  :  ".equals(jAtendimentoHr.getText()))
                || (!"  /  /    ".equals(jAtendimentoDt.getText()) && jAtendimentoHr.getText().equals("  :  :  "))) {
            JOptionPane.showMessageDialog(this, "O campo Data e Hora devem ser preenchidos juntos.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            return true;
        }

        return false;
    }

    /**
     * Pega os dados da ficha (nome, nascimento, sexo, cns/cpf, laudo, data e *
     * hora do atendimento e coloca formatado, pro banco, em um objeto
     * CadPessoas
     *
     * @return
     */
    private CadPessoas getFormatedCadPessoas() {
        Digitadores digi = new Digitadores();
        CadPessoas cdp = new CadPessoas();
        String newNasc = jNascimento.getText();
        String data = jAtendimentoDt.getText();
        String newHora = jAtendimentoHr.getText();
        String newData;
        String atendDataHr;

        cdp.setNome(jNome.getText().trim());
        cdp.setNascimento(newNasc.substring(6, 10) + "-" + newNasc.substring(3, 5) + "-" + newNasc.substring(0, 2));   // modificar a data para o formato do banco
        cdp.setSexo(jSexoM.isSelected() ? "M" : "F");
        cdp.setCns(jCnsCpf.getText());
        cdp.setLaudo(jLaudo.getText().trim());
        if (!"  /  /    ".equals(data)) {
            newData = data.substring(6, 10) + "-" + data.substring(3, 5) + "-" + data.substring(0, 2);
            atendDataHr = newData + " " + newHora;
        } else {
            atendDataHr = null;
        }
        cdp.setAtendimentodthr(atendDataHr);
        digi.setId(idDigitador);
        cdp.setDigitadores(digi);
        return cdp;
    }

    /**
     * Insere ou Atualiza o cadastro com as informações dadas
     *
     * @param id
     */
    private void inserirOrAttCad(int id) {
        if (checkCaixas()) {
            CadPessoas cp;
            CadPessoasBanco cpb = new CadPessoasBanco();
            cp = getFormatedCadPessoas();

            if (cpb.validarCnsOrCpf(id, cp.getCns())) {
                cpb = new CadPessoasBanco();    //instanciar um novo objeto desta classe
                if (att) {
                    cp.setId(cadastro.getId());
                    if (cpb.atualizar(cp)) {
                        JOptionPane.showMessageDialog(this, "A ficha do paciente foi atualizada com sucesso.");
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Erro ao atualizar a ficha do paciente.", "Erro",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    if (cpb.inserir(cp)) {
                        JOptionPane.showMessageDialog(this, "A ficha do paciente foi cadastrada com sucesso.");
                        jNome.setText("");
                        jNascimento.setText("");
                        jSexoM.setSelected(false);
                        jSexoF.setSelected(false);
                        jCnsCpf.setText("");
                        jLaudo.setText("");
                        jAtendimentoDt.setText("");
                        jAtendimentoHr.setText("");
                        jContadorLaudo.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(this, "Erro ao cadastrar a ficha do paciente.", "Erro",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "O CNS ou CPF informado já existe.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private void jCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCadastrarActionPerformed
        // TODO add your handling code here:
        inserirOrAttCad(-1);    //não possui id ainda
    }//GEN-LAST:event_jCadastrarActionPerformed
    
    /**
     * Coloca o valor de dígitos que a caixa jLaudo possui ao apertar uma tecla
     *
     * @param jCampo
     * @param jContador
     * @param contador
     * @param evt
     * @param pressReleas
     * @return
     */
    private int setJContador(javax.swing.JTextArea jCampo, javax.swing.JLabel jContador, int contador, int evt,
            String pressReleas) {
        jContador.setVisible(true);
        //Faz a quantidade de caracteres aparecer na tela
        if (pressReleas.equals("Press")) {
            contador = TelaLogin.contadorTexto(jCampo.getText(), contador, evt, KeyEvent.VK_BACK_SPACE);
        } else {
            contador = jCampo.getText().length();
        }
        jContador.setText("(" + contador + ")");
        return contador;
    }

    private void jLaudoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLaudoKeyPressed
        // TODO add your handling code here        
        contadorLaudo = setJContador(jLaudo, jContadorLaudo, contadorLaudo, evt.getKeyCode(), "Press");
    }//GEN-LAST:event_jLaudoKeyPressed

    private void jAtendimentoDtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAtendimentoDtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jAtendimentoDtActionPerformed

    private void jLaudoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLaudoKeyReleased
        // TODO add your handling code here
        contadorLaudo = setJContador(jLaudo, jContadorLaudo, contadorLaudo, evt.getKeyCode(), "Released");
    }//GEN-LAST:event_jLaudoKeyReleased

    private void jNascimentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jNascimentoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jNascimentoKeyReleased

    private void jAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAtualizarActionPerformed
        // TODO add your handling code here:
        inserirOrAttCad(cadastro.getId());
    }//GEN-LAST:event_jAtualizarActionPerformed
   /**
    * Apaga os campos que JFormattedTextField ao apertar back_space ou delete
    * @param jCampo
    * @param evt 
    */
    public static void apagarJFormatted(javax.swing.JFormattedTextField jCampo, int evt) {
        if (evt == KeyEvent.VK_DELETE || evt == KeyEvent.VK_BACK_SPACE) {
            if (jCampo.getValue() != null) {   //Quando tinha texto ele ficava pra sempre
                jCampo.setValue(null);
            }
        }
    }
    private void jAtendimentoDtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jAtendimentoDtKeyPressed
        // TODO add your handling code here:
        apagarJFormatted(jAtendimentoDt, evt.getKeyCode());
    }//GEN-LAST:event_jAtendimentoDtKeyPressed

    private void jAtendimentoHrKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jAtendimentoHrKeyPressed
        // TODO add your handling code here:
        apagarJFormatted(jAtendimentoHr, evt.getKeyCode());
    }//GEN-LAST:event_jAtendimentoHrKeyPressed

    private void jNascimentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jNascimentoKeyPressed
        // TODO add your handling code here:
        apagarJFormatted(jNascimento, evt.getKeyCode());
    }//GEN-LAST:event_jNascimentoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField jAtendimentoDt;
    private javax.swing.JFormattedTextField jAtendimentoHr;
    private javax.swing.JButton jAtualizar;
    private javax.swing.JButton jCadastrar;
    private javax.swing.JTextField jCnsCpf;
    private javax.swing.JLabel jContadorLaudo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextArea jLaudo;
    private javax.swing.JFormattedTextField jNascimento;
    private javax.swing.JTextField jNome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JCheckBox jSexoF;
    private javax.swing.JCheckBox jSexoM;
    // End of variables declaration//GEN-END:variables
}
