package kruskal.algorithm;

import kruskal.datastructure.UnionFind;
import kruskal.model.Arista;

import java.util.Collections;
import java.util.List;

/**
 * Implementación del algoritmo de Kruskal para encontrar el árbol de recubrimiento mínimo
 */
public class KruskalAlgorithm {

    public static List<Arista> encontrarARM(int numMunicipios, List<Arista> aristas) {
        // Ordenar aristas por costo (de menor a mayor)
        Collections.sort(aristas);

        UnionFind uf = new UnionFind(numMunicipios);
        List<Arista> arbolRecubrimientoMinimo = new java.util.ArrayList<>();

        // Iterar por cada arista en orden de costo
        for (Arista arista : aristas) {
            int origen = arista.getOrigen();
            int destino = arista.getDestino();

            // Si la arista no forma un ciclo, agregarla al árbol de recubrimiento mínimo
            if (!uf.mismoConjunto(origen, destino)) {
                arbolRecubrimientoMinimo.add(arista);
                uf.unir(origen, destino);
            }
        }

        return arbolRecubrimientoMinimo;
    }
}