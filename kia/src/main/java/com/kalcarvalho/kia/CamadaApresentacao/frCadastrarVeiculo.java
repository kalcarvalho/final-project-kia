package CamadaApresentacao;

import Controladoras.CtrCadastrarVeiculo;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class frCadastrarVeiculo extends JFrame {

  private CtrCadastrarVeiculo ccv;
  private ValidarCampo vc;
  private boolean ativa;
  JPanel contentPane;
  ImageIcon image1;
  ImageIcon image2;
  ImageIcon image3;
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JLabel lbTara = new JLabel();
  JTextField tfTara = new JTextField();
  JLabel lbPlaca = new JLabel();
  JTextField tfPlaca = new JTextField();
  JLabel lbConsumoMedio = new JLabel();
  JTextField tfConsumoMedio = new JTextField();
  JLabel lbCapacidade = new JLabel();
  JTextField tfCapacidade = new JTextField();
  JLabel lbRefrigeracao = new JLabel();
  JLabel lbCor = new JLabel();
  JTextField tfCor = new JTextField();
  JLabel lbAno = new JLabel();
  JTextField tfAno = new JTextField();
  JButton btCadastrar = new JButton();
  JButton jbLimpar = new JButton();
  JButton btDSair = new JButton();
  JLabel lbTipo = new JLabel();
  JComboBox cbRefrigeracao = new JComboBox(preencherRefr());
  JTextField tfTipo = new JTextField();

  //Construct the frame
  public frCadastrarVeiculo() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      ativa = false;
      jbInit();
      this.formatWindow();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //Component initialization
  private void jbInit() throws Exception {
    vc = new ValidarCampo();
    tfPlaca.addKeyListener(new frCadastrarVeiculo_tfPlaca_keyAdapter(this));
    tfAno.addKeyListener(new frCadastrarVeiculo_tfAno_keyAdapter(this));
    tfCor.addKeyListener(new frCadastrarVeiculo_tfCor_keyAdapter(this));
    tfTara.addKeyListener(new frCadastrarVeiculo_tfTara_keyAdapter(this));
    tfCapacidade.addKeyListener(
      new frCadastrarVeiculo_tfCapacidade_keyAdapter(this)
    );
    tfConsumoMedio.addKeyListener(
      new frCadastrarVeiculo_tfConsumoMedio_keyAdapter(this)
    );
    tfTipo.setText("");
    tfTipo.setBounds(new Rectangle(239, 48, 92, 21));
    tfTipo.addKeyListener(new frCadastrarVeiculo_tfTipo_keyAdapter(this));
    jPanel1.add(lbPlaca, null);
    jPanel1.add(lbCor, null);
    jPanel1.add(tfPlaca, null);
    jPanel1.add(tfCor, null);
    jPanel1.add(lbTara, null);
    jPanel1.add(tfTara, null);
    jPanel1.add(cbRefrigeracao, null);
    jPanel1.add(lbRefrigeracao, null);
    jPanel1.add(tfCapacidade, null);
    jPanel1.add(lbConsumoMedio, null);
    jPanel1.add(tfConsumoMedio, null);
    jPanel1.add(lbCapacidade, null);
    jPanel1.add(lbTipo, null);
    jPanel1.add(lbAno, null);
    jPanel1.add(tfAno, null);
    jPanel1.add(jbLimpar, null);
    jPanel1.add(btDSair, null);
    jPanel1.add(btCadastrar, null);
    jPanel1.add(tfTipo, null);
    btDSair.addActionListener(
      new frCadastrarVeiculo_btDSair_actionAdapter(this)
    );
    btCadastrar.addActionListener(
      new frCadastrarVeiculo_btCadastrar_actionAdapter(this)
    );
    jbLimpar.addActionListener(
      new frCadastrarVeiculo_jbLimpar_actionAdapter(this)
    );
    lbTipo.setText("Tipo:");
    lbTipo.setBounds(new Rectangle(202, 56, 34, 15));
    //instacio o objeto
    ccv = new CtrCadastrarVeiculo();
    contentPane = (JPanel) this.getContentPane();
    contentPane.setLayout(borderLayout1);
    this.setResizable(false);
    this.setSize(new Dimension(352, 237));
    //    this.setSize(new Dimension(400, 300));
    this.setTitle("Cadastrar Veiculo");
    jPanel1.setLayout(null);

    lbTara.setText("Tara:");
    lbTara.setBounds(new Rectangle(17, 92, 34, 15));
    tfTara.setText("");
    tfTara.setBounds(new Rectangle(58, 86, 86, 21));
    lbPlaca.setText("Placa:");
    lbPlaca.setBounds(new Rectangle(17, 19, 34, 15));
    tfPlaca.setText("");
    tfPlaca.setBounds(new Rectangle(58, 13, 85, 21));
    lbConsumoMedio.setText("Consumo Médio:");
    lbConsumoMedio.setBounds(new Rectangle(184, 130, 84, 15));
    tfConsumoMedio.setText("");
    tfConsumoMedio.setBounds(new Rectangle(273, 124, 58, 21));
    lbCapacidade.setText("Capacidade:");
    lbCapacidade.setBounds(new Rectangle(199, 92, 71, 15));
    tfCapacidade.setText("");
    tfCapacidade.setBounds(new Rectangle(267, 86, 64, 21));
    lbRefrigeracao.setText("Refrigeração:");
    lbRefrigeracao.setBounds(new Rectangle(15, 130, 76, 15));
    lbCor.setText("Cor:");
    lbCor.setBounds(new Rectangle(19, 56, 34, 15));
    tfCor.setText("");
    tfCor.setBounds(new Rectangle(58, 50, 86, 21));
    lbAno.setText("Ano:");
    lbAno.setBounds(new Rectangle(203, 19, 34, 15));
    tfAno.setText("");
    tfAno.setBounds(new Rectangle(239, 13, 57, 21));
    btCadastrar.setBounds(new Rectangle(32, 169, 85, 25));
    btCadastrar.setText("Cadastrar");
    jbLimpar.setBounds(new Rectangle(136, 169, 73, 25));
    jbLimpar.setText("Limpar");
    btDSair.setBounds(new Rectangle(232, 169, 73, 25));
    btDSair.setText("Sair");
    cbRefrigeracao.setBounds(new Rectangle(92, 124, 53, 21));
    contentPane.add(jPanel1, BorderLayout.CENTER);
  }

  //File | Exit action performed
  public void jMenuFileExit_actionPerformed(ActionEvent e) {
    System.exit(0);
  }

  //Help | About action performed
  public void jMenuHelpAbout_actionPerformed(ActionEvent e) {}

  //Overridden so we can exit when window is closed
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(0);
    }
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

  public String[] preencherRefr() {
    String[] bool = new String[2];
    bool[0] = "Sim";
    bool[1] = "Não";
    return bool;
  }

  void btCadastrar_actionPerformed(ActionEvent e) {
    if (
      !vc.valDouble(tfTara.getText(), "Tara") ||
      !vc.valDouble(tfCapacidade.getText(), "Capacidade") ||
      !vc.valDouble(tfConsumoMedio.getText(), "Consumo Médio") ||
      !vc.valDouble(tfAno.getText(), "Ano") ||
      !vc.valNulo(tfCor.getText(), "Cor") ||
      !vc.valNulo(tfTipo.getText(), "Tipo")
    ) return;

    double tara = Double.parseDouble(tfTara.getText());
    double consmed = Double.parseDouble(tfConsumoMedio.getText());
    String placa = tfPlaca.getText();
    String refr = (String) cbRefrigeracao.getSelectedItem();
    String cor = tfCor.getText();
    double ano = Double.parseDouble(tfAno.getText());
    double capac = Double.parseDouble(tfCapacidade.getText());
    String tipo = tfTipo.getText();
    ccv.cadastrar(placa, tara, capac, consmed, cor, ano, tipo, refr);

    JOptionPane.showMessageDialog(
      null,
      "Cadastro Efetuado com Sucesso!",
      "Cadastro de Veículos",
      JOptionPane.INFORMATION_MESSAGE
    );

    try {
      this.finalize();
      new frCadastrarVeiculo();
      this.setVisible(false);
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
  }

  void btDSair_actionPerformed(ActionEvent e) {
    if (ativa) {
      Object opt[] = { "Sim", "Não" };
      int result = JOptionPane.showOptionDialog(
        this,
        "Deseja Cancelar esse Cadastro",
        "Cadastro de Veículos",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        opt,
        opt[0]
      );
      if (result == JOptionPane.YES_OPTION) {
        try {
          this.finalize();
          this.setVisible(false);
        } catch (Throwable ex) {
          ex.printStackTrace();
        }
      }
    } else {
      this.setVisible(false);
      try {
        ccv.destrutor();
        this.finalize();
      } catch (Throwable ex1) {
        ex1.printStackTrace();
      }
    }
  }

  void jbLimpar_actionPerformed(ActionEvent e) {
    tfTara.setText("");
    tfConsumoMedio.setText("");
    tfPlaca.setText("");
    cbRefrigeracao.setSelectedItem("Sim");
    tfCor.setText("");
    tfAno.setText("");
    tfCapacidade.setText("");
    tfTipo.setText("");
  }

  void tfPlaca_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfAno_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfCor_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfTara_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfCapacidade_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfConsumoMedio_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfTipo_keyPressed(KeyEvent e) {
    ativa = true;
  }
}

