package Card;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class WiteCard extends CustomCard {
    /**
     * “extends CustomCard” 继承basemod的CustomCard类，可以理解为继承了卡牌所需要的几个基本组成部件。
     */

    /**
     * 注：
     * 描叙中存在几个特殊的字符串：
     * 1. !D! 、 !M! 、 !B!。
     * 该字符串全为英文字符，使用时前后需用空格完整地与其他文本前后隔开，从左至右依次表示damage、magicnumber、block三个变量的值，当三个变量值与baseDamage、baseMagicnumber、baseBlock不同时发生对应的颜色变化。
     * 这六个变量的具体信息见：
     * 2. [R]、[G]、[B]
     * 该字符串全为英文字符，使用时前后需用空格完整地与其他文本前后隔开，从左至右依次表示战士的能量、猎手的能量、机器人的能量。
     * 3. 关键字，诸如 力量 、 敏捷。
     * 该字符串无中英文限制，使用时前后需用空格完整地与其他文本前后隔开，游戏中已有的关键字可以直接使用，需要自定义的可以去接口部分自己编辑关键字。（详参ModCore的receiveEditKeywords部分）
     * <p>
     * 实例：  “获得 !M! 层 力量 。如果 力量 超过3层，额外获得 [R] 。”;
     */

    //卡牌在游戏中的id
    public static final String ID = "WiteRelics";
    //卡牌显示的名称
    public static final String NAME = "WiteRelics";
    //卡牌下方的描叙内容。
    public static final String DESCRIPTION = "Wite";
    //卡牌的费用。
    private static final int COST = 1;
    // 卡牌种类。决定诸如技能卡、能力卡、攻击卡这种种类。
    //AbstractCard.CardType.SKILL——技能，AbstractCard.CardType.ATTACK——攻击，AbstractCard.CardType.POWER——能力，AbstractCard.CardType.CURSE——诅咒，AbstractCard.CardType.STATU——状态；
    private static final CardType cardType = AbstractCard.CardType.ATTACK;
    //卡牌颜色。决定该卡牌属于哪个角色。
    //卡牌颜色：需要新建一个AbstractCardEnum类import进该类后使用。代码如下：@SpireEnum /换行  public static AbstractCard.CardColor Color; Color为你的角色对应的颜色）
    private static final CardColor colorType = AbstractCard.CardColor.RED;
    //卡牌稀有度。决定卡牌的稀有度，同时稀有度决定卡牌的出现概率。
    //卡牌分类：AbstractCard.CardRarity.BASIC——基础牌，AbstractCard.CardRarity.COMMON——白卡，AbstractCard.CardRarity.RARE——金卡，AbstractCard.CardRarity.UNCOMMON——蓝卡
    private static final CardRarity rarityType = AbstractCard.CardRarity.BASIC;
    //卡牌目标。决定你打出卡牌时指向效果。
    //卡牌目标（就是选择了卡牌后能选的目标）：AbstractCard.CardTarget.SELF——自己，AbstractCard.CardTarget.SELF_AND_ENEMY——自己以及敌人，AbstractCard.CardTarget.ALL_ENEMY——所有敌人，AbstractCard.CardTarget.ENEMY——敌人；
    private static final CardTarget target = AbstractCard.CardTarget.ENEMY;


    public WiteCard() {
        super(ID, NAME, null, COST, DESCRIPTION, cardType, colorType, rarityType, target);
        this.baseBlock = 0;//基础格挡值，除升级以外无任何其他加成. this.block为有敏捷等加成的格挡值.
        this.baseDamage = 0;//基础伤害值，除升级以外无任何其他加成. this.damage为有力量、钢笔尖等加成的伤害值.
        this.baseMagicNumber = 0;//特殊值。一般用于表示给予power的层数，也可用于表示一些需要出现在描叙文本里的值。和下一行连用。
        this.magicNumber = this.baseMagicNumber;
        this.isEthereal = false;//虚无属性，false不虚无，true虚无。可在该类里调用改变。不虚无就可以赋值为false或者删掉这一行
        this.exhaust = false;//消耗属性，false不消耗，true消耗。可在该类里调用改变。不消耗就可以赋值为false或者删掉这一行
        this.isInnate = false;//固有属性，false不固有，true固有。可在该类里调用改变。不固有就可以赋值为false或者删掉这一行
    }

    //初始化
    //用于显示在卡牌一览里。同时也是诸多卡牌复制效果所需要调用的基本方法，用来获得一张该卡的原始模板修改后加入手牌/抽牌堆/弃牌堆/牌组。
    public AbstractCard makeCopy() {
        return new WiteCard();
    }

    //升级
    //注：该部分为升级的效果部分，此处展示的代码为只能升级一次的代码，如需无限升级，卡牌代码有些许不同但不便于例出，请自行查看灼热攻击源码。
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();//升级名称。必带。
            this.upgradeBlock(3);//升级而增加的护甲。增加的是baseDamage
            this.upgradeDamage(3);//升级而增加的伤害。增加的是baseBlock
            this.upgradeMagicNumber(1);//升级而增加的特殊值。增加的是baseMagicNumber
            this.upgradeBaseCost(1);//升级后的费用。注意括号内的值即为费用，与上方不同！！！！
            this.isEthereal = false;//虚无属性。
            this.exhaust = false;//消耗属性。
            this.isInnate = false;//固有属性。
        }
    }

    //注：卡牌效果的diy区。
    //局部变量：abstractPlayer-玩家，abstractMonster --敌人。
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {

    }

    //canUse返回值为true可以被打出，为false不能被打出。通过自行添加代码可控制卡牌打出与否。可不写此方法。
    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        boolean canUse = super.canUse(p, m);
        //diy区。
        this.cantUseMessage = "";//卡牌不能被打出时所提示的文本。
        return canUse;
    }

    //canUpgrade返回值为true可以被升级，返回值为false不可被升级。通过添加代码可控制升级次数。可不写此方法。
    public boolean canUpgrade() {
        boolean canUpgrade = true;
        //diy区
        //升级时所提示的文本。
        this.cantUseMessage ="";
        return canUpgrade;
    }
    //触发时机：当卡牌被抽到时。
    public void triggerWhenDrawn() {

    }
    //触发时机：当卡牌被丢去弃牌堆时。
    public void onMoveToDiscard() {
        this.rawDescription = "原文本";
        this.initializeDescription();//这两行作用见下applyPower方法。
    }
    //触发时机：当卡牌被复制时。
    public void triggerWhenCopied() {
    }
    //触发时机：当玩家结束回合时。（可能与虚无属性冲突，未测试。如冲突，解决办法：将虚无的三行代码（AbstractCard的2155-2157行）复制丢入。）
    public void triggerOnEndOfPlayerTurn() {
    }
    //触发时机：当其他卡被打出时。
    public void triggerOnOtherCardPlayed(final AbstractCard c) {
    }
    //触发时机：当玩家获得能量时。（回合开始时获得能量是否也会触发未测试。）
    public void triggerOnGainEnergy(final int e, final boolean dueToCard) {
    }
    //触发时机：当一张卡被打出后。
    public void triggerOnCardPlayed(final AbstractCard cardPlayed) {
    }
    //触发时机：当一张卡被打出时。
    public void onPlayCard(final AbstractCard c, final AbstractMonster m) {
    }
    //注：猜测以上两个时机，前者为卡牌效果生效后，后者为卡牌效果生效前。未测试，仅提供参考。

    //触发时机：回合开始时。
    public void atTurnStart() {
    }
    //触发时机：当卡牌被消耗时。
    public void triggerOnExhaust() {
    }
    //触发时机较为复杂。官方用用途之一为抽到卡时更新卡面描叙。方法内两句需连用。如果需要恢复原文本，则在上方的卡牌被丢进抽牌堆的时机内this.rewDescription = 原文本;this.initializeDescription();即可。
    public void applyPowers() {
        this.rawDescription = "修改后的文本";
        this.initializeDescription();
    }
}
