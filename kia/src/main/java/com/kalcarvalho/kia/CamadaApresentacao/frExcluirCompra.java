package CamadaApresentacao;

import CamadaNegocios.Data;
import Controladoras.CtrExcluirCompra;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Vector;
import javax.swing.*;

public class frExcluirCompra extends JFrame {

  JPanel contentPane;
  JLabel jLabel1 = new JLabel();
  JComboBox cbNumNota;
  JLabel jLabel2 = new JLabel();
  JFormattedTextField tfEmissao = new JFormattedTextField();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JTextField tfFornecedor = new JTextField();
  JTextField tfTotal = new JTextField();
  JButton btExcluir = new JButton();
  JButton btSair = new JButton();
  private CtrExcluirCompra ctec = new CtrExcluirCompra();
  DecimalFormat decimo = new DecimalFormat("0.00");

  //Construct the frame
  public frExcluirCompra() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      Vector nNota = ctec.preencherNota();
      nNota.trimToSize();
      cbNumNota = new JComboBox(nNota);
      jbInit();
      this.formatWindow();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //Component initialization
  private void jbInit() throws Exception {
    contentPane = (JPanel) this.getContentPane();
    jLabel1.setText("Nº Nota:");
    jLabel1.setBounds(new Rectangle(15, 21, 54, 15));
    contentPane.setLayout(null);
    this.setSize(new Dimension(400, 147));
    this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    this.setTitle("Excluir Compra");
    cbNumNota.setBounds(new Rectangle(94, 19, 112, 21));
    cbNumNota.addActionListener(
      new frExcluirCompra_cbNumNota_actionAdapter(this)
    );
    jLabel2.setBounds(new Rectangle(226, 21, 54, 15));
    jLabel2.setText("Emissao:");
    tfEmissao.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
    tfEmissao.setBackground(Color.white);
    tfEmissao.setEditable(false);
    //      tfEmissao.setHorizontalAlignment(SwingConstants.RIGHT);
    tfEmissao.setText("");
    tfEmissao.setBounds(new Rectangle(280, 18, 112, 20));
    jLabel3.setText("Fornecedor:");
    jLabel3.setBounds(new Rectangle(15, 70, 74, 15));
    jLabel4.setBounds(new Rectangle(226, 70, 54, 15));
    jLabel4.setText("Valor R$:");
    tfFornecedor.setBackground(Color.white);
    tfFornecedor.setEditable(false);
    tfFornecedor.setText("");
    tfFornecedor.setBounds(new Rectangle(94, 68, 112, 20));
    tfTotal.setBounds(new Rectangle(280, 67, 112, 20));
    tfTotal.setBackground(Color.white);
    tfTotal.setEditable(false);
    tfTotal.setText("");
    btExcluir.setBounds(new Rectangle(104, 110, 73, 25));
    btExcluir.setMnemonic('E');
    btExcluir.setText("Excluir");
    btExcluir.addActionListener(
      new frExcluirCompra_btExcluir_actionAdapter(this)
    );
    btSair.setText("Sair");
    btSair.addActionListener(new frExcluirCompra_btSair_actionAdapter(this));
    btSair.setBounds(new Rectangle(219, 110, 73, 25));
    btSair.setMnemonic('S');
    contentPane.add(cbNumNota, null);
    contentPane.add(jLabel1, null);
    contentPane.add(jLabel3, null);
    contentPane.add(tfFornecedor, null);
    contentPane.add(jLabel2, null);
    contentPane.add(jLabel4, null);
    contentPane.add(tfTotal, null);
    contentPane.add(tfEmissao, null);
    contentPane.add(btExcluir, null);
    contentPane.add(btSair, null);
  }

  public void formatWindow() {
    this.setSize(new Dimension(432, 200));
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

  private void preencheCampos() {
    try {
      Data dt = new Data();
      String nota = (String) cbNumNota.getSelectedItem();
      Vector tmp = ctec.selecionarNota(Integer.parseInt(nota));
      tmp.trimToSize();
      tfFornecedor.setText("");
      tfEmissao.setText("");
      tfTotal.setText("");
      tfFornecedor.setText((String) tmp.get(0));
      tfEmissao.setText(dt.parseInterface((String) tmp.get(1)));
      tfTotal.setText(decimo.format(Double.parseDouble((String) tmp.get(2))));
      tmp.removeAllElements();
    } catch (NumberFormatException ex) {
      ex.printStackTrace();
    } catch (ArrayIndexOutOfBoundsException ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage());
    }
  }

  void btExcluir_actionPerformed(ActionEvent e) {
    String nota = "";
    try {
      nota = (String) cbNumNota.getSelectedItem();
      ctec.excluir(Integer.parseInt(nota));
    } catch (NumberFormatException ex) {
      JOptionPane.showMessageDialog(
        null,
        "Não há notas a serem canceladas",
        "Notas de Entrada",
        JOptionPane.INFORMATION_MESSAGE
      );
      return;
    }
    JOptionPane.showMessageDialog(
      null,
      "Nota Cancelada com Sucesso",
      "Cancelamento de Nota de Entrada",
      JOptionPane.INFORMATION_MESSAGE
    );
    try {
      this.setVisible(false);
      this.finalize();
      new frExcluirCompra();
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
  }

  void cbNumNota_actionPerformed(ActionEvent e) {
    this.preencheCampos();
  }

  void btSair_actionPerformed(ActionEvent e) {
    this.setVisible(false);
    try {
      this.finalize();
      super.finalize();
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
  }
}

class frExcluirCompra_btExcluir_actionAdapter
  implements java.awt.event.ActionListener {

  frExcluirCompra adaptee;

  frExcluirCompra_btExcluir_actionAdapter(frExcluirCompra adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btExcluir_actionPerformed(e);
  }
}

class frExcluirCompra_btSair_actionAdapter
  implements java.awt.event.ActionListener {

  frExcluirCompra adaptee;

  frExcluirCompra_btSair_actionAdapter(frExcluirCompra adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btSair_actionPerformed(e);
  }
}

class frExcluirCompra_cbNumNota_actionAdapter
  implements java.awt.event.ActionListener {

  frExcluirCompra adaptee;

  frExcluirCompra_cbNumNota_actionAdapter(frExcluirCompra adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.cbNumNota_actionPerformed(e);
  }
}
