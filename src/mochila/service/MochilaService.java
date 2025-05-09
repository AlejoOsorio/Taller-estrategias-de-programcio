package mochila.service;


import mochila.model.Objeto;

import java.util.List;

public interface MochilaService {
    double resolverMochila(List<Objeto> objetos, double pesoMaximo, String estrategia);
    void mostrarObjetosSeleccionados(List<Objeto> objetos);
}
