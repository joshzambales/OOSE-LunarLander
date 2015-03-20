package LanderGame;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

/**
 * The class of all planets in the Game.
 * @author Jonathan Aardestrup
 */

public class Planet {

	// Properties
	private Vector2f location;		// x,y planets location in space
	private int size;					// Size of planet
	private int resource; 				// Amout of resources
	
	// Resources
	private Image texPlanet;			// Image/texture for Planet

	Planet(Vector2f pos, int size, int resource){
		location = pos;
		this.size = size;
		this.resource = resource;	
	}
	
	
	public void update(GameContainer gc, int delta) throws SlickException {
		
	}
	
	/**
	 * Constructor for planet, which handles the initial of Position of a planet
	 * @param pos Position where the planet should be initialised
	 */
	public void getPlanetPos(Vector2f pos){
		location = pos;
	}
	
	public void resPlanet(int res){
		resource = res;
	}
	
	
	
	public void render(GameContainer gc, Graphics g) throws SlickException {
		// debugging 
		
		g.drawOval(location.x-(size/2), location.y-(size/2), size, size);
		g.setColor(Color.white);

	}
	
//	public boolean hasLanded(Vector2f playerPos){
//		boolean bool = false;
//
//		if (playerPos.sub(location) == 0){
//		bool = true;
//		}
//		return bool;
//		
//		
//	}
	
}
