/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import model.database.Cliente;
import model.database.DAO.ClientesDAO;
import model.database.DAO.ClientesDAOMySQL;
import model.database.DAO.EventosDAO;
import model.database.DAO.FurgonetaDAO;
import model.database.DAO.FurgonetaDAOMySQL;
import model.database.DAO.PersonalDAO;
import model.database.DAO.PersonalDAOMySQL;
import model.database.Furgoneta;
import model.database.Personal;
import view.eventos.AddEventoDialog;
import view.login.LoginJFrame;

/**
 *
 * @author neira
 */
public class AddEventoController {
    private final AddEventoDialog view;
    private final EventosDAO eventosDAO;
    private final ClientesDAO clientesDAO;
    private final PersonalDAO empleadosDAO;
    private final FurgonetaDAO furgonetasDAO;
    private final LoginJFrame mainView;

    public AddEventoController(AddEventoDialog view, EventosDAO eventosDAO) {
        this.view = view;
        this.eventosDAO = eventosDAO;
        this.clientesDAO = new ClientesDAOMySQL();
        this.empleadosDAO = new PersonalDAOMySQL();
        this.furgonetasDAO = new FurgonetaDAOMySQL();
        this.mainView = new LoginJFrame();
        initValues();
    }
    
    
    public void initValues(){
        JComboBox<String> comClientes = view.getComboBoxClientes();
        ArrayList<Cliente> clientes = clientesDAO.mostrarClientes();
        
        for (Cliente cliente : clientes) {
            comClientes.addItem(cliente.getNombre());
        }
        
        JComboBox<String> comEmpleado1 = view.getComboBoxEmpleado1();
        JComboBox<String> comEmpleado2 = view.getComboBoxEmpleado2();
        ArrayList<Personal> empleado = empleadosDAO.mostrarPersonal();
        
        for (Personal personal : empleado) {
            comEmpleado1.addItem(personal.getNombre() +" "+ personal.getApellidos());
            comEmpleado2.addItem(personal.getNombre() +" "+ personal.getApellidos());
        }
        
        JComboBox<String> comFurgoneta = view.getComboBoxFurgoneta();
        ArrayList<Furgoneta> furgonetas = furgonetasDAO.mostrarFurgonetas();
        
        for (Furgoneta furgoneta : furgonetas) {
            comFurgoneta.addItem(furgoneta.getIdFurgoneta()+" "+furgoneta.getModeloFurgoneta());
        }
        
       
        
        
    }
    
    
    
}
