package kruskal.util;

import kruskal.model.Arista;

import java.util.List;

public class GraphValidator {

    /**
     * Verifica si el árbol de recubrimiento mínimo conecta todos los nodos
     * @param numMunicipios Número total de municipios
     * @param arbolRecubrimientoMinimo Lista de aristas que forman el árbol
     * @return true si todos los municipios están conectados, false en caso contrario
     */
    public static boolean todosConectados(int numMunicipios, List<Arista> arbolRecubrimientoMinimo) {
        // En un árbol de recubrimiento mínimo, el número de aristas es igual a (n-1)
        return arbolRecubrimientoMinimo.size() == numMunicipios - 1;
    }

    /**
     * Calcula el costo total de las aristas
     * @param aristas Lista de aristas
     * @return Costo total
     */
    public static int calcularCostoTotal(List<Arista> aristas) {
        return aristas.stream().mapToInt(Arista::getCosto).sum();
    }
}