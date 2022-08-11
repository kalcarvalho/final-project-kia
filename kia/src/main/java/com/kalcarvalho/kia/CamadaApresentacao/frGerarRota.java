package CamadaApresentacao;

import Controladoras.CtrGerarRota;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class frGerarRota extends JFrame {

  private Vector pai = new Vector();
  private Vector fidEnd = new Vector();
  private Vector fRua = new Vector();
  private Vector naoRota = new Vector();
  private CtrGerarRota cgr;
  private Vector roteador = new Vector();
  GridLayout gridLayout1 = new GridLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JLabel lbPraca = new JLabel();
  JComboBox cbPraca;
  JPanel jPanel3 = new JPanel();
  JPanel jPanel4 = new JPanel();
  JButton btDetalhes = new JButton();
  JButton btCancelar = new JButton();
  JButton btGerar = new JButton();
  JButton btSair = new JButton();
  GridLayout gridLayout2 = new GridLayout();
  JSplitPane jSplitPane1 = new JSplitPane();
  JScrollPane jScrollPane1 = new JScrollPane();
  JScrollPane jScrollPane2 = new JScrollPane();
  JList jList1 = new JList();
  JList jList2 = new JList();

  public frGerarRota() {
    try {
      jbInit();
      this.formatWindow();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    cgr = new CtrGerarRota();
    cbPraca = new JComboBox(cgr.selecionarPracas());
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.setVisible(true);
    this.setTitle("Gerar Rota de Entrega");
    this.setSize(new Dimension(427, 332));
    this.getContentPane().setLayout(gridLayout1);
    jPanel1.setLayout(null);
    jPanel2.setBorder(BorderFactory.createEtchedBorder());
    jPanel2.setBounds(new Rectangle(1, 1, 426, 59));
    jPanel2.setLayout(null);
    lbPraca.setText("Pra�a:");
    lbPraca.setBounds(new Rectangle(43, 23, 39, 15));
    cbPraca.setBounds(new Rectangle(93, 19, 190, 19));
    cbPraca.addActionListener(new frGerarRota_cbPraca_actionAdapter(this));
    jPanel3.setBorder(BorderFactory.createEtchedBorder());
    jPanel3.setBounds(new Rectangle(1, 59, 426, 188));
    jPanel3.setLayout(gridLayout2);
    jPanel4.setBorder(BorderFactory.createEtchedBorder());
    jPanel4.setBounds(new Rectangle(1, 247, 427, 55));
    jPanel4.setLayout(null);
    btDetalhes.setBounds(new Rectangle(44, 14, 77, 23));
    btDetalhes.setText("Detalhes");
    btDetalhes.addActionListener(
      new frGerarRota_btDetalhes_actionAdapter(this)
    );
    btCancelar.setBounds(new Rectangle(132, 14, 78, 23));
    btCancelar.setText("Cancelar");
    btCancelar.addActionListener(
      new frGerarRota_btCancelar_actionAdapter(this)
    );
    btGerar.setBounds(new Rectangle(223, 14, 71, 23));
    btGerar.setText("Gerar");
    btGerar.addActionListener(new frGerarRota_btGerar_actionAdapter(this));
    btSair.setBounds(new Rectangle(306, 14, 71, 23));
    btSair.setText("Sair");
    btSair.addActionListener(new frGerarRota_btSair_actionAdapter(this));
    jList1.addMouseListener(new frGerarRota_jList1_mouseAdapter(this));
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(jPanel2, null);
    jPanel2.add(cbPraca, null);
    jPanel2.add(lbPraca, null);
    jPanel4.add(btCancelar, null);
    jPanel4.add(btDetalhes, null);
    jPanel4.add(btGerar, null);
    jPanel4.add(btSair, null);
    jPanel1.add(jPanel3, null);
    jPanel3.add(jSplitPane1, null);
    jSplitPane1.setDividerLocation(200);
    jSplitPane1.add(jScrollPane1, JSplitPane.LEFT);
    jSplitPane1.add(jScrollPane2, JSplitPane.RIGHT);
    jPanel1.add(jPanel4, null);
    jScrollPane2.getViewport().add(jList2, null);
    jScrollPane1.getViewport().add(jList1, null);
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

  void cbPraca_actionPerformed(ActionEvent e) {
    pai = cgr.selecionarVenda((String) cbPraca.getSelectedItem());
    if (!pai.isEmpty()) {
      fidEnd = (Vector) pai.get(0);
      fRua = (Vector) pai.get(1);
    } else {
      JOptionPane.showMessageDialog(
        null,
        "N�o h� vendas em aberto",
        "Pra�a",
        JOptionPane.INFORMATION_MESSAGE
      );
      return;
    }
    jList1.setListData(fRua);
  }

  void jList1_mouseClicked(MouseEvent e) {
    int i = jList1.getSelectedIndex();
    naoRota.addElement(fRua.get(i));
    fRua.removeElementAt(i);
    fidEnd.removeElementAt(i);
    jList1.setListData(fRua);
    jList2.setListData(naoRota);
  }

  void btGerar_actionPerformed(ActionEvent e) {
    roteador.addElement(fidEnd);
    roteador.addElement(fRua);
    roteador.addElement(naoRota);
    cgr.gerarRota(roteador);
  }

  void btSair_actionPerformed(ActionEvent e) {
    try {
      cgr.destrutor();
      this.finalize();
      this.setVisible(false);
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
  }

  void btCancelar_actionPerformed(ActionEvent e) {
    try {
      cgr.destrutor();
      this.finalize();
      this.setVisible(false);
      new frGerarRota();
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
  }

  void btDetalhes_actionPerformed(ActionEvent e) {
    if (!fidEnd.isEmpty()) cgr.exibirDetalhes(
      fidEnd
    ); else JOptionPane.showMessageDialog(
      null,
      "Escolha uma pra�a",
      "Rota",
      JOptionPane.INFORMATION_MESSAGE
    );
  }
}

class frGerarRota_cbPraca_actionAdapter
  implements java.awt.event.ActionListener {

  frGerarRota adaptee;

  frGerarRota_cbPraca_actionAdapter(frGerarRota adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.cbPraca_actionPerformed(e);
  }
}

class frGerarRota_jList1_mouseAdapter extends java.awt.event.MouseAdapter {

  frGerarRota adaptee;

  frGerarRota_jList1_mouseAdapter(frGerarRota adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseClicked(MouseEvent e) {
    adaptee.jList1_mouseClicked(e);
  }
}

class frGerarRota_btGerar_actionAdapter
  implements java.awt.event.ActionListener {

  frGerarRota adaptee;

  frGerarRota_btGerar_actionAdapter(frGerarRota adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btGerar_actionPerformed(e);
  }
}

class frGerarRota_btSair_actionAdapter
  implements java.awt.event.ActionListener {

  frGerarRota adaptee;

  frGerarRota_btSair_actionAdapter(frGerarRota adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btSair_actionPerformed(e);
  }
}

class frGerarRota_btCancelar_actionAdapter
  implements java.awt.event.ActionListener {

  frGerarRota adaptee;

  frGerarRota_btCancelar_actionAdapter(frGerarRota adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btCancelar_actionPerformed(e);
  }
}

class frGerarRota_btDetalhes_actionAdapter
  implements java.awt.event.ActionListener {

  frGerarRota adaptee;

  frGerarRota_btDetalhes_actionAdapter(frGerarRota adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btDetalhes_actionPerformed(e);
  }
}
