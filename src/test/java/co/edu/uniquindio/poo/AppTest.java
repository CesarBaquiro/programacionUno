package co.edu.uniquindio.poo;

/**
 * @author Cesar Baquiro Área de programación UQ
 */

import co.edu.Mascotas;

//import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

public class AppTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    @Test
    public void testMascotasGetterSetter() {
        LOG.info("Iniciando testmascotasGetterSetter");

        Mascotas mascota = new Mascotas("Sasuke", "Perro", "Husky", "Macho", (byte)4, "Gris", 20.6);

        assertEquals(mascota.getNombre(), "Sasuke");
        assertEquals(mascota.getEspecie(), "Perro");
        assertEquals(mascota.getRaza(), "Husky");
        assertEquals(mascota.getGenero(), "Macho");
        assertEquals(mascota.getEdad(), (byte)4);
        assertEquals(mascota.getColor(), "Gris"); 
        assertEquals(mascota.getPeso(), 20.6);    

        // Modificar valores usando setters
        mascota.setNombre("Rodolfo Sasuke");
        mascota.setEspecie("Perre");
        mascota.setRaza("Lobo siberiano");
        mascota.setGenero("Audi TT");
        mascota.setEdad((byte) 10);
        mascota.setColor("Blue");
        mascota.setPeso(30);

        // Verificar si los setters han funcionado correctamente
        assertEquals(mascota.getNombre(), "Rodolfo Sasuke");
        assertEquals(mascota.getEspecie(), "Perre"); // Asegurarse de que el setter de Especie también funciona
        assertEquals(mascota.getRaza(), "Lobo siberiano");
        assertEquals(mascota.getGenero(), "Audi TT");
        assertEquals(mascota.getEdad(), (byte)30);
           assertEquals(mascota.getColor(), "Blue"); 
        assertEquals(mascota.getPeso(), 30);    

        LOG.info("Finalizando testmascotasGetterSetter");
    }

    @Test
    public void testMascotasEquals() {
        LOG.info("Iniciando testmascotasEquals");

        Mascotas mascota1 = new Mascotas("Juan", "Perez", "juan@example.com", "123456789", (byte) 25, "Gris", 20.6);
        Mascotas mascota2 = new Mascotas( "Juan", "Perez", "juan@example.com", "123456789", (byte) 25, "Gris", 20.6);
        Mascotas mascota3 = new Mascotas( "Pedro", "Gomez", "pedro@example.com", "987654321", (byte) 30, "Gris", 20.6);

        // Verificar que dos instancias con la misma información son iguales
        assertEquals(mascota1, mascota2);

        // Verificar que dos instancias con información diferente no son iguale
        assertNotEquals(mascota1, mascota3);

        LOG.info("Finalizando testmascotasEquals");
    }

    @Test
    public void testMascotasHashCode() {
        LOG.info("Iniciando testmascotasHashCode");

        Mascotas mascota1 = new Mascotas( "Juan", "Perez", "juan@example.com", "123456789", (byte) 25, "Gris", 20.6);
        Mascotas mascota2 = new Mascotas("Juan", "Perez", "juan@example.com", "123456789", (byte) 25, "Gris", 20.6);

        // Verificar que el hashCode de dos instancias con la misma información es igual
        assertEquals(mascota1.hashCode(), mascota2.hashCode());

        LOG.info("Finalizando testmascotasHashCode");
    }
}
