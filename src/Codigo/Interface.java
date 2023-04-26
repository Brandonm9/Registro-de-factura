package Codigo;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Interface extends JFrame {
    public Interface() {
        super("Recibo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel principal
        JPanel panel = new JPanel(new GridBagLayout());

        // Etiquetas
        JLabel nombreCompradorLbl = new JLabel("Nombre del comprador:");
        JLabel nombreVendedorLbl = new JLabel("Nombre del vendedor:");
        JLabel fechaLbl = new JLabel("Fecha:");
        JLabel nombreProductoLbl = new JLabel("Nombre del producto:");
        JLabel precioProductoLbl = new JLabel("Precio del producto:");
        JLabel cantidadLbl = new JLabel("Cantidad:");

        // Campos de texto
        JTextField nombreCompradorTxt = new JTextField(20);
        JTextField nombreVendedorTxt = new JTextField(20);
        JTextField fechaTxt = new JTextField(20);
        JTextField nombreProductoTxt = new JTextField(20);
        JTextField precioProductoTxt = new JTextField(20);
        JTextField cantidadTxt = new JTextField(20);

        // Botones
        JButton finalizarBtn = new JButton("Finalizar");
        JButton agregarBtn = new JButton("Agregar");

        List<Producto> productos = new ArrayList<>();
        List<Producto> listaPrecios = new ArrayList<>();

        // Agregar componentes al panel
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_END;
        c.insets = new Insets(5, 5, 5, 5);
        panel.add(nombreCompradorLbl, c);

        c.gridy = 1;
        panel.add(nombreVendedorLbl, c);

        c.gridy = 2;
        panel.add(fechaLbl, c);

        c.gridy = 3;
        panel.add(nombreProductoLbl, c);

        c.gridy = 4;
        panel.add(precioProductoLbl, c);

        c.gridy = 5;
        panel.add(cantidadLbl, c);

        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        panel.add(nombreCompradorTxt, c);

        c.gridy = 1;
        panel.add(nombreVendedorTxt, c);

        c.gridy = 2;
        panel.add(fechaTxt, c);

        c.gridy = 3;
        panel.add(nombreProductoTxt, c);

        c.gridy = 4;
        panel.add(precioProductoTxt, c);

        c.gridy = 5;
        panel.add(cantidadTxt, c);

        c.gridx = 0;
        c.gridy = 6;
        c.anchor = GridBagConstraints.LINE_END;
        panel.add(finalizarBtn, c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.LINE_START;
        panel.add(agregarBtn, c);

        // Agregar panel al frame
        getContentPane().add(panel, BorderLayout.CENTER);

        // Ajustar tamaño y mostrar el frame
        pack();
        setVisible(true);

        finalizarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nombreCompradorTxt.getText();
                String sellerName = nombreVendedorTxt.getText();
                String date = fechaTxt.getText();
                String productName = nombreProductoTxt.getText();
                double productPrice = Double.parseDouble(precioProductoTxt.getText());
                int productQuantity = Integer.parseInt(cantidadTxt.getText());

                Cliente cliente = new Cliente(name, "");
                Vendedor vendedor = new Vendedor(sellerName, "");
                Cuenta cuenta = new Cuenta(date, "", null, null, null);
                Producto productoslist = new Producto(productName, productQuantity);
                productos.add(productoslist);
                Producto preciosProductos = new Producto(productPrice * productQuantity);
                listaPrecios.add(preciosProductos);

                try {
                    FileWriter fw = new FileWriter("recibo.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);

                    //bw.write(nombreComprador + ";" + nombreVendedor + ";" + fecha + ";" + nombreProducto + ";" + precioProducto + ";" + cantidad);
                    bw.write("Id del recibo: " + cuenta.getId() + " Fecha de emision de este recibo: " + cuenta.getFecha());
                    bw.newLine();
                    bw.write("Nombre del vendedor: " + vendedor.getNombre() + " Id del vendedor: " + vendedor.getId() + "\n");
                    bw.write("Nombre del comprador: " + cliente.getNombre() + " Id del comprador: " + cliente.getId() + "\n");
                    bw.write("Nombre de productos   Cantidad    Precio\n");
                    for (int i = 0; i < productos.size(); i++) {
                        bw.write(productos.get(i).getNombre() + "    " );
                        bw.write(productos.get(i).getCantidad() + "  " + listaPrecios.get(i).getPrecio() + "\n");
                    }
                    double total = 0;
                    for (Producto precioProducto : listaPrecios) {
                        total += precioProducto.getPrecio();
                    }

                    bw.write("Total: " + total + "\n");



                    JOptionPane.showMessageDialog(panel,"Se completo con exito");

                    bw.close();
                    fw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });

        agregarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productName = nombreProductoTxt.getText();
                double productPrice;
                int productQuantity;
                try {
                    productPrice = Double.parseDouble(precioProductoTxt.getText());
                    productQuantity = Integer.parseInt(cantidadTxt.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "El valor y la cantidad deben ser números válidos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Producto productoslist = new Producto(productName, productQuantity);
                productos.add(productoslist);
                Producto preciosProductos = new Producto(productPrice * productQuantity);
                listaPrecios.add(preciosProductos);
                nombreProductoTxt.setText("");
                precioProductoTxt.setText("");
                cantidadTxt.setText("");
            }
        });

    }
}