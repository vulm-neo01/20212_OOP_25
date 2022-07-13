package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.FlatteningPathIterator;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import entity.Entity;
import object.OBJ_Background;
import object.OBJ_Heart;
import object.OBJ_ManaCrystal;

public class UI {
	
	GamePanel gp;
	Graphics2D g2;
	Font arial_40, arial_80B;
	BufferedImage heart_full, heart_haft, heart_blank, crystal_full, crystal_blank;
	BufferedImage background, player;
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;
	public boolean gameFinished = false;
//	public String currentDialongueString = "";
	public int commandNum = 0;
	public int titleScreenState = 0;
	public int slotCol = 0;
	public int slotRow = 0;
	
	public UI(GamePanel gp) {
		this.gp = gp;
		arial_40 = new Font("Arial", Font.PLAIN, 40);
		arial_80B = new Font("Arial", Font.BOLD, 80);
		
		// creat hud object
		Entity heart = new OBJ_Heart(gp);
		heart_full = heart.image;
		heart_haft = heart.image2;
		heart_blank = heart.image3;
		Entity crystal = new OBJ_ManaCrystal(gp);
		crystal_full = crystal.image;
		crystal_blank = crystal.image2;
	}

	public void showMessage(String text) {
		message = text;
		messageOn = true;
	}
	
	public void draw(Graphics2D g2) {
		
		this.g2 = g2;
		
		g2.setFont(arial_40);
		g2.setColor(Color.white);
		
		//titles state
		if(gp.gameState == gp.titleState) {
			drawTitlesScreen();
		}
		
		//play state
		if(gp.gameState == gp.playState) {
//			drawPlayerLife();
			drawPlayerLife();
		}
		//pause state
		if(gp.gameState == gp.pauseState) {
			drawPlayerLife();
			drawPauseScreen();
		}
		//character state
		if(gp.gameState == gp.characterState) {
			drawCharacterScreen();
			drawInventory();
		}
		//dialogue state
//		if(gp.gameState == gp.dialogueState) {
//			drawDialogueScreen();
//		}
		if(gp.gameState == gp.gameOverState) {
			drawGameOverScreen();
		}
	}
	
	public void drawPlayerLife() {
		
//		gp.player.life = 6;
		
		int x = gp.tileSize/2;
		int y = gp.tileSize/2;
		int i = 0;
		
		//draw max heart
		while (i < gp.player.maxLife/2) {
			g2.drawImage(heart_blank, x, y, null);
			i++;
			x += gp.tileSize;
			
		}
		
		//heart
		x = gp.tileSize/2;
		y = gp.tileSize/2;
		i = 0;
		
		//draw current life
		while (i < gp.player.life) {
			g2.drawImage(heart_haft, x, y, null);
			i++;
			if(i < gp.player.life) {
				g2.drawImage(heart_full, x, y, null);
			}
			i++;
			x += gp.tileSize;
			
		}
		
		//draw max mana
		x = gp.tileSize /2;
		y = (int)(gp.tileSize *1.5);
		i = 0;
		while (i < gp.player.maxMana) {
			g2.drawImage(crystal_blank, x, y, null);
			i++;
			x += 35;
		}
		
		//draw mana
		x = gp.tileSize /2;
		y = (int)(gp.tileSize *1.5);
		i = 0;
		while (i < gp.player.maxMana) {
			g2.drawImage(crystal_full, x, y, null);
			i++;
			x += 35;
		}
	}
	
	public void drawTitlesScreen() {
		
		if(titleScreenState == 0) {
		
		
			g2.drawImage(gp.background.down1, 0, 0, gp.screenWidth, gp.screenHeight, null);
			
//			g2.setColor(new Color(0, 0, 0));
//			g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
			//titles name
			g2.setFont(g2.getFont().deriveFont(Font.BOLD, 90F));
			String text = "GROUP 25";
			int x = getXforCenteredText(text);
			int y = gp.tileSize*3;
			
			//Shadom
			g2.setColor(Color.gray);
			g2.drawString(text, x + 5, y + 5);
			
			//main color
			g2.setColor(Color.white);
			g2.drawString(text, x, y);
				
			
			//image
			x = gp.screenWidth/2 - (gp.tileSize)*3;
			y += gp.tileSize*2;
			player = setup("/player/boy_down_1", gp.tileSize, gp.tileSize);
			g2.drawImage(player, x, y, gp.tileSize*2, gp.tileSize*2, null);
			if (commandNum == 0) {
				drawButtonCharacter(x - 10 , y - 10, gp.tileSize*2 + 20, gp.tileSize*2 + 20);
//					System.out.println(gp.player.characterNum + " 0000");
			}
			
			//menu
			g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40F));
			
