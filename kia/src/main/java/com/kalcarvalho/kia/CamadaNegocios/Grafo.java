package CamadaNegocios;

import java.util.*;

public class Grafo extends CtrDados {

  protected Vector Parada = new Vector();
  protected Loja dist;
  protected static Aresta a[];
  protected static Vertice v[];
  private static int cont;

  public Grafo() {
    Vector campo = new Vector();
    cont = 0;
    cmd.chamarSQL(
      "SELECT Rota.idRota, numero " +
      "FROM Rota, Endereco, Distribuidora, EndDistribuidora " +
      "WHERE Endereco.idRota=Rota.idRota " +
      "AND Endereco.idEndereco=EndDistribuidora.idEndereco " +
      "AND cnpj=idDistribuidora"
    );

    campo = cmd.getFromRegistros(cmd.executarSQL(), 2);
    dist =
      new Loja(
        Integer.parseInt((String) campo.get(1)),
        Integer.parseInt((String) campo.get(0))
      );
    Parada.addElement(dist);
  }

  public void criaGrafo(Vector ar) {
    for (int i = 0; i < ar.size(); i++) a[cont++] = new Aresta();
  }

  public void critParada(Vector p) {
    Parada.addElement(p);
  }

  public void criaPercurso() {
    Vector campo = new Vector();
    Vector prox = new Vector();
    int count;

    campo.addElement("Count(*)");
    cmd.selecionar(campo, "GradeRota", "idRotaOrigem=" + dist.getRota());

    count = cmd.getFromRegistros(cmd.executarSQL(), 1).size();

    campo.removeAllElements();
    if (count == 0) return;

    campo.addElement("idRotaDestino");
    campo.addElement("AlturaOrigem");
    campo.addElement("AlturaDestino");
    cmd.selecionar(campo, "GradeRota", "idRotaOrigem=" + dist.getRota());
    campo.removeAllElements();
    for (int i = 0; i < count; ++i) {
      prox = cmd.getFromRegistros(cmd.executarSQL(), 3);
      campo.addElement("Extensao");
      if (i == 1) {
        v[i - 1] = new Vertice();
        cmd.selecionar(campo, "Rota", "idRota=" + dist.getRota());
        v[i - 1].setVertice(dist.getRota(), cmd.getInt(cmd.executarSQL()));
      }
    }
  }
}
