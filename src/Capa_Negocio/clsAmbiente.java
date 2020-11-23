/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_Negocio;

import Capa_Datos.clsJDBC;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class clsAmbiente {

    private int id;
    private String nombre;
    private String descripcion;
    private String estado;
    
    public static int generarCodigo() throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "SELECT COALESCE(MAX(id),0) + 1 FROM ambiente";
            ResultSet rs = con.createStatement().executeQuery(strSQL);
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public static ArrayList<clsAmbiente> buscar(String nombre) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            ArrayList<clsAmbiente> lista = new ArrayList<>();
            String strSQL = "SELECT * FROM ambiente WHERE nombre ilike ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setString(1,"%" + nombre + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                clsAmbiente objA = new clsAmbiente();
                objA.setId(rs.getInt(1));
                objA.setNombre(rs.getString(2));
                objA.setDescripcion(rs.getString(3));
                objA.setEstado(rs.getString(4));
                lista.add(objA);
            }
            return lista;
        } catch (Exception e) {
            throw new Exception("Error al buscar Ambiente");
        }
    }
    
    public static ArrayList<clsAmbiente> listar() throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            ArrayList<clsAmbiente> lista = new ArrayList<>();
            String strSQL = "SELECT * FROM ambiente";
            PreparedStatement ps = con.prepareStatement(strSQL);           
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                clsAmbiente objA = new clsAmbiente();
                objA.setId(rs.getInt(1));
                objA.setNombre(rs.getString(2));
                objA.setDescripcion(rs.getString(3));
                objA.setEstado(rs.getString(4));
                lista.add(objA);
            }
            return lista;
        } catch (Exception e) {
            throw new Exception("Error al listar Ambiente");
        }
    }
    
    public static clsAmbiente buscar(int id) throws Exception{
        try(Connection con = clsJDBC.getConexion()){
            String strSQL = "SELECT * FROM ambiente WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                clsAmbiente objA = new clsAmbiente();
                objA.setId(id);
                objA.setNombre(rs.getString(2));
                objA.setDescripcion(rs.getString(3));
                objA.setEstado(rs.getString(4));              
                return objA;
            }else{
                return null;
            }
        }catch(Exception e){
            throw new Exception("Error al buscar Ambiente");
        }
    }    
    
    public void registrar() throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "INSERT INTO ambiente VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, this.id);
            ps.setString(2, this.nombre);
            ps.setString(3, this.descripcion);
            ps.setString(4, this.estado);
            ps.execute();
        } catch (Exception e) {
            //"Error al registrar Ambiente"
            throw new Exception(e.getMessage());
        }
    }
    
    public static void Eliminar(int id) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "DELETE FROM ambiente WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al eliminar Ambiente");
        }
    }
    
    public void modificar(clsAmbiente objA) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "UPDATE ambiente SET nombre = ?, descripcion = ?, estado = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setString(1, objA.getNombre());
            ps.setString(2, objA.getDescripcion());
            ps.setString(3, objA.getEstado());
            ps.setInt(4, id);
            ps.execute();
        } catch (Exception e) {
            throw new Exception("Error al modificar ambiente");
        }
    }
    
    public static void darBaja(int id) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "UPDATE ambiente SET estado = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setString(1, "I");
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al dar baja Ambiente");
        }
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof clsAmbiente) {
            clsAmbiente aux = (clsAmbiente) obj;
            return aux.getId()== id;
        }
        return false;
    }
    
}
