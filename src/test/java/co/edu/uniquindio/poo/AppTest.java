/**
 * @author Cesar Baquiro Área de programación UQ
 */
package co.edu.uniquindio.poo;
import co.edu.Estudiantes;

//import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

public class AppTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    @Test
    public void testEstudiantesGetterSetter() {
        LOG.info("Iniciando testEstudiantesGetterSetter");

        Estudiantes estudiante = new Estudiantes("123", "Juan", "Perez", "juan@example.com", "123456789", 25);

        assertEquals(estudiante.getId(), "123");
        assertEquals(estudiante.getName(), "Juan");
        assertEquals(estudiante.getLastname(), "Perez");
        assertEquals(estudiante.getMail(), "juan@example.com");
        assertEquals(estudiante.getPhone(), "123456789");
        assertEquals(estudiante.getAge(), 25);

        // Modificar valores usando setters
        estudiante.setId("456");
        estudiante.setName("Pedro");
        estudiante.setLastname("Gomez");
        estudiante.setMail("pedro@example.com");
        estudiante.setPhone("987654321");
        estudiante.setAge(30);

        // Verificar si los setters han funcionado correctamente
        assertEquals(estudiante.getId(), "456");
        assertEquals(estudiante.getName(), "Pedro");
        assertEquals(estudiante.getLastname(), "Gomez"); // Asegurarse de que el setter de lastname también funciona
        assertEquals(estudiante.getMail(), "pedro@example.com");
        assertEquals(estudiante.getPhone(), "987654321");
        assertEquals(estudiante.getAge(), 30);

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

        // Verificar que dos instancias con información diferente no son iguale
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
