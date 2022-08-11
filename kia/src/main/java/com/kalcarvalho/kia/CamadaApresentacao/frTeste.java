package CamadaApresentacao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;
//import Controladoras.CtrCadastrarProduto;
import javax.swing.border.*;

public class frTeste extends JFrame
{
  // private CtrCadastrarProduto ccp;
   private boolean ativa;
  JFileChooser jFileChooser1 = new JFileChooser();


   public frTeste()
   {
      enableEvents(AWTEvent.WINDOW_EVENT_MASK);
      try
      {
	 ativa = false;
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
    this.getContentPane().setLayout(null);
    jFileChooser1.setEnabled(false);
    jFileChooser1.setDoubleBuffered(false);
    jFileChooser1.setOpaque(true);
    jFileChooser1.setApproveButtonMnemonic(0);
    jFileChooser1.setApproveButtonText("");
    jFileChooser1.setApproveButtonToolTipText("");
    jFileChooser1.setFileHidingEnabled(false);
    jFileChooser1.setBounds(new Rectangle(1, 40, 398, 175));
    this.setVisible(true);
    this.setSize(new Dimension(500, 350));
    this.getContentPane().add(jFileChooser1, null);
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

}
