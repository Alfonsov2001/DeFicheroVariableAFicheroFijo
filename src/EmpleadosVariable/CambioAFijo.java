
package EmpleadosVariable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Alfonso Valenzuela Rivero
 */
public class CambioAFijo {

    public static void main(String[] args) {
        try {
            DataOutputStream escribeFijo=new DataOutputStream(new FileOutputStream("Ficheros/EmpleadosFijo.dat".replace("/", File.separator)));
            DataInputStream leeVariable=new DataInputStream(new FileInputStream("Ficheros/EmpleadosVariable.dat".replace("/", File.separator)));
            Empleado reg = EmpleadosVariableDAO.leer(leeVariable);
            while (!EmpleadosVariableDAO.getFf()) {
                int id=reg.getId();
                String nombreFijo=EmpleadosVariableDAO.cadenaFijo(reg.getNombre(), 10);
                String apellidosFijo=EmpleadosVariableDAO.cadenaFijo(reg.getApellidos(), 30);
                float sueldo=reg.getSueldo();
                
                escribeFijo.writeInt(id);
                escribeFijo.writeChars(nombreFijo);
                escribeFijo.writeChars(apellidosFijo);
                escribeFijo.writeFloat(sueldo);
                
                reg = EmpleadosVariableDAO.leer(leeVariable);
            }
        } catch (EOFException eof) {
            
        } catch (IOException ioe) {
            System.out.println("Error al leer el archivo");
        }
    }
}
