package co.edu.uniquindio.poo;

//import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.Enum.Color;
import co.edu.uniquindio.poo.Enum.Especie;
import co.edu.uniquindio.poo.Enum.Genero;
import co.edu.uniquindio.poo.Enum.Raza;

/**
 * Clase AppTest
 * Contiene los test siguiendo el enfoque TDD
 */

public class AppTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    /*
     * Test de datos compleots
     */

    @Test
    public void testDatosCompletos() {
        LOG.info("----------Iniciando testDatosCompletos-----------");

        MascotaController.crearMascota("0", "Sasuke", Especie.PERRO, Raza.HUSKY, Genero.MACHO, (byte) 4, Color.GRIS,
                20.6);
        MascotaController.crearMascota("1", "Pelusa", Especie.GATO, Raza.SIAMES, Genero.HEMBRA, (byte) 2, Color.BLANCO,
                5.5);
        MascotaController.crearMascota("2", "Rocky", Especie.PERRO, Raza.BULLDOG, Genero.MACHO, (byte) 4, Color.GRIS,
                12.0);

        assertEquals("0", MascotaController.listaMascotas.get(0).id());
        assertEquals("Sasuke", MascotaController.listaMascotas.get(0).nombre());
        assertEquals(Especie.PERRO, MascotaController.listaMascotas.get(0).especie());
        assertEquals(Raza.HUSKY, MascotaController.listaMascotas.get(0).raza());
        assertEquals(Genero.MACHO, MascotaController.listaMascotas.get(0).genero());
        assertEquals((byte) 4, MascotaController.listaMascotas.get(0).edad());
        assertEquals(Color.GRIS, MascotaController.listaMascotas.get(0).color());
        LOG.info("-----------Finalizando testDatosCompletos-------------");
    }

    /*
     * Comprobacion de datos nulos
     */

    @Test
    public void agregarMascota() {
        LOG.info("----------Iniciando agregarMascota-----------");

        MascotaController.crearMascota("0", "Sasuke", Especie.PERRO, Raza.HUSKY, Genero.MACHO, (byte) 4, Color.GRIS,
                20.6);
        MascotaController.crearMascota("1", "Pelusa", Especie.GATO, Raza.SIAMES, Genero.HEMBRA, (byte) 2, Color.BLANCO,
                5.5);
        MascotaController.crearMascota("2", "Rocky", Especie.PERRO, Raza.BULLDOG, Genero.MACHO, (byte) 4, Color.GRIS,
                12.0);
        LOG.info("-----------Mascotras agregadas-------------");
        MascotaController.listaMascotas.forEach(System.out::println);
        LOG.info("-----------Finalizando agregarMascota-------------");
    }

    /*
     * Comprobacion de agregar mascota nula
     */

    @Test
    public void agregarMascotaNula() {
        LOG.info("--------Iniciando agregarMascotaNula--------");
        // Comprobacion agregando una mascota nula a la lista
        assertThrows(Throwable.class,
                () -> MascotaController.listaMascotas.add(null), "Error no se puede agregar una mascota nula.");
        LOG.info("----------Finalizando agregarMascotaNula----------");
    }

    /*
     * Test mascota repetida
     */
    @Test
    public void testMascotaRepetida() {
        LOG.info("----------Iniciando testMascotaRepetida-----------");

        MascotaController.crearMascota("0", "Sasuke", Especie.PERRO, Raza.HUSKY, Genero.MACHO, (byte) 4, Color.GRIS,
                20.6);
        MascotaController.crearMascota("1", "Pelusa", Especie.GATO, Raza.SIAMES, Genero.HEMBRA, (byte) 2, Color.BLANCO,
                5.5);
        MascotaController.crearMascota("1", "Rocky", Especie.PERRO, Raza.BULLDOG, Genero.MACHO, (byte) 4, Color.GRIS,
                12.0);

        for (int i = 0; i < MascotaController.listaMascotas.size() - 1; i++) {
            String idActual = MascotaController.listaMascotas.get(i).id();

            for (int j = i + 1; j < MascotaController.listaMascotas.size(); j++) {
                String idSiguiente = MascotaController.listaMascotas.get(j).id();
                assertNotEquals(idActual, idSiguiente,
                        "Error, No pueden haber dos mascotas con el mismo id en el sistema");
            }
        }
        LOG.info("-----------Finalizando testMascotaRepetida-------------");
    }

    /*
     * Test orden alfabetico
     */
    @Test
    public void testOrdenAlfabetico() {
        LOG.info("----------Iniciando testOrdenAlfabetico-----------");

        MascotaController.crearMascota("0", "Sasuke", Especie.PERRO, Raza.HUSKY, Genero.MACHO, (byte) 4, Color.GRIS,
                20.6);
        MascotaController.crearMascota("1", "Pelusa", Especie.GATO, Raza.SIAMES, Genero.HEMBRA, (byte) 2, Color.BLANCO,
                5.5);
        MascotaController.crearMascota("2", "Rocky", Especie.PERRO, Raza.BULLDOG, Genero.MACHO, (byte) 4, Color.GRIS,
                12.0);
        MascotaController.crearMascota("3", "Ares", Especie.PERRO, Raza.BULLDOG, Genero.MACHO, (byte) 4, Color.GRIS,
                12.0);

        LOG.info("----------------Listado de mascotas desordenadas---------------");
        MascotaController.listaMascotas.forEach(System.out::println);

        MascotaController.ordenarMascotasAlfabeticamente();

        LOG.info("----------------Listado de mascotas en orden alfabetico---------------");
        MascotaController.listaMascotas.forEach(System.out::println);
        LOG.info("-----------Finalizando testOrdenAlfabetico-------------");
    }

    /*
     * Test de ordenamiento de edad descendente
     */
    @Test
    public void testOrdenEdadDescendente() {
        LOG.info("----------Iniciando testOrdenEdadDescendente-----------");

        MascotaController.crearMascota("0", "Sasuke", Especie.PERRO, Raza.HUSKY, Genero.MACHO, (byte) 4, Color.GRIS,
                20.6);
        MascotaController.crearMascota("1", "Pelusa", Especie.GATO, Raza.SIAMES, Genero.HEMBRA, (byte) 2, Color.BLANCO,
                5.5);
        MascotaController.crearMascota("2", "Rocky", Especie.PERRO, Raza.BULLDOG, Genero.MACHO, (byte) 11, Color.GRIS,
                12.0);
        MascotaController.crearMascota("3", "Ares", Especie.PERRO, Raza.BULLDOG, Genero.MACHO, (byte) 1, Color.GRIS,
                12.0);

        LOG.info("----------------Listado de mascotas desordenadas---------------");
        MascotaController.listaMascotas.forEach(System.out::println);
        // Usamos el metodo que nos ayuda a ordenar
        MascotaController.ordenarMascotasEdadDescendente();

        LOG.info("----------------Listado de mascotas en orden descendente---------------");
        MascotaController.listaMascotas.forEach(System.out::println);
        LOG.info("-----------Finalizando testOrdenEdadDescendente-------------");
    }

    /*
     * Test de filtrado de mascotas adultas (Mayores a 10 años)
     */

    @Test
    public void testMascotasAdultas() {
        LOG.info("----------Iniciando testMascotasAdultas-----------");

        MascotaController.crearMascota("0", "Sasuke", Especie.PERRO, Raza.HUSKY, Genero.MACHO, (byte) 4, Color.GRIS,
                20.6);
        MascotaController.crearMascota("1", "Pelusa", Especie.GATO, Raza.SIAMES, Genero.HEMBRA, (byte) 2, Color.BLANCO,
                5.5);
        MascotaController.crearMascota("2", "Rocky", Especie.PERRO, Raza.BULLDOG, Genero.MACHO, (byte) 11, Color.GRIS,
                12.0);
        MascotaController.crearMascota("3", "Ares", Especie.PERRO, Raza.BULLDOG, Genero.MACHO, (byte) 1, Color.GRIS,
                12.0);
        MascotaController.crearMascota("4", "Elias", Especie.PERRO, Raza.BULLDOG, Genero.MACHO, (byte) 13, Color.GRIS,
                12.0);

        LOG.info("----------------Listado de mascotas---------------");
        MascotaController.listaMascotas.forEach(System.out::println);
        // Usamos el metodo que nos ayuda a filtrar
        MascotaController.obtenerMascotasAdultas();

        LOG.info("----------------Listado de mascotas adultas (Mayores a 10 años)---------------");
        MascotaController.obtenerMascotasAdultas().forEach(System.out::println);
        LOG.info("-----------Finalizando testMascotasAdultas-------------");
    }

}
