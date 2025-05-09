package kruskal.ui;

import kruskal.model.Arista;
import kruskal.service.KruskalService;
import kruskal.service.impl.KruskalServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KruskalConsoleUI {
    private final KruskalService kruskalService;
    private final Scanner scanner;

    public KruskalConsoleUI() {
        this.kruskalService = new KruskalServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("=== SISTEMA DE PLANIFICACIÓN DE RED DE FIBRA ÓPTICA ===");

        int numMunicipios = solicitarNumeroMunicipios();
        List<Arista> aristas = solicitarConexiones(numMunicipios);

        procesarSolucion(numMunicipios, aristas);

        scanner.close();
    }

    private int solicitarNumeroMunicipios() {
        System.out.print("Ingrese el número de municipios a conectar: ");
        return scanner.nextInt();
    }

    private List<Arista> solicitarConexiones(int numMunicipios) {
        System.out.print("Ingrese el número de conexiones posibles entre municipios: ");
        int numConexiones = scanner.nextInt();

        List<Arista> aristas = new ArrayList<>();

        System.out.println("\nPor favor, ingrese la información de cada conexión:");
        for (int i = 1; i <= numConexiones; i++) {
            System.out.println("\nConexión " + i + ":");
            Arista arista = solicitarArista(numMunicipios, i);
            if (arista != null) {
                aristas.add(arista);
            } else {
                i--; // Repetir esta iteración si hay error
            }
        }

        return aristas;
    }

    private Arista solicitarArista(int numMunicipios, int i) {
        System.out.print("Municipio origen (1-" + numMunicipios + "): ");
        int origen = scanner.nextInt();

        System.out.print("Municipio destino (1-" + numMunicipios + "): ");
        int destino = scanner.nextInt();

        System.out.print("Costo de la conexión (en pesos colombianos): ");
        int costo = scanner.nextInt();

        // Validar datos de entrada
        if (origen < 1 || origen > numMunicipios || destino < 1 || destino > numMunicipios || origen == destino) {
            System.out.println("Error: Los municipios deben estar entre 1 y " + numMunicipios + " y ser diferentes.");
            return null;
        }

        if (costo < 0) {
            System.out.println("Error: El costo no puede ser negativo.");
            return null;
        }

        return new Arista(origen, destino, costo);
    }

    private void procesarSolucion(int numMunicipios, List<Arista> aristas) {
        List<Arista> arbolRecubrimientoMinimo = kruskalService.calcularARM(numMunicipios, aristas);

        if (!kruskalService.validarConexionCompleta(numMunicipios, arbolRecubrimientoMinimo)) {
            System.out.println("\n¡ATENCIÓN! No es posible conectar todos los municipios con las conexiones proporcionadas.");
            System.out.println("Verifique que el grafo sea conexo (existe un camino entre cualquier par de municipios).");
        } else {
            mostrarResultado(arbolRecubrimientoMinimo);
        }
    }

    private void mostrarResultado(List<Arista> arbolRecubrimientoMinimo) {
        int costoTotal = kruskalService.calcularCostoTotal(arbolRecubrimientoMinimo);

        System.out.println("\n=== PLAN DE CONEXIÓN ÓPTIMO ===");
        System.out.println("Conexiones de fibra óptica a instalar:");

        for (int i = 0; i < arbolRecubrimientoMinimo.size(); i++) {
            Arista arista = arbolRecubrimientoMinimo.get(i);
            System.out.println((i + 1) + ". " + arista);
        }

        System.out.println("\nCosto total de la instalación: $" + costoTotal + " pesos colombianos");
    }
}