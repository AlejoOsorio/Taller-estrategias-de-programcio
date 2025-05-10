package programación_dinamica;

public class DistribucionLucasTabulacion {
    public static void main(String[] args) {
        System.out.println(distribucionLucas(5));
    }

    public static int distribucionLucas(int n) {
        // Caso base: Lucas(0) = 2 -> O(1)
        if (n == 0) {return 2;}

        // Caso base: Lucas(1) = 1 -> O(1)
        if (n == 1) {return 1;}

        int[] dist = new int[n + 1];
        dist[0] = 2;
        dist[1] = 1;

        // Bucle O(n): cada iteración realiza suma constante
        for (int i = 2; i <= n; i++) {
            dist[i] = dist[i - 1] + dist[i - 2];
        }
        return dist[n];
    }
}