			text = "START";
			x = getXforCenteredText(text);
			y += gp.tileSize*3.5;
			g2.drawString(text, x, y);
			if(commandNum == 1) {
				drawButton(x - 15, y - 50, 170, 65, "START");
			}
			
			
			text = "END";
			x = getXforCenteredText(text);
			y += gp.tileSize*2;
			g2.drawString(text, x, y);
			if(commandNum == 2) {
				drawButton(x-15, y-50, 120, 65, "END");
			}
		} else if(titleScreenState == 1) {
			g2.drawImage(gp.background.down1, 0, 0, gp.screenWidth, gp.screenHeight, null);
			g2.setColor(Color.white);
			g2.setFont(g2.getFont().deriveFont(42F));
			
			String text;
			int x;
			int y = gp.tileSize;
			
			text = "Hard";
			x = getXforCenteredText(text);
			y += gp.tileSize*3;
			g2.drawString(text, x, y);
			if(commandNum == 0) {
				drawButton(x - 15, y - 50, 130, 65, "Hard");
//				g2.drawString(">", x - gp.tileSize, y);
			}
			
			text = "Easy";
			x = getXforCenteredText(text);
			y += gp.tileSize*2;
			g2.drawString(text, x, y);
			if(commandNum == 1) {
				drawButton(x - 15, y - 50, 130, 65, "Easy");
//				g2.drawString(">", x - gp.tileSize, y);
			}
			
			text = "Back";
			x = getXforCenteredText(text);
			y += gp.tileSize*2;
			g2.drawString(text, x, y);
			if(commandNum == 2) {
				drawButton(x - 15, y - 50, 130, 65, "Back");
//				g2.drawString(">", x - gp.tileSize, y);
			}
		}
	}
	
	public void drawPauseScreen() {
		
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
		String text = "PAUSED";
		int x = getXforCenteredText(text);
		
		int y = gp.screenHeight/2;
		
		g2.drawString(text, x, y);
		
	}
	
	public void drawCharacterScreen() {
		//create a frame
		final int frameX = gp.tileSize*2;
		final int frameY = gp.tileSize;
		final int frameWidth = gp.tileSize*5;
		final int frameHeight = gp.tileSize*10;
		drawSubWindow(frameX, frameY, frameWidth, frameHeight);
	
		g2.setColor(Color.white);
		g2.setFont(g2.getFont().deriveFont(32F));
		
		int textX = frameX + 20;
		int textY = frameY + gp.tileSize;
		final int lineHeight = 32;
		
		g2.drawString("Level", textX, textY);
		textY += lineHeight;
		g2.drawString("Life", textX, textY);
		textY += lineHeight;
		g2.drawString("Mana", textX, textY);
		textY += lineHeight;
		g2.drawString("Strength", textX, textY);
		textY += lineHeight;
		g2.drawString("Dexterity", textX, textY);
		textY += lineHeight;
		g2.drawString("Attack", textX, textY);
		textY += lineHeight;
		g2.drawString("Defense", textX, textY);
		textY += lineHeight;
		g2.drawString("Exp", textX, textY);
		textY += lineHeight;
		g2.drawString("Next Level", textX, textY);
		textY += lineHeight;
		g2.drawString("Coin", textX, textY);
		textY += lineHeight + 10;
		g2.drawString("Weapon", textX, textY);
		textY += lineHeight + 15;
		g2.drawString("Shield", textX, textY);
		textY += lineHeight;
		
		//values
		int tailX = (frameX + frameWidth) - 30;
		//reset textX
		textY = frameY + gp.tileSize;
		String value;
		
		value = String.valueOf(gp.player.level);
		textX = getXforAligntoRightText(value, tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.life + "/" + gp.player.maxLife);
		textX = getXforAligntoRightText(value, tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.mana + "/" + gp.player.maxMana);
		textX = getXforAligntoRightText(value, tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.strength);
		textX = getXforAligntoRightText(value, tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.dexterity);
		textX = getXforAligntoRightText(value, tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.attack);
		textX = getXforAligntoRightText(value, tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.defense);
		textX = getXforAligntoRightText(value, tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.exp);
		textX = getXforAligntoRightText(value, tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.nextLevelExp);
		textX = getXforAligntoRightText(value, tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.coin);
		textX = getXforAligntoRightText(value, tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		g2.drawImage(gp.player.currentWeapon.down1, tailX - gp.tileSize, textY -24, null);
		textY += gp.tileSize;
		g2.drawImage(gp.player.currentShield.down1, tailX - gp.tileSize, textY -24, null);
		
	}
//	public void drawDialogueScreen() {
//		//window
//		int x = gp.tileSize*2;
//		int y = gp.tileSize/2;
//		int width = gp.screenWidth - (gp.tileSize*4);
//		int hight = gp.tileSize*4;
//		
//		drawSubWindow(x, y, width, hight);
//	}
//	
	public void drawInventory() {
		
		int frameX = gp.tileSize*9;
		int frameY = gp.tileSize;
		int frameWidht = gp.tileSize*6;
		int frameHeight = gp.tileSize*5;
		
		drawSubWindow(frameX, frameY, frameWidht, frameHeight);
		
		//slot
		final int slotXstart = frameX + 20;
		final int slotYstart = frameY + 20;
		int slotX = slotXstart;
		int slotY = slotYstart;
		int slotSixe = gp.tileSize+3;
		
		//draw player's items
		for(int  i = 0; i < gp.player.inventory.size(); i++) {
			
			if(gp.player.inventory.get(i) == gp.player.currentWeapon ||
					gp.player.inventory.get(i) == gp.player.currentShield) {
				g2.setColor(new Color(240, 190, 90));
				g2.fillRoundRect(slotX, slotY, gp.tileSize, gp.tileSize, 10, 10);
			}
			
			
			g2.drawImage(gp.player.inventory.get(i).down1, slotX, slotY, null);
			
			slotX += slotSixe;
			 
			if(i == 4 || i == 9 || i == 14) {
				slotX = slotXstart;
				slotY += slotSixe;
				
			}
		}
		
		//curson
		int cursonX = slotXstart + (slotSixe * slotCol);
		int cursonY = slotYstart + (slotSixe * slotRow);
		int cursonWidth = gp.tileSize;
		int cursonHeight = gp.tileSize;
		 
		//draw curson
		g2.setColor(Color.white);
		g2.setStroke(new BasicStroke(3));
		g2.drawRoundRect(cursonX, cursonY, cursonWidth, cursonHeight, 10, 10);
		
		//desscription frame
		int dFrameX = frameX;
		int dframeY = frameY + frameHeight;
		int dFrameWidth = frameWidht;
		int dFrameHeight = gp.tileSize*3;
		drawSubWindow(dFrameX, dframeY, dFrameWidth, dFrameHeight);
		
		//desscription frame text
		int textX = dFrameX + 20;
		int textY = dframeY + gp.tileSize;
		g2.setFont(g2.getFont().deriveFont(20F));
		
		int itemIndex = getItemIndexOnSlot();
		
		if(itemIndex < gp.player.inventory.size()) {
			drawSubWindow(dFrameX, dframeY, dFrameWidth, dFrameHeight);
			for(String line: gp.player.inventory.get(itemIndex).description.split("\n") ) {
				g2.drawString(line, textX, textY);
				textY += 32;
			}
		}
		
	}
	
	public void drawGameOverScreen() {
		g2.setColor(new Color(0, 0, 0, 150));
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		
		int x;
		int y;
		String text;
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 110f));
		
		text = "Game Over";
		//Shadow
		g2.setColor(Color.black);
		x = getXforCenteredText(text);
		y = gp.tileSize*4;
		g2.drawString(text, x, y);
		//Main
		g2.setColor(Color.white);
		g2.drawString(text, x-4, y-4);
		
		//Retry
		g2.setFont(g2.getFont().deriveFont(50f));
		text = "Retry";
		x = getXforCenteredText(text);
		y += gp.tileSize*4;
		g2.drawString(text, x, y);
		if(commandNum == 0) {
			drawButton(x-10, y-gp.tileSize, 150, 65, "Retry");
//			g2.drawString(">", x-40, y);
		}
		
		//Back to the title screen
		text = "End";
		x = getXforCenteredText(text);
		y += 65;
		g2.drawString(text, x, y);
		if(commandNum == 1) {
			drawButton(x-10, y-gp.tileSize, 130, 65, "End");
//			g2.drawString(">", x-40, y);
		}
	}
	
	public int getItemIndexOnSlot() {
		int itemIndex = slotCol + (slotRow * 3);
		return itemIndex;
		
	}
	
	public void drawButtonCharacter(int x, int y, int width, int height) {
		Color c = new Color(255, 255, 255);
		g2.setColor(c);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x + 5 , y + 5, width-10, height-10, 25, 25);
	}
	
	public void drawButton(int x, int y, int width, int height, String text) {
		Color c = new Color(255, 0, 0);
		g2.setColor(c);
		g2.fillRoundRect(x, y, width, height, 35, 35);
		
		c = new Color(255, 255, 255);
		g2.setColor(c);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x + 5 , y + 5, width-10, height-10, 25, 25);
		
		g2.drawString(text, x + 15 , y + 50);
	}
	
	public void drawSubWindow(int x, int y, int width, int heght) {
		Color c = new Color(0,0,0,210);
		g2.setColor(c);
		g2.fillRoundRect(x, y, width, heght, 35, 35);
		
		c = new Color(255, 255, 255);
		g2.setColor(c);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x + 5, y + 5, width -10, heght -10, 25, 25);
	}
	
	public int getXforCenteredText(String text) {
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenWidth/2 - length/2;
		return x;
	}
	
	public int getXforAligntoRightText(String text, int tailX) {
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = tailX - length;
		return x;
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
