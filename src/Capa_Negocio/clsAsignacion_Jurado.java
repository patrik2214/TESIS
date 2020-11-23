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
public class clsAsignacion_Jurado {
    
    private int id;
    private clsTesis tesis;
    private clsDocente docente;
    
    public static int generarCodigo() throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "SELECT COALESCE(MAX(id),0) + 1 FROM asignacion_jurado";
            ResultSet rs = con.createStatement().executeQuery(strSQL);
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            throw e;
        }
    }

    public void Registrar() throws Exception {

        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "INSERT INTO asignacion_jurado VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, this.id);
            ps.setInt(2, this.tesis.getId());
            ps.setInt(3, this.docente.getId());          
            ps.execute();
        } catch (Exception e) {
            throw new Exception("Error al registrar Asignación de Jurado");
        }
    }

    public static clsAsignacion_Jurado buscar(int id) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "SELECT * FROM asignacion_jurado WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                clsAsignacion_Jurado objA = new clsAsignacion_Jurado();
                objA.setId(rs.getInt(1));
                objA.setTesis(clsTesis.buscar(rs.getInt(2)));
                objA.setDocente(clsDocente.buscar(rs.getInt(3)));                                            
                return objA;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage() + " Error al buscar Asignación de Jurado");
        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public clsTesis getTesis() {
        return tesis;
    }

    public void setTesis(clsTesis tesis) {
        this.tesis = tesis;
    }

    public clsDocente getDocente() {
        return docente;
    }

    public void setDocente(clsDocente docente) {
        this.docente = docente;
    }
    
    
    
}
