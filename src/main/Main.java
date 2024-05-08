/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controller.LoginController;
import view.login.LoginJFrame;

/**
 *
 * @author neira
 */
public class Main {
    public static void main(String[] args) {
        LoginJFrame view = new LoginJFrame();
        LoginController controller = new LoginController(view);
        
        view.setVisible(true);
        
        
    }
    
}
