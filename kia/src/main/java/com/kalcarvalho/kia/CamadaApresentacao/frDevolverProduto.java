package CamadaApresentacao;

import CamadaNegocios.Data;
import Controladoras.CtrDevolverProduto;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.JOptionPane;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class frDevolverProduto extends JFrame {

  private int idVenda;
  private int idpro;
  private int qtd;
  private CtrDevolverProduto ctdp = new CtrDevolverProduto();
  JPanel contentPane;
  JComboBox cbNumNota;
  JComboBox cbProduto = new JComboBox();
  JComboBox cbValidade = new JComboBox();
  JTextField tfQuantidade = new JTextField();
  JButton btDevolver = new JButton();
  JButton btSair = new JButton();
  JLabel lbNota = new JLabel();
  JLabel lbProduto = new JLabel();
  JLabel lbValidade = new JLabel();
  JLabel lbQuantidade = new JLabel();
  JLabel lbPreco = new JLabel();
  JTextField tfPreco = new JTextField();
  Data dt = new Data();

  //Construct the frame
  public frDevolverProduto() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      cbNumNota = new JComboBox(ctdp.preencherNota());
      jbInit();
      this.formatWindow();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //Component initialization
  private void jbInit() throws Exception {
    contentPane = (JPanel) this.getContentPane();
    contentPane.setLayout(null);
    this.setSize(new Dimension(273, 259));
    this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.setTitle("Devolução de Produtos");
    cbNumNota.setBounds(new Rectangle(102, 15, 142, 22));
    cbNumNota.addActionListener(
      new frDevolverProduto_cbNumNota_actionAdapter(this)
    );
    cbProduto.setEnabled(false);
    cbProduto.setBounds(new Rectangle(102, 51, 142, 22));
    cbProduto.addActionListener(
      new frDevolverProduto_cbProduto_actionAdapter(this)
    );
    cbValidade.setBounds(new Rectangle(102, 85, 142, 22));
    cbValidade.addActionListener(
      new frDevolverProduto_cbValidade_actionAdapter(this)
    );
    cbValidade.setEnabled(false);
    tfQuantidade.setEnabled(false);
    tfQuantidade.setText("");
    tfQuantidade.setHorizontalAlignment(SwingConstants.RIGHT);
    tfQuantidade.setBounds(new Rectangle(102, 118, 142, 22));
    btDevolver.setBounds(new Rectangle(37, 193, 86, 25));
    btDevolver.setEnabled(false);
    btDevolver.setMnemonic('D');
    btDevolver.setText("Devolver");
    btDevolver.addActionListener(
      new frDevolverProduto_btDevolver_actionAdapter(this)
    );
    btSair.setText("Sair");
    btSair.addActionListener(new frDevolverProduto_btSair_actionAdapter(this));
    btSair.setBounds(new Rectangle(139, 192, 86, 25));
    btSair.setMnemonic('S');
    lbNota.setText("Nº Nota:");
    lbNota.setBounds(new Rectangle(21, 14, 72, 24));
    lbProduto.setBounds(new Rectangle(21, 51, 72, 24));
    lbProduto.setText("Produto:");
    lbValidade.setBounds(new Rectangle(21, 83, 72, 24));
    lbValidade.setText("Validade:");
    lbQuantidade.setBounds(new Rectangle(21, 116, 72, 24));
    lbQuantidade.setText("Quantidade:");
    lbPreco.setText("Preço R$");
    lbPreco.setBounds(new Rectangle(21, 151, 72, 24));
    tfPreco.setBounds(new Rectangle(102, 153, 142, 22));
    tfPreco.setText("");
    tfPreco.setHorizontalAlignment(SwingConstants.RIGHT);
    tfPreco.setEnabled(true);
    tfPreco.setDisabledTextColor(Color.gray);
    tfPreco.setEditable(false);
    contentPane.add(btDevolver, null);
    contentPane.add(btSair, null);
    contentPane.add(tfPreco, null);
    contentPane.add(lbPreco, null);
    contentPane.add(tfQuantidade, null);
    contentPane.add(lbQuantidade, null);
    contentPane.add(cbValidade, null);
    contentPane.add(lbValidade, null);
    contentPane.add(cbProduto, null);
    contentPane.add(lbProduto, null);
    contentPane.add(cbNumNota, null);
    contentPane.add(lbNota, null);
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

  private void preencherProduto() {
    idVenda = Integer.parseInt((String) cbNumNota.getSelectedItem());
    Vector tmp = ctdp.selecionarNota(idVenda);
    tmp.trimToSize();
    String id2[] = new String[tmp.size()]; //cria string do tamanho de vector
    tmp.copyInto(id2); //copia vector para string
    cbProduto.removeAllItems();
    for (int i = 0; i < id2.length; i++) cbProduto.addItem(id2[i]);
    cbProduto.setEnabled(true);
  }

  private void preencherValidade() {
    Data dt = new Data();
    String id = (String) cbProduto.getSelectedItem();
    for (int i = 0; i < id.length(); i++) {
      if (id.charAt(i) == ' ') {
        id = id.substring(0, i);
        idpro = Integer.parseInt(id);
        break;
      }
    }
    JOptionPane.showMessageDialog(null, "idpro= " + idpro);
    Vector tmp = ctdp.selecionarProduto(idpro, idVenda);
    tmp.trimToSize(); //reduz a capacidade do Vector para o numero elementos
    String id2[] = new String[tmp.size()]; //cria string do tamanho de vector
    tmp.copyInto(id2); //copia vector para string, opcao2 usar Enumeration
    cbValidade.removeAllItems();
    for (int i = 0; i < id2.length; i++) {
      id2[i] = dt.parseInterface(id2[i]);
      cbValidade.addItem(id2[i]);
    }
    cbValidade.setEnabled(true);
  }

  private void carregarQuantidade() {
    Data dt = new Data();
    dt.parseMySQL((String) cbValidade.getSelectedItem());
    Vector tmp = ctdp.selecionarValidade(dt.getDataMysql(), idVenda, idpro);
    tmp.trimToSize();
    tfQuantidade.setText((String) tmp.get(0));
    tfPreco.setText((String) tmp.get(1));
    tfQuantidade.setEnabled(true);
    btDevolver.setEnabled(true);
    qtd = Integer.parseInt(tfQuantidade.getText());
  }

  private boolean verificarQuantidade() {
    if (qtd < Integer.parseInt(tfQuantidade.getText())) {
      tfQuantidade.setText(Integer.toString(qtd));
      return false;
    } else if (Integer.parseInt(tfQuantidade.getText()) <= 0) {
      tfQuantidade.setText(Integer.toString(qtd));
      return false;
    }
    return true;
  }

  private void destruir() {
    try {
      this.show(false);
      this.finalize();
      super.finalize();
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
  }

  void cbNumNota_actionPerformed(ActionEvent e) {
    this.preencherProduto();
  }

  void cbProduto_actionPerformed(ActionEvent e) {
    this.preencherValidade();
  }

  void cbValidade_actionPerformed(ActionEvent e) {
    this.carregarQuantidade();
  }

  void btSair_actionPerformed(ActionEvent e) {
    this.destruir();
  }

  void btDevolver_actionPerformed(ActionEvent e) {
    if (!this.verificarQuantidade()) return;
    String val = (String) cbValidade.getSelectedItem();
    dt.parseMySQL(val);
    ctdp.devolver(
      idpro,
      Integer.parseInt(tfQuantidade.getText()),
      dt.getDataMysql(),
      Double.parseDouble(tfPreco.getText())
    );
    this.destruir();
    this.setVisible(false);
    new frDevolverProduto();
  }
}

class frDevolverProduto_cbNumNota_actionAdapter
  implements java.awt.event.ActionListener {

  frDevolverProduto adaptee;

  frDevolverProduto_cbNumNota_actionAdapter(frDevolverProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.cbNumNota_actionPerformed(e);
  }
}

class frDevolverProduto_cbProduto_actionAdapter
  implements java.awt.event.ActionListener {

  frDevolverProduto adaptee;

  frDevolverProduto_cbProduto_actionAdapter(frDevolverProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.cbProduto_actionPerformed(e);
  }
}

class frDevolverProduto_cbValidade_actionAdapter
  implements java.awt.event.ActionListener {

  frDevolverProduto adaptee;

  frDevolverProduto_cbValidade_actionAdapter(frDevolverProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.cbValidade_actionPerformed(e);
  }
}

class frDevolverProduto_btSair_actionAdapter
  implements java.awt.event.ActionListener {

  frDevolverProduto adaptee;

  frDevolverProduto_btSair_actionAdapter(frDevolverProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btSair_actionPerformed(e);
  }
}

class frDevolverProduto_btDevolver_actionAdapter
  implements java.awt.event.ActionListener {

  frDevolverProduto adaptee;

  frDevolverProduto_btDevolver_actionAdapter(frDevolverProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btDevolver_actionPerformed(e);
  }
}
