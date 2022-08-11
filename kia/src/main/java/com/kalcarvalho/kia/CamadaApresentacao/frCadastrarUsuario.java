package CamadaApresentacao;

import Controladoras.CtrCadastrarUsuario;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class frCadastrarUsuario extends JFrame {

  private ValidarCampo vc;
  protected CtrCadastrarUsuario ccu;
  private boolean ativa;
  JButton btSair = new JButton();
  JLabel lbLogin = new JLabel();
  JButton btCadastrar = new JButton();
  JTextField tfNome = new JTextField();
  JLabel jlTipo = new JLabel();
  JLabel jlSenha = new JLabel();
  JTextField tfMatricula = new JTextField();
  JLabel lbNome = new JLabel();
  JButton btLimpar = new JButton();
  JComboBox cbTipo = new JComboBox(preencherTipo());
  JTextField tfSenha = new JTextField();
  JTextField tfLogin = new JTextField();
  JLabel jlMatricula = new JLabel();

  public frCadastrarUsuario() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      ativa = false;
      jbInit();
      this.centrWindow();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    //instacio o objeto
    vc = new ValidarCampo();
    ccu = new CtrCadastrarUsuario();
    jlMatricula.setBounds(new Rectangle(248, 29, 75, 15));
    jlMatricula.setText("Matricula:");
    tfLogin.addKeyListener(new frCadastrarUsuario_tfLogin_keyAdapter(this));
    tfLogin.setBounds(new Rectangle(54, 60, 174, 21));
    tfLogin.setText("");
    tfSenha.setText("");
    tfSenha.setAlignmentX((float) 0.5);
    tfSenha.addKeyListener(new frCadastrarUsuario_tfSenha_keyAdapter(this));
    tfSenha.setBounds(new Rectangle(301, 60, 146, 21));
    cbTipo.setBounds(new Rectangle(55, 97, 120, 21));
    cbTipo.setEditable(true);
    btLimpar.addActionListener(
      new frCadastrarUsuario_btLimpar_actionAdapter(this)
    );
    btLimpar.setText("Limpar");
    btLimpar.setBounds(new Rectangle(202, 150, 73, 25));
    lbNome.setBounds(new Rectangle(16, 29, 50, 15));
    lbNome.setText("Nome:");
    tfMatricula.addKeyListener(
      new frCadastrarUsuario_tfMatricula_keyAdapter(this)
    );
    tfMatricula.setBounds(new Rectangle(301, 27, 145, 21));
    tfMatricula.setText("");
    jlSenha.setBounds(new Rectangle(256, 61, 80, 15));
    jlSenha.setText("Senha:");
    jlSenha.setToolTipText("Cadastre uma senha de no máximo 8 dígitos");
    jlTipo.setBounds(new Rectangle(19, 100, 58, 15));
    jlTipo.setText("Tipo:");
    jlTipo.setHorizontalTextPosition(SwingConstants.TRAILING);
    tfNome.addKeyListener(new frCadastrarUsuario_tfNome_keyAdapter(this));
    tfNome.setBounds(new Rectangle(53, 27, 175, 21));
    tfNome.setText("");
    btCadastrar.addActionListener(
      new frCadastrarUsuario_btCadastrar_actionAdapter(this)
    );
    btCadastrar.setText("Cadastrar");
    btCadastrar.setSelectedIcon(null);
    btCadastrar.setBounds(new Rectangle(91, 149, 85, 25));
    lbLogin.setBounds(new Rectangle(15, 63, 72, 15));
    lbLogin.setText("Login:");
    btSair.addActionListener(new frCadastrarUsuario_btSair_actionAdapter(this));
    btSair.setText("Sair");
    btSair.setBounds(new Rectangle(301, 150, 73, 25));
    this.setResizable(false);
    this.setSize(new Dimension(466, 222));
    this.setTitle("Cadastrar Usuário");
    this.getContentPane().setLayout(null);
    //    jButton2.setBounds(new Rectangle(318, 103, 71, 23));
    //  jButton2.setText("jButton2");
    this.getContentPane().add(tfLogin, null);
    this.getContentPane().add(lbNome, null);
    this.getContentPane().add(tfNome, null);
    this.getContentPane().add(jlMatricula, null);
    this.getContentPane().add(tfMatricula, null);
    this.getContentPane().add(lbLogin, null);
    this.getContentPane().add(jlSenha, null);
    this.getContentPane().add(tfSenha, null);
    this.getContentPane().add(jlTipo, null);
    this.getContentPane().add(cbTipo, null);
    this.getContentPane().add(btCadastrar, null);
    this.getContentPane().add(btLimpar, null);
    this.getContentPane().add(btSair, null);
  }

  public void centrWindow() {
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
    Tip.addElement("Funcionário");
    Tip.addElement("Gerente");
    return Tip;
  }

  void btCadastrar_actionPerformed(ActionEvent e) {
    if (
      !vc.valNulo(tfNome.getText(), "Nome") ||
      !vc.valNulo(tfLogin.getText(), "Login") ||
      !vc.valNulo(tfSenha.getText(), "Senha")
    ) return;

    String lg = tfLogin.getText();
    String sh = tfSenha.getText();
    String nome = tfNome.getText();
    String mat = tfMatricula.getText();
    String tip = (String) cbTipo.getSelectedItem();
    ccu.cadastrar(mat, nome, lg, sh, tip);
    JOptionPane.showMessageDialog(
      null,
      "Cadastro Efetuado com Sucesso!",
      "Cadastro de Usuários",
      JOptionPane.INFORMATION_MESSAGE
    );

    try {
      this.finalize();
      new frCadastrarUsuario();
      this.setVisible(false);
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
  }

  void btLimpar_actionPerformed(ActionEvent e) {
    tfLogin.setText("");
    tfSenha.setText("");
    tfNome.setText("");
    tfMatricula.setText("");
    cbTipo.setSelectedItem("");
  }

  void btSair_actionPerformed(ActionEvent e) {
    if (ativa) {
      Object opt[] = { "Sim", "Não" };
      int result = JOptionPane.showOptionDialog(
        this,
        "Deseja Cancelar esse Cadastro",
        "Cadastro de Usuário",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        opt,
        opt[0]
      );
      if (result == JOptionPane.YES_OPTION) {
        try {
          ccu.destrutor();
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

  void tfNome_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfMatricula_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfLogin_keyPressed(KeyEvent e) {
    ativa = true;
  }

  void tfSenha_keyPressed(KeyEvent e) {
    ativa = true;
  }
}

class frCadastrarUsuario_btCadastrar_actionAdapter
  implements java.awt.event.ActionListener {

  frCadastrarUsuario adaptee;

  frCadastrarUsuario_btCadastrar_actionAdapter(frCadastrarUsuario adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btCadastrar_actionPerformed(e);
  }
}

class frCadastrarUsuario_btLimpar_actionAdapter
  implements java.awt.event.ActionListener {

  frCadastrarUsuario adaptee;

  frCadastrarUsuario_btLimpar_actionAdapter(frCadastrarUsuario adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btLimpar_actionPerformed(e);
  }
}

class frCadastrarUsuario_btSair_actionAdapter
  implements java.awt.event.ActionListener {

  frCadastrarUsuario adaptee;

  frCadastrarUsuario_btSair_actionAdapter(frCadastrarUsuario adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btSair_actionPerformed(e);
  }
}

class frCadastrarUsuario_tfNome_keyAdapter extends java.awt.event.KeyAdapter {

  frCadastrarUsuario adaptee;

  frCadastrarUsuario_tfNome_keyAdapter(frCadastrarUsuario adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfNome_keyPressed(e);
  }
}

class frCadastrarUsuario_tfMatricula_keyAdapter
  extends java.awt.event.KeyAdapter {

  frCadastrarUsuario adaptee;

  frCadastrarUsuario_tfMatricula_keyAdapter(frCadastrarUsuario adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfMatricula_keyPressed(e);
  }
}

class frCadastrarUsuario_tfLogin_keyAdapter extends java.awt.event.KeyAdapter {

  frCadastrarUsuario adaptee;

  frCadastrarUsuario_tfLogin_keyAdapter(frCadastrarUsuario adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfLogin_keyPressed(e);
  }
}

class frCadastrarUsuario_tfSenha_keyAdapter extends java.awt.event.KeyAdapter {

  frCadastrarUsuario adaptee;

  frCadastrarUsuario_tfSenha_keyAdapter(frCadastrarUsuario adaptee) {
    this.adaptee = adaptee;
  }

  public void keyPressed(KeyEvent e) {
    adaptee.tfSenha_keyPressed(e);
  }
}
