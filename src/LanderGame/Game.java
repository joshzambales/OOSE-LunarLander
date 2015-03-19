package LanderGame;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

public class Game extends BasicGame {
	private Player player;
	
	public Game(String gamename)
	{
		super(gamename);
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException {		
		player = new Player(new Vector2f(gc.getWidth()/2, gc.getHeight()/2));
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		player.render(gc,g);
		
		g.drawString("Rotation:" + player.getRotation(),10 , 30);
		g.drawString("Acceleration: " + player.getVelocity(), 10, 60);
		g.drawString("Thrust: " + player.getThrust(), 10, 90);
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		player.update(gc,delta);
	}
}