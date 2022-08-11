package CamadaApresentacao;

import Controladoras.CtrExcluirCliente;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class frExcluirCliente extends JFrame {

  private CtrExcluirCliente cec;
  JPanel jPanel1 = new JPanel();
  Border border1;
  JComboBox jComboBox1 = new JComboBox();
  JLabel jLabel1 = new JLabel();

  public frExcluirCliente() throws HeadlessException {
    try {
      jbInit();
      this.formatWindow();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    cec = new CtrExcluirCliente();
    border1 =
      new EtchedBorder(
        EtchedBorder.RAISED,
        Color.white,
        new Color(151, 145, 140)
      );
    this.getContentPane().setLayout(null);
    jPanel1.setBorder(border1);
    jPanel1.setBounds(new Rectangle(1, 1, 370, 62));
    jPanel1.setLayout(null);
    jComboBox1 = new JComboBox(cec.preencherCliente());
    jComboBox1.setBounds(new Rectangle(137, 18, 216, 22));
    jComboBox1.addActionListener(
      new frExcluirCliente_jComboBox1_actionAdapter(this)
    );
    jLabel1.setText("Selecionar Cliente:");
    jLabel1.setBounds(new Rectangle(20, 21, 111, 16));
    this.setResizable(false);
    this.setSize(new Dimension(379, 97));
    this.setTitle("Remover Cliente");
    jPanel1.add(jComboBox1, null);
    jPanel1.add(jLabel1, null);
    this.getContentPane().add(jPanel1, null);
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

  void jComboBox1_actionPerformed(ActionEvent e) {
    String razaoSocial = (String) jComboBox1.getSelectedItem();

    Object opt[] = { "Sim", "Não" };
    int result = JOptionPane.showOptionDialog(
      this,
      "Tem certeza que deseja remover todos os dados deste Cliente?",
      "Confirmação de Remoção de Clientes",
      JOptionPane.YES_NO_OPTION,
      JOptionPane.QUESTION_MESSAGE,
      null,
      opt,
      opt[0]
    );
    if (result == JOptionPane.YES_OPTION) {
      try {
        cec.selecionarCliente(razaoSocial);
        cec.destrutor();
        this.finalize();
        this.setVisible(false);
        new frExcluirCliente();
      } catch (Throwable ex) {
        ex.printStackTrace();
      }
    } else {}
  }
}

class frExcluirCliente_jComboBox1_actionAdapter
  implements java.awt.event.ActionListener {

  frExcluirCliente adaptee;

  frExcluirCliente_jComboBox1_actionAdapter(frExcluirCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.jComboBox1_actionPerformed(e);
  }
}
