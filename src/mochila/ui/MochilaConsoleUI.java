package mochila.ui;

import mochila.model.Objeto;
import mochila.service.MochilaService;
import mochila.service.impl.MochilaServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MochilaConsoleUI {
    private final MochilaService mochilaService;
    private final Scanner scanner;

    public MochilaConsoleUI() {
        this.mochilaService = new MochilaServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("=== PROBLEMA DE LA MOCHILA FRACCIONARIA ===");

        double pesoMaximo = solicitarPesoMaximo();
        List<Objeto> objetos = solicitarObjetos();

        mostrarObjetos(objetos);

        resolverYMostrarResultados(objetos, pesoMaximo);

        scanner.close();
    }

    private double solicitarPesoMaximo() {
        System.out.print("Ingrese el peso máximo del contenedor: ");
        return scanner.nextDouble();
    }

    private List<Objeto> solicitarObjetos() {
        List<Objeto> objetos = new ArrayList<>();

        System.out.print("Ingrese el número de tipos de objetos: ");
        int numTiposObjetos = scanner.nextInt();

        for (int i = 1; i <= numTiposObjetos; i++) {
            System.out.println("\nObjeto " + i + ":");
            System.out.print("Ingrese el peso: ");
            double peso = scanner.nextDouble();

            System.out.print("Ingrese el valor: ");
            double valor = scanner.nextDouble();

            System.out.print("Ingrese la cantidad disponible: ");
            int cantidad = scanner.nextInt();

            objetos.add(new Objeto(i, peso, valor, cantidad));
        }

        return objetos;
    }

    private void mostrarObjetos(List<Objeto> objetos) {
        System.out.println("\nObjetos disponibles:");
        for (Objeto obj : objetos) {
            System.out.println(obj);
        }
    }

    private void resolverYMostrarResultados(List<Objeto> objetos, double pesoMaximo) {
        // 1. Resolver usando la heurística de valor por unidad de peso
        System.out.println("\n=== SOLUCIÓN USANDO VALOR POR UNIDAD DE PESO ===");
        double valorTotalPorValorPeso = mochilaService.resolverMochila(objetos, pesoMaximo, "valorpeso");
        mochilaService.mostrarObjetosSeleccionados(objetos);
        System.out.println("Valor total de la carga: " + String.format("%.2f", valorTotalPorValorPeso));

        // 2. Resolver usando la heurística de valor
        System.out.println("\n=== SOLUCIÓN PRIORIZANDO VALOR ===");
        double valorTotalPorValor = mochilaService.resolverMochila(objetos, pesoMaximo, "valor");
        mochilaService.mostrarObjetosSeleccionados(objetos);
        System.out.println("Valor total de la carga: " + String.format("%.2f", valorTotalPorValor));

        // 3. Resolver usando la heurística de peso
        System.out.println("\n=== SOLUCIÓN PRIORIZANDO OBJETOS MÁS LIGEROS ===");
        double valorTotalPorPeso = mochilaService.resolverMochila(objetos, pesoMaximo, "peso");
        mochilaService.mostrarObjetosSeleccionados(objetos);
        System.out.println("Valor total de la carga: " + String.format("%.2f", valorTotalPorPeso));
    }
}