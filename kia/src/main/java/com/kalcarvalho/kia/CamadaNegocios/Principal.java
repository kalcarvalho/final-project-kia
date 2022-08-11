package CamadaNegocios;

import javax.swing.*;

public class Principal
{
   public static Distribuidora dist;

   public Principal()
   {
      dist = new Distribuidora();
   }

   //main
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
	   new Principal();
	 }

}