package binomial2;

public class CoeficientesBinomiales {

    // Implementación con tabulación (bottom-up)
    public static int[][] calcularCoeficientesBinomiales(int n) {
        int[][] coeficientes = new int[n + 1][n + 1];

        // Casos base: C(i,0) = C(i,i) = 1
        for (int i = 0; i <= n; i++) {
            coeficientes[i][0] = 1;  // C(i,0) = 1
            coeficientes[i][i] = 1;  // C(i,i) = 1
        }

        // Construir la tabla usando la relación de recurrencia:
        // C(n,k) = C(n-1,k-1) + C(n-1,k)
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                coeficientes[i][j] = coeficientes[i - 1][j - 1] + coeficientes[i - 1][j];
            }
        }

        return coeficientes;
    }

    // Implementación con memorización (top-down)
    public static int coeficienteBinomialMemorizacion(int n, int k, Integer[][] memo) {
        // Validar que n y k sean válidos
        if (k < 0 || k > n) {
            return 0;
        }

        // Casos base
        if (k == 0 || k == n) {
            return 1;
        }

        // Verificar si ya calculamos este valor
        if (memo[n][k] != null) {
            return memo[n][k];
        }

        // Aplicar la relación de recurrencia
        memo[n][k] = coeficienteBinomialMemorizacion(n - 1, k - 1, memo) +
                coeficienteBinomialMemorizacion(n - 1, k, memo);

        return memo[n][k];
    }

    // Método principal para probar el funcionamiento
    public static void main(String[] args) {
        int n = 5;

        // Usando tabulación
        System.out.println("Calculando coeficientes binomiales con tabulación para n = " + n);
        int[][] coeficientes = calcularCoeficientesBinomiales(n);

        System.out.println("Triángulo de Pascal (coeficientes binomiales):");
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(coeficientes[i][j] + " ");
            }
            System.out.println();
        }

        // Probando la versión con memorización
        System.out.println("\nProbando algunos valores con memorización:");
        Integer[][] memo = new Integer[n+1][n+1];
        System.out.println("C(5,2) = " + coeficienteBinomialMemorizacion(5, 2, memo));
        System.out.println("C(5,3) = " + coeficienteBinomialMemorizacion(5, 3, memo));
    }
}