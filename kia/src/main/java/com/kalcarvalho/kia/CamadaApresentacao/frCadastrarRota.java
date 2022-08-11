package CamadaApresentacao;

import Controladoras.*;

import java.util.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


/**
 *
 * <p>Title: Cadastrar Rota</p>
 * <p>Description: Esta classe é uma interface com usuário para cadastrar uma rota.
 *  O usuario seleciona o nome da rua no combobox. Este combox é preenchido
 * com todos os enderecos da tabela rua da cidade anteriormente selecionada.
 *  Se a rua nao existir, entra com o nome da rua manualmente.
 * Após entrar com o tamanho da rua, o usuario seleciona no segundo combox com o nome
 * "tem inicio no fim da rua:" e escolhe o nome da rua que vem anteriormente a rua
 * que ele está cadastrando.
 * NOTA: este combobox nao é editável. ele é preenchido através de ruas cadastradas
 * na tabela rota,
 * entao, caso nao exista uma rua que faça ligaçao com esta rua, a rua nao poderá ser
 * cadastrada.
 * NOTA2: Explicando, o sistema cadastra sua rota a partir de seu ponto zero, ou seja,
 * pra vc cadastrar uma rua no centro da cidade, terá que ter cadastrado as ruas
 * que a levam até lá.
 * NOTA3: Esta maneira é mais segura e transparente de se trabalhar com rotas.
 *  Caso haja mais de uma rua que faça ligaçao com esta rua, clique no botao mais e
 * cadastre outra rua.
 * Há uma tabela rota e outra rotaExtend que serao usada para o algoritmo.
 * NOTA4. quando vc cadastra uma rota que já exista cliente nesta rua, o sistema
 * configura-o. O mesmo acontece quando vc está cadastrando endereco de cliente
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: AIK</p>
 * @author Alan, Ilson e Kal-el
 * @version 1.0
 */
public class frCadastrarRota extends JDialog
{
   private Vector ini = new Vector();
   private Vector des = new Vector();
   private frCadastrarInicioRua fcir;
   private ValidarCampo vc;
   private boolean ativa;
   private boolean dupla;
   private CtrCadastrarRota ccr;
   private frCadastrarRota fcr;
   private String TIPO_RUA;
  GridLayout gridLayout1 = new GridLayout();
  JPanel jPanel1 = new JPanel();
  JLabel lbCidade = new JLabel();
  JComboBox cbCidade;
  JLabel lbRua = new JLabel();
  JComboBox cbRua = new JComboBox();
  JLabel lbExtensao = new JLabel();
  JTextField tfExtensao = new JTextField();
  JButton btCadastrar = new JButton();
  JButton btSair = new JButton();
  Border border1;
  JButton btMaoDupla = new JButton();
  JPanel jPanel2 = new JPanel();
  JLabel lbCidade1 = new JLabel();
  JTextField tfAlturaOrigem = new JTextField();
  JLabel lbRua1 = new JLabel();
  JComboBox cbLogrOrigem = new JComboBox();
  JComboBox cbCidadeOrigem;
  JLabel lbDimensao1 = new JLabel();
  JButton btMaisOrigem = new JButton();
  JLabel lbInicio = new JLabel();
  JLabel lbCidade2 = new JLabel();
  JLabel lbInicio1 = new JLabel();
  JPanel jPanel3 = new JPanel();
  JTextField tfAlturaDestino = new JTextField();
  JLabel lbRua2 = new JLabel();
  JComboBox cbLogrDestino = new JComboBox();
  JComboBox cbCidadeDestino;
  JLabel lbDimensao2 = new JLabel();
  JButton btMaisDestino = new JButton();
   JLabel lbDimensao3 = new JLabel();
   JTextField tfExtensaoDestino = new JTextField();
  JTextField tfExtensaoOrigem = new JTextField();
  JLabel lbDimensao4 = new JLabel();
  JCheckBox chkDupla = new JCheckBox();

