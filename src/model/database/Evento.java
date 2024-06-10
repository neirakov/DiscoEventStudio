/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database;

/**
 *
 * @author neira
 */
public class Evento {
    private int idEvento;
    private String cliente;
    private String empleados;
    private String tipoEvento;
    private String tipoPack;
    private String descripcionPack;
    private String importePack;
    private String furgoneta;
    private String fotomaton;
    private String karaoke;
    private String proyeccion;
    private String importeBaseFotomaton;
    private String importeBaseKaraoke;
    private String importeBaseProyeccion;
    private String horasExtraDisco;
    private String horasExtraFotomaton;
    private String importeHorasExtraDisco;
    private String importeHorasExtraFotomaton;
    private String importeTotal;
    private String importeIVA;
    private String importeTotalConIVA;

    public Evento(int idEvento, String cliente, String empleados, String tipoEvento,String tipoPack ,String descripcionPack, String importePack, String furgoneta, String fotomaton, String karaoke,String proyeccion, String importeBaseFotomaton, String importeBaseKaraoke, String importeBaseProyeccion, String horasExtraDisco, String horasExtraFotomaton, String importeHorasExtraDisco, String importeHorasExtraFotomaton, String importeTotal, String importeIVA, String importeTotalConIVA) {
        this.idEvento = idEvento;
        this.cliente = cliente;
        this.empleados = empleados;
        this.tipoEvento = tipoEvento;
        this.tipoPack = tipoPack;
        this.descripcionPack = descripcionPack;
        this.importePack = importePack;
        this.furgoneta = furgoneta;
        this.fotomaton = fotomaton;
        this.karaoke = karaoke;
        this.proyeccion = proyeccion;
        this.importeBaseFotomaton = importeBaseFotomaton;
        this.importeBaseKaraoke = importeBaseKaraoke;
        this.importeBaseProyeccion = importeBaseProyeccion;
        this.horasExtraDisco = horasExtraDisco;
        this.horasExtraFotomaton = horasExtraFotomaton;
        this.importeHorasExtraDisco = importeHorasExtraDisco;
        this.importeHorasExtraFotomaton = importeHorasExtraFotomaton;
        this.importeTotal = importeTotal;
        this.importeIVA = importeIVA;
        this.importeTotalConIVA = importeTotalConIVA;
    }
    
        public Evento(int idEvento, String cliente, String tipoPack, String empleados,String furgoneta,String fotomaton,String karaoke,String proyeccion,String importeTotalConIVA) {
        this.idEvento = idEvento;
        this.cliente = cliente;
        this.tipoPack = tipoPack;
        this.empleados = empleados;
        this.furgoneta = furgoneta;
        this.fotomaton = fotomaton;
        this.karaoke = karaoke;
        this.proyeccion = proyeccion;
        this.importeTotalConIVA = importeTotalConIVA;
    }

    public String getProyeccion() {
        return proyeccion;
    }
    
    public void setProyeccion(String proyeccion) {
        this.proyeccion = proyeccion;
    }
   
    public String getTipoPack() {
        return tipoPack;
    }

    public void setTipoPack(String tipoPack) {
        this.tipoPack = tipoPack;
    }
    
    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEmpleados() {
        return empleados;
    }

    public void setEmpleados(String empleados) {
        this.empleados = empleados;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getDescripcionPack() {
        return descripcionPack;
    }

    public void setDescripcionPack(String descripcionPack) {
        this.descripcionPack = descripcionPack;
    }

    public String getImportePack() {
        return importePack;
    }

    public void setImportePack(String importePack) {
        this.importePack = importePack;
    }

    public String getFurgoneta() {
        return furgoneta;
    }

    public void setFurgoneta(String furgoneta) {
        this.furgoneta = furgoneta;
    }

    public String getFotomaton() {
        return fotomaton;
    }

    public void setFotomaton(String fotomaton) {
        this.fotomaton = fotomaton;
    }

    public String getKaraoke() {
        return karaoke;
    }

    public void setKaraoke(String karaoke) {
        this.karaoke = karaoke;
    }

    public String getImporteBaseFotomaton() {
        return importeBaseFotomaton;
    }

    public void setImporteBaseFotomaton(String importeBaseFotomaton) {
        this.importeBaseFotomaton = importeBaseFotomaton;
    }

    public String getImporteBaseKaraoke() {
        return importeBaseKaraoke;
    }

    public void setImporteBaseKaraoke(String importeBaseKaraoke) {
        this.importeBaseKaraoke = importeBaseKaraoke;
    }

    public String getImporteBaseProyeccion() {
        return importeBaseProyeccion;
    }

    public void setImporteBaseProyeccion(String importeBaseProyeccion) {
        this.importeBaseProyeccion = importeBaseProyeccion;
    }

    public String getHorasExtraDisco() {
        return horasExtraDisco;
    }

    public void setHorasExtraDisco(String horasExtraDisco) {
        this.horasExtraDisco = horasExtraDisco;
    }

    public String getHorasExtraFotomaton() {
        return horasExtraFotomaton;
    }

    public void setHorasExtraFotomaton(String horasExtraFotomaton) {
        this.horasExtraFotomaton = horasExtraFotomaton;
    }

    public String getImporteHorasExtraDisco() {
        return importeHorasExtraDisco;
    }

    public void setImporteHorasExtraDisco(String importeHorasExtraDisco) {
        this.importeHorasExtraDisco = importeHorasExtraDisco;
    }

    public String getImporteHorasExtraFotomaton() {
        return importeHorasExtraFotomaton;
    }

    public void setImporteHorasExtraFotomaton(String importeHorasExtraFotomaton) {
        this.importeHorasExtraFotomaton = importeHorasExtraFotomaton;
    }

    public String getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(String importeTotal) {
        this.importeTotal = importeTotal;
    }

    public String getImporteIVA() {
        return importeIVA;
    }

    public void setImporteIVA(String importeIVA) {
        this.importeIVA = importeIVA;
    }

    public String getImporteTotalConIVA() {
        return importeTotalConIVA;
    }

    public void setImporteTotalConIVA(String importeTotalConIVA) {
        this.importeTotalConIVA = importeTotalConIVA;
    }
    
}
