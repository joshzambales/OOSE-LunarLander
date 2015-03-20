package LanderGame;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

/**
 * The player spaceship which moves around the world, in which the user controls.
 * @author Frans Larsen
 */
public class Player {
	// Configuration
	public float MAX_THRUST = 0.0025f; // Maximum allowed thrust speed (Not to be confused with velocity)
	
	// Properties
	private Vector2f position;		// x,y ships position in space
	private Vector2f velocity;		// x,y ships acceleration direction
	private float rotation;			// current rotation of ship
	private float thrust;			// Force being added to the ships forward vector relative to its rotation
	
	// Resources
	private Image texShip;			// Image/texture for Ship
	private Image texThrust;		// Image/texture for thrust flame
	private Sound sfxCollision;		// Sound for collision with object	
	private Sound sfxThrust;		// Sound for while using thrusters
	
	
	/**
	 * Constructor for player, which handles the initial of Position, acceleration, rotation & thrust
	 */
	Player() {
		position = new Vector2f(0,0);
		velocity = new Vector2f(0,0);		
		rotation = 0;
		thrust = 0;
	}
	
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
			thrust += (MAX_THRUST - thrust) * 0.0001 * delta;
		} else {
			thrust += (0 - thrust) * 0.01f * delta;
		}
		
		if(key.isKeyDown(Input.KEY_S)) {
			//TODO Cleanup braking
			float x = velocity.x;
			float y = velocity.y;
			x += (0 - x) * 0.003f * delta;
			y += (0 - y) * 0.003f * delta;
			velocity = new Vector2f(x,y);
		}
		
		if(key.isKeyDown(Input.KEY_A)) {
			rotation -= Math.PI/640 * delta;
			
			//texShip.setRotation((float) Math.toDegrees(rotation));
		}
		
		if(key.isKeyDown(Input.KEY_D)) {
			rotation += Math.PI/640 * delta;
			
			//texShip.setRotation((float) Math.toDegrees(rotation));
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
		g.drawRect(position.x-5, position.y-5, 10, 10);
		
		// Debugging
		g.setColor(Color.red);	
		g.drawLine(position.x, position.y, position.x + (500 * velocity.x), position.y + (500 * velocity.y));
		g.setColor(Color.cyan);
		g.drawLine(position.x, position.y, position.x+(float)(20*Math.cos(rotation)), position.y+(float)(20*Math.sin(rotation)));
		g.setColor(Color.white);
	}
	
	/**
	 * Adds a force to the ships velocity
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
	public float getVelocity() {
		//FIXME I think this is wrong?
		return (float) Math.sqrt(Math.pow(velocity.x, 2) + Math.pow(velocity.y, 2));
	}
}
