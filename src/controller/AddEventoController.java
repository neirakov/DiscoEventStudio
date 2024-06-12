/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
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
import model.database.Evento;
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
        this.view.setAñadirClienteActionListener(addEventoListener());
        initValues();
    }
    
        private ActionListener addEventoListener(){
        ActionListener al = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              String cliente = view.getComboBoxClientes().getSelectedItem().toString();
              String tipoEvento = view.comprobarRadioButtonsTipoEvento();
              String packBoda = view.getComboBoxPacksBoda();
              String fotomaton = String.valueOf(view.comprobarRadioButtonFotomaton());
              String empleado1 = view.getComboBoxEmpleado1().getSelectedItem().toString();
              String empleado2 = view.getComboBoxEmpleado2().getSelectedItem().toString();
              String empleados = empleado1+","+empleado2;
              char idVehiculo = view.getComboBoxFurgoneta().getSelectedItem().toString().charAt(0);
              String vehiculo = String.valueOf(idVehiculo);
              String fechaEvento = view.getFechaEventoTextField();
              String horasExtraFotomaton = String.valueOf(view.getHorasExtraFotomaton().getValue());
              String horasExtraDisco = String.valueOf(view.getHorasExtraDisco().getValue());
              String karaoke = String.valueOf(view.getKaraokeRadioButton());
              String proyeccion = String.valueOf(view.getProyeccionRadioButton());

             Evento evento = new Evento(cliente,tipoEvento,packBoda,fotomaton,horasExtraFotomaton,empleados,vehiculo,karaoke,proyeccion,fechaEvento,horasExtraDisco);
             String[] empleadosSplit = empleado1.split("-");
             String[] empleados2Split = empleado2.split("-");
                System.out.println(empleadosSplit[0] + " " + empleados2Split[0]);
                int idEmpleado = empleadosDAO.obtenerIDempleadoPorNombre(empleadosSplit[0]);
                int idEmpleado2 = empleadosDAO.obtenerIDempleadoPorNombre(empleados2Split[0]);
                System.out.println(idEmpleado + " " + idEmpleado2);
 
             eventosDAO.agregarEvento(evento, idEmpleado, idEmpleado2);
              
            }   
        };
        return al;
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
            comEmpleado1.addItem(personal.getNombre() +"-"+ personal.getApellidos());
            comEmpleado2.addItem(personal.getNombre() +"-"+ personal.getApellidos());
        }
        
        JComboBox<String> comFurgoneta = view.getComboBoxFurgoneta();
        ArrayList<Furgoneta> furgonetas = furgonetasDAO.mostrarFurgonetas();
        
        for (Furgoneta furgoneta : furgonetas) {
            comFurgoneta.addItem(furgoneta.getIdFurgoneta()+" "+furgoneta.getModeloFurgoneta());
        }
           
    }
    
    
    
}
