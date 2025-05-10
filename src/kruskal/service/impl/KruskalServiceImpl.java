package kruskal.service.impl;

import kruskal.algorithm.KruskalAlgorithm;
import kruskal.model.Arista;
import kruskal.service.KruskalService;
import kruskal.util.GraphValidator;

import java.util.List;

public class KruskalServiceImpl implements KruskalService {

    @Override
    public List<Arista> calcularARM(int numMunicipios, List<Arista> aristas) {
        return KruskalAlgorithm.encontrarARM(numMunicipios, aristas);
    }

    @Override
    public boolean validarConexionCompleta(int numMunicipios, List<Arista> aristas) {
        return GraphValidator.todosConectados(numMunicipios, aristas);
    }

    @Override
    public int calcularCostoTotal(List<Arista> aristas) {
        return GraphValidator.calcularCostoTotal(aristas);
    }
}