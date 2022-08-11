package CamadaApresentacao;

import Controladoras.CtrAlterarProduto;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Vector;
import javax.swing.*;

public class frAlterarProduto extends JFrame {

  DecimalFormat decimo = new DecimalFormat("0.00");
  private ValidarCampo vc;
  private CtrAlterarProduto cap;
  private boolean ativa;
  private Vector prods;
  private String descricao;
  private String razaoSocial;
  private String idProduto;
  JTextField tfCodProd = new JTextField();
  JLabel lbPCusto = new JLabel();
  JPanel jPanel3 = new JPanel();
  JTextField tfEstoqueMinimo = new JTextField();
  JLabel lbId = new JLabel();
  JButton btLimpar = new JButton();
  JTextField tfPVenda = new JTextField();
  JPanel jPanel2 = new JPanel();
  JComboBox cbProd = new JComboBox();
  JButton btSair = new JButton();
  JTextField tfEstoqueMaximo = new JTextField();
  JLabel lbRefrigeracao = new JLabel();
  JLabel lbUnidade = new JLabel();
  JButton btAlterar = new JButton();
  JLabel lbEstoqueMaximo = new JLabel();
  JPanel jPanel1 = new JPanel();
  JTextField tfPCusto = new JTextField();
  JLabel lbFornecedor = new JLabel();
  JLabel lbApresentacao = new JLabel();
  JTextField tfApresentacao = new JTextField();
  JLabel lbPVenda = new JLabel();
  JLabel lbEstoqueMinimo = new JLabel();
  JTextField tfRefr = new JTextField();
  JTextField tfUnidade = new JTextField();
  JLabel lbSelForn = new JLabel();
  JComboBox cbFornecedor;

