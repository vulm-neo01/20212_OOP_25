package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UI;
import main.UtilityTool;

public class Entity {
	
	GamePanel gp;
	
	public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
	public BufferedImage attackUp1, attackUp2, attackDown1, attackDown2, attackLeft1, attackLeft2, attackRight1, attackRight2;
	public Rectangle solidArea = new Rectangle(0, 0, 40, 40);
	public Rectangle attackArea = new Rectangle(0, 0, 0, 0);
	public int solidAreaDefaultX, solidAreaDefaultY;
	public boolean collision = false;
//	String dialogues[] = new String[20];
	public BufferedImage image, image2, image3;
	
	//state
	public int worldX, worldY;
	public String direction = "down";
	public int spriteNum = 1;
	public boolean collisionOn = false;
	public boolean invincible = false;
	boolean attacking = false;
	public boolean alive = true;
	public boolean dying = false;
	boolean hpBarOn = false;
	
	
	//counter
	public int spriteCounter = 0;
	public int actionLookCounter = 0;
	public int invincibleCounter = 0;
	public int shotAvaliableCounter = 0;
	int dyingCounter = 0;
	int hpBarCounter = 0;
	
	//character status
	public int maxLife;
	public int life;
	public int maxMana;
	public int mana;
	public int ammo;
	public String name;
	public int speed;
	public int attack;
	public int defense;
	public int exp;
	public int nextLevelExp;
	public int coin;
	public int level;
	public int dexterity;
	public int strength;
	public Entity currentWeapon;
	public Entity currentShield;
	public Projectile projectile;
	
	// item attributes
	public int value;
	public int attackValue;
	public int defenseValue;
	public String description = "";
	public int useCost;
	
	//type
	public int type;		
	public final int type_player = 0;
	public final int type_npc = 1;
	public final int type_monster = 2;
	public final int type_sword = 3;
	public final int type_axe = 4;
	public final int type_shield = 5;
	public final int type_consumable = 6;
	public final int type_pickupOnly = 7;
	
	
	public Entity(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setAction() {
		
	}
	public void damageReaction() {
		
	}
	
	public void use(Entity entity) {
		
	}
	
	public void checkDrop() {
		
	}
	
	public void dropItem(Entity droppedItem) {
		for(int i = 0; i < gp.obj[1].length; i++) {
			if(gp.obj[gp.currentMap][i] == null) {
				gp.obj[gp.currentMap][i] = droppedItem;
				gp.obj[gp.currentMap][i].worldX = worldX;
				gp.obj[gp.currentMap][i].worldY = worldY;
				break;
			}
		}
	}
	
	public void update() {
		setAction();
		
		collisionOn = false;
		gp.cChecker.checkTile(this);
		gp.cChecker.checkObject(this, false);
		gp.cChecker.checkEntity(this, gp.npc);
		gp.cChecker.checkEntity(this, gp.monster);
		boolean contactPlay =  gp.cChecker.checkPlay(this);
		
		if(this.type == type_monster && contactPlay == true) {
			damagePlayer(attack);
		}
		
		if(collisionOn == false) {
			
			switch(direction) {
				case "up":
					worldY -= speed;
					break;
							
				case "down":
					worldY += speed;
					break;
							
				case "left":
					worldX -= speed;
					break;
							
				case "right":
					worldX += speed;
					break;
			}
		}
					
		spriteCounter++;
		if(spriteCounter > 12) {
			if(spriteNum == 1) {
				spriteNum = 2;
			} else if(spriteNum == 2) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
		
		if(invincible == true) {
			invincibleCounter ++;
			if(invincibleCounter > 40) {
				invincible = false;
				invincibleCounter = 0;
			}
		}
		
		if(shotAvaliableCounter < 30) {
			shotAvaliableCounter++;
		}
	}
	
	public void damagePlayer(int attack) {
		if(gp.player.invincible == false) {
			gp.playSE(6);
			
			int damage = attack - gp.player.defense;
			if(damage < 0) {
				damage = 0;
			}
			
			gp.player.life -= 1;
			gp.player.invincible = true;
		}
		
	}
	
	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
		   worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
		   worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
	       worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
			
			switch(direction) {
			case "up":
				if(spriteNum == 1) {image = up1;} 
				if(spriteNum == 2) {image = up2;}
				break;
			case "down":
				if(spriteNum == 1) {image = down1;} 
				if(spriteNum == 2) {image = down2;}
				break;
			case "left":
				if(spriteNum == 1) {image = left1;} 
				if(spriteNum == 2) {image = left2;}
				break;
			case "right":
				if(spriteNum == 1) {image = right1;} 
				if(spriteNum == 2) {image = right2;}
				break;
			}
			
			//monster hp bar
			if(type == 2 && hpBarOn == true) {
				
				double oneScale = (double)gp.tileSize/maxLife;
				double hpBarValue = oneScale*life;
				
				g2.setColor(new Color(35, 35, 35));
				g2.fillRect(screenX - 1, screenY - 16, gp.tileSize + 2, 12);
				
				g2.setColor(new Color(255, 0, 30));
				g2.fillRect(screenX, screenY - 15, (int)hpBarValue, 10);
			
				hpBarCounter++;
				if(hpBarCounter > 100) {
					hpBarCounter = 0;
					hpBarOn = false;
				}
			}
			
			if(invincible == true) {
				hpBarOn = true;
				hpBarCounter = 0;
				checkAlpha(g2, 0.4F);
			}
			if(dying == true) {
				dyingAnimation(g2);
			}
			
			g2.drawImage(image, screenX, screenY, null);
			checkAlpha(g2, 1F);
		}
	}
	
	public void dyingAnimation(Graphics2D g2) {
		dyingCounter++;
		int i = 10;
		if(dyingCounter <= i) {
			checkAlpha(g2, 0f);
		}
		if(dyingCounter > i && dyingCounter <= i*2) {
			checkAlpha(g2, 1f);
		}
		if(dyingCounter > i*2 && dyingCounter <= i*3) {
			checkAlpha(g2, 0f);
		}
		if(dyingCounter > i*3 && dyingCounter <= i*4) {
			checkAlpha(g2, 1f);
		}
		if(dyingCounter > i*4 && dyingCounter <= i*5) {
			checkAlpha(g2, 0f);
		}
		if(dyingCounter > i*5 && dyingCounter <= i*6) {
			checkAlpha(g2, 1f);
		}
		if(dyingCounter > i*6 && dyingCounter <= i*7) {
			checkAlpha(g2, 0f);
		}
		if(dyingCounter > i*7 && dyingCounter <= i*8) {
			checkAlpha(g2, 1f);
		}
		if(dyingCounter > i*8) {
			alive = false;
		}
		
	}
	
	public void checkAlpha(Graphics2D g2, float alphaValue) {
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
	}
	
	public BufferedImage setup(String imagePath, int width, int height) {
		UtilityTool uTool = new UtilityTool();
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
			image = uTool.scaleImage(image, width, height);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return image;
	}
}
