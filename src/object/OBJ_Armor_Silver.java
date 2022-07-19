package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Armor_Silver extends Entity{
	public OBJ_Armor_Silver(GamePanel gp) {
		super(gp);
		
		type = type_armor;
		name = "Silver Armor";
		down1 = setup("/object/armor_silver", gp.tileSize, gp.tileSize);
		defenseValue = 6;
		healthValue = 2;
		description = "[" + name + "]\nA shiny and solid silver Armor.";
	}
}
