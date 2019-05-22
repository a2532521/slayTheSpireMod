package Power.Holy;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MichaelPower  extends AbstractPower {
    //日志类
    public static final Logger logger =  LogManager.getLogger(MichaelPower.class.getName());

    //能力的ID，判断有无能力、能力层数时填写该Id而不是类名。
    public static final String POWER_ID = "MichaelPower";
    //能力的名称。
    public static final String NAME = "MichaelPower";
    //不需要调用变量的文本描叙，例如钢笔尖（PenNibPower）。
    public static final String DESCRIPITON = "米迦勒的神圣怒火";
    //需要调用变量的文本描叙，例如力量（Strength）、敏捷（Dexterity）等。
    public static final String[] DESCRIPTIONS = {"", "", ""};
    //以上两种文本描叙只需写一个，更新文本方法在第36行。

    //参数：owner-能力施加对象、amount-施加能力层数。在cards的use里面用ApplyPowerAction调用进行传递。
    public MichaelPower(AbstractCreature owner, int amount) {
        this.name = NAME;
        this.ID = POWER_ID;
        //owner-能力施加对象
        this.owner = owner;
        //amount-施加能力层数
        this.amount = amount;
        this.img = ImageMaster.loadImage("能力图片路径");
        //以上五句不可缺少，照抄即可。记得修改this.img的图片路径。

        //调用该方法（第36行）的文本更新函数,更新一次文本描叙，不可缺少。
        updateDescription();
        //能力种类，可以不填写，会默认为PowerType.BUFF。PowerType.BUFF不会被人工制品抵消，PowerType.DEBUFF会被人工制品抵消。
        this.type = PowerType.BUFF;
    }
    @Override
    public void updateDescription() {
        //不需要调用变量的文本更新方式。
        this.description = DESCRIPITON;
        //this.description = (DESCRIPTIONS[0] + 变量1 + DESCRIPTIONS[1] + 变量2 + DESCRIPTIONS[3] + ······);需要调用变量的文本更新方式。
        //例： public static final String[] DESCRIPTIONS = {"在你回合开始时获得","点力量."};
        //   this.description = (DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1]);
        //   通过该方式更新后的文本:在你回合开始时获得amount层力量.
        //   另外一提，除变量this.amount（能力层数对应的变量）外，其他变量被赋值后需要人为调用updateDescription函数进行文本更新。
    }

    /**
     * 在每回合开始的时候
     */
    @Override
    public void atStartOfTurn() {

    }


}
