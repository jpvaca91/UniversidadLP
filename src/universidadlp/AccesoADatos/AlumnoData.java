package universidadlp.AccesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static jdk.internal.org.objectweb.asm.commons.GeneratorAdapter.AND;
import org.mariadb.jdbc.Statement;
import universidadlp.Entidades.Alumno;

public class AlumnoData {

    private Connection con = null;

    public AlumnoData() {
        con = Coneccion.getConexion();

    }

    public void guardarAlumno(Alumno alumno) {

        String sql = "INSERT INTO alumno (DNI,apellido,nombre,fechaNacimiento,estado)"
                + "VALUE (?,?,?,?,?)";

        try {
            
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5, alumno.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                alumno.setIdAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Alumno guardado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumnos" + ex);

        }

    }

    public Alumno buscarAlumno(int dni) {

        String sql = "SELECT DNI,apellido,nombre,fechaNacimiento FROM alumno WHERE DNI= ? AND estado=1 ";
        Alumno alumno = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dni);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                alumno = new Alumno();
                alumno.setDni(dni);
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);

            } else {
                JOptionPane.showMessageDialog(null, "No existe el alumno");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumnos" + ex);
        }
        return alumno;
    }

    public void actualizarAlumno(Alumno alumno) {
        String sql = "UPDATE alumno SET DNI=?, apellido=?, nombre=?, fechaNacimiento=?"
                + "WHERE DNI=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setInt(5, alumno.getDni());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Alumno actualizado");

            } else {
                JOptionPane.showMessageDialog(null, "No existe el alumno");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");

        }

    }

    public void eliminarAlumno(int DNI) {
        String sql = "UPDATE alumno SET estado=0 WHERE DNI =?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, DNI);
            int exito = ps.executeUpdate();
            if (exito == 1) {

                JOptionPane.showMessageDialog(null, "Alumno eliminado");

            } else {
                JOptionPane.showMessageDialog(null, "Alumno no encontrado");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro al acceder a la tabla alumno");
        }

    }

    public List<Alumno> listarAlumnos() {

        String sql = "SELECT idAlumno,DNI,apellido,nombre FROM alumno WHERE estado=1 ";
        ArrayList<Alumno> alumnos = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("DNI"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));

                alumno.setEstado(true);

                alumnos.add(alumno);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumnos" + ex);
        }
        return alumnos;
    }

}
