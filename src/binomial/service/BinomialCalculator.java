package binomial.service;

import binomial.strategy.BinomialStrategy;
import binomial.strategy.impl.MemoizationStrategy;
import binomial.strategy.impl.TabulationStrategy;

public class BinomialCalculator {
    private BinomialStrategy strategy;

    public BinomialCalculator(String method) {
        this.strategy = method.equalsIgnoreCase("memoization") ?
                new MemoizationStrategy() : new TabulationStrategy();
    }

    public int calculate(int n, int k) {
        return strategy.calculate(n, k);
    }

    public int[][] calculateAll(int n) {
        if (strategy instanceof TabulationStrategy) {
            return ((TabulationStrategy)strategy).calculateAll(n);
        }
        throw new UnsupportedOperationException("Esta operación solo está soportada para tabulación");
    }
}