  public frAlterarProduto() {
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
    cap = new CtrAlterarProduto();
    this.setResizable(false);
    this.setSize(new Dimension(426, 354));
    this.setTitle("Alterar Produto");
    jPanel3.setLayout(null);
    jPanel3.setBounds(new Rectangle(3, 267, 417, 59));
    jPanel3.setBorder(BorderFactory.createEtchedBorder());
    lbPCusto.setBounds(new Rectangle(13, 160, 84, 15));
    lbPCusto.setText("Preço Custo: R$");
    tfCodProd.setBounds(new Rectangle(93, 11, 86, 21));
    tfCodProd.addKeyListener(new frAlterarProduto_tfCodProd_keyAdapter(this));
    tfCodProd.setBackground(SystemColor.text);
    tfCodProd.setText("");
    this.getContentPane().setLayout(null);
    tfEstoqueMinimo.setBackground(SystemColor.text);
    tfEstoqueMinimo.setText("");
    tfEstoqueMinimo.setBounds(new Rectangle(115, 123, 52, 21));
    tfEstoqueMinimo.addKeyListener(
      new frAlterarProduto_tfEstoqueMinimo_keyAdapter(this)
    );
    lbId.setText("Código Produto:");
    lbId.setBounds(new Rectangle(12, 18, 90, 15));
    btLimpar.setBounds(new Rectangle(175, 16, 73, 25));
    btLimpar.setText("Limpar");
    btLimpar.addActionListener(
      new frAlterarProduto_btLimpar_actionAdapter(this)
    );
    tfPVenda.setBackground(SystemColor.text);
    tfPVenda.setText("");
    tfPVenda.setBounds(new Rectangle(280, 155, 70, 21));
    tfPVenda.addKeyListener(new frAlterarProduto_tfPVenda_keyAdapter(this));
    jPanel2.setBorder(BorderFactory.createEtchedBorder());
    jPanel2.setBounds(new Rectangle(3, 76, 417, 192));
    jPanel2.setLayout(null);
    cbFornecedor = new JComboBox(cap.preencherForn());
    cbProd.setBounds(new Rectangle(173, 44, 172, 21));
    cbProd.addActionListener(new frAlterarProduto_cbProd_actionAdapter(this));
    btSair.setBounds(new Rectangle(253, 16, 73, 25));
    btSair.setText("Sair");
    btSair.addActionListener(new frAlterarProduto_btSair_actionAdapter(this));
    tfEstoqueMaximo.setBackground(SystemColor.text);
    tfEstoqueMaximo.setText("");
    tfEstoqueMaximo.setBounds(new Rectangle(296, 121, 53, 21));
    tfEstoqueMaximo.addKeyListener(
      new frAlterarProduto_tfEstoqueMaximo_keyAdapter(this)
    );
    lbRefrigeracao.setText("Refrigeração:");
    lbRefrigeracao.setBounds(new Rectangle(13, 53, 72, 15));
    lbUnidade.setRequestFocusEnabled(true);
    lbUnidade.setText("Unidade:");
    lbUnidade.setBounds(new Rectangle(219, 53, 52, 15));
    btAlterar.setBounds(new Rectangle(87, 16, 83, 25));
    btAlterar.setText("Alterar");
    btAlterar.addActionListener(
      new frAlterarProduto_btAlterar_actionAdapter(this)
    );
    lbEstoqueMaximo.setText("Estoque Máximo:");
    lbEstoqueMaximo.setBounds(new Rectangle(189, 126, 84, 15));
    jPanel1.setBorder(BorderFactory.createEtchedBorder());
    jPanel1.setBounds(new Rectangle(3, 1, 417, 78));
    jPanel1.setLayout(null);
    tfPCusto.setBackground(SystemColor.text);
    tfPCusto.setText("");
    tfPCusto.setBounds(new Rectangle(101, 155, 67, 21));
    tfPCusto.addKeyListener(new frAlterarProduto_tfPCusto_keyAdapter(this));
    lbFornecedor.setFont(new java.awt.Font("SansSerif", 1, 11));
    lbFornecedor.setText("Produto:");
    lbFornecedor.setBounds(new Rectangle(111, 49, 55, 15));
    lbApresentacao.setText("Apresentação:");
    lbApresentacao.setBounds(new Rectangle(13, 90, 74, 15));
    tfApresentacao.setBackground(SystemColor.text);
    tfApresentacao.setText("");
    tfApresentacao.setBounds(new Rectangle(91, 84, 312, 21));
    tfApresentacao.addKeyListener(
      new frAlterarProduto_tfApresentacao_keyAdapter(this)
    );
    lbPVenda.setText("Preço Venda: R$");
    lbPVenda.setBounds(new Rectangle(190, 160, 82, 15));
    lbEstoqueMinimo.setDebugGraphicsOptions(0);
    lbEstoqueMinimo.setText("Estoque Mínimo:");
    lbEstoqueMinimo.setBounds(new Rectangle(13, 126, 82, 15));
    tfRefr.setBackground(SystemColor.text);
    tfRefr.setText("");
    tfRefr.setBounds(new Rectangle(92, 47, 39, 21));
    tfRefr.addKeyListener(new frAlterarProduto_tfRefr_keyAdapter(this));
    tfUnidade.setBackground(SystemColor.text);
    tfUnidade.setText("");
    tfUnidade.setBounds(new Rectangle(269, 47, 56, 21));
    tfUnidade.addKeyListener(new frAlterarProduto_tfUnidade_keyAdapter(this));
    lbSelForn.setFont(new java.awt.Font("SansSerif", 1, 11));
    lbSelForn.setText("Selecione o Fornecedor:");
    lbSelForn.setBounds(new Rectangle(24, 22, 144, 15));
    cbFornecedor.setBounds(new Rectangle(175, 16, 170, 21));
    cbFornecedor.addActionListener(
      new frAlterarProduto_cbFornecedor_actionAdapter(this)
    );
    jPanel3.add(btLimpar, null);
    jPanel3.add(btAlterar, null);
    jPanel3.add(btSair, null);
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(tfApresentacao, null);
    jPanel2.add(lbApresentacao, null);
    jPanel2.add(lbEstoqueMinimo, null);
    jPanel2.add(lbPCusto, null);
    jPanel2.add(lbRefrigeracao, null);
    jPanel2.add(lbUnidade, null);
    jPanel2.add(lbId, null);
    jPanel2.add(tfRefr, null);
    jPanel2.add(tfUnidade, null);
    jPanel2.add(tfCodProd, null);
    jPanel2.add(lbEstoqueMaximo, null);
    jPanel2.add(lbPVenda, null);
    jPanel2.add(tfPCusto, null);
    jPanel2.add(tfEstoqueMinimo, null);
    jPanel2.add(tfEstoqueMaximo, null);
    jPanel2.add(tfPVenda, null);
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(lbSelForn, null);
    jPanel1.add(cbProd, null);
    jPanel1.add(cbFornecedor, null);
    jPanel1.add(lbFornecedor, null);
    this.getContentPane().add(jPanel3, null);
    tfCodProd.setEnabled(false);
    tfRefr.setEnabled(false);
    tfUnidade.setEnabled(false);
    tfApresentacao.setEnabled(false);
    tfEstoqueMinimo.setEnabled(false);
    tfEstoqueMaximo.setEnabled(false);
    tfPCusto.setEnabled(false);
    tfPVenda.setEnabled(false);
    btLimpar.setEnabled(false);
    btAlterar.setEnabled(false);
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

  void btSair_actionPerformed(ActionEvent e) {
    if (ativa) {
      Object opt[] = { "Sim", "Não" };
      int result = JOptionPane.showOptionDialog(
        this,
        "Deseja Realmente Sair, Qualquer Alteração Não Terá Efeito",
        "Alteração de Produto",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        opt,
        opt[0]
      );
      if (result == JOptionPane.YES_OPTION) {
        try {
          this.finalize();
          this.setVisible(false);
        } catch (Throwable ex) {
          ex.printStackTrace();
        }
      }
    } else {
      try {
        cap.destrutor();
      } catch (Throwable ex2) {}
      this.setVisible(false);
      try {
        this.finalize();
      } catch (Throwable ex1) {
        ex1.printStackTrace();
      }
    }
  }

  void btLimpar_actionPerformed(ActionEvent e) {
    tfCodProd.setText("");
    tfRefr.setText("");
    tfUnidade.setText("");
    tfApresentacao.setText("");
    tfEstoqueMinimo.setText("");
    tfEstoqueMaximo.setText("");
    tfPCusto.setText("");
    tfPVenda.setText("");
  }

  void tfCodProd_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfRefr_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfUnidade_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfApresentacao_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfEstoqueMinimo_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfEstoqueMaximo_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfPCusto_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfPVenda_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void cbProd_actionPerformed(ActionEvent e) {
    descricao = (String) cbProd.getSelectedItem();
    prods = cap.SelecionarProduto(descricao);

    tfCodProd.setEnabled(true);
    tfRefr.setEnabled(true);
    tfUnidade.setEnabled(true);
    tfApresentacao.setEnabled(true);
    tfEstoqueMinimo.setEnabled(true);
    tfEstoqueMaximo.setEnabled(true);
    tfPCusto.setEnabled(true);
    tfPVenda.setEnabled(true);
    btLimpar.setEnabled(true);
    btAlterar.setEnabled(true);

    // System.out.println(prods);
    //id de produto prods(0)
    idProduto = (String) (prods.get(0));
    tfPCusto.setText(decimo.format(Double.parseDouble((String) prods.get(1))));
    tfPVenda.setText(decimo.format(Double.parseDouble((String) prods.get(2))));
    //descricao prods(3)
    tfCodProd.setText((String) prods.get(4));
    tfRefr.setText((String) prods.get(5));
    tfUnidade.setText((String) prods.get(6));
    tfApresentacao.setText((String) prods.get(7));
    tfEstoqueMinimo.setText((String) prods.get(8));
    tfEstoqueMaximo.setText((String) prods.get(9));
  }

  void btAlterar_actionPerformed(ActionEvent e) {
    //validação de campos - classe Validar Campo
    if (
      !vc.valNulo(tfCodProd.getText(), "Código Produto") ||
      !vc.valNulo(tfRefr.getText(), "Refrigeração") ||
      !vc.valNulo(tfUnidade.getText(), "Unidade") ||
      !vc.valNulo(tfApresentacao.getText(), "Apresentação") ||
      !vc.valDouble(tfEstoqueMinimo.getText(), "Estoque Mínimo") ||
      !vc.valDouble(tfEstoqueMaximo.getText(), "Estoque Máximo") ||
      !vc.valDouble(tfPCusto.getText(), "Preço Custo") ||
      !vc.valDouble(tfPVenda.getText(), "Preço Venda")
    ) return;

    descricao = (String) cbProd.getSelectedItem();
    String codProd = tfCodProd.getText();
    String ref = tfRefr.getText();
    String un = tfUnidade.getText();
    String apres = tfApresentacao.getText();
    double estmin = Double.parseDouble(tfEstoqueMinimo.getText());
    double estmax = Double.parseDouble(tfEstoqueMaximo.getText());
    double pCusto = Double.parseDouble(tfPCusto.getText());
    double pVenda = Double.parseDouble(tfPVenda.getText());
    cap.alterar(
      descricao,
      codProd,
      ref,
      un,
      apres,
      estmin,
      estmax,
      pCusto,
      pVenda,
      idProduto
    );

    JOptionPane.showMessageDialog(
      null,
      "Alteração Efetuada com Sucesso!",
      "Alteração de Produto",
      JOptionPane.INFORMATION_MESSAGE
    );

    try {
      this.finalize();
      new frAlterarProduto();
      this.setVisible(false);
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
  }

  void cbFornecedor_actionPerformed(ActionEvent e) {
    Vector produtos = new Vector();
    razaoSocial = (String) cbFornecedor.getSelectedItem();
    produtos = cap.SelecionarFornecedor(razaoSocial);
    produtos.trimToSize();
    cbProd.removeAllItems();
    for (int i = 0; i < produtos.size(); i++) cbProd.addItem(produtos.get(i));
  }
}

class frAlterarProduto_btSair_actionAdapter
  implements java.awt.event.ActionListener {

  frAlterarProduto adaptee;

  frAlterarProduto_btSair_actionAdapter(frAlterarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btSair_actionPerformed(e);
  }
}

class frAlterarProduto_btLimpar_actionAdapter
  implements java.awt.event.ActionListener {

  frAlterarProduto adaptee;

  frAlterarProduto_btLimpar_actionAdapter(frAlterarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btLimpar_actionPerformed(e);
  }
}

class frAlterarProduto_tfCodProd_keyAdapter extends java.awt.event.KeyAdapter {

  frAlterarProduto adaptee;

  frAlterarProduto_tfCodProd_keyAdapter(frAlterarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfCodProd_keyPressed(e);
  }
}

class frAlterarProduto_tfRefr_keyAdapter extends java.awt.event.KeyAdapter {

  frAlterarProduto adaptee;

  frAlterarProduto_tfRefr_keyAdapter(frAlterarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfRefr_keyPressed(e);
  }
}

class frAlterarProduto_tfUnidade_keyAdapter extends java.awt.event.KeyAdapter {

  frAlterarProduto adaptee;

  frAlterarProduto_tfUnidade_keyAdapter(frAlterarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfUnidade_keyPressed(e);
  }
}

class frAlterarProduto_tfApresentacao_keyAdapter
  extends java.awt.event.KeyAdapter {

  frAlterarProduto adaptee;

  frAlterarProduto_tfApresentacao_keyAdapter(frAlterarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfApresentacao_keyPressed(e);
  }
}

class frAlterarProduto_tfEstoqueMinimo_keyAdapter
  extends java.awt.event.KeyAdapter {

  frAlterarProduto adaptee;

  frAlterarProduto_tfEstoqueMinimo_keyAdapter(frAlterarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfEstoqueMinimo_keyPressed(e);
  }
}

class frAlterarProduto_tfEstoqueMaximo_keyAdapter
  extends java.awt.event.KeyAdapter {

  frAlterarProduto adaptee;

  frAlterarProduto_tfEstoqueMaximo_keyAdapter(frAlterarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfEstoqueMaximo_keyPressed(e);
  }
}

class frAlterarProduto_tfPCusto_keyAdapter extends java.awt.event.KeyAdapter {

  frAlterarProduto adaptee;

  frAlterarProduto_tfPCusto_keyAdapter(frAlterarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfPCusto_keyPressed(e);
  }
}

class frAlterarProduto_tfPVenda_keyAdapter extends java.awt.event.KeyAdapter {

  frAlterarProduto adaptee;

  frAlterarProduto_tfPVenda_keyAdapter(frAlterarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfPVenda_keyPressed(e);
  }
}

class frAlterarProduto_cbProd_actionAdapter
  implements java.awt.event.ActionListener {

  frAlterarProduto adaptee;

  frAlterarProduto_cbProd_actionAdapter(frAlterarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.cbProd_actionPerformed(e);
  }
}

class frAlterarProduto_btAlterar_actionAdapter
  implements java.awt.event.ActionListener {

  frAlterarProduto adaptee;

  frAlterarProduto_btAlterar_actionAdapter(frAlterarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btAlterar_actionPerformed(e);
  }
}

class frAlterarProduto_cbFornecedor_actionAdapter
  implements java.awt.event.ActionListener {

  frAlterarProduto adaptee;

  frAlterarProduto_cbFornecedor_actionAdapter(frAlterarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.cbFornecedor_actionPerformed(e);
  }
}
