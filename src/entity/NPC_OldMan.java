package entity;

import java.util.Random;

import main.GamePanel;

public class NPC_OldMan extends Entity{
	public NPC_OldMan(GamePanel pd) {
		super(pd);
		direction = "down";
		speed = 1;
		
		getImage();
	}
	public void getImage() {
		
		up1 = setup("/npc/up1", gp.tileSize, gp.tileSize);
		up2 = setup("/npc/up2", gp.tileSize, gp.tileSize);
		down1 = setup("/npc/down1", gp.tileSize, gp.tileSize);
		down2 = setup("/npc/down2", gp.tileSize, gp.tileSize);
		left1 = setup("/npc/right1", gp.tileSize, gp.tileSize);
		left2 = setup("/npc/right2", gp.tileSize, gp.tileSize);
		right1 = setup("/npc/left1", gp.tileSize, gp.tileSize);
		right2 = setup("/npc/left2", gp.tileSize, gp.tileSize);
	}
	

	public void setAction() {
		
		if(onPath == true) {
			int goalCol = (gp.player.worldX + gp.player.solidArea.x)/gp.tileSize;
			int goalRow = (gp.player.worldY + gp.player.solidArea.y)/gp.tileSize;
			
			searchPath(goalCol, goalRow);
		}
		
		actionLookCounter ++;
		
		if(actionLookCounter == 120) {
			
			Random random = new Random();
			int i = random.nextInt(100) + 1;
//			System.out.println(i);
			if(i <= 25) {
				direction = "up";
			}
			if(i > 25 && i <= 50) {
				direction = "down";
			}
			if( i > 50 && i <= 75) {
				direction = "left";
			}
			if(i > 75 && i <= 100) {
				direction = "right";
			}
			actionLookCounter = 0;
		}
		
	}
	
}
