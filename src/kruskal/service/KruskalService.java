package kruskal.service;

import kruskal.model.Arista;

import java.util.List;

public interface KruskalService {
    List<Arista> calcularARM(int numMunicipios, List<Arista> aristas);
    boolean validarConexionCompleta(int numMunicipios, List<Arista> aristas);
    int calcularCostoTotal(List<Arista> aristas);
}