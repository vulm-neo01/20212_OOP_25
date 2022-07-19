package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Armor_Silver;
import object.OBJ_Axe;
import object.OBJ_Coin_Bronze;
import object.OBJ_Heart;
import object.OBJ_Helmet_Normal;
import object.OBJ_Helmet_Silver;
import object.OBJ_ManaCrystal;
import object.OBJ_Potion_Blue;
import object.OBJ_Potion_Red;
import object.OBJ_Rock;
import object.OBJ_Shield_Silver;
import object.OBJ_Sword_Vip;

public class MON_GreenSlime extends Entity{

	GamePanel gp;
	
	public MON_GreenSlime(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		type = type_monster;
		name = "Green Slime";
		getStatsOnDifficulty();
		projectile = new OBJ_Rock(gp);
		
		
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
		maxLife = 4;
		life = maxLife;
		attack = 2;
		defense = 0;
		exp = 2;
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
		up1 = setup("/monster/greenslime_down_1", gp.tileSize, gp.tileSize);
		up2 = setup("/monster/greenslime_down_2", gp.tileSize, gp.tileSize);
		down1 = setup("/monster/greenslime_down_1", gp.tileSize, gp.tileSize);
		down2 = setup("/monster/greenslime_down_2", gp.tileSize, gp.tileSize);
		left1 = setup("/monster/greenslime_down_1", gp.tileSize, gp.tileSize);
		left2 = setup("/monster/greenslime_down_2", gp.tileSize, gp.tileSize);
		right1 = setup("/monster/greenslime_down_1", gp.tileSize, gp.tileSize);
		right2 = setup("/monster/greenslime_down_2", gp.tileSize, gp.tileSize);
	}
	
	public void setAction() {
		
		if(onPath == true) {
			int goalCol = (gp.player.worldX + gp.player.solidArea.x)/gp.tileSize;
			int goalRow = (gp.player.worldY + gp.player.solidArea.y)/gp.tileSize;
			
			searchPath(goalCol, goalRow);
			
			int i = new Random().nextInt(200) + 1;
			if(i > 197 && projectile.alive == false && shotAvaliableCounter == 30) {
				projectile.set(worldX, worldY, direction, true, this);
				gp.projectileList.add(projectile);
				shotAvaliableCounter = 0;
			}
		} else {
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
	public void damageReaction() {
		actionLookCounter = 0;
//		direction = gp.player.direction;
		onPath = true;
	}
	public void checkDrop() {
		
		int i = new Random().nextInt(100) + 1;
		
		if(i < 10) {
			dropItem(new OBJ_Axe(gp));
		}
		if(i >= 10 && i < 20) {
			dropItem(new OBJ_Helmet_Silver(gp));
		}

		if(i >= 30 && i < 40) {
			dropItem(new OBJ_Potion_Red(gp));
		}
		if(i >= 40 && i < 50) {
			dropItem(new OBJ_Potion_Blue(gp));
		}
		if(i >= 50 && i < 70) {
			dropItem(new OBJ_Helmet_Normal(gp));
		}
		if(i >= 70 && i < 85) {
			dropItem(new OBJ_Heart(gp));
		}
		if(i >= 85 && i < 100) {
			dropItem(new OBJ_ManaCrystal(gp));
		}
	}
}
