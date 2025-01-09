import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ShipTest {
    @Test
    public void ship_not_null() {
        Configuration conf = new Configuration();
        conf.setType(ShipType.Corvette);
        conf.setShipName("Testo");
        Ship ship = new Ship(conf);
        assertThat(ship).isNotNull();
    }

    @Test
    public void constructor_values_not_over_maximum() {
        Configuration conf = new Configuration();
        conf.setType(ShipType.Corvette);
        conf.setShipName("Testo");
        Ship ship = new Ship(conf);
        assertThat(ship.getConfiguration().getEV())
            .isEqualTo(ShipType.Corvette.getEV());
    }
}
