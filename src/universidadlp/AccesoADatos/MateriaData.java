
package universidadlp.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadlp.Entidades.Materia;


public class MateriaData {
     private Connection con = null;

    public MateriaData() {
        con = Coneccion.getConexion();
    }
    
    
    public void guardarMateria (Materia materia){
        String sql= "insert into materia (nombre, año, estado)value (?,?,?)";
        
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
    
    public Materia buscarMateria(String nombre){
        
        String sql="select idMateria, año, estado from materia where nombre=? and estado=1";
        Materia materia=null;
         try {
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ps.setString(1, nombre);
             
             ResultSet rs= ps.executeQuery(sql);
             if(rs.next()){
                 materia= new Materia();
                 materia.setIdMateria(rs.getInt("idMateria"));
                 materia.setNombre(nombre);
                 materia.setAnioMateria(rs.getInt("año"));
                 materia.setEstado(true);
                 
             }ps.close();
             
             
             
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia" + ex);
         }
        
             
        
     return materia;   
    }
    
    
}
