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
public class clsSustentacion {

    private int id;
    private Date fecha;
    private Time hora_inicio;
    private Time hora_fin;
    private String calificacion;
    private String comentarios;
    private String decision;
    private Boolean estado;
    private clsAmbiente ambiente;

    public static int generarCodigo() throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "SELECT COALESCE(MAX(id),0) + 1 FROM sustentacion";
            ResultSet rs = con.createStatement().executeQuery(strSQL);
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            throw e;
        }
    }

    public static clsSustentacion buscar(int id) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "SELECT * FROM sustentacion WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                clsSustentacion objS = new clsSustentacion();
                objS.setId(rs.getInt(1));
                objS.setFecha(rs.getDate(2));
                objS.setHora_inicio(rs.getTime(3));
                objS.setHora_fin(rs.getTime(4));
                objS.setCalificacion(rs.getString(5));
                objS.setComentarios(rs.getString(6));
                objS.setDecision(rs.getString(7));
                objS.setEstado(rs.getBoolean(8));
                objS.setAmbiente(clsAmbiente.buscar(rs.getInt(9)));
                return objS;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage() + " Error al buscar Sustentacion");
        }
    }

    public void registrar(int alumnoid) throws Exception {
        Connection con = clsJDBC.getConexion();
        try {
            con.setAutoCommit(false);
            String strSQL = "INSERT INTO sustentacion VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, this.id);
            ps.setDate(2, this.fecha);
            ps.setTime(3, this.hora_inicio);
            ps.setTime(4, this.hora_fin);
            ps.setString(5, this.calificacion);
            ps.setString(6, this.comentarios);
            ps.setString(7, this.decision);
            ps.setBoolean(8, this.estado);
            ps.setInt(9, this.ambiente.getId());
            ps.execute();
            
            // Agregar sustentacion a la tesis
            clsTesis tesis = clsTesis.buscar(alumnoid);
            String subSQL = "UPDATE tesis SET id_sustentacion = ? WHERE id_alumno = ?";
            PreparedStatement subps = con.prepareStatement(subSQL);
            subps.setInt(1, id);
            subps.setInt(2, alumnoid);
            subps.execute();
        } catch (Exception e) {
            con.rollback();
            throw new Exception("Error al registrar Sustentacion");
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    // posible transaccion
    public static void Eliminar(int id) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "DELETE FROM sustentacion WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al eliminar Sustentacion");
        }
    }

    public static ArrayList<clsSustentacion> listar() throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            ArrayList<clsSustentacion> lista = new ArrayList<>();
            String strSQL = "SELECT * FROM sustentacion";
            ResultSet rs = con.createStatement().executeQuery(strSQL);
            while (rs.next()) {
                clsSustentacion objS = new clsSustentacion();
                objS.setId(rs.getInt(1));
                objS.setFecha(rs.getDate(2));
                objS.setHora_inicio(rs.getTime(3));
                objS.setHora_fin(rs.getTime(4));
                objS.setCalificacion(rs.getString(5));
                objS.setComentarios(rs.getString(6));
                objS.setDecision(rs.getString(7));
                objS.setEstado(rs.getBoolean(8));
                objS.setAmbiente(clsAmbiente.buscar(rs.getInt(9)));
                lista.add(objS);
            }
            return lista;

        } catch (Exception e) {
            throw new Exception("Error al listar Sustentacion");
        }
    }

    public void modificar(clsSustentacion objS) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "UPDATE sustentacion SET fecha = ?, hora_inicio = ?, hora_fin = ?, calificacion = ?, comentarios = ?, decision = ?, estado = ?, id_ambiente = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setDate(1, objS.getFecha());
            ps.setTime(2, objS.getHora_inicio());
            ps.setTime(3, objS.getHora_fin());
            ps.setString(4, objS.getCalificacion());
            ps.setString(5, objS.getComentarios());
            ps.setString(6, objS.getDecision());
            ps.setBoolean(7, objS.getEstado());
            ps.setInt(8, objS.getAmbiente().getId());
            ps.setInt(9, id);
            ps.execute();
        } catch (Exception e) {
            throw new Exception("Error al modificar Sustentacion");
        }
    }

    public static void darBaja(int id) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "UPDATE alumno SET estado = FALSE WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al dar baja Sustentacion");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Time hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Time getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(Time hora_fin) {
        this.hora_fin = hora_fin;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public clsAmbiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(clsAmbiente ambiente) {
        this.ambiente = ambiente;
    }

}
