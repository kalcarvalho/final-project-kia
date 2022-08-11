package CamadaApresentacao;

import Controladoras.CtrCadastrarProduto;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.*;

public class frCadastrarProduto extends JDialog {

  private ValidarCampo vc;
  private CtrCadastrarProduto ccp;
  private boolean ativa;
  JComboBox cbForn;
  JPanel jPanel1 = new JPanel();
  JLabel lbFornecedor = new JLabel();
  JTextField tfCodProd = new JTextField();
  JLabel lbDescricao = new JLabel();
  JLabel lbPCusto = new JLabel();
  JComboBox cbRefri = new JComboBox();
  JTextField tfEstoqueMinimo = new JTextField();
  JLabel lbId = new JLabel();
  JTextField tfPVenda = new JTextField();
  JPanel jPanel2 = new JPanel();
  JComboBox cbUnidade = new JComboBox();
  JTextField tfEstoqueMaximo = new JTextField();
  JLabel lbRefrigeracao = new JLabel();
  JLabel lbUnidade = new JLabel();
  JLabel lbEstoqueMaximo = new JLabel();
  JTextField tfPCusto = new JTextField();
  JLabel lbApresentacao = new JLabel();
  JTextField tfApresentacao = new JTextField();
  JLabel lbPVenda = new JLabel();
  JLabel lbEstoqueMinimo = new JLabel();
  JTextField tfDescricao = new JTextField();
  JPanel jPanel3 = new JPanel();
  JButton btLimpar = new JButton();
  JButton btSair = new JButton();
  JButton btCadastrar = new JButton();

