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
		
		up1 = setup("/npc/oldman_up_1", gp.tileSize, gp.tileSize);
		up2 = setup("/npc/oldman_up_2", gp.tileSize, gp.tileSize);
		down1 = setup("/npc/oldman_down_1", gp.tileSize, gp.tileSize);
		down2 = setup("/npc/oldman_down_2", gp.tileSize, gp.tileSize);
		left1 = setup("/npc/oldman_left_1", gp.tileSize, gp.tileSize);
		left2 = setup("/npc/oldman_left_2", gp.tileSize, gp.tileSize);
		right1 = setup("/npc/oldman_right_1", gp.tileSize, gp.tileSize);
		right2 = setup("/npc/oldman_right_2", gp.tileSize, gp.tileSize);
	}
	
//	public void setDialogue() {
//		dialogues[0] = "Hello, Iad.";
//	}
//	
	public void setAction() {
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
