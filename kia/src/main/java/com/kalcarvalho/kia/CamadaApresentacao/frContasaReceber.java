package CamadaApresentacao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Vector;
import Controladoras.ctrContasaReceber;
import CamadaNegocios.Data;

public class frContasaReceber extends JFrame
{
//   new DateField("",DateField.DATE_TIME);
   public boolean ativa;
   private ctrContasaReceber ccr;
   private Data dt;
   private String idVenda;
   JPanel jPanel1 = new JPanel();
   JPanel jPanel2 = new JPanel();
   JPanel jPanel3 = new JPanel();
  JLabel lbContasaReceber = new JLabel();
  JComboBox cbContasaReceber;
  JButton btLiquidar = new JButton();
  JButton btSair = new JButton();
  JLabel lbDataCompra = new JLabel();
  JLabel lbTotal = new JLabel();
  JLabel lbDataVenc = new JLabel();
  JLabel lbDataPag = new JLabel();
  JLabel lbCliente = new JLabel();
  JTextField tfCliente = new JTextField();
  JTextField tfTotal = new JTextField();
  JFormattedTextField ftfDataVenda = new JFormattedTextField();
  JFormattedTextField ftfDataVenc = new JFormattedTextField();
  JFormattedTextField ftfDataPag = new JFormattedTextField();
  DecimalFormat decimo=new DecimalFormat("0.00");
  JLabel lbFormaPag = new JLabel();
  JComboBox cbFormaPag = new JComboBox();
   public frContasaReceber()
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
      ccr = new ctrContasaReceber();
      dt = new Data();
      cbContasaReceber = new JComboBox(ccr.preencherContasaReceber());
      this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      this.setResizable(false);
      this.setSize(new Dimension(344, 291));
      this.setTitle("Contas a Receber");
      this.getContentPane().setLayout(null);
      jPanel1.setBorder(BorderFactory.createEtchedBorder());
      jPanel1.setBounds(new Rectangle(3, 4, 335, 53));
    jPanel1.setLayout(null);
      jPanel2.setBorder(BorderFactory.createEtchedBorder());
      jPanel2.setBounds(new Rectangle(3, 55, 335, 155));
    jPanel2.setLayout(null);
      jPanel3.setBorder(BorderFactory.createEtchedBorder());
      jPanel3.setBounds(new Rectangle(3, 209, 335, 47));
    jPanel3.setLayout(null);
      lbContasaReceber.setFont(new java.awt.Font("Arial", 1, 11));
    lbContasaReceber.setText("Contas a Receber ID:");
    lbContasaReceber.setBounds(new Rectangle(32, 17, 123, 15));
    cbContasaReceber.setBounds(new Rectangle(164, 15, 69, 19));
    cbContasaReceber.addActionListener(new frContasaReceber_cbContasaReceber_actionAdapter(this));
    btLiquidar.setBounds(new Rectangle(84, 13, 71, 23));
    btLiquidar.setText("Liquidar");
    btLiquidar.addActionListener(new frContasaReceber_btLiquidar_actionAdapter(this));
    btSair.setBounds(new Rectangle(165, 13, 71, 23));
    btSair.setText("Sair");
    btSair.addActionListener(new frContasaReceber_btSair_actionAdapter(this));
    lbDataCompra.setText("Data da Venda:");
    lbDataCompra.setBounds(new Rectangle(11, 45, 100, 15));
    lbTotal.setText("Total:");
    lbTotal.setBounds(new Rectangle(217, 14, 34, 15));
    lbDataVenc.setText("Data de Vencimento:");
    lbDataVenc.setBounds(new Rectangle(10, 72, 106, 15));
    lbDataPag.setText("Data de Pagamento:");
    lbDataPag.setBounds(new Rectangle(12, 100, 103, 15));
    lbCliente.setText("Cliente:");
    lbCliente.setBounds(new Rectangle(13, 14, 46, 15));
    tfCliente.setBackground(SystemColor.text);
    tfCliente.setText("");
    tfCliente.setBounds(new Rectangle(68, 9, 140, 20));
    tfTotal.setBackground(SystemColor.text);
    tfTotal.setText("");
    tfTotal.setBounds(new Rectangle(254, 9, 62, 20));
    ftfDataVenda.setBackground(SystemColor.text);
    ftfDataVenda.setText("");
    ftfDataVenda.setBounds(new Rectangle(122, 39, 108, 21));
    ftfDataVenc.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
    ftfDataVenc.setBackground(SystemColor.text);
    ftfDataVenc.setText("");
    ftfDataVenc.setBounds(new Rectangle(122, 66, 108, 21));
    ftfDataPag.setBackground(SystemColor.text);
    ftfDataPag.setText("");
    ftfDataPag.setBounds(new Rectangle(122, 94, 109, 21));
    lbFormaPag.setText("Forma Pagamento:");
    lbFormaPag.setBounds(new Rectangle(12, 127, 96, 15));
    cbFormaPag.setBounds(new Rectangle(122, 123, 109, 19));
    this.getContentPane().add(jPanel2, null);
    jPanel1.add(lbContasaReceber, null);
    jPanel1.add(cbContasaReceber, null);
    this.getContentPane().add(jPanel3, null);
    this.getContentPane().add(jPanel1, null);
    jPanel3.add(btLiquidar, null);
    jPanel3.add(btSair, null);
    jPanel2.add(lbCliente, null);
    jPanel2.add(tfTotal, null);
    jPanel2.add(lbTotal, null);
    jPanel2.add(tfCliente, null);
    jPanel2.add(ftfDataPag, null);
    jPanel2.add(lbDataPag, null);
    jPanel2.add(lbDataVenc, null);
    jPanel2.add(ftfDataVenda, null);
    jPanel2.add(lbDataCompra, null);
    jPanel2.add(ftfDataVenc, null);
    jPanel2.add(cbFormaPag, null);
    jPanel2.add(lbFormaPag, null);
    tfCliente.setEditable(false);
    tfTotal.setEditable(false);
    ftfDataVenda.setEditable(false);
    ftfDataPag.setEditable(false);
    ftfDataVenc.setEditable(false);
    cbFormaPag.setEditable(false);
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


