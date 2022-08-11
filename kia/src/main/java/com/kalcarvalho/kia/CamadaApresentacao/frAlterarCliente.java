package CamadaApresentacao;

import Controladoras.CtrAlterarCliente;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class frAlterarCliente extends JFrame {

  protected ValidarCampo vc;
  private CtrAlterarCliente cac;
  private boolean ativa;
  Vector tmpCli, tmpEnd, tmpTel;
  int indice1Tel; //controlar a troca de telefones na tela
  int indice2Tel; //guarda o indice do tel
  int indice0End;
  int indice1End;
  int indice2End; //guarda indice de endereco
  int indice3End;
  int indice4End;
  int indice5End;
  int indice6End;
  int indice7End;
  int idEnd;
  String cnpj;

  JPanel jPanel1 = new JPanel();
  JComboBox jComboBox1;
  JLabel jLCliente = new JLabel();
  Border border1;
  JPanel jPanel2 = new JPanel();
  Border border2;
  JTextField tfInscEstadual = new JTextField();
  JLabel jlInscEstadual = new JLabel();
  JTextField tfNomeFantasia = new JTextField();
  JLabel jlNomeFantasia = new JLabel();
  JTextField tfCNPJ = new JTextField();
  JLabel lbCNPJ = new JLabel();
  JTextField tfRazaoSocial = new JTextField();
  JLabel lbRazaoSocial = new JLabel();
  JPanel jPanel3 = new JPanel();
  Border border3;
  JTextField tfEmail = new JTextField();
  JLabel lbEstado = new JLabel();
  JLabel lbCep = new JLabel();
  JLabel lbCidade = new JLabel();
  JTextField TFcep = new JTextField();
  JTextField tfBairro = new JTextField();
  JLabel lbBairro = new JLabel();
  JLabel jlEndereco = new JLabel();
  JTextField tfCidade = new JTextField();
  JTextField tfEndereco = new JTextField();
  JButton btOutroEndereco = new JButton();
  JLabel lbEmail = new JLabel();
  JTextField tfNumero = new JTextField();
  JLabel lbNumero = new JLabel();
  JPanel jPanel4 = new JPanel();
  Border border4;
  JLabel lbTelefone = new JLabel();
  JButton btOutroTel = new JButton();
  JTextField tfTelefone = new JTextField();
  JTextField tfFax = new JTextField();
  JLabel lbFax = new JLabel();
  JPanel jPanel5 = new JPanel();
  Border border5;
  JButton btAlterar = new JButton();
  JButton btLimpar = new JButton();
  JButton jBtSair = new JButton();
  JTextField tfEstado = new JTextField();

  public frAlterarCliente() throws HeadlessException {
    ativa = false;
    indice1Tel = 0;
    indice2Tel = 1;
    indice0End = 0;
    indice1End = 1;
    indice2End = 2;
    indice3End = 3;
    indice4End = 4;
    indice5End = 5;
    indice6End = 6;
    indice7End = 7;

    try {
      jbInit();
      this.formatWindow();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    vc = new ValidarCampo();
    cac = new CtrAlterarCliente();
    border1 =
      new EtchedBorder(
        EtchedBorder.RAISED,
        Color.white,
        new Color(165, 163, 151)
      );
    border2 =
      new EtchedBorder(
        EtchedBorder.RAISED,
        Color.white,
        new Color(165, 163, 151)
      );
    border3 =
      new EtchedBorder(
        EtchedBorder.RAISED,
        Color.white,
        new Color(165, 163, 151)
      );
    border4 =
      new EtchedBorder(
        EtchedBorder.RAISED,
        Color.white,
        new Color(165, 163, 151)
      );
    border5 =
      new EtchedBorder(
        EtchedBorder.RAISED,
        Color.white,
        new Color(165, 163, 151)
      );
    this.setEnabled(true);
    this.setResizable(false);
    this.setSize(new Dimension(507, 410));
    this.setState(Frame.NORMAL);
    this.setTitle("Alterar Cliente");
    this.getContentPane().setLayout(null);
    jPanel1.setBorder(border1);
    jPanel1.setBounds(new Rectangle(1, 1, 497, 52));
    jPanel1.setLayout(null);
    jComboBox1 = new JComboBox(cac.preencherCliente());
    jComboBox1.setBounds(new Rectangle(148, 18, 208, 21));
    jComboBox1.addActionListener(
      new frAlterarCliente_jComboBox1_actionAdapter(this)
    );
    jLCliente.setFont(new java.awt.Font("SansSerif", 1, 13));
    jLCliente.setRequestFocusEnabled(true);
    jLCliente.setText("Selecione Cliente:");
    jLCliente.setBounds(new Rectangle(17, 21, 126, 15));
    jPanel2.setBorder(border2);
    jPanel2.setBounds(new Rectangle(2, 54, 497, 101));
    jPanel2.setLayout(null);
    tfInscEstadual.setBackground(SystemColor.text);
    tfInscEstadual.setEnabled(false);
    tfInscEstadual.setText("");
    tfInscEstadual.setBounds(new Rectangle(338, 67, 145, 21));
    tfInscEstadual.addKeyListener(
      new frAlterarCliente_tfInscEstadual_keyAdapter(this)
    );
    jlInscEstadual.setText("Insc. Estadual:");
    jlInscEstadual.setBounds(new Rectangle(255, 71, 75, 15));
    tfNomeFantasia.setBounds(new Rectangle(90, 37, 393, 21));
    tfNomeFantasia.addKeyListener(
      new frAlterarCliente_tfNomeFantasia_keyAdapter(this)
    );
    tfNomeFantasia.setAlignmentX((float) 0.5);
    tfNomeFantasia.setBackground(SystemColor.text);
    tfNomeFantasia.setEnabled(false);
    tfNomeFantasia.setText("");
    jlNomeFantasia.setText("Nome Fantasia:");
    jlNomeFantasia.setBounds(new Rectangle(10, 39, 80, 15));
    tfCNPJ.setBackground(SystemColor.text);
    tfCNPJ.setEnabled(false);
    tfCNPJ.setText("");
    tfCNPJ.setBounds(new Rectangle(90, 67, 142, 21));
    tfCNPJ.addKeyListener(new frAlterarCliente_tfCNPJ_keyAdapter(this));
    lbCNPJ.setText("C.N.P.J.:");
    lbCNPJ.setBounds(new Rectangle(40, 71, 50, 15));
    tfRazaoSocial.setBackground(SystemColor.text);
    tfRazaoSocial.setEnabled(false);
    tfRazaoSocial.setText("");
    tfRazaoSocial.setBounds(new Rectangle(90, 11, 393, 21));
    tfRazaoSocial.addKeyListener(
      new frAlterarCliente_tfRazaoSocial_keyAdapter(this)
    );
    lbRazaoSocial.setText("Raz㯠Social:");
    lbRazaoSocial.setBounds(new Rectangle(17, 14, 72, 15));
    jPanel3.setBorder(border3);
    jPanel3.setBounds(new Rectangle(2, 156, 497, 132));
    jPanel3.setLayout(null);
    tfEmail.setBackground(SystemColor.text);
    tfEmail.setEnabled(false);
    tfEmail.setText("");
    tfEmail.setBounds(new Rectangle(88, 102, 272, 21));
    tfEmail.addKeyListener(new frAlterarCliente_tfEmail_keyAdapter(this));
    lbEstado.setText("Estado:");
    lbEstado.setBounds(new Rectangle(381, 74, 44, 15));
    lbCep.setText("CEP:");
    lbCep.setBounds(new Rectangle(384, 46, 27, 15));
    lbCidade.setText("Cidade:");
    lbCidade.setBounds(new Rectangle(42, 76, 47, 15));
    TFcep.setBackground(SystemColor.text);
    TFcep.setEnabled(false);
    TFcep.setText("");
    TFcep.setBounds(new Rectangle(411, 42, 70, 21));
    TFcep.addKeyListener(new frAlterarCliente_TFcep_keyAdapter(this));
    tfBairro.setBackground(SystemColor.text);
    tfBairro.setEnabled(false);
    tfBairro.setText("");
    tfBairro.setBounds(new Rectangle(185, 43, 174, 21));
    tfBairro.addKeyListener(new frAlterarCliente_tfBairro_keyAdapter(this));
    lbBairro.setText("Bairro:");
    lbBairro.setBounds(new Rectangle(150, 45, 34, 15));
    jlEndereco.setText("Endere篺");
    jlEndereco.setBounds(new Rectangle(32, 16, 58, 15));
    tfCidade.setBackground(SystemColor.text);
    tfCidade.setEnabled(false);
    tfCidade.setText("");
    tfCidade.setBounds(new Rectangle(88, 73, 208, 21));
    tfCidade.addKeyListener(new frAlterarCliente_tfCidade_keyAdapter(this));
    tfEndereco.setBackground(SystemColor.text);
    tfEndereco.setEnabled(false);
    tfEndereco.setSelectionStart(0);
    tfEndereco.setText("");
    tfEndereco.setBounds(new Rectangle(89, 13, 393, 21));
    tfEndereco.addKeyListener(new frAlterarCliente_tfEndereco_keyAdapter(this));
    btOutroEndereco.setBounds(new Rectangle(393, 99, 87, 25));
    btOutroEndereco.setEnabled(false);
    btOutroEndereco.setSelected(false);
    btOutroEndereco.setToolTipText("clique aqui para alterar outro endereço");
    btOutroEndereco.setText("Outro End.");
    btOutroEndereco.addActionListener(
      new frAlterarCliente_btOutroEndereco_actionAdapter(this)
    );
    lbEmail.setText("E-mail:");
    lbEmail.setBounds(new Rectangle(42, 106, 34, 15));
    tfNumero.setBackground(SystemColor.text);
    tfNumero.setEnabled(false);
    tfNumero.setText("");
    tfNumero.setBounds(new Rectangle(88, 42, 45, 21));
    tfNumero.addKeyListener(new frAlterarCliente_tfNumero_keyAdapter(this));
    lbNumero.setText("Número:");
    lbNumero.setBounds(new Rectangle(37, 44, 44, 15));
    jPanel4.setBorder(border4);
    jPanel4.setBounds(new Rectangle(2, 290, 497, 42));
    jPanel4.setLayout(null);
    lbTelefone.setText("Telefone:");
    lbTelefone.setBounds(new Rectangle(22, 14, 52, 15));
    btOutroTel.setBounds(new Rectangle(394, 10, 84, 25));
    btOutroTel.setEnabled(false);
    btOutroTel.setToolTipText("clique aqui para alterar outro telefone");
    btOutroTel.setVerifyInputWhenFocusTarget(true);
    btOutroTel.setText("Outro Tel.");
    btOutroTel.addActionListener(
      new frAlterarCliente_btOutroTel_actionAdapter(this)
    );
    tfTelefone.setBackground(SystemColor.text);
    tfTelefone.setEnabled(false);
    tfTelefone.setText("");
    tfTelefone.setBounds(new Rectangle(77, 11, 111, 21));
    tfTelefone.addKeyListener(new frAlterarCliente_tfTelefone_keyAdapter(this));
    tfFax.setBackground(SystemColor.text);
    tfFax.setEnabled(false);
    tfFax.setText("");
    tfFax.setBounds(new Rectangle(240, 12, 134, 21));
    tfFax.addKeyListener(new frAlterarCliente_tfFax_keyAdapter(this));
    lbFax.setText("Fax:");
    lbFax.setBounds(new Rectangle(202, 14, 34, 15));
    jPanel5.setBorder(border5);
    jPanel5.setBounds(new Rectangle(3, 333, 497, 43));
    jPanel5.setLayout(null);
    btAlterar.setBounds(new Rectangle(74, 9, 73, 25));
    btAlterar.setEnabled(false);
    btAlterar.setToolTipText("");
    btAlterar.setText("Alterar");
    btAlterar.addActionListener(
      new frAlterarCliente_btAlterar_actionAdapter(this)
    );
    btLimpar.setBounds(new Rectangle(201, 10, 73, 25));
    btLimpar.setEnabled(false);
    btLimpar.setToolTipText("");
    btLimpar.setText("Limpar");
    btLimpar.addActionListener(
      new frAlterarCliente_btLimpar_actionAdapter(this)
    );
    jBtSair.setBounds(new Rectangle(327, 10, 73, 25));
    jBtSair.setToolTipText("");
    jBtSair.setText("Sair");
    jBtSair.addActionListener(new frAlterarCliente_jBtSair_actionAdapter(this));
    tfEstado.setBackground(SystemColor.text);
    tfEstado.setEnabled(false);
    tfEstado.setText("");
    tfEstado.setBounds(new Rectangle(424, 70, 57, 21));
    tfEstado.addKeyListener(new frAlterarCliente_tfEstado_keyAdapter(this));
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(jLCliente, null);
    jPanel1.add(jComboBox1, null);
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(tfNomeFantasia, null);
    jPanel2.add(lbRazaoSocial, null);
    jPanel2.add(tfRazaoSocial, null);
    jPanel2.add(jlNomeFantasia, null);
    jPanel2.add(lbCNPJ, null);
    jPanel2.add(tfCNPJ, null);
    jPanel2.add(jlInscEstadual, null);
    jPanel2.add(tfInscEstadual, null);
    this.getContentPane().add(jPanel3, null);
    jPanel3.add(lbBairro, null);
    jPanel3.add(jlEndereco, null);
    jPanel3.add(tfEndereco, null);
    jPanel3.add(lbNumero, null);
    jPanel3.add(tfNumero, null);
    jPanel3.add(tfBairro, null);
    jPanel3.add(lbCep, null);
    jPanel3.add(TFcep, null);
    jPanel3.add(lbCidade, null);
    jPanel3.add(tfCidade, null);
    jPanel3.add(lbEstado, null);
    jPanel3.add(lbEmail, null);
    jPanel3.add(tfEmail, null);
    jPanel3.add(btOutroEndereco, null);
    jPanel3.add(tfEstado, null);
    this.getContentPane().add(jPanel4, null);
    jPanel4.add(tfTelefone, null);
    jPanel4.add(lbTelefone, null);
    jPanel4.add(lbFax, null);
    jPanel4.add(tfFax, null);
    jPanel4.add(btOutroTel, null);
    this.getContentPane().add(jPanel5, null);
    jPanel5.add(btLimpar, null);
    jPanel5.add(btAlterar, null);
    jPanel5.add(jBtSair, null);
  }

  public void formatWindow() {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = this.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    this.setLocation(
        (screenSize.width - frameSize.width) / 2,
        (screenSize.height - frameSize.height) / 2
      );
    this.setVisible(true);
  }

  //*Esse m鴯do serve pra informar se o usuᲩo entrou com algum dado dado na tela*/
  void tfRazaoSocial_keyPressed(KeyEvent e) {
    //     ativa = true;
  }

  void jComboBox1_actionPerformed(ActionEvent e) {
    tmpCli = new Vector();
    tmpEnd = new Vector();
    tmpTel = new Vector();
    tmpCli.removeAllElements();
    tmpEnd.removeAllElements();
    tmpTel.removeAllElements();
    String razaoSocial = (String) jComboBox1.getSelectedItem();
    tfCNPJ.setEnabled(true);
    tfRazaoSocial.setEnabled(true);
    tfInscEstadual.setEnabled(true);
    tfNomeFantasia.setEnabled(true);
    tfEndereco.setEnabled(true);
    tfBairro.setEnabled(true);
    tfCidade.setEnabled(true);
    TFcep.setEnabled(true);
    tfNumero.setEnabled(true);
    tfEmail.setEnabled(true);
    tfEstado.setEnabled(true);
    tfTelefone.setEnabled(true);
    tfFax.setEnabled(true);
    btLimpar.setEnabled(true);
    btAlterar.setEnabled(true);
    btOutroEndereco.setEnabled(true);
    btOutroTel.setEnabled(true);
    cnpj = cac.selecionarCliente(razaoSocial); //recebe o id de cliente

    //*preenche dados fornecedor*/
    tmpCli = cac.preencherTelaCliente(cnpj);
    try {
      tfCNPJ.setText((String) tmpCli.get(0));
      tfRazaoSocial.setText((String) tmpCli.get(1));
      tfInscEstadual.setText((String) tmpCli.get(2));
      tfNomeFantasia.setText((String) tmpCli.get(3));
    } catch (ArrayIndexOutOfBoundsException ex2) {
      JOptionPane.showMessageDialog(
        null,
        "N㯠Existem Clientes Cadastrados",
        "Consulta de Cliente",
        JOptionPane.ERROR_MESSAGE
      );
    }

    //*preenche endereco tela*/
    tmpEnd = cac.outroEnd(cnpj);
    tmpEnd.trimToSize();
    try {
      idEnd = Integer.parseInt((String) tmpEnd.get(0)); //id endereco (int)
      tfEndereco.setText((String) tmpEnd.get(1));
      tfBairro.setText((String) tmpEnd.get(2));
      tfCidade.setText((String) tmpEnd.get(3));
      tfEstado.setText((String) tmpEnd.get(4));
      TFcep.setText((String) tmpEnd.get(5));
      tfNumero.setText((String) tmpEnd.get(6));
      tfEmail.setText((String) tmpEnd.get(7));
    } catch (ArrayIndexOutOfBoundsException ex1) {
      JOptionPane.showMessageDialog(
        null,
        "N㯠Existem Endere篳 Cadastrados",
        "Consulta de Endereço",
        JOptionPane.ERROR_MESSAGE
      );
      for (int i = 0; i < 8; i++) tmpEnd.addElement("");
    }

    //*preenche tel tela*/
    tmpTel = cac.outroTel(cnpj);
    tmpTel.trimToSize();
    try {
      tfTelefone.setText((String) tmpTel.get(0));
      tfFax.setText((String) tmpTel.get(1));
    } catch (ArrayIndexOutOfBoundsException ex) {
      JOptionPane.showMessageDialog(
        null,
        "N㯠Existem Telefones Cadastrados",
        "Consulta de Telefone",
        JOptionPane.INFORMATION_MESSAGE
      );

      tmpTel.addElement("");
      tmpTel.addElement("");
      tfTelefone.setText((String) tmpTel.get(0));
      tfFax.setText((String) tmpTel.get(1));
    }
  }

  void btOutroEndereco_actionPerformed(ActionEvent e) {
    if (indice7End + 1 < tmpEnd.size()) {
      indice0End += 8;
      indice1End += 8;
      indice2End += 8;
      indice3End += 8;
      indice4End += 8;
      indice5End += 8;
      indice6End += 8;
      indice7End += 8;
      idEnd = Integer.parseInt((String) tmpEnd.get(indice0End));
      tfEndereco.setText((String) tmpEnd.get(indice1End));
      tfBairro.setText((String) tmpEnd.get(indice2End));
      tfCidade.setText((String) tmpEnd.get(indice3End));
      tfEstado.setText((String) tmpEnd.get(indice4End));
      TFcep.setText((String) tmpEnd.get(indice5End));
      tfNumero.setText((String) tmpEnd.get(indice6End));
      tfEmail.setText((String) tmpEnd.get(indice7End));
    } else {
      JOptionPane.showMessageDialog(
        null,
        "N㯠Existem Outros Endere篳 Cadastrados",
        "Consulta de Endereço",
        JOptionPane.INFORMATION_MESSAGE
      );

      indice0End = 0;
      indice1End = 1;
      indice2End = 2;
      indice3End = 3;
      indice4End = 4;
      indice5End = 5;
      indice6End = 6;
      indice7End = 7;
      idEnd = Integer.parseInt((String) tmpEnd.get(indice0End));
      tfEndereco.setText((String) tmpEnd.get(indice1End));
      tfBairro.setText((String) tmpEnd.get(indice2End));
      tfCidade.setText((String) tmpEnd.get(indice3End));
      tfEstado.setText((String) tmpEnd.get(indice4End));
      TFcep.setText((String) tmpEnd.get(indice5End));
      tfNumero.setText((String) tmpEnd.get(indice6End));
      tfEmail.setText((String) tmpEnd.get(indice7End));
    }
  }

  void btOutroTel_actionPerformed(ActionEvent e) {
    if (indice2Tel + 1 < tmpTel.size()) {
      indice1Tel += 2;
      indice2Tel += 2;
      tfTelefone.setText((String) tmpTel.get(indice1Tel));
      tfFax.setText((String) tmpTel.get(indice2Tel));
    } else {
      JOptionPane.showMessageDialog(
        null,
        "N㯠Existem Outros Telefones Cadastrados",
        "Consulta de Telefone",
        JOptionPane.INFORMATION_MESSAGE
      );

      indice1Tel = 0;
      indice2Tel = 1;
      tfTelefone.setText((String) tmpTel.get(indice1Tel));
      tfFax.setText((String) tmpTel.get(indice2Tel));
    }
  }

  void btLimpar_actionPerformed(ActionEvent e) {
    this.limpar();
  }

  public void limpar() {
    tfCNPJ.setText("");
    tfRazaoSocial.setText("");
    tfInscEstadual.setText("");
    tfNomeFantasia.setText("");
    tfEndereco.setText("");
    tfBairro.setText("");
    tfCidade.setText("");
    TFcep.setText("");
    tfNumero.setText("");
    tfEmail.setText("");
    tfEstado.setText("");
    tfTelefone.setText("");
    tfFax.setText("");
  }

  void jBtSair_actionPerformed(ActionEvent e) {
    if (ativa) {
      Object opt[] = { "Sim", "Não" };
      int result = JOptionPane.showOptionDialog(
        this,
        "Deseja Realmente Sair, Qualquer Altera磯 N㯠Ter᠅feito",
        "Altera磯 de Cliente",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        opt,
        opt[0]
      );
      if (result == JOptionPane.YES_OPTION) {
        try {
          cac.destrutor();
          this.finalize();
          this.setVisible(false);
        } catch (Throwable ex) {
          ex.printStackTrace();
        }
      }
    } else {
      this.setVisible(false);
      try {
        cac.destrutor();
        this.finalize();
      } catch (Throwable ex1) {
        ex1.printStackTrace();
      }
    }
  }

  void tfNomeFantasia_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfEndereco_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfTelefone_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void btAlterar_actionPerformed(ActionEvent e) {
    //obs. empresa n㯠pode alterar cnpj, solu磯 fazer outro cadastro
    //valida磯 de campos - classe ValidarCampo
    if (
      !vc.valNulo(tfRazaoSocial.getText(), "Razão Social") ||
      !vc.valNulo(tfInscEstadual.getText(), "Inscrição Estadual") ||
      !vc.valNulo(tfNomeFantasia.getText(), "Nome Fantasia") ||
      !vc.valNulo(tfEndereco.getText(), "Endereço") ||
      !vc.valNulo(tfBairro.getText(), "Bairro") ||
      !vc.valNulo(tfCidade.getText(), "Cidade") ||
      !vc.valNulo(tfEstado.getText(), "Estado") ||
      !vc.valNulo(tfTelefone.getText(), "Telefone")
    ) return;

    cac.alterarCliente(
      cnpj,
      tfRazaoSocial.getText(),
      tfInscEstadual.getText(),
      tfNomeFantasia.getText(),
      idEnd,
      tfEndereco.getText(),
      tfBairro.getText(),
      tfCidade.getText(),
      tfEstado.getText(),
      TFcep.getText(),
      tfNumero.getText(),
      tfEmail.getText(),
      (String) tmpTel.get(indice1Tel),
      tfTelefone.getText(),
      tfFax.getText()
    );

    JOptionPane.showMessageDialog(
      null,
      "Altera磯 Efetuada com Sucesso!",
      "Altera磯 de Cliente",
      JOptionPane.INFORMATION_MESSAGE
    );
    try {
      this.finalize();
      new frAlterarCliente();
      this.setVisible(false);
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
  }

  void tfCNPJ_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfInscEstadual_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfNumero_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfBairro_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void TFcep_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfCidade_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfEstado_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfEmail_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfFax_keyPressed(KeyEvent e) {
    ativa = true;
  }
}

class frAlterarCliente_tfRazaoSocial_keyAdapter
  extends java.awt.event.KeyAdapter {

  frAlterarCliente adaptee;

  frAlterarCliente_tfRazaoSocial_keyAdapter(frAlterarCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfRazaoSocial_keyPressed(e);
  }
}

class frAlterarCliente_jComboBox1_actionAdapter
  implements java.awt.event.ActionListener {

  frAlterarCliente adaptee;

  frAlterarCliente_jComboBox1_actionAdapter(frAlterarCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.jComboBox1_actionPerformed(e);
  }
}

class frAlterarCliente_btOutroEndereco_actionAdapter
  implements java.awt.event.ActionListener {

  frAlterarCliente adaptee;

  frAlterarCliente_btOutroEndereco_actionAdapter(frAlterarCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btOutroEndereco_actionPerformed(e);
  }
}

class frAlterarCliente_btOutroTel_actionAdapter
  implements java.awt.event.ActionListener {

  frAlterarCliente adaptee;

  frAlterarCliente_btOutroTel_actionAdapter(frAlterarCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btOutroTel_actionPerformed(e);
  }
}

class frAlterarCliente_btLimpar_actionAdapter
  implements java.awt.event.ActionListener {

  frAlterarCliente adaptee;

  frAlterarCliente_btLimpar_actionAdapter(frAlterarCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btLimpar_actionPerformed(e);
  }
}

class frAlterarCliente_jBtSair_actionAdapter
  implements java.awt.event.ActionListener {

  frAlterarCliente adaptee;

  frAlterarCliente_jBtSair_actionAdapter(frAlterarCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.jBtSair_actionPerformed(e);
  }
}

class frAlterarCliente_tfNomeFantasia_keyAdapter
  extends java.awt.event.KeyAdapter {

  frAlterarCliente adaptee;

  frAlterarCliente_tfNomeFantasia_keyAdapter(frAlterarCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfNomeFantasia_keyPressed(e);
  }
}

class frAlterarCliente_tfEndereco_keyAdapter extends java.awt.event.KeyAdapter {

  frAlterarCliente adaptee;

  frAlterarCliente_tfEndereco_keyAdapter(frAlterarCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfEndereco_keyPressed(e);
  }
}

class frAlterarCliente_tfTelefone_keyAdapter extends java.awt.event.KeyAdapter {

  frAlterarCliente adaptee;

  frAlterarCliente_tfTelefone_keyAdapter(frAlterarCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfTelefone_keyPressed(e);
  }
}

class frAlterarCliente_btAlterar_actionAdapter
  implements java.awt.event.ActionListener {

  frAlterarCliente adaptee;

  frAlterarCliente_btAlterar_actionAdapter(frAlterarCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btAlterar_actionPerformed(e);
  }
}

class frAlterarCliente_tfCNPJ_keyAdapter extends java.awt.event.KeyAdapter {

  frAlterarCliente adaptee;

  frAlterarCliente_tfCNPJ_keyAdapter(frAlterarCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfCNPJ_keyPressed(e);
  }
}

class frAlterarCliente_tfInscEstadual_keyAdapter
  extends java.awt.event.KeyAdapter {

  frAlterarCliente adaptee;

  frAlterarCliente_tfInscEstadual_keyAdapter(frAlterarCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfInscEstadual_keyPressed(e);
  }
}

class frAlterarCliente_tfNumero_keyAdapter extends java.awt.event.KeyAdapter {

  frAlterarCliente adaptee;

  frAlterarCliente_tfNumero_keyAdapter(frAlterarCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfNumero_keyPressed(e);
  }
}

class frAlterarCliente_tfBairro_keyAdapter extends java.awt.event.KeyAdapter {

  frAlterarCliente adaptee;

  frAlterarCliente_tfBairro_keyAdapter(frAlterarCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfBairro_keyPressed(e);
  }
}

class frAlterarCliente_TFcep_keyAdapter extends java.awt.event.KeyAdapter {

  frAlterarCliente adaptee;

  frAlterarCliente_TFcep_keyAdapter(frAlterarCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.TFcep_keyPressed(e);
  }
}

class frAlterarCliente_tfCidade_keyAdapter extends java.awt.event.KeyAdapter {

  frAlterarCliente adaptee;

  frAlterarCliente_tfCidade_keyAdapter(frAlterarCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfCidade_keyPressed(e);
  }
}

class frAlterarCliente_tfEstado_keyAdapter extends java.awt.event.KeyAdapter {

  frAlterarCliente adaptee;

  frAlterarCliente_tfEstado_keyAdapter(frAlterarCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfEstado_keyPressed(e);
  }
}

class frAlterarCliente_tfEmail_keyAdapter extends java.awt.event.KeyAdapter {

  frAlterarCliente adaptee;

  frAlterarCliente_tfEmail_keyAdapter(frAlterarCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfEmail_keyPressed(e);
  }
}

class frAlterarCliente_tfFax_keyAdapter extends java.awt.event.KeyAdapter {

  frAlterarCliente adaptee;

  frAlterarCliente_tfFax_keyAdapter(frAlterarCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfFax_keyPressed(e);
  }
}
