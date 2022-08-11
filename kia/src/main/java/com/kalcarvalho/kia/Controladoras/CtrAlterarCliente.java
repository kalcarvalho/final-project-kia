package Controladoras;

import CamadaNegocios.Cliente;
import CamadaNegocios.Rota;
import java.util.Vector;

public class CtrAlterarCliente
{
  private Cliente cl;
  private Rota ro;

  public CtrAlterarCliente()
  {
     cl=new Cliente();
     ro=new Rota();
  }

  public Vector preencherCliente()
  {
     return cl.getCliente();
  }

  public String selecionarCliente(String str)
 {
    return cl.getCliente(str);
 }

 public Vector preencherTelaCliente(String cnpj)
 {
    return cl.preencherTelaCliente(cnpj);
 }

 public Vector outroEnd(String cnpj)
 {
    return cl.preencherTelaEnd(cnpj);
 }

 public Vector outroTel(String cnpj)
{
    return cl.preencherTelaTel(cnpj);
}

 public void alterarCliente(String cnpj, String razaoSocial, String inscEstadual,
		    String fantasia,int idEnd,String rua,String bairro,
		    String cidade,String estado,String cep,String num,
		    String email,String idTel,String tel,String fax)
{
   int id;
   Vector praca=new Vector();
   cl.alterarCliente(cnpj,razaoSocial,inscEstadual,fantasia);
   id=ro.getIdRota(rua,cidade);
   praca=cl.selecionarPraca(cidade);
   praca.remove(null);
   praca.remove("");
   cl.atualizarPraca((String)praca.get(0),String.valueOf(idEnd));
   cl.alterarEnd(idEnd,rua,bairro,cidade,estado,cep,num,email,id);
   cl.alterarTel(idTel,tel,fax);
}

public void destrutor() throws Throwable
  {
     cl.destrutor();
     this.finalize();
  }
}
