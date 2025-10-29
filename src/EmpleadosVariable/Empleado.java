
package EmpleadosVariable;

/**
 *
 * @author Alfonso Valenzuela Rivero
 */
public class Empleado {
    private int id;
    private String nombre;
    private String apellidos;
    private float sueldo;

    public Empleado(int id, String nombre, String apellidos, float sueldo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sueldo = sueldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }
    
    @Override
    public String toString() {
        return this.id+" "+this.nombre+" "+this.apellidos+" "+this.sueldo;
    }
    
}
