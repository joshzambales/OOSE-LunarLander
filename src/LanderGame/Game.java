package LanderGame;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

public class Game extends BasicGame {
	private Player p;
	
	public Game(String gamename)
	{
		super(gamename);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		p.render(gc,g);
		
		g.drawString("Rotation:" + p.getRotation(),10 , 30);
		g.drawString("Acceleration: " + p.getAcceleration(), 10, 60);
		g.drawString("Thrust: " + p.getThrust(), 10, 90);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {		
		p = new Player(new Vector2f(gc.getWidth()/2, gc.getHeight()/2));
	}
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		p.update(gc,delta);
	}
}