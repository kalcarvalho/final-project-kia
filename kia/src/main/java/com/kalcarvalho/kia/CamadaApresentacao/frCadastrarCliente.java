package CamadaApresentacao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;
import Controladoras.CtrCadastrarCliente;

public class frCadastrarCliente extends JDialog
{
   private Vector ends=new Vector();
   private Vector idEnds=new Vector();
   private ValidarCampo vc;
   private CtrCadastrarCliente ccc;
   private boolean ativa;
   private String cnpj;
   private String rua;
   private String bairro;
   private String cidade;
   private String estado;
   private String cep;
   private String numero;
   private String Email;
   private String telefone;
   private String fax;

  JComboBox cbEstado = new JComboBox(preencherEstado());
  JTextField TFcep = new JTextField();
  JPanel jPanel4 = new JPanel();
  JTextField tfNomeFantasia = new JTextField();
  JTextField tfCNPJ = new JTextField();
  JLabel lbTelefone = new JLabel();
  JTextField tfTelefone = new JTextField();
  JLabel lbNumero = new JLabel();
  JLabel lbRazaoSocial = new JLabel();
  JPanel jPanel3 = new JPanel();
  JLabel lbEstado = new JLabel();
  JLabel lbCep = new JLabel();
  JButton btLimpar = new JButton();
  JTextField tfInscEstadual = new JTextField();
  JLabel lbBairro = new JLabel();
  JLabel jlEndereco = new JLabel();
  JTextField tfCidade = new JTextField();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel5 = new JPanel();
  JLabel lbCNPJ = new JLabel();
  JTextField tfFax = new JTextField();
  JLabel lbFax = new JLabel();
  JButton btSair = new JButton();
  JTextField tfEmail = new JTextField();
  JLabel lbCidade = new JLabel();
  JLabel jlNomeFantasia = new JLabel();
  JButton btCadastrar = new JButton();
  JTextField tfBairro = new JTextField();
  JLabel jlInscEstadual = new JLabel();
  JButton btOutroTel = new JButton();
  JLabel lbEmail = new JLabel();
  JButton btOutroEndereco = new JButton();
  JTextField tfNumero = new JTextField();
  JTextField tfRazaoSocial = new JTextField();
  JComboBox cbEnd;
  public frCadastrarCliente() throws HeadlessException
  {
    try
    {
      jbInit();
      ativa = false;
      this.formatWindow();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception
  {
     this.setModal(true);
     vc = new ValidarCampo();
     ccc =new CtrCadastrarCliente();
//preenche cliente com ruas da tabela rota
     cbEnd=new JComboBox(ccc.selecionarRua());
     this.setResizable(false);
    this.setSize(new Dimension(515, 377));
    this.setTitle("Cadastrar Cliente");
    jPanel4.setLayout(null);
    jPanel4.setBounds(new Rectangle(5, 238, 501, 54));
    jPanel4.setBorder(BorderFactory.createEtchedBorder());
    TFcep.addKeyListener(new frCadastrarCliente_TFcep_keyAdapter(this));
    TFcep.setBounds(new Rectangle(415, 37, 70, 21));
    TFcep.setText("");
    cbEstado.addActionListener(new frCadastrarCliente_cbEstado_actionAdapter(this));
    cbEstado.addKeyListener(new frCadastrarCliente_cbEstado_keyAdapter(this));
    cbEstado.setBounds(new Rectangle(431, 66, 54, 21));
    this.getContentPane().setLayout(null);
    tfNomeFantasia.setBounds(new Rectangle(93, 36, 393, 21));
    tfNomeFantasia.addKeyListener(new frCadastrarCliente_tfNomeFantasia_keyAdapter(this));
    tfNomeFantasia.setAlignmentX((float) 0.5);
    tfNomeFantasia.setText("");
    tfCNPJ.setText("");
    tfCNPJ.setBounds(new Rectangle(93, 66, 142, 21));
    tfCNPJ.addKeyListener(new frCadastrarCliente_tfCNPJ_keyAdapter(this));
    lbTelefone.setText("Telefone:");
    lbTelefone.setBounds(new Rectangle(33, 26, 52, 15));
    tfTelefone.setText("");
    tfTelefone.setBounds(new Rectangle(88, 20, 111, 21));
    tfTelefone.addKeyListener(new frCadastrarCliente_tfTelefone_keyAdapter(this));
    lbNumero.setText("Número:");
    lbNumero.setBounds(new Rectangle(40, 39, 44, 15));
    lbRazaoSocial.setText("Razão Social:");
    lbRazaoSocial.setBounds(new Rectangle(20, 13, 72, 15));
    jPanel3.setBorder(BorderFactory.createEtchedBorder());
    jPanel3.setBounds(new Rectangle(5, 107, 501, 133));
    jPanel3.setLayout(null);
    lbEstado.setText("Estado:");
    lbEstado.setBounds(new Rectangle(384, 69, 44, 15));
    lbCep.setText("CEP:");
    lbCep.setBounds(new Rectangle(387, 41, 27, 15));
    btLimpar.setBounds(new Rectangle(214, 13, 73, 25));
    btLimpar.setText("Limpar");
    btLimpar.addActionListener(new frCadastrarCliente_btLimpar_actionAdapter(this));
    tfInscEstadual.setText("");
    tfInscEstadual.setBounds(new Rectangle(341, 66, 145, 21));
    tfInscEstadual.addKeyListener(new frCadastrarCliente_tfInscEstadual_keyAdapter(this));
    lbBairro.setText("Bairro:");
    lbBairro.setBounds(new Rectangle(153, 40, 34, 15));
    jlEndereco.setText("Endereço:");
    jlEndereco.setBounds(new Rectangle(35, 11, 58, 15));
    tfCidade.setText("");
    tfCidade.setBounds(new Rectangle(92, 68, 208, 21));
    tfCidade.addKeyListener(new frCadastrarCliente_tfCidade_keyAdapter(this));
    jPanel2.setBorder(BorderFactory.createEtchedBorder());
    jPanel2.setBounds(new Rectangle(4, 9, 502, 100));
    jPanel2.setLayout(null);
    jPanel5.setBorder(BorderFactory.createEtchedBorder());
    jPanel5.setBounds(new Rectangle(5, 291, 501, 53));
    jPanel5.setLayout(null);
    lbCNPJ.setText("C.N.P.J.:");
    lbCNPJ.setBounds(new Rectangle(43, 70, 50, 15));
    tfFax.setText("");
    tfFax.setBounds(new Rectangle(246, 20, 121, 21));
    tfFax.addKeyListener(new frCadastrarCliente_tfFax_keyAdapter(this));
    lbFax.setText("Fax:");
    lbFax.setBounds(new Rectangle(215, 26, 34, 15));
    btSair.setBounds(new Rectangle(297, 13, 73, 25));
    btSair.setText("Sair");
    btSair.addActionListener(new frCadastrarCliente_btSair_actionAdapter(this));
    tfEmail.setText("");
    tfEmail.setBounds(new Rectangle(92, 102, 274, 21));
    tfEmail.addKeyListener(new frCadastrarCliente_tfEmail_keyAdapter(this));
    lbCidade.setText("Cidade:");
    lbCidade.setBounds(new Rectangle(45, 71, 47, 15));
    jlNomeFantasia.setText("Nome Fantasia:");
    jlNomeFantasia.setBounds(new Rectangle(13, 38, 80, 15));
    btCadastrar.setBounds(new Rectangle(120, 13, 84, 25));
    btCadastrar.setText("Cadastrar");
    btCadastrar.addActionListener(new frCadastrarCliente_btCadastrar_actionAdapter(this));
    tfBairro.setText("");
    tfBairro.setBounds(new Rectangle(188, 38, 174, 21));
    tfBairro.addKeyListener(new frCadastrarCliente_tfBairro_keyAdapter(this));
    jlInscEstadual.setText("Insc. Estadual:");
    jlInscEstadual.setBounds(new Rectangle(258, 70, 75, 15));
    btOutroTel.setBounds(new Rectangle(399, 17, 84, 25));
    btOutroTel.setToolTipText("Clique aqui "+
                            "para cadastrar mais de um telefone");
    btOutroTel.setText("Outro Tel.");
    btOutroTel.addActionListener(new frCadastrarCliente_btOutroTel_actionAdapter(this));
    lbEmail.setText("E-mail:");
    lbEmail.setBounds(new Rectangle(42, 102, 34, 15));
    btOutroEndereco.setBounds(new Rectangle(398, 96, 87, 25));
    btOutroEndereco.setSelected(false);
    btOutroEndereco.setToolTipText("Clique aqui "+
                            "para cadastrar mais de um endereço");
    btOutroEndereco.setText("Outro End.");
    btOutroEndereco.addActionListener(new frCadastrarCliente_btOutroEndereco_actionAdapter(this));
    tfNumero.setText("");
    tfNumero.setBounds(new Rectangle(92, 37, 45, 21));
    tfNumero.addKeyListener(new frCadastrarCliente_tfNumero_keyAdapter(this));
    tfRazaoSocial.setText("");
    tfRazaoSocial.setBounds(new Rectangle(93, 10, 393, 21));
    tfRazaoSocial.addKeyListener(new frCadastrarCliente_tfRazaoSocial_keyAdapter(this));
    cbEnd.setEditable(true);
    cbEnd.setBounds(new Rectangle(92, 7, 393, 19));
    jPanel4.add(lbTelefone, null);
    jPanel4.add(tfTelefone, null);
    jPanel4.add(lbFax, null);
    jPanel4.add(tfFax, null);
    jPanel4.add(btOutroTel, null);
    this.getContentPane().add(jPanel3, null);
    jPanel3.add(btOutroEndereco, null);
    jPanel3.add(jlEndereco, null);
    jPanel3.add(lbNumero, null);
    jPanel3.add(tfNumero, null);
    jPanel3.add(lbBairro, null);
    jPanel3.add(tfBairro, null);
    jPanel3.add(lbCep, null);
    jPanel3.add(TFcep, null);
    jPanel3.add(cbEstado, null);
    jPanel3.add(lbEstado, null);
    jPanel3.add(tfCidade, null);
    jPanel3.add(lbCidade, null);
    jPanel3.add(lbEmail, null);
    jPanel3.add(tfEmail, null);
    jPanel3.add(cbEnd, null);
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(tfRazaoSocial, null);
    jPanel2.add(lbRazaoSocial, null);
    jPanel2.add(tfInscEstadual, null);
    jPanel2.add(tfNomeFantasia, null);
    jPanel2.add(lbCNPJ, null);
    jPanel2.add(jlNomeFantasia, null);
    jPanel2.add(tfCNPJ, null);
    jPanel2.add(jlInscEstadual, null);
    this.getContentPane().add(jPanel5, null);
    jPanel5.add(btLimpar, null);
    jPanel5.add(btCadastrar, null);
    jPanel5.add(btSair, null);
    this.getContentPane().add(jPanel4, null);
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


  public Vector preencherEstado()
   {
     Vector Est= new Vector();
     Est.addElement("");
     Est.addElement("RJ");
     Est.addElement("SP");
     Est.addElement("MG");
     Est.addElement("ES");
     Est.addElement("AC");
     Est.addElement("AL");
     Est.addElement("AP");
     Est.addElement("AM");
     Est.addElement("BA");
     Est.addElement("CE");
     Est.addElement("DF");
     Est.addElement("GO");
     Est.addElement("MA");
     Est.addElement("MT");
     Est.addElement("MS");
     Est.addElement("PA");
     Est.addElement("PB");
     Est.addElement("PR");
     Est.addElement("PE");
     Est.addElement("PI");
     Est.addElement("RN");
     Est.addElement("RS");
     Est.addElement("RO");
     Est.addElement("RR");
     Est.addElement("SC");
     Est.addElement("SE");
     Est.addElement("TO");
     return Est;
   }

   void cbEstado_actionPerformed(ActionEvent e)
   {
       estado = (String) cbEstado.getSelectedItem();
   }

   void btCadastrar_actionPerformed(ActionEvent e)
   {
     //validação de campos - classe ValidarCampo
     if (! vc.valNulo(tfRazaoSocial.getText(),"Razão Social") || !
	 vc.valNulo(tfInscEstadual.getText(),"Inscrição Estadual") || !
	 vc.valNulo(tfNomeFantasia.getText(),"Nome Fantasia") || !
	 vc.valNulo((String)cbEnd.getSelectedItem(),"Endereço") || !
	 vc.valNulo(tfBairro.getText(),"Bairro") || !
	 vc.valNulo(tfCidade.getText(),"Cidade") || !
	 vc.valNulo(tfTelefone.getText(),"Telefone") ) return;


      cnpj=tfCNPJ.getText();
      String razaoSocial=tfRazaoSocial.getText();
      String inscEstadual=tfInscEstadual.getText();
      String fantasia=tfNomeFantasia.getText();
      rua=(String)cbEnd.getSelectedItem();
      bairro=tfBairro.getText();
      cidade=tfCidade.getText();
      cep=TFcep.getText();
      numero=tfNumero.getText();
      Email=tfEmail.getText();
      telefone=tfTelefone.getText();
      fax=tfFax.getText();

      ends.addElement(rua);
      idEnds.addElement(ccc.novoEndereco(rua,bairro,cidade,estado,cep,numero,Email,cnpj));
      ccc.novoTelefone(telefone,fax,cnpj);
      ccc.cadastrar(cnpj,razaoSocial,inscEstadual,fantasia,ends,
		    idEnds,cidade);

      JOptionPane.showMessageDialog(
       null,
       "Cadastro Efetuado com Sucesso!","Cadastro de Clientes",
       JOptionPane.INFORMATION_MESSAGE);

       try
       {
         this.finalize();
         new frCadastrarCliente();
         this.setVisible(false);
       }
       catch (Throwable ex)
       {
         ex.printStackTrace();
       }
    }

    public void limpar()
     {
        tfCNPJ.setText("");
       tfRazaoSocial.setText("");
       tfInscEstadual.setText("");
       tfNomeFantasia.setText("");
       cbEnd.setSelectedItem("");
       tfBairro.setText("");
       tfCidade.setText("");
       TFcep.setText("");
       tfNumero.setText("");
       tfEmail.setText("");
       cbEstado.setSelectedItem("");
       tfTelefone.setText("");
       tfFax.setText("");
     }

     void btOutroEndereco_actionPerformed(ActionEvent e)
     {
	if (! vc.valNulo((String)cbEnd.getSelectedItem(),"Endereço") || !
	    vc.valNulo(tfBairro.getText(),"Bairro") || !
	    vc.valNulo(tfCidade.getText(),"Cidade")) return;

        cnpj=tfCNPJ.getText();
        rua=(String)cbEnd.getSelectedItem();
        bairro=tfBairro.getText();
        cidade=tfCidade.getText();
        cep=TFcep.getText();
        numero=tfNumero.getText();
        Email=tfEmail.getText();
        idEnds.addElement(ccc.novoEndereco(rua,bairro,cidade,estado,cep,numero,Email,cnpj));

        JOptionPane.showMessageDialog(
       null,
       "Endereço Cadastrado com Sucesso, Inclua Outro", "Cadastro de Endereço",
       JOptionPane.INFORMATION_MESSAGE);

      cbEnd.setSelectedItem("");
      tfBairro.setText("");
      tfCidade.setText("");
      TFcep.setText("");
      tfNumero.setText("");
      tfEmail.setText("");
      cbEstado.setSelectedItem("");
      ends.addElement(rua);
     }


  void btOutroTel_actionPerformed(ActionEvent e)
  {
     if (! vc.valNulo(tfTelefone.getText(),"Telefone")) return;

     telefone=tfTelefone.getText();
     fax=tfFax.getText();
     ccc.novoTelefone(telefone,fax,cnpj);
     JOptionPane.showMessageDialog(
          null,
          "Telefone Cadastrado com Sucesso, Inclua Outro", "Cadastro de Endereço",
          JOptionPane.INFORMATION_MESSAGE);
     tfTelefone.setText("");
     tfFax.setText("");

  }


  void btSair_actionPerformed(ActionEvent e)
  {
     if(ativa)
     {
        Object opt[] = {"Sim","Não"};
        int result = JOptionPane.showOptionDialog(this,
            "Deseja Cancelar esse Cadastro",
            "Cadastro de Endereço",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opt,
            opt[0]
            );
        if(result == JOptionPane.YES_OPTION)
        {
           try
           {
	      ccc.destrutor();
              this.finalize();
              this.setVisible(false);
           }
           catch (Throwable ex)
           {
              ex.printStackTrace();
           }
        }
     }
     else
     {
        this.setVisible(false);
        try
        {
           this.finalize();
        }
        catch (Throwable ex1)
        {
           ex1.printStackTrace();
        }
     }


  }

  void btLimpar_actionPerformed(ActionEvent e)
  {
     this.limpar();
  }

   //*Esse método serve pra informar se o usuário entrou com algum dado dado na tela*/
  void tfRazaoSocial_keyPressed(KeyEvent e)
  {
     ativa =true;
  }

  void tfNomeFantasia_keyPressed(KeyEvent e)
  {
     ativa = true;
  }

  void tfCNPJ_keyPressed(KeyEvent e)
  {
     ativa = true;
  }

  void tfInscEstadual_keyPressed(KeyEvent e)
  {
     ativa = true;
  }

  void tfEndereco_keyPressed(KeyEvent e)
  {
     ativa = true;
  }

  void tfNumero_keyPressed(KeyEvent e)
  {
     ativa = true;
  }

  void tfBairro_keyPressed(KeyEvent e)
  {
   ativa = true;
  }

  void TFcep_keyPressed(KeyEvent e)
  {
     ativa = true;
  }

  void tfCidade_keyPressed(KeyEvent e)
  {
     ativa = true;
  }

  void cbEstado_keyPressed(KeyEvent e)
  {
     ativa = true;
  }

  void tfEmail_keyPressed(KeyEvent e)
  {
     ativa = true;
  }

  void tfTelefone_keyPressed(KeyEvent e)
  {
     ativa = true;
  }

  void tfFax_keyPressed(KeyEvent e)
  {
     ativa = true;
  }

}

class frCadastrarCliente_btOutroEndereco_actionAdapter implements java.awt.event.ActionListener {
  frCadastrarCliente adaptee;

  frCadastrarCliente_btOutroEndereco_actionAdapter(frCadastrarCliente adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btOutroEndereco_actionPerformed(e);
  }
}

class frCadastrarCliente_btOutroTel_actionAdapter implements java.awt.event.ActionListener {
  frCadastrarCliente adaptee;

  frCadastrarCliente_btOutroTel_actionAdapter(frCadastrarCliente adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btOutroTel_actionPerformed(e);
  }
}

class frCadastrarCliente_btCadastrar_actionAdapter implements java.awt.event.ActionListener {
  frCadastrarCliente adaptee;

  frCadastrarCliente_btCadastrar_actionAdapter(frCadastrarCliente adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btCadastrar_actionPerformed(e);
  }
}

class frCadastrarCliente_btSair_actionAdapter implements java.awt.event.ActionListener {
  frCadastrarCliente adaptee;

  frCadastrarCliente_btSair_actionAdapter(frCadastrarCliente adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btSair_actionPerformed(e);
  }
}

class frCadastrarCliente_cbEstado_actionAdapter implements java.awt.event.ActionListener {
  frCadastrarCliente adaptee;

  frCadastrarCliente_cbEstado_actionAdapter(frCadastrarCliente adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cbEstado_actionPerformed(e);
  }
}

class frCadastrarCliente_btLimpar_actionAdapter implements java.awt.event.ActionListener {
  frCadastrarCliente adaptee;

  frCadastrarCliente_btLimpar_actionAdapter(frCadastrarCliente adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btLimpar_actionPerformed(e);
  }
}

class frCadastrarCliente_tfRazaoSocial_keyAdapter extends java.awt.event.KeyAdapter {
  frCadastrarCliente adaptee;

  frCadastrarCliente_tfRazaoSocial_keyAdapter(frCadastrarCliente adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.tfRazaoSocial_keyPressed(e);
  }
}

class frCadastrarCliente_tfNomeFantasia_keyAdapter extends java.awt.event.KeyAdapter {
  frCadastrarCliente adaptee;

  frCadastrarCliente_tfNomeFantasia_keyAdapter(frCadastrarCliente adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.tfNomeFantasia_keyPressed(e);
  }
}

class frCadastrarCliente_tfCNPJ_keyAdapter extends java.awt.event.KeyAdapter {
  frCadastrarCliente adaptee;

  frCadastrarCliente_tfCNPJ_keyAdapter(frCadastrarCliente adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.tfCNPJ_keyPressed(e);
  }
}

class frCadastrarCliente_tfInscEstadual_keyAdapter extends java.awt.event.KeyAdapter {
  frCadastrarCliente adaptee;

  frCadastrarCliente_tfInscEstadual_keyAdapter(frCadastrarCliente adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.tfInscEstadual_keyPressed(e);
  }
}

class frCadastrarCliente_tfNumero_keyAdapter extends java.awt.event.KeyAdapter {
  frCadastrarCliente adaptee;

  frCadastrarCliente_tfNumero_keyAdapter(frCadastrarCliente adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.tfNumero_keyPressed(e);
  }
}

class frCadastrarCliente_tfBairro_keyAdapter extends java.awt.event.KeyAdapter {
  frCadastrarCliente adaptee;

  frCadastrarCliente_tfBairro_keyAdapter(frCadastrarCliente adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.tfBairro_keyPressed(e);
  }
}

class frCadastrarCliente_TFcep_keyAdapter extends java.awt.event.KeyAdapter {
  frCadastrarCliente adaptee;

  frCadastrarCliente_TFcep_keyAdapter(frCadastrarCliente adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.TFcep_keyPressed(e);
  }
}

class frCadastrarCliente_tfCidade_keyAdapter extends java.awt.event.KeyAdapter {
  frCadastrarCliente adaptee;

  frCadastrarCliente_tfCidade_keyAdapter(frCadastrarCliente adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.tfCidade_keyPressed(e);
  }
}

class frCadastrarCliente_cbEstado_keyAdapter extends java.awt.event.KeyAdapter {
  frCadastrarCliente adaptee;

  frCadastrarCliente_cbEstado_keyAdapter(frCadastrarCliente adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.cbEstado_keyPressed(e);
  }
}

class frCadastrarCliente_tfEmail_keyAdapter extends java.awt.event.KeyAdapter {
  frCadastrarCliente adaptee;

  frCadastrarCliente_tfEmail_keyAdapter(frCadastrarCliente adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.tfEmail_keyPressed(e);
  }
}

class frCadastrarCliente_tfTelefone_keyAdapter extends java.awt.event.KeyAdapter {
  frCadastrarCliente adaptee;

  frCadastrarCliente_tfTelefone_keyAdapter(frCadastrarCliente adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.tfTelefone_keyPressed(e);
  }
}

class frCadastrarCliente_tfFax_keyAdapter extends java.awt.event.KeyAdapter {
  frCadastrarCliente adaptee;

  frCadastrarCliente_tfFax_keyAdapter(frCadastrarCliente adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.tfFax_keyPressed(e);
  }
}

