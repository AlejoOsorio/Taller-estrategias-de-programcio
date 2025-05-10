package mochilaMemorizacion2;


public class ProblemaMochila {

    // Solución con memorización (top-down)
    public static int mochilaMemorizacion(int capacidad, int[] pesos, int[] valores, int n, Integer[][] memo) {
        // Caso base
        if (n == 0 || capacidad == 0) {
            return 0;
        }

        // Si ya hemos calculado este valor antes, lo devolvemos
        if (memo[n][capacidad] != null) {
            return memo[n][capacidad];
        }

        // Si el peso del elemento actual excede la capacidad de la mochila, no lo incluimos
        if (pesos[n-1] > capacidad) {
            memo[n][capacidad] = mochilaMemorizacion(capacidad, pesos, valores, n-1, memo);
            return memo[n][capacidad];
        }

        // Tomamos el máximo entre incluir y no incluir el elemento actual
        int incluyendo = valores[n-1] +
                mochilaMemorizacion(capacidad - pesos[n-1], pesos, valores, n-1, memo);
        int excluyendo = mochilaMemorizacion(capacidad, pesos, valores, n-1, memo);

        // Guardamos el resultado en la memoria
        memo[n][capacidad] = Math.max(incluyendo, excluyendo);

        return memo[n][capacidad];
    }

    // Método para reconstruir los elementos seleccionados
    public static void elementosSeleccionados(int capacidad, int[] pesos, int[] valores, int n, Integer[][] memo) {
        // Resultado óptimo
        int valorOptimo = mochilaMemorizacion(capacidad, pesos, valores, n, memo);
        System.out.println("Valor óptimo: " + valorOptimo);

        // Reconstruir la solución
        boolean[] seleccionados = new boolean[n];
        int capacidadRestante = capacidad;

        for (int i = n; i > 0 && valorOptimo > 0; i--) {
            if (i == 1 && valorOptimo > 0) {
                // Si queda valor, significa que el primer elemento está incluido
                seleccionados[0] = true;
                break;
            }

            // Si el valor viene de la misma fila anterior,
            // significa que este elemento no fue incluido
            boolean noIncluido = memo[i-1][capacidadRestante] != null &&
                    valorOptimo == memo[i-1][capacidadRestante];

            if (!noIncluido) {
                // Este elemento fue incluido
                seleccionados[i-1] = true;
                valorOptimo -= valores[i-1];
                capacidadRestante -= pesos[i-1];
            }
        }

        // Mostrar elementos seleccionados
        System.out.println("Elementos seleccionados:");
        for (int i = 0; i < n; i++) {
            if (seleccionados[i]) {
                System.out.println("Elemento " + (i+1) +
                        ": valor = " + valores[i] +
                        ", peso = " + pesos[i]);
            }
        }
    }

    public static void main(String[] args) {
        // Ejemplo del problema de la diapositiva 31
        int[] valores = {2, 5, 10, 14, 15};
        int[] pesos = {1, 3, 4, 5, 7};
        String[] nombres = {"A", "B", "C", "D", "E"};
        int capacidadMochila = 8;
        int n = valores.length;

        // Inicializar matriz de memorización
        Integer[][] memo = new Integer[n+1][capacidadMochila+1];

        // Calcular valor óptimo
        int valorMaximo = mochilaMemorizacion(capacidadMochila, pesos, valores, n, memo);
        System.out.println("Valor máximo que se puede obtener: " + valorMaximo);

        // Imprimir tabla de memorización
        System.out.println("\nTabla de memorización:");
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacidadMochila; w++) {
                System.out.print((memo[i][w] != null ? memo[i][w] : "X") + "\t");
            }
            System.out.println();
        }

        // Reconstruir solución
        System.out.println("\nReconstrucción de la solución:");
        elementosSeleccionados(capacidadMochila, pesos, valores, n, memo);

        // Prueba de escritorio
        System.out.println("\nPrueba de escritorio para el caso de la diapositiva 31:");
        System.out.println("Elementos disponibles:");
        for (int i = 0; i < n; i++) {
            System.out.println(nombres[i] + ": valor = " + valores[i] + ", peso = " + pesos[i]);
        }
        System.out.println("Capacidad de la mochila: " + capacidadMochila);
    }
}