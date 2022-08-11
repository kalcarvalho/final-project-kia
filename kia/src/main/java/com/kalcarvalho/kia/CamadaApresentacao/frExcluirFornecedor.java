package CamadaApresentacao;

import Controladoras.CtrExcluirFornecedor;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class frExcluirFornecedor extends JFrame {

  private CtrExcluirFornecedor cef;
  JPanel jPanel1 = new JPanel();
  Border border1;
  JComboBox jComboBox1;
  JLabel jLabel1 = new JLabel();

  public frExcluirFornecedor() throws HeadlessException {
    try {
      jbInit();
      this.formatWindow();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    cef = new CtrExcluirFornecedor();
    border1 =
      new EtchedBorder(
        EtchedBorder.RAISED,
        Color.white,
        new Color(151, 145, 140)
      );
    this.getContentPane().setLayout(null);
    jPanel1.setBorder(border1);
    jPanel1.setBounds(new Rectangle(1, 2, 370, 62));
    jPanel1.setLayout(null);
    System.out.print(cef.preencherForn());
    jComboBox1 = new JComboBox(cef.preencherForn());
    jComboBox1.setBounds(new Rectangle(147, 18, 216, 22));
    jComboBox1.addActionListener(
      new frExcluirFornecedor_jComboBox1_actionAdapter(this)
    );
    jLabel1.setText("Selecionar Fornecedor:");
    jLabel1.setBounds(new Rectangle(9, 20, 134, 16));
    this.setResizable(false);
    this.setSize(new Dimension(379, 97));
    this.setTitle("Remover Fornecedor");
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(jLabel1, null);
    jPanel1.add(jComboBox1, null);
  }

  public void formatWindow() {
    this.validate();
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

  void jComboBox1_actionPerformed(ActionEvent e) {
    String razaoSocial = (String) jComboBox1.getSelectedItem();

    Object opt[] = { "Sim", "Não" };
    int result = JOptionPane.showOptionDialog(
      this,
      "Tem certeza que deseja remover todos os dados deste Fornecedor?",
      "Confirmação de Remoção de Fornecedor",
      JOptionPane.YES_NO_OPTION,
      JOptionPane.QUESTION_MESSAGE,
      null,
      opt,
      opt[0]
    );
    if (result == JOptionPane.YES_OPTION) {
      try {
        cef.selecionarFornecedor(razaoSocial);
        cef.destrutor();
        this.finalize();
        this.setVisible(false);
        new frExcluirFornecedor();
      } catch (Throwable ex) {
        ex.printStackTrace();
      }
    } else {}
  }
}

class frExcluirFornecedor_jComboBox1_actionAdapter
  implements java.awt.event.ActionListener {

  frExcluirFornecedor adaptee;

  frExcluirFornecedor_jComboBox1_actionAdapter(frExcluirFornecedor adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.jComboBox1_actionPerformed(e);
  }
}
