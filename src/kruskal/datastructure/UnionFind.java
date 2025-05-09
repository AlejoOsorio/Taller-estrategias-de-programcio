package kruskal.datastructure;

/**
 * Implementación de la estructura de datos "Union-Find" con compresión de caminos
 * para detectar ciclos en un grafo no dirigido
 */
public class UnionFind {
    private final int[] padre;
    private final int[] rango;

    public UnionFind(int n) {
        padre = new int[n + 1]; // +1 porque los municipios empiezan desde 1
        rango = new int[n + 1];

        // Inicializar: cada elemento es su propio padre
        for (int i = 1; i <= n; i++) {
            padre[i] = i;
            rango[i] = 0;
        }
    }

    // Encuentra el representante (raíz) de un conjunto con compresión de caminos
    public int encontrar(int x) {
        if (padre[x] != x) {
            padre[x] = encontrar(padre[x]); // Compresión de caminos
        }
        return padre[x];
    }

    // Une dos conjuntos basándose en el rango
    public void unir(int x, int y) {
        int raizX = encontrar(x);
        int raizY = encontrar(y);

        if (raizX == raizY) {
            return; // Ya están en el mismo conjunto
        }

        // Unir según el rango
        if (rango[raizX] < rango[raizY]) {
            padre[raizX] = raizY;
        } else if (rango[raizX] > rango[raizY]) {
            padre[raizY] = raizX;
        } else {
            // Si los rangos son iguales, hacer uno raíz y aumentar su rango
            padre[raizY] = raizX;
            rango[raizX]++;
        }
    }

    // Verifica si dos elementos están en el mismo conjunto
    public boolean mismoConjunto(int x, int y) {
        return encontrar(x) == encontrar(y);
    }
}