/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.database.DAO;

import java.util.ArrayList;
import model.database.Personal;

/**
 *
 * @author neira
 */
public interface PersonalDAO {
    ArrayList<Personal> mostrarPersonal();
    void eliminarEmpleado(int idEmpleado);
    void agregarEmpleado(Personal personal);
    
}
