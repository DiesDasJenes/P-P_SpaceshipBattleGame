import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class BehaviorTest {


    private int damage;
    private int shieldpower;
    private int expected;

    // Inject via constructor
    // ((DMG * SP) / 100) / AV - EV
    // for {8, 2, 10}, numberA = 8, numberB = 2, expected = 10
    public BehaviorTest(int damage, int shieldpower, int expected) {
        this.damage = damage;
        this.shieldpower = shieldpower;
        this.expected = expected;
    }

    // name attribute is optional, provide an unique name for test
    // multiple parameters, uses Collection<Object[]>
    @Parameterized.Parameters(name = "{index}: testAdd({0}+{1}) = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1, 2},
                {2, 2, 4},
                {8, 2, 10},
                {4, 5, 9},
                {5, 5, 10}
        });
    }

    @Test
    public void test_addTwoNumbes() {
       // assertThat(Math.addExact(numberA, numberB), is(expected));
    }

}
