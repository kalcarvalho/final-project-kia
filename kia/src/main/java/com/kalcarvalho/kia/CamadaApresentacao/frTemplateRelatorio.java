package CamadaApresentacao;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;

public class frTemplateRelatorio extends JFrame {

  JPanel jPanel1 = new JPanel();
  GridLayout gridLayout1 = new GridLayout();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTable grid = new JTable();
  JToolBar jToolBar1 = new JToolBar();
  JButton btSair = new JButton();
  JButton btImprimir = new JButton();
  ImageIcon image1;
  ImageIcon image2;

  public frTemplateRelatorio(Vector t, int x, int y) {
    try {
      jbInit(x, y);
      this.formatWindow();
      this.setTable(t);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit(int x, int y) throws Exception {
    image1 =
      new ImageIcon(
        CamadaApresentacao.frTemplateRelatorio.class.getResource("openFile.png")
      );
    image2 =
      new ImageIcon(
        CamadaApresentacao.frTemplateRelatorio.class.getResource(
            "closeFile.png"
          )
      );
    jPanel1.setLayout(gridLayout1);
    grid.setBackground(SystemColor.text);
    this.setResizable(false);
    this.setSize(new Dimension(x, y));
    this.getContentPane().add(jPanel1, BorderLayout.WEST);
    this.getContentPane().add(jScrollPane1, BorderLayout.CENTER);
    jScrollPane1.getViewport().add(grid, null);
    btImprimir.setIcon(image2);
    btImprimir.setToolTipText("Sair");
    btImprimir.addActionListener(
      new frTemplateRelatorio_btImprimir_actionAdapter(this)
    );
    btSair.setIcon(image1);
    btSair.setToolTipText("Imprimir");
    btImprimir.addActionListener(
      new frTemplateRelatorio_btSair_actionAdapter(this)
    );
    jToolBar1.add(btImprimir);
    jToolBar1.add(btSair);

    this.getContentPane().add(jToolBar1, BorderLayout.NORTH);
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

  public void setTable(Vector x) {
    Vector a = new Vector();
    Vector b = new Vector();
    try {
      a = (Vector) x.get(0);
    } catch (ArrayIndexOutOfBoundsException ex) {
      JOptionPane.showMessageDialog(
        null,
        "Não Há Registros",
        "Log",
        JOptionPane.INFORMATION_MESSAGE
      );
      return;
    }
    try {
      b = (Vector) x.get(1);
    } catch (ArrayIndexOutOfBoundsException ex) {
      JOptionPane.showMessageDialog(
        null,
        "Não Há Registros",
        "Log",
        JOptionPane.INFORMATION_MESSAGE
      );
      return;
    }
    grid.setModel(new DefaultTableModel(a, b));
  }

  void btImprimir_actionPerformed(ActionEvent e) {}

  void btSair_actionPerformed(ActionEvent e) {
    try {
      super.finalize();
      this.finalize();
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
    this.setVisible(false);
  }
}

class frTemplateRelatorio_btImprimir_actionAdapter
  implements java.awt.event.ActionListener {

  frTemplateRelatorio adaptee;

  frTemplateRelatorio_btImprimir_actionAdapter(frTemplateRelatorio adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btImprimir_actionPerformed(e);
  }
}

class frTemplateRelatorio_btSair_actionAdapter
  implements java.awt.event.ActionListener {

  frTemplateRelatorio adaptee;

  frTemplateRelatorio_btSair_actionAdapter(frTemplateRelatorio adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btSair_actionPerformed(e);
  }
}
