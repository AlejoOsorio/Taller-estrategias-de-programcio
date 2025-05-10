package mochilaMemorizacion.util;

import mochilaMemorizacion.model.Item;

import java.util.List;

public class SolutionPrinter {
    public static void printSolution(int optimalValue, boolean[] selectedItems, List<Item> items) {
        System.out.println("Valor óptimo: " + optimalValue);
        System.out.println("Elementos seleccionados:");
        for (int i = 0; i < selectedItems.length; i++) {
            if (selectedItems[i]) {
                System.out.println(items.get(i));
            }
        }
    }

    public static void printMemoizationTable(Integer[][] memo) {
        System.out.println("\nTabla de memorización:");
        for (Integer[] row : memo) {
            for (Integer val : row) {
                System.out.print((val != null ? val : "X") + "\t");
            }
            System.out.println();
        }
    }

    public static void printItems(List<Item> items) {
        System.out.println("Elementos disponibles:");
        for (Item item : items) {
            System.out.println(item);
        }
    }
}