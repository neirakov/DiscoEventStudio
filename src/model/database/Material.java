/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database;

/**
 *
 * @author neira
 */
public class Material {
    private int idArticulo;
    private String nombreArticulo;
    private String unidadesDisponibles;
    private String unidadesNoDisponibles;

    public Material(int idArticulo, String nombreArticulo, String unidadesDisponibles, String unidadesNoDisponibles) {
        this.idArticulo = idArticulo;
        this.nombreArticulo = nombreArticulo;
        this.unidadesDisponibles = unidadesDisponibles;
        this.unidadesNoDisponibles = unidadesNoDisponibles;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public String getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(String unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public String getUnidadesNoDisponibles() {
        return unidadesNoDisponibles;
    }

    public void setUnidadesNoDisponibles(String unidadesNoDisponibles) {
        this.unidadesNoDisponibles = unidadesNoDisponibles;
    }
}
