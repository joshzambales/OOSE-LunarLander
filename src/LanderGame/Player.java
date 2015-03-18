package LanderGame;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

/**
 * The player spaceship which takes keyboard inputs, in which the user controls
 * @author Frans Larsen
 */
public class Player {
	public float THRUST_SPEED = 0.0025f; // Maximum allowed thrust speed
	
	private Vector2f position;		// x,y ships position in space
	private Vector2f acceleration;	// x,y ships acceleration direction
	private float rotation;			// current rotation of ship
	private float thrust;			// Force being added to the ships forward vector relative to its rotation
	
	/**
	 * Constructor for player, which handles the init of Position, acceleration, rotation & thrust
	 * @param pos Position where the player should be initialised
	 */
	Player(Vector2f pos) {
		position = pos;	
		acceleration = new Vector2f(0,0);		
		rotation = 0;
		thrust = 0;
	}
	
	/**
	 * Updates the players position, acceleration using gameinputs
	 * @param gc GameContainer 
	 * @param delta Delta frame time
	 * @throws SlickException throws any SlickException
	 */
	public void update(GameContainer gc, int delta) throws SlickException {
		Input key = gc.getInput();
		
		if(key.isKeyDown(Input.KEY_W)) {
			thrust += (THRUST_SPEED - thrust) * 0.0001;
		} else {
			thrust += (0 - thrust) * 0.01f;
		}
		
		//TODO Add break using KEY_S
		
		if(key.isKeyDown(Input.KEY_A)) {
			rotation -= Math.PI/640 * delta;
		}
		if(key.isKeyDown(Input.KEY_D)) {
			rotation += Math.PI/640 * delta;
		}
		
		//TODO Add de-acceleration from UNKNOWN FORCES FROM SPACE
		
		acceleration.add(new Vector2f(thrust * (float)Math.cos(rotation),thrust * (float)Math.sin(rotation)));
		position.add(acceleration);
	}
	
	/**
	 * Renders the ship for the player, including sprites, particles, etc.
	 * @param gc GameContainer 
	 * @param delta Delta frame time
	 * @throws SlickException throws any SlickException
	 */
	public void render(GameContainer gc, Graphics g) throws SlickException {
		//TODO Draw image and rotate image according to rotation vector
		g.drawRect(position.x-5, position.y-5, 10, 10);
		
		g.drawLine(position.x, position.y, position.x+(float)(20*Math.cos(rotation)), position.y+(float)(20*Math.sin(rotation)));
	}
	
	/**
	 * Adds a force to the ships acceleration
	 * @param v Is the vector of force to add
	 */
	public void addForce(Vector2f v) {
		acceleration.add(v);
	}
	
	/**
	 * Returns the ships rotation in Radians
	 * @return
	 */
	public float getRotation() {
		return rotation;
	}
	
	/**
	 * Returns the ships thrust rate
	 * @return
	 */
	public float getThrust() {
		return thrust;
	}
	
	/**
	 * Returns the ships acceleration
	 * @return
	 */
	public float getAcceleration() {
		//FIXME I think this is wrong?
		return (float) Math.sqrt(Math.pow(Math.cos(acceleration.x), 2) + Math.pow(Math.sin(acceleration.y), 2));
	}
}
