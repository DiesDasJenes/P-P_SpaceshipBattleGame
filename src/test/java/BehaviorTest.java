import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class BehaviorTest {


    private int EV;
    private int expected;
    private Behavior Behavior;

    // Trefferwahrscheinlichkeit: ((EV/1.5)+AV)-EVe
    public BehaviorTest(int EV,ShipType type, int expected) {
        this.EV = EV;
        this.expected = expected;
        Configuration configuration = new Configuration();
        configuration.setType(type);
        Behavior = new Behavior(configuration);
    }

    // name attribute is optional, provide an unique name for test
    // multiple parameters, uses Collection<Object[]>
    @Parameterized.Parameters(name = "{index}: getHitProb(EVe={0}+{1}) = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, ShipType.Corvette, 90},
                {40, ShipType.Corvette, 50},
                {50, ShipType.Corvette, 40},
                {80, ShipType.Corvette, 10},
                {90, ShipType.Corvette, 0},
                {100, ShipType.Corvette, 0},
                {0, ShipType.Freighter, 30},
                {40, ShipType.Freighter, 0},
                {50, ShipType.Freighter, 0},
                {80, ShipType.Freighter, 0},
                {90, ShipType.Freighter, 0},
                {100, ShipType.Freighter, 0}
        });
    }

    @Test
    public void getHitProbability() {
       assertThat(Behavior.getHitProbability(EV), is(expected));
    }

}
