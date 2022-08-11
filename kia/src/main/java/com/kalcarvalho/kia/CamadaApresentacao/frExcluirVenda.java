package CamadaApresentacao;

import CamadaNegocios.Data;
import Controladoras.CtrExcluirVenda;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Vector;
import javax.swing.*;

public class frExcluirVenda extends JFrame {

  JPanel contentPane;
  JLabel jLabel1 = new JLabel();
  JComboBox cbNumNota;
  JLabel jLabel2 = new JLabel();
  JFormattedTextField tfEmissao = new JFormattedTextField();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JTextField tfCliente = new JTextField();
  JTextField tfTotal = new JTextField();
  JButton btExcluir = new JButton();
  JButton btSair = new JButton();
  private CtrExcluirVenda ctev = new CtrExcluirVenda();
  DecimalFormat decimo = new DecimalFormat("0.00");

  //Construct the frame
  public frExcluirVenda() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      Vector nNota = ctev.preencherNota();
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
    this.setSize(new Dimension(432, 200));
    contentPane = (JPanel) this.getContentPane();
    jLabel1.setText("Nº Nota:");
    jLabel1.setBounds(new Rectangle(23, 26, 54, 15));
    contentPane.setLayout(null);
    this.setSize(new Dimension(432, 167));
    this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    this.setTitle("Excluir Venda");
    cbNumNota.setBounds(new Rectangle(80, 23, 112, 21));
    cbNumNota.addActionListener(
      new frExcluirVenda_cbNumNota_actionAdapter(this)
    );
    jLabel2.setBounds(new Rectangle(234, 26, 54, 15));
    jLabel2.setText("Emissao:");
    tfEmissao.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
    tfEmissao.setBackground(Color.white);
    tfEmissao.setEditable(false);
    //    tfEmissao.setHorizontalAlignment(SwingConstants.RIGHT);
    tfEmissao.setText("");
    tfEmissao.setBounds(new Rectangle(288, 23, 112, 20));
    jLabel3.setText("Cliente:");
    jLabel3.setBounds(new Rectangle(23, 75, 54, 15));
    jLabel4.setBounds(new Rectangle(234, 75, 54, 15));
    jLabel4.setText("Valor R$:");
    tfCliente.setBackground(Color.white);
    tfCliente.setEditable(false);
    tfCliente.setText("");
    tfCliente.setBounds(new Rectangle(80, 72, 112, 20));
    tfTotal.setBounds(new Rectangle(288, 72, 112, 20));
    tfTotal.setBackground(Color.white);
    tfTotal.setEditable(false);
    tfTotal.setText("");
    btExcluir.setBounds(new Rectangle(119, 128, 73, 25));
    btExcluir.setMnemonic('E');
    btExcluir.setText("Excluir");
    btExcluir.addActionListener(
      new frExcluirVenda_btExcluir_actionAdapter(this)
    );
    btSair.setText("Sair");
    btSair.addActionListener(new frExcluirVenda_btSair_actionAdapter(this));
    btSair.setBounds(new Rectangle(234, 128, 73, 25));
    btSair.setMnemonic('S');
    contentPane.add(jLabel1, null);
    contentPane.add(jLabel2, null);
    contentPane.add(cbNumNota, null);
    contentPane.add(tfEmissao, null);
    contentPane.add(jLabel3, null);
    contentPane.add(jLabel4, null);
    contentPane.add(tfCliente, null);
    contentPane.add(tfTotal, null);
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

  private void destruir() {
    try {
      this.setVisible(false);
      this.finalize();
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
  }

  private void preencheCampos() {
    try {
      Data dt = new Data();
      String nota = (String) cbNumNota.getSelectedItem();
      Vector tmp = ctev.selecionarNota(Integer.parseInt(nota));
      tmp.trimToSize();
      tfCliente.setText("");
      tfEmissao.setText("");
      tfTotal.setText("");
      tfCliente.setText((String) tmp.get(0));
      tfEmissao.setText(dt.parseInterface((String) tmp.get(1)));
      tfTotal.setText(decimo.format(Double.parseDouble((String) tmp.get(2))));
      tmp.removeAllElements();
    } catch (NumberFormatException ex) {
      ex.printStackTrace();
      return;
    } catch (ArrayIndexOutOfBoundsException ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage());
    }
  }

  void btExcluir_actionPerformed(ActionEvent e) {
    String nota = "";
    try {
      nota = (String) cbNumNota.getSelectedItem();
      ctev.excluir(Integer.parseInt(nota));
    } catch (NumberFormatException ex) {
      JOptionPane.showMessageDialog(
        null,
        "Não há notas a serem canceladas",
        "Notas de Saída",
        JOptionPane.INFORMATION_MESSAGE
      );
      return;
    }
    JOptionPane.showMessageDialog(
      null,
      "Nota Cancelada com Sucesso",
      "Cancelamento de Nota de Saída",
      JOptionPane.INFORMATION_MESSAGE
    );
    try {
      this.setVisible(false);
      this.finalize();
      new frExcluirVenda();
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
  }

  void cbNumNota_actionPerformed(ActionEvent e) {
    this.preencheCampos();
  }

  void btSair_actionPerformed(ActionEvent e) {
    this.destruir();
  }
}

class frExcluirVenda_btExcluir_actionAdapter
  implements java.awt.event.ActionListener {

  frExcluirVenda adaptee;

  frExcluirVenda_btExcluir_actionAdapter(frExcluirVenda adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btExcluir_actionPerformed(e);
  }
}

class frExcluirVenda_btSair_actionAdapter
  implements java.awt.event.ActionListener {

  frExcluirVenda adaptee;

  frExcluirVenda_btSair_actionAdapter(frExcluirVenda adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btSair_actionPerformed(e);
  }
}

class frExcluirVenda_cbNumNota_actionAdapter
  implements java.awt.event.ActionListener {

  frExcluirVenda adaptee;

  frExcluirVenda_cbNumNota_actionAdapter(frExcluirVenda adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.cbNumNota_actionPerformed(e);
  }
}
