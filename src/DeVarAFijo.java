
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 *
 * @author Alfonso Valenzuela Rivero
 */
public class DeVarAFijo {

    public static void main(String[] args) {
        byte edad;
        boolean ff;
        String strNombre;
        StringBuilder nombreFijo;
        final byte TAMAÑOUTF=30;
        try {
            DataInputStream lecturaVar=new DataInputStream(new FileInputStream("Ficheros/FichData.dat".replace("/", File.separator)));
            DataOutputStream escrituraFijo=new DataOutputStream(new FileOutputStream("Ficheros/FichDataFijo.dat".replace("/", File.separator)));
            ff=false;
            while(!ff){
                //Aqui cambio de variable a fijo el nombre
                strNombre=lecturaVar.readUTF();//leo lo que quiero cambiar
                nombreFijo=new StringBuilder(strNombre);//creo stringbuilder
                nombreFijo.setLength(TAMAÑOUTF);//cambio el tamaño a 30(fijo)
                escrituraFijo.writeChars(nombreFijo.toString());
                //La edad simplemente la leo ya que no es un dato  variable
                edad=lecturaVar.readByte();
                //Aquí escribo en el fichero
                escrituraFijo.writeChars(strNombre);
                escrituraFijo.writeByte(edad);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error al encontrar el archivo");
        } catch (IOException ex) {
            System.out.println("Error al leer el archivo");
        }
    }
}