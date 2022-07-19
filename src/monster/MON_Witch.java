package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Armor_Silver;
import object.OBJ_Fireball;
import object.OBJ_Potion_Blue;
import object.OBJ_Potion_Red;
import object.OBJ_Shield_Silver;
import object.OBJ_Sword_Vip;

public class MON_Witch extends Entity{

	GamePanel gp;
	
	public MON_Witch(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		type = type_monster;
		name = "Gray Bat";
		getStatsOnDifficulty();
		projectile = new OBJ_Fireball(gp);
		
		
		solidArea.x = 3;
		solidArea.y = 18;
		solidArea.width = 42;
		solidArea.height = 30;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
	}
	
	public void getStatsOnDifficulty() {
		speed = 1;
		maxLife = 6;
		life = maxLife;
		attack = 8;
		defense = 2;
		exp = 8;
		switch(gp.difficulty) {
		case 0:
			break;
		case 1:
			speed = (int)(1.2*speed);
			maxLife = (int)(1.5*maxLife);
			life = maxLife;
			attack = (int)(1.2*attack);
			defense = (int)(1.2*defense);
			break;
		case 2:
			speed = (int)(1.5*speed);
			maxLife = (int)(2*maxLife);
			life = maxLife;
			attack = (int)(1.5*attack);
			defense = (int)(1.5*defense);
			break;
		default: 
			break;
		}
	}
	
	public void getImage() {
		up1 = setup("/monster/npc5_bk1", gp.tileSize, gp.tileSize);
		up2 = setup("/monster/npc5_bk2", gp.tileSize, gp.tileSize);
		down1 = setup("/monster/npc5_fr1", gp.tileSize, gp.tileSize);
		down2 = setup("/monster/npc5_fr2", gp.tileSize, gp.tileSize);
		left1 = setup("/monster/npc5_lf1", gp.tileSize, gp.tileSize);
		left2 = setup("/monster/npc5_lf2", gp.tileSize, gp.tileSize);
		right1 = setup("/monster/npc5_rt1", gp.tileSize, gp.tileSize);
		right2 = setup("/monster/npc5_rt2", gp.tileSize, gp.tileSize);
	}
	
	public void setAction() {
		
			int goalCol = (gp.player.worldX + gp.player.solidArea.x)/gp.tileSize;
			int goalRow = (gp.player.worldY + gp.player.solidArea.y)/gp.tileSize;
			int mCol = (worldX + solidArea.x)/gp.tileSize;
			int mRow = (worldY + solidArea.y)/gp.tileSize;
			
			if((Math.abs(mCol - goalCol)) <= 10 && (Math.abs(mRow - goalRow)) <= 10) {
				searchPath(goalCol, goalRow);
			}
			
			int i = new Random().nextInt(200) + 1;
			if(i > 197 && projectile.alive == false && shotAvaliableCounter == 30) {
				projectile.set(worldX, worldY, direction, true, this);
				gp.projectileList.add(projectile);
				shotAvaliableCounter = 0;
			}
			
			actionLookCounter ++;
		
			if(actionLookCounter == 60) {
			
				Random random = new Random();
				int j = random.nextInt(100) + 1;
	//			System.out.println(i);
				if(j <= 25) {
					direction = "up";
				}
				if(j > 25 && j <= 50) {
					direction = "down";
				}
				if( j > 50 && j <= 75) {
					direction = "left";
				}
				if(j > 75 && j <= 100) {
					direction = "right";
				}
				actionLookCounter = 0;
			}
		}
		
		
		
	public void damageReaction() {
		actionLookCounter = 0;
//		direction = gp.player.direction;
		onPath = true;
	}
	public void checkDrop() {
		
		int i = new Random().nextInt(100) + 1;
		
		if(i < 20) {
			dropItem(new OBJ_Sword_Vip(gp));
		}
		if(i >= 20 && i < 35) {
			dropItem(new OBJ_Armor_Silver(gp));
		}

		
		if(i >= 35 && i < 50) {
			dropItem(new OBJ_Potion_Red(gp));
		}
		if(i >= 50 && i < 70) {
			dropItem(new OBJ_Potion_Blue(gp));
		}
		if(i >= 70 && i < 100) {
			dropItem(new OBJ_Shield_Silver(gp));
		}
		
	}
}
