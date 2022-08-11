package CamadaApresentacao;

import java.awt.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;

public class frTemplate extends JFrame {

  GridLayout gridLayout1 = new GridLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  GridLayout gridLayout2 = new GridLayout();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTable grid = new JTable();
  JLabel jLabel1 = new JLabel();
  GridBagLayout gridBagLayout1 = new GridBagLayout();

  public frTemplate(Vector t, int x, int y) {
    try {
      jbInit(x, y);
      this.formatWindow();
      this.setTable(t);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit(int x, int y) throws Exception {
    this.getContentPane().setLayout(gridLayout1);
    jPanel1.setLayout(null);
    this.setResizable(false);
    this.setSize(new Dimension(x, y));
    jPanel2.setBorder(BorderFactory.createEtchedBorder());
    jPanel2.setBorder(BorderFactory.createEtchedBorder());
    jPanel2.setBounds(new Rectangle(1, 1, 700, 60));
    jPanel2.setLayout(gridBagLayout1);
    jPanel3.setBorder(BorderFactory.createEtchedBorder());
    jPanel3.setBounds(new Rectangle(2, 59, 700, 239));
    jPanel3.setLayout(gridLayout2);
    grid.setBackground(SystemColor.text);
    jLabel1.setText("");
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(jPanel2, null);
    jPanel2.add(
      jLabel1,
      new GridBagConstraints(
        0,
        0,
        1,
        1,
        0.0,
        0.0,
        GridBagConstraints.WEST,
        GridBagConstraints.NONE,
        new Insets(19, 18, 22, 232),
        145,
        15
      )
    );
    jPanel1.add(jPanel3, null);
    jPanel3.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(grid, null);
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
}
