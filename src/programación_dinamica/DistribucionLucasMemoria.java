package programación_dinamica;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DistribucionLucasMemoria {
    private static Map<Integer, Integer> lucasMem = new HashMap<Integer, Integer>();

    private static int lucasIndex(int n) {
        if (lucasMem.isEmpty()) {
            lucasMem.put(0, 2);
            lucasMem.put(1, 1);
        }

        if (lucasMem.containsKey(n)) {
            return lucasMem.get(n); // O(1): acceso rápido a valor ya calculado
        }

        // Llamadas recursivas para calcular Lucas(n)
        // Cada término se calcula solo una vez gracias a la memoización
        int value = lucasIndex(n - 1) + lucasIndex(n - 2);

        lucasMem.put(n, value);
        return value;
    }

    public static void main(String[] args) {
        System.out.println(lucasIndex(4));
    }

}