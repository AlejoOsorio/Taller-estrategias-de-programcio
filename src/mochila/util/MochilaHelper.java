package mochila.util;

import mochila.model.Objeto;

import java.util.List;

public class MochilaHelper {

    public static double llenarMochila(List<Objeto> objetos, double pesoMaximo) {
        resetearFracciones(objetos);

        double pesoActual = 0.0;
        double valorTotal = 0.0;

        for (Objeto obj : objetos) {
            for (int i = 0; i < obj.getCantidad(); i++) {
                if (pesoActual + obj.getPeso() <= pesoMaximo) {
                    pesoActual += obj.getPeso();
                    valorTotal += obj.getValor();
                    obj.setFraccion(obj.getFraccion() + 1.0);
                } else {
                    double fraccionRestante = (pesoMaximo - pesoActual) / obj.getPeso();
                    pesoActual = pesoMaximo;
                    valorTotal += obj.getValor() * fraccionRestante;
                    obj.setFraccion(obj.getFraccion() + fraccionRestante);
                    return valorTotal;
                }

                if (pesoActual == pesoMaximo) {
                    return valorTotal;
                }
            }
        }

        return valorTotal;
    }

    private static void resetearFracciones(List<Objeto> objetos) {
        for (Objeto obj : objetos) {
            obj.setFraccion(0.0);
        }
    }
}