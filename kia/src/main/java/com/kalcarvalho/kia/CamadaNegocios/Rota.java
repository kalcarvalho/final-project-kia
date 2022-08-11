package CamadaNegocios;

import java.util.Vector;
import javax.swing.JOptionPane;

public class Rota extends CtrDados
{
   public Rota()
   {
   }

   public Vector getRua()
   {
      Vector campo=new Vector();
      Vector rua=new Vector();
      campo.addElement("rua");
      cmd.selecionar(campo,"Rota");
      rua=cmd.getArrayRegistros(cmd.executarSQL());
      if (rua == null)
      {
	 JOptionPane.showMessageDialog(null, "Não existem Endereços Cadastrados.");
      }
      return rua;
   }
   public Vector getRua(String cidade)
   {
      Vector campo=new Vector();
      Vector rua=new Vector();
      campo.addElement("rua");
      cmd.selecionar(campo,"Rota","cidade='"+cidade+"'");
      rua=cmd.getArrayRegistros(cmd.executarSQL());
      if (rua == null)
      {
	 JOptionPane.showMessageDialog(null, "Não existem Endereços Cadastrados.");
      }
      return rua;
   }

   public Vector getExtensao(String cidade)
   {
      Vector campo = new Vector();
      Vector rua = new Vector();
      campo.addElement("Extensao");
      cmd.selecionar(campo,"Rota","cidade='"+cidade+"'");
      rua = cmd.getArrayRegistros(cmd.executarSQL());

      if (rua == null)
      {
	 JOptionPane.showMessageDialog(null, "Não existem Endereços Cadastrados.");
      }
      return rua;
   }

   public int cadastrar(String cidade, String rua, int tam, String cidori, Vector ini, String cidest, Vector des, String tipo)
   {
      int id;
      Vector id_o = new Vector();
      Vector campo = new Vector();

      if (tipo == "D") {
	 campo.addElement("count(*)");
	 cmd.selecionar(campo, "Rota", "rua='" + rua + "'");
	 campo.removeAllElements();
	 if(cmd.getInt(cmd.executarSQL()) == 0)
	 {
	   campo.addElement("");
	   campo.addElement(String.valueOf(tam));
	   campo.addElement(rua);
	   campo.addElement(cidade);
	   campo.addElement(tipo);
	   cmd.inserir(campo, "Rota");
	 }
	 campo.removeAllElements();
	 campo.addElement("idRota");
	 cmd.selecionar(campo, "Rota", "rua='" + rua + "' AND cidade='"+ cidade + "'");
      }
      else {
	 campo.addElement("");
	 campo.addElement(String.valueOf(tam));
	 campo.addElement(rua);
	 campo.addElement(cidade);
	 campo.addElement(tipo);
	 cmd.inserir(campo, "Rota");

	 campo.removeAllElements();

	 campo.addElement("MAX(idRota)");
	 cmd.selecionar(campo, "Rota");
      }

      id = cmd.getInt(cmd.executarSQL());

      campo.removeAllElements();

      for(int i = 0; i < des.size(); i++)
      {
	String Rua = (String) des.get(i++);
	String Altura = (String) des.get(i++);
	String Extensao = (String) des.get(i++);
	String Typo = (String) des.get(i);
	int ido;


	 campo.addElement("count(*)");
	 cmd.selecionar(campo, "Rota", "rua='"+ Rua + "' AND cidade='" + cidest + "'");

        campo.removeAllElements();

         if(cmd.getInt(cmd.executarSQL()) == 0)
	 {

		campo.addElement("");
		campo.addElement(Extensao);
		campo.addElement(Rua);
		campo.addElement(cidest);
		campo.addElement(Typo);
		System.out.println(campo);
		cmd.inserir(campo, "Rota");
		campo.removeAllElements();

		Logger.registrar("idRota", "Rota", "Insercao");

		campo.addElement("MAX(idRota)");
		cmd.selecionar(campo, "Rota");
	}
	else
	{
	    campo.addElement("idRota");
	    cmd.selecionar(campo, "Rota",
			   "rua='" + Rua + "' AND cidade='" + cidest + "'");
	}

	 ido = cmd.getInt(cmd.executarSQL());
	 System.out.println(ido);

	 campo.removeAllElements();

	 campo.addElement("Count(*)");
	 cmd.selecionar(campo, "Endereco", "rua='" + Rua + "' AND cidade='" + cidest + "'");

	 if (cmd.getInt(cmd.executarSQL()) != 0)
	 {

		campo.removeAllElements();

		campo.addElement("idRota");
		id_o.addElement(String.valueOf(ido));

		cmd.atualizar("Endereco", campo, id_o, "rua='" + Rua + "'");
		id_o.removeAllElements();
		Logger.registrar("idRota", "Endereco", "Atualizacao");

	 }

	 campo.removeAllElements();

	 campo.addElement("");
	 campo.addElement(String.valueOf(id));
	 campo.addElement(String.valueOf(ido));
	 campo.addElement(Altura);
	 campo.addElement(String.valueOf(-1));

	 cmd.inserir(campo, "GradeRota");

	 Logger.registrar("MAX(idGrade)","GradeRota", "Insercao");

	 campo.removeAllElements();
      }


      for (int i = 0; i<ini.size(); i++)
      {
	String Rua = (String) ini.get(i++);
	if(Rua.indexOf("[") != -1) Rua = Rua.substring(0, Rua.indexOf("["));
	String Altura = (String) ini.get(i++);
	String Extensao = (String) ini.get(i++);
	String Typo = (String) ini.get(i);
	int idi;

	 campo.addElement("idRota");

	 cmd.selecionar(campo, "Rota", "rua='" + Rua + "', cidade='"+cidori+"'" );
	 idi = cmd.getInt(cmd.executarSQL());

	 campo.removeAllElements();


	 campo.addElement("");
	 campo.addElement(String.valueOf(idi));
	 campo.addElement(String.valueOf(id));
	 campo.addElement(String.valueOf(-1));
	 campo.addElement(Altura);

	 cmd.inserir(campo, "GradeRota");


	 Logger.registrar("MAX(idGrade)","GradeRota","Inserção");
	 campo.removeAllElements();
      }
      return id;
   }

