package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Helmet_Normal extends Entity{
	public OBJ_Helmet_Normal(GamePanel gp) {
		super(gp);
		
		type = type_helmet;
		name = "Normal Helmet";
		down1 = setup("/object/helmet_normal", gp.tileSize, gp.tileSize);
		defenseValue = 2;
		description = "[" + name + "]\nA good helmet for your head.";
	}
}
