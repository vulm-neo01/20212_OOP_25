package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Shield_Silver extends Entity{
	public OBJ_Shield_Silver(GamePanel gp) {
		super(gp);
		
		type = type_shield;
		name = "Silver Shield";
		down1 = setup("/object/shield_silver", gp.tileSize, gp.tileSize);
		defenseValue = 6;
		healthValue = 2;
		description = "[" + name + "]\nA shiny and solid silver shield.";
	}
}
