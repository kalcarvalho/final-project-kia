package CamadaApresentacao;

import Controladoras.CtrAlterarUsuario;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class frAlterarUsuario extends JFrame {

  private ValidarCampo vc;
  protected CtrAlterarUsuario cau = new CtrAlterarUsuario();
  private boolean ativa;
  private Vector mats;
  JButton btSair = new JButton();
  JLabel lbLogin = new JLabel();
  JTextField tfNome = new JTextField();
  JLabel jlTipo = new JLabel();
  JLabel jlSenha = new JLabel();
  JTextField tfTipo = new JTextField();
  JLabel lbNome = new JLabel();
  JButton btLimpar = new JButton();
  JButton btAlterar = new JButton();
  JTextField tfSenha = new JTextField();
  JTextField tfLogin = new JTextField();
  JLabel jlMatricula = new JLabel();
  JComboBox cbMatricula = new JComboBox(cau.preencherMat());

  public frAlterarUsuario() {
    try {
      jbInit();
      //      ativa=false;
      this.formatWindow();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    vc = new ValidarCampo();
    cbMatricula.addActionListener(
      new frAlterarUsuario_cbMatricula_actionAdapter(this)
    );
    cbMatricula.setBounds(new Rectangle(161, 14, 91, 21));
    jlMatricula.setBounds(new Rectangle(20, 20, 148, 15));
    jlMatricula.setText("Selecione a Matricula:");
    jlMatricula.setFont(new java.awt.Font("SansSerif", 1, 12));
    tfLogin.setBackground(SystemColor.text);
    tfLogin.setEnabled(false);
    tfLogin.addKeyListener(new frAlterarUsuario_tfLogin_keyAdapter(this));
    tfLogin.setBounds(new Rectangle(58, 92, 175, 21));
    tfLogin.setText("");
    tfSenha.setBackground(SystemColor.text);
    tfSenha.setEnabled(false);
    tfSenha.setText("");
    tfSenha.setAlignmentX((float) 0.5);
    tfSenha.addKeyListener(new frAlterarUsuario_tfSenha_keyAdapter(this));
    tfSenha.setBounds(new Rectangle(298, 92, 107, 21));
    btAlterar.setEnabled(false);
    btAlterar.addActionListener(
      new frAlterarUsuario_btAlterar_actionAdapter(this)
    );
    btAlterar.setText("Alterar");
    btAlterar.setSelectedIcon(null);
    btAlterar.setBounds(new Rectangle(68, 142, 80, 25));
    btLimpar.setEnabled(false);
    btLimpar.addActionListener(
      new frAlterarUsuario_btLimpar_actionAdapter(this)
    );
    btLimpar.setText("Limpar");
    btLimpar.setBounds(new Rectangle(174, 143, 73, 25));
    lbNome.setBounds(new Rectangle(21, 62, 50, 15));
    lbNome.setText("Nome:");
    tfTipo.setBackground(SystemColor.text);
    tfTipo.setEnabled(false);
    tfTipo.addKeyListener(new frAlterarUsuario_tfTipo_keyAdapter(this));
    tfTipo.setBounds(new Rectangle(297, 56, 107, 21));
    tfTipo.setText("");
    jlSenha.setBounds(new Rectangle(253, 98, 80, 15));
    jlSenha.setText("Senha:");
    jlSenha.setToolTipText("Cadastre uma senha de no m�ximo 8 d�gitos");
    jlTipo.setBounds(new Rectangle(263, 62, 58, 15));
    jlTipo.setText("Tipo:");
    jlTipo.setHorizontalTextPosition(SwingConstants.TRAILING);
    tfNome.setBackground(SystemColor.text);
    tfNome.setEnabled(false);
    tfNome.addKeyListener(new frAlterarUsuario_tfNome_keyAdapter(this));
    tfNome.setBounds(new Rectangle(58, 56, 175, 21));
    tfNome.setText("");
    lbLogin.setBounds(new Rectangle(20, 98, 72, 15));
    lbLogin.setText("Login:");
    btSair.addActionListener(new frAlterarUsuario_btSair_actionAdapter(this));
    btSair.setText("Sair");
    btSair.setBounds(new Rectangle(273, 143, 73, 25));
    this.getContentPane().setLayout(null);
    this.setResizable(false);
    this.setSize(new Dimension(432, 227));
    this.setTitle("Alterar Usu�rio");
    this.getContentPane().add(tfLogin, null);
    this.getContentPane().add(jlMatricula, null);
    this.getContentPane().add(cbMatricula, null);
    this.getContentPane().add(lbNome, null);
    this.getContentPane().add(tfNome, null);
    this.getContentPane().add(jlTipo, null);
    this.getContentPane().add(tfTipo, null);
    this.getContentPane().add(lbLogin, null);
    this.getContentPane().add(jlSenha, null);
    this.getContentPane().add(tfSenha, null);
    this.getContentPane().add(btAlterar, null);
    this.getContentPane().add(btLimpar, null);
    this.getContentPane().add(btSair, null);
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

  public Vector preencherTipo() {
    Vector Tip = new Vector();
    Tip.addElement("");
    Tip.addElement("Funcion�rio");
    Tip.addElement("Gerente");
    return Tip;
  }

  void btAlterar_actionPerformed(ActionEvent e) {
    if (
      !vc.valNulo(tfNome.getText(), "Nome") ||
      !vc.valNulo(tfLogin.getText(), "Login") ||
      !vc.valNulo(tfSenha.getText(), "Senha") ||
      !vc.valNulo(tfTipo.getText(), "Tipo")
    ) return;

    String mat = (String) cbMatricula.getSelectedItem();
    String nome = tfNome.getText();
    String lg = tfLogin.getText();
    String sh = tfSenha.getText();
    String tip = tfTipo.getText();
    cau.alterar(mat, nome, lg, sh, tip);
    JOptionPane.showMessageDialog(
      null,
      "Altera��o Efetuada com Sucesso!",
      "Altera��o de Usu�rios",
      JOptionPane.INFORMATION_MESSAGE
    );

    try {
      this.finalize();
      new frAlterarUsuario();
      this.setVisible(false);
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
  }

  void btLimpar_actionPerformed(ActionEvent e) {
    tfLogin.setText("");
    tfSenha.setText("");
    tfNome.setText("");
    tfTipo.setText("");
  }

  void btSair_actionPerformed(ActionEvent e) {
    if (ativa) {
      Object opt[] = { "Sim", "N�o" };
      int result = JOptionPane.showOptionDialog(
        this,
        "Deseja Realmente Sair, Qualquer Altera��o N�o Ter� Efeito",
        "Altera��o de Usu�rio",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        opt,
        opt[0]
      );
      if (result == JOptionPane.YES_OPTION) {
        try {
          cau.destrutor();
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

  void cbMatricula_actionPerformed(ActionEvent e) {
    String mat = (String) cbMatricula.getSelectedItem();
    mats = cau.selecionarMat(mat);

    tfLogin.setEnabled(true);
    tfSenha.setEnabled(true);
    tfNome.setEnabled(true);
    tfTipo.setEnabled(true);
    btAlterar.setEnabled(true);
    btLimpar.setEnabled(true);

    tfNome.setText((String) mats.get(1));
    tfLogin.setText((String) mats.get(2));
    tfSenha.setText((String) mats.get(3));
    tfTipo.setText((String) mats.get(4));
  }

  void tfNome_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfTipo_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfLogin_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfSenha_keyPressed(KeyEvent e) {
    ativa = true;
  }
}

class frAlterarUsuario_btAlterar_actionAdapter
  implements java.awt.event.ActionListener {

  frAlterarUsuario adaptee;

  frAlterarUsuario_btAlterar_actionAdapter(frAlterarUsuario adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btAlterar_actionPerformed(e);
  }
}

class frAlterarUsuario_btLimpar_actionAdapter
  implements java.awt.event.ActionListener {

  frAlterarUsuario adaptee;

  frAlterarUsuario_btLimpar_actionAdapter(frAlterarUsuario adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btLimpar_actionPerformed(e);
  }
}

class frAlterarUsuario_btSair_actionAdapter
  implements java.awt.event.ActionListener {

  frAlterarUsuario adaptee;

  frAlterarUsuario_btSair_actionAdapter(frAlterarUsuario adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btSair_actionPerformed(e);
  }
}

class frAlterarUsuario_cbMatricula_actionAdapter
  implements java.awt.event.ActionListener {

  frAlterarUsuario adaptee;

  frAlterarUsuario_cbMatricula_actionAdapter(frAlterarUsuario adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.cbMatricula_actionPerformed(e);
  }
}

class frAlterarUsuario_tfNome_keyAdapter extends java.awt.event.KeyAdapter {

  frAlterarUsuario adaptee;

  frAlterarUsuario_tfNome_keyAdapter(frAlterarUsuario adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfNome_keyPressed(e);
  }
}

class frAlterarUsuario_tfTipo_keyAdapter extends java.awt.event.KeyAdapter {

  frAlterarUsuario adaptee;

  frAlterarUsuario_tfTipo_keyAdapter(frAlterarUsuario adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfTipo_keyPressed(e);
  }
}

class frAlterarUsuario_tfLogin_keyAdapter extends java.awt.event.KeyAdapter {

  frAlterarUsuario adaptee;

  frAlterarUsuario_tfLogin_keyAdapter(frAlterarUsuario adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfLogin_keyPressed(e);
  }
}

class frAlterarUsuario_tfSenha_keyAdapter extends java.awt.event.KeyAdapter {

  frAlterarUsuario adaptee;

  frAlterarUsuario_tfSenha_keyAdapter(frAlterarUsuario adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfSenha_keyPressed(e);
  }
}
