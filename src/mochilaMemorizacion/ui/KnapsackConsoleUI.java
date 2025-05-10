package mochilaMemorizacion.ui;

import mochilaMemorizacion.algorithm.MemoizationKnapsackSolver;
import mochilaMemorizacion.model.Item;
import mochilaMemorizacion.service.KnapsackService;
import mochilaMemorizacion.util.SolutionPrinter;

import java.util.Arrays;
import java.util.List;

public class KnapsackConsoleUI {
    public void runExample() {
        // Datos de ejemplo
        List<Item> items = Arrays.asList(
                new Item("A", 2, 1),
                new Item("B", 5, 3),
                new Item("C", 10, 4),
                new Item("D", 14, 5),
                new Item("E", 15, 7)
        );
        int capacity = 8;

        // Configurar el servicio
        KnapsackService service = new KnapsackService(new MemoizationKnapsackSolver());

        // Mostrar items
        SolutionPrinter.printItems(items);
        System.out.println("Capacidad de la mochila: " + capacity);

        // Resolver
        int optimalValue = service.solveKnapsack(capacity, items);
        boolean[] selectedItems = service.getSelectedItems(capacity, items);

        // Mostrar resultados
        SolutionPrinter.printSolution(optimalValue, selectedItems, items);
        SolutionPrinter.printMemoizationTable(service.getMemoizationTable());
    }
}