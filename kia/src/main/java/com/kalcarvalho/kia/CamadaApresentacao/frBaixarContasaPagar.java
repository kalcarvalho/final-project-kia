package CamadaApresentacao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Vector;
import Controladoras.ctrBaixarContasaPagar;
import CamadaNegocios.Data;

public class frBaixarContasaPagar extends JFrame
{

//   new DateField("",DateField.DATE_TIME);
   public boolean ativa;
   private ctrBaixarContasaPagar cbcp;
   private Data dt;
   private String idCompra;
   JPanel jPanel1 = new JPanel();
   JPanel jPanel2 = new JPanel();
   JPanel jPanel3 = new JPanel();
  JLabel lbContasaPagar = new JLabel();
  JComboBox cbContasaPagar;
  JButton btPagar = new JButton();
  JButton btSair = new JButton();
  JLabel lbDataCompra = new JLabel();
  JLabel lbTotal = new JLabel();
  JLabel lbDataVenc = new JLabel();
  JLabel lbDataPag = new JLabel();
  JLabel lbFornecedor = new JLabel();
  JTextField tfFornecedor = new JTextField();
  JTextField tfTotal = new JTextField();
  JFormattedTextField ftfDataCompra = new JFormattedTextField();
  JFormattedTextField ftfDataVenc = new JFormattedTextField();
  JFormattedTextField ftfDataPag = new JFormattedTextField();
  DecimalFormat decimo=new DecimalFormat("0.00");
   public frBaixarContasaPagar()
   {
      try
      {
	 ativa = false;
	 jbInit();
	 this.formatWindow();
      }
      catch(Exception e)
      {
	 e.printStackTrace();
      }
   }
   private void jbInit() throws Exception
   {
      cbcp = new ctrBaixarContasaPagar();
      dt = new Data();
      cbContasaPagar = new JComboBox(cbcp.preencherContasaPagar());
      this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      this.setResizable(false);
      this.setSize(new Dimension(344, 260));
      this.setTitle("Contas a Pagar");
      this.getContentPane().setLayout(null);
      jPanel1.setBorder(BorderFactory.createEtchedBorder());
      jPanel1.setBounds(new Rectangle(3, 4, 335, 53));
    jPanel1.setLayout(null);
      jPanel2.setBorder(BorderFactory.createEtchedBorder());
      jPanel2.setBounds(new Rectangle(3, 55, 335, 124));
    jPanel2.setLayout(null);
      jPanel3.setBorder(BorderFactory.createEtchedBorder());
      jPanel3.setBounds(new Rectangle(3, 179, 335, 47));
    jPanel3.setLayout(null);
      lbContasaPagar.setFont(new java.awt.Font("Arial", 1, 11));
    lbContasaPagar.setText("Contas a Pagar ID:");
    lbContasaPagar.setBounds(new Rectangle(32, 17, 103, 15));
    cbContasaPagar.setBounds(new Rectangle(138, 15, 69, 19));
    cbContasaPagar.addActionListener(new frBaixarContasaPagar_cbContasaPagar_actionAdapter(this));
    btPagar.setBounds(new Rectangle(84, 13, 71, 23));
    btPagar.setText("Pagar");
    btPagar.addActionListener(new frBaixarContasaPagar_btPagar_actionAdapter(this));
    btSair.setBounds(new Rectangle(165, 13, 71, 23));
    btSair.setText("Sair");
    btSair.addActionListener(new frBaixarContasaPagar_btSair_actionAdapter(this));
    lbDataCompra.setText("Data da Compra:");
    lbDataCompra.setBounds(new Rectangle(11, 45, 100, 15));
    lbTotal.setText("Total:");
    lbTotal.setBounds(new Rectangle(217, 14, 34, 15));
    lbDataVenc.setText("Data de Vencimento:");
    lbDataVenc.setBounds(new Rectangle(10, 72, 106, 15));
    lbDataPag.setText("Data de Pagamento:");
    lbDataPag.setBounds(new Rectangle(12, 100, 103, 15));
    lbFornecedor.setText("Fornecedor:");
    lbFornecedor.setBounds(new Rectangle(13, 14, 81, 15));
    tfFornecedor.setBackground(SystemColor.text);
    tfFornecedor.setText("");
    tfFornecedor.setBounds(new Rectangle(76, 9, 132, 20));
    tfTotal.setBackground(SystemColor.text);
    tfTotal.setText("");
    tfTotal.setBounds(new Rectangle(254, 9, 62, 20));
    ftfDataCompra.setBackground(SystemColor.text);
    ftfDataCompra.setText("");
    ftfDataCompra.setBounds(new Rectangle(122, 39, 108, 21));
    ftfDataVenc.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
    ftfDataVenc.setBackground(SystemColor.text);
    ftfDataVenc.setText("");
    ftfDataVenc.setBounds(new Rectangle(122, 66, 108, 21));
    ftfDataPag.setBackground(SystemColor.text);
    ftfDataPag.setText("");
    ftfDataPag.setBounds(new Rectangle(122, 94, 109, 21));
    this.getContentPane().add(jPanel2, null);
    jPanel1.add(lbContasaPagar, null);
    jPanel1.add(cbContasaPagar, null);
    this.getContentPane().add(jPanel3, null);
    this.getContentPane().add(jPanel1, null);
    jPanel3.add(btPagar, null);
    jPanel3.add(btSair, null);
    jPanel2.add(lbFornecedor, null);
    jPanel2.add(tfTotal, null);
    jPanel2.add(lbTotal, null);
    jPanel2.add(tfFornecedor, null);
    jPanel2.add(ftfDataPag, null);
    jPanel2.add(lbDataPag, null);
    jPanel2.add(lbDataVenc, null);
    jPanel2.add(ftfDataCompra, null);
    jPanel2.add(lbDataCompra, null);
    jPanel2.add(ftfDataVenc, null);
    tfFornecedor.setEditable(false);
    tfTotal.setEditable(false);
    ftfDataCompra.setEditable(false);
    ftfDataPag.setEditable(false);
    ftfDataVenc.setEditable(false);
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


  void cbContasaPagar_actionPerformed(ActionEvent e)
  {
     Vector tela;
     double total;
     idCompra=(String) cbContasaPagar.getSelectedItem();
     tela=cbcp.selecionarConta(idCompra);
     String tmp=(String)tela.get(3);
     tfFornecedor.setText((String)tela.get(0));
     ftfDataCompra.setText(dt.parseInterface((String) tela.get(1)));
     ftfDataVenc.setText(dt.parseInterface((String) tela.get(2)));
     total=Double.parseDouble(tmp);
     tfTotal.setText(decimo.format(total));
     ftfDataPag.setText(dt.getCurrentDate("dd/MM/yyyy"));
  }

  void btSair_actionPerformed(ActionEvent e)
  {
     try
      {
	 cbcp.destrutor();
	 this.finalize();
	 this.setVisible(false);
      }
      catch (Throwable ex)
      {
	 ex.printStackTrace();
      }
  }

  void btPagar_actionPerformed(ActionEvent e)
  {
     cbcp.pagar(idCompra);
     JOptionPane.showMessageDialog(
       null,
       "Pagamento Efetuado com Sucesso!","Contas a Pagar",
       JOptionPane.INFORMATION_MESSAGE);
     try
     {
	this.finalize();
	new frBaixarContasaPagar();
	this.setVisible(false);
     }
     catch (Throwable ex)
     {
	ex.printStackTrace();
     }
  }

}

class frBaixarContasaPagar_cbContasaPagar_actionAdapter implements java.awt.event.ActionListener {
  frBaixarContasaPagar adaptee;

  frBaixarContasaPagar_cbContasaPagar_actionAdapter(frBaixarContasaPagar adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cbContasaPagar_actionPerformed(e);
  }
}

class frBaixarContasaPagar_btSair_actionAdapter implements java.awt.event.ActionListener {
  frBaixarContasaPagar adaptee;

  frBaixarContasaPagar_btSair_actionAdapter(frBaixarContasaPagar adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btSair_actionPerformed(e);
  }
}

class frBaixarContasaPagar_btPagar_actionAdapter implements java.awt.event.ActionListener {
  frBaixarContasaPagar adaptee;

  frBaixarContasaPagar_btPagar_actionAdapter(frBaixarContasaPagar adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btPagar_actionPerformed(e);
  }
}
