package mochilaMemorizacion.service;

import mochilaMemorizacion.algorithm.KnapsackSolver;
import mochilaMemorizacion.model.Item;

import java.util.List;

public class KnapsackService {
    private final KnapsackSolver solver;

    public KnapsackService(KnapsackSolver solver) {
        this.solver = solver;
    }

    public int solveKnapsack(int capacity, List<Item> items) {
        return solver.solve(capacity, items);
    }

    public Integer[][] getMemoizationTable() {
        return solver.getMemoizationTable();
    }

    public boolean[] getSelectedItems(int capacity, List<Item> items) {
        return solver.getSelectedItems(capacity, items);
    }
}