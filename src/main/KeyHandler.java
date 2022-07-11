package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.charset.CoderMalfunctionError;
import java.security.spec.ECFieldFp;

public class KeyHandler implements KeyListener{
	
	GamePanel gp;
	public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed, shotKeyPressed;
	//DEBUG
	boolean checkDrawTime = false;
	
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
		
	}
	
	public void titlesState(int code) {
		if(gp.ui.titleScreenState == 0) {
			
			if(code == KeyEvent.VK_W) {
				gp.ui.commandNum--;
				if(gp.ui.commandNum < 0) {
					gp.ui.commandNum = 2;
				}
			}
			if(code == KeyEvent.VK_S) {
				gp.ui.commandNum++;
				if(gp.ui.commandNum > 2) {
					gp.ui.commandNum = 0;
				}
			}
			if(code == KeyEvent.VK_ENTER) {
				if(gp.ui.commandNum == 0) {
					gp.ui.titleScreenState = 1;
				}
				if(gp.ui.commandNum == 1) {
					
				}
				if(gp.ui.commandNum == 2 ) {
					System.exit(0);
				}
			}
		}
		else if(gp.ui.titleScreenState == 1) {
			
			if(code == KeyEvent.VK_W) {
				gp.ui.commandNum--;
				if(gp.ui.commandNum < 0) {
					gp.ui.commandNum = 3;
				}
			}
			if(code == KeyEvent.VK_S) {
				gp.ui.commandNum++;
				if(gp.ui.commandNum > 3) {
					gp.ui.commandNum = 0;
				}
			}
			if(code == KeyEvent.VK_ENTER) {
				if(gp.ui.commandNum == 0) {
					System.out.println("You some fighter specific atuff!");
					gp.gameState = gp.playState;
					gp.playMusic(0);
				}
				if(gp.ui.commandNum == 1) {
					System.out.println("You some thief specific atuff!");
					gp.gameState = gp.playState;
					gp.playMusic(0);
				}
				if(gp.ui.commandNum == 2 ) {
					System.out.println("You some scrocerer specific atuff!");
					gp.gameState = gp.playState;
					gp.playMusic(0);
				}
				if(gp.ui.commandNum == 3 ) {
					gp.ui.titleScreenState = 0;
				}
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
		
		
		//DEBUG
		if(code == KeyEvent.VK_T) {
			if(checkDrawTime == false) {
				checkDrawTime = true;
			}
			else if(checkDrawTime == true) {
				checkDrawTime = false;
			}
		}
		if(code == KeyEvent.VK_R) {
			switch (gp.currentMap) {
			case 0: {
				gp.tileM.loadMap("/maps/worldV3.txt", 0);
				break;
			}
			case 1: {
				gp.tileM.loadMap("/maps/interior01.txt", 1);
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
			if(gp.ui.commandNum == 0) {
				gp.gameState = gp.playState;
				gp.retry();
				gp.playMusic(0);
			}
			else if(gp.ui.commandNum == 1) {
				gp.gameState = gp.titleState;
				gp.restart();
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
