package mochila.strategy.impl;

import mochila.model.Objeto;
import mochila.strategy.MochilaStrategy;
import mochila.util.MochilaHelper;

import java.util.Collections;
import java.util.List;

public class PorValorStrategy implements MochilaStrategy {

    @Override
    public double resolver(List<Objeto> objetos, double pesoMaximo) {
        // Ordenar objetos por valor en orden descendente
        Collections.sort(objetos, (a, b) -> Double.compare(b.getValor(), a.getValor()));

        return MochilaHelper.llenarMochila(objetos, pesoMaximo);
    }
}