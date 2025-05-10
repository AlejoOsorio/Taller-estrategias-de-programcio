package mochila.service.impl;


import mochila.model.Objeto;
import mochila.service.MochilaService;
import mochila.strategy.MochilaStrategy;
import mochila.strategy.impl.PorPesoStrategy;
import mochila.strategy.impl.PorValorPesoStrategy;
import mochila.strategy.impl.PorValorStrategy;

import java.util.List;

public class MochilaServiceImpl implements MochilaService {

    @Override
    public double resolverMochila(List<Objeto> objetos, double pesoMaximo, String estrategia) {
        MochilaStrategy strategy = switch (estrategia.toLowerCase()) {
            case "valor" -> new PorValorStrategy();
            case "peso" -> new PorPesoStrategy();
            default -> new PorValorPesoStrategy();
        };

        return strategy.resolver(objetos, pesoMaximo);
    }

    @Override
    public void mostrarObjetosSeleccionados(List<Objeto> objetos) {
        System.out.println("\nObjetos seleccionados:");
        for (Objeto obj : objetos) {
            if (obj.getFraccion() > 0) {
                System.out.println("Objeto " + obj.getId() + ": " +
                        String.format("%.2f", obj.getFraccion()) + " unidades" +
                        " (Valor aportado: " + String.format("%.2f", obj.getValor() * obj.getFraccion()) + ")");
            }
        }
    }
}