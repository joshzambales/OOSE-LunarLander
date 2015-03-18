package LanderGame;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Vector2f;

public class Player {
	public float THRUST_SPEED = 0.0025f;
	
	private Vector2f position;		// x,y ships position in space
	private Vector2f acceleration;	// x,y ships acceleration direction
	private float rotation;			// current rotation of ship
	private float thrust;
	
	Player() {
		position = new Vector2f(1280/2,720/2);
		acceleration = new Vector2f(0,0);
		rotation = 0;
		thrust = 0;
	}
	
	void update(GameContainer gc, int delta) throws SlickException {
		Input key = gc.getInput();
		
		//TODO Take rotation into account rather than just moving with worldspace
		if(key.isKeyDown(Input.KEY_W)) {
			thrust += (THRUST_SPEED - thrust) * 0.0001;
			acceleration.add(new Vector2f(thrust * (float)Math.cos(rotation),thrust * (float)Math.sin(rotation)));
		}
		if(key.isKeyDown(Input.KEY_A)) {
			rotation -= Math.PI/640 * delta;
		}
		if(key.isKeyDown(Input.KEY_D)) {
			rotation += Math.PI/640 * delta;
		}
		
		thrust += (0 - thrust) * 0.001f; // De-accelerate ship
		
		position.add(acceleration);
	}
	
	void render(GameContainer gc, Graphics g) throws SlickException {
		//TODO Draw image and rotate image according to rotation vector
		g.drawRect(position.x-5, position.y-5, 10, 10);
		
		g.drawLine(position.x, position.y, position.x+(float)(20*Math.cos(rotation)), position.y+(float)(20*Math.sin(rotation)));
	}
	
	public void addForce(Vector2f v) {
		acceleration.add(v);
	}
	
	public float getRotation() {
		return rotation;
	}
	
	public float getThrust() {
		return thrust;
	}
	
	public float getAcceleration() {
		return (float) Math.sqrt(Math.pow(Math.cos(acceleration.x), 2) + Math.pow(Math.sin(acceleration.y), 2));
	}
}
