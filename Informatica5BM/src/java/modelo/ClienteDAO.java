package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public List listar() {
        String sql = "call sp_ListarCliente()";
        List<Cliente> listaClientes = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setCodigoCliente(rs.getInt(1));
                cl.setCodigoZapato(rs.getInt(2));
                cl.setNombre(rs.getString(3));
                cl.setTelefono(rs.getString(4));
                cl.setCorreo(rs.getString(5));
                cl.setDireccion(rs.getString(6));
                listaClientes.add(cl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaClientes;
    }
    
    public int agregar(Cliente cl) {
        String sql = "call sp_AgregarCliente(?, ?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cl.getCodigoZapato());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getTelefono());
            ps.setString(4, cl.getCorreo());
            ps.setString(5, cl.getDireccion());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    public Cliente listarCodigoCliente(int id) {
        Cliente cliente = null;
        String sql = "call sp_BuscarCliente(?);";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setCodigoCliente(rs.getInt(1));
                cliente.setCodigoZapato(rs.getInt(2));
                cliente.setNombre(rs.getString(3));
                cliente.setTelefono(rs.getString(4));
                cliente.setCorreo(rs.getString(5));
                cliente.setDireccion(rs.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }
    
    public int actualizar(Cliente cl) {
        String sql = "call sp_ActualizarCliente(?, ?, ?, ?, ?, ?);";
        resp = 0;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cl.getCodigoCliente());
            ps.setInt(2, cl.getCodigoZapato());
            ps.setString(3, cl.getNombre());
            ps.setString(4, cl.getTelefono());
            ps.setString(5, cl.getCorreo());
            ps.setString(6, cl.getDireccion());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    public void eliminar(int id) {
        String sql = "call sp_EliminarCliente(" + id + ");";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
