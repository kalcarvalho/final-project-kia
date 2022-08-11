package CamadaApresentacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import Controladoras.CtrLogin;
import Controladoras.CtrBackup;
import CamadaNegocios.Principal;

public class frLogin extends JDialog
{
   private CtrLogin cl;
   protected static frDistribuidora fd;
   private CtrBackup cb;
   JPanel jPanel1 = new JPanel();
   JLabel lbLogin = new JLabel();
   JLabel lbSenha = new JLabel();
   JTextField tfLogin = new JTextField();
   JButton btCancelar = new JButton();
   JButton btEntrar = new JButton();
   JPasswordField pfSenha = new JPasswordField();

   public frLogin()
   {
      try
      {
	 jbInit();
	 this.formatWindow();
      }
      catch (Exception e)
      {
	 e.printStackTrace();
      }
   }

   private void jbInit() throws Exception
   {
      this.setModal(true);
      cl = new CtrLogin();
      this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    this.setResizable(false);
      this.setSize(new Dimension(294, 216));
      this.setTitle("Logar no Sistema");
      jPanel1.setLayout(null);
      lbLogin.setText("Login:");
      lbLogin.setBounds(new Rectangle(82, 44, 34, 15));
      lbSenha.setText("Senha:");
      lbSenha.setBounds(new Rectangle(77, 85, 34, 15));
      tfLogin.setText("");
      tfLogin.setBounds(new Rectangle(122, 38, 89, 21));
      btCancelar.setBounds(new Rectangle(149, 124, 79, 25));
      btCancelar.setText("Cancelar");
      btCancelar.addActionListener(new frLogin_btCancelar_actionAdapter(this));
      btEntrar.setBounds(new Rectangle(61, 124, 73, 25));
      btEntrar.setText("Entrar");
    btEntrar.addActionListener(new frLogin_btEntrar_actionAdapter(this));
      pfSenha.setText("");
      pfSenha.setBounds(new Rectangle(122, 78, 89, 21));
      jPanel1.add(pfSenha, null);
      jPanel1.add(lbLogin, null);
      jPanel1.add(tfLogin, null);
      jPanel1.add(lbSenha, null);
      jPanel1.add(btEntrar, null);
      jPanel1.add(btCancelar, null);
      this.getContentPane().add(jPanel1, BorderLayout.CENTER);
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
      this.setLocation( (screenSize.width - frameSize.width) / 2,
		       (screenSize.height - frameSize.height) / 2);
      this.setVisible(true);
   }

   void btCancelar_actionPerformed(ActionEvent e)
   {
      CamadaNegocios.Principal.dist.sair();
   }

  void btEntrar_actionPerformed(ActionEvent e)
  {
     Vector opcao=new Vector();
     String login = tfLogin.getText();
     String auto="false";
     String semb="true";
     String status="false";//mostra se algum diretorio foi configurado
     String ok="Sem Backup";
     char[] senha=pfSenha.getPassword();
     String tipo=cl.logar(login,senha);
     if (tipo=="") JOptionPane.showMessageDialog
	    ( null,"Senha ou Login Inválido","Login!",
	  JOptionPane.ERROR_MESSAGE);
    else
    {
	cb=new CtrBackup();
	opcao=cb.getOpcaoBackup();
	try
	{
	   auto = (String)opcao.get(0);
	   semb=(String)opcao.get(1);
	   status=(String)opcao.get(2);
	}
	catch (ArrayIndexOutOfBoundsException ex1)
	{
	   JOptionPane.showMessageDialog(null,"Tabela OpcaoBackup Vazia",
					 "Erro ao buscar Dados na Tabela",
					 JOptionPane.ERROR_MESSAGE);
	}
	if(auto.equals("true"))
	   ok="Automatico";
	fd = new frDistribuidora(tipo,status);
	fd.setRadioBackup(ok);
	dispose();
	try
	{
	   this.finalize();
	}
	catch (Throwable ex)
	{
	}
    }
  }
}

class frLogin_btCancelar_actionAdapter implements java.awt.event.ActionListener {
  frLogin adaptee;

  frLogin_btCancelar_actionAdapter(frLogin adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btCancelar_actionPerformed(e);
  }
}

class frLogin_btEntrar_actionAdapter implements java.awt.event.ActionListener {
  frLogin adaptee;

  frLogin_btEntrar_actionAdapter(frLogin adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btEntrar_actionPerformed(e);
  }
}
