package CamadaApresentacao;

import Controladoras.CtrCadastrarFornecedor;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class frCadastrarFornecedor extends JDialog {

  //aqui vai a controladora
  private ValidarCampo vc;
  private CtrCadastrarFornecedor ccf;
  private boolean ativa;
  private String cnpj;
  private String rua;
  private String bairro;
  private String cidade;
  private String estado;
  private String cep;
  private String numero;
  private String Email;
  private String telefone;
  private String fax;

  JComboBox cbEstado = new JComboBox(preencherEstado());
  JTextField TFcep = new JTextField();
  JPanel jPanel4 = new JPanel();
  JTextField tfNomeFantasia = new JTextField();
  JTextField tfCNPJ = new JTextField();
  JLabel lbTelefone = new JLabel();
  JTextField tfTelefone = new JTextField();
  JLabel lbNumero = new JLabel();
  JLabel lbRazaoSocial = new JLabel();
  JPanel jPanel3 = new JPanel();
  JLabel lbEstado = new JLabel();
  JLabel lbCep = new JLabel();
  JButton btLimpar = new JButton();
  JTextField tfInscEstadual = new JTextField();
  JLabel lbBairro = new JLabel();
  JLabel jlRVendas = new JLabel();
  JLabel jlEndereco = new JLabel();
  JTextField tfCidade = new JTextField();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel5 = new JPanel();
  JLabel lbCNPJ = new JLabel();
  JTextField tfFax = new JTextField();
  JLabel lbFax = new JLabel();
  JButton btSair = new JButton();
  JTextField tfEmail = new JTextField();
  JLabel lbCidade = new JLabel();
  JLabel jlNomeFantasia = new JLabel();
  JButton btCadastrar = new JButton();
  JTextField tfEndereco = new JTextField();
  JTextField tfBairro = new JTextField();
  JLabel jlInscEstadual = new JLabel();
  JButton btOutroTel = new JButton();
  JLabel lbEmail = new JLabel();
  JButton btOutroEndereco = new JButton();
  JTextField tfNumero = new JTextField();
  JTextField tfRVendas = new JTextField();
  JTextField tfRazaoSocial = new JTextField();

  public frCadastrarFornecedor() throws HeadlessException {
    try {
      jbInit();
      ativa = false;
      this.formatWindow();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    this.setModal(true);
    vc = new ValidarCampo();
    ccf = new CtrCadastrarFornecedor();
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.setSize(new Dimension(514, 410));
    this.setTitle("Cadastrar Fornecedor");
    jPanel4.setLayout(null);
    jPanel4.setBounds(new Rectangle(4, 314, 503, 63));
    jPanel4.setBorder(BorderFactory.createEtchedBorder());
    TFcep.addKeyListener(new frCadastrarFornecedor_TFcep_keyAdapter(this));
    TFcep.setBounds(new Rectangle(418, 38, 70, 21));
    TFcep.setText("");
    cbEstado.addActionListener(
      new frCadastrarFornecedor_cbEstado_actionAdapter(this)
    );
    cbEstado.addKeyListener(
      new frCadastrarFornecedor_cbEstado_keyAdapter(this)
    );
    cbEstado.setBounds(new Rectangle(434, 67, 54, 21));
    this.getContentPane().setLayout(null);
    tfNomeFantasia.setBounds(new Rectangle(93, 36, 393, 21));
    tfNomeFantasia.addKeyListener(
      new frCadastrarFornecedor_tfNomeFantasia_keyAdapter(this)
    );
    tfNomeFantasia.setAlignmentX((float) 0.5);
    tfNomeFantasia.setText("");
    tfCNPJ.setText("");
    tfCNPJ.setBounds(new Rectangle(93, 66, 142, 21));
    tfCNPJ.addKeyListener(new frCadastrarFornecedor_tfCNPJ_keyAdapter(this));
    lbTelefone.setText("Telefone:");
    lbTelefone.setBounds(new Rectangle(37, 17, 52, 15));
    tfTelefone.setText("");
    tfTelefone.setBounds(new Rectangle(94, 11, 101, 21));
    tfTelefone.addKeyListener(
      new frCadastrarFornecedor_tfTelefone_keyAdapter(this)
    );
    lbNumero.setText("Número:");
    lbNumero.setBounds(new Rectangle(44, 40, 44, 15));
    lbRazaoSocial.setText("Razão Social:");
    lbRazaoSocial.setBounds(new Rectangle(20, 13, 72, 15));
    jPanel3.setBorder(BorderFactory.createEtchedBorder());
    jPanel3.setBounds(new Rectangle(4, 133, 502, 134));
    jPanel3.setLayout(null);
    lbCep.setText("CEP:");
    lbCep.setBounds(new Rectangle(391, 42, 27, 15));
    lbEstado.setText("Estado:");
    lbEstado.setBounds(new Rectangle(388, 70, 44, 15));
    btLimpar.setBounds(new Rectangle(215, 18, 73, 25));
    btLimpar.setText("Limpar");
    btLimpar.addActionListener(
      new frCadastrarFornecedor_btLimpar_actionAdapter(this)
    );
    tfInscEstadual.setText("");
    tfInscEstadual.setBounds(new Rectangle(341, 66, 145, 21));
    tfInscEstadual.addKeyListener(
      new frCadastrarFornecedor_tfInscEstadual_keyAdapter(this)
    );
    lbBairro.setText("Bairro:");
    lbBairro.setBounds(new Rectangle(157, 41, 34, 15));
    jlRVendas.setText("Representate de Vendas:");
    jlRVendas.setBounds(new Rectangle(28, 97, 136, 15));
    jlEndereco.setText("Endereço:");
    jlEndereco.setBounds(new Rectangle(38, 13, 58, 15));
    tfCidade.setText("");
    tfCidade.setBounds(new Rectangle(95, 69, 208, 21));
    tfCidade.addKeyListener(
      new frCadastrarFornecedor_tfCidade_keyAdapter(this)
    );
    jPanel2.setBorder(BorderFactory.createEtchedBorder());
    jPanel2.setBounds(new Rectangle(4, 6, 502, 130));
    jPanel2.setLayout(null);
    jPanel5.setBorder(BorderFactory.createEtchedBorder());
    jPanel5.setBounds(new Rectangle(4, 266, 503, 49));
    jPanel5.setLayout(null);
    lbCNPJ.setText("C.N.P.J.:");
    lbCNPJ.setBounds(new Rectangle(43, 70, 50, 15));
    tfFax.setText("");
    tfFax.setBounds(new Rectangle(244, 11, 121, 21));
    tfFax.addKeyListener(new frCadastrarFornecedor_tfFax_keyAdapter(this));
    lbFax.setText("Fax:");
    lbFax.setBounds(new Rectangle(215, 17, 34, 15));
    btSair.setBounds(new Rectangle(299, 18, 73, 25));
    btSair.setText("Sair");
    btSair.addActionListener(
      new frCadastrarFornecedor_btSair_actionAdapter(this)
    );
    tfEmail.setText("");
    tfEmail.setBounds(new Rectangle(95, 98, 271, 21));
    tfEmail.addKeyListener(new frCadastrarFornecedor_tfEmail_keyAdapter(this));
    lbCidade.setText("Cidade:");
    lbCidade.setBounds(new Rectangle(49, 72, 47, 15));
    jlNomeFantasia.setText("Nome Fantasia:");
    jlNomeFantasia.setBounds(new Rectangle(13, 38, 80, 15));
    btCadastrar.setBounds(new Rectangle(119, 18, 84, 25));
    btCadastrar.setText("Cadastrar");
    btCadastrar.addActionListener(
      new frCadastrarFornecedor_btCadastrar_actionAdapter(this)
    );
    tfEndereco.setSelectionStart(0);
    tfEndereco.setText("");
    tfEndereco.setBounds(new Rectangle(95, 9, 393, 21));
    tfEndereco.addKeyListener(
      new frCadastrarFornecedor_tfEndereco_keyAdapter(this)
    );
    tfBairro.setText("");
    tfBairro.setBounds(new Rectangle(192, 39, 174, 21));
    tfBairro.addKeyListener(
      new frCadastrarFornecedor_tfBairro_keyAdapter(this)
    );
    jlInscEstadual.setText("Insc. Estadual:");
    jlInscEstadual.setBounds(new Rectangle(258, 70, 75, 15));
    btOutroTel.setBounds(new Rectangle(405, 7, 84, 25));
    btOutroTel.setToolTipText(
      "Clique aqui " + "para cadastrar mais de um telefone"
    );
    btOutroTel.setText("Outro Tel.");
    btOutroTel.addActionListener(
      new frCadastrarFornecedor_btOutroTel_actionAdapter(this)
    );
    lbEmail.setText("E-mail:");
    lbEmail.setBounds(new Rectangle(55, 103, 34, 15));
    btOutroEndereco.setBounds(new Rectangle(403, 98, 86, 25));
    btOutroEndereco.setSelected(false);
    btOutroEndereco.setToolTipText(
      "Clique aqui " + "para cadastrar mais de um endereço"
    );
    btOutroEndereco.setText("Outro End.");
    btOutroEndereco.addActionListener(
      new frCadastrarFornecedor_btOutroEndereco_actionAdapter(this)
    );
    tfNumero.setText("");
    tfNumero.setBounds(new Rectangle(95, 38, 45, 21));
    tfNumero.addKeyListener(
      new frCadastrarFornecedor_tfNumero_keyAdapter(this)
    );
    tfRVendas.setText("");
    tfRVendas.setBounds(new Rectangle(162, 95, 324, 21));
    tfRVendas.addKeyListener(
      new frCadastrarFornecedor_tfRVendas_keyAdapter(this)
    );
    tfRazaoSocial.setText("");
    tfRazaoSocial.setBounds(new Rectangle(93, 10, 393, 21));
    tfRazaoSocial.addKeyListener(
      new frCadastrarFornecedor_tfRazaoSocial_keyAdapter(this)
    );
    jPanel4.add(btLimpar, null);
    jPanel4.add(btCadastrar, null);
    jPanel4.add(btSair, null);
    this.getContentPane().add(jPanel3, null);
    jPanel3.add(tfCidade, null);
    jPanel3.add(tfBairro, null);
    jPanel3.add(tfEmail, null);
    jPanel3.add(cbEstado, null);
    jPanel3.add(lbEstado, null);
    jPanel3.add(lbCidade, null);
    jPanel3.add(lbNumero, null);
    jPanel3.add(tfNumero, null);
    jPanel3.add(lbBairro, null);
    jPanel3.add(lbCep, null);
    jPanel3.add(TFcep, null);
    jPanel3.add(tfEndereco, null);
    jPanel3.add(jlEndereco, null);
    jPanel3.add(lbEmail, null);
    jPanel3.add(btOutroEndereco, null);
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(tfNomeFantasia, null);
    jPanel2.add(tfRazaoSocial, null);
    jPanel2.add(lbRazaoSocial, null);
    jPanel2.add(jlNomeFantasia, null);
    jPanel2.add(lbCNPJ, null);
    jPanel2.add(tfCNPJ, null);
    jPanel2.add(jlInscEstadual, null);
    jPanel2.add(tfInscEstadual, null);
    jPanel2.add(tfRVendas, null);
    jPanel2.add(jlRVendas, null);
    this.getContentPane().add(jPanel5, null);
    jPanel5.add(tfFax, null);
    jPanel5.add(tfTelefone, null);
    jPanel5.add(lbTelefone, null);
    jPanel5.add(lbFax, null);
    jPanel5.add(btOutroTel, null);
    this.getContentPane().add(jPanel4, null);
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

  //Overridden so we can exit when window is closed
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(0);
    }
  }

  public Vector preencherEstado() {
    Vector Est = new Vector();
    Est.addElement("");
    Est.addElement("RJ");
    Est.addElement("SP");
    Est.addElement("MG");
    Est.addElement("ES");
    Est.addElement("AC");
    Est.addElement("AL");
    Est.addElement("AP");
    Est.addElement("AM");
    Est.addElement("BA");
    Est.addElement("CE");
    Est.addElement("DF");
    Est.addElement("GO");
    Est.addElement("MA");
    Est.addElement("MT");
    Est.addElement("MS");
    Est.addElement("PA");
    Est.addElement("PB");
    Est.addElement("PR");
    Est.addElement("PE");
    Est.addElement("PI");
    Est.addElement("RN");
    Est.addElement("RS");
    Est.addElement("RO");
    Est.addElement("RR");
    Est.addElement("SC");
    Est.addElement("SE");
    Est.addElement("TO");
    return Est;
  }

  void cbEstado_actionPerformed(ActionEvent e) {
    estado = (String) cbEstado.getSelectedItem();
  }

  void btCadastrar_actionPerformed(ActionEvent e) {
    if (
      !vc.valNulo(tfRazaoSocial.getText(), "Razão Social") ||
      !vc.valNulo(tfInscEstadual.getText(), "Inscrição Estadual") ||
      !vc.valNulo(tfNomeFantasia.getText(), "Nome Fantasia") ||
      !vc.valNulo(tfEndereco.getText(), "Endereço") ||
      !vc.valNulo(tfBairro.getText(), "Bairro") ||
      !vc.valNulo(tfCidade.getText(), "Cidade") ||
      !vc.valNulo(tfTelefone.getText(), "Telefone")
    ) return;

    cnpj = tfCNPJ.getText();
    String razaoSocial = tfRazaoSocial.getText();
    String inscEstadual = tfInscEstadual.getText();
    String fantasia = tfNomeFantasia.getText();
    String repVendas = tfRVendas.getText();
    rua = tfEndereco.getText();
    bairro = tfBairro.getText();
    cidade = tfCidade.getText();
    cep = TFcep.getText();
    numero = tfNumero.getText();
    Email = tfEmail.getText();
    telefone = tfTelefone.getText();
    fax = tfFax.getText();
    ccf.cadastrar(cnpj, razaoSocial, inscEstadual, fantasia, repVendas);
    ccf.novoEndereco(rua, bairro, cidade, estado, cep, numero, Email, cnpj);
    ccf.novoTelefone(telefone, fax, cnpj);

    JOptionPane.showMessageDialog(
      null,
      "Cadastro Efetuado com Sucesso!",
      "Cadastro de Fornecedores",
      JOptionPane.INFORMATION_MESSAGE
    );

    try {
      this.finalize();
      new frCadastrarFornecedor();
      this.setVisible(false);
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
  }

  public void limpar() {
    tfCNPJ.setText("");
    tfRazaoSocial.setText("");
    tfInscEstadual.setText("");
    tfNomeFantasia.setText("");
    tfRVendas.setText("");
    tfEndereco.setText("");
    tfBairro.setText("");
    tfCidade.setText("");
    TFcep.setText("");
    tfNumero.setText("");
    tfEmail.setText("");
    cbEstado.setSelectedItem("");
    tfTelefone.setText("");
    tfFax.setText("");
  }

  void btOutroEndereco_actionPerformed(ActionEvent e) {
    if (
      !vc.valNulo(tfEndereco.getText(), "Endereço") ||
      !vc.valNulo(tfBairro.getText(), "Bairro") ||
      !vc.valNulo(tfCidade.getText(), "Cidade")
    ) return;

    cnpj = tfCNPJ.getText();
    rua = tfEndereco.getText();
    bairro = tfBairro.getText();
    cidade = tfCidade.getText();
    cep = TFcep.getText();
    numero = tfNumero.getText();
    Email = tfEmail.getText();
    ccf.novoEndereco(rua, bairro, cidade, estado, cep, numero, Email, cnpj);
    JOptionPane.showMessageDialog(
      null,
      "Endereço Cadastrado com Sucesso, Inclua Outro",
      "Cadastro de Endereço",
      JOptionPane.INFORMATION_MESSAGE
    );
    tfEndereco.setText("");
    tfBairro.setText("");
    tfCidade.setText("");
    TFcep.setText("");
    tfNumero.setText("");
    tfEmail.setText("");
    cbEstado.setSelectedItem("");
    tfEndereco.setText("");
    tfBairro.setText("");
    tfCidade.setText("");
    TFcep.setText("");
    tfNumero.setText("");
    tfEmail.setText("");
    cbEstado.setSelectedItem("");
  }

  void btOutroTel_actionPerformed(ActionEvent e) {
    if (!vc.valNulo(tfTelefone.getText(), "Telefone")) return;

    telefone = tfTelefone.getText();
    fax = tfFax.getText();
    ccf.novoTelefone(telefone, fax, cnpj);
    JOptionPane.showMessageDialog(
      null,
      "Telefone Cadastrado com Sucesso, Inclua Outro",
      "Cadastro de Endereço",
      JOptionPane.INFORMATION_MESSAGE
    );
    tfTelefone.setText("");
    tfFax.setText("");
  }

  void btLimpar_actionPerformed(ActionEvent e) {
    this.limpar();
  }

  void btSair_actionPerformed(ActionEvent e) {
    if (ativa) {
      Object opt[] = { "Sim", "Não" };
      int result = JOptionPane.showOptionDialog(
        this,
        "Deseja Cancelar esse Cadastro",
        "Cadastro de Fornecedores",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        opt,
        opt[0]
      );
      if (result == JOptionPane.YES_OPTION) {
        try {
          ccf.destrutor();
          this.finalize();
          this.setVisible(false);
        } catch (Throwable ex) {
          ex.printStackTrace();
        }
      }
    } else {
      this.setVisible(false);
      try {
        this.finalize();
      } catch (Throwable ex1) {
        ex1.printStackTrace();
      }
    }
  }

  //*Esse método serve pra informar se o usuário entrou com algum dado dado na tela*/
  void tfRazaoSocial_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfNomeFantasia_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfCNPJ_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfInscEstadual_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfRVendas_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfEndereco_keyPressed(KeyEvent e) {
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

  void cbEstado_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfEmail_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfTelefone_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfFax_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void cbEstado_keyTyped(KeyEvent e) {}

  void cbEstado_keyReleased(KeyEvent e) {}

  void TFcep_keyTyped(KeyEvent e) {}

  void TFcep_keyReleased(KeyEvent e) {}

  void tfNomeFantasia_keyTyped(KeyEvent e) {}

  void tfNomeFantasia_keyReleased(KeyEvent e) {}

  void tfCNPJ_keyTyped(KeyEvent e) {}

  void tfCNPJ_keyReleased(KeyEvent e) {}

  void tfTelefone_keyTyped(KeyEvent e) {}

  void tfTelefone_keyReleased(KeyEvent e) {}

  void tfInscEstadual_keyTyped(KeyEvent e) {}

  void tfInscEstadual_keyReleased(KeyEvent e) {}

  void tfCidade_keyTyped(KeyEvent e) {}

  void tfCidade_keyReleased(KeyEvent e) {}

  void tfFax_keyTyped(KeyEvent e) {}

  void tfFax_keyReleased(KeyEvent e) {}

  void tfEmail_keyTyped(KeyEvent e) {}

  void tfEmail_keyReleased(KeyEvent e) {}

  void tfEndereco_keyTyped(KeyEvent e) {}

  void tfEndereco_keyReleased(KeyEvent e) {}

  void tfBairro_keyTyped(KeyEvent e) {}

  void tfBairro_keyReleased(KeyEvent e) {}

  void tfNumero_keyTyped(KeyEvent e) {}

  void tfNumero_keyReleased(KeyEvent e) {}

  void tfRVendas_keyTyped(KeyEvent e) {}

  void tfRVendas_keyReleased(KeyEvent e) {}

  void tfRazaoSocial_keyTyped(KeyEvent e) {}

  void tfRazaoSocial_keyReleased(KeyEvent e) {}
}

class frCadastrarFornecedor_btOutroEndereco_actionAdapter
  implements java.awt.event.ActionListener {

  frCadastrarFornecedor adaptee;

  frCadastrarFornecedor_btOutroEndereco_actionAdapter(
    frCadastrarFornecedor adaptee
  ) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btOutroEndereco_actionPerformed(e);
  }
}

class frCadastrarFornecedor_btOutroTel_actionAdapter
  implements java.awt.event.ActionListener {

  frCadastrarFornecedor adaptee;

  frCadastrarFornecedor_btOutroTel_actionAdapter(
    frCadastrarFornecedor adaptee
  ) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btOutroTel_actionPerformed(e);
  }
}

