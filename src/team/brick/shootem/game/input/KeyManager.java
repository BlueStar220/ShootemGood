package team.brick.shootem.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *	The KeyManager keeps track of key presses.
 * 	
 *	@author 
 *	@version 1.0
 *	@since version 1.0
 */
public class KeyManager implements KeyListener {
	
	private boolean[] keys;
	public boolean up, down, left, right;
	
	public KeyManager(){
		keys = new boolean[256];
	}
	
	/**
	 *  Sets the movement keys to true or false based on
	 *  whether or not its key is pressed.
	 */
	public void tick(){
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
	}

	
	
	/**
	 * Sets the key with the given key code to true if 
	 * it has been pressed.
	 * 
	 * @param e
	 * @Override
	 */
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	/**
	 * Sets the key with the given key code to false if 
	 * it has been released.
	 * 
	 * @param e
	 * @Override
	 */
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