  void cbContasaReceber_actionPerformed(ActionEvent e)
  {
     Vector tela;
     Vector tipo;
     double total;
     idVenda=(String) cbContasaReceber.getSelectedItem();
     tela=ccr.selecionarConta(idVenda);
     String tmp=(String)tela.get(3);
     tfCliente.setText((String)tela.get(0));
     ftfDataVenda.setText(dt.parseInterface ((String) tela.get(1)));
     ftfDataVenc.setText(dt.parseInterface ((String) tela.get(2)));
     total=Double.parseDouble(tmp);
     tfTotal.setText(decimo.format(total));
     ftfDataPag.setText(dt.getCurrentDate("dd/MM/yyyy"));
     tipo=ccr.getFormaPagto();
     cbFormaPag.removeAllItems();
     for (int i=0;i<tipo.size();i++)
	cbFormaPag.addItem(tipo.get(i));
     tipo.removeAllElements();
  }

  void btSair_actionPerformed(ActionEvent e)
  {
     try
      {
	 ccr.destrutor();
	 this.finalize();
	 this.setVisible(false);
      }
      catch (Throwable ex)
      {
	 ex.printStackTrace();
      }
  }

  void btLiquidar_actionPerformed(ActionEvent e)
  {
     String tipo=(String) cbFormaPag.getSelectedItem();
     ccr.liquidar(idVenda,tipo);
     JOptionPane.showMessageDialog(
       null,
       "Pagamento Efetuado com Sucesso!","Contas a Receber",
       JOptionPane.INFORMATION_MESSAGE);
     try
     {
	this.finalize();
	new frContasaReceber();
	this.setVisible(false);
     }
     catch (Throwable ex)
     {
	ex.printStackTrace();
     }
  }

}

class frContasaReceber_cbContasaReceber_actionAdapter implements java.awt.event.ActionListener {
  frContasaReceber adaptee;

  frContasaReceber_cbContasaReceber_actionAdapter(frContasaReceber adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cbContasaReceber_actionPerformed(e);
  }
}

class frContasaReceber_btSair_actionAdapter implements java.awt.event.ActionListener {
  frContasaReceber adaptee;

  frContasaReceber_btSair_actionAdapter(frContasaReceber adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btSair_actionPerformed(e);
  }
}

class frContasaReceber_btLiquidar_actionAdapter implements java.awt.event.ActionListener {
  frContasaReceber adaptee;

  frContasaReceber_btLiquidar_actionAdapter(frContasaReceber adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btLiquidar_actionPerformed(e);
  }
}
