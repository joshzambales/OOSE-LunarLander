package LanderGame;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Vector2f;

public class Player {
	public float SPEED = 0.005f;
	
	private Vector2f position;
	private Vector2f rotation;
	private Vector2f acceleration;
	
	Player() {
		position = new Vector2f(0,0);
		rotation = new Vector2f(0,0);
		acceleration = new Vector2f(0,0);
	}
	
	void update(GameContainer gc, int delta) throws SlickException {
		Input key = gc.getInput();
		
		//TODO Take rotation into account rather than just moving with worldspace
		if(key.isKeyPressed(Input.KEY_W)) {
			acceleration.add(new Vector2f(0,1 * SPEED * delta));
		}
		if(key.isKeyPressed(Input.KEY_S)) {
			acceleration.add(new Vector2f(0,-1 * SPEED * delta));
		}
		if(key.isKeyPressed(Input.KEY_A)) {
			acceleration.add(new Vector2f(-1 * SPEED * delta,0));
		}
		if(key.isKeyPressed(Input.KEY_D)) {
			acceleration.add(new Vector2f(1 * SPEED * delta,0));
		}
		
		position.add(acceleration);
	}
	
	void render(GameContainer gc, Graphics g) throws SlickException {
		//TODO Draw image and rotate image according to rotation vector
		g.drawRect(position.x, position.y, 10, 10);
	}
	
	public void addForce(Vector2f v) {
		acceleration.add(v);
	}
}
