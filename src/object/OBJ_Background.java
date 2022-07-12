package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Background extends Entity{
	
	public OBJ_Background(GamePanel gp) {
		super(gp);
		
		name = "Background";
		down1 = setup("/object/background1", 768, 432);
		// TODO Auto-generated constructor stub
	}

}
