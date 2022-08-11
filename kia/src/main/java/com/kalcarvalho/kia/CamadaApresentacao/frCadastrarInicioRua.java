package CamadaApresentacao;

import Controladoras.CtrCadastrarRota;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class frCadastrarInicioRua extends JDialog {

  public final int RUA_ROTA = 0;
  public final int RUA_LOGR = 1;
  Vector ini = new Vector();
  private Vector ri = new Vector();
  private String cidade;
  private int TIPO_RUA;
  private CtrCadastrarRota ccr;
  GridLayout gridLayout1 = new GridLayout();
  JPanel jPanel1 = new JPanel();
  JLabel lbRua = new JLabel();
  JComboBox cbRua;
  JButton btCadastrar = new JButton();
  JButton btVoltar = new JButton();
  JLabel jLabel1 = new JLabel();
  JTextField tfAltura = new JTextField();
  JLabel jLabel2 = new JLabel();
  JTextField tfExtensao = new JTextField();
  JCheckBox jCheckBox1 = new JCheckBox();

  public frCadastrarInicioRua() {
    try {
      jbInit();
      this.formatWindow();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public frCadastrarInicioRua(String c, int tipo) {
    cidade = c;
    TIPO_RUA = tipo;
    try {
      jbInit();
      this.formatWindow();
      /* if(TIPO_RUA == RUA_ROTA) {
	 Vector inicio = (Vector) ri.get(1);
	 Vector ext = (Vector) ri.get(2);
	 for (int j = 0; j < inicio.size(); j++) cbRua.addItem(inicio.get(j) +
	     "[" + ext.get(j) + "]");
      }*/
    } catch (Exception e) {
      e.printStackTrace();
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

  private void jbInit() throws Exception {
    ccr = new CtrCadastrarRota();

    switch (TIPO_RUA) {
      case RUA_ROTA:
        ri = (Vector) ccr.selecionarEnd(cidade);
        cbRua = new JComboBox((Vector) ccr.selecionarEnd(cidade).get(1));
        jCheckBox1.setEnabled(false);
        tfExtensao.setVisible(false);
        break;
      case RUA_LOGR:
        cbRua = new JComboBox((Vector) ccr.selecionarEnd(cidade).get(0));
        cbRua.setEditable(true);
        break;
      default:
        cbRua = new JComboBox();
    }

    this.setDefaultCloseOperation(
        javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE
      );
    this.setModal(true);
    this.getContentPane().setLayout(gridLayout1);
    this.setResizable(false);
    this.setSize(new Dimension(380, 180));
    this.setTitle("Cadastrar Rua Anterior");
    jPanel1.setLayout(null);
    lbRua.setHorizontalAlignment(SwingConstants.RIGHT);
    lbRua.setHorizontalTextPosition(SwingConstants.TRAILING);
    lbRua.setText("Rua:");
    lbRua.setBounds(new Rectangle(14, 27, 34, 15));
    cbRua.setBounds(new Rectangle(55, 25, 201, 20));
    cbRua.addActionListener(new frCadastrarInicioRua_cbRua_actionAdapter(this));
    btCadastrar.setBounds(new Rectangle(52, 95, 92, 23));
    btCadastrar.setText("Cadastrar");
    btCadastrar.addActionListener(
      new frCadastrarInicioRua_btCadastrar_actionAdapter(this)
    );
    btVoltar.setBounds(new Rectangle(164, 95, 92, 23));
    btVoltar.setText("Voltar");
    btVoltar.addActionListener(
      new frCadastrarInicioRua_btVoltar_actionAdapter(this)
    );
    jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel1.setHorizontalTextPosition(SwingConstants.TRAILING);
    jLabel1.setText("Altura:");
    jLabel1.setBounds(new Rectangle(19, 68, 34, 15));
    tfAltura.setText("");
    tfAltura.setBounds(new Rectangle(60, 65, 77, 20));
    jLabel2.setBounds(new Rectangle(165, 70, 68, 15));
    jLabel2.setText("Extensão:");
    jLabel2.setHorizontalTextPosition(SwingConstants.TRAILING);
    jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
    tfExtensao.setBounds(new Rectangle(237, 67, 62, 20));
    tfExtensao.setText("");
    jCheckBox1.setActionCommand("chkTipo");
    jCheckBox1.setText("Mão Dupla");
    jCheckBox1.setBounds(new Rectangle(272, 33, 91, 25));
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(btVoltar, null);
    jPanel1.add(btCadastrar, null);
    jPanel1.add(tfExtensao, null);
    jPanel1.add(jLabel2, null);
    jPanel1.add(lbRua, null);
    jPanel1.add(cbRua, null);
    jPanel1.add(tfAltura, null);
    jPanel1.add(jLabel1, null);
    jPanel1.add(jCheckBox1, null);
  }

  void btCadastrar_actionPerformed(ActionEvent e) {
    ini.addElement(cbRua.getSelectedItem());
    ini.addElement(tfAltura.getText());

    ini.addElement(tfExtensao.getText());
    if (jCheckBox1.isSelected()) ini.addElement("D"); else ini.addElement("U");

    JOptionPane.showMessageDialog(
      null,
      "Cadastro Efetuado com Sucesso",
      "Cadastro de Rota",
      JOptionPane.INFORMATION_MESSAGE
    );
  }

  void btVoltar_actionPerformed(ActionEvent e) {
    this.setVisible(false);
  }

  public Vector getInicio() {
    return ini;
  }

  void cbRua_actionPerformed(ActionEvent e) {
    /*if(TIPO_RUA == this.RUA_ROTA) {
      String ori = (String) cbRua.getSelectedItem();
      String arr = ori.substring(ori.indexOf("[") + 1, ori.indexOf("]"));
      tfExtensao.setText(arr);
    }*/

  }
}

class frCadastrarInicioRua_btCadastrar_actionAdapter
  implements java.awt.event.ActionListener {

  frCadastrarInicioRua adaptee;

  frCadastrarInicioRua_btCadastrar_actionAdapter(frCadastrarInicioRua adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btCadastrar_actionPerformed(e);
  }
}

class frCadastrarInicioRua_btVoltar_actionAdapter
  implements java.awt.event.ActionListener {

  frCadastrarInicioRua adaptee;

  frCadastrarInicioRua_btVoltar_actionAdapter(frCadastrarInicioRua adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btVoltar_actionPerformed(e);
  }
}

class frCadastrarInicioRua_cbRua_actionAdapter
  implements java.awt.event.ActionListener {

  frCadastrarInicioRua adaptee;

  frCadastrarInicioRua_cbRua_actionAdapter(frCadastrarInicioRua adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.cbRua_actionPerformed(e);
  }
}
