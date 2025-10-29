
package EmpleadosVariable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Alfonso Valenzuela  Rivero
 */
public class EscribeFichFijo {

    public static void main(String[] args) {
        try {
            DataOutputStream creaFijo=new DataOutputStream(new FileOutputStream("Ficheros/EmpleadosFijo.dat".replace("/", File.separator)));
            DataInputStream leeVariable=new DataInputStream(new FileInputStream("Ficheros/EmpleadosVariable.dat".replace("/", File.separator)));
            Empleado hayRegistro=EmpleadosVariableDAO.leer(leeVariable);
            while(!EmpleadosVariableDAO.getFf() && hayRegistro != null){
                EmpleadosFijoDAO.escribir(creaFijo, hayRegistro);
                hayRegistro=EmpleadosVariableDAO.leer(leeVariable);
            } 
        } catch (IOException ex) {
            System.out.println("Error al crear el archivo");
        }
    }
}
