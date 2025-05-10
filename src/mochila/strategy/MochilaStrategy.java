package mochila.strategy;

import mochila.model.Objeto;

import java.util.List;

public interface MochilaStrategy {
    double resolver(List<Objeto> objetos, double pesoMaximo);
}