class frCadastrarFornecedor_btCadastrar_actionAdapter
  implements java.awt.event.ActionListener {

  frCadastrarFornecedor adaptee;

  frCadastrarFornecedor_btCadastrar_actionAdapter(
    frCadastrarFornecedor adaptee
  ) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btCadastrar_actionPerformed(e);
  }
}

class frCadastrarFornecedor_btLimpar_actionAdapter
  implements java.awt.event.ActionListener {

  frCadastrarFornecedor adaptee;

  frCadastrarFornecedor_btLimpar_actionAdapter(frCadastrarFornecedor adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btLimpar_actionPerformed(e);
  }
}

class frCadastrarFornecedor_btSair_actionAdapter
  implements java.awt.event.ActionListener {

  frCadastrarFornecedor adaptee;

  frCadastrarFornecedor_btSair_actionAdapter(frCadastrarFornecedor adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btSair_actionPerformed(e);
  }
}

class frCadastrarFornecedor_cbEstado_actionAdapter
  implements java.awt.event.ActionListener {

  frCadastrarFornecedor adaptee;

  frCadastrarFornecedor_cbEstado_actionAdapter(frCadastrarFornecedor adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.cbEstado_actionPerformed(e);
  }
}

class frCadastrarFornecedor_tfRazaoSocial_keyAdapter
  extends java.awt.event.KeyAdapter {

  frCadastrarFornecedor adaptee;

  frCadastrarFornecedor_tfRazaoSocial_keyAdapter(
    frCadastrarFornecedor adaptee
  ) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfRazaoSocial_keyPressed(e);
  }
}

