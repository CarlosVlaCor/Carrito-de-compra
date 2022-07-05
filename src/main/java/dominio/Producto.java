
package dominio;

public class Producto {
    private int idProducto;
    private String nombre;
    private double costo;
    private int stock;

    public Producto() {
    }

    public Producto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    public Producto(int id_producto, String nombre, double precio, int stock) {
        this.idProducto = id_producto;
        this.nombre = nombre;
        this.costo = precio;
        this.stock = stock;
    }

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.costo = precio;
        this.stock = stock;
    }

    public Producto(int id_producto, String nombre, double precio) {
        this.idProducto = id_producto;
        this.nombre = nombre;
        this.costo = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
}
