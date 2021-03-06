/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Registro;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Libro;

/**
 *
 * @author Julio
 */
public class Listar extends javax.swing.JFrame {

    /**
     * Creates new form Agregar
     */
    public Listar() {
        initComponents();
        llenarTabla(this.librosTabla);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        codigoTextBox = new javax.swing.JTextField();
        buscarButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        librosTabla = new javax.swing.JTable();
        eliminarButton = new javax.swing.JButton();
        modificarButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Buscar por código de libro");

        buscarButton.setText("Buscar");
        buscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarButtonActionPerformed(evt);
            }
        });

        librosTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(librosTabla);

        eliminarButton.setText("Eliminar");
        eliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarButtonActionPerformed(evt);
            }
        });

        modificarButton.setText("Modificar");
        modificarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Listar libros");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(eliminarButton)
                .addGap(37, 37, 37)
                .addComponent(modificarButton)
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(codigoTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(buscarButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarButton))
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminarButton)
                    .addComponent(modificarButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarButtonActionPerformed
        String codigo = this.codigoTextBox.getText();
        Registro controlador = new Registro();
        if(controlador.borrar(codigo)){
            llenarTabla(this.librosTabla);
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");
        }
        else
            JOptionPane.showMessageDialog(null, "Hubo un error al intentar eliminar");
    }//GEN-LAST:event_eliminarButtonActionPerformed

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButtonActionPerformed
        String codigo = this.codigoTextBox.getText();
        mostrarUnLibro(this.librosTabla, codigo);
    }//GEN-LAST:event_buscarButtonActionPerformed

    private void modificarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarButtonActionPerformed
        String codigo = this.codigoTextBox.getText();
        Registro controlador = new Registro();
        Libro libro = controlador.buscar(codigo);
        if(libro != null){
            Modificar modificar = new Modificar(codigo);
            modificar.setVisible(true);
        }
        else
            JOptionPane.showMessageDialog(null, "El código del libro no existe en los registros");
        
    }//GEN-LAST:event_modificarButtonActionPerformed

    private void mostrarUnLibro(JTable lista, String codigo) {
        if (codigo.equals("")) {
            llenarTabla(lista);
        } else {
            Registro controlador = new Registro();
            DefaultTableModel modeloTabla = new DefaultTableModel();
            lista.setModel(modeloTabla);

            modeloTabla.addColumn("Codigo");
            modeloTabla.addColumn("ISBN");
            modeloTabla.addColumn("Nombre Libro");
            modeloTabla.addColumn("Ejemplares");
            modeloTabla.addColumn("Genero");
            modeloTabla.addColumn("Tema");
            modeloTabla.addColumn("Autor");
            modeloTabla.addColumn("Nacionalidad Autor");
            modeloTabla.addColumn("Editorial");
            modeloTabla.addColumn("Tipo Lector");

            Object[] columna = new Object[10];
            Libro libro = controlador.buscar(codigo);
            if (libro != null) {
                columna[0] = libro.getCodigo();
                columna[1] = libro.getIsnb();
                columna[2] = libro.getNombreLibro();
                columna[3] = libro.getNumEjemplares();
                columna[4] = libro.getGenero();
                columna[5] = libro.getTema();
                columna[6] = libro.getNombreAutor();
                columna[7] = libro.getNacionalidadAutor();
                columna[8] = libro.getNombreEditorial();
                columna[9] = libro.getTipoLector();
                modeloTabla.addRow(columna);
            } else {
                JOptionPane.showMessageDialog(null, "No existen libros registrado con ese código");
            }
        }
    }

    private void llenarTabla(JTable lista) {
        Registro controlador = new Registro();
        DefaultTableModel modeloTabla = new DefaultTableModel();
        lista.setModel(modeloTabla);

        modeloTabla.addColumn("Codigo");
        modeloTabla.addColumn("ISBN");
        modeloTabla.addColumn("Nombre Libro");
        modeloTabla.addColumn("Ejemplares");
        modeloTabla.addColumn("Genero");
        modeloTabla.addColumn("Tema");
        modeloTabla.addColumn("Autor");
        modeloTabla.addColumn("Nacionalidad Autor");
        modeloTabla.addColumn("Editorial");
        modeloTabla.addColumn("Tipo Lector");

        Object[] columna = new Object[10];
        List<Libro> libros = controlador.listar();
        int cantidadLibros = libros.size();
        for (int x = 0; x < cantidadLibros; x++) {
            columna[0] = libros.get(x).getCodigo();
            columna[1] = libros.get(x).getIsnb();
            columna[2] = libros.get(x).getNombreLibro();
            columna[3] = libros.get(x).getNumEjemplares();
            columna[4] = libros.get(x).getGenero();
            columna[5] = libros.get(x).getTema();
            columna[6] = libros.get(x).getNombreAutor();
            columna[7] = libros.get(x).getNacionalidadAutor();
            columna[8] = libros.get(x).getNombreEditorial();
            columna[9] = libros.get(x).getTipoLector();
            modeloTabla.addRow(columna);

        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton buscarButton;
    public javax.swing.JTextField codigoTextBox;
    public javax.swing.JButton eliminarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable librosTabla;
    public javax.swing.JButton modificarButton;
    // End of variables declaration//GEN-END:variables
}
