package Controladoras;

import CamadaNegocios.Fornecedor;

public class CtrCadastrarFornecedor
{
    private Fornecedor forn;
    //private Data;

    public CtrCadastrarFornecedor()
    {
      forn=new Fornecedor();
//      dt = new Data();
    }

    public void novoEndereco(String rua,String bairro,String cidade,String estado, String cep,String numero,String Email, String cnpj)
    {
      forn.inserirEndereco(rua,bairro,cidade,estado,cep,numero,Email,cnpj);
    }

    public void novoTelefone(String t,String f,String cnpj)
    {
      forn.inserirTelefone(t,f,cnpj);
    }

    public void cadastrar(String cnp,String razaosoc,String inscest,String fant,String repVe)
    {
      forn.cadastrar(cnp,razaosoc,inscest,fant,repVe);
    }

    public void destrutor() throws Throwable
      {
	 forn.destrutor();
	 this.finalize();
      }

 }
