package Controladoras;

import CamadaNegocios.Cliente;
import CamadaNegocios.Rota;
import java.util.Vector;
import javax.swing.JOptionPane;

public class CtrCadastrarRota {

  private Rota rt;
  private Cliente cl;

  public CtrCadastrarRota() {
    rt = new Rota();
    cl = new Cliente();
  }

  public Vector getCidades() {
    return cl.getCidades();
  }

  /**
   * usa o metodo geRua de cliente para selecionar as ruas da tabela endereco,
   * para preencher o combobox rua.
   * usa o método getRua de rota para retornar as ruas da tabela rota
   * @param cidade String nome da cidade
   * @return Vector com 2 vectores, posicao 0 ruas da tabela endereco, posicao 1
   * ruas da tabela rota
   */
  public Vector selecionarEnd(String cidade) {
    Vector endereco = new Vector();
    endereco.addElement(cl.getRua(cidade));
    endereco.addElement(rt.getRua(cidade));
    endereco.addElement(rt.getExtensao(cidade));
    return endereco;
  }

  /**
   * cadastra a rota e caso já exista cliente nesta rua, configura-o.
   * @param cidade String nome da cidade
   * @param rua String nome da rua
   * @param tam String tamanho da rua
   * @param ini Vector nome das ruas anteriores que fazem ligação
   */
  public void cadastrarRota(
    String cidade,
    String rua,
    int tam,
    String cidori,
    Vector ini,
    String cidest,
    Vector des,
    String tipo
  ) {
    Vector idEnde = new Vector();
    int idRota = 0;

    //pega idEndereco da rua se a rua já for cadastrada na tabela endereco,
    //ou seja, se já tiver cliente nesta rua
    idEnde = cl.getId(rua, cidade);
    //verifica se a rua ja esta cadastrada na tabela rota

    if (rt.getIdRota(rua, cidade) != 0 && tipo == "U") {
      JOptionPane.showMessageDialog(
        null,
        "Rua já Cadastrada",
        "Cadastro de Rota",
        JOptionPane.ERROR_MESSAGE
      );
      return;
    }

    idRota = rt.cadastrar(cidade, rua, tam, cidori, ini, cidest, des, tipo);
    //IMPORTANTE: se já houver cliente nesta rua, o metodo atualizar seta o
    //campo idRota da tabela endereco, configurando assim este endereço.
    //O mesmo acontece quando vc está cadastrando um endereço de um cliente
    if (!idEnde.equals(null)) for (
      int i = 0;
      i < idEnde.size();
      i++
    ) cl.atualizar(idRota, (String) idEnde.get(i));
  }

  public void destrutor() throws Throwable {
    rt.destrutor();
    cl.destrutor();
    this.finalize();
  }
}
