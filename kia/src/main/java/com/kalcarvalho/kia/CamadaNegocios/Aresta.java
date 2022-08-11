package CamadaNegocios;

import java.util.*;

public class Aresta {

  private int idGrade;
  private Vertice vi = new Vertice();
  private Vertice vf = new Vertice();
  private static int nArestas;

  public Aresta() {
    nArestas = 0;
  }

  public Aresta(int id, Vertice vo, Vertice vd) {
    vi = vo;
    vf = vd;
    idGrade = id;
    nArestas++;
  }
}