class frCadastrarFornecedor_tfNomeFantasia_keyAdapter
  extends java.awt.event.KeyAdapter {

  frCadastrarFornecedor adaptee;

  frCadastrarFornecedor_tfNomeFantasia_keyAdapter(
    frCadastrarFornecedor adaptee
  ) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfNomeFantasia_keyPressed(e);
  }
}

class frCadastrarFornecedor_tfCNPJ_keyAdapter
  extends java.awt.event.KeyAdapter {

  frCadastrarFornecedor adaptee;

  frCadastrarFornecedor_tfCNPJ_keyAdapter(frCadastrarFornecedor adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfCNPJ_keyPressed(e);
  }
}

class frCadastrarFornecedor_tfInscEstadual_keyAdapter
  extends java.awt.event.KeyAdapter {

  frCadastrarFornecedor adaptee;

  frCadastrarFornecedor_tfInscEstadual_keyAdapter(
    frCadastrarFornecedor adaptee
  ) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfInscEstadual_keyPressed(e);
  }
}

class frCadastrarFornecedor_tfRVendas_keyAdapter
  extends java.awt.event.KeyAdapter {

  frCadastrarFornecedor adaptee;

  frCadastrarFornecedor_tfRVendas_keyAdapter(frCadastrarFornecedor adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfRVendas_keyPressed(e);
  }
}