class frCadastrarVeiculo_btDSair_actionAdapter
  implements java.awt.event.ActionListener {

  frCadastrarVeiculo adaptee;

  frCadastrarVeiculo_btDSair_actionAdapter(frCadastrarVeiculo adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btDSair_actionPerformed(e);
  }
}

class frCadastrarVeiculo_btCadastrar_actionAdapter
  implements java.awt.event.ActionListener {

  frCadastrarVeiculo adaptee;

  frCadastrarVeiculo_btCadastrar_actionAdapter(frCadastrarVeiculo adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btCadastrar_actionPerformed(e);
  }
}

class frCadastrarVeiculo_jbLimpar_actionAdapter
  implements java.awt.event.ActionListener {

  frCadastrarVeiculo adaptee;

  frCadastrarVeiculo_jbLimpar_actionAdapter(frCadastrarVeiculo adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.jbLimpar_actionPerformed(e);
  }
}

class frCadastrarVeiculo_tfPlaca_keyAdapter extends java.awt.event.KeyAdapter {

  frCadastrarVeiculo adaptee;

  frCadastrarVeiculo_tfPlaca_keyAdapter(frCadastrarVeiculo adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfPlaca_keyPressed(e);
  }
}

class frCadastrarVeiculo_tfAno_keyAdapter extends java.awt.event.KeyAdapter {

