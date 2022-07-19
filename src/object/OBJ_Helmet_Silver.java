package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Helmet_Silver extends Entity{
	public OBJ_Helmet_Silver(GamePanel gp) {
		super(gp);
		
		type = type_helmet;
		name = "Silver Helmet";
		down1 = setup("/object/helmet_silver", gp.tileSize, gp.tileSize);
		defenseValue = 6;
		healthValue = 2;
		description = "[" + name + "]\nA shiny silver helmet, it's made for you.";
	}
}
