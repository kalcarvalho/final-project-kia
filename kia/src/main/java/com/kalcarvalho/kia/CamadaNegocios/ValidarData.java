package CamadaNegocios;

public class ValidarData
{
   private int day;    // 1-31
   private int month;  // 1-12
   private int year;

   public ValidarData()
   {
   }

   public boolean validar(int d, int m, int a)
   {
      if (m > 0 && m <= 12)       // validate mes
	 month = m;
      else
      {
	 return false;
      }

      if (a>1900) year = a; //analisar este if quando for reutilizar esssa classe
      else return false;

      if (checkDay(d)) return true;
      else return false;
   }

   private boolean  checkDay(int testDay)
   {
      int daysPerMonth[] = { 0, 31, 28, 31, 30,
			     31, 30, 31, 31, 30,
			     31, 30, 31 };

      if (testDay > 0 && testDay <= daysPerMonth[ month ])
	 return true;

      if ( month == 2 &&   // Fevereiro: ano bissexto
	   testDay == 29 &&
	   ( year % 400 == 0 ||
	     ( year % 4 == 0 && year % 100 != 0 ) ) )
	 return true;

      return false;
   }

   public String toString()
   {
      return year + "/" + month + "/" + day;
   }
}