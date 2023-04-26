package Codigo;

public class Producto {
    String nombre,id,descripcion;
    double precio, valorImpuesto, total;
    int cantidad;
    Cliente cliente;

    public Producto(String nombre, String id, String descripcion, double precio, double valorImpuesto, double total, int cantidad, Cliente cliente) {
        this.nombre = nombre;
        this.id = cliente.generadorDeId();
        this.descripcion = descripcion;
        this.precio = precio;
        this.valorImpuesto = valorImpuesto;
        this.total = total;
        this.cantidad = cantidad;
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public Producto(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getValorImpuesto() {
        return valorImpuesto;
    }

    public void setValorImpuesto(double valorImpuesto) {
        this.valorImpuesto = valorImpuesto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
