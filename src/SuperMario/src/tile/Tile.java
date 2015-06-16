package tile;

import java.awt.Graphics;
import java.awt.Rectangle;

import mario.Handler;
import mario.Id;

public abstract class Tile {
	
	/**
	 * Coordinate Position of the Tile
	 */
	public int x, y;
	
	/**
	 * Height and width of the Tile
	 */
	public int width, height;
	
	/**
	 * True if the Tile is solid and can't be moved through
	 */
	public boolean solid;
	
	/**
	 * Velocity in X direction
	 */
	public int velX;
	
	/**
	 * Velocity in Y direction
	 */
	public int velY;
	
	/**
	 * Identifier (wall?)
	 */
	public Id id;
	
	/**
	 * Game handler instance
	 */
	public Handler handler;
	
	/**
	 * Creates a new tile
	 * @param x XCoordinate
	 * @param y YCoordinate
	 * @param width The width (x) of tile
	 * @param height The height (y) of tile
	 * @param solid Can the play travel through the tile?
	 * @param id 
	 * @param handler
	 */
	public Tile(int x, int y, int width, int height, boolean solid, Id id, Handler handler){
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.solid = solid;
		this.id = id; 
		this.handler = handler;
	}
	
	/**
	 * Takes care of drawing the tile
	 * @param g Graphics
	 */
	public abstract void render(Graphics g);
	
	/**
	 * Handles any movement during the game
	 */
	public abstract void tick();
	
	/**
	 * Kills object if needed
	 */
	public void die(){
		handler.removeTile(this);
	}
	
	
	
	//-------------------GETTERS-------------------
	
	/**
	 * Getter for X
	 * @return X-Coordinate
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * Getter for Y
	 * @return Y-Coordinate
	 */
	public int getY(){
		return y;
	}
	
	/**
	 * Getter for solid
	 * @return true if solid, false if not
	 */
	public boolean isSolid(){
		return solid;
	}
	
	public Id getId(){
		return id;
	}

	//-------------------SETTERS-------------------
	
	/**
	 * Setter for X
	 */
	public void setX(int x){
		this.x = x;
	}
	
	/**
	 * Setter for Y
	 */
	public void setY(int y){
		this.y = y;
	}
	
	/**
	 * Setter for solid
	 */
	public void setSolid(boolean solid){
		this.solid = solid;
	}

	/**
	 * Sets the X direction velocity 
	 * @param velX
	 */
	public void setVelX(int velX) {
		this.velX = velX;
	}

	/** 
	 * Sets the Y direction velocity
	 * @param velY
	 */
	public void setVelY(int velY) {
		this.velY = velY;
	}
	
	/**
	 * Gets the bounds of the tile
	 * @return 
	 */
	public Rectangle getBounds(){
		return new Rectangle(getX(), getY(), width, height);
	}
}
