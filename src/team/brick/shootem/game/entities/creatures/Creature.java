package team.brick.shootem.game.entities.creatures;

import team.brick.shootem.game.Handler;
import team.brick.shootem.game.entities.Entity;
import team.brick.shootem.game.tiles.Tile;

/**
 *	Creatures are entities which move and have health.
 * 	
 *	@author Miguel Millan
 *	@version 1.0
 *	@since version 1.0
 */
public abstract class Creature extends Entity {
	
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64,
							DEFAULT_CREATURE_HEIGHT = 64;
	
	protected int health;
	protected float speed;
	protected float xMove, yMove;

	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	/**
	 *	Calls the Creatures Move methods if there are no Entity collisions.
	 */
	public void move(){
		if(!checkEntityCollisions(xMove, 0f))
			moveX();
		if(!checkEntityCollisions(0f, yMove))
			moveY();
	}
	
	/**
	 * Moves the Creature in the x direction.
	 */
	public void moveX(){
		if(xMove > 0){//Moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}else{
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}
			
		}else if(xMove < 0){//Moving left
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}else{
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}
			
		}
	}
	
	/**
	 * Moves the Creature in the y direction.
	 */
	public void moveY(){
		if(yMove < 0){//Up
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}else{
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
			
		}else if(yMove > 0){//Down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}else{
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}
			
		}
	}
	
	/**
	 * Checks if the creature is colliding with a solid Tile.
	 * 
	 * @param x the x position of the Tile
	 * @param y the y position of the Tile
	 * @return true if the Tile is not solid
	 * @return false if the Tile is is solid
	 */
	protected boolean collisionWithTile(int x, int y){
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	//GETTERS SETTERS

	/**
	 * @return xMove 
	 */
	public float getxMove() {
		return xMove;
	}

	/**
	 * @param xMove how far the creature will move in the x-direction
	 */
	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	/**
	 * @return yMove
	 */
	public float getyMove() {
		return yMove;
	}

	/**
	 * @param yMove how far the Creature will move in the y-direction
	 */
	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	/**
	 * @return health the current health of the Creature
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param health the new health of the Creature
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * @return speed the current speed of the Creature
	 */
	public float getSpeed() {
		return speed;
	}

	/**
	 * @param speed the new speed of the Creature
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
}
