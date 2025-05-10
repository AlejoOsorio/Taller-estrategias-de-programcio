package binomial.strategy.impl;

import binomial.strategy.BinomialStrategy;

public class TabulationStrategy implements BinomialStrategy {

    @Override
    public int calculate(int n, int k) {
        if (k < 0 || k > n) return 0;

        int[][] dp = new int[n+1][n+1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        return dp[n][k];
    }

    public int[][] calculateAll(int n) {
        return calcularCoeficientesBinomiales(n);
    }

    private int[][] calcularCoeficientesBinomiales(int n) {
        int[][] coeficientes = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            coeficientes[i][0] = 1;
            coeficientes[i][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                coeficientes[i][j] = coeficientes[i - 1][j - 1] + coeficientes[i - 1][j];
            }
        }

        return coeficientes;
    }
}