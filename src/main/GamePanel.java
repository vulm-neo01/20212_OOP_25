package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import object.OBJ_Background;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Screen settings
	final int originalTileSize = 16; //16x16
	final int scale = 3;
	
	public final int tileSize = originalTileSize * scale; //48x48 tile
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol; //768px
	public final int screenHeight = tileSize * maxScreenRow; // 576px
	
	
	// WORLD SETTINGS
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	public final int maxMap = 10;
	public int currentMap = 0;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHieght = tileSize * maxWorldRow;
	
	//FPS
	int FPS = 60;
	
	public UI ui = new UI(this);
	TileManager tileM = new TileManager(this);
	public KeyHandler keyH = new KeyHandler(this);
	Sound music = new Sound();
	Sound se = new Sound();
	public CollisionChecker cChecker = new CollisionChecker(this); 
	public AssetSetter aSetter = new AssetSetter(this);
	public EventHandler eHandler = new EventHandler(this);
	Thread gameThread;
	
	//entity and object
	public Player player = new Player(this, keyH);
	public Entity background = new OBJ_Background(this);
	public Entity obj[][] = new Entity[maxMap][20];
	public Entity npc[][] = new Entity[maxMap][10];
	public Entity monster[][] = new Entity[maxMap][20];
	public ArrayList<Entity> projectileList = new ArrayList<>();
	ArrayList<Entity> entityList = new ArrayList<>();
	
	// Set player's default position
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 10;
	
	//Game state
	public int gameState;
	public final int titleState = 0;
	public final int playState = 1;
	public final int pauseState = 2;
	//public final int dialogueState = 3;
	public final int characterState = 4;
	public final int gameOverState = 5;
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void setupGame() {
		gameState = titleState;
		
		aSetter.setObject();
		aSetter.setNPC();
		aSetter.setMonster();
		
//		playMusic(0);
//		stopMusic();
		
	}
	
//	public void setGame() {
//		aSetter.setObject();
//		aSetter.setNPC();
//		aSetter.setMonster();
////		playMusic(0);
////		stopMusic();
//	}
//
	public void retry() {
		player.setDefaultPositions();
		player.restoreLifeAndMan();
//		player.color = ui.characterNum;
//		setupGame();
		aSetter.setObject();
		aSetter.setNPC();
		aSetter.setMonster();
	}
	
	public void restart() {
		player.setDefaultValues();
		player.setDefaultPositions();
		player.restoreLifeAndMan();
		player.setItems();
		aSetter.setObject();
		aSetter.setNPC();
		aSetter.setMonster();
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		
		// DELTA Method
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		while(gameThread != null) {
			
			currentTime =System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			
			lastTime = currentTime;
			
			if(delta >= 1) {
				update();
				repaint();
				delta--;
			}
			
		}
	}
	
	public void update() {
		if(gameState == playState) {
			player.update();
			
			//npc
			for(int i = 0; i < npc[1].length;  i++) {
				if(npc[currentMap][i] != null) {
					npc[currentMap][i].update();
				}
			}
			for(int  i = 0; i < monster[1].length; i++) {
				if(monster[currentMap][i] != null) {
					if(monster[currentMap][i].alive == true && monster[currentMap][i].dying == false) {
						monster[currentMap][i].update();
					}
					if(monster[currentMap][i].alive == false) {
						monster[currentMap][i].checkDrop();
						monster[currentMap][i] = null;
					}
				}
			}
			for(int  i = 0; i < projectileList.size(); i++) {
				if(projectileList.get(i) != null) {
					if(projectileList.get(i).alive == true) {
						projectileList.get(i).update();
					}
					if(projectileList.get(i).alive == false) {
						projectileList.remove(i);
					}
				}
			}
			
		}
		if(gameState == pauseState) {
			
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		//DEBUG
		long drawStart = 0;
		if(keyH.showDebugText == true) {
			drawStart = System.nanoTime();
		}
		
		//title screen
		if(gameState == titleState) {
			ui.draw(g2);
		}else {
			
			// TILEg
			tileM.draw(g2);
			
			// add entity to the list
			entityList.add(player);
			for(int  i = 0; i < npc[1].length; i++) {
				if(npc[currentMap][i] != null) {
					entityList.add(npc[currentMap][i]);
				}
			}
			
			for(int  i = 0; i < obj[1].length; i++) {
				if(obj[currentMap][i] != null) {
					entityList.add(obj[currentMap][i]);
				}
			}
			
			for(int  i = 0; i < monster[1].length; i++) {
				if(monster[currentMap][i] != null) {
					entityList.add(monster[currentMap][i]);
				}
			}
			
			for(int  i = 0; i < projectileList.size(); i++) {
				if(projectileList.get(i) != null) {
					entityList.add(projectileList.get(i));
				}
			}
			
			//sort
			Collections.sort(entityList, new Comparator<Entity>() {

				@Override
				public int compare(Entity e1, Entity e2) {
					int resuls = Integer.compare(e1.worldY, e2.worldY);
					return resuls;
				}
			});
			
			//draw entity
			for(int i = 0; i < entityList.size(); i++) {
				entityList.get(i).draw(g2);
			}
			// empty entity list
			entityList.clear();
//			for(int i = 0; i < entityList.size(); i++) {
//				entityList.remove(i);
//			}
			
			//UI
			ui.draw(g2);
		}
		
		//DEBUG
		if(keyH.showDebugText == true) {
			long drawEnd = System.nanoTime();
			long passed = drawEnd - drawStart;
			
			g2.setFont(new Font("Arial",Font.PLAIN,20));
			g2.setColor(Color.white);
			
			int x = 10;
			int y = 400;
			int lineHeight = 20;
			
			g2.drawString("WorldX" + player.worldX, x, y); y += lineHeight;
			g2.drawString("WorldY" + player.worldY, x, y); y += lineHeight;
			g2.drawString("Col" + (player.worldX + player.solidArea.x)/tileSize, x, y); y += lineHeight;
			g2.drawString("Row" + (player.worldY + player.solidArea.y)/tileSize, x, y); y += lineHeight;
			
			
			g2.drawString("Draw Time " + passed, x, y);
		}
		
		g2.dispose();
	}
	
	public void playMusic(int i) {
		music.setFile(i);
		music.play();
		music.loop();
	}
	
	public void stopMusic() {
		music.stop();
	}
	
	public void playSE(int i) {
		se.setFile(i);
		se.play();
		
	}
}
