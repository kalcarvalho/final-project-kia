package CamadaApresentacao;

import Controladoras.CtrRemoverCondPag;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class frRemoverCondPag extends JFrame {

  private CtrRemoverCondPag crcp;
  JPanel jPanel1 = new JPanel();
  JLabel lbCondPag = new JLabel();
  JComboBox jComboBox1;
  JButton btRemover = new JButton();
  JButton btSair = new JButton();

  public frRemoverCondPag() {
    try {
      jbInit();
      this.formatWindow();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    crcp = new CtrRemoverCondPag();
    jPanel1.setLayout(null);
    this.setVisible(true);
    this.setResizable(false);
    this.setSize(new Dimension(317, 152));
    this.setTitle("Remover Condição de Pagamento");
    lbCondPag.setText("Selecione: ");
    lbCondPag.setBounds(new Rectangle(66, 35, 58, 15));
    jComboBox1 = new JComboBox(crcp.selecioneCb());
    jComboBox1.setBounds(new Rectangle(137, 34, 113, 19));
    btRemover.setBounds(new Rectangle(73, 79, 77, 23));
    btRemover.setText("Remover");
    btRemover.addActionListener(
      new frRemoverCondPag_btRemover_actionAdapter(this)
    );
    btSair.setBounds(new Rectangle(159, 79, 71, 23));
    btSair.setText("Sair");
    btSair.addActionListener(new frRemoverCondPag_btSair_actionAdapter(this));

    this.getContentPane().add(jPanel1, BorderLayout.CENTER);
    jPanel1.add(jComboBox1, null);
    jPanel1.add(lbCondPag, null);
    jPanel1.add(btRemover, null);
    jPanel1.add(btSair, null);
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
    try {
      crcp.destrutor();
      this.finalize();
      this.setVisible(false);
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
  }

  void btRemover_actionPerformed(ActionEvent e) {
    String cond = (String) jComboBox1.getSelectedItem();
    crcp.RemoverCondPag(cond);
    JOptionPane.showMessageDialog(
      null,
      "Remoção Efetuada com Sucesso",
      "Remoção de Forma de Pagamento",
      JOptionPane.INFORMATION_MESSAGE
    );
    try {
      this.finalize();
    } catch (Throwable ex) {}
    this.setVisible(false);
    new frRemoverCondPag();
  }
}

class frRemoverCondPag_btSair_actionAdapter
  implements java.awt.event.ActionListener {

  frRemoverCondPag adaptee;

  frRemoverCondPag_btSair_actionAdapter(frRemoverCondPag adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btSair_actionPerformed(e);
  }
}

class frRemoverCondPag_btRemover_actionAdapter
  implements java.awt.event.ActionListener {

  frRemoverCondPag adaptee;

  frRemoverCondPag_btRemover_actionAdapter(frRemoverCondPag adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btRemover_actionPerformed(e);
  }
}
