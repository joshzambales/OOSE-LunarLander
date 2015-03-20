package LanderGame;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

public class Game extends BasicGame {
	private Player player;
	private Planet planet;
	
	public Game(String gamename)
	{
		super(gamename);
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException {		
		player = new Player(new Vector2f(gc.getWidth()/2, gc.getHeight()/2));
		planet = new Planet (new Vector2f(100, 400), 200, 100.0f, 300.0f, 10);
		
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		player.render(gc,g);
		planet.render(gc,g);
		
		g.drawString("Rotation:" + player.getRotation() + " Rad",10 , 30);
		g.drawString("Velocity: " + player.getVelocity() + " pix/ms", 10, 60);
		g.drawString("Thrust: " + player.getThrust() + " pix/ms", 10, 90);
		g.drawString("Distance: " + distance(), 10, 120);
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		player.update(gc,delta);

		if (distance() <= planet.getGravityRange()){
			planet.color = Color.yellow;
		}
	}

	public float distance() {
		double x, y;
		x = Math.pow((planet.getPos().x - player.getPosition().x), 2);
		y = Math.pow((planet.getPos().y - player.getPosition().y), 2);
		return (float) Math.sqrt(x+y);
	}
	
	
	
}