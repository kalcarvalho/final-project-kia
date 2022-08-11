package CamadaApresentacao;

import Controladoras.CtrExcluirVeiculo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class frExcluirVeiculo extends JFrame {

  private CtrExcluirVeiculo cev;
  JPanel jPanel1 = new JPanel();
  Border border1;
  JLabel jLabel1 = new JLabel();
  JComboBox cbPlaca;

  public frExcluirVeiculo() throws HeadlessException {
    try {
      jbInit();
      this.formatWindow();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    cev = new CtrExcluirVeiculo();
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
    jLabel1.setText("Selecione a Placa:");
    jLabel1.setBounds(new Rectangle(25, 25, 134, 16));
    this.setResizable(false);
    this.setSize(new Dimension(379, 97));
    this.setTitle("Remover Usuário");
    cbPlaca = new JComboBox(cev.preencherPlaca());
    cbPlaca.setBounds(new Rectangle(134, 20, 125, 21));
    cbPlaca.addActionListener(new frExcluirVeiculo_cbPlaca_actionAdapter(this));
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(cbPlaca, null);
    jPanel1.add(jLabel1, null);
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

  void cbPlaca_actionPerformed(ActionEvent e) {
    String placa = (String) cbPlaca.getSelectedItem();

    Object opt[] = { "Sim", "Não" };
    int result = JOptionPane.showOptionDialog(
      this,
      "Tem certeza que deseja remover todos os dados deste Veículo?",
      "Confirmação de Remoção de Veículo",
      JOptionPane.YES_NO_OPTION,
      JOptionPane.QUESTION_MESSAGE,
      null,
      opt,
      opt[0]
    );
    if (result == JOptionPane.YES_OPTION) {
      try {
        cev.selecionarPlaca(placa);
        cev.destrutor();
        this.finalize();
        this.setVisible(false);
        new frExcluirVeiculo();
      } catch (Throwable ex) {
        ex.printStackTrace();
      }
    } else {}
  }
}

class frExcluirVeiculo_cbPlaca_actionAdapter
  implements java.awt.event.ActionListener {

  frExcluirVeiculo adaptee;

  frExcluirVeiculo_cbPlaca_actionAdapter(frExcluirVeiculo adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.cbPlaca_actionPerformed(e);
  }
}
