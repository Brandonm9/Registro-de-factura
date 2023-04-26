package Codigo;

public class Vendedor extends Cliente{

    public Vendedor(String nombre, String id) {//, String idVendedor
        super(nombre, id);
    }

    @Override
    public String generadorDeId() {
        return super.generadorDeId();
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

}
