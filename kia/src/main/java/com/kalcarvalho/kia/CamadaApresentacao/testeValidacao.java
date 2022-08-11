package CamadaApresentacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class testeValidacao extends JFrame
{
   private ValidarCampo vc;
   JLabel jLabel1 = new JLabel();
   JLabel jLabel2 = new JLabel();
   JLabel jLabel3 = new JLabel();
   JLabel jLabel4 = new JLabel();
   JLabel jLabel5 = new JLabel();
   JLabel jLabel6 = new JLabel();
   JTextField tfDouble = new JTextField();
   JTextField tfDoubleNulo = new JTextField();
   JTextField tfInteiro = new JTextField();
   JTextField tfInterNulo = new JTextField();
   JTextField tfnulo = new JTextField();
   JTextField tfString = new JTextField();
  JButton jButton1 = new JButton();
   public testeValidacao()
   {
      try {
        jbInit();
	this.formatWindow();
      }
      catch(Exception e) {
        e.printStackTrace();
      }
   }
   private void jbInit() throws Exception
   {
      vc = new ValidarCampo();
     this.setSize(new Dimension(300, 300));
     jLabel1.setText("double");
     jLabel1.setBounds(new Rectangle(40, 31, 34, 15));
     this.getContentPane().setLayout(null);
     jLabel2.setText("doubleeNulo");
     jLabel2.setBounds(new Rectangle(40, 68, 63, 15));
     jLabel3.setText("inteiro");
     jLabel3.setBounds(new Rectangle(40, 99, 34, 15));
     jLabel4.setText("inteiroeNulo");
     jLabel4.setBounds(new Rectangle(40, 132, 71, 15));
     jLabel5.setText("nulo");
     jLabel5.setBounds(new Rectangle(40, 165, 30, 15));
     jLabel6.setText("string");
     jLabel6.setBounds(new Rectangle(38, 198, 34, 15));
     tfDouble.setBounds(new Rectangle(114, 26, 62, 20));
     tfDoubleNulo.setBounds(new Rectangle(114, 63, 62, 20));
     tfInteiro.setBounds(new Rectangle(114, 94, 62, 20));
     tfInterNulo.setBounds(new Rectangle(114, 127, 62, 20));
     tfnulo.setBounds(new Rectangle(114, 160, 62, 20));
     tfString.setBounds(new Rectangle(114, 193, 62, 20));
     this.setTitle("Teste de Validação");
    jButton1.setBounds(new Rectangle(195, 110, 71, 23));
    jButton1.setText("testar");
    jButton1.addActionListener(new testeValidacao_jButton1_actionAdapter(this));
    this.getContentPane().add(jLabel1, null);
     this.getContentPane().add(jLabel2, null);
     this.getContentPane().add(jLabel3, null);
     this.getContentPane().add(jLabel4, null);
     this.getContentPane().add(jLabel5, null);
     this.getContentPane().add(jLabel6, null);
     this.getContentPane().add(tfDouble, null);
     this.getContentPane().add(tfDoubleNulo, null);
     this.getContentPane().add(tfInteiro, null);
     this.getContentPane().add(tfInterNulo, null);
     this.getContentPane().add(tfnulo, null);
     this.getContentPane().add(tfString, null);
    this.getContentPane().add(jButton1, null);
   }

   public void formatWindow()
    {
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      Dimension frameSize = this.getSize();
      if (frameSize.height > screenSize.height)
      {
	frameSize.height = screenSize.height;
      }
      if (frameSize.width > screenSize.width)
      {
	frameSize.width = screenSize.width;
      }
      this.setLocation((screenSize.width - frameSize.width) / 2,
		       (screenSize.height - frameSize.height) / 2);
      this.setVisible(true);
    }



  void jButton1_actionPerformed(ActionEvent e)
  {
     String a=new String();
     double x;
     int y;
//     x=vc.valDouble(tfDouble.getText());
//     x=vc.valDouble(tfDouble.getText(),"double");
//     y=vc.valInt(tfInteiro.getText());
  //   System.out.println(x);
  //   System.out.println(y);
  //   a=vc.valNulo(tfString.getText(),"String");
    // System.out.println(a);
  }

public static void main(String[] args)
{
  try
  {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
  }
  catch(Exception e)
  {
    e.printStackTrace();
  }
  new testeValidacao();
}

}

class testeValidacao_jButton1_actionAdapter implements java.awt.event.ActionListener {
  testeValidacao adaptee;

  testeValidacao_jButton1_actionAdapter(testeValidacao adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton1_actionPerformed(e);
  }
}
