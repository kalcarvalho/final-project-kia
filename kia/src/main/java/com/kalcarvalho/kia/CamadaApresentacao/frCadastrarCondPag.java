package CamadaApresentacao;

import Controladoras.CtrCadastrarCondPag;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class frCadastrarCondPag extends JFrame {

  private ValidarCampo vc;
  private CtrCadastrarCondPag cccp;
  JPanel jPanel1 = new JPanel();
  JLabel lbCondicao = new JLabel();
  JTextField tfCondicao = new JTextField();
  JButton btSair = new JButton();
  JButton btCadastrar = new JButton();

  public frCadastrarCondPag() {
    try {
      jbInit();
      this.formatWindow();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    vc = new ValidarCampo();
    cccp = new CtrCadastrarCondPag();
    jPanel1.setLayout(null);
    this.setVisible(true);
    this.setResizable(false);
    this.setSize(new Dimension(317, 152));
    this.setTitle("Cadastrar Condição de Pagamento");
    lbCondicao.setText("Nova Condição:");
    lbCondicao.setBounds(new Rectangle(40, 33, 86, 15));
    tfCondicao.setText("");
    tfCondicao.setBounds(new Rectangle(138, 30, 131, 20));
    btSair.setBounds(new Rectangle(169, 72, 71, 23));
    btSair.setText("Sair");
    btSair.addActionListener(new frCadastrarCondPag_btSair_actionAdapter(this));
    btCadastrar.setBounds(new Rectangle(72, 72, 80, 23));
    btCadastrar.setText("Cadastrar");
    btCadastrar.addActionListener(
      new frCadastrarCondPag_btCadastrar_actionAdapter(this)
    );
    this.getContentPane().add(jPanel1, BorderLayout.CENTER);
    jPanel1.add(lbCondicao, null);
    jPanel1.add(tfCondicao, null);
    jPanel1.add(btSair, null);
    jPanel1.add(btCadastrar, null);
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
      cccp.destrutor();
      this.finalize();
      this.setVisible(false);
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
  }

  void btCadastrar_actionPerformed(ActionEvent e) {
    if (!vc.valNulo(tfCondicao.getText())) return;
    cccp.cadastrar(tfCondicao.getText());
    JOptionPane.showMessageDialog(
      null,
      "Cadastro Efetuado com Sucesso!",
      "Cadastro de Forma de Pagamento",
      JOptionPane.INFORMATION_MESSAGE
    );
    tfCondicao.setText("");
  }
}

class frCadastrarCondPag_btSair_actionAdapter
  implements java.awt.event.ActionListener {

  frCadastrarCondPag adaptee;

  frCadastrarCondPag_btSair_actionAdapter(frCadastrarCondPag adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btSair_actionPerformed(e);
  }
}

class frCadastrarCondPag_btCadastrar_actionAdapter
  implements java.awt.event.ActionListener {

  frCadastrarCondPag adaptee;

  frCadastrarCondPag_btCadastrar_actionAdapter(frCadastrarCondPag adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btCadastrar_actionPerformed(e);
  }
}
