package CamadaNegocios;

import java.util.*;

public class Vertice {

  private int idVertice;
  private int extensao;

  public Vertice() {}

  public void setVertice(int id, int ext) {
    idVertice = id;
    extensao = ext;
  }

  public int getID() {
    return idVertice;
  }

  public int getExtensao() {
    return extensao;
  }
}
