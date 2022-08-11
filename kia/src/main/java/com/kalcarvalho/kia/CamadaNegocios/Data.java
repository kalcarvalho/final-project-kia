package CamadaNegocios;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class Data
{
   private GregorianCalendar gc;
  protected Date today;
  protected Date anotherdate;
  protected ValidarData vd;
  private String dataMysql;
  private String dataInterface;

  public Data()
  {
     gc = new GregorianCalendar();
     today = new Date();
     anotherdate = new Date();
     vd = new ValidarData();
     dataMysql="";
     dataInterface="";
  }

  public String getCurrentDate (String format)
  {
     String datenewformat = new String();
     SimpleDateFormat formatter = new SimpleDateFormat(format);
     datenewformat = formatter.format(today);

     return datenewformat;
  }

  public String getCorrenteHora()
  {
     String hora="00:00:00";
     String tmp=gc.getInstance().getTime().toString();
     System.out.println(tmp);
     try
     {
	hora = tmp.substring(11, 19);
     }
     catch (Exception ex)
     {
	JOptionPane.showMessageDialog(null,"Data ou Hora do Sistema Desregulados",
				      "Data e Hora",JOptionPane.WARNING_MESSAGE);
     }
     return hora;
  }

  public String parseDateInterface (String format,Date data)
    {
       String datenewformat = new String();
       SimpleDateFormat formatter = new SimpleDateFormat(format);
       datenewformat = formatter.format(data);
       return datenewformat;
    }

  public boolean parseMySQL(String dt)
  {
     int dia, mes, ano;
     String dd, mm, aa;

     try
     {
	dd = dt.substring(0, 2);
	mm = dt.substring(3, 5);
	aa = dt.substring(6);
     }
     catch (StringIndexOutOfBoundsException ex)
     {
	ex.printStackTrace();
	return false;
     }

     try
     {
	dia = Integer.parseInt(dd);
	mes = Integer.parseInt(mm);
	ano = Integer.parseInt(aa);
     }
     catch (NumberFormatException ex)
     {
	ex.printStackTrace();
	 return false;
     }

     if (vd.validar(dia, mes, ano))
     {
	dataMysql = ano + "/" + mes + "/" + dia;
	return true;
      }
      else return false;
  }

  public String parseInterface(String dt)
  {
     String dd="";
     String mm="";
     String aaaa="";
     try
     {
	dd = dt.substring(8,10);
	mm = dt.substring(5,7);
	aaaa = dt.substring(0,4);
     }
     catch (StringIndexOutOfBoundsException ex)
     {
	ex.printStackTrace();
	JOptionPane.showMessageDialog(null,"",
	"Erro ao convertar data do banco de dados para interface",
	JOptionPane.ERROR_MESSAGE);
     }
     return dd + "/" + mm + "/" + aaaa;
  }


  public String getDataMysql()
  {
     return dataMysql;
  }
}
