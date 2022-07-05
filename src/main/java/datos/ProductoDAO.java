package datos;

import dominio.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    private static final String SQL_ALL_PRODUCTOS = "SELECT * FROM productos";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM productos WHERE id_producto = ?";
    private static final String SQL_INSERT_PRODUCTO="INSERT INTO productos(nombre,costo,stock) VALUES(?,?,?)";
    private static final String SQL_UPDATE_PRODUCTO = "UPDATE productos SET nombre = ?, costo = ?, stock = ? WHERE id_producto = ?";
    private static final String SQL_DELETE_PRODUCTO = "DELETE FROM productos WHERE id_producto = ?";
    
    public List<Producto> getProductos(){
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Producto> productos = new ArrayList<>();
        try {
            conexion = Conexion.getConexion();
            ps = conexion.prepareStatement(SQL_ALL_PRODUCTOS);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Producto producto = new Producto(rs.getInt("id_producto"),rs.getString("nombre"),rs.getDouble("costo"),rs.getInt("stock"));
                productos.add(producto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(conexion);
        }
        return productos;
    }
    
    public Producto getProducto(Producto producto){
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
       Producto productoObtenido = null;
        try {
            conexion = Conexion.getConexion();
            ps = conexion.prepareStatement(SQL_FIND_BY_ID);
            ps.setInt(1, producto.getIdProducto());
            rs = ps.executeQuery();
            
            while(rs.next()){
                productoObtenido= new Producto(rs.getInt("id_producto"),rs.getString("nombre"),rs.getDouble("costo"),rs.getInt("stock"));
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(conexion);
        }
       return productoObtenido;
    }
    public int insertarProducto(Producto producto){
         Connection conexion = null;
        PreparedStatement ps = null;
        int modificados = 0;
        try {
            conexion = Conexion.getConexion();
            ps = conexion.prepareStatement(SQL_INSERT_PRODUCTO);
            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getCosto());
            ps.setInt(3, producto.getStock());
            modificados = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            
            Conexion.close(ps);
            Conexion.close(conexion);
        }
       return modificados;
    }
    
    public int editarProducto(Producto producto){
         Connection conexion = null;
        PreparedStatement ps = null;
        int modificados = 0;
        try {
            conexion = Conexion.getConexion();
            ps = conexion.prepareStatement(SQL_UPDATE_PRODUCTO);
            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getCosto());
            ps.setInt(3, producto.getStock());
            ps.setInt(4, producto.getIdProducto());
            modificados = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            
            Conexion.close(ps);
            Conexion.close(conexion);
        }
       return modificados;
    }
    
    public int eliminarProducto(Producto producto){
        Connection conexion = null;
        PreparedStatement ps = null;
        int modificados = 0;
        try {
            conexion = Conexion.getConexion();
            ps = conexion.prepareStatement(SQL_DELETE_PRODUCTO);
            ps.setInt(1, producto.getIdProducto());
            
            modificados = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            
            Conexion.close(ps);
            Conexion.close(conexion);
        }
       return modificados;
    }
}
