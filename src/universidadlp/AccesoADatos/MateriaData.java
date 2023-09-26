package universidadlp.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadlp.Entidades.Materia;

public class MateriaData {

    private Connection con = null;

    public MateriaData() {
        con = Coneccion.getConexion();
    }

    public void guardarMateria(Materia materia) {
        String sql = "insert into materia (nombre, año, estado)value (?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.isEstado());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia guardada");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia" + ex);
        }
    }

    public Materia buscarMateria(String nombre) {

        String sql = "select idMateria, año, estado from materia where nombre=? and estado=1";
        Materia materia = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nombre);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(nombre);
                materia.setAnioMateria(rs.getInt("año"));
                materia.setEstado(true);

            } else {
                JOptionPane.showMessageDialog(null, "Materia no encontrada");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia" + ex);
        }

        return materia;
    }

    public void eliminarMateria(String nombre) {

        String sql = "UPDATE materia SET estado=0 WHERE nombre=?";

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, nombre);
            int exito = ps.executeUpdate();
            if (exito == 1) {

                JOptionPane.showMessageDialog(null, "Materia eliminada");

            } else {
                JOptionPane.showMessageDialog(null, "Materia no encontrada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al accedeer a la tabla Materia");
        }
    }

    public void modificarMateria(Materia materia) {
        String sql = "UPDATE materia SET nombre=?, año=? WHERE nombre=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setString(3, materia.getNombre());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Materia actualizada");

            } else {
                JOptionPane.showMessageDialog(null, "No existe la Materia");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");

        }
    }
 public List<Materia> listarMaterias() {

        String sql = "SELECT nombre FROM materia WHERE estado=1 ";
        ArrayList<Materia> materias = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               Materia materia = new Materia();
                materia.setNombre(rs.getString("nombre"));
                
                
                materia.setEstado(true);
                
                materias.add(materia);

            } 
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumnos" + ex);
        }
        return materias;
}
 
 
}
