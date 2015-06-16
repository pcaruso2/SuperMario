package entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import mario.Handler;
import mario.Id;

public abstract class Entity {

	/**
	 * Coordinate Position of the Entity
	 */
	public int x, y;
	
	/**
	 * Height and width of the entity
	 */
	public int width, height;
	
	public int facing = 0;				//0 = left and 1 = right;
	
	/**
	 * True if the entity is solid and can't be moved through
	 */
	public boolean solid;
	
	/**
	 * Is the entity jumping
	 */
	public boolean jumping = false;
	
	/**
	 * Is the entity falling
	 */
	public boolean falling = true;
	
	/**
	 * Velocity in the X direction
	 */
	public int velX;
	
	/**
	 * Velocity in the Y direction
	 */
	public int velY;
	
	/**
	 * Gravity of the entity
	 */
	public double gravity = 0.0;
	
	/**
	 * What is the entity? (enemy? Player?)
	 */
	public Id id;
	
	/**
	 * The instance of the game handler
	 */
	public Handler handler;
	
	//Creates a new entity
	public Entity(int x, int y, int width, int height, boolean solid, Id id, Handler handler){
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.solid = solid;
		this.id = id;
		this.handler = handler;
	}
	
	public abstract void render(Graphics g);
	
	public abstract void tick();
	
	public void die(){
		handler.removeEntity(this);
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

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(getX(), getY(), width, height);
	}
	
	public Rectangle getBoundsTop(){
		return new Rectangle(getX()+10, getY(), width-20, 5);
	}
	
	public Rectangle getBoundsBottom(){
		return new Rectangle(getX()+10, getY()+height-5, width-20, 5);
	}
	
	public Rectangle getBoundsLeft(){
		return new Rectangle(getX(), getY()+10, 5, height-20);
	}
	
	public Rectangle getBoundsRight(){
		return new Rectangle(getX()+width-5, getY()+10, 5, height-20);
	}
	
}
