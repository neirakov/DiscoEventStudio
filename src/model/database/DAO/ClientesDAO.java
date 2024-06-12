/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.database.DAO;

import java.util.ArrayList;
import model.database.Cliente;

/**
 *
 * @author neira
 */
public interface ClientesDAO {
    ArrayList<Cliente> mostrarClientes();
    void eliminarCliente(int idCliente);
    void agregarCliente(Cliente cliente);
    int obtenerIdClientePorNombre(String nombre);
}
