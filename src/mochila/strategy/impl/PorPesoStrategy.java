package mochila.strategy.impl;

import mochila.model.Objeto;
import mochila.strategy.MochilaStrategy;
import mochila.util.MochilaHelper;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PorPesoStrategy implements MochilaStrategy {

    @Override
    public double resolver(List<Objeto> objetos, double pesoMaximo) {
        // Ordenar objetos por peso en orden ascendente
        Collections.sort(objetos, Comparator.comparingDouble(Objeto::getPeso));

        return MochilaHelper.llenarMochila(objetos, pesoMaximo);
    }
}