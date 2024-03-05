package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.List;

import co.edu.uniquindio.poo.Enum.*;

/**
 * Clase Mascota
 * Esta clase es un record, contiene los metodos getters implicitos
 * (No contiene setters, porque es una clase que crea registros inmutables)
 */

public record Mascota(String id, String nombre, Especie especie, Raza raza, Genero genero, byte edad, Color color,
        double peso) {
};
