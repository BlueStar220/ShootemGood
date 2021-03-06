package team.brick.shootem.game.gfx;

import team.brick.shootem.game.Handler;
import team.brick.shootem.game.entities.Entity;
import team.brick.shootem.game.tiles.Tile;

/**
 *	The GameCamera specifies which part of the game is displayed.
 * 	
 *	@author 
 *	@version 1.0
 *	@since version 1.0
 */
public class GameCamera {
	
	private Handler handler;
	private float xOffset, yOffset;
	
	public GameCamera(Handler handler, float xOffset, float yOffset){
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	/**
	 *  Ensures that no blank spaces are shown by making
	 *  sure the xOffset and yOffset is never outside of the dimensions of the world.
	 */
	public void checkBlankSpace(){
		if(xOffset < 0){
			xOffset = 0;
		}else if(xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()){
			xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
		}
		
		if(yOffset < 0){
			yOffset = 0;
		}else if(yOffset > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight()){
			yOffset = handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight();
		}
	}
	
	/**
	 * Centers the GameCamera on the specified entity.
	 * 
	 * @param e
	 */
	public void centerOnEntity(Entity e){
		xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
		yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
		checkBlankSpace();
	}
	
	/**
	 * Moves the GameCamera.
	 * 
	 * @param xAmt amount to move in the x direction
	 * @param yAmt amount to move in the y direction
	 */
	public void move(float xAmt, float yAmt){
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}

	/**
	 * @return xOffset
	 */
	public float getxOffset() {
		return xOffset;
	}

	/**
	 * @param xOffset how far to offset the GameCamera in the x direction.
	 */
	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	/**
	 * @return yOffset
	 */
	public float getyOffset() {
		return yOffset;
	}

	/**
	 * @param yOffset how far to offset the GameCamera in the y direction.
	 */
	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

}
