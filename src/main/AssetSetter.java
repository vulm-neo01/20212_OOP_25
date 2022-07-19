package main;

import entity.NPC_OldMan;
import monster.MON_GrayBat;
import monster.MON_GreenSlime;
import monster.MON_RedBat;
import monster.MON_Witch;
import object.OBJ_Armor_Silver;
import object.OBJ_Axe;
import object.OBJ_Coin_Bronze;
import object.OBJ_Heart;
import object.OBJ_Helmet_Silver;
import object.OBJ_Key;
import object.OBJ_ManaCrystal;
import object.OBJ_Potion_Blue;
import object.OBJ_Potion_Red;
import object.OBJ_Shield_Blue;
import object.OBJ_Shield_Silver;
import object.OBJ_Sword_Vip;
import tiles_interactive.IT_DryTree;

public class AssetSetter {
	
	GamePanel gp;
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		int mapNum = 0;
		int  i = 0;

		gp.obj[mapNum][i] = new OBJ_Axe(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*33;
		gp.obj[mapNum][i].worldY = gp.tileSize*21;
		i++;
		gp.obj[mapNum][i] = new OBJ_Shield_Blue(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*35;
		gp.obj[mapNum][i].worldY = gp.tileSize*21;
		i++;
		gp.obj[mapNum][i] = new OBJ_Potion_Red(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*23;
		gp.obj[mapNum][i].worldY = gp.tileSize*27;
		i++;
		gp.obj[mapNum][i] = new OBJ_Potion_Blue(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*27;
		gp.obj[mapNum][i].worldY = gp.tileSize*27;
		i++;
		gp.obj[mapNum][i] = new OBJ_Potion_Blue(gp);
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
		gp.obj[mapNum][i] = new OBJ_Potion_Red(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*22;
		gp.obj[mapNum][i].worldY = gp.tileSize*25;
		i++;
		gp.obj[mapNum][i] = new OBJ_Helmet_Silver(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*30;
		gp.obj[mapNum][i].worldY = gp.tileSize*30;
		i++;
		gp.obj[mapNum][i] = new OBJ_Armor_Silver(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*32;
		gp.obj[mapNum][i].worldY = gp.tileSize*32;
		i++;
		gp.obj[mapNum][i] = new OBJ_Shield_Silver(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*34;
		gp.obj[mapNum][i].worldY = gp.tileSize*34;
		i++;
		gp.obj[mapNum][i] = new OBJ_Sword_Vip(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*36;
		gp.obj[mapNum][i].worldY = gp.tileSize*36;
		i++;
	}
	
	public void setNPC() {
		int mapNum = 0;
		gp.npc[mapNum][0] = new NPC_OldMan(gp);
		gp.npc[mapNum][0].worldX = gp.tileSize*21;
		gp.npc[mapNum][0].worldY = gp.tileSize*21;
//		
//		gp.npc[mapNum][1] = new NPC_OldMan(gp);
//		gp.npc[mapNum][1].worldX = gp.tileSize*39;
//		gp.npc[mapNum][1].worldY = gp.tileSize*39;
		
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
		gp.monster[mapNum][i] = new MON_RedBat(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*34;
		gp.monster[mapNum][i].worldY = gp.tileSize*37;
		i++;
		gp.monster[mapNum][i] = new MON_Witch(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*34;
		gp.monster[mapNum][i].worldY = gp.tileSize*28;
		i++;
		gp.monster[mapNum][i] = new MON_GrayBat(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*36;
		gp.monster[mapNum][i].worldY = gp.tileSize*20;
		i++;
		
	}
	
	public void setInteractiveTile() {
		int mapNum = 0;
		int i = 0;
//		gp.iTile[mapNum][i]= new IT_DryTree(gp, 27, 12); i++;
//		
//		gp.iTile[mapNum][i]= new IT_DryTree(gp, 28, 12); i++;
//		
//		gp.iTile[mapNum][i]= new IT_DryTree(gp, 29, 12); i++;
//		
//		gp.iTile[mapNum][i]= new IT_DryTree(gp, 30, 12); i++;
//		
//		gp.iTile[mapNum][i]= new IT_DryTree(gp, 31, 12); i++;
	}
}
