package LanderGame;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

public class Game extends BasicGame {
	private Player player;
	private Planet planet;
	private Vector2f pull;
	
	public Game(String gamename)
	{
		super(gamename);
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException {		
		player = new Player(new Vector2f(gc.getWidth()/2, gc.getHeight()/2));
		planet = new Planet (new Vector2f(200, 400), 200, 100.0f, 300.0f, 10);
		pull = new Vector2f (0,0);
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		player.render(gc,g);
		planet.render(gc,g);
		
		g.drawString("Rotation:" + player.getRotation() + " Rad",10 , 30);
		g.drawString("Velocity: " + player.getVelocity() + " pix/ms", 10, 60);
		g.drawString("Thrust: " + player.getThrust() + " pix/ms", 10, 90);
		g.drawString("Distance: " + distance(), 10, 120);
		
		
		g.drawLine(player.getPosition().x, 
					player.getPosition().y, 
					player.getPosition().x + (player.getVelocity()*getPullDirection().x*5000000),
					player.getPosition().y + (player.getVelocity()*getPullDirection().y*5000000)); //Gravitational direction
		
		
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		player.update(gc,delta);

		if (distance() <= planet.getGravityRange()){	//If player enters gravity
			planet.color = Color.yellow;				//Colour planet yellow (for debug)
			pull = new Vector2f (planet.getPos().x-player.getPosition().x , planet.getPos().y-player.getPosition().y);	// Vector between ship and planet
			pull.normalise();
			pull.x *= planet.gravitationalForce();			//Setting gravity force on the pull vector
			pull.y *= planet.gravitationalForce();
			
			
			
			//TODO Measure velocity along vector toward planet position			
			if(pullSpeed() < 9.82){				//If gravitational speed is below certain threshold
				player.addForce(pull);			//Add gravity force to player
			}
	
			
		}
	}
	

	public float distance() {
		double x, y;
		x = Math.pow((planet.getPos().x - player.getPosition().x), 2);
		y = Math.pow((planet.getPos().y - player.getPosition().y), 2);
		return (float) Math.sqrt(x+y);
	}
	
	public Vector2f getPullDirection(){
		return pull;
	}
	
	public float pullSpeed(){
		//TODO Get velocity toward planet (along getPullDirection) - Is now a constant based on gravitationalForce
		
		Vector2f direction = new Vector2f();
		float x = player.getPosition().x; 
		float y = player.getPosition().y;
		//direction = (x, y, planet.getPos().x,planet.getPos().y);
		
		return (float) Math.sqrt(Math.pow(getPullDirection().x, 2) + Math.pow(getPullDirection().y, 2));
	}
	
	
}