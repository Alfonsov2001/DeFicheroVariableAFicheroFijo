package EmpleadosFijo;

import EmpleadosFijo.EmpleadosFijoDAO;
import EmpleadosVariable.Empleado;
import EmpleadosVariable.EmpleadosVariableDAO;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Alfonso Valenzuela Rivero
 */
public class PruebaEmpleadoFijo {

    public static void main(String[] args) {
        try {
            DataInputStream lecturaFijo = new DataInputStream(new FileInputStream("Ficheros/EmpleadosFijo.dat".replace("/", File.separator)));
            System.out.println("Datos de empleado fijo: ");
            System.out.println("");
            try {
                Empleado reg = EmpleadosFijoDAO.leer(lecturaFijo);
                while (!EmpleadosVariableDAO.getFf() && reg != null) {
                    System.out.println(reg);
                    reg = EmpleadosFijoDAO.leer(lecturaFijo);
                }
            }catch (IOException ioe) {
                System.out.println("Error de E/S");
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado");
        }
    }
}
