package kruskal.model;

/**
 * Clase para representar una arista entre dos nodos (municipios)
 */
public class Arista implements Comparable<Arista> {
    private final int origen;
    private final int destino;
    private final int costo;

    public Arista(int origen, int destino, int costo) {
        this.origen = origen;
        this.destino = destino;
        this.costo = costo;
    }

    // Getters
    public int getOrigen() { return origen; }
    public int getDestino() { return destino; }
    public int getCosto() { return costo; }

    // Para ordenar las aristas por costo (de menor a mayor)
    @Override
    public int compareTo(Arista otra) {
        return this.costo - otra.costo;
    }

    @Override
    public String toString() {
        return "Municipio " + origen + " → Municipio " + destino + " (Costo: $" + costo + ")";
    }
}