package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Boots_Leather extends Entity{
	
	public OBJ_Boots_Leather(GamePanel gp) {
		
		super(gp);
		
		name = "Boots";
		down1 = setup("/object/boots", gp.tileSize, gp.tileSize);
		
	}
}
