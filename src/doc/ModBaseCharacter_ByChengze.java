//不懂java的术语，所以随便乱称呼，希望dalao不要见怪。2333  
//author：只会写bug的承泽
//编辑于05/11/2018正午， 游戏版本build0503正式版。

package SampleMod;

import java.util.ArrayList;

import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.screens.CharSelectInfo;
import com.megacrit.cardcrawl.unlock.UnlockTracker;

import basemod.abstracts.CustomPlayer;

public class ModBaseCharacter_ByChengze extends CustomPlayer{
	public static final int ENERGY_PER_TURN = 3;//角色的初始能量值。
	public static final String[] orbTextures = {
			"图标路径1","图标路径2","图标路径3","图标路径4","图标路径5","图标路径6",
			"图标路径1","图标路径2","图标路径3","图标路径4","图标路径5",
	};//战斗界面左下角的能量图标组，详参压缩包内img文件夹内容。
	public static final String orbVfx = "图标路径";//也是战斗界面左下角的能量图标的一部分，详参压缩包内img文件夹内容。
	
	public ModBaseCharacter_ByChengze(String name, PlayerClass setClass) {
		super(name, setClass, orbTextures, orbVfx, "人物角色立绘动画文件路径", "人物角色立绘图片名");
		//人物角色立绘动画文件路径  格式："img/char/CharacterName/CharacterName_md.g3dj"。g3dj文件决定人物动画。
		//人物角色立绘图片名  格式："CharacterName_md|idle"。该文件为png格式，和CharacterName_md.g3dj放在同一目录下。
		//g3dj文件见压缩包内img文件夹内内容。
		
		this.dialogX = this.drawX + 0.0f * Settings.scale;
        this.dialogY = this.drawY + 240.0f * Settings.scale;
        //决定初始的XY坐标，游戏内“能量不足”等文本提示位置基于该坐标。
        
		this.initializeClass("人物角色立绘图片路径", "篝火内休息前图片路径", "篝火内休息后图片路径", "死亡结算界面图片路径", getLoadout(), 20.0F, -10.0F, 220.0F, 290.0F, new EnergyManager(ENERGY_PER_TURN));
	}
	
	public static ArrayList<String> getStartingDeck() {
		ArrayList<String> retVal = new ArrayList<>();
		retVal.add("卡牌Id");
		return retVal;
	}//添加初始牌组
	
	public static ArrayList<String> getStartingRelics() {
		ArrayList<String> retVal = new ArrayList<>();
		retVal.add("遗物Id");
		UnlockTracker.markRelicAsSeen("遗物Id");
		return retVal;
	}//添加初始遗物
	
	private CharSelectInfo getLoadout() {
		return new CharSelectInfo("CharacterName", "角色描叙",
				80, 80, 0, 99, 5,
				//参数含义：80，80 - 初始拥有血量和初始最大血量   0-球球数  99-初始金币数量  5-每回合抽牌数量
			null, getStartingRelics(), getStartingDeck(), false);
		//null位置对应参数：CharacterEnum.CharacterName
		//需要新建一个CharacterEnum类import后使用。代码如下：
		//@SpireEnum
		//public static AbstractPlayer.PlayerClass CharacterName; CharacterName为你的角色对应的英文名称
	}//在角色选择界面的一些描叙内容。

}
