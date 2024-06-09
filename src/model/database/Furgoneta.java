/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database;

/**
 *
 * @author neira
 */
public class Furgoneta {
    private int idFurgoneta;
    private String modeloFurgoneta;

    public Furgoneta(int idFurgoneta, String modeloFurgoneta) {
        this.idFurgoneta = idFurgoneta;
        this.modeloFurgoneta = modeloFurgoneta;
    }

    public int getIdFurgoneta() {
        return idFurgoneta;
    }

    public void setIdFurgoneta(int idFurgoneta) {
        this.idFurgoneta = idFurgoneta;
    }

    public String getModeloFurgoneta() {
        return modeloFurgoneta;
    }

    public void setModeloFurgoneta(String modeloFurgoneta) {
        this.modeloFurgoneta = modeloFurgoneta;
    }
}
