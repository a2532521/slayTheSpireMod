import basemod.interfaces.*;
import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.helpers.CardHelper;

public class TarotModCore implements PostInitializeSubscriber, EditCharactersSubscriber, EditCardsSubscriber, EditRelicsSubscriber, EditStringsSubscriber, EditKeywordsSubscriber {
    /**
     * 以上继承6个接口，来注入人物mod所需的全部类。
     * 其中包括：Cards(卡牌)、Power(能力)、Action(动作)、relics(遗物)、KeyWord(关键字)、Character(角色)。更多接口可详参basemod。
     */
    //Mod名称。
    private static final String MODNAME = "TarotMod";
    //mod作者。
    private static final String AUTHOR = "sxk";
    //Mod描叙，随便写。
    private static final String DESCRIPTION = "v0.0.1\n Add a new player.";
    //mod人物对应的颜色。getColor所需的三个参数分别对应颜色的三个色相R、G、U。查找色相请打开系统自带画图，编辑颜色窗口，右下角的RGU三栏。（仅以Win10的自带画图为例）
    private static final Color COLOR = CardHelper.getColor(255, 255, 0);

    @Override
    public void receiveEditCards() {

    }

    @Override
    public void receiveEditCharacters() {

    }

    @Override
    public void receiveEditKeywords() {

    }

    @Override
    public void receiveEditRelics() {

    }

    @Override
    public void receiveEditStrings() {

    }

    @Override
    public void receivePostInitialize() {

    }
}
