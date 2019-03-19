package Card;

import CardEnum.AbstractCardEnum;
import CardEnum.BasisConfigValue;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class HolyCard extends CustomCard {

    //卡牌在游戏中的id
    public static final String ID = "HolyBasis";
    //卡牌显示的名称
    public static final String NAME = "HolyBasis";
    //卡牌下方的描叙内容。
    public static final String DESCRIPTION = "HolyBasis";
    //卡牌的费用。
    private static final int COST = BasisConfigValue.COST_NUMBER_1;
    //
    private static final CardColor colorType = AbstractCardEnum.QUEEN;
    //基础
    private static final CardRarity rarityType = AbstractCard.CardRarity.BASIC;
    //
    private static final CardTarget target = AbstractCard.CardTarget.ENEMY;


    public HolyCard() {
        super(ID, NAME, null, COST, DESCRIPTION, AbstractCard.CardType.SKILL, colorType, rarityType, target);
    }

    @Override
    public void upgrade() {

    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {

    }
}
