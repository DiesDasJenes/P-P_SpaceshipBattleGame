

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;


public class ShipTest {


    @org.junit.Test
    public void ship_not_null(){
        Configuration conf = new Configuration();
        conf.setType(ShipType.Corvette);
        conf.setShipName("Testo");
        Ship ship = new Ship(conf);
        assertNotNull(ship);
    }

    @org.junit.Test
    public void constructor_values_not_over_maximum(){
        Configuration conf = new Configuration();
        conf.setType(ShipType.Corvette);
        conf.setShipName("Testo");
        Ship ship = new Ship(conf);
        assertThat(ship.getConfiguration().getEV(), equalTo(ShipType.Corvette.getEV()));
    }
}