class frCadastrarFornecedor_tfEndereco_keyAdapter
  extends java.awt.event.KeyAdapter {

  frCadastrarFornecedor adaptee;

  frCadastrarFornecedor_tfEndereco_keyAdapter(frCadastrarFornecedor adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfEndereco_keyPressed(e);
  }
}

class frCadastrarFornecedor_tfNumero_keyAdapter
  extends java.awt.event.KeyAdapter {

  frCadastrarFornecedor adaptee;

  frCadastrarFornecedor_tfNumero_keyAdapter(frCadastrarFornecedor adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfNumero_keyPressed(e);
  }
}

class frCadastrarFornecedor_tfBairro_keyAdapter
  extends java.awt.event.KeyAdapter {

  frCadastrarFornecedor adaptee;

  frCadastrarFornecedor_tfBairro_keyAdapter(frCadastrarFornecedor adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfBairro_keyPressed(e);
  }
}

class frCadastrarFornecedor_TFcep_keyAdapter extends java.awt.event.KeyAdapter {

  frCadastrarFornecedor adaptee;

  frCadastrarFornecedor_TFcep_keyAdapter(frCadastrarFornecedor adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.TFcep_keyPressed(e);
  }
}

class frCadastrarFornecedor_tfCidade_keyAdapter
  extends java.awt.event.KeyAdapter {

  frCadastrarFornecedor adaptee;

  frCadastrarFornecedor_tfCidade_keyAdapter(frCadastrarFornecedor adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfCidade_keyPressed(e);
  }
}

class frCadastrarFornecedor_cbEstado_keyAdapter
  extends java.awt.event.KeyAdapter {

  frCadastrarFornecedor adaptee;

  frCadastrarFornecedor_cbEstado_keyAdapter(frCadastrarFornecedor adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.cbEstado_keyPressed(e);
  }
}

class frCadastrarFornecedor_tfEmail_keyAdapter
  extends java.awt.event.KeyAdapter {

  frCadastrarFornecedor adaptee;

  frCadastrarFornecedor_tfEmail_keyAdapter(frCadastrarFornecedor adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfEmail_keyPressed(e);
  }
}

class frCadastrarFornecedor_tfTelefone_keyAdapter
  extends java.awt.event.KeyAdapter {

  frCadastrarFornecedor adaptee;

  frCadastrarFornecedor_tfTelefone_keyAdapter(frCadastrarFornecedor adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfTelefone_keyPressed(e);
  }
}

class frCadastrarFornecedor_tfFax_keyAdapter extends java.awt.event.KeyAdapter {

  frCadastrarFornecedor adaptee;

  frCadastrarFornecedor_tfFax_keyAdapter(frCadastrarFornecedor adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfFax_keyPressed(e);
  }
}
