/**
 * @author Cesar Baquiro Área de programación UQ
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

import co.edu.Estudiantes;

public class AppTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    @Test
    public void testEstudiantesGetterSetter() {
        LOG.info("Iniciando testEstudiantesGetterSetter");

        Estudiantes estudiante = new Estudiantes("123", "Juan", "Perez", "juan@example.com", "123456789", 25);

        assertEquals("123", estudiante.getId());
        assertEquals("Juan", estudiante.getName());
        assertEquals("Perez", estudiante.getLastname());
        assertEquals("juan@example.com", estudiante.getMail());
        assertEquals("123456789", estudiante.getPhone());
        assertEquals(25, estudiante.getAge());

        // Modificar valores usando setters
        estudiante.setId("456");
        estudiante.setName("Pedro");
        estudiante.setLastname("Gomez");
        estudiante.setMail("pedro@example.com");
        estudiante.setPhone("987654321");
        estudiante.setAge(30);

        // Verificar si los setters han funcionado correctamente
        assertEquals("456", estudiante.getId());
        assertEquals("Pedro", estudiante.getName());
        assertEquals("Gomez", estudiante.getLastname()); // Asegurarse de que el setter de lastname también funciona
        assertEquals("pedro@example.com", estudiante.getMail());
        assertEquals("987654321", estudiante.getPhone());
        assertEquals(30, estudiante.getAge());

        LOG.info("Finalizando testEstudiantesGetterSetter");
    }

    @Test
    public void testEstudiantesEquals() {
        LOG.info("Iniciando testEstudiantesEquals");

        Estudiantes estudiante1 = new Estudiantes("123", "Juan", "Perez", "juan@example.com", "123456789", 25);
        Estudiantes estudiante2 = new Estudiantes("123", "Juan", "Perez", "juan@example.com", "123456789", 25);
        Estudiantes estudiante3 = new Estudiantes("456", "Pedro", "Gomez", "pedro@example.com", "987654321", 30);

        // Verificar que dos instancias con la misma información son iguales
        assertEquals(estudiante1, estudiante2);

        // Verificar que dos instancias con información diferente no son iguales
        assertNotEquals(estudiante1, estudiante3);

        LOG.info("Finalizando testEstudiantesEquals");
    }

    @Test
    public void testEstudiantesHashCode() {
        LOG.info("Iniciando testEstudiantesHashCode");

        Estudiantes estudiante1 = new Estudiantes("123", "Juan", "Perez", "juan@example.com", "123456789", 25);
        Estudiantes estudiante2 = new Estudiantes("123", "Juan", "Perez", "juan@example.com", "123456789", 25);

        // Verificar que el hashCode de dos instancias con la misma información es igual
        assertEquals(estudiante1.hashCode(), estudiante2.hashCode());

        LOG.info("Finalizando testEstudiantesHashCode");
    }
}
