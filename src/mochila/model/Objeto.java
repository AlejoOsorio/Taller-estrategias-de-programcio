package mochila.model;

/**
 * Clase para representar un objeto con su peso, valor y cantidad disponible
 */
public class Objeto {
    private int id;
    private double peso;
    private double valor;
    private int cantidad;
    private double fraccion; // Fracción del objeto que se incluye en la mochila (0 ≤ fraccion ≤ 1)

    public Objeto(int id, double peso, double valor, int cantidad) {
        this.id = id;
        this.peso = peso;
        this.valor = valor;
        this.cantidad = cantidad;
        this.fraccion = 0.0;
    }

    // Getters y setters
    public int getId() { return id; }
    public double getPeso() { return peso; }
    public double getValor() { return valor; }
    public int getCantidad() { return cantidad; }
    public double getFraccion() { return fraccion; }
    public void setFraccion(double fraccion) { this.fraccion = fraccion; }

    // Método para calcular el valor por unidad de peso
    public double getValorPorPeso() {
        return valor / peso;
    }

    @Override
    public String toString() {
        return "Objeto " + id + " (Peso: " + peso + ", Valor: " + valor +
                ", Cantidad: " + cantidad + ", Valor/Peso: " + String.format("%.2f", getValorPorPeso()) + ")";
    }
}