package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.charset.CoderMalfunctionError;
import java.security.spec.ECFieldFp;

import entity.Player;

public class KeyHandler implements KeyListener{
	
	GamePanel gp;
	public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed, shotKeyPressed;
	//DEBUG
	boolean showDebugText = false;
	
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		// title state
		if(gp.gameState == gp.titleState) {
			titlesState(code);
		
		}
		
		//play state
		else if(gp.gameState == gp.playState) {
			
			playState(code);
		}
		
		else if(code == KeyEvent.VK_P) {
			pauseState(code);
		}
		
		//character state
		else if(gp.gameState == gp.characterState) {
			characterState(code);
		}
		
		//Game Over State
		else if(gp.gameState == gp.gameOverState) {
			gameOverState(code);
		}
		
		//Game Win State
		else if(gp.gameState == gp.gameWinState) {
			gameWinState(code);
		}
		
	}
	
	public void titlesState(int code) {
		if(gp.ui.titleScreenState == 0) {
			
			if(code == KeyEvent.VK_W) {
				gp.ui.commandNum--;
				gp.playSE(8);
				if(gp.ui.commandNum < 0) {
					gp.ui.commandNum = 2;
				}
			}
			if(code == KeyEvent.VK_S) {
				gp.ui.commandNum++;
				gp.playSE(8);
				if(gp.ui.commandNum > 2) {
					gp.ui.commandNum = 0;
				}
			}
			if(code == KeyEvent.VK_ENTER) {
				gp.playSE(12);
				if(gp.ui.commandNum == 0) {
					gp.ui.titleScreenState = 1;
				}
				if(gp.ui.commandNum == 1) {
					gp.ui.titleScreenState = 2;
				}
				if(gp.ui.commandNum == 2) {
					System.exit(0);
				}
			}
		}
		else if(gp.ui.titleScreenState == 1) {
			
			if(code == KeyEvent.VK_W) {
				gp.ui.commandNum--;
				gp.playSE(8);
				if(gp.ui.commandNum < 0) {
					gp.ui.commandNum = 3;
				}
			}
			if(code == KeyEvent.VK_S) {
				gp.ui.commandNum++;
				gp.playSE(8);
				if(gp.ui.commandNum > 3) {
					gp.ui.commandNum = 0;
				}
			}
			if(code == KeyEvent.VK_ENTER) {
				gp.playSE(12);
	
				if(gp.ui.commandNum == 0) {
					gp.difficulty = 0;
					gp.setupGame();
					gp.gameState = gp.playState;
					gp.playMusic(0);
				}
				if(gp.ui.commandNum == 1 ) {
					gp.difficulty = 1;
					gp.setupGame();
					gp.gameState = gp.playState;
					gp.playMusic(0);
				}
				if(gp.ui.commandNum == 2 ) {
					gp.difficulty = 2;
					gp.setupGame();
					gp.gameState = gp.playState;
					gp.playMusic(0);
				}
				if(gp.ui.commandNum == 3 ) {
					gp.playMusic(0);
					gp.ui.titleScreenState = 0;
				}
			}
		} else if(gp.ui.titleScreenState == 2) {
			if(code == KeyEvent.VK_W){
        		gp.ui.commandNum--;
        		gp.playSE(8);
        		if(gp.ui.commandNum<0) {
        			
        			gp.ui.commandNum = 1;
        		}
        	}
        	if(code == KeyEvent.VK_S){
        		gp.ui.commandNum++;
        		gp.playSE(8);
        		if(gp.ui.commandNum > 1) {
        			
        			gp.ui.commandNum = 0;
        		}
        	}
        	if(code==KeyEvent.VK_ENTER) {
        		gp.playSE(12);
        		if(gp.ui.commandNum==0) {
        			gp.saveGame.loadSavedGame();
        			gp.setupGame();
        			
        			gp.gameState = gp.playState;
        		}
        		if(gp.ui.commandNum==1) {
        			
        			gp.ui.titleScreenState = 0;
        		}
        		gp.ui.commandNum = 0;
        	}
		}
	}
	
	public void playState(int code) {
		if(code == KeyEvent.VK_W) {
			upPressed = true;
		}
		
		if(code == KeyEvent.VK_S) {
			downPressed = true;
		}
		
		if(code == KeyEvent.VK_A) {
			leftPressed = true;
		}
		
		if(code == KeyEvent.VK_D) {
			rightPressed = true;
		}
		if(code == KeyEvent.VK_C) {
			gp.gameState = gp.characterState;
		}
		if(code == KeyEvent.VK_ENTER ) {
			if(code == KeyEvent.VK_W) {
				upPressed = true;
			}
			
			if(code == KeyEvent.VK_S) {
				downPressed = true;
			}
			
			if(code == KeyEvent.VK_A) {
				leftPressed = true;
			}
			
			if(code == KeyEvent.VK_D) {
				rightPressed = true;
			}
			if(code == KeyEvent.VK_C) {
				gp.gameState = gp.characterState;
			}
			enterPressed = true;
		}
		if(code == KeyEvent.VK_F) {
			shotKeyPressed = true;
		}
		if(code == KeyEvent.VK_P) {
			gp.gameState = gp.pauseState;
		}
		
		
		//DEBUG
		if(code == KeyEvent.VK_T) {
			if(showDebugText == false) {
				showDebugText = true;
			}
			else if(showDebugText == true) {
				showDebugText = false;
			}
		}
		if(code == KeyEvent.VK_R) {
			
			switch (gp.currentMap) {
			case 0: {
				gp.tileM.loadMap("/maps/map1.txt", 0);
				break;
			}
			case 1: {
				gp.tileM.loadMap("/maps/map2.txt", 1);
				break;
			}
			}
		}
	}
	public void pauseState(int code) {
		if(gp.gameState == gp.playState) {
			gp.gameState = gp.pauseState;
		}
		else if (gp.gameState == gp.pauseState) {
			gp.gameState = gp.playState;
		}
	}
	public void characterState(int code) {
		if(code == KeyEvent.VK_C) {
			gp.gameState = gp.playState;
		}
		
		if(code == KeyEvent.VK_W) {
			if(gp.ui.slotRow != 0) {
				gp.ui.slotRow--;
				gp.playSE(8);
			}
		}
		
		if(code == KeyEvent.VK_S) {
			if(gp.ui.slotRow != 3) {
				gp.ui.slotRow++;
				gp.playSE(8);
			}
		}
		
		if(code == KeyEvent.VK_A) {
			if(gp.ui.slotCol != 0) {
				gp.ui.slotCol--;
				gp.playSE(8);
			}
		}
		
		if(code == KeyEvent.VK_D) {
			if(gp.ui.slotCol != 4) {
				gp.ui.slotCol++;
				gp.playSE(8);
			}
		}
		
		if(code == KeyEvent.VK_ENTER) {
			gp.player.selectItem();
		}
	}

	public void gameOverState(int code) {
		if(code == KeyEvent.VK_W) {
			gp.ui.commandNum--;
			if(gp.ui.commandNum < 0) {
				gp.ui.commandNum = 1;
			}
			gp.playSE(8);
		}
		if(code == KeyEvent.VK_S) {
			gp.ui.commandNum++;
			if(gp.ui.commandNum > 1) {
				gp.ui.commandNum = 0;
			}
			gp.playSE(8);
		}
		if(code == KeyEvent.VK_ENTER) {
			gp.playSE(12);
			if(gp.ui.commandNum == 0) {
				gp.gameState = gp.playState;
				gp.retry();
				gp.playMusic(0);
			}
			else if(gp.ui.commandNum == 1) {
				gp.gameState = gp.titleState;
				gp.ui.titleScreenState = 0;
				gp.restart();
				gp.playMusic(0);
			}
		}
	}
		
		public void gameWinState(int code) {
			if(code == KeyEvent.VK_W) {
				gp.ui.commandNum--;
				if(gp.ui.commandNum < 0) {
					gp.ui.commandNum = 1;
				}
				gp.playSE(8);
			}
			if(code == KeyEvent.VK_S) {
				gp.ui.commandNum++;
				if(gp.ui.commandNum > 1) {
					gp.ui.commandNum = 0;
				}
				gp.playSE(8);
			}
			if(code == KeyEvent.VK_ENTER) {
				gp.playSE(12);
				if(gp.ui.commandNum == 0) {
					gp.gameState = gp.playState;
					gp.retry();
					gp.playMusic(0);
				}
				else if(gp.ui.commandNum == 1) {
					gp.gameState = gp.titleState;
					gp.ui.titleScreenState = 0;
					gp.restart();
					gp.playMusic(0);
				}
			}
		}

	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			upPressed = false;
		}
		
		if(code == KeyEvent.VK_S) {
			downPressed = false;
		}
		
		if(code == KeyEvent.VK_A) {
			leftPressed = false;
		}
		
		if(code == KeyEvent.VK_D) {
			rightPressed = false;
		}
		if(code == KeyEvent.VK_F) {
			shotKeyPressed = false;
		}
	}

}
