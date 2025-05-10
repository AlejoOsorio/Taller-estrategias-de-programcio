package mochilaMemorizacion.algorithm;

import mochilaMemorizacion.algorithm.KnapsackSolver;
import mochilaMemorizacion.model.Item;

import java.util.List;

public class MemoizationKnapsackSolver implements KnapsackSolver {
    private Integer[][] memo;

    @Override
    public int solve(int capacity, List<Item> items) {
        int n = items.size();
        memo = new Integer[n+1][capacity+1];
        return knapsackMemo(capacity, items, n);
    }

    private int knapsackMemo(int capacity, List<Item> items, int n) {
        if (n == 0 || capacity == 0) return 0;
        if (memo[n][capacity] != null) return memo[n][capacity];

        Item current = items.get(n-1);
        if (current.getWeight() > capacity) {
            memo[n][capacity] = knapsackMemo(capacity, items, n-1);
        } else {
            int include = current.getValue() + knapsackMemo(capacity - current.getWeight(), items, n-1);
            int exclude = knapsackMemo(capacity, items, n-1);
            memo[n][capacity] = Math.max(include, exclude);
        }
        return memo[n][capacity];
    }

    @Override
    public Integer[][] getMemoizationTable() {
        return memo;
    }

    @Override
    public boolean[] getSelectedItems(int capacity, List<Item> items) {
        int n = items.size();
        boolean[] selected = new boolean[n];
        int remainingCapacity = capacity;
        int optimalValue = solve(capacity, items);

        for (int i = n; i > 0 && optimalValue > 0; i--) {
            if (i == 1 && optimalValue > 0) {
                selected[0] = true;
                break;
            }

            if (memo[i-1][remainingCapacity] != null &&
                    optimalValue == memo[i-1][remainingCapacity]) {
                continue;
            } else {
                selected[i-1] = true;
                optimalValue -= items.get(i-1).getValue();
                remainingCapacity -= items.get(i-1).getWeight();
            }
        }
        return selected;
    }
}