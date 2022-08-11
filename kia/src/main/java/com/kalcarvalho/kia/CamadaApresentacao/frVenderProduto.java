package CamadaApresentacao;

import CamadaNegocios.Data;
import Controladoras.CtrVenda;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */
public class frVenderProduto extends JFrame {

  private frCadastrarProduto fcp;
  private frCadastrarCliente fcc;
  private CtrVenda ctv;
  private int id3;
  private Vector cabeca;
  private Vector corpo;
  private Vector estoque;
  private Vector printer;
  private Vector Produto;
  private Vector Validade;
  private boolean ativa;
  private int itens;
  Data dt = new Data();
  JPanel contentPane;
  JMenuBar jMenuBar1 = new JMenuBar();
  JPanel jPanel1 = new JPanel();
  JLabel lbCodCliente = new JLabel();
  JTextField tfCodCliente = new JTextField();
  JLabel lbEmissao = new JLabel();
  JLabel lbCliente = new JLabel();
  JComboBox cbCliente;
  JLabel lbVencto = new JLabel();
  JFormattedTextField tfVencto = new JFormattedTextField();
  JPanel jPanel2 = new JPanel();
  JLabel lbPreco = new JLabel();
  JTextField tfPreco = new JTextField();
  JLabel lbProduto = new JLabel();
  JTextField tfQuantidade = new JTextField();
  JLabel lbQuantidade = new JLabel();
  JLabel lbValidade = new JLabel();
  JComboBox cbProduto;
  JButton btEntrarItem = new JButton();
  //   JButton btLimpar = new JButton();
  JPanel jPanel4 = new JPanel();
  JButton btVender = new JButton();
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
  JLabel jLabel1 = new JLabel();
  JTextField tfNumNota = new JTextField();
  JComboBox cbValidade = new JComboBox();
  JLabel lbEstoque = new JLabel();
  JTextField tfEstoque = new JTextField();
  JProgressBar progresso = new JProgressBar();
  FlowLayout flowLayout1 = new FlowLayout();
  JButton btNovoCliente = new JButton();
  JLabel lbUnidade = new JLabel();

