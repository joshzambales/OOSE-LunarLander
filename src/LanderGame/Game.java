package LanderGame;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Game extends BasicGame {
	private Player p;
	
	public Game(String gamename)
	{
		super(gamename);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		
		g.drawString("Test", 250, 200);
		p.render(gc,g);
		
		g.drawString("Rotation:" + p.getRotation(),10 , 30);
		g.drawString("Acceleration: " + p.getAcceleration(), 10, 60);
		g.drawString("Thrust: " + p.getThrust(), 10, 90);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		// TODO Auto-generated method stub
		
		p = new Player();
	}
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		// TODO Auto-generated method stub
		p.update(gc,delta);
	}
}