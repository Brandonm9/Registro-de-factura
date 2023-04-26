package Codigo;

public class Cuenta {
    String fecha,id;
    Producto producto;
    Cliente cliente;
    Vendedor vendedor;

    public Cuenta(String fecha, String id, Producto producto, Cliente cliente, Vendedor vendedor) {
        this.fecha = fecha;
        this.producto = producto;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.id = id;
    }

    public Cuenta(String fecha, Cliente cliente, String id) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.id = cliente.generadorDeId();
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}
