package universidadlp.AccesoADatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadlp.Entidades.Inscripcion;

public class InscripcionData {
    
    private Connection con = null;
    
    public void InscripcionData() {
        this.con = Coneccion.getConexion();
        
    }
    
    public void guardarInscripcion(Inscripcion insc) {
        
        String sql = "INSTER INTO inscripcion (idAlumno,idMateria,nota) VALUE(?,?,?)";
        
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
    
        public void actualizarNota(int idAlumno, int idMateria, double nota){
            String sql="UPDATE inscripcion SET nota=? WHERE idAlumno=? AND idMateria=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            
            int filas=ps.executeUpdate();
            
            if(filas>0){
              JOptionPane.showMessageDialog(null, "Nota actualizada");
            }           
        } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
            
        }
     }
