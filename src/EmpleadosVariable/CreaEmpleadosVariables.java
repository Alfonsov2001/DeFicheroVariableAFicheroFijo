package EmpleadosVariable;
//Preguntar a Nuria por qué no puedo leer el achivo fijo
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 *
 * @author Alfonso Valenzuela Rivero
 */
public class CreaEmpleadosVariables {

    public static void main(String[] args) {
        try {
            DataOutputStream escribeFichero=new DataOutputStream((new FileOutputStream("Ficheros/EmpleadosVariable.dat".replace("/", File.separator))));
            EmpleadosVariableDAO.escribir(escribeFichero, new Empleado(1,"Alfonso", "Valenzuela Rivero", 2500));
            EmpleadosVariableDAO.escribir(escribeFichero, new Empleado(2,"Pablo","Jiménez Fuentes",5000));
            EmpleadosVariableDAO.escribir(escribeFichero, new Empleado(3,"Antonio","Fernández Jiménez", 3000));
            EmpleadosVariableDAO.escribir(escribeFichero, new Empleado(4,"David","Valdivia Guillén",4000));
            EmpleadosVariableDAO.escribir(escribeFichero, new Empleado(5,"Javier","Jiménez",3500));
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error al escribir/crear el fichero");
        }catch(IOException ioe){
            System.out.println("Error al cerrar el flujo 1");
        }
        
    }
}