package Character;

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

public class WiteCharacter extends CustomPlayer {
    //角色的初始能量值。
    public static final int ENERGY_PER_TURN = 3;
    //战斗界面左下角的能量图标组，详参压缩包内img文件夹内容。
    public static final String[] orbTextures = {
            "图标路径1","图标路径2","图标路径3","图标路径4","图标路径5","图标路径6",
            "图标路径1","图标路径2","图标路径3","图标路径4","图标路径5",
    };
    //战斗界面左下角的能量图标组，详参压缩包内img文件夹内容。
    public static final String orbVfx = "图标路径";//也是战斗界面左下角的能量图标的一部分，详参压缩包内img文件夹内容。

    public WiteCharacter(String name, PlayerClass setClass){
        super(name, setClass, orbTextures, orbVfx, "人物角色立绘动画文件路径", "人物角色立绘图片名");
        //决定初始的XY坐标，游戏内“能量不足”等文本提示位置基于该坐标。
        this.dialogX = this.drawX + 0.0f * Settings.scale;
        this.dialogY = this.drawY + 240.0f * Settings.scale;
        //初始化
        this.initializeClass("人物角色立绘图片路径", "篝火内休息前图片路径", "篝火内休息后图片路径", "死亡结算界面图片路径",
                getLoadout(), 20.0F, -10.0F, 220.0F, 290.0F, new EnergyManager(ENERGY_PER_TURN));

    }
    //添加初始牌组
    public ArrayList<String> getStartingDeck() {
        ArrayList<String> retVal = new ArrayList<String>();
        retVal.add("卡牌Id");
        return retVal;
    }
    //添加初始遗物
    public ArrayList<String> getStartingRelics() {
        ArrayList<String> retVal = new ArrayList<String>();
        retVal.add("遗物Id");
        UnlockTracker.markRelicAsSeen("遗物Id");
        return retVal;
    }
    //在角色选择界面的一些描叙内容。
    public CharSelectInfo getLoadout() {
        return null;
    }


    public String getTitle(PlayerClass playerClass) {
        return null;
    }

    public AbstractCard.CardColor getCardColor() {
        return null;
    }

    public Color getCardRenderColor() {
        return null;
    }

    public AbstractCard getStartCardForEvent() {
        return null;
    }

    public Color getCardTrailColor() {
        return null;
    }

    public int getAscensionMaxHPLoss() {
        return 0;
    }

    public BitmapFont getEnergyNumFont() {
        return null;
    }

    public void doCharSelectScreenSelectEffect() {

    }

    public String getCustomModeCharacterButtonSoundKey() {
        return null;
    }

    public String getLocalizedCharacterName() {
        return null;
    }

    public AbstractPlayer newInstance() {
        return null;
    }

    public String getSpireHeartText() {
        return null;
    }

    public Color getSlashAttackColor() {
        return null;
    }

    public AbstractGameAction.AttackEffect[] getSpireHeartSlashEffect() {
        return new AbstractGameAction.AttackEffect[0];
    }

    public String getVampireText() {
        return null;
    }
}
