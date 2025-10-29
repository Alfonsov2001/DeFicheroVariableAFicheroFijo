package EmpleadosVariable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 *
 * @author Alfonso Valenzuela Rivero
 */
public class EmpleadosFijoDAO {

    private static boolean ff = false;
    private static final int TAMAÑO_NOMBRE=10;
    private static final int TAMAÑO_APELLIDOS=30;

    public static Empleado leer(DataInputStream data) throws IOException, EOFException {
        Empleado empleado;
        empleado=null;
        try {
            int id = data.readInt();
            String nombre=EmpleadosFijoDAO.leeCaracteres(data, TAMAÑO_NOMBRE);
            String apellidos=EmpleadosFijoDAO.leeCaracteres(data, TAMAÑO_APELLIDOS);
            float sueldo = data.readFloat();
            empleado=new Empleado(id, nombre, apellidos, sueldo);
        } catch (EOFException eof) {
            ff=true;
        } catch (IOException ioe){
            System.out.println("Error de E/S");
        }
        return empleado;
    }

    public static void escribir(DataOutputStream data, Empleado reg) throws IOException {
        data.writeInt(reg.getId());
        String nombre=EmpleadosFijoDAO.cadenaFijo(reg.getNombre(), TAMAÑO_NOMBRE);
        data.writeChars(nombre);
        String apellidos=EmpleadosFijoDAO.cadenaFijo(reg.getApellidos(), TAMAÑO_APELLIDOS);
        data.writeChars(apellidos);
        data.writeFloat(reg.getSueldo());
    }

    public static boolean getFf() {
        return ff;
    }
    
    public static String cadenaFijo(String nomOApes,int tamaño) throws IndexOutOfBoundsException{
        StringBuilder nom=new StringBuilder(nomOApes);
        if (nom.length() > tamaño) {
            nom.setLength(tamaño);
        }else{
            for (int i = nom.length(); i < tamaño; i++) {
                nom.append("@").toString();
            }
        }
        return nom.toString();
    }
    
    public static String leeCaracteres(DataInputStream data, int tamaño) throws IOException{
        StringBuilder palabra=new StringBuilder();
        for (int i = 0; i < tamaño; i++) {
            palabra.append(data.readChar());
        }
        return palabra.toString();
    }
}