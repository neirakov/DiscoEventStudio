/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.database.DAO;

import java.util.ArrayList;
import model.database.Furgoneta;

/**
 *
 * @author neira
 */
public interface FurgonetaDAO {
    ArrayList<Furgoneta> mostrarFurgonetas();
    void eliminarFurgoneta(int idFurgoneta);
    void agregarFurgoneta(Furgoneta furgoneta);
}
