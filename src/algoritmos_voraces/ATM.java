package algoritmos_voraces;

import java.util.LinkedHashMap;
import java.util.Map;

public class ATM {

    public static Map<Integer, Integer> obtenerCambio(int cantidad, Map<Integer, Integer> dinero) {
        if (cantidad % 10000 != 0) {
            System.out.println("la cantidad debe ser divisible por 10.000.");
            return null;
        }

        Map<Integer, Integer> resultado = new LinkedHashMap<>();
        int restante = cantidad;

        // Complejidad del for n siendo n la longitud del mapa dinero
        for (Map.Entry<Integer, Integer> entry : dinero.entrySet()) {
            int denomiacion = entry.getKey();
            int undDisp = entry.getValue();

            int cantNec = restante / denomiacion;
            int cantUsd = Math.min(undDisp, cantNec);

            if (cantUsd > 0) {
                resultado.put(denomiacion, cantUsd);
                restante -= cantUsd * denomiacion;
            }
        }

        if (restante == 0) {
            return resultado;
        } else {
            System.out.println("No fue posible devolver");
            return null;
        }
    }

    public static void main(String[] args) {
        Map<Integer, Integer> dinero = new LinkedHashMap<>();
        dinero.put(100000, 50);
        dinero.put(50000, 100);
        dinero.put(20000, 200);
        dinero.put(10000, 300);

        Map<Integer, Integer> devuelta = obtenerCambio(10000, dinero);

        if (devuelta != null) {
            for (Map.Entry<Integer, Integer> entry : devuelta.entrySet()) {
                System.out.printf("$%d x %d billetes\n", entry.getKey(), entry.getValue());
            }
        }
    }
}
