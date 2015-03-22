package LanderGame;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

/**
 * The class of all planets in the Game.
 * @author Jonathan Aardestrup
 */

public class Planet extends Circle {

	// Properties
	private Vector2f location;			// x,y planets location in space
	private float gravity;				// Amount of gravity
	private float gravityRange;			// Reach of gravity
	private float size;					// Size of planet
	private int resource; 				// Amout of resources

	
	// Resources
	private Image texPlanet;			// Image/texture for Planet

	// Debug
	public Color color = Color.green;
	
	/**
	 * Constructor for planet, which handles the initial of Position of a planet
	 * @param pos Position where the planet should be initialised
	 */
	
	Planet(Vector2f pos, int size, float gravity, float gravityRange, int resource){
		super(pos.x, pos.y, size);
		
		location = pos;
		this.size = size;
		this.resource = resource;	
		this.gravity = gravity;
		this.gravityRange = gravityRange + size;
	}
	
	/**
	 * Updates the planet position, acceleration using gameinputs
	 * @param gc GameContainer 
	 * @param delta Delta frame time
	 * @throws SlickException throws any SlickException
	 */
	public void update(GameContainer gc, int delta) throws SlickException {
		
	}
	
	
	/**
	 * Returns the position of the planet
	 * @return
	 */
	public Vector2f getPos(){
		return location;
	}
	
	/**
	 * Returns the number of resources of the planet
	 * @return
	 */
	public int getPlanetRes(){
		return resource;
	}
	
	/**
	 * Sets the number of resources of the planet
	 * @param number of resources the planet should have from start
	 */
	public void setPlanetRes(int res){
		if(res < 0){
			res = 0;
		}
		resource = res;
	}
	
	/**
	 * Renders the ship for the planet, including sprites, particles, etc.
	 * @param gc GameContainer 
	 * @param delta Delta frame time
	 * @throws SlickException throws any SlickException
	 */
	
	public void render(GameContainer gc, Graphics g) throws SlickException {
		// debugging 
		
		g.drawRect(location.x-5, location.y-5, 10, 10);
		g.setColor(color);
		g.drawOval(location.x-(size/2), location.y-(size/2), size, size);
		g.setColor(Color.magenta);
		g.drawOval(location.x-((gravityRange)/2), location.y-((gravityRange)/2), gravityRange, gravityRange);
		g.setColor(Color.white);


	}
	
	/**
	 * Returns the GravitationalForce of planet
	 * @return
	 */
	public float gravitationalForce(){
		return size * 0.00000045f; // TODO do the math!	
	}

	/**
	 * Returns the Gravity range of planet
	 * @return
	 */
	public float getGravityRange() {
		return gravityRange/2;
	}

	/**
	 * Sets the range of gravity influence of the planet
	 * @param range of gravity influence of the planet
	 */
	public void setGravityRange(float gravityRange) {
		this.gravityRange = gravityRange;
	}
	
	
}
