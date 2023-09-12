
package universidadlp.AccesoADatos;

import java.sql.Connection;
import universidadlp.Entidades.Alumno;

public class AlumnoData {
  private Connection con=null;
public AlumnoData(){
    con=Coneccion.getConexion();

}
public void guardarAlumno(Alumno alumno){
    String sql= "INSERT INTO alumno (DNI,apellido,nombre,fechaNacimiento,estado)"
            + "VALUE (?,?,?,?,?)";
      
}      
}
