package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Heart extends Entity{
	
	GamePanel gp;
	
	public OBJ_Heart(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_pickupOnly;
		name = "Heart";
		value = 2;
		down1 = setup("/object/heart_full", gp.tileSize, gp.tileSize);
		image = setup("/object/heart_full", gp.tileSize, gp.tileSize);
		image2 = setup("/object/heart_half", gp.tileSize, gp.tileSize);
		image3 = setup("/object/heart_blank", gp.tileSize, gp.tileSize);
		
	}
	public void use(Entity entity) {
		
		gp.playSE(2);
		entity.life += value;
	}
	
}