  public frCadastrarProduto() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      ativa = false;
      jbInit();
      this.formatWindow();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    vc = new ValidarCampo();
    super.setModal(true);
    ccp = new CtrCadastrarProduto(); //dispose
    cbForn = new JComboBox(ccp.preencherForn());
    cbRefri = new JComboBox(this.preencherRefr());
    cbUnidade = new JComboBox(this.preencherUni());
    jPanel1.setLayout(null);
    jPanel1.setBounds(new Rectangle(5, 7, 417, 46));
    jPanel1.setBorder(BorderFactory.createEtchedBorder());
    cbForn.setBounds(new Rectangle(170, 10, 169, 21));
    this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.setSize(new Dimension(432, 349));
    this.setTitle("Cadastrar Produto");
    this.getContentPane().setLayout(null);
    lbFornecedor.setFont(new java.awt.Font("SansSerif", 1, 11));
    lbFornecedor.setText("Selecione Fornecedor:");
    lbFornecedor.setBounds(new Rectangle(24, 16, 136, 15));
    tfCodProd.setText("");
    tfCodProd.setBounds(new Rectangle(317, 12, 86, 21));
    tfCodProd.addKeyListener(new frCadastrarProduto_tfCodProd_keyAdapter(this));
    lbDescricao.setText("Descrição:");
    lbDescricao.setBounds(new Rectangle(13, 18, 53, 15));
    lbPCusto.setText("Preço Custo:");
    lbPCusto.setBounds(new Rectangle(13, 160, 66, 15));
    cbRefri.setBounds(new Rectangle(93, 48, 55, 21));
    tfEstoqueMinimo.setText("");
    tfEstoqueMinimo.setBounds(new Rectangle(98, 120, 52, 21));
    tfEstoqueMinimo.addKeyListener(
      new frCadastrarProduto_tfEstoqueMinimo_keyAdapter(this)
    );
    lbId.setText("Código Produto:");
    lbId.setBounds(new Rectangle(217, 18, 90, 15));
    tfPVenda.setText("");
    tfPVenda.setBounds(new Rectangle(250, 154, 70, 21));
    tfPVenda.addKeyListener(new frCadastrarProduto_tfPVenda_keyAdapter(this));
    jPanel2.setBorder(BorderFactory.createEtchedBorder());
    jPanel2.setBounds(new Rectangle(5, 52, 417, 192));
    jPanel2.setLayout(null);
    cbUnidade.setBounds(new Rectangle(269, 45, 64, 21));
    tfEstoqueMaximo.setText("");
    tfEstoqueMaximo.setBounds(new Rectangle(260, 120, 59, 21));
    tfEstoqueMaximo.addKeyListener(
      new frCadastrarProduto_tfEstoqueMaximo_keyAdapter(this)
    );
    lbRefrigeracao.setText("Refrigeração:");
    lbRefrigeracao.setBounds(new Rectangle(13, 53, 72, 15));
    lbUnidade.setRequestFocusEnabled(true);
    lbUnidade.setText("Unidade:");
    lbUnidade.setBounds(new Rectangle(219, 51, 52, 15));
    lbEstoqueMaximo.setText("Estoque Máximo:");
    lbEstoqueMaximo.setBounds(new Rectangle(171, 126, 84, 15));
    tfPCusto.setText("");
    tfPCusto.setBounds(new Rectangle(83, 154, 67, 21));
    tfPCusto.addKeyListener(new frCadastrarProduto_tfPCusto_keyAdapter(this));
    lbApresentacao.setText("Apresentação:");
    lbApresentacao.setBounds(new Rectangle(13, 90, 74, 15));
    tfApresentacao.setText("");
    tfApresentacao.setBounds(new Rectangle(91, 84, 312, 21));
    tfApresentacao.addKeyListener(
      new frCadastrarProduto_tfApresentacao_keyAdapter(this)
    );
    lbPVenda.setText("Preço Venda:");
    lbPVenda.setBounds(new Rectangle(172, 160, 70, 15));
    lbEstoqueMinimo.setDebugGraphicsOptions(0);
    lbEstoqueMinimo.setText("Estoque Mínimo:");
    lbEstoqueMinimo.setBounds(new Rectangle(13, 126, 82, 15));
    tfDescricao.setText("");
    tfDescricao.setBounds(new Rectangle(80, 12, 121, 21));
    tfDescricao.addKeyListener(
      new frCadastrarProduto_tfDescricao_keyAdapter(this)
    );
    jPanel3.setBorder(BorderFactory.createEtchedBorder());
    jPanel3.setBounds(new Rectangle(5, 243, 417, 69));
    jPanel3.setLayout(null);
    btLimpar.setBounds(new Rectangle(175, 22, 73, 25));
    btLimpar.setText("Limpar");
    btLimpar.addActionListener(
      new frCadastrarProduto_btLimpar_actionAdapter(this)
    );
    btSair.setBounds(new Rectangle(253, 22, 73, 25));
    btSair.setText("Sair");
    btSair.addActionListener(new frCadastrarProduto_btSair_actionAdapter(this));
    btCadastrar.setBounds(new Rectangle(87, 22, 83, 25));
    btCadastrar.setText("Cadastrar");
    btCadastrar.addActionListener(
      new frCadastrarProduto_btCadastrar_actionAdapter(this)
    );
    jPanel1.add(lbFornecedor, null);
    jPanel1.add(cbForn, null);
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(tfDescricao, null);
    jPanel2.add(lbDescricao, null);
    jPanel2.add(tfCodProd, null);
    jPanel2.add(lbId, null);
    jPanel2.add(tfApresentacao, null);
    jPanel2.add(lbApresentacao, null);
    jPanel2.add(tfEstoqueMinimo, null);
    jPanel2.add(lbEstoqueMinimo, null);
    jPanel2.add(tfPCusto, null);
    jPanel2.add(lbPCusto, null);
    jPanel2.add(lbPVenda, null);
    jPanel2.add(tfPVenda, null);
    jPanel2.add(lbRefrigeracao, null);
    jPanel2.add(lbUnidade, null);
    jPanel2.add(cbUnidade, null);
    jPanel2.add(lbEstoqueMaximo, null);
    jPanel2.add(tfEstoqueMaximo, null);
    jPanel2.add(cbRefri, null);
    this.getContentPane().add(jPanel3, null);
    jPanel3.add(btLimpar, null);
    jPanel3.add(btCadastrar, null);
    jPanel3.add(btSair, null);
    this.getContentPane().add(jPanel1, null);
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

  void btLimpar_actionPerformed(ActionEvent e) {
    tfDescricao.setText("");
    tfCodProd.setText("");
    tfApresentacao.setText("");
    tfEstoqueMinimo.setText("");
    tfEstoqueMaximo.setText("");
    tfPCusto.setText("");
    tfPVenda.setText("");
  }

  public String[] preencherRefr() {
    String[] bool = new String[2];
    bool[0] = "Sim";
    bool[1] = "Não";
    return bool;
  }

  public Vector preencherUni() {
    Vector uni = new Vector();
    uni.addElement("Kg");
    uni.addElement("Lt");
    uni.addElement("Un");
    uni.addElement("Mt");
    uni.addElement("Dúzia");
    return uni;
  }

