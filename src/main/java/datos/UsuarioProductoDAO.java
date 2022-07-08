/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.Producto;
import dominio.Usuario;
import dominio.UsuarioProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlo
 */
public class UsuarioProductoDAO {

    private static final String SQL_INSERT = "INSERT INTO tbl_productos_usuarios(fecha_compra,comprado,id_producto,id_usuario,cantidad) "
            + "VALUES(?,?,?,?,?)";
    private static final String SQL_FIND_ALL = "SELECT * FROM tbl_productos_usuarios  INNER JOIN productos ON tbl_productos_usuarios.id_producto = productos.id_producto "
            + "WHERE tbl_productos_usuarios.id_usuario = ?";
    private static final String SQL_UPDATE = "UPDATE tbl_productos_usuarios SET cantidad = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_productos_usuarios WHERE id = ?";
    private static final String SQL_FIND_BY_ID_PRDOCUTO = "SELECT id,cantidad FROM tbl_productos_usuarios WHERE id_producto = ? ";

    public int insertarProductoUsuario(UsuarioProducto usuarioProducto) {
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int modificados = 0;
        try {
            conexion = Conexion.getConexion();
            ps = conexion.prepareStatement(SQL_FIND_BY_ID_PRDOCUTO);
            ps.setInt(1, usuarioProducto.getProducto().getIdProducto());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                int cantidad = rs.getInt("cantidad");
                int id = rs.getInt("id");
               
                cantidad += usuarioProducto.getCantidad();
            
                ps = conexion.prepareStatement(SQL_UPDATE);
                ps.setInt(1, cantidad);
                ps.setInt(2, id);
               
               modificados=ps.executeUpdate();

            } else {
                ps = conexion.prepareStatement(SQL_INSERT);
                ps.setString(1, usuarioProducto.getFecha());
                ps.setBoolean(2, usuarioProducto.isComprado());
                ps.setInt(3, usuarioProducto.getProducto().getIdProducto());
                ps.setInt(4, usuarioProducto.getUsuario().getIdUsuario());
                ps.setInt(5, usuarioProducto.getCantidad());
                modificados = ps.executeUpdate();
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(conexion);
        }
        return modificados;
    }

    public List<UsuarioProducto> getUsuarioProductos(Usuario usuario) {
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Producto producto = null;
        UsuarioProducto usuarioProducto = null;
        List<UsuarioProducto> productosUsuario = new ArrayList<>();
        try {
            conexion = Conexion.getConexion();
            ps = conexion.prepareStatement(SQL_FIND_ALL);
            ps.setInt(1, usuario.getIdUsuario());
            rs = ps.executeQuery();

            while (rs.next()) {
                producto = new Producto(rs.getString("nombre"), rs.getDouble("costo"), rs.getInt("stock"));
                usuarioProducto = new UsuarioProducto(rs.getInt("id"), rs.getString("fecha_compra"), rs.getInt("cantidad"), rs.getBoolean("comprado"), producto);
                productosUsuario.add(usuarioProducto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(conexion);
        }
        return productosUsuario;
    }

    public int modificarUsuarioProducto(UsuarioProducto usuarioProducto) {
        Connection conexion = null;
        PreparedStatement ps = null;
        int modificados = 0;
        try {
            conexion = Conexion.getConexion();
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setInt(1, usuarioProducto.getCantidad());
            ps.setInt(2,usuarioProducto.getId());
            modificados = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(ps);
            Conexion.close(conexion);
        }
        return modificados;
    }

    public int eliminarUsuarioProducto(UsuarioProducto usuarioProducto) {
        Connection conexion = null;
        PreparedStatement ps = null;
        int modificados = 0;
        try {
            conexion = Conexion.getConexion();
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, usuarioProducto.getId());
            modificados = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(ps);
            Conexion.close(conexion);
        }
        return modificados;
    }
}
