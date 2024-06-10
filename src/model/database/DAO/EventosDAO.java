/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.database.DAO;

import java.util.ArrayList;
import model.database.Evento;

/**
 *
 * @author neira
 */
public interface EventosDAO {
    ArrayList<Evento> mostrarEventos();
    void eliminarEvento(int idEvento);
    void agregarEvento(Evento evento);
}
