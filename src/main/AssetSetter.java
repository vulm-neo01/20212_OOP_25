package main;

import entity.NPC_OldMan;
import monster.MON_GrayBat;
import monster.MON_GreenSlime;
import monster.MON_RedBat;
import monster.MON_Witch;
import object.OBJ_Armor_Silver;
import object.OBJ_Axe;
import object.OBJ_Chest;
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
		gp.obj[mapNum][i].worldX = gp.tileSize*35;
		gp.obj[mapNum][i].worldY = gp.tileSize*19;
		i++;
		gp.obj[mapNum][i] = new OBJ_Shield_Blue(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*35;
		gp.obj[mapNum][i].worldY = gp.tileSize*20;
		i++;
		gp.obj[mapNum][i] = new OBJ_Armor_Silver(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*13;
		gp.obj[mapNum][i].worldY = gp.tileSize*23;
		i++;
		gp.obj[mapNum][i] = new OBJ_Potion_Red(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*23;
		gp.obj[mapNum][i].worldY = gp.tileSize*13;
		i++;
		gp.obj[mapNum][i] = new OBJ_Potion_Blue(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*23;
		gp.obj[mapNum][i].worldY = gp.tileSize*14;
		i++;
		gp.obj[mapNum][i] = new OBJ_Potion_Blue(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*39;
		gp.obj[mapNum][i].worldY = gp.tileSize*34;
		i++;
		gp.obj[mapNum][i] = new OBJ_Heart(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*33;
		gp.obj[mapNum][i].worldY = gp.tileSize*19;
		i++;
		gp.obj[mapNum][i] = new OBJ_ManaCrystal(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*33;
		gp.obj[mapNum][i].worldY = gp.tileSize*20;
		i++;
		gp.obj[mapNum][i] = new OBJ_Potion_Red(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*13;
		gp.obj[mapNum][i].worldY = gp.tileSize*21;
		i++;
		gp.obj[mapNum][i] = new OBJ_Helmet_Silver(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*38;
		gp.obj[mapNum][i].worldY = gp.tileSize*40;
		i++;
		gp.obj[mapNum][i] = new OBJ_Shield_Silver(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*39;
		gp.obj[mapNum][i].worldY = gp.tileSize*40;
		i++;
		gp.obj[mapNum][i] = new OBJ_Sword_Vip(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*15;
		gp.obj[mapNum][i].worldY = gp.tileSize*10;
		i++;
		
		mapNum = 1;
		i = 0;
		gp.obj[mapNum][i] = new OBJ_Chest(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*12;
		gp.obj[mapNum][i].worldY = gp.tileSize*8;
		i++;
		gp.obj[mapNum][i] = new OBJ_Key(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*23;
		gp.obj[mapNum][i].worldY = gp.tileSize*25;
		i++;
		gp.obj[mapNum][i] = new OBJ_Heart(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*37;
		gp.obj[mapNum][i].worldY = gp.tileSize*41;
		i++;
		gp.obj[mapNum][i] = new OBJ_ManaCrystal(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*37;
		gp.obj[mapNum][i].worldY = gp.tileSize*42;
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
		gp.monster[mapNum][i].worldX = gp.tileSize*12;
		gp.monster[mapNum][i].worldY = gp.tileSize*38;
		i++;
		gp.monster[mapNum][i] = new MON_GreenSlime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*13;
		gp.monster[mapNum][i].worldY = gp.tileSize*39;
		i++;
		gp.monster[mapNum][i] = new MON_GreenSlime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*14;
		gp.monster[mapNum][i].worldY = gp.tileSize*40;
		i++;
		gp.monster[mapNum][i] = new MON_GreenSlime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*17;
		gp.monster[mapNum][i].worldY = gp.tileSize*32;
		i++;
		gp.monster[mapNum][i] = new MON_GreenSlime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*19;
		gp.monster[mapNum][i].worldY = gp.tileSize*32;
		i++;
		gp.monster[mapNum][i] = new MON_GreenSlime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*10;
		gp.monster[mapNum][i].worldY = gp.tileSize*30;
		i++;
		gp.monster[mapNum][i] = new MON_GreenSlime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*26;
		gp.monster[mapNum][i].worldY = gp.tileSize*31;
		i++;
		gp.monster[mapNum][i] = new MON_RedBat(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*34;
		gp.monster[mapNum][i].worldY = gp.tileSize*20;
		i++;
		gp.monster[mapNum][i] = new MON_Witch(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*10;
		gp.monster[mapNum][i].worldY = gp.tileSize*16;
		i++;
		gp.monster[mapNum][i] = new MON_GrayBat(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*18;
		gp.monster[mapNum][i].worldY = gp.tileSize*21;
		i++;
		gp.monster[mapNum][i] = new MON_GrayBat(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*37;
		gp.monster[mapNum][i].worldY = gp.tileSize*37;
		i++;

		
		
		mapNum = 1;
		i = 0;
		gp.monster[mapNum][i] = new MON_GrayBat(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*23;
		gp.monster[mapNum][i].worldY = gp.tileSize*33;
		i++;
		gp.monster[mapNum][i] = new MON_RedBat(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*22;
		gp.monster[mapNum][i].worldY = gp.tileSize*39;
		i++;
		gp.monster[mapNum][i] = new MON_GreenSlime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*36;
		gp.monster[mapNum][i].worldY = gp.tileSize*36;
		i++;
		gp.monster[mapNum][i] = new MON_GreenSlime(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*35;
		gp.monster[mapNum][i].worldY = gp.tileSize*35;
		i++;
		gp.monster[mapNum][i] = new MON_RedBat(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*36;
		gp.monster[mapNum][i].worldY = gp.tileSize*24;
		i++;
		gp.monster[mapNum][i] = new MON_RedBat(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*11;
		gp.monster[mapNum][i].worldY = gp.tileSize*16;
		i++;
		gp.monster[mapNum][i] = new MON_GrayBat(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*12;
		gp.monster[mapNum][i].worldY = gp.tileSize*16;
		i++;
		gp.monster[mapNum][i] = new MON_Witch(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*36;
		gp.monster[mapNum][i].worldY = gp.tileSize*33;
		i++;
		gp.monster[mapNum][i] = new MON_RedBat(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*36;
		gp.monster[mapNum][i].worldY = gp.tileSize*8;
		i++;
		gp.monster[mapNum][i] = new MON_RedBat(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*36;
		gp.monster[mapNum][i].worldY = gp.tileSize*9;
		i++;
		gp.monster[mapNum][i] = new MON_RedBat(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*37;
		gp.monster[mapNum][i].worldY = gp.tileSize*9;
		i++;
		gp.monster[mapNum][i] = new MON_RedBat(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*37;
		gp.monster[mapNum][i].worldY = gp.tileSize*9;
		i++;
		gp.monster[mapNum][i] = new MON_Witch(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*11;
		gp.monster[mapNum][i].worldY = gp.tileSize*30;
		i++;
		gp.monster[mapNum][i] = new MON_Witch(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*12;
		gp.monster[mapNum][i].worldY = gp.tileSize*30;
		i++;
		gp.monster[mapNum][i] = new MON_GrayBat(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*11;
		gp.monster[mapNum][i].worldY = gp.tileSize*31;
		i++;
		gp.monster[mapNum][i] = new MON_GrayBat(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*12;
		gp.monster[mapNum][i].worldY = gp.tileSize*31;
		i++;

		
	}
	
	public void setInteractiveTile() {
		int mapNum = 1;
		int i = 0;
		gp.iTile[mapNum][i]= new IT_DryTree(gp, 27, 12); i++;
		
		gp.iTile[mapNum][i]= new IT_DryTree(gp, 28, 12); i++;
		
		gp.iTile[mapNum][i]= new IT_DryTree(gp, 29, 12); i++;
		
		gp.iTile[mapNum][i]= new IT_DryTree(gp, 30, 12); i++;
		
		gp.iTile[mapNum][i]= new IT_DryTree(gp, 31, 12); i++;
		
	}
}
