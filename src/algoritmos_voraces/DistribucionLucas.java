package algoritmos_voraces;

public class DistribucionLucas {
    public static void main(String[] args) {
        System.out.println(distribucionLucas(5));
    }

    public static int distribucionLucas(int n) {
        if (n == 0) {return 2;}
        if (n == 1) {return 1;}

        int[] dist = new int[n + 1];
        dist[0] = 2;
        dist[1] = 1;

        for (int i = 2; i <= n; i++) {
            dist[i] = dist[i - 1] + dist[i - 2];
        }
        return dist[n];
    }
}
