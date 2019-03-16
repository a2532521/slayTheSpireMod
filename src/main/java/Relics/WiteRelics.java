package Relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class WiteRelics extends CustomRelic {
    //遗物Id，添加遗物、替换遗物时填写该id而不是遗物类名。
    public static final String ID = "ModBaseRelics";
    //遗物图片路径
    public static final String IMG = "遗物图片路径";
    //遗物外轮廓路径
    public static final String OUTLINE = "遗物外轮廓路径";

    //特殊格式： 1.文本描叙中#r、#y、#b、#g分别能使文本变成红、黄、蓝、绿色。
    //         使用方法：将需要变色的部分无空格放在#r(#y/#b/#g)后面，然后将这一块前后用空格与其他文本隔开。
    //         例：public static final DESCRIPTION = "回合开始时获得 #b3 点力量.";
    //       2.文本描叙中[R]、[G]、[B]分别对应战士、猎手、机器人的能量。
    //         使用方法同上，不再赘叙。
    public static final String DESCRIPTION = "文本描叙";//遗物效果的文本描叙。


    public WiteRelics() {
        //参数：ID-遗物Id，new Texture(Gdx.files.internal(IMG))-遗物图片，new Texture(Gdx.files.internal(OUTLINE))-遗物轮廓，
        //RelicTier.BOSS-遗物种类，LandingSound.FLAT-遗物音效。
        //遗物种类：RelicTier.BOSS-boss遗物, RelicTier.COMMON-一般遗物, RelicTier.RARE-罕见遗物, RelicTier.SHOP-商店遗物, RelicTier.SPECIAL-事件遗物, RelicTier.STARTER-初始遗物, RelicTier.UNCOMMON-稀有遗物。
        //遗物音效：LandingSound.CLINK,LandingSound.FLAT,LandingSound.HEAVY,LandingSound.MAGICAL,LandingSound.SOLID  具体音效请到游戏内听。
        super(ID, new Texture(Gdx.files.internal(IMG)), new Texture(Gdx.files.internal(OUTLINE)), RelicTier.BOSS, LandingSound.FLAT);
    }

}