  //Construct the frame
  public frVenderProduto() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
      this.formatWindow();
      this.formatHeaderDBGrid();
      estoque = new Vector();
      printer = new Vector();
      Produto = new Vector();
      Produto = new Vector();
      ativa = false;
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //Component initialization
  private void jbInit() throws Exception {
    ctv = new CtrVenda();
    id3 = itens = 0;
    this.setSize(new Dimension(505, 390));
    contentPane = (JPanel) this.getContentPane();
    contentPane.setLayout(null);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setEnabled(true);
    this.setResizable(false);
    this.setSize(new Dimension(499, 382));
    this.setTitle("Lançamento de Vendas");
    jPanel1.setBorder(BorderFactory.createEtchedBorder());
    jPanel1.setBounds(new Rectangle(4, 11, 488, 64));
    jPanel1.setLayout(null);
    lbCodCliente.setMaximumSize(new Dimension(50, 16));
    lbCodCliente.setDisplayedMnemonic('0');
    lbCodCliente.setHorizontalAlignment(SwingConstants.RIGHT);
    lbCodCliente.setText("Cód. Cliente:");
    lbCodCliente.setBounds(new Rectangle(9, 11, 68, 15));
    tfCodCliente.setNextFocusableComponent(tfEmissao);
    tfCodCliente.setPreferredSize(new Dimension(80, 22));
    tfCodCliente.setVerifyInputWhenFocusTarget(true);
    tfCodCliente.setEditable(false);
    tfCodCliente.setText("");
    tfCodCliente.setHorizontalAlignment(SwingConstants.RIGHT);
    tfCodCliente.setBounds(new Rectangle(85, 8, 80, 22));
    lbEmissao.setHorizontalAlignment(SwingConstants.RIGHT);
    lbEmissao.setText("Emissão:");
    lbEmissao.setBounds(new Rectangle(173, 12, 55, 15));
    cbCliente = new JComboBox(ctv.preencherCliente());
    cbCliente.setEnabled(false);
    cbCliente.setAutoscrolls(false);
    cbCliente.setDebugGraphicsOptions(0);
    cbCliente.setNextFocusableComponent(tfVencto);
    cbCliente.setPreferredSize(new Dimension(140, 22));
    cbCliente.setMaximumRowCount(10);
    cbCliente.setSelectedItem(null);
    cbCliente.setBounds(new Rectangle(85, 35, 145, 22));
    cbCliente.addActionListener(new cbCliente_ActionListener(this));
    cbProduto = new JComboBox(ctv.preencherProduto());
    cbProduto.setEnabled(false);
    cbProduto.setNextFocusableComponent(cbValidade);
    cbProduto.setPreferredSize(new Dimension(140, 22));
    cbProduto.setMaximumRowCount(10);
    cbProduto.setBounds(new Rectangle(85, 8, 144, 22));
    cbProduto.addActionListener(
      new frVenderProduto_cbProduto_actionAdapter(this)
    );
    cbProduto.setActionCommand("comboBoxChanged");
    lbCliente.setHorizontalAlignment(SwingConstants.RIGHT);
    lbCliente.setLabelFor(cbCliente);
    lbCliente.setText("Cliente:");
    lbCliente.setBounds(new Rectangle(9, 38, 68, 15));
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
    tfVencto.addKeyListener(new frVenderProduto_tfVencto_keyAdapter(this));
    jPanel2.setLayout(null);
    jPanel2.setBorder(BorderFactory.createEtchedBorder());
    jPanel2.setBounds(new Rectangle(5, 73, 488, 104));
    lbPreco.setHorizontalAlignment(SwingConstants.RIGHT);
    lbPreco.setText("Preço: R$");
    lbPreco.setBounds(new Rectangle(337, 38, 60, 15));
    tfPreco.setPreferredSize(new Dimension(80, 22));
    tfPreco.setHorizontalAlignment(SwingConstants.RIGHT);
    tfPreco.setBounds(new Rectangle(401, 34, 80, 22));
    cbValidade.setNextFocusableComponent(tfQuantidade);
    lbProduto.setHorizontalAlignment(SwingConstants.RIGHT);
    lbProduto.setText("Produto:");
    lbProduto.setBounds(new Rectangle(28, 11, 50, 15));
    tfQuantidade.setNextFocusableComponent(btEntrarItem);
    tfQuantidade.setPreferredSize(new Dimension(80, 22));
    tfQuantidade.setText("");
    tfQuantidade.setHorizontalAlignment(SwingConstants.RIGHT);
    tfQuantidade.setBounds(new Rectangle(85, 34, 51, 22));
    tfQuantidade.addActionListener(
      new frVenderProduto_tfQuantidade_actionAdapter(this)
    );
    lbQuantidade.setHorizontalAlignment(SwingConstants.RIGHT);
    lbQuantidade.setText("Quantidade:");
    lbQuantidade.setBounds(new Rectangle(10, 38, 68, 15));
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
      new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
          btEntrarItem_actionPerformed(e);
        }
      }
    );
    btVender.setEnabled(false);
    btVender.setToolTipText("Clique aqui para confirmar a venda");
    btVender.setActionCommand("");
    btVender.setMnemonic('V');
    btVender.setText("Vender");
    btVender.addActionListener(
      new frVenderProduto_btVender_actionAdapter(this)
    );
    btSair.setPreferredSize(new Dimension(80, 25));
    btSair.setMnemonic('S');
    btSair.setText("Sair");
    btSair.addActionListener(new frVenderProduto_btSair_actionAdapter(this));
    jPanel4.setLayout(flowLayout1);
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
      new frVenderProduto_btCancelar_actionAdapter(this)
    );
    btCancelar.setMnemonic('N');
    btCancelar.setActionCommand("");
    btCancelar.setEnabled(false);
    tfEmissao.setHorizontalAlignment(SwingConstants.RIGHT);
    tfEmissao.setNextFocusableComponent(cbCliente);
    tfEmissao.setColumns(10);
    tfEmissao.setFocusAccelerator('E');
    tfEmissao.setScrollOffset(0);
    tfEmissao.setBounds(new Rectangle(232, 7, 80, 22));
    tfEmissao.addActionListener(
      new frVenderProduto_tfEmissao_actionAdapter(this)
    );
    tfEmissao.setValue(null);
    tfEmissao.addKeyListener(new frVenderProduto_tfEmissao_keyAdapter(this));
    jPanel4.setBounds(new Rectangle(4, 304, 488, 40));
    paneGrid.setBounds(new Rectangle(7, 185, 484, 116));
    paneGrid.setLayout(bLayout);
    tabela.setDebugGraphicsOptions(0);
    tabela.setCellSelectionEnabled(false);
    tabela.setGridColor(new Color(100, 0, 100));
    scroller.getViewport().setBackground(Color.white);
    scroller.setAutoscrolls(true);
    jLabel1.setText("Nº Nota:");
    jLabel1.setBounds(new Rectangle(338, 12, 46, 15));
    tfNumNota.setEditable(false);
    tfNumNota.setText("");
    tfNumNota.setHorizontalAlignment(SwingConstants.RIGHT);
    tfNumNota.setBounds(new Rectangle(401, 10, 80, 20));
    cbValidade.setBounds(new Rectangle(401, 6, 80, 22));
    cbValidade.addActionListener(
      new frVenderProduto_cbValidade_actionAdapter(this)
    );
    lbEstoque.setBounds(new Rectangle(197, 38, 48, 15));
    lbEstoque.setText("Estoque:");
    lbEstoque.setHorizontalAlignment(SwingConstants.LEFT);
    tfEstoque.setBounds(new Rectangle(254, 34, 58, 22));
    tfEstoque.setHorizontalAlignment(SwingConstants.RIGHT);
    tfEstoque.setText("");
    tfEstoque.setPreferredSize(new Dimension(80, 22));
    tfEstoque.setDisabledTextColor(Color.black);
    tfEstoque.setNextFocusableComponent(btEntrarItem);
    tfEstoque.setEditable(false);
    progresso.setForeground(SystemColor.desktop);
    progresso.setString("10%");
    progresso.setBounds(new Rectangle(195, 61, 117, 13));
    this.setJMenuBar(jMenuBar1);
    btNovoCliente.setBounds(new Rectangle(241, 34, 71, 23));
    btNovoCliente.setText("novo");
    btNovoCliente.addActionListener(
      new frVenderProduto_btNovoCliente_actionAdapter(this)
    );
    lbUnidade.setBounds(new Rectangle(148, 38, 32, 15));
    jPanel1.add(lbCodCliente, null);
    jPanel1.add(tfCodCliente, null);
    jPanel1.add(lbCliente, null);
    jPanel1.add(cbCliente, null);
    jPanel1.add(tfVencto, null);
    jPanel1.add(lbVencto, null);
    jPanel1.add(lbEmissao, null);
    jPanel1.add(tfEmissao, null);
    jPanel1.add(jLabel1, null);
    jPanel1.add(tfNumNota, null);
    jPanel1.add(btNovoCliente, null);
    jPanel2.add(lbProduto, null);
    jPanel2.add(cbProduto, null);
    jPanel2.add(tfQuantidade, null);
    jPanel2.add(lbQuantidade, null);
    //   jPanel2.add(btLimpar, null);
    jPanel2.add(btEntrarItem, null);
    jPanel2.add(lbValidade, null);
    jPanel2.add(tfPreco, null);
    jPanel2.add(tfTotal, null);
    jPanel2.add(lbPreco, null);
    jPanel2.add(lbPreco1, null);
    jPanel2.add(cbValidade, null);
    jPanel2.add(tfEstoque, null);
    contentPane.add(jPanel1, null);
    contentPane.add(paneGrid, null);
    paneGrid.add(scroller, BorderLayout.CENTER);
    contentPane.add(jPanel4, null);
    jPanel4.add(btVender, null);
    jPanel4.add(btCancelar, null);
    jPanel4.add(btSair, null);
    contentPane.add(jPanel2, null);
    scroller.getViewport().add(tabela, null);
    jPanel2.add(progresso, null);
    jPanel2.add(lbEstoque, null);
    jPanel2.add(lbUnidade, null);
    tfCodCliente.setFocusable(true);
  }

  public void formatHeaderDBGrid() {
    cabeca = new Vector();
    corpo = new Vector();
    cabeca.addElement("Produto");
    cabeca.addElement("Validade");
    cabeca.addElement("Qtde");
    cabeca.addElement("Preço");
    cabeca.addElement("Subtotal");
  }

  /**
   * Formata o Corpo da Tabela
   */
  public void formatBodyDBGrid() {
    Vector linha = new Vector();
    linha.addElement(cbProduto.getSelectedItem());
    linha.addElement(cbValidade.getSelectedItem());
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
    printer.addElement("\nNº Nota: " + tfCodCliente.getText() + "\t");
    printer.addElement("Emissão: " + tfEmissao.getText() + "\n");
    printer.addElement(
      "Fornecedor: " + (String) cbCliente.getSelectedItem() + "\t"
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

  public String dataMySqltoNormal(String s) {
    //s - 2004-02-31
    String dd, mm, aaaa;
    dd = s.substring(8, 10);
    mm = s.substring(5, 7);
    aaaa = s.substring(0, 4);
    return dd + "/" + mm + "/" + aaaa;
  }

  public void formatTextField(JFormattedTextField tf) {
    if (tf.getText().length() < 2) return; else if (
      tf.getText().length() == 2
    ) tf.setText(tf.getText() + "/"); else if (
      tf.getText().length() == 5
    ) tf.setText(tf.getText() + "/"); else if (tf.getText().length() == 9) {
      tf.nextFocus();
    } else if (tf.getText().length() > 9) {
      tf.setText(tf.getText().substring(tf.getText().length() - 1));
      tf.nextFocus();
    }
  }

  private void formatProgressBar(int est, int min, int max) {
    int perc = 0;

    progresso.doLayout();

    if (est < min || est > max) progresso.setForeground(
      new Color(255, 0, 0)
    ); else progresso.setForeground(new Color(0, 78, 152));

    try {
      perc = (est * 100) / max;
    } catch (Exception ex) {
      ex.printStackTrace();
      return;
    }

    progresso.setValue(perc);
    progresso.setToolTipText(Integer.toString(perc) + "%");
  }

  private void formatComboValidade() {
    String id = (String) cbProduto.getSelectedItem();
    Vector tmp = new Vector();
    Produto.remove(0);
    Produto.remove(0);
    Produto.trimToSize();
    tmp = (Vector) Produto.elementAt(0);
    tmp.trimToSize();
    cbValidade.removeAllItems();
    for (int i = 0; i < tmp.size(); i++) {
      cbValidade.addItem(this.dataMySqltoNormal((String) tmp.get(i)));
    }
    dt.parseMySQL((String) cbValidade.getSelectedItem());
    Validade = ctv.selecionarValidade(id3, dt.getDataMysql());
    tfEstoque.setText((String) Validade.get(0));
    this.formatProgressBar(
        Integer.parseInt(tfEstoque.getText()),
        Integer.parseInt((String) Validade.get(1)),
        Integer.parseInt((String) Validade.get(2))
      );
    /*tfEstoque.setText(
	  Integer.toString(
		 ctv.selecionarValidade(
			id3, (String) cbValidade.getSelectedItem()))); */

    cbProduto.setEnabled(true);
    btEntrarItem.setEnabled(true);
  }

  void btSair_actionPerformed(ActionEvent e) {
    if (ativa) {
      Object opt[] = { "Sim", "Não" };
      int result = JOptionPane.showOptionDialog(
        this,
        "Deseja Cancelar essa Venda?",
        "Lançar Vendas",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        opt,
        opt[0]
      );
      if (result == JOptionPane.YES_OPTION) {
        try {
          ctv.cancelar(estoque);
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

  void cbCliente_actionPerformed(ActionEvent e) {
    if (!cbProduto.isEnabled()) {
      cbProduto.setEnabled(true);
      btEntrarItem.setEnabled(true);
    }
    try {
      String id = (String) cbCliente.getSelectedItem();
      tfCodCliente.setText(ctv.selecionarCliente(id));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  void cbProduto_actionPerformed(ActionEvent e) {
    try {
      String id = (String) cbProduto.getSelectedItem();
      if (tfEmissao.getText() == "") return;
      dt.parseMySQL(tfEmissao.getText());
      Produto = ctv.selecionarProduto(id, dt.getDataMysql()); //recebe id de produto
      if (Produto == null) {
        return;
      }
      try {
        id3 = Integer.parseInt((String) Produto.get(0));
      } catch (NumberFormatException ex3) {
        return;
      }
      tfPreco.setEditable(true);
      //	 tfPreco.setText(decimo.format(Double.parseDouble((String)Produto.get(2))));
      try {
        tfPreco.setText((String) Produto.get(1));
      } catch (Exception ex2) {
        return;
      }
      try {
        lbUnidade.setText((String) Produto.get(3));
      } catch (Exception ex1) {
        return;
      }
      this.formatComboValidade();
    } catch (Exception ex) {
      ex.printStackTrace();
      return;
    }
  }

  private boolean validaEstoque() {
    if (
      Integer.parseInt(tfQuantidade.getText()) >
      Integer.parseInt(tfEstoque.getText())
    ) {
      JOptionPane.showMessageDialog(
        null,
        "<html>Há somente " +
        tfEstoque.getText() +
        " produtos" +
        " no estoque com esta validade.<p>Selecione outra validade para escolher mais.</html>"
      );
      tfQuantidade.setText(tfEstoque.getText());
      return false;
    }
    return true;
  }

  void btEntrarItem_actionPerformed(ActionEvent e) {
    Vector tmp2 = new Vector();

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

    if (Integer.parseInt(tfEstoque.getText()) == 0) return;

    //tratar validade
    if (this.validaEstoque() == false) return;
    String vali = (String) cbValidade.getSelectedItem();
    if (dt.parseMySQL(vali)) {
      vali = dt.getDataMysql();
      try {
        tmp2 =
          ctv.entrarItem(
            id3,
            vali,
            Integer.parseInt(qtd),
            Double.parseDouble(tfPreco.getText()),
            tfEmissao.getText()
          );
      } catch (NumberFormatException ex1) {
        ex1.printStackTrace();
      }

      tfTotal.setText(decimo.format(Double.parseDouble((String) tmp2.get(0))));
      this.formatBodyDBGrid();
      estoque.addElement(qtd);
      estoque.addElement(Integer.toString(id3));
      estoque.addElement(vali);
    } else {
      JOptionPane.showMessageDialog(
        null,
        "Entre com o Formato: 'dd/mm/aaaa'",
        "Data de Validade Inválida",
        JOptionPane.ERROR_MESSAGE
      );
    }
    if (itens == 0) {
      tfNumNota.setText((String) tmp2.get(1));
      btVender.setEnabled(true);
      cbCliente.setEnabled(false);
      cbCliente.setEditable(false);
      ativa = true;
      btCancelar.setEnabled(true);
    }

    itens++;
    dt.parseMySQL((String) cbValidade.getSelectedItem());
    Validade = ctv.selecionarValidade(id3, dt.getDataMysql());
    tfEstoque.setText((String) Validade.get(0));
    this.formatProgressBar(
        Integer.parseInt(tfEstoque.getText()),
        Integer.parseInt((String) Validade.get(1)),
        Integer.parseInt((String) Validade.get(2))
      );
  }

  void btVender_actionPerformed(ActionEvent e) {
    String data = tfEmissao.getText();
    String vencimento = tfVencto.getText();
    String idc = tfCodCliente.getText();
    String nota = tfNumNota.getText();
    //tratar dataEmissao
    if (dt.parseMySQL(data)) data = dt.getDataMysql(); else {
      JOptionPane.showMessageDialog(
        null,
        "Entre com o Formato: 'dd/mm/aaaa'",
        "Data de Emissão Inválida",
        JOptionPane.ERROR_MESSAGE
      );
      return;
    }

    //tratar dataVencimento
    if (dt.parseMySQL(vencimento)) vencimento = dt.getDataMysql(); else {
      JOptionPane.showMessageDialog(
        null,
        "Entre com o Formato: 'dd/mm/aaaa'",
        "Data de Vencimento Inválida",
        JOptionPane.ERROR_MESSAGE
      );
      return;
    }
    ctv.vender(vencimento, data, nota, idc);
    JOptionPane.showMessageDialog(
      null,
      "Venda Lançada com Sucesso!",
      "",
      JOptionPane.INFORMATION_MESSAGE
    );

    try {
      this.finalize();
      new frVenderProduto();
      this.setVisible(false);
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
  }

  void btCancelar_actionPerformed(ActionEvent e) {
    if (ativa) {
      ctv.cancelar(estoque);

      JOptionPane.showMessageDialog(
        null,
        "Venda Cancelada com Sucesso!",
        "Lançar Vendas",
        JOptionPane.INFORMATION_MESSAGE
      );

      try {
        this.finalize();
        new frVenderProduto();
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
    if (tfEmissao.getText().length() == 9) cbCliente.setEnabled(true);
    this.formatTextField(tfEmissao);
  }

  void cbValidade_actionPerformed(ActionEvent e) {
    dt.parseMySQL((String) cbValidade.getSelectedItem());
    Validade = ctv.selecionarValidade(id3, dt.getDataMysql());
    tfEstoque.setText((String) Validade.get(0));
    this.formatProgressBar(
        Integer.parseInt(tfEstoque.getText()),
        Integer.parseInt((String) Validade.get(1)),
        Integer.parseInt((String) Validade.get(2))
      );
    /*tfEstoque.setText(
	   Integer.toString(
		  ctv.selecionarValidade(
			 id3, (String) cbValidade.getSelectedItem()))); */
  }

  void tfEmissao_actionPerformed(ActionEvent e) {}

  void btNovoCliente_actionPerformed(ActionEvent e) {
    fcc = new frCadastrarCliente();
    Vector tmp = ctv.preencherCliente();
    cbCliente.removeAllItems();
    for (int i = 0; i < tmp.size(); i++) cbCliente.addItem(tmp.get(i));
  }

  void btNovoProduto_actionPerformed(ActionEvent e) {
    fcp = new frCadastrarProduto();
    Vector tmp = ctv.preencherProduto();
    cbProduto.removeAllItems();
    for (int i = 0; i < tmp.size(); i++) cbProduto.addItem(tmp.get(i));
  }
}

class frVenderProduto_btSair_actionAdapter
  implements java.awt.event.ActionListener {

  frVenderProduto adaptee;

  frVenderProduto_btSair_actionAdapter(frVenderProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btSair_actionPerformed(e);
  }
}

class frVenderProduto_btVender_actionAdapter
  implements java.awt.event.ActionListener {

  frVenderProduto adaptee;

  frVenderProduto_btVender_actionAdapter(frVenderProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btVender_actionPerformed(e);
  }
}

class frVenderProduto_btEntrarItem_actionAdapter //1
  implements java.awt.event.ActionListener {

  frVenderProduto adaptee;

  frVenderProduto_btEntrarItem_actionAdapter(frVenderProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btEntrarItem_actionPerformed(e);
  }
}

class frVenderProduto_btCancelar_actionAdapter
  implements java.awt.event.ActionListener {

  frVenderProduto adaptee;

  frVenderProduto_btCancelar_actionAdapter(frVenderProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btCancelar_actionPerformed(e);
  }
}

class frVenderProduto_tfQuantidade_actionAdapter
  implements java.awt.event.ActionListener {

  frVenderProduto adaptee;

  frVenderProduto_tfQuantidade_actionAdapter(frVenderProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.tfQuantidade_actionPerformed(e);
  }
}

class frVenderProduto_tfVencto_keyAdapter extends java.awt.event.KeyAdapter {

  frVenderProduto adaptee;

  frVenderProduto_tfVencto_keyAdapter(frVenderProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void keyTyped(KeyEvent e) {
    adaptee.tfVencto_keyTyped(e);
  }
}

class frVenderProduto_tfEmissao_keyAdapter extends java.awt.event.KeyAdapter {

  frVenderProduto adaptee;

  frVenderProduto_tfEmissao_keyAdapter(frVenderProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void keyTyped(KeyEvent e) {
    adaptee.tfEmissao_keyTyped(e);
  }
}

class frVenderProduto_cbValidade_actionAdapter
  implements java.awt.event.ActionListener {

  frVenderProduto adaptee;

  frVenderProduto_cbValidade_actionAdapter(frVenderProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.cbValidade_actionPerformed(e);
  }
}

class cbCliente_ActionListener implements java.awt.event.ActionListener {

  frVenderProduto adaptee;

  cbCliente_ActionListener(frVenderProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.cbCliente_actionPerformed(e);
  }
}

class frVenderProduto_cbProduto_actionAdapter
  implements java.awt.event.ActionListener {

  frVenderProduto adaptee;

  frVenderProduto_cbProduto_actionAdapter(frVenderProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.cbProduto_actionPerformed(e);
  }
}

class ActionListener implements java.awt.event.ActionListener {

  frVenderProduto adaptee;

  ActionListener(frVenderProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btEntrarItem_actionPerformed(e);
  }
}

class frVenderProduto_tfEmissao_actionAdapter
  implements java.awt.event.ActionListener {

  frVenderProduto adaptee;

  frVenderProduto_tfEmissao_actionAdapter(frVenderProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.tfEmissao_actionPerformed(e);
  }
}

class frVenderProduto_btNovoCliente_actionAdapter
  implements java.awt.event.ActionListener {

  frVenderProduto adaptee;

  frVenderProduto_btNovoCliente_actionAdapter(frVenderProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btNovoCliente_actionPerformed(e);
  }
}
