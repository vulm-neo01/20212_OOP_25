package main;

import entity.NPC_OldMan;
import monster.MON_GreenSlime;
import object.OBJ_Axe;
import object.OBJ_Coin_Bronze;
import object.OBJ_Heart;
import object.OBJ_Key;
import object.OBJ_ManaCrystal;
import object.OBJ_Potion_Red;
import object.OBJ_Shield_Blue;

public class AssetSetter {
	
	GamePanel gp;
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		int mapNum = 0;
		int  i = 0;

		gp.obj[mapNum][i] = new OBJ_Coin_Bronze(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*25;
		gp.obj[mapNum][i].worldY = gp.tileSize*23;
		i++;
		gp.obj[mapNum][i] = new OBJ_Coin_Bronze(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*21;
		gp.obj[mapNum][i].worldY = gp.tileSize*19;
		i++;
		gp.obj[mapNum][i] = new OBJ_Coin_Bronze(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*26;
		gp.obj[mapNum][i].worldY = gp.tileSize*21;
		i++;
		gp.obj[mapNum][i] = new OBJ_Axe(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*33;
		gp.obj[mapNum][i].worldY = gp.tileSize*21;
		i++;
		gp.obj[mapNum][i] = new OBJ_Shield_Blue(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*35;
		gp.obj[mapNum][i].worldY = gp.tileSize*21;
		i++;
		gp.obj[mapNum][i] = new OBJ_Potion_Red(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*22;
		gp.obj[mapNum][i].worldY = gp.tileSize*27;
		i++;
		gp.obj[mapNum][i] = new OBJ_Heart(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*22;
		gp.obj[mapNum][i].worldY = gp.tileSize*29;
		i++;
		gp.obj[mapNum][i] = new OBJ_ManaCrystal(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*22;
		gp.obj[mapNum][i].worldY = gp.tileSize*31;
		i++;
	}
	
	public void setNPC() {
		int mapNum = 0;
		gp.npc[mapNum][0] = new NPC_OldMan(gp);
		gp.npc[mapNum][0].worldX = gp.tileSize*21;
		gp.npc[mapNum][0].worldY = gp.tileSize*21;
		
		gp.npc[mapNum][1] = new NPC_OldMan(gp);
		gp.npc[mapNum][1].worldX = gp.tileSize*39;
		gp.npc[mapNum][1].worldY = gp.tileSize*39;
		
//		gp.npc[0] = new NPC_OldMan(gp);
//		gp.npc[0].worldX = gp.tileSize*9;
//		gp.npc[0].worldY = gp.tileSize*10;

	}
	
	public void setMonster() {
		
		int mapNum = 0;
		int i = 0;
		gp.monster[mapNum][i] = new MON_GreenSlime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*23;
		gp.monster[mapNum][i].worldY = gp.tileSize*36;
		i++;
		gp.monster[mapNum][i] = new MON_GreenSlime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*23;
		gp.monster[mapNum][i].worldY = gp.tileSize*37;
		i++;
		gp.monster[mapNum][i] = new MON_GreenSlime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*24;
		gp.monster[mapNum][i].worldY = gp.tileSize*37;
		i++;
		gp.monster[mapNum][i] = new MON_GreenSlime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*34;
		gp.monster[mapNum][i].worldY = gp.tileSize*42;
		i++;
		gp.monster[mapNum][i] = new MON_GreenSlime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*38;
		gp.monster[mapNum][i].worldY = gp.tileSize*42;
		i++;
		
//		mapNum = 1;
//		gp.monster[i] = new MON_GreenSlime(gp);
//		gp.monster[i].worldX = gp.tileSize*38;
//		gp.monster[i].worldY = gp.tileSize*42;
//		i++;
//		
//		gp.monster[0] = new MON_GreenSlime(gp);
//		gp.monster[0].worldX = gp.tileSize*11;
//		gp.monster[0].worldY = gp.tileSize*10;
//		
//		gp.monster[0] = new MON_GreenSlime(gp);
//		gp.monster[0].worldX = gp.tileSize*11;
//		gp.monster[0].worldY = gp.tileSize*11;
	}
}
