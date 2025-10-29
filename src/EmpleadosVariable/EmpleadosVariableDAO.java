package EmpleadosVariable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 *
 * @author Alfonso Valenzuela Rivero
 */
public class EmpleadosVariableDAO {

    private static boolean ff = false;

    public static Empleado leer(DataInputStream data) throws IOException, EOFException {
        Empleado empleado;
        empleado=null;
        try {
            int id = data.readInt();
            String nombre = data.readUTF();
            String apellidos = data.readUTF();
            float sueldo = data.readFloat();
            empleado=new Empleado(id, nombre, apellidos, sueldo);
        } catch (EOFException eof) {
            ff=true;
        }
        return empleado;
    }

    public static void escribir(DataOutputStream data, Empleado reg) throws IOException {
        data.writeInt(reg.getId());
        data.writeUTF(reg.getNombre());
        data.writeUTF(reg.getApellidos());
        data.writeFloat(reg.getSueldo());
    }

    public static boolean getFf() {
        return ff;
    }

    public static String cadenaFijo(String nomOApes, int tamaño) throws IndexOutOfBoundsException {
        String nomOApesFijo;
        StringBuilder nom = new StringBuilder(nomOApes);
        nom.setLength(tamaño);
        nomOApesFijo = nom.toString();
        return nomOApesFijo;
    }
}