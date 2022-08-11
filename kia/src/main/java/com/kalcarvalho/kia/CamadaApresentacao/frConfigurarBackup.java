package CamadaApresentacao;

import Controladoras.CtrBackup;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class frConfigurarBackup extends JFrame {

  private CtrBackup cb;
  GridLayout gridLayout1 = new GridLayout();
  JPanel jPanel1 = new JPanel();
  JLabel lbDir = new JLabel();
  JTextField tfOrigem = new JTextField();
  JButton btAplicar = new JButton();
  JButton btSair = new JButton();
  JLabel lbDestino = new JLabel();
  JTextField tfDestino = new JTextField();

  public frConfigurarBackup(String stback) {
    try {
      jbInit(stback);
      this.formatWindow();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit(String status) throws Exception {
    cb = new CtrBackup();
    this.getContentPane().setLayout(gridLayout1);
    this.setResizable(false);
    this.setSize(new Dimension(307, 234));
    this.setTitle("Configurar Backup");
    jPanel1.setLayout(null);
    lbDir.setRequestFocusEnabled(true);
    lbDir.setToolTipText(
      "Mantenha sempre duas barras para especificar o diretório"
    );
    lbDir.setVerifyInputWhenFocusTarget(true);
    lbDir.setText("Origem:");
    lbDir.setBounds(new Rectangle(34, 26, 39, 15));
    tfOrigem.setToolTipText("");
    tfOrigem.setText("");

    if (status.equals("true")) tfOrigem.setText(
      cb.getOrigem()
    ); else tfOrigem.setText("C:\\mysql\\data\\Distribuidora");

    tfOrigem.setBounds(new Rectangle(34, 54, 236, 20));
    jPanel1.setOpaque(true);
    jPanel1.setToolTipText("");
    btAplicar.setBounds(new Rectangle(65, 154, 71, 23));
    btAplicar.setText("Aplicar");
    btAplicar.addActionListener(
      new frConfigurarBackup_btAplicar_actionAdapter(this)
    );
    btSair.setBounds(new Rectangle(152, 154, 71, 23));
    btSair.setText("Sair");
    btSair.addActionListener(new frConfigurarBackup_btSair_actionAdapter(this));
    lbDestino.setText("Destino:");
    lbDestino.setBounds(new Rectangle(35, 88, 45, 15));

    if (status.equals("false")) tfDestino.setText(
      "C:\\"
    ); else tfDestino.setText(cb.getDestino());

    tfDestino.setBounds(new Rectangle(34, 114, 236, 20));
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(tfDestino, null);
    jPanel1.add(lbDir, null);
    jPanel1.add(tfOrigem, null);
    jPanel1.add(lbDestino, null);
    jPanel1.add(btAplicar, null);
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

  void btAplicar_actionPerformed(ActionEvent e) {
    cb.configurar(tfOrigem.getText(), tfDestino.getText());
  }

  void btSair_actionPerformed(ActionEvent e) {
    try {
      this.finalize();
      this.setVisible(false);
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
  }
}

class frConfigurarBackup_btAplicar_actionAdapter
  implements java.awt.event.ActionListener {

  frConfigurarBackup adaptee;

  frConfigurarBackup_btAplicar_actionAdapter(frConfigurarBackup adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btAplicar_actionPerformed(e);
  }
}

class frConfigurarBackup_btSair_actionAdapter
  implements java.awt.event.ActionListener {

  frConfigurarBackup adaptee;

  frConfigurarBackup_btSair_actionAdapter(frConfigurarBackup adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btSair_actionPerformed(e);
  }
}
