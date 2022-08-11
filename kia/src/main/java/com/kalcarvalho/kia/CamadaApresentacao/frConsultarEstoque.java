package CamadaApresentacao;

import Controladoras.CtrConsultarEstoque;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.*;

public class frConsultarEstoque extends JFrame {

  private CtrConsultarEstoque cce;
  String razaoSocial;
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JLabel lbFornecedor = new JLabel();
  JComboBox cbFornecedor;
  JLabel lbProduto = new JLabel();
  JComboBox cbProduto = new JComboBox();
  JPanel jPanel3 = new JPanel();
  GridLayout gridLayout1 = new GridLayout();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTable grid = new JTable();
  JPanel jPanel4 = new JPanel();
  JButton btSair = new JButton();

  public frConsultarEstoque() {
    cce = new CtrConsultarEstoque();
    try {
      jbInit();
      this.formatWindow();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    cbFornecedor = new JComboBox(cce.preencherForn());
    this.setResizable(false);
    this.setSize(new Dimension(405, 315));
    this.getContentPane().setLayout(null);
    jPanel1.setBorder(BorderFactory.createEtchedBorder());
    jPanel1.setBounds(new Rectangle(1, 1, 397, 96));
    jPanel1.setLayout(null);
    jPanel2.setBorder(BorderFactory.createEtchedBorder());
    jPanel2.setBounds(new Rectangle(1, 96, 397, 140));
    jPanel2.setLayout(null);
    lbFornecedor.setText("Selecione Fornecedor:");
    lbFornecedor.setBounds(new Rectangle(62, 29, 119, 15));
    cbFornecedor.setBounds(new Rectangle(176, 25, 149, 19));
    cbFornecedor.addActionListener(
      new frConsultarEstoque_cbFornecedor_actionAdapter(this)
    );
    lbProduto.setText("Selecione Produto:");
    lbProduto.setBounds(new Rectangle(62, 61, 92, 15));
    cbProduto.setBounds(new Rectangle(176, 57, 149, 19));
    cbProduto.addActionListener(
      new frConsultarEstoque_cbProduto_actionAdapter(this)
    );
    jPanel3.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel3.setBounds(new Rectangle(60, 15, 265, 111));
    jPanel3.setLayout(gridLayout1);
    this.setTitle("Consultar Estoque / Validade");
    grid.setBackground(SystemColor.text);
    grid.setBorder(BorderFactory.createLineBorder(Color.black));
    jScrollPane1.getViewport().setBackground(SystemColor.text);
    jPanel4.setBorder(BorderFactory.createEtchedBorder());
    jPanel4.setBounds(new Rectangle(1, 235, 397, 47));
    jPanel4.setLayout(null);
    btSair.setBounds(new Rectangle(306, 12, 71, 23));
    btSair.setText("Sair");
    btSair.addActionListener(new frConsultarEstoque_btSair_actionAdapter(this));
    jPanel1.add(lbFornecedor, null);
    jPanel1.add(cbFornecedor, null);
    jPanel1.add(lbProduto, null);
    jPanel1.add(cbProduto, null);
    this.getContentPane().add(jPanel2, null);
    this.getContentPane().add(jPanel4, null);
    jPanel4.add(btSair, null);
    this.getContentPane().add(jPanel1, null);
    jPanel2.add(jPanel3, null);
    jPanel3.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(grid, null);
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

  void cbFornecedor_actionPerformed(ActionEvent e) {
    Vector produtos = new Vector();
    razaoSocial = (String) cbFornecedor.getSelectedItem();
    produtos = cce.SelecionarFornecedor(razaoSocial);
    produtos.trimToSize();
    cbProduto.removeAllItems();
    for (int i = 0; i < produtos.size(); i++) cbProduto.addItem(
      produtos.get(i)
    );
  }

  void cbProduto_actionPerformed(ActionEvent e) {
    Vector a = new Vector();
    Vector b = new Vector();
    Vector tmp = new Vector();
    String descricao = (String) cbProduto.getSelectedItem();
    tmp = cce.SelecionarProduto(descricao);
    System.out.println(tmp);

    try {
      a = (Vector) tmp.get(0);
    } catch (ArrayIndexOutOfBoundsException ex) {
      JOptionPane.showMessageDialog(
        null,
        "Não Há Registro desse Produto em Estoque",
        "Consulta Estoque / Validade",
        JOptionPane.INFORMATION_MESSAGE
      );
      return;
    }
    try {
      b = (Vector) tmp.get(1);
    } catch (ArrayIndexOutOfBoundsException ex) {
      JOptionPane.showMessageDialog(
        null,
        "Não Há Registro desse Produto em Estoque",
        "Consulta Estoque / Validade",
        JOptionPane.INFORMATION_MESSAGE
      );
      return;
    }
    grid.setModel(new DefaultTableModel(a, b));
  }

  void btSair_actionPerformed(ActionEvent e) {
    try {
      this.finalize();
      super.finalize();
      this.setVisible(false);
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
  }
}

class frConsultarEstoque_cbFornecedor_actionAdapter
  implements java.awt.event.ActionListener {

  frConsultarEstoque adaptee;

  frConsultarEstoque_cbFornecedor_actionAdapter(frConsultarEstoque adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.cbFornecedor_actionPerformed(e);
  }
}

class frConsultarEstoque_cbProduto_actionAdapter
  implements java.awt.event.ActionListener {

  frConsultarEstoque adaptee;

  frConsultarEstoque_cbProduto_actionAdapter(frConsultarEstoque adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.cbProduto_actionPerformed(e);
  }
}

class frConsultarEstoque_btSair_actionAdapter
  implements java.awt.event.ActionListener {

  frConsultarEstoque adaptee;

  frConsultarEstoque_btSair_actionAdapter(frConsultarEstoque adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btSair_actionPerformed(e);
  }
}
