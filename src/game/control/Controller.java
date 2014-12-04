/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.control;


import game.model.ModelObject;
import game.model.Player;
import game.view.GameView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andrej
 */
public class Controller {

    public GameView view;
    private List<ModelObject> objects;
    private Thread thread;
    private boolean running = false;

    public Controller() {
        objects = new ArrayList<>();
    }

    private void initializeGame() {
        
        Player player = new Player(200, 220);
        objects.add(player);

    }

    private synchronized void update() {
        
        if(view.isClicked())
        {
            objects.get(0).move(view.getClickedXPosition(), view.getClickedYPosition());
        }
        else
        {
            objects.get(0).move(200, 220);
        }
        
        
        view.updateModel(objects);

    }
    
    
    private void render() {
        
        view.repaint();
    }
    
    public synchronized void start() {
        initializeGame();
        running = true;
        thread = new Thread() {
            @Override
            public void run() {
                while (running) {
                    update();
                    render();
                    try {
                        Thread.sleep(80);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };
        thread.start();
    }

    public void stop() {
        running = false;
        try {
            thread.join(); 
        } catch (InterruptedException ex) {
        }

        view.repaint();
    }

    public void setView(GameView view) {
        this.view = view;
    }

}
