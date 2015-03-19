package LanderGame;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

/**
 * The player spaceship which moves around the world, in which the user controls.
 * @author Frans Larsen
 */
public class Player {
	public float MAX_THRUST = 0.0025f; // Maximum allowed thrust speed (Not to be confused with velocity)
	
	private Vector2f position;		// x,y ships position in space
	private Vector2f velocity;	// x,y ships acceleration direction
	private float rotation;			// current rotation of ship
	private float thrust;			// Force being added to the ships forward vector relative to its rotation
	
	/**
	 * Constructor for player, which handles the initial of Position, acceleration, rotation & thrust
	 * @param pos Position where the player should be initialised
	 */
	Player(Vector2f pos) {
		position = pos;
		velocity = new Vector2f(0,0);		
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
			thrust += (MAX_THRUST - thrust) * 0.0001;
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
		
		velocity.add(new Vector2f(thrust * (float)Math.cos(rotation),thrust * (float)Math.sin(rotation)));
		position.add(velocity);
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
		
		// Debugging
		g.setColor(Color.red);	
		g.drawLine(position.x, position.y, position.x + (500*velocity.x), position.y + (500*velocity.y));
		g.setColor(Color.cyan);
		g.drawLine(position.x, position.y, position.x+(float)(20*Math.cos(rotation)), position.y+(float)(20*Math.sin(rotation)));
		g.setColor(Color.white);
	}
	
	/**
	 * Adds a force to the ships acceleration
	 * @param v Is the vector of force to add
	 */
	public void addForce(Vector2f v) {
		velocity.add(v);
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
		return (float) Math.sqrt(Math.pow(Math.cos(velocity.x), 2) + Math.pow(Math.sin(velocity.y), 2));
	}
}
