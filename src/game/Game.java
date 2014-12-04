/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import database.Database;
import game.control.Controller;
import game.view.GameView;

/**
 *
 * @author andrej
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Database connection = new Database();
        connection.getData();
        
        /*
        Controller controller = new Controller();
        GameView view = new GameView(controller);
        view.setVisible(true);
                */
    }
    
}
