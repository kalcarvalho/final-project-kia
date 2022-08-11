package Controladoras;

import CamadaNegocios.Fornecedor;
import javax.swing.JOptionPane;
import java.util.Vector;

public class CtrAlterarFornecedor
{
  private Fornecedor forn;

  public CtrAlterarFornecedor()
  {
     forn=new Fornecedor();
  }

  public Vector preencherForn()
  {
     return forn.getFornecedor();
  }

  public String selecionarFornecedor(String str)
  {
     return forn.getFornecedor(str);
  }

   public Vector preencherTelaFornecedor(String cnpj)
   {
      return forn.preencherTelaFornecedor(cnpj);
   }

   public Vector outroEnd(String cnpj)
   {
      return forn.preencherTelaEnd(cnpj);
   }

   public Vector outroTel(String cnpj)
   {
      return forn.preencherTelaTel(cnpj);
   }

   public void alterarForn(String cnpj, String razaoSocial, String inscEstadual,
			  String fantasia,String repVendas,int idEnd,String rua,
			  String bairro,String cidade, String estado,String cep,
			  String num, String email,String idTel,String tel,
			  String fax)
   {
      forn.alterarForn(cnpj,razaoSocial,inscEstadual,fantasia,repVendas);
      forn.alterarEnd(idEnd,rua,bairro,cidade,estado,cep,num,email);
      forn.alterarTel(idTel,tel,fax);
   }

   public void destrutor() throws Throwable
     {
	forn.destrutor();
	this.finalize();
     }

}
