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
 * @author needa
 */
public class clsAuditoria {
    
    private int id;
    private String comentarios;
    private Boolean estado;
    private clsTesis tesis;
    private clsHorario horario;
    
    public static int generarCodigo() throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "SELECT COALESCE(MAX(id),0) + 1 FROM auditoria";
            ResultSet rs = con.createStatement().executeQuery(strSQL);
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static clsAuditoria buscar(int id) throws Exception{
        try(Connection con = clsJDBC.getConexion()){
            String strSQL = "SELECT * FROM auditoria WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                clsAuditoria objA = new clsAuditoria();
                objA.setId(id);
                objA.setComentarios(rs.getString(2));
                objA.setEstado(rs.getBoolean(3));                
                objA.setTesis(clsTesis.buscar(rs.getInt(4)));
                objA.setHorario(clsHorario.buscar(rs.getInt(5)));
                return objA;
            }else{
                return null;
            }
        }catch(Exception e){
            throw new Exception("Error al buscar Auditoria");
        }
    }
    
    public void registrar() throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "INSERT INTO auditoria VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, this.id);
            ps.setString(2, this.comentarios);
            ps.setBoolean(3, this.estado);            
            ps.setInt(4, this.tesis.getId());           
            ps.setInt(5, this.horario.getId());           
            ps.execute();
        } catch (Exception e) {
            throw new Exception("Error al registrar Auditoria");
        }
    }
    
    public static void Eliminar(int id) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "DELETE FROM auditoria WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al eliminar Auditoria");
        }
    }
    
    public static ArrayList<clsAuditoria> listar() throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            ArrayList<clsAuditoria> lista = new ArrayList<>();
            String strSQL = "SELECT * FROM auditoria";
            ResultSet rs = con.createStatement().executeQuery(strSQL);
            while (rs.next()) {
                clsAuditoria objA = new clsAuditoria();
                objA.setId(rs.getInt(1));
                objA.setComentarios(rs.getString(2));
                objA.setEstado(rs.getBoolean(3));                
                objA.setTesis(clsTesis.buscar(rs.getInt(4)));
                objA.setHorario(clsHorario.buscar(rs.getInt(5)));               
                lista.add(objA);
            }
            return lista;
        } catch (Exception e) {
            throw new Exception("Error al listar Auditoria");
        }
    }
    
    public void modificar(clsAuditoria objA) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "UPDATE auditoria SET comentarios = ?, estado = ?, id_Tesis = ?, id_Horario = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setString(1, objA.getComentarios());
            ps.setBoolean(2, objA.getEstado());
            ps.setInt(3, objA.getTesis().getId());  
            ps.setInt(4, objA.getHorario().getId());                       
            ps.setInt(5, id);
            ps.execute();          
        } catch (Exception e) {
            throw new Exception("Error al modificar Auditoria");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public clsTesis getTesis() {
        return tesis;
    }

    public void setTesis(clsTesis tesis) {
        this.tesis = tesis;
    }

    public clsHorario getHorario() {
        return horario;
    }

    public void setHorario(clsHorario horario) {
        this.horario = horario;
    }
    
    
    
}
