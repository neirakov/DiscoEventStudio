/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author neira
 */
public class ReadSQL {
    public static String read(String ruta) {
        Path path = Paths.get(ruta);
        String consulta = null;
        try {
            consulta = Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return consulta;
    }  
}
