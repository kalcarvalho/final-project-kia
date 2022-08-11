package CamadaApresentacao;

import java.awt.*;
import java.util.Vector;
import javax.swing.*;

public class frLogMaquina extends JFrame {

  GridLayout gridLayout1 = new GridLayout();
  JPanel jPanel1 = new JPanel();
  GridLayout gridLayout2 = new GridLayout();
  JScrollPane jScrollPane1 = new JScrollPane();
  JLabel lbJavaRunTimeS = new JLabel();
  JLabel lbFbricanteS = new JLabel();
  JLabel lbVersaoBDE = new JLabel();
  JLabel lbDirUsuS = new JLabel();
  JLabel lbBDE = new JLabel();
  JLabel lbIdiomaS = new JLabel();
  JLabel lbDirUsuE = new JLabel();
  JLabel lbBDS = new JLabel();
  JLabel lbSoE = new JLabel();
  JLabel lbDirHomeE = new JLabel();
  JLabel lbJavaRunTimeE = new JLabel();
  JLabel lbPaisS = new JLabel();
  JLabel lbFabricante = new JLabel();
  JLabel lbPaisE = new JLabel();
  JLabel lbSoS = new JLabel();
  JLabel lbDirHomeS = new JLabel();
  JLabel lbVersaoJVMS = new JLabel();
  JLabel lbVersaoBDS = new JLabel();
  JPanel jPanel2 = new JPanel();
  JLabel lbIdiomaE = new JLabel();
  JLabel lbNomeUsuE = new JLabel();
  JLabel lbNomeUsuS = new JLabel();
  JLabel lbVersaoJVME = new JLabel();

