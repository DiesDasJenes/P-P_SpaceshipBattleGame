import org.junit.Test;

import static org.junit.Assert.*;

public class EngineTest {

    // https://www.artima.com/suiterunner/privateP.html
    @Test
    public void isHealthoverZero() {
        Engine e = new Engine();
        Configuration c = new Configuration();
        c.setType(ShipType.Corvette);
        Ship ship = new Ship(c);
        assertEquals(true,e.isHealthoverZero(ship));
    }
}