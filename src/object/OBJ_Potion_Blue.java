package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Potion_Blue extends Entity{
	
	GamePanel gp;
	public OBJ_Potion_Blue(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = type_consumable;
		name = "Blue Potion";
		value = 5;
		down1 = setup("/object/potion_blue", gp.tileSize, gp.tileSize);
		description = "[Red Potion]\nReals your mana by " + value + ".";
	}
	
	public void use(Entity entity) {
		
		entity.mana += value;
		if(gp.player.mana > gp.player.maxMana) {
			gp.player.mana = gp.player.maxMana;
		}
		gp.playSE(2);
	}
}

