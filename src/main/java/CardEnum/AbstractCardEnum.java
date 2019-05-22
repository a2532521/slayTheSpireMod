package CardEnum;

import com.evacipated.cardcrawl.modthespire.lib.SpireEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class AbstractCardEnum {
    /**
     * 神圣卡
     */
    @SpireEnum
    public static AbstractCard.CardColor HOLY ;
    /**
     * 邪恶卡
     */
    @SpireEnum
    public static AbstractCard.CardColor EVIL;

    @SpireEnum
    public static AbstractCard.CardColor QUEEN;

    @SpireEnum
    public static AbstractCard.CardColor BELIEF ;
}
