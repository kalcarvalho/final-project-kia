package CamadaApresentacao;

import Controladoras.CtrExcluirUsuario;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class frExcluirUsuario extends JFrame {

  private CtrExcluirUsuario ceu;
  JPanel jPanel1 = new JPanel();
  Border border1;
  JComboBox cbMat;
  JLabel jLabel1 = new JLabel();

  public frExcluirUsuario() throws HeadlessException {
    try {
      jbInit();
      this.formatWindow();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    ceu = new CtrExcluirUsuario();
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
    System.out.print(ceu.preencherMat());
    cbMat = new JComboBox(ceu.preencherMat());
    cbMat.setBounds(new Rectangle(147, 20, 137, 22));
    cbMat.addActionListener(new frExcluirFornecedor_cbMat_actionAdapter(this));
    jLabel1.setText("Selecione a Matrícula:");
    jLabel1.setBounds(new Rectangle(25, 26, 134, 16));
    this.setResizable(false);
    this.setSize(new Dimension(379, 97));
    this.setTitle("Remover Usuário");
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(cbMat, null);
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

  void cbMat_actionPerformed(ActionEvent e) {
    String mat = (String) cbMat.getSelectedItem();

    Object opt[] = { "Sim", "Não" };
    int result = JOptionPane.showOptionDialog(
      this,
      "Tem certeza que deseja remover todos os dados deste Usuario?",
      "Confirmação de Remoção de Usuário",
      JOptionPane.YES_NO_OPTION,
      JOptionPane.QUESTION_MESSAGE,
      null,
      opt,
      opt[0]
    );
    if (result == JOptionPane.YES_OPTION) {
      try {
        ceu.selecionarMat(mat);
        ceu.destrutor();
        this.finalize();
        this.setVisible(false);
        new frExcluirUsuario();
      } catch (Throwable ex) {
        ex.printStackTrace();
      }
    } else {}
  }
}

class frExcluirFornecedor_cbMat_actionAdapter
  implements java.awt.event.ActionListener {

  frExcluirUsuario adaptee;

  frExcluirFornecedor_cbMat_actionAdapter(frExcluirUsuario adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.cbMat_actionPerformed(e);
  }
}
