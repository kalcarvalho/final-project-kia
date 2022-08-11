package CamadaApresentacao;

import Controladoras.CtrAlterarVeiculo;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class frAlterarVeiculo extends JFrame {

  private ValidarCampo vc;
  private CtrAlterarVeiculo cav = new CtrAlterarVeiculo();
  private boolean ativa;
  private Vector placas;
  JPanel contentPane;
  ImageIcon image1;
  ImageIcon image2;
  ImageIcon image3;
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JLabel lbTara = new JLabel();
  JTextField tfTara = new JTextField();
  JLabel lbPlaca = new JLabel();
  JLabel lbConsumoMedio = new JLabel();
  JTextField tfConsumoMedio = new JTextField();
  JLabel lbCapacidade = new JLabel();
  JTextField tfCapacidade = new JTextField();
  JLabel lbRefrigeracao = new JLabel();
  JLabel lbCor = new JLabel();
  JTextField tfCor = new JTextField();
  JLabel lbAno = new JLabel();
  JTextField tfAno = new JTextField();
  JButton btAlterar = new JButton();
  JButton jbLimpar = new JButton();
  JButton btDSair = new JButton();
  JLabel lbTipo = new JLabel();
  JComboBox cbPlaca = new JComboBox(cav.preencherPlaca());
  JTextField tfRefrigeracao = new JTextField();
  JTextField tfTipo = new JTextField();

  public frAlterarVeiculo() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      ativa = false;
      jbInit();
      this.formatWindow();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    vc = new ValidarCampo();
    tfAno.addKeyListener(new frAlterarVeiculo_tfAno_keyAdapter(this));
    tfCor.addKeyListener(new frAlterarVeiculo_tfCor_keyAdapter(this));
    tfTara.addKeyListener(new frAlterarVeiculo_tfTara_keyAdapter(this));
    tfCapacidade.addKeyListener(
      new frAlterarVeiculo_tfCapacidade_keyAdapter(this)
    );
    tfConsumoMedio.addKeyListener(
      new frAlterarVeiculo_tfConsumoMedio_keyAdapter(this)
    );
    cbPlaca.setBounds(new Rectangle(135, 13, 76, 21));
    cbPlaca.addActionListener(new frAlterarVeiculo_cbPlaca_actionAdapter(this));
    tfRefrigeracao.setBackground(SystemColor.text);
    tfRefrigeracao.setText("");
    tfRefrigeracao.setBounds(new Rectangle(89, 122, 57, 21));
    tfRefrigeracao.addKeyListener(
      new frAlterarVeiculo_tfRefrigeracao_keyAdapter(this)
    );
    tfTipo.setBackground(SystemColor.text);
    tfTipo.setText("");
    tfTipo.setBounds(new Rectangle(243, 50, 90, 21));
    tfTipo.addKeyListener(new frAlterarVeiculo_tfTipo_keyAdapter(this));
    lbPlaca.setFont(new java.awt.Font("SansSerif", 1, 12));
    this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    tfAno.setBackground(SystemColor.text);
    tfCor.setBackground(SystemColor.text);
    tfTara.setBackground(SystemColor.text);
    tfCapacidade.setBackground(SystemColor.text);
    tfConsumoMedio.setBackground(SystemColor.text);
    jPanel1.add(lbPlaca, null);
    jPanel1.add(tfAno, null);
    jPanel1.add(lbAno, null);
    jPanel1.add(tfTara, null);
    jPanel1.add(lbCor, null);
    jPanel1.add(tfCor, null);
    jPanel1.add(lbTipo, null);
    jPanel1.add(lbTara, null);
    jPanel1.add(lbCapacidade, null);
    jPanel1.add(tfCapacidade, null);
    jPanel1.add(lbRefrigeracao, null);
    jPanel1.add(lbConsumoMedio, null);
    jPanel1.add(tfConsumoMedio, null);
    jPanel1.add(btAlterar, null);
    jPanel1.add(jbLimpar, null);
    jPanel1.add(btDSair, null);
    jPanel1.add(tfRefrigeracao, null);
    jPanel1.add(tfTipo, null);
    jPanel1.add(cbPlaca, null);
    btDSair.addActionListener(new frAlterarVeiculo_btDSair_actionAdapter(this));
    btAlterar.addActionListener(
      new frAlterarVeiculo_btAlterar_actionAdapter(this)
    );
    jbLimpar.addActionListener(
      new frAlterarVeiculo_jbLimpar_actionAdapter(this)
    );
    lbTipo.setText("Tipo:");
    lbTipo.setBounds(new Rectangle(204, 56, 34, 15));
    contentPane = (JPanel) this.getContentPane();
    contentPane.setLayout(borderLayout1);
    this.setResizable(false);
    this.setSize(new Dimension(352, 230));
    this.setTitle("Alterar Ve�culo");
    jPanel1.setLayout(null);
    lbTara.setText("Tara:");
    lbTara.setBounds(new Rectangle(19, 90, 34, 15));
    tfTara.setText("");
    tfTara.setBounds(new Rectangle(60, 84, 86, 21));
    lbPlaca.setText("Selecione a Placa:");
    lbPlaca.setBounds(new Rectangle(17, 19, 105, 15));
    lbConsumoMedio.setText("Consumo M�dio:");
    lbConsumoMedio.setBounds(new Rectangle(186, 128, 84, 15));
    tfConsumoMedio.setText("");
    tfConsumoMedio.setBounds(new Rectangle(275, 122, 58, 21));
    lbCapacidade.setText("Capacidade:");
    lbCapacidade.setBounds(new Rectangle(201, 90, 71, 15));
    tfCapacidade.setText("");
    tfCapacidade.setBounds(new Rectangle(269, 84, 64, 21));
    lbRefrigeracao.setText("Refrigera��o:");
    lbRefrigeracao.setBounds(new Rectangle(17, 128, 76, 15));
    lbCor.setText("Cor:");
    lbCor.setBounds(new Rectangle(21, 56, 34, 15));
    tfCor.setText("");
    tfCor.setBounds(new Rectangle(60, 50, 86, 21));
    lbAno.setText("Ano:");
    lbAno.setBounds(new Rectangle(232, 19, 34, 15));
    tfAno.setText("");
    tfAno.setBounds(new Rectangle(276, 13, 57, 21));
    btAlterar.setBounds(new Rectangle(34, 167, 85, 25));
    btAlterar.setText("Alterar");
    jbLimpar.setBounds(new Rectangle(138, 167, 73, 25));
    jbLimpar.setText("Limpar");
    btDSair.setBounds(new Rectangle(234, 167, 73, 25));
    btDSair.setText("Sair");
    contentPane.add(jPanel1, BorderLayout.CENTER);
    tfTara.setEnabled(false);
    tfCapacidade.setEnabled(false);
    tfConsumoMedio.setEnabled(false);
    tfCor.setEnabled(false);
    tfAno.setEnabled(false);
    tfTipo.setEnabled(false);
    tfRefrigeracao.setEnabled(false);
    btAlterar.setEnabled(false);
    jbLimpar.setEnabled(false);
  }

  public void jMenuFileExit_actionPerformed(ActionEvent e) {
    System.exit(0);
  }

  public void jMenuHelpAbout_actionPerformed(ActionEvent e) {}

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

  public String[] preencherBool() {
    String[] bool = new String[2];
    bool[0] = "Sim";
    bool[1] = "Nao";
    return bool;
  }

  void btAlterar_actionPerformed(ActionEvent e) {
    if (
      !vc.valDouble(tfTara.getText(), "Tara") ||
      !vc.valDouble(tfCapacidade.getText(), "Capacidade") ||
      !vc.valDouble(tfConsumoMedio.getText(), "Consumo M�dio") ||
      !vc.valDouble(tfAno.getText(), "Ano") ||
      !vc.valNulo(tfCor.getText(), "Cor") ||
      !vc.valNulo(tfTipo.getText(), "Tipo") ||
      !vc.valNulo(tfRefrigeracao.getText(), "Refrigera��o")
    ) return;
    String placa = (String) cbPlaca.getSelectedItem();
    double tara = Double.parseDouble(tfTara.getText());
    double capac = Double.parseDouble(tfCapacidade.getText());
    double consmed = Double.parseDouble(tfConsumoMedio.getText());
    String cor = tfCor.getText();
    double ano = Double.parseDouble(tfAno.getText());
    String tipo = tfTipo.getText();
    String refr = tfRefrigeracao.getText();
    cav.alterar(placa, tara, capac, consmed, cor, ano, tipo, refr);
    JOptionPane.showMessageDialog(
      null,
      "Altera��o Efetuada com Sucesso!",
      "Altera��o de Ve�culos",
      JOptionPane.INFORMATION_MESSAGE
    );
    try {
      this.finalize();
      new frAlterarVeiculo();
      this.setVisible(false);
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
  }

  void btDSair_actionPerformed(ActionEvent e) {
    if (ativa) {
      Object opt[] = { "Sim", "N�o" };
      int result = JOptionPane.showOptionDialog(
        this,
        "Deseja Realmente Sair, Qualquer Altera��o N�o Ter� Efeito",
        "Altera��o de Ve�culo",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        opt,
        opt[0]
      );
      if (result == JOptionPane.YES_OPTION) {
        try {
          cav.destrutor();
          this.finalize();
          this.setVisible(false);
        } catch (Throwable ex) {
          ex.printStackTrace();
        }
      }
    } else {
      this.setVisible(false);
      try {
        this.finalize();
      } catch (Throwable ex1) {
        ex1.printStackTrace();
      }
    }
  }

  void jbLimpar_actionPerformed(ActionEvent e) {
    tfTara.setText("");
    tfConsumoMedio.setText("");
    tfRefrigeracao.setText("");
    tfCor.setText("");
    tfAno.setText("");
    tfCapacidade.setText("");
    tfTipo.setText("");
    cbPlaca.setSelectedItem("");
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

  void cbPlaca_actionPerformed(ActionEvent e) {
    String placa = (String) cbPlaca.getSelectedItem();
    placas = cav.selecionarPlaca(placa);
    tfTara.setEnabled(true);
    tfCapacidade.setEnabled(true);
    tfConsumoMedio.setEnabled(true);
    tfCor.setEnabled(true);
    tfAno.setEnabled(true);
    tfTipo.setEnabled(true);
    tfRefrigeracao.setEnabled(true);
    btAlterar.setEnabled(true);
    jbLimpar.setEnabled(true);
    tfTara.setText((String) placas.get(1));
    tfCapacidade.setText((String) placas.get(2));
    tfConsumoMedio.setText((String) placas.get(3));
    tfCor.setText((String) placas.get(4));
    tfAno.setText((String) placas.get(5));
    tfTipo.setText((String) placas.get(6));
    tfRefrigeracao.setText((String) placas.get(7));
  }

  void tfTipo_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfRefrigeracao_keyPressed(KeyEvent e) {
    ativa = true;
  }
}

class frAlterarVeiculo_btDSair_actionAdapter
  implements java.awt.event.ActionListener {

  frAlterarVeiculo adaptee;

  frAlterarVeiculo_btDSair_actionAdapter(frAlterarVeiculo adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btDSair_actionPerformed(e);
  }
}

class frAlterarVeiculo_btAlterar_actionAdapter
  implements java.awt.event.ActionListener {

  frAlterarVeiculo adaptee;

  frAlterarVeiculo_btAlterar_actionAdapter(frAlterarVeiculo adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btAlterar_actionPerformed(e);
  }
}

class frAlterarVeiculo_jbLimpar_actionAdapter
  implements java.awt.event.ActionListener {

  frAlterarVeiculo adaptee;

  frAlterarVeiculo_jbLimpar_actionAdapter(frAlterarVeiculo adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.jbLimpar_actionPerformed(e);
  }
}

class frAlterarVeiculo_tfAno_keyAdapter extends java.awt.event.KeyAdapter {

  frAlterarVeiculo adaptee;

  frAlterarVeiculo_tfAno_keyAdapter(frAlterarVeiculo adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfAno_keyPressed(e);
  }
}

class frAlterarVeiculo_tfCor_keyAdapter extends java.awt.event.KeyAdapter {

  frAlterarVeiculo adaptee;

  frAlterarVeiculo_tfCor_keyAdapter(frAlterarVeiculo adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfCor_keyPressed(e);
  }
}

class frAlterarVeiculo_tfTara_keyAdapter extends java.awt.event.KeyAdapter {

  frAlterarVeiculo adaptee;

  frAlterarVeiculo_tfTara_keyAdapter(frAlterarVeiculo adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfTara_keyPressed(e);
  }
}

class frAlterarVeiculo_tfCapacidade_keyAdapter
  extends java.awt.event.KeyAdapter {

  frAlterarVeiculo adaptee;

  frAlterarVeiculo_tfCapacidade_keyAdapter(frAlterarVeiculo adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfCapacidade_keyPressed(e);
  }
}

class frAlterarVeiculo_tfConsumoMedio_keyAdapter
  extends java.awt.event.KeyAdapter {

  frAlterarVeiculo adaptee;

  frAlterarVeiculo_tfConsumoMedio_keyAdapter(frAlterarVeiculo adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfConsumoMedio_keyPressed(e);
  }
}

class frAlterarVeiculo_cbPlaca_actionAdapter
  implements java.awt.event.ActionListener {

  frAlterarVeiculo adaptee;

  frAlterarVeiculo_cbPlaca_actionAdapter(frAlterarVeiculo adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.cbPlaca_actionPerformed(e);
  }
}

class frAlterarVeiculo_tfTipo_keyAdapter extends java.awt.event.KeyAdapter {

  frAlterarVeiculo adaptee;

  frAlterarVeiculo_tfTipo_keyAdapter(frAlterarVeiculo adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfTipo_keyPressed(e);
  }
}

class frAlterarVeiculo_tfRefrigeracao_keyAdapter
  extends java.awt.event.KeyAdapter {

  frAlterarVeiculo adaptee;

  frAlterarVeiculo_tfRefrigeracao_keyAdapter(frAlterarVeiculo adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfRefrigeracao_keyPressed(e);
  }
}
