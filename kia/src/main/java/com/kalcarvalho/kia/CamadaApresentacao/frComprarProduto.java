package CamadaApresentacao;

import CamadaNegocios.Data;
import Controladoras.CtrCompra;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class frComprarProduto extends JFrame {

  private frCadastrarFornecedor fcf;
  private frCadastrarProduto fcp;
  private CtrCompra cp;
  private int id3;
  private Vector cabeca;
  private Vector corpo;
  private Vector estoque;
  private Vector printer;
  private String idFornecedor; //passa o cnpj para produto buscar id
  private boolean ativa;
  Data data = new Data();
  JPanel contentPane;
  JPanel jPanel1 = new JPanel();
  JLabel lbNumNota = new JLabel();
  JTextField tfNumNota = new JTextField();
  JLabel lbEmissao = new JLabel();
  JLabel lbFornecedor = new JLabel();
  JComboBox cbFornecedor;
  JLabel lbVencto = new JLabel();
  JFormattedTextField tfVencto = new JFormattedTextField();
  JPanel jPanel2 = new JPanel();
  JLabel lbPreco = new JLabel();
  JTextField tfPreco = new JTextField();
  JFormattedTextField tfValidade = new JFormattedTextField();
  JLabel lbProduto = new JLabel();
  JTextField tfQuantidade = new JTextField();
  JLabel lbQuantidade = new JLabel();
  JLabel lbValidade = new JLabel();
  JComboBox cbProduto;
  JButton btEntrarItem = new JButton();
  JPanel jPanel4 = new JPanel();
  JButton btComprar = new JButton();
  JButton btSair = new JButton();
  JTextField tfTotal = new JTextField();
  JLabel lbPreco1 = new JLabel();
  JButton btCancelar = new JButton();
  JFormattedTextField tfEmissao = new JFormattedTextField();
  JPanel paneGrid = new JPanel();
  BorderLayout bLayout = new BorderLayout();
  JScrollPane scroller = new JScrollPane();
  JTable tabela = new JTable();
  DecimalFormat decimo = new DecimalFormat("0.00");
  JButton btNovoFornecedor = new JButton();
  JButton btNovoProduto = new JButton();
  JLabel lbUnidade = new JLabel();

  //Construct the frame
  public frComprarProduto() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
      this.formatWindow();
      this.formatHeaderDBGrid();
      estoque = new Vector();
      printer = new Vector();
      ativa = false;
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //Component initialization
  private void jbInit() throws Exception {
    cp = new CtrCompra();
    id3 = 0;
    contentPane = (JPanel) this.getContentPane();
    contentPane.setLayout(null);
    this.setEnabled(true);
    this.setResizable(false);
    this.setSize(new Dimension(503, 380));
    this.setTitle("Lançamento de Compras");
    jPanel1.setBorder(BorderFactory.createEtchedBorder());
    jPanel1.setBounds(new Rectangle(4, 11, 488, 64));
    jPanel1.setLayout(null);
    lbNumNota.setMaximumSize(new Dimension(50, 16));
    lbNumNota.setDisplayedMnemonic('0');
    lbNumNota.setHorizontalAlignment(SwingConstants.RIGHT);
    lbNumNota.setText("Nº Nota:");
    lbNumNota.setBounds(new Rectangle(29, 11, 48, 15));
    tfNumNota.setNextFocusableComponent(tfEmissao);
    tfNumNota.setPreferredSize(new Dimension(80, 22));
    tfNumNota.setText("");
    tfNumNota.setHorizontalAlignment(SwingConstants.RIGHT);
    tfNumNota.setBounds(new Rectangle(85, 8, 80, 22));
    lbEmissao.setHorizontalAlignment(SwingConstants.RIGHT);
    lbEmissao.setText("Data de Emissão:");
    lbEmissao.setBounds(new Rectangle(293, 11, 101, 15));
    cbFornecedor = new JComboBox(cp.preencherForn());
    cbFornecedor.setAutoscrolls(false);
    cbFornecedor.setDebugGraphicsOptions(0);
    cbFornecedor.setNextFocusableComponent(tfVencto);
    cbFornecedor.setPreferredSize(new Dimension(140, 22));
    cbFornecedor.setMaximumRowCount(10);
    cbFornecedor.setSelectedIndex(0);
    cbFornecedor.setBounds(new Rectangle(85, 35, 145, 22));
    cbFornecedor.setActionCommand("comboBoxChanged");
    cbProduto = new JComboBox();
    cbProduto.setEnabled(false);
    cbProduto.setNextFocusableComponent(tfValidade);
    cbProduto.setPreferredSize(new Dimension(140, 22));
    cbProduto.setMaximumRowCount(10);
    cbProduto.setBounds(new Rectangle(85, 9, 144, 22));
    cbProduto.setActionCommand("comboBoxChanged");
    lbFornecedor.setHorizontalAlignment(SwingConstants.RIGHT);
    lbFornecedor.setText("Fornecedor:");
    lbFornecedor.setBounds(new Rectangle(11, 40, 68, 15));
    lbVencto.setHorizontalAlignment(SwingConstants.RIGHT);
    lbVencto.setText("Vencimento:");
    lbVencto.setBounds(new Rectangle(320, 38, 74, 15));
    tfVencto.setDoubleBuffered(false);
    tfVencto.setMaximumSize(new Dimension(10, 10));
    tfVencto.setNextFocusableComponent(cbProduto);
    tfVencto.setPreferredSize(new Dimension(80, 22));
    tfVencto.setVerifyInputWhenFocusTarget(true);
    tfVencto.setHorizontalAlignment(SwingConstants.RIGHT);
    tfVencto.setBounds(new Rectangle(401, 35, 80, 22));
    tfVencto.addKeyListener(new frComprarProduto_tfVencto_keyAdapter(this));
    jPanel2.setLayout(null);
    jPanel2.setBackground(UIManager.getColor("control"));
    jPanel2.setBorder(BorderFactory.createEtchedBorder());
    jPanel2.setBounds(new Rectangle(5, 73, 488, 104));
    lbPreco.setHorizontalAlignment(SwingConstants.RIGHT);
    lbPreco.setText("Preço: R$");
    lbPreco.setBounds(new Rectangle(337, 38, 60, 15));
    tfPreco.setPreferredSize(new Dimension(80, 22));
    tfPreco.setHorizontalAlignment(SwingConstants.RIGHT);
    tfPreco.setBounds(new Rectangle(401, 34, 80, 22));
    tfValidade.setNextFocusableComponent(tfQuantidade);
    tfValidade.setPreferredSize(new Dimension(80, 22));
    tfValidade.setHorizontalAlignment(SwingConstants.RIGHT);
    tfValidade.setBounds(new Rectangle(401, 8, 80, 22));
    tfValidade.addKeyListener(new frComprarProduto_tfValidade_keyAdapter(this));
    lbProduto.setHorizontalAlignment(SwingConstants.RIGHT);
    lbProduto.setText("Produto:");
    lbProduto.setBounds(new Rectangle(28, 11, 50, 15));
    tfQuantidade.setNextFocusableComponent(btEntrarItem);
    tfQuantidade.setPreferredSize(new Dimension(80, 22));
    tfQuantidade.setText("");
    tfQuantidade.setHorizontalAlignment(SwingConstants.RIGHT);
    tfQuantidade.setBounds(new Rectangle(85, 34, 59, 22));
    tfQuantidade.addActionListener(
      new frComprarProduto_tfQuantidade_actionAdapter(this)
    );
    lbQuantidade.setHorizontalAlignment(SwingConstants.RIGHT);
    lbQuantidade.setText("Quantidade:");
    lbQuantidade.setBounds(new Rectangle(10, 37, 68, 15));
    lbValidade.setHorizontalAlignment(SwingConstants.RIGHT);
    lbValidade.setText("Validade:");
    lbValidade.setBounds(new Rectangle(337, 11, 60, 15));
    btEntrarItem.setBounds(new Rectangle(10, 70, 94, 25));
    btEntrarItem.setEnabled(false);
    btEntrarItem.setNextFocusableComponent(cbProduto);
    btEntrarItem.setContentAreaFilled(true);
    btEntrarItem.setMnemonic('E');
    btEntrarItem.setText("Entrar Item");
    btEntrarItem.addActionListener(
      new frComprarProduto_btEntrarItem_actionAdapter(this)
    );
    btComprar.setBounds(new Rectangle(98, 12, 91, 25));
    btComprar.setActionCommand("");
    btComprar.setMnemonic('C');
    btComprar.setText("Comprar");
    btComprar.addActionListener(
      new frComprarProduto_btComprar_actionAdapter(this)
    );
    btSair.setBounds(new Rectangle(307, 12, 91, 25));
    btSair.setPreferredSize(new Dimension(80, 25));
    btSair.setMnemonic('S');
    btSair.setText("Sair");
    btSair.addActionListener(new frComprarProduto_btSair_actionAdapter(this));
    jPanel4.setLayout(null);
    tfTotal.setBackground(Color.black);
    tfTotal.setFont(new java.awt.Font("SansSerif", 0, 11));
    tfTotal.setForeground(Color.yellow);
    tfTotal.setPreferredSize(new Dimension(80, 22));
    tfTotal.setEditable(false);
    tfTotal.setText("");
    tfTotal.setHorizontalAlignment(SwingConstants.RIGHT);
    tfTotal.setBounds(new Rectangle(401, 72, 80, 22));
    lbPreco1.setHorizontalAlignment(SwingConstants.RIGHT);
    lbPreco1.setText("Total: R$");
    lbPreco1.setBounds(new Rectangle(343, 76, 54, 15));
    btCancelar.setText("Cancelar");
    btCancelar.addActionListener(
      new frComprarProduto_btCancelar_actionAdapter(this)
    );
    btCancelar.setMnemonic('N');
    btCancelar.setActionCommand("");
    btCancelar.setBounds(new Rectangle(203, 12, 91, 25));
    btCancelar.setEnabled(false);
    tfEmissao.setText(data.getCurrentDate("dd/MM/yyyy"));
    tfEmissao.setHorizontalAlignment(SwingConstants.RIGHT);
    tfEmissao.setNextFocusableComponent(cbFornecedor);
    tfEmissao.setColumns(10);
    tfEmissao.setScrollOffset(0);
    tfEmissao.setBounds(new Rectangle(401, 8, 80, 22));
    tfEmissao.setValue(null);
    tfEmissao.addKeyListener(new frComprarProduto_tfEmissao_keyAdapter(this));
    jPanel4.setBounds(new Rectangle(4, 304, 488, 40));
    paneGrid.setBounds(new Rectangle(4, 185, 487, 116));
    paneGrid.setLayout(bLayout);
    tabela.setDebugGraphicsOptions(0);
    tabela.setCellSelectionEnabled(false);
    tabela.setGridColor(new Color(100, 0, 100));
    scroller
      .getViewport()
      .setBackground(UIManager.getColor("controlLtHighlight"));
    scroller.setAutoscrolls(true);
    btNovoFornecedor.setBounds(new Rectangle(240, 32, 61, 25));
    btNovoFornecedor.setText("novo");
    btNovoFornecedor.addActionListener(
      new frComprarProduto_btNovoFornecedor_actionAdapter(this)
    );
    btNovoProduto.setBounds(new Rectangle(239, 6, 62, 25));
    btNovoProduto.setText("novo");
    btNovoProduto.addActionListener(
      new frComprarProduto_btNovoProduto_actionAdapter(this)
    );
    lbUnidade.setBounds(new Rectangle(151, 37, 34, 15));
    jPanel1.add(lbNumNota, null);
    jPanel1.add(tfNumNota, null);
    jPanel1.add(cbFornecedor, null);
    jPanel1.add(tfVencto, null);
    jPanel1.add(lbEmissao, null);
    jPanel1.add(lbVencto, null);
    jPanel1.add(tfEmissao, null);
    jPanel1.add(lbFornecedor, null);
    jPanel1.add(btNovoFornecedor, null);
    jPanel2.add(lbProduto, null);
    jPanel2.add(cbProduto, null);
    jPanel2.add(tfQuantidade, null);
    jPanel2.add(lbQuantidade, null);
    jPanel2.add(btEntrarItem, null);
    jPanel2.add(tfValidade, null);
    jPanel2.add(lbValidade, null);
    jPanel2.add(tfPreco, null);
    jPanel2.add(tfTotal, null);
    jPanel2.add(lbPreco, null);
    jPanel2.add(lbPreco1, null);
    jPanel2.add(btNovoProduto, null);
    jPanel2.add(lbUnidade, null);
    contentPane.add(jPanel1, null);
    contentPane.add(paneGrid, null);
    paneGrid.add(scroller, BorderLayout.CENTER);
    contentPane.add(jPanel4, null);
    jPanel4.add(btCancelar, null);
    jPanel4.add(btSair, null);
    jPanel4.add(btComprar, null);
    contentPane.add(jPanel2, null);
    scroller.getViewport().add(tabela, null);
    tfNumNota.setFocusable(true);

    cbFornecedor.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
          cbFornecedor_actionPerformed(e);
        }
      }
    );

    cbProduto.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
          cbProduto_actionPerformed(e);
        }
      }
    );
  }

  public void formatHeaderDBGrid() {
    cabeca = new Vector();
    corpo = new Vector();
    cabeca.addElement("Produto");
    cabeca.addElement("Qtde");
    cabeca.addElement("Preço");
    cabeca.addElement("Subtotal");
  }

  public void formatBodyDBGrid() {
    Vector linha = new Vector();
    linha.addElement(cbProduto.getSelectedItem());
    linha.addElement(tfQuantidade.getText());
    linha.addElement(tfPreco.getText());
    linha.addElement(
      decimo.format(
        Double.parseDouble(tfPreco.getText()) *
        Integer.parseInt(tfQuantidade.getText())
      )
    );
    corpo.addElement(linha);
    tabela.setModel(new DefaultTableModel(corpo, cabeca));
  }

  public void formatHeaderNF() {
    printer.addElement("\nNº Nota: " + tfNumNota.getText() + "\t");
    printer.addElement("Emissão: " + tfEmissao.getText() + "\n");
    printer.addElement(
      "Fornecedor: " + (String) cbFornecedor.getSelectedItem() + "\t"
    );
    printer.addElement("Vencimento: " + tfVencto.getText() + "\n\n");
    printer.addElement("COD.\tDESCR.        \tQUANT.\tPRECO\tSUBTOT.\n");
  }

  public void formatBodyNF() {
    printer.addElement(Integer.toString(id3) + "\t");
    printer.addElement((String) cbProduto.getSelectedItem() + "        \t");
    printer.addElement(tfQuantidade.getText() + "\t");
    printer.addElement(tfPreco.getText() + "\t");
    printer.addElement(
      decimo.format(
        Double.parseDouble(tfPreco.getText()) *
        Integer.parseInt(tfQuantidade.getText())
      ) +
      "\n"
    );
  }

  public void formatFootNF() {
    printer.addElement("\nValor Total da Nota: R$ " + tfTotal.getText());
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

  public void formatTextField(JFormattedTextField tf) {
    if (tf.getText().length() < 2) return; else if (
      tf.getText().length() == 2
    ) tf.setText(tf.getText() + "/"); else if (
      tf.getText().length() == 5
    ) tf.setText(tf.getText() + "/"); else if (
      tf.getText().length() == 9
    ) tf.nextFocus(); else if (tf.getText().length() > 9) {
      tf.setText(tf.getText().substring(tf.getText().length() - 1));
      tf.nextFocus();
    }
  }

  void btSair_actionPerformed(ActionEvent e) {
    if (ativa) {
      Object opt[] = { "Sim", "Não" };
      int result = JOptionPane.showOptionDialog(
        this,
        "Deseja Cancelar essa Compra?",
        "Lançar Compras",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        opt,
        opt[0]
      );
      if (result == JOptionPane.YES_OPTION) {
        try {
          cp.cancelar(estoque);
          cp.destrutor();
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

  void cbFornecedor_actionPerformed(ActionEvent e) {
    String razaoSocial = (String) cbFornecedor.getSelectedItem();
    idFornecedor = cp.selecionarFornecedor(razaoSocial); //recebe o id de fornecedor
    Vector tmp = cp.preencherProd(idFornecedor);
    tmp.trimToSize(); //reduz a capacidade do Vector para o numero elementos
    String id2[] = new String[tmp.size()]; //cria string do tamanho de vector
    tmp.copyInto(id2); //copia vector para string
    cbProduto.removeAllItems();
    for (int i = 0; i < id2.length; i++) cbProduto.addItem(id2[i]);
    cbProduto.setEnabled(true);
    btEntrarItem.setEnabled(true);
  }

  void cbProduto_actionPerformed(ActionEvent e) {
    String nome = (String) cbProduto.getSelectedItem(); //trocar variavel para nome
    id3 = cp.selecionarProduto(nome, idFornecedor); //recebe id de produto
    tfPreco.setEditable(true);
    lbUnidade.setText(cp.carregarUnidade(id3));
    tfPreco.setText(Double.toString(cp.carregarPreco(id3)));
  }

  void btEntrarItem_actionPerformed(ActionEvent e) {
    cbFornecedor.setEnabled(false);
    cbFornecedor.setEditable(false);
    ativa = true;
    btCancelar.setEnabled(true);

    //tratar quantidade
    String qtd = tfQuantidade.getText();
    try {
      double tmp = Double.parseDouble(qtd);
    } catch (NumberFormatException ex) {
      ex.printStackTrace();
      JOptionPane.showMessageDialog(
        null,
        "Entre com um Número Inteiro ou Decimal",
        "Campo Quantidade Inválido",
        JOptionPane.ERROR_MESSAGE
      );
      return;
    }

    //tratar validade
    String vali = tfValidade.getText();
    if (cp.parseMySQL(vali)) {
      vali = cp.getDataMysql();
      tfTotal.setText(
        decimo.format(
          cp.entrarItem(
            idFornecedor,
            tfNumNota.getText(),
            id3,
            vali,
            Integer.parseInt(qtd),
            Double.parseDouble(tfPreco.getText()),
            tfEmissao.getText()
          )
        )
      );

      this.formatBodyDBGrid();

      estoque.addElement(qtd);
      estoque.addElement(Integer.toString(id3));
    } else {
      JOptionPane.showMessageDialog(
        null,
        "Entre com o Formato: 'dd/mm/aaaa'",
        "Data de Validade Inválida",
        JOptionPane.ERROR_MESSAGE
      );
    }
  }

  void btComprar_actionPerformed(ActionEvent e) {
    String data = tfEmissao.getText();
    String vencimento = tfVencto.getText();
    String nota = tfNumNota.getText();
    //tratar Nota Fiscal
    try {
      int tmp = Integer.parseInt(nota);
    } catch (NumberFormatException ex) {
      ex.printStackTrace();
      JOptionPane.showMessageDialog(
        null,
        "Entre com o Número da Nota Fiscal",
        "Campo Nota Fiscal Inválido",
        JOptionPane.ERROR_MESSAGE
      );
      return;
    }

    //tratar dataEmissao
    if (cp.parseMySQL(data)) data = cp.getDataMysql(); else {
      JOptionPane.showMessageDialog(
        null,
        "Entre com o Formato: 'dd/mm/aaaa'",
        "Data de Emissão Inválida",
        JOptionPane.ERROR_MESSAGE
      );
      return;
    }

    //tratar dataVencimento
    if (cp.parseMySQL(vencimento)) vencimento = cp.getDataMysql(); else {
      JOptionPane.showMessageDialog(
        null,
        "Entre com o Formato: 'dd/mm/aaaa'",
        "Data de Vencimento Inválida",
        JOptionPane.ERROR_MESSAGE
      );
      return;
    }
    cp.comprar(vencimento, data, nota, idFornecedor);
    JOptionPane.showMessageDialog(
      null,
      "Compra Lançada com Sucesso!",
      "",
      JOptionPane.INFORMATION_MESSAGE
    );

    try {
      this.finalize();
      new frComprarProduto();
      this.setVisible(false);
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
  }

  void btCancelar_actionPerformed(ActionEvent e) {
    if (ativa) {
      cp.cancelar(estoque);

      JOptionPane.showMessageDialog(
        null,
        "Compra Cancelada com Sucesso!",
        "Lançar Compras",
        JOptionPane.INFORMATION_MESSAGE
      );

      try {
        this.finalize();
        new frComprarProduto();
        this.setVisible(false);
      } catch (Throwable ex) {
        ex.printStackTrace();
      }
    }
  }

  void tfQuantidade_actionPerformed(ActionEvent e) {
    this.btEntrarItem_actionPerformed(e);
  }

  void tfVencto_keyTyped(KeyEvent e) {
    this.formatTextField(tfVencto);
  }

  void tfEmissao_keyTyped(KeyEvent e) {
    this.formatTextField(tfEmissao);
  }

  void tfValidade_keyTyped(KeyEvent e) {
    this.formatTextField(tfValidade);
  }

  void btNovoFornecedor_actionPerformed(ActionEvent e) {
    fcf = new frCadastrarFornecedor();
    Vector tmp = cp.preencherForn();
    cbFornecedor.removeAllItems();
    for (int i = 0; i < tmp.size(); i++) cbFornecedor.addItem(tmp.get(i));
  }

  void btNovoProduto_actionPerformed(ActionEvent e) {
    fcp = new frCadastrarProduto();
    Vector tmp = cp.preencherProd(idFornecedor);
    cbProduto.removeAllItems();
    for (int i = 0; i < tmp.size(); i++) cbProduto.addItem(tmp.get(i));
  }
}

class frComprarProduto_btSair_actionAdapter
  implements java.awt.event.ActionListener {

  frComprarProduto adaptee;

  frComprarProduto_btSair_actionAdapter(frComprarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btSair_actionPerformed(e);
  }
}

class frComprarProduto_btComprar_actionAdapter
  implements java.awt.event.ActionListener {

  frComprarProduto adaptee;

  frComprarProduto_btComprar_actionAdapter(frComprarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btComprar_actionPerformed(e);
  }
}

class frComprarProduto_btEntrarItem_actionAdapter
  implements java.awt.event.ActionListener {

  frComprarProduto adaptee;

  frComprarProduto_btEntrarItem_actionAdapter(frComprarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btEntrarItem_actionPerformed(e);
  }
}

class frComprarProduto_btCancelar_actionAdapter
  implements java.awt.event.ActionListener {

  frComprarProduto adaptee;

  frComprarProduto_btCancelar_actionAdapter(frComprarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btCancelar_actionPerformed(e);
  }
}

class frComprarProduto_tfQuantidade_actionAdapter
  implements java.awt.event.ActionListener {

  frComprarProduto adaptee;

  frComprarProduto_tfQuantidade_actionAdapter(frComprarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.tfQuantidade_actionPerformed(e);
  }
}

class frComprarProduto_tfVencto_keyAdapter extends java.awt.event.KeyAdapter {

  frComprarProduto adaptee;

  frComprarProduto_tfVencto_keyAdapter(frComprarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void keyTyped(KeyEvent e) {
    adaptee.tfVencto_keyTyped(e);
  }
}

class frComprarProduto_tfEmissao_keyAdapter extends java.awt.event.KeyAdapter {

  frComprarProduto adaptee;

  frComprarProduto_tfEmissao_keyAdapter(frComprarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void keyTyped(KeyEvent e) {
    adaptee.tfEmissao_keyTyped(e);
  }
}

/*Vasco 4 x 0 Botafogo*/

class frComprarProduto_tfValidade_keyAdapter extends java.awt.event.KeyAdapter {

  frComprarProduto adaptee;

  frComprarProduto_tfValidade_keyAdapter(frComprarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void keyTyped(KeyEvent e) {
    adaptee.tfValidade_keyTyped(e);
  }
}

class frComprarProduto_btNovoFornecedor_actionAdapter
  implements java.awt.event.ActionListener {

  frComprarProduto adaptee;

  frComprarProduto_btNovoFornecedor_actionAdapter(frComprarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btNovoFornecedor_actionPerformed(e);
  }
}

class frComprarProduto_btNovoProduto_actionAdapter
  implements java.awt.event.ActionListener {

  frComprarProduto adaptee;

  frComprarProduto_btNovoProduto_actionAdapter(frComprarProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btNovoProduto_actionPerformed(e);
  }
}