  void btSair_actionPerformed(ActionEvent e) {
    if (ativa) {
      Object opt[] = { "Sim", "Não" };
      int result = JOptionPane.showOptionDialog(
        this,
        "Deseja Cancelar esse Cadastro",
        "Cadastro de Produto",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        opt,
        opt[0]
      );
      if (result == JOptionPane.YES_OPTION) {
        try {
          ccp.destrutor();
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

  void tfPVenda_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfPCusto_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfEstoqueMinimo_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfEstoqueMaximo_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfApresentacao_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfDescricao_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfCodProd_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void btCadastrar_actionPerformed(ActionEvent e) {
    //validação de campos - classe Validar Campo
    if (
      !vc.valNulo(tfCodProd.getText(), "Código Produto") ||
      !vc.valNulo(tfApresentacao.getText(), "Apresentação") ||
      !vc.valDouble(tfEstoqueMinimo.getText(), "Estoque Mínimo") ||
      !vc.valDouble(tfEstoqueMaximo.getText(), "Estoque Máximo") ||
      !vc.valDouble(tfPCusto.getText(), "Preço Custo") ||
      !vc.valDouble(tfPVenda.getText(), "Preço Venda")
    ) return;

    String razaoSocial = (String) cbForn.getSelectedItem();
    String descricao = tfDescricao.getText();
    String codProd = tfCodProd.getText();
    String refrig = (String) cbRefri.getSelectedItem();
    String unidade = (String) cbUnidade.getSelectedItem();
    String apres = tfApresentacao.getText();
    double estMin = Double.parseDouble(tfEstoqueMinimo.getText());
    double estMax = Double.parseDouble(tfEstoqueMaximo.getText());
    double pCusto = Double.parseDouble(tfPCusto.getText());
    double pVenda = Double.parseDouble(tfPVenda.getText());
    ccp.cadastrar(
      razaoSocial,
      descricao,
      codProd,
      refrig,
      unidade,
      apres,
      estMin,
      estMax,
      pCusto,
      pVenda
    );

    JOptionPane.showMessageDialog(
      null,
      "Cadastro Efetuado com Sucesso!",
      "Cadastro de Produtos",
      JOptionPane.INFORMATION_MESSAGE
    );

    try {
      this.finalize();
      new frCadastrarProduto();
      this.setVisible(false);
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
  }
}

class frCadastrarProduto_btLimpar_actionAdapter
  implements java.awt.event.ActionListener {

  frCadastrarProduto adaptee;

  frCadastrarProduto_btLimpar_actionAdapter(frCadastrarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btLimpar_actionPerformed(e);
  }
}

class frCadastrarProduto_btSair_actionAdapter
  implements java.awt.event.ActionListener {

  frCadastrarProduto adaptee;

  frCadastrarProduto_btSair_actionAdapter(frCadastrarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btSair_actionPerformed(e);
  }
}

class frCadastrarProduto_tfPVenda_keyAdapter extends java.awt.event.KeyAdapter {

  frCadastrarProduto adaptee;

  frCadastrarProduto_tfPVenda_keyAdapter(frCadastrarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfPVenda_keyPressed(e);
  }
}

class frCadastrarProduto_tfPCusto_keyAdapter extends java.awt.event.KeyAdapter {

  frCadastrarProduto adaptee;

  frCadastrarProduto_tfPCusto_keyAdapter(frCadastrarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfPCusto_keyPressed(e);
  }
}

class frCadastrarProduto_tfEstoqueMinimo_keyAdapter
  extends java.awt.event.KeyAdapter {

  frCadastrarProduto adaptee;

  frCadastrarProduto_tfEstoqueMinimo_keyAdapter(frCadastrarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfEstoqueMinimo_keyPressed(e);
  }
}

class frCadastrarProduto_tfEstoqueMaximo_keyAdapter
  extends java.awt.event.KeyAdapter {

  frCadastrarProduto adaptee;

  frCadastrarProduto_tfEstoqueMaximo_keyAdapter(frCadastrarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfEstoqueMaximo_keyPressed(e);
  }
}

class frCadastrarProduto_tfApresentacao_keyAdapter
  extends java.awt.event.KeyAdapter {

  frCadastrarProduto adaptee;

  frCadastrarProduto_tfApresentacao_keyAdapter(frCadastrarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfApresentacao_keyPressed(e);
  }
}

class frCadastrarProduto_tfDescricao_keyAdapter
  extends java.awt.event.KeyAdapter {

  frCadastrarProduto adaptee;

  frCadastrarProduto_tfDescricao_keyAdapter(frCadastrarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfDescricao_keyPressed(e);
  }
}

class frCadastrarProduto_tfCodProd_keyAdapter
  extends java.awt.event.KeyAdapter {

  frCadastrarProduto adaptee;

  frCadastrarProduto_tfCodProd_keyAdapter(frCadastrarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfCodProd_keyPressed(e);
  }
}

class frCadastrarProduto_btCadastrar_actionAdapter
  implements java.awt.event.ActionListener {

  frCadastrarProduto adaptee;

  frCadastrarProduto_btCadastrar_actionAdapter(frCadastrarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btCadastrar_actionPerformed(e);
  }
}
