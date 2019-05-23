package Character;

import CardEnum.AbstractCardEnum;
import CardEnum.CharacterEnum;
import basemod.abstracts.CustomPlayer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.screens.CharSelectInfo;
import com.megacrit.cardcrawl.unlock.UnlockTracker;

import java.util.ArrayList;

public class theFoolCharacter extends CustomPlayer {
    //角色的初始能量值。
    public static final int ENERGY_PER_TURN = 3;
    //战斗界面左下角的能量图标组，详参压缩包内img文件夹内容。
    public static final String[] orbTextures = {
            "图标路径1","图标路径2","图标路径3","图标路径4","图标路径5","图标路径6",
            "图标路径1","图标路径2","图标路径3","图标路径4","图标路径5",
    };
    //战斗界面左下角的能量图标组，详参压缩包内img文件夹内容。
    //也是战斗界面左下角的能量图标的一部分，详参压缩包内img文件夹内容。
    public static final String orbVfx = "img/character/magesButton.png";

    public static final String MAGES_SHOULDER_1 = "img/character/shoulder.png";
    public static final String MAGES_SHOULDER_2 = "img/character/shoulder2.png";
    public static final String MAGES_CORPSE = "img/character/corpse.png";

   // public static final String orbVfx = "img/character/magesButton.png";
    public static final String MAGES_PORTRAIT = "img/character/magesPortrait.jpg";


    /**
     * 初始角色
     */
    public theFoolCharacter(String name, PlayerClass setClass){
        super(name, setClass, orbTextures, orbVfx, MAGES_PORTRAIT, "TheFool");
        //决定初始的XY坐标，游戏内“能量不足”等文本提示位置基于该坐标。
        this.dialogX = this.drawX + 0.0f * Settings.scale;
        this.dialogY = this.drawY + 240.0f * Settings.scale;
        //初始化
        this.initializeClass(MAGES_PORTRAIT, MAGES_SHOULDER_1, MAGES_SHOULDER_2, MAGES_CORPSE,
                getLoadout(), 20.0F, -10.0F, 220.0F, 290.0F, new EnergyManager(ENERGY_PER_TURN));
    }

    //添加初始牌组
    @Override
    public ArrayList<String> getStartingDeck() {
        ArrayList<String> retVal = new ArrayList<String>();
        retVal.add("Tarot_Base_Attack");
        retVal.add("Tarot_Base_Attack");
        retVal.add("Tarot_Base_Attack");
        retVal.add("Tarot_Base_Attack");
        retVal.add("Tarot_Base_Defence");
        retVal.add("Tarot_Base_Defence");
        retVal.add("Tarot_Base_Defence");
        retVal.add("Tarot_Base_Defence");
        retVal.add("Tarot_Base_Draw");
        return retVal;
    }
    //添加初始遗物
    @Override
    public ArrayList<String> getStartingRelics() {
        ArrayList<String> retVal = new ArrayList<String>();
        //初始遗物
        retVal.add("TheFool");
        UnlockTracker.markRelicAsSeen("TheFool");
        return retVal;
    }
    //在角色选择界面的一些描叙内容。
    @Override
    public CharSelectInfo getLoadout() {
        // 参数初始化 1. 名称  2. 描述   3. 血量 4. 最大血量   5. maxOrbs? 6.金币 7 初始化卡
        CharSelectInfo info =    new CharSelectInfo("TAROT", "TAROT。",
                100, 100, 125, 10, 5,
              new theFoolCharacter("TheFool",CharacterEnum.THE_FOOL)  , getStartingRelics(), getStartingDeck(),false);
        return info;
    }

    @Override
    public String getTitle(PlayerClass playerClass) {
        return null;
    }

    @Override
    public AbstractCard.CardColor getCardColor() {
        return null;
    }

    @Override
    public Color getCardRenderColor() {
        return null;
    }

    @Override
    public AbstractCard getStartCardForEvent() {
        return null;
    }

    @Override
    public Color getCardTrailColor() {
        return null;
    }

    @Override
    public int getAscensionMaxHPLoss() {
        return 0;
    }

    @Override
    public BitmapFont getEnergyNumFont() {
        return null;
    }

    @Override
    public void doCharSelectScreenSelectEffect() {

    }

    @Override
    public String getCustomModeCharacterButtonSoundKey() {
        return null;
    }

    @Override
    public String getLocalizedCharacterName() {
        return null;
    }

    @Override
    public AbstractPlayer newInstance() {
        return null;
    }

    @Override
    public String getSpireHeartText() {
        return null;
    }

    @Override
    public Color getSlashAttackColor() {
        return null;
    }

    @Override
    public AbstractGameAction.AttackEffect[] getSpireHeartSlashEffect() {
        return new AbstractGameAction.AttackEffect[0];
    }

    @Override
    public String getVampireText() {
        return null;
    }
}