  public frLogMaquina(Vector log) {
    try {
      jbInit(log);
      this.formatWindow();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit(Vector log) throws Exception {
    this.setResizable(false);
    this.setTitle("Sobre o Computador");
    this.setSize(new Dimension(516, 396));
    this.getContentPane().setLayout(gridLayout1);
    jPanel1.setLayout(gridLayout2);
    lbJavaRunTimeS.setBounds(new Rectangle(171, 64, 336, 15));
    lbJavaRunTimeS.setText((String) log.get(1));
    lbJavaRunTimeS.setFont(new java.awt.Font("Bookman Old Style", 0, 11));
    lbFbricanteS.setBounds(new Rectangle(171, 127, 337, 15));
    lbFbricanteS.setText((String) log.get(3));
    lbFbricanteS.setFont(new java.awt.Font("Bookman Old Style", 0, 11));
    lbVersaoBDE.setBounds(new Rectangle(40, 184, 125, 14));
    lbVersaoBDE.setText("Versão bd:");
    lbVersaoBDE.setFont(new java.awt.Font("Bookman Old Style", 0, 11));
    lbDirUsuS.setBounds(new Rectangle(171, 238, 339, 15));
    lbDirUsuS.setText((String) log.get(5));
    lbDirUsuS.setFont(new java.awt.Font("Bookman Old Style", 0, 11));
    lbBDE.setBounds(new Rectangle(40, 157, 115, 15));
    lbBDE.setText("Banco de Dados:");
    lbBDE.setFont(new java.awt.Font("Bookman Old Style", 0, 11));
    lbIdiomaS.setBounds(new Rectangle(171, 293, 338, 15));
    lbIdiomaS.setText((String) log.get(7));
    lbIdiomaS.setFont(new java.awt.Font("Bookman Old Style", 0, 11));
    lbDirUsuE.setBounds(new Rectangle(40, 238, 126, 15));
    lbDirUsuE.setText("Diretório BD:");
    lbDirUsuE.setFont(new java.awt.Font("Bookman Old Style", 0, 11));
    lbBDS.setBounds(new Rectangle(171, 156, 338, 15));
    lbBDS.setText((String) log.get(9));
    lbBDS.setFont(new java.awt.Font("Bookman Old Style", 0, 11));
    lbSoE.setBounds(new Rectangle(40, 34, 119, 15));
    lbSoE.setText("Sistema Operacional:");
    lbSoE.setFont(new java.awt.Font("Bookman Old Style", 0, 11));
    lbDirHomeE.setBounds(new Rectangle(40, 267, 127, 15));
    lbDirHomeE.setText("Diretório Backup BD:");
    lbDirHomeE.setFont(new java.awt.Font("Bookman Old Style", 0, 11));
    lbJavaRunTimeE.setBounds(new Rectangle(40, 64, 116, 15));
    lbJavaRunTimeE.setText("Java Runtime:");
    lbJavaRunTimeE.setFont(new java.awt.Font("Bookman Old Style", 0, 11));
    lbPaisS.setBounds(new Rectangle(171, 322, 338, 15));
    lbPaisS.setText((String) log.get(8));
    lbPaisS.setFont(new java.awt.Font("Bookman Old Style", 0, 11));
    lbFabricante.setBounds(new Rectangle(40, 127, 110, 15));
    lbFabricante.setText("Fabricante:");
    lbFabricante.setFont(new java.awt.Font("Bookman Old Style", 0, 11));
    lbPaisE.setBounds(new Rectangle(40, 320, 118, 15));
    lbPaisE.setText("País:");
    lbPaisE.setFont(new java.awt.Font("Bookman Old Style", 0, 11));
    lbSoS.setFont(new java.awt.Font("Bookman Old Style", 0, 11));
    lbSoS.setText((String) log.get(0));
    lbSoS.setBounds(new Rectangle(171, 34, 336, 15));
    lbDirHomeS.setFont(new java.awt.Font("Bookman Old Style", 0, 11));
    lbDirHomeS.setText((String) log.get(6));
    lbDirHomeS.setBounds(new Rectangle(171, 267, 339, 15));
    lbVersaoJVMS.setFont(new java.awt.Font("Bookman Old Style", 0, 11));
    lbVersaoJVMS.setText((String) log.get(2));
    lbVersaoJVMS.setBounds(new Rectangle(171, 97, 338, 15));
    lbVersaoBDS.setFont(new java.awt.Font("Bookman Old Style", 0, 11));
    lbVersaoBDS.setText((String) log.get(10));
    lbVersaoBDS.setBounds(new Rectangle(171, 183, 340, 15));
    jPanel2.setFont(new java.awt.Font("Bookman Old Style", 0, 11));
    jPanel2.setBackground(Color.lightGray);
    jPanel2.setLayout(null);
    lbIdiomaE.setFont(new java.awt.Font("Bookman Old Style", 0, 11));
    lbIdiomaE.setText("Idioma:");
    lbIdiomaE.setBounds(new Rectangle(40, 293, 126, 15));
    lbNomeUsuE.setFont(new java.awt.Font("Bookman Old Style", 0, 11));
    lbNomeUsuE.setText("Nome do Usuário:");
    lbNomeUsuE.setBounds(new Rectangle(40, 210, 118, 15));
    lbNomeUsuS.setFont(new java.awt.Font("Bookman Old Style", 0, 11));
    lbNomeUsuS.setText((String) log.get(4));
    lbNomeUsuS.setBounds(new Rectangle(171, 210, 338, 15));
    lbVersaoJVME.setFont(new java.awt.Font("Bookman Old Style", 0, 11));
    lbVersaoJVME.setText("Versão JVM:");
    lbVersaoJVME.setBounds(new Rectangle(40, 97, 115, 15));
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(jPanel2, null);
    jPanel2.add(lbSoE, null);
    jPanel2.add(lbJavaRunTimeE, null);
    jPanel2.add(lbVersaoJVME, null);
    jPanel2.add(lbFabricante, null);
    jPanel2.add(lbFbricanteS, null);
    jPanel2.add(lbSoS, null);
    jPanel2.add(lbJavaRunTimeS, null);
    jPanel2.add(lbVersaoJVMS, null);
    jPanel2.add(lbBDS, null);
    jPanel2.add(lbBDE, null);
    jPanel2.add(lbIdiomaS, null);
    jPanel2.add(lbNomeUsuE, null);
    jPanel2.add(lbNomeUsuS, null);
    jPanel2.add(lbDirUsuE, null);
    jPanel2.add(lbDirUsuS, null);
    jPanel2.add(lbDirHomeE, null);
    jPanel2.add(lbDirHomeS, null);
    jPanel2.add(lbIdiomaE, null);
    jPanel2.add(lbPaisE, null);
    jPanel2.add(lbPaisS, null);
    jPanel2.add(lbVersaoBDE, null);
    jPanel2.add(lbVersaoBDS, null);
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
}
