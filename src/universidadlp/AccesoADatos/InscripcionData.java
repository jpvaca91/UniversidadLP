package universidadlp.AccesoADatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadlp.Entidades.Alumno;
import universidadlp.Entidades.Inscripcion;
import universidadlp.Entidades.Materia;

public class InscripcionData {

    private Connection con = null;
    private MateriaData md = new MateriaData();
    private AlumnoData ad = new AlumnoData();

    public void InscripcionData() {
        this.con = Coneccion.getConexion();

    }

    public void guardarInscripcion(Inscripcion insc) {

        String sql = "INSERT INTO inscripcion (idAlumno,idMateria,nota) VALUES(?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, insc.getAlumno().getIdAlumno());
            ps.setInt(2, insc.getMateria().getIdMateria());
            ps.setDouble(3, insc.getNota());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripcion Registrada");

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion");
        }
    }

    public void actualizarNota(int idAlumno, int idMateria, double nota) {
        String sql = "UPDATE inscripcion SET nota=? WHERE idAlumno=? AND idMateria=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Nota actualizada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }

    }

    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
        String sql = "DELETE FROM inscripcion WHERE idAlumno=? AND idMateria=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Inscripcion borrada");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");

        }
    }

    public List<Inscripcion> obtenerInscripciones() {
        ArrayList<Inscripcion> cursadas = new ArrayList<>();

        String sql = "SELECT * FROM inscripcion";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion insc = new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripto"));
                Alumno alu = ad.buscarAlumno(rs.getInt("idAlumno"));
                Materia mat = md.buscarMateria(rs.getString("idMateria"));
                insc.setAlumno(alu);
                insc.setMateria(mat);
                insc.setNota(rs.getDouble("nota"));
                cursadas.add(insc);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");

        }
        return cursadas;
    }

    public List<Inscripcion> obtenerInscripcionesPorAlumno() {
        ArrayList<Inscripcion> cursadas = new ArrayList<>();

        String sql = "SELECT * FROM inscripcion WHERE idAlumno=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            int idAlumno = 0;
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion insc = new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripto"));
                Alumno alu = ad.buscarAlumno(rs.getInt("idAlumno"));
                Materia mat = md.buscarMateria(rs.getString("idMateria"));
                insc.setAlumno(alu);
                insc.setMateria(mat);
                insc.setNota(rs.getDouble("nota"));
                cursadas.add(insc);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");

        }
        return cursadas;
    }

    public List<Materia> obtenerMateriasCursadas(int idAlumno) {
        ArrayList<Materia> materias = new ArrayList<>();

        String sql = "SELECT inscripcion.idMateria, nombre, año FROM inscripcion,"
                + "materia WHERE inscripcion.idMateria=materia.idMateria"
                + "AND inscripcion.idAlumno=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materias.add(materia);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }

        return materias;

    }

    public List<Materia> obtenerMateriasNOCursadas(int idAlumno) {
        List<Materia> materias = new ArrayList<>();
       
        String sql = "SELECT idMateria,nombre,año FROM materia WHERE estado= 1 AND idMateria not in "
                + "(SELECT idMateria FROM inscripcion WHERE idAlumno =?) ";
        Materia materia = null;
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            JOptionPane.showMessageDialog(null, "Hasta corre bien ");
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materias.add(materia);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
        return materias;
    }

    public List<Alumno> obtenerAlumnoPorMateria(int idMateria) {
        ArrayList<Alumno> alumnoMateria = new ArrayList<>();
        String sql = "SELECT a.idAlumno, DNI, apellido, nombre, fechaNacimiento, estado"
                + "FROM inscripcion i, alumno a WHERE i.idAlumno=a.idAlumno AND idMateria=? AND a.estado=1";

        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, idMateria);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
                alumnoMateria.add(alumno);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
        return alumnoMateria;
    }
}
