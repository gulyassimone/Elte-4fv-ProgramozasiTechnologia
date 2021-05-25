/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author gulya
 */
public class KeyListener extends KeyAdapter {
    
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
            
        }

        if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
            
        }

        if ((key == KeyEvent.VK_UP) && (!downDirection)) {
            
        }

        if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
            
        }
    }
}
