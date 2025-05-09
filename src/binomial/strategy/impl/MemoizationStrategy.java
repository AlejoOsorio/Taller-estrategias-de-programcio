package binomial.strategy.impl;

import binomial.strategy.BinomialStrategy;

public class MemoizationStrategy implements BinomialStrategy {
    private Integer[][] memo;

    @Override
    public int calculate(int n, int k) {
        memo = new Integer[n+1][k+1];
        return coeficienteBinomialMemorizacion(n, k);
    }

    private int coeficienteBinomialMemorizacion(int n, int k) {
        if (k < 0 || k > n) return 0;
        if (k == 0 || k == n) return 1;
        if (memo[n][k] != null) return memo[n][k];

        memo[n][k] = coeficienteBinomialMemorizacion(n-1, k-1) +
                coeficienteBinomialMemorizacion(n-1, k);
        return memo[n][k];
    }
}