   public frCadastrarRota()
   {
    try {
      jbInit();
      TIPO_RUA = "U";
      dupla = false;
      this.formatWindow();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
   }
   public frCadastrarRota(String rua, String extensao, String origem, String destino, String alt_o, String alt_d, String cid_rua, String cid_o, String cid_d, Vector i, Vector d)
   {
      try {
	 TIPO_RUA = "D";
	 dupla = true;
	 jbInit();
      this.setModal(true);
      this.setTitle("Cadastro de Mao Dupla - Rua: " + rua);
      this.btMaoDupla.setEnabled(false);
      this.tfExtensao.setText(extensao);
      this.cbCidade.setSelectedItem(cid_rua);
      this.cbCidadeOrigem.setSelectedItem(cid_d);
      this.cbCidadeDestino.setSelectedItem(cid_o);
      this.cbLogrOrigem.setSelectedItem(destino);
      this.cbLogrDestino.setSelectedItem(origem);
      this.tfAlturaOrigem.setText(alt_d);
      this.tfAlturaDestino.setText(alt_o);
      this.formatWindow();
      ini = i; des = d;
    }
    catch(Exception e) {
      e.printStackTrace();
    }
   }
  private void jbInit() throws Exception
  {
   ccr = new CtrCadastrarRota();
   vc=new ValidarCampo();
   Vector cid = ccr.getCidades();

   if(cid == null) cbCidade = new JComboBox();
   else cbCidade=new JComboBox(ccr.getCidades());

   border1 = BorderFactory.createLineBorder(Color.lightGray,4);
    cbCidadeOrigem = new JComboBox(ccr.getCidades());
    cbCidadeDestino = new JComboBox(ccr.getCidades());
    lbExtensao.setText("Extensao:");
    lbExtensao.setBounds(new Rectangle(23, 72, 61, 15));
    tfExtensao.setToolTipText("Em metros");
    tfExtensao.setText("");
    tfExtensao.setBounds(new Rectangle(98, 70, 62, 20));
    tfExtensao.addKeyListener(new frCadastrarRota_tfExtensao_keyAdapter(this));
    cbRua.setEditable(true);
    cbRua.addMouseListener(new frCadastrarRota_cbRua_mouseAdapter(this));
    btCadastrar.setBounds(new Rectangle(80, 372, 98, 23));
    btCadastrar.setText("Cadastrar");
    btCadastrar.addActionListener(new frCadastrarRota_btCadastrar_actionAdapter(this));
    btSair.setBounds(new Rectangle(187, 372, 98, 23));
    btSair.setText("Sair");
    btSair.addActionListener(new frCadastrarRota_btSair_actionAdapter(this));
    cbCidade.addActionListener(new frCadastrarRota_cbCidade_actionAdapter(this));
    btMaoDupla.setBounds(new Rectangle(170, 71, 98, 23));
    btMaoDupla.setMnemonic('D');
    btMaoDupla.setText("Mao Dupla");
    btMaoDupla.addActionListener(new frCadastrarRota_btMaoDupla_actionAdapter(this));
    jPanel2.setBorder(BorderFactory.createEtchedBorder());
    jPanel2.setBounds(new Rectangle(15, 109, 360, 124));
    jPanel2.setLayout(null);
    lbCidade1.setBounds(new Rectangle(27, 38, 47, 15));
    lbCidade1.setHorizontalAlignment(SwingConstants.RIGHT);
    lbCidade1.setText("Cidade:");
    tfAlturaOrigem.setBounds(new Rectangle(86, 86, 62, 20));
    tfAlturaOrigem.setText("");
    tfAlturaOrigem.setToolTipText("Em metros");
    lbRua1.setBounds(new Rectangle(7, 63, 67, 15));
    lbRua1.setHorizontalAlignment(SwingConstants.RIGHT);
    lbRua1.setText("Logradouro:");
      cbLogrOrigem.setEnabled(true);
    cbLogrOrigem.setEditable(false);
    cbLogrOrigem.setBounds(new Rectangle(86, 61, 179, 19));
    cbLogrOrigem.addActionListener(new frCadastrarRota_cbLogrOrigem_actionAdapter(this));
    cbCidadeOrigem.setBounds(new Rectangle(86, 36, 149, 19));
    cbCidadeOrigem.addActionListener(new frCadastrarRota_cbCidadeOrigem_actionAdapter(this));
    lbDimensao1.setBounds(new Rectangle(25, 88, 49, 15));
    lbDimensao1.setHorizontalAlignment(SwingConstants.RIGHT);
    lbDimensao1.setText("Altura:");
    btMaisOrigem.setBounds(new Rectangle(272, 59, 71, 23));
    btMaisOrigem.setToolTipText("Clique aqui se ela iniciar em mais de uma rua");
    btMaisOrigem.setText("Mais...");
    btMaisOrigem.addActionListener(new frCadastrarRota_btMaisOrigem_actionAdapter(this));
    btMaisOrigem.addActionListener(new frCadastrarRota_btMaisOrigem_actionAdapter(this));
    lbInicio.setFont(new java.awt.Font("Dialog", 1, 11));
    lbInicio.setText("Rua Origem:");
    lbInicio.setBounds(new Rectangle(10, 10, 82, 15));
    lbCidade2.setText("Cidade:");
    lbCidade2.setHorizontalAlignment(SwingConstants.RIGHT);
    lbCidade2.setBounds(new Rectangle(27, 38, 47, 15));
    lbInicio1.setBounds(new Rectangle(10, 10, 82, 15));
    lbInicio1.setText("Rua Destino:");
    lbInicio1.setFont(new java.awt.Font("Dialog", 1, 11));
    jPanel3.setLayout(null);
    jPanel3.setBounds(new Rectangle(15, 238, 360, 124));
    jPanel3.setBorder(BorderFactory.createEtchedBorder());
    tfAlturaDestino.setBounds(new Rectangle(86, 86, 62, 20));
    tfAlturaDestino.setText("");
    tfAlturaDestino.setToolTipText("Em metros");
    lbRua2.setBounds(new Rectangle(7, 63, 67, 15));
    lbRua2.setHorizontalAlignment(SwingConstants.RIGHT);
    lbRua2.setText("Logradouro:");
    cbLogrDestino.setEditable(true);
    cbLogrDestino.setBounds(new Rectangle(86, 61, 179, 19));
    cbCidadeDestino.setBounds(new Rectangle(86, 36, 149, 19));
    cbCidadeDestino.addActionListener(new frCadastrarRota_cbCidadeDestino_actionAdapter(this));
    lbDimensao2.setBounds(new Rectangle(25, 88, 49, 15));
    lbDimensao2.setHorizontalAlignment(SwingConstants.RIGHT);
    lbDimensao2.setText("Altura:");
    btMaisDestino.setBounds(new Rectangle(272, 59, 72, 23));
    btMaisDestino.setToolTipText("Clique aqui se ela iniciar em mais de uma rua");
    btMaisDestino.setText("Mais...");
    btMaisDestino.addActionListener(new frCadastrarRota_btMaisDestino_actionAdapter(this));
    lbDimensao3.setText("Extensao:");
      lbDimensao3.setHorizontalAlignment(SwingConstants.RIGHT);
      lbDimensao3.setBounds(new Rectangle(211, 89, 67, 15));
      tfExtensaoDestino.setToolTipText("Em metros");
      tfExtensaoDestino.setText("");
      tfExtensaoDestino.setBounds(new Rectangle(281, 88, 62, 20));
      tfExtensaoOrigem.setBounds(new Rectangle(281, 88, 62, 20));
    tfExtensaoOrigem.setText("");
    tfExtensaoOrigem.setToolTipText("Em metros");
    tfExtensaoOrigem.setEditable(false);
    lbDimensao4.setBounds(new Rectangle(189, 90, 85, 15));
    lbDimensao4.setHorizontalAlignment(SwingConstants.RIGHT);
    lbDimensao4.setText("Extensao:");
    chkDupla.setText("Mao Dupla");
    chkDupla.setBounds(new Rectangle(251, 36, 95, 25));
    jPanel2.add(cbLogrOrigem, null);
    jPanel2.add(lbCidade1, null);
    jPanel2.add(cbCidadeOrigem, null);
    jPanel2.add(lbRua1, null);
    jPanel2.add(btMaisOrigem, null);
    jPanel2.add(lbDimensao1, null);
    jPanel2.add(tfAlturaOrigem, null);
    jPanel2.add(lbInicio, null);
      jPanel2.add(tfExtensaoOrigem, null);
      jPanel2.add(lbDimensao4, null);
    jPanel1.add(jPanel3, null);
    jPanel3.add(cbLogrDestino, null);
    jPanel3.add(lbCidade2, null);
    jPanel3.add(cbCidadeDestino, null);
    jPanel3.add(lbRua2, null);
    jPanel3.add(btMaisDestino, null);
    jPanel3.add(lbDimensao2, null);
    jPanel3.add(tfAlturaDestino, null);
    jPanel3.add(lbInicio1, null);
      jPanel3.add(tfExtensaoDestino, null);
      jPanel3.add(lbDimensao3, null);
    jPanel3.add(chkDupla, null);
    jPanel1.add(btSair, null);
    jPanel1.add(btCadastrar, null);
    jPanel1.add(cbCidade, null);
    jPanel1.add(lbCidade, null);
    jPanel1.add(lbRua, null);
    jPanel1.add(cbRua, null);
    jPanel1.add(lbExtensao, null);
    jPanel1.add(tfExtensao, null);
    jPanel1.add(btMaoDupla, null);
    jPanel1.add(jPanel2, null);
    this.getContentPane().add(jPanel1, null);
    this.setTitle("Cadastrar Rota");
    this.getContentPane().setLayout(gridLayout1);
    this.setResizable(false);
    this.setSize(new Dimension(390, 435));
    jPanel1.setLayout(null);
    lbCidade.setText("Cidade:");
    lbCidade.setBounds(new Rectangle(38, 18, 47, 15));
    cbCidade.setBounds(new Rectangle(99, 16, 149, 19));
    lbRua.setText("Logradouro:");
    lbRua.setBounds(new Rectangle(18, 45, 67, 15));
    cbRua.setBounds(new Rectangle(99, 45, 251, 19));
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

  public boolean sucessoCadastro()
  {
     this.setTipoRua(dupla);
     return dupla;
  }

  private void setTipoRua(boolean b)
  {
     if(b) TIPO_RUA = "D";
     else TIPO_RUA = "U";
  }


  public void destruir()
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

  void btSair_actionPerformed(ActionEvent e)
  {
     if(ativa)
     {
	Object opt[] = {"Sim","Nao"};
	int result = JOptionPane.showOptionDialog(this,
	    "Deseja Cancelar esse Cadastro",
	    "Cadastro de Rota",
	    JOptionPane.YES_NO_OPTION,
	    JOptionPane.QUESTION_MESSAGE,
	    null,
	    opt,
	    opt[0]
	    );
	if(result == JOptionPane.YES_OPTION)
	{
	   if(dupla)
	   {
	      dupla = false;
	      this.setVisible(false);
	   }
	   else this.destruir();
	}
     }
     else
     {
	this.setVisible(false);
	try
	{
	   ccr.destrutor();
	   this.finalize();
	}
	catch (Throwable ex1)
	{
	   ex1.printStackTrace();
	}
     }
  }

  void tfExtensao_keyPressed(KeyEvent e)
  {
     ativa=true;
  }

  void cbRua_mouseClicked(MouseEvent e)
  {
     ativa=true;
  }

  void cbLogrOrigem_mouseClicked(MouseEvent e)
  {
     ativa=true;
  }

  /**
   * busca as ruas na tabela endereco e rota de acordo com a cidade selecionada
   * usa o método selecionarEnd da classe controladora para isso
   * @param e ActionEvent
   */
  void cbCidade_actionPerformed(ActionEvent e)
  {
     Vector ri=new Vector();
     Vector rua=new Vector();
     Vector inicio=new Vector();
     cbRua.removeAllItems();
     cbLogrOrigem.removeAllItems();
     cbCidadeOrigem.setSelectedItem(cbCidade.getSelectedItem());
     ri=ccr.selecionarEnd((String)cbCidade.getSelectedItem());

   try
   {
      rua = (Vector) ri.get(0);
   }
   catch (Exception ex)
   {
      JOptionPane.showMessageDialog(null,"Nao Existem Endereços Cadastrados",
				    "Cadastro de Rota",JOptionPane.INFORMATION_MESSAGE);
      return;//REVER TODOS OS MESSAGENS DEPOIS
   }
   try
   {
      inicio = (Vector) ri.get(1);
   }
   catch (Exception ex1)
   {
   }

     for (int i=0;i<rua.size();i++) cbRua.addItem(rua.get(i));
     //for (int j=0;j<inicio.size();j++) cbLogrOrigem.addItem(inicio.get(j));
  }

  /**
   * insere na tabela rota e rotaExtend uma rota
   * usa o método cadastrar rota da controladora
   * @param e ActionEvent
   */
  void btCadastrar_actionPerformed(ActionEvent e)
  {
     if(! vc.valInt(tfExtensao.getText(),"Dimensao")) return;
     if(! vc.valNulo((String)cbRua.getSelectedItem(),"Rua")) return;
     if(! vc.valInt(tfAlturaOrigem.getText(), "Altura Origem")) return;
     if(! vc.valInt(tfAlturaDestino.getText(), "Altura Destino")) return;


     ini.addElement((String) cbLogrOrigem.getSelectedItem());
     ini.addElement(tfAlturaOrigem.getText());
     ini.addElement(tfExtensaoOrigem.getText());
     ini.addElement("");

     des.addElement((String) cbLogrDestino.getSelectedItem());
     des.addElement(tfAlturaDestino.getText());
     des.addElement(tfExtensaoDestino.getText());

     if (chkDupla.isSelected()) des.addElement("D");
     else des.addElement("U");

     ccr.cadastrarRota(
	  (String)cbCidade.getSelectedItem(),
	  (String)cbRua.getSelectedItem(),
	  Integer.parseInt(tfExtensao.getText()),
	  (String) cbCidadeOrigem.getSelectedItem(),
	  ini,
	  (String) cbCidadeDestino.getSelectedItem(),
	  des, TIPO_RUA
      );
     JOptionPane.showMessageDialog(null,"Cadastro Efetuado com Sucesso",
				   "Cadastro de Rota",JOptionPane.INFORMATION_MESSAGE);
     try
       {
	 this.finalize();
	 new frCadastrarRota();
	  this.setVisible(false);
       }
       catch (Throwable ex)
       {
	 ex.printStackTrace();
       }
  }

  void btMaisOrigem_actionPerformed(ActionEvent e)
  {
     fcir = new frCadastrarInicioRua((String)cbCidade.getSelectedItem(), 0);
     if (fcir.getInicio().isEmpty()) return;
     if (ini.isEmpty()) ini=fcir.getInicio();
     else {
	Vector ini2 = fcir.getInicio();
	ini.lastElement();
	for(int i = 0; i < ini2.size(); i++) {
	   ini.addElement(ini2.get(0));
	}

     }
  }

  void cbCidadeOrigem_actionPerformed(ActionEvent e) {
     Vector ri=new Vector();
     Vector inicio=new Vector();
     Vector ext = new Vector();
     cbLogrOrigem.removeAllItems();
     ri = ccr.selecionarEnd((String)cbCidadeOrigem.getSelectedItem());

     try
     {
	inicio = (Vector) ri.get(1);
	ext = (Vector) ri.get(2);
     }
     catch (Exception ex1)
     {
	return;
     }

     for (int j = 0; j < inicio.size(); j++) cbLogrOrigem.addItem(inicio.get(j) + "[" + ext.get(j) + "]");

   }

  void btMaoDupla_actionPerformed(ActionEvent e) {
     if ((String) cbRua.getSelectedItem() == "") return;
     if (tfExtensao.getText() == "") return;
     if ((String) cbLogrOrigem.getSelectedItem() == "") return;
     if ((String) cbLogrDestino.getSelectedItem() == "") return; // Nome do Destino
     if (tfAlturaOrigem.getText() == "") return;  // Altura da Origem
     if (tfAlturaDestino.getText() == "") return;  // Altura do Destino
     String ori = (String) cbLogrOrigem.getSelectedItem();
     ori = ori.substring(0, ori.indexOf("["));

     fcr = new frCadastrarRota(
       (String) cbRua.getSelectedItem(),
       tfExtensao.getText(),
       ori, // Nome da Origem
       (String) cbLogrDestino.getSelectedItem(), // Nome do Destino
       tfAlturaOrigem.getText(), // Altura da Origem
       tfAlturaDestino.getText(),  // Altura do Destino
       (String) cbCidade.getSelectedItem(),
       (String) cbCidadeOrigem.getSelectedItem(),
       (String) cbCidadeDestino.getSelectedItem(),
       ini,
       des
       );
     dupla = fcr.sucessoCadastro();
     TIPO_RUA = fcr.getTipoRua();
     fcr.destruir();
}

  public String getTipoRua()
  {
     return TIPO_RUA;
  }

  void cbCidadeDestino_actionPerformed(ActionEvent e) {
     Vector ri = new Vector();
     Vector inicio = new Vector();
     cbLogrDestino.removeAllItems();
     ri = ccr.selecionarEnd((String)cbCidadeDestino.getSelectedItem());

     try
     {
	inicio = (Vector) ri.get(0);
     }
     catch (Exception ex1)
     {
	return;
     }

     for (int j=0; j < inicio.size(); j++) cbLogrDestino.addItem(inicio.get(j));

  }

  void btMaisDestino_actionPerformed(ActionEvent e) {
     fcir = new frCadastrarInicioRua((String)cbCidade.getSelectedItem(), 1);
     if (fcir.getInicio().isEmpty()) return;
     if (des.isEmpty()) des = fcir.getInicio();
     else {
	Vector tmp = fcir.getInicio();
	des.lastElement();
	for(int i = 0; i < tmp.size(); i++) {
	   des.addElement(tmp.get(0));
	}
     }
  }

  void cbLogrOrigem_actionPerformed(ActionEvent e) {
   String ori = (String) cbLogrOrigem.getSelectedItem();
   if (ori == null) return;
   String arr = ori.substring(ori.indexOf("[") + 1, ori.indexOf("]"));
   tfExtensaoOrigem.setText(arr);
  }
}

class frCadastrarRota_btSair_actionAdapter implements java.awt.event.ActionListener {
  frCadastrarRota adaptee;

  frCadastrarRota_btSair_actionAdapter(frCadastrarRota adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btSair_actionPerformed(e);
  }
}

class frCadastrarRota_tfExtensao_keyAdapter extends java.awt.event.KeyAdapter {
  frCadastrarRota adaptee;

  frCadastrarRota_tfExtensao_keyAdapter(frCadastrarRota adaptee) {
    this.adaptee = adaptee;
  }
  public void keyPressed(KeyEvent e) {
    adaptee.tfExtensao_keyPressed(e);
  }
}

class frCadastrarRota_cbRua_mouseAdapter extends java.awt.event.MouseAdapter {
  frCadastrarRota adaptee;

  frCadastrarRota_cbRua_mouseAdapter(frCadastrarRota adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.cbRua_mouseClicked(e);
  }
}

class frCadastrarRota_cbCidade_actionAdapter implements java.awt.event.ActionListener {
  frCadastrarRota adaptee;

  frCadastrarRota_cbCidade_actionAdapter(frCadastrarRota adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cbCidade_actionPerformed(e);
  }
}

class frCadastrarRota_btCadastrar_actionAdapter implements java.awt.event.ActionListener {
  frCadastrarRota adaptee;

  frCadastrarRota_btCadastrar_actionAdapter(frCadastrarRota adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btCadastrar_actionPerformed(e);
  }
}

class frCadastrarRota_btMaoDupla_actionAdapter implements java.awt.event.ActionListener {
  frCadastrarRota adaptee;

  frCadastrarRota_btMaoDupla_actionAdapter(frCadastrarRota adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btMaoDupla_actionPerformed(e);
  }
}

class frCadastrarRota_btMaisOrigem_actionAdapter implements java.awt.event.ActionListener {
  frCadastrarRota adaptee;

  frCadastrarRota_btMaisOrigem_actionAdapter(frCadastrarRota adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btMaisOrigem_actionPerformed(e);
  }
}

class frCadastrarRota_cbCidadeOrigem_actionAdapter implements java.awt.event.ActionListener {
  frCadastrarRota adaptee;

  frCadastrarRota_cbCidadeOrigem_actionAdapter(frCadastrarRota adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cbCidadeOrigem_actionPerformed(e);
  }
}

class frCadastrarRota_cbCidadeDestino_actionAdapter implements java.awt.event.ActionListener {
  frCadastrarRota adaptee;

  frCadastrarRota_cbCidadeDestino_actionAdapter(frCadastrarRota adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cbCidadeDestino_actionPerformed(e);
  }
}

class frCadastrarRota_btMaisDestino_actionAdapter implements java.awt.event.ActionListener {
  frCadastrarRota adaptee;

  frCadastrarRota_btMaisDestino_actionAdapter(frCadastrarRota adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btMaisDestino_actionPerformed(e);
  }
}

class frCadastrarRota_cbLogrOrigem_actionAdapter implements java.awt.event.ActionListener {
  frCadastrarRota adaptee;

  frCadastrarRota_cbLogrOrigem_actionAdapter(frCadastrarRota adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cbLogrOrigem_actionPerformed(e);
  }
}

