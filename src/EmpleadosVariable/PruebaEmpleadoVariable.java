package EmpleadosVariable;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author Alfonso Valenzuela Rivero
 */
public class PruebaEmpleadoVariable {

    public static void main(String[] args) {
        DataInputStream leeFichero;
        leeFichero = null;
        try {
            leeFichero = new DataInputStream(new FileInputStream("Ficheros/EmpleadosVariable.dat".replace("/", File.separator)));
            System.out.println("Datos de EmpleadoVariable: ");
            System.out.println("");
            Empleado reg = EmpleadosVariableDAO.leer(leeFichero);
            while (!EmpleadosVariableDAO.getFf()) {
                System.out.println(reg);
                reg = EmpleadosVariableDAO.leer(leeFichero);
            }
        } catch (IOException ioe) {
            System.out.println("Error al leer el archivo");
        } finally {
            if (leeFichero != null) {
                try {
                    leeFichero.close();
                } catch (IOException ioe) {
                    System.out.println("Error al cerrar el fichero");
                }
            }
        }

    }
}
