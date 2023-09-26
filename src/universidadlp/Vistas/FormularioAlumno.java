package universidadlp.Vistas;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import universidadlp.AccesoADatos.AlumnoData;
import universidadlp.Entidades.Alumno;

public class FormularioAlumno extends javax.swing.JInternalFrame {
    
    public FormularioAlumno() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDayChooser1 = new com.toedter.calendar.JDayChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtDocumento = new javax.swing.JTextField();
        jtApellido = new javax.swing.JTextField();
        jtNombre = new javax.swing.JTextField();
        jrEstado = new javax.swing.JRadioButton();
        jbBuscar = new javax.swing.JButton();
        jbNuevo = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jdFechaNac = new com.toedter.calendar.JDateChooser();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("ALUMNO");

        jLabel2.setText("Documento");

        jLabel3.setText("Nombre");

        jLabel4.setText("Apellido");

        jLabel5.setText("Estado");

        jLabel6.setText("Fecha de Nacimiento:");

        jtDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtDocumentoActionPerformed(evt);
            }
        });

        jrEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrEstadoActionPerformed(evt);
            }
        });

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbGuardar.setText("Modificar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jbNuevo)
                        .addGap(27, 27, 27)
                        .addComponent(jbEliminar)
                        .addGap(37, 37, 37)
                        .addComponent(jbGuardar)
                        .addGap(42, 42, 42)
                        .addComponent(jbSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jbBuscar))
                            .addComponent(jrEstado)
                            .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jdFechaNac, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(494, 494, 494))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jbNuevo)
                                    .addComponent(jbEliminar)
                                    .addComponent(jbGuardar)
                                    .addComponent(jbSalir))
                                .addGap(59, 59, 59))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jrEstado)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jdFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrEstadoActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        // Metodo para agregar nuevo Alumno
        Boolean estado = false;
        
        int dni = Integer.parseInt(jtDocumento.getText());
        String apellido = jtApellido.getText();
        String nombre = jtNombre.getText();
        LocalDate fecha = jdFechaNac.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        //por defecto, el estado lo creamos falso, y ahora comprobamos si está activo para colocar bien el estado
        if (jrEstado.isSelected()) {
            estado = true;
        }
        Alumno al = new Alumno(dni, apellido, nombre, fecha, estado);
        JOptionPane.showMessageDialog(null, "Alumno creado Localmente");
        
        AlumnoData alumnodata = new AlumnoData();
        alumnodata.guardarAlumno(al);
        LimpiarCampos();
        

    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // Configuracion del boton "SALIR"

        dispose();
        

    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        //Configuracion del boton "Buscar"
        AlumnoData alumno = new AlumnoData();
        Alumno alumnoActual = new Alumno();
       /* alumnolocal = alumno.buscarAlumno(Integer.parseInt(jtDocumento.getText()));
        
        jtApellido.setText(alumnolocal.getApellido());
        jtNombre.setText(alumnolocal.getNombre());
        jdFechaNac.setDate(Date.from(alumnolocal.getFechaNac().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        jrEstado.setSelected(true);*/
        
       try{
       Integer dni=Integer.parseInt(jtDocumento.getText());
       alumnoActual=alumno.buscarAlumno(dni);
       if(alumnoActual!=null){
           
           jtApellido.setText(alumnoActual.getApellido());
           jtNombre.setText(alumnoActual.getNombre());
           jrEstado.setSelected(alumnoActual.isEstado());
           LocalDate lc=alumnoActual.getFechaNac();
           java.util.Date date=java.util.Date.from(lc.atStartOfDay(ZoneId.systemDefault()).toInstant());
          jdFechaNac.setDate(date);
       }
       
       }catch(NumberFormatException ex){
           JOptionPane.showMessageDialog(this, "Debe ingresar un numero vàlido");
       }
           
           
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        //Configuracion del boton "GUARDAR"
        
        AlumnoData alumno = new AlumnoData ();
        Alumno alumnoActual = new Alumno();
       /* alumnoact=alumnoLocal();
        alumno.actualizarAlumno(alumnoact);*/
       
       try{
           Integer dni=Integer.parseInt(jtDocumento.getText());
           String nombre=jtNombre.getText();
           String apellido=jtApellido.getText();
           if(nombre.isEmpty()|| apellido.isEmpty()){
               
               JOptionPane.showMessageDialog(null, "No puede haber campos vacios");
               return;
           }
           java.util.Date sfecha=jdFechaNac.getDate();
           LocalDate fechaNac=sfecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
           Boolean estado=jrEstado.isSelected();
           
           if(alumnoActual==null){
               alumnoActual=new Alumno(dni,apellido,nombre,fechaNac,estado);
               alumno.guardarAlumno(alumnoActual);
           }else{
               alumnoActual.setDni(dni);
               alumnoActual.setApellido(apellido);
               alumnoActual.setNombre(nombre);
               alumnoActual.setFechaNac(fechaNac);
               alumno.actualizarAlumno(alumnoActual);
           }
           
       }catch(NumberFormatException nfe){
           JOptionPane.showMessageDialog(null, "Debe ingresar un dni vàlido");
       }
               
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        //Configuracion boton "ELIMINAR"
        
        AlumnoData alumno = new AlumnoData ();
       alumno.eliminarAlumno(Integer.parseInt(jtDocumento.getText()));
   
       LimpiarCampos();
       
      // JOptionPane.showMessageDialog(null, "¿Seguro que desea eliminar el alumno?");
          
        
            
        
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jtDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtDocumentoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDayChooser jDayChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbSalir;
    private com.toedter.calendar.JDateChooser jdFechaNac;
    private javax.swing.JRadioButton jrEstado;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtDocumento;
    private javax.swing.JTextField jtNombre;
    // End of variables declaration//GEN-END:variables

    public void LimpiarCampos() {
        jtDocumento.setText("");
        jtApellido.setText("");
        jtNombre.setText("");
        jrEstado.setSelected(true);
        jdFechaNac.setDate(new Date());
       
    }
    
    public Alumno alumnoLocal (){
          Boolean estado = false;
        
        int dni = Integer.parseInt(jtDocumento.getText());
        String apellido = jtApellido.getText();
        String nombre = jtNombre.getText();
        LocalDate fecha = jdFechaNac.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        //por defecto, el estado lo creamos falso, y ahora comprobamos si está activo para colocar bien el estado
        if (jrEstado.isSelected()) {
            estado = true;
        }
        Alumno loc = new Alumno(dni, apellido, nombre, fecha, estado);
        return loc;
    }
}
    
        
