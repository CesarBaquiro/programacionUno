package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import co.edu.uniquindio.poo.Enum.Color;
import co.edu.uniquindio.poo.Enum.Especie;
import co.edu.uniquindio.poo.Enum.Genero;
import co.edu.uniquindio.poo.Enum.Raza;

/*
 * La clase controller se encarga de gestionar el registro de las mascotas en la lista
 */

public class MascotaController {
    /*
     * Lista de mascotas
     */
    public static List<Mascota> listaMascotas = new ArrayList<>();

    /*
     * Metodo para crear nuevas instancias de Masctoa
     */
    public static void crearMascota(String id, String nombre, Especie especie, Raza raza, Genero genero, byte edad,
            Color color, double peso) {
        // Guarda la instancia creada en la lista
        MascotaController.listaMascotas.add(new Mascota(id, nombre, especie, raza, genero, edad, color, peso));
    }

    /*
     * Metodo para ordenar las mascotas alfabeticamente
     */
    public static void ordenarMascotasAlfabeticamente() {
        // Nos aseguramos de que la lista este inicializada y tenga los datos
        if (listaMascotas != null) {
            // Hacemos uso del método sort de Collections y ignoramos si se está haciendo
            // uso de minúsculas o mayúsculas para comparar y reordenar
            Collections.sort(listaMascotas,
                    (mascota1, mascota2) -> mascota1.nombre().compareToIgnoreCase(mascota2.nombre()));
        } else {
            System.out.println("La listaMascotas no ha sido inicializada o está vacía.");
        }
    }

    /*
     * Metodo para ordenar las mascotas en edad descendente
     */

    public static void ordenarMascotasEdadDescendente() {
        // Nos aseguramos de que la lista este inicializada y tenga los datos
        if (listaMascotas != null) {
            // Hacemos uso del método sort de Collections y le indicamos que compare por la
            // edad de las mascotas. Usamos el metodo reversed() pera que quede de manera
            // descendente
            Collections.sort(listaMascotas, Comparator.comparingInt(Mascota::edad).reversed());
        } else {
            System.out.println("La listaMascotas no ha sido inicializada o está vacía.");
        }
    }

    /*
     * Metodo para filtrar mascotas adultas (Mayores a 10 años)
     */

    public static List<Mascota> obtenerMascotasAdultas() {
        // Comprobamos que la listaMascotas esté inicializada y contenga las mascotas
        // que
        // queremos filtrar
        if (listaMascotas != null) {
            // Utilizamos stream() para crear un flujo de datos sobre la lista
            // Filtramos las mascotas con edad mayor a 10
            // Collectors.toList() recoge los elementos filtrados en una nueva lista
            return listaMascotas.stream()
                    .filter(mascota -> mascota.edad() > 10)
                    .collect(Collectors.toList());
        } else {
            System.out.println("La listaMascotas no ha sido inicializada o está vacía.");
            return new ArrayList<>(); // Retorna una lista vacía si la listaMascotas es nula o vacía ya que el metodo
                                      // debe retornar una lista
        }
    }
}
