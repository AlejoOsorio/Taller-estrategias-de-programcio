package mochila.strategy.impl;

import mochila.model.Objeto;
import mochila.strategy.MochilaStrategy;
import mochila.util.MochilaHelper;

import java.util.Collections;
import java.util.List;

public class PorValorPesoStrategy implements MochilaStrategy {

    @Override
    public double resolver(List<Objeto> objetos, double pesoMaximo) {
        // Ordenar objetos por valor/peso en orden descendente
        Collections.sort(objetos, (a, b) -> Double.compare(b.getValorPorPeso(), a.getValorPorPeso()));

        return MochilaHelper.llenarMochila(objetos, pesoMaximo);
    }
}