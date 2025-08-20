/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author informatica
 */
public class ZapatoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public List listar() {
        String sql = "call sp_ListarZapato();";
        List<Zapato> listaZapatos = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Zapato zp = new Zapato();
                zp.setCodigoZapato(rs.getInt(1));
                zp.setNombre(rs.getString(2));
                zp.setMarca(rs.getString(3));
                zp.setTalla(rs.getString(4));
                zp.setColor(rs.getString(5));
                listaZapatos.add(zp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaZapatos;
    }

    public int agregar(Zapato zp) {
        String sql = "call sp_AgregarZapato(?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, zp.getNombre());
            ps.setString(2, zp.getMarca());
            ps.setString(3, zp.getTalla());
            ps.setString(4, zp.getColor());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public Zapato listarCodigoZapato(int id) {
        Zapato zapato = null;
        String sql = "call sp_BuscarZapato(?);";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                zapato = new Zapato();
                zapato.setCodigoZapato(rs.getInt(1));
                zapato.setNombre(rs.getString(2));
                zapato.setMarca(rs.getString(3));
                zapato.setTalla(rs.getString(4));
                zapato.setColor(rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return zapato;
    }
    
    public int actualizar(Zapato zp) {
        String sql = "call sp_ActualizarZapato(?, ?, ?, ?, ?);";
        resp = 0;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, zp.getCodigoZapato());
            ps.setString(2, zp.getNombre());
            ps.setString(3, zp.getMarca());
            ps.setString(4, zp.getTalla());
            ps.setString(5, zp.getColor());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }


    public void eliminar(int id) {
        String sql = "call sp_EliminarZapato(" + id + ");";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
