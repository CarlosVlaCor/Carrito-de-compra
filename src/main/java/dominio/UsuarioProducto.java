/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author carlo
 */
public class UsuarioProducto {
    private int id;
    private String fecha;
    private int cantidad;
    private boolean comprado;
    private Producto producto;
    private Usuario usuario;

    public UsuarioProducto() {
    }

    public UsuarioProducto(int id, String fecha, int cantidad, boolean comprado, Producto idProducto, Usuario idUsuario) {
        this.id = id;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.comprado = comprado;
        this.producto = idProducto;
        this.usuario = idUsuario;
    }

    public UsuarioProducto(String fecha, int cantidad, boolean comprado, Producto idProducto, Usuario idUsuario) {
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.comprado = comprado;
        this.producto = idProducto;
        this.usuario = idUsuario;
    }

    public UsuarioProducto(int id, String fecha, int cantidad, boolean comprado, Producto producto) {
        this.id = id;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.comprado = comprado;
        this.producto = producto;
    }

    public UsuarioProducto(int id, int cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }
    public UsuarioProducto(int id) {
        this.id = id;
        
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto idProducto) {
        this.producto = idProducto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario idUsuario) {
        this.usuario = idUsuario;
    }

    @Override
    public String toString() {
        return "UsuarioProducto{" + "id=" + id + ", fecha=" + fecha + ", cantidad=" + cantidad + ", comprado=" + comprado + ", idProducto=" + producto + ", idUsuario=" + usuario + '}';
    }
    
    
}
