package co.edu.uniquindio.poo;

//import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

/**
 * Comprobacion de datos nulos
 */
    
    @Test
    public void datosNulos(){
        LOG.info("Iniciando datosNulos");
        assertThrows(NullPointerException.class, () -> {
        Mascota mascota = new Mascota(null, null, null, null, (byte) 0, null, 0);
        // Cualquier operación que pueda lanzar una excepción aquí
        });
        LOG.info("Finalizando datosNulos");

    }

/**
 * Comprobacion de datos vacios
 */

    @Test
    public void datosVacios(){
        LOG.info("Iniciando datosVacios");
       
        assertThrows(Throwable.class, () -> new Mascota("", null, null , null ,(byte) 0, null, 0));

        LOG.info("Finalizando datosVacios");

    }

/**
 * Comprobacion de datos completos
 */

@Test
    public void testDatosCompletos(){
        LOG.info("Iniciando testDatosCompletos");

        Mascota mascota = new Mascota("Sasuke", Especie.PERRO, Raza.HUSKY, Genero.MACHO, (byte) 4, Color.GRIS, 20.6);

        assertEquals( "Sasuke", mascota.nombre());
        assertEquals( Especie.PERRO, mascota.especie());
        assertEquals( Raza.HUSKY, mascota.raza());
        assertEquals( Genero.MACHO, mascota.genero());
        assertEquals((byte)4, mascota.edad());
        assertEquals( Color.GRIS, mascota.color());

        LOG.info("Finalizando testDatosCompletos");
    }

    
/**
 * Comprobacion de edad negativa
 */

@Test
    public void testEdadNegativa(){
        LOG.info("Iniciando testEdadNegativa");
        Mascota mascota = new Mascota("Sasuke", Especie.PERRO, Raza.HUSKY, Genero.MACHO, (byte) -4, Color.GRIS, 4.2);
        assertEquals( "Sasuke", mascota.nombre());
        assertEquals( Especie.PERRO, mascota.especie());
        assertEquals( Raza.HUSKY, mascota.raza());
        assertEquals( Genero.MACHO, mascota.genero());
        //Mensaje personalizado de error cuando la edad es menor a 0
        assertEquals((byte)4, mascota.edad(),  "---------------La edad debe ser mayor a 0-----------------------");
        assertEquals( Color.GRIS, mascota.color());

        LOG.info("Finalizando testEdadNegativa");
    }


    /**
 * Comprobacion de genero
 */

    @Test
    public void testValidarGenero(){
        LOG.info("Iniciando testEdadNegativa");
        Mascota mascota = new Mascota("Sasuke", Especie.PERRO, Raza.HUSKY, null, (byte) -4, Color.GRIS, 4.2);
        //Mensaje personalizado de error cuando el genero no se ingresa
        assertEquals( Genero.MACHO, mascota.genero(), "--------------Debe ingresar un género------------");
        LOG.info("Finalizando testEdadNegativa");
    }

}
