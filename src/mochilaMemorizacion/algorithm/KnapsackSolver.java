package mochilaMemorizacion.algorithm;

import mochilaMemorizacion.model.Item;

import java.util.List;

public interface KnapsackSolver {
    int solve(int capacity, List<Item> items);
    Integer[][] getMemoizationTable();
    boolean[] getSelectedItems(int capacity, List<Item> items);
}