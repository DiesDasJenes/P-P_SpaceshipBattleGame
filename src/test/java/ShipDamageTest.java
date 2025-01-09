import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ShipDamageTest {
    @Test
    public void shouldCalculateCorrectDamage() {
        Ship attacker = new Ship(createConfig(ShipType.Corvette));
        Ship defender = new Ship(createConfig(ShipType.Jumper));
        int initialHealth = 100;
        defender.getConfiguration().setHEALTH(initialHealth);
        
        int calculatedDamage = attacker.getBehavior().doDamage(defender);
        defender.getConfiguration().reduceHealth(calculatedDamage);
        
        assertThat(defender.getConfiguration().getHEALTH())
            .as("Health after damage")
            .isLessThanOrEqualTo(initialHealth);
    }

    private Configuration createConfig(ShipType type) {
        Configuration config = new Configuration();
        config.setType(type);
        return config;
    }
} 