   public int getIdRota (String rua, String cidade)
   {
      Vector campo=new Vector();
      int id;
      campo.addElement("idRota");
      cmd.selecionar(campo,"Rota","rua='"+rua+"' AND cidade='"+cidade+"'");
      id=cmd.getInt(cmd.executarSQL());
      return id;
   }

   /**
    * método para seleciona os enderecos que vão entrar no roteamento.
    * @param VidEnd Vector idEndereco
    * @param rua Vector rua
    * @return Vector com os IdEnderecos que vão entrar no roteamento com seu
    * respectivo idRota.
    */
   public Vector selecionarRota(Vector VidEnd,Vector rua)
   {
      Vector tmp=new Vector();
      Vector tmp2=new Vector();
      Vector rota=new Vector();
      Vector foraRota=new Vector();
      tmp.addElement("idEndereco");
      tmp.addElement("idRota");
      for (int i=0;i<VidEnd.size();i++)
      {
	 cmd.selecionar(tmp,"Endereco","idEndereco='"+VidEnd.get(i)+
			"' AND idRota IS NOT NULL");
	    tmp2=cmd.getFromRegistros(cmd.executarSQL(),2);
	    if(! tmp2.isEmpty())
	       rota.addElement(tmp2);
	       else
		  foraRota.addElement(rua.get(i));
      }
      if (! foraRota.isEmpty())
	 JOptionPane.showMessageDialog(null,"Não estão entrando na rota os seguintes "+
			      "endereços por não haver rota cadastrada: "+
			      foraRota,"Rota não cadastrada",
			      JOptionPane.WARNING_MESSAGE);
      return rota;
   }

   /**
    * método para gerar a melhor rota de entrega de mercadorias: usar a tabela
    * Rota (idRota,tamanho,rua,ciade) e rotaExtend(idE,inicia,idRota), onde
    * inicia em rotaExtend equivale a rua anterior, ou seja, a rua que é feito
    * a ligação,,, é usado uma tabela extra para issso porque uma rua pode se iniciar
    * num cruzamento, por exemplo, ou seja, ela pode se iniciada em mais de 1 rua.
    * o vector correspondente a posição 1 do newVector corresponde ao idRota, ou seja,
    * contem os valores de busca, ´sáo onde vão ser feitas as entregas,,,
    * a posição 0, representa o ideEndereço desta entrega, ou seja, a a partir deste
    * id voce poderá localizar o numero da rua e o nome do Cliente
    * @param newRota Vector com 2 Vectores, posicao 0 Vector com idEnd, posicao 1
    * vector com idRota
    */
   public void gerarRota(Vector newRota)
   {
      //IDEIA
      //depois que gerar a rota, falta ainda criar uma interface para exibição,,
      //em uma nova tela,, tipo:
      //rua **********, depois
      //rua ********, depois
      //rua ********, entrega em
      //empresa ***** numero ***, depois
      //rua ***, depois
      //rua *****, entrega em
      //empresa ++++++= nuemro ***, depois
      //LEMBRAR que após gerar rota, setar statusrota para 1

      Vector route = new Vector();
      Vector campo = new Vector();
      int p;
      
      Grafo g = new Grafo();

      g.critParada(newRota);
      g.criaPercurso();	


   }

   public void destrutor() throws Throwable
     {
	this.finalize();
     }
}
