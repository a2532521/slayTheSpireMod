package Card;

import CardEnum.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Tarot_Base_Defence_Card extends CustomCard {
    /**
     * 基础防御牌
     */

    //卡牌在游戏中的id
    public static final String ID = "Tarot_Base_Defence";
    //卡牌显示的名称
    public static final String NAME = "Tarot_Base_Defence";
    //卡牌下方的描叙内容。
    public static final String DESCRIPTION = "Tarot_Base_Defence";
    //卡牌的费用。
    private static final int COST = 1;
    // 卡牌种类。决定诸如技能卡、能力卡、攻击卡这种种类。
    private static final CardType cardType = AbstractCard.CardType.SKILL;
    //卡牌颜色。决定该卡牌属于哪个角色。
    private static final CardColor colorType = AbstractCardEnum.TAROT;
    //卡牌稀有度。决定卡牌的稀有度，同时稀有度决定卡牌的出现概率。
    private static final CardRarity rarityType = AbstractCard.CardRarity.BASIC;
    //目标
    private static final CardTarget target = AbstractCard.CardTarget.SELF;

    public Tarot_Base_Defence_Card(){
        super(ID, NAME, null, COST, DESCRIPTION, cardType, colorType, rarityType, target);
        this.baseBlock = 6;//基础格挡值，除升级以外无任何其他加成. this.block为有敏捷等加成的格挡值.


    }
    //初始化
    //用于显示在卡牌一览里。同时也是诸多卡牌复制效果所需要调用的基本方法，用来获得一张该卡的原始模板修改后加入手牌/抽牌堆/弃牌堆/牌组。
    @Override
    public AbstractCard makeCopy() {
        return new Tarot_Base_Defence_Card();
    }

    @Override
    public void upgrade() {

    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {

    }
}
