package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Sword_Vip extends Entity{
	public OBJ_Sword_Vip(GamePanel gp) {
		super(gp);
		
		type = type_sword;
		name = "Vip Sword";
		down1 = setup("/object/sword_vip", gp.tileSize, gp.tileSize);
		attackValue = 12;
		attackArea.width = 36;
		attackArea.height = 36;
		description = "[" + name + "]\nA sword forged by skilled dwarves.";
	}
}
