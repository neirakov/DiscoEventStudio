/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.database.DAO.FurgonetaDAO;
import model.database.Furgoneta;
import view.furgonetas.AddFurgonetaDialog;
import view.furgonetas.FurgonetasDialog;
import view.login.LoginJFrame;

/**
 *
 * @author neira
 */
public class AddFurgonetaController {
    private final AddFurgonetaDialog view;
    private final FurgonetaDAO furgonetaDAO;
    private final LoginJFrame mainView;

    public AddFurgonetaController(AddFurgonetaDialog view, FurgonetaDAO furgonetaDAO) {
        this.view = view;
        this.furgonetaDAO = furgonetaDAO;
        this.mainView = new LoginJFrame();
        this.view.setAñadirFurgonetaActionListener(crearFurgonetaListener());
    }
    
    private ActionListener crearFurgonetaListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String furgonetaModelo = view.getModeloFurgoneta();
                if (furgonetaModelo.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Debe completar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Furgoneta furgoneta = new Furgoneta(0,furgonetaModelo);
                furgonetaDAO.agregarFurgoneta(furgoneta);
                FurgonetasDialog fd = new FurgonetasDialog(mainView,true);
                FurgonetasController fc = new FurgonetasController(fd);
                view.dispose();
                fd.setVisible(true);
            }
        };
          return al;
    }
    
}
