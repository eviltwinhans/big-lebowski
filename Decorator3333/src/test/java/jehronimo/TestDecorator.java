/**
 * Created by chapchikov on 12.12.2016.
 */
package jehronimo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDecorator {

    MainComponent arrow = null;
    Modificator m = null;

    @Before
    public void setup(){
        arrow = new MainComponent();
        m = new NameModificator(new PreModificator(new PostModificator(arrow)));
    }

    @Test
    public void testDoDamage(){
        m.doDamage(9);
        Assert.assertTrue("Диапазон урона неверно ограничен снизу!", arrow.currentDamage >= 10);
        Assert.assertTrue("Диапазон урона неверно ограничен сверху!", arrow.currentDamage <= 60);
    }
}
