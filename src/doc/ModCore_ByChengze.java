//不懂java的术语，所以随便乱称呼，希望dalao不要见怪。2333  
//author：只会写bug的承泽
//编辑于07/04/2018晚， 游戏版本build0614正式版。

package SampleMod;

import static basemod.DevConsole.logger;

import java.nio.charset.StandardCharsets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.CardHelper;
import com.megacrit.cardcrawl.localization.RelicStrings;

import basemod.BaseMod;
import basemod.ModPanel;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditCharactersSubscriber;
import basemod.interfaces.EditKeywordsSubscriber;
import basemod.interfaces.EditRelicsSubscriber;
import basemod.interfaces.EditStringsSubscriber;
import basemod.interfaces.PostInitializeSubscriber;

public class ModCore_ByChengze implements PostInitializeSubscriber,EditCharactersSubscriber,EditCardsSubscriber,EditRelicsSubscriber,EditStringsSubscriber,EditKeywordsSubscriber {
	//以上继承6个接口，来注入人物mod所需的全部类。其中包括：Cards(卡牌)、Power(能力)、Action(动作)、relics(遗物)、KeyWord(关键字)、Character(角色)。更多接口可详参basemod。
	
	private static final String MODNAME = "SampleMod";//Mod名称。
	private static final String AUTHOR = "chengze";//mod作者。
	private static final String DESCRIPTION = "v0.0.1\n Add a new player.";//Mod描叙，随便写。
	private static final Color COLOR = CardHelper.getColor(0, 0, 0);//mod人物对应的颜色。getColor所需的三个参数分别对应颜色的三个色相R、G、U。查找色相请打开系统自带画图，编辑颜色窗口，右下角的RGU三栏。（仅以Win10的自带画图为例）
	
	public ModCore_ByChengze() {
	    logger.info("============================ 监听初始化事件 ============================");
	    
	    BaseMod.subscribe(this);//监听事件，确保正常注入，不可缺少。
        
        logger.info("============================ 监听初始化事件成功 ============================");
		logger.info("========================正在注入新卡片相关信息========================");
		
		BaseMod.addColor(null,
				COLOR, COLOR, COLOR, COLOR, COLOR, COLOR, COLOR,
                "攻击卡卡背图片路径（小号图片，512x512）", "技能卡卡背图片路径（小号图片，512x512）",
                "能力卡卡背图片路径（小号图片，512x512）", "卡片左上角能量图片路径（小号图片，512x512）",
                "攻击卡卡背图片路径（大号图片，1024x1024）", "技能卡卡背图片路径（大号图片，1024x1024）",
                "能力卡卡背图片路径（大号图片，1024x1024）", "卡片左上角能量图片路径（大号图片，1024x1024）");
		//null位置对应参数：AbstractCardEnum.Color.toString()
		//需要新建一个AbstractCardEnum类import后使用。代码如下：
		//@SpireEnum
		//public static AbstractCard.CardColor Color; Color为你的角色对应的颜色
		
		logger.info("========================注入新卡片相关信息成功========================");
	}
	
	public static void initialize() {
        logger.info("=========================初始化角色Mod数据=========================");
        
        @SuppressWarnings("unused")
        ModCore_ByChengze CharacterName = new ModCore_ByChengze();//初始化角色mod，必备。
        
        logger.info("===========================角色Mod初始化成功===========================");
    }
	
	@SuppressWarnings("deprecation")
	@Override
	public void receivePostInitialize() {
    	Texture badgeTexture = new Texture("mod图标路径");
    	ModPanel settingsPanel = new ModPanel();
    	settingsPanel.addLabel("config里的mod描叙", 400.0f, 700.0f, (me) -> {});
    	BaseMod.registerModBadge(badgeTexture, MODNAME, AUTHOR, DESCRIPTION, settingsPanel);
    	
        Settings.isDailyRun = false;
        Settings.isTrial = false;
        Settings.isDemo = false;
	}//ModTheSpire正常启动mod后，在主界面里多出一项Mods选项来显示启用的Mod信息。以上部分为填写被显示的信息。
	
	@Override
    public void receiveEditCharacters() {
		logger.info("========================正在注入Mod人物信息========================");
		
		logger.info("add " + null);
		//null位置对应参数：CharacterEnum.CharacterName.toString()
		//需要新建一个CharacterEnum类import后使用。代码如下：
		//@SpireEnum
		//public static AbstractPlayer.PlayerClass CharacterName; CharacterName为你的角色对应的英文名称
		
	    BaseMod.addCharacter(
	    		null, "Mod人物名称", "CharacterName class string",
	    		//null位置对应参数：CharacterName.class
	    	    //需要新建一个CharacterName类import后使用，该类负责管理人物的各类初始信息，如初始卡组、初始遗物、人物描叙等。
	    	    //代码过长，无法展示，请详参群内的ModBaseCharacter.java-人物模板。
	    		
	    		null,"Mod人物名称","角色选择界面对应的摁扭图标", "人物选择界面的背景图片",
	    		//null位置对应参数：AbstractCardEnum.BLACK.toString()
	    		//详细解释同该类第50行。
	    		
	    		null);
	            //null位置对应参数CharacterEnum.CharacterName.toString()
	            //详细解释同该类第84行。
	    
		logger.info("========================注入Mod人物信息成功========================");
	}
	
	@Override
	public void receiveEditRelics() {
		logger.info("=========================正在加载新的遗物内容=========================");
        
		//格式：BaseMod.addRelicToCustomPool(new 遗物类名(), null);
		//null位置对应参数：AbstractCardEnum.BLACK.toString()
		//详细解释同该类第50行。
		
		logger.info("=========================加载新的遗物内容成功=========================");
	}//负责注入你所编辑好的遗物。
	
	@Override
	public void receiveEditCards() {
		logger.info("=========================正在加载新的卡牌内容=========================");
		
		//加入卡牌格式:BaseMod.addCard(new 卡牌类名());
		//解锁卡牌格式:UnlockTracker.unlockCard("卡牌Id");
		
		logger.info("=========================加载新的卡牌内容成功=========================");
	}//负责注入你所编辑好的卡牌。
	
	@Override
	public void receiveEditStrings() {
        logger.info("=========================正在加载遗物文本信息=========================");
        
        String relicStrings = Gdx.files.internal("文本位置").readString(String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(RelicStrings.class, relicStrings);
        //除遗物文本信息需要导入外，其他文本信息可在类中直接写好，也可导入，具体实现请详参其他mod。文本文件格式.json。文本编码格式UTF-8。
        
        logger.info("=========================加载遗物文本信息成功========================");
	}//负责加载你编辑好的文本信息。
	
	@Override
	public void receiveEditKeywords() {
	    logger.info("==========================正在注入新的关键字==========================");
	    
	    BaseMod.addKeyword(new String[]{"关键字","关键字"}, "关键字描叙");
	    //文本描叙需要使用到关键字时，请将关键字格式前后加一个空格。
	    //例： DESCRIPTION = "这个位置有一个 关键字 需要体现。";
	    
	    logger.info("==========================注入新的关键字成功==========================");
	}//负责加载关键字。

}