  frCadastrarVeiculo adaptee;

  frCadastrarVeiculo_tfAno_keyAdapter(frCadastrarVeiculo adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfAno_keyPressed(e);
  }
}

class frCadastrarVeiculo_tfCor_keyAdapter extends java.awt.event.KeyAdapter {

  frCadastrarVeiculo adaptee;

  frCadastrarVeiculo_tfCor_keyAdapter(frCadastrarVeiculo adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfCor_keyPressed(e);
  }
}

class frCadastrarVeiculo_tfTara_keyAdapter extends java.awt.event.KeyAdapter {

  frCadastrarVeiculo adaptee;

  frCadastrarVeiculo_tfTara_keyAdapter(frCadastrarVeiculo adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfTara_keyPressed(e);
  }
}

class frCadastrarVeiculo_tfCapacidade_keyAdapter
  extends java.awt.event.KeyAdapter {

  frCadastrarVeiculo adaptee;

  frCadastrarVeiculo_tfCapacidade_keyAdapter(frCadastrarVeiculo adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfCapacidade_keyPressed(e);
  }
}

class frCadastrarVeiculo_tfConsumoMedio_keyAdapter
  extends java.awt.event.KeyAdapter {

  frCadastrarVeiculo adaptee;

  frCadastrarVeiculo_tfConsumoMedio_keyAdapter(frCadastrarVeiculo adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfConsumoMedio_keyPressed(e);
  }
}

class frCadastrarVeiculo_tfTipo_keyAdapter extends java.awt.event.KeyAdapter {

  frCadastrarVeiculo adaptee;

  frCadastrarVeiculo_tfTipo_keyAdapter(frCadastrarVeiculo adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfTipo_keyPressed(e);
  }
}
