package LanderGame;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

/**
 * The class of all planets in the Game.
 * @author Jonathan Aardestrup
 */

public class Planet {

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
		location = pos;
		this.size = size;
		this.resource = resource;	
		this.gravity = gravity;
		this.gravityRange = gravityRange + size;
	}
	
	
	public void update(GameContainer gc, int delta) throws SlickException {
		
	}
	
	
	
	public Vector2f getPos(){
		return location;
	}
	
	public int getPlanetRes(){
		return resource;
	}
	
	public void setPlanetRes(int res){
		if(res < 0){
			res = 0;
		}
		resource = res;
	}
	

	
	public void render(GameContainer gc, Graphics g) throws SlickException {
		// debugging 
		
		g.drawRect(location.x-5, location.y-5, 10, 10);
		g.setColor(color);
		g.drawOval(location.x-(size/2), location.y-(size/2), size, size);
		g.setColor(Color.magenta);
		g.drawOval(location.x-((gravityRange)/2), location.y-((gravityRange)/2), gravityRange, gravityRange);
		g.setColor(Color.white);


	}
	
	
	public float gravitationalForce(){
		return size * 0.00000045f; // TODO do the math!	
	}


	public float getGravityRange() {
		return gravityRange/2;
	}


	public void setGravityRange(float gravityRange) {
		this.gravityRange = gravityRange;
	}
	
}
