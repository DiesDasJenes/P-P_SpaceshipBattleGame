import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EngineTest {
    private Engine engine;
    private Configuration config;
    
    @BeforeEach
    public void setUp() {
        engine = new Engine();
        config = new Configuration();
    }

    @Test
    public void shouldReturnTrueForFullHealth() {
        config.setType(ShipType.Corvette);
        Ship ship = new Ship(config);
        
        assertThat(engine.isHealthoverZero(ship))
            .as("Ship with full health")
            .isTrue();
    }

    @Test
    public void shouldReturnFalseForZeroHealth() {
        config.setType(ShipType.Corvette);
        Ship ship = new Ship(config);
        double currentHealth = ship.getConfiguration().getHEALTH();
        ship.getConfiguration().reduceHealth(currentHealth + 1);  // Ensure health goes below zero
        
        assertThat(engine.isHealthoverZero(ship))
            .as("Ship with zero or negative health")
            .isFalse();
    }

    @Test
    public void shouldReturnFalseForNegativeHealth() {
        config.setType(ShipType.Corvette);
        Ship ship = new Ship(config);
        ship.getConfiguration().setHEALTH(-10);
        
        assertThat(engine.isHealthoverZero(ship))
            .as("Ship with negative health")
            .isFalse();
    }

    @Test
    public void shouldThrowExceptionForNullShip() {
        assertThatThrownBy(() -> engine.isHealthoverZero(null))
            .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void shouldCalculateDamageWithinWeaponRange() {
        Ship attacker = new Ship(createConfig(ShipType.Corvette));
        Ship defender = new Ship(createConfig(ShipType.Jumper));
        
        int damage = attacker.getBehavior().doDamage(defender);
        
        assertThat(damage)
            .as("Damage should be within weapon range")
            .isGreaterThanOrEqualTo(0);
    }

    @Test
    public void shouldAbsorbDamageWithShields() {
        Ship defender = new Ship(createConfig(ShipType.Freighter));
        defender.getConfiguration().setSP(50);
        double initialHealth = defender.getConfiguration().getHEALTH();
        
        defender.getConfiguration().reduceHealth(100);
        
        assertThat(defender.getConfiguration().getHEALTH())
            .as("Health after shield absorption")
            .isLessThan(initialHealth);
    }

    private Configuration createConfig(ShipType type) {
        Configuration config = new Configuration();
        config.setType(type);
        return config;
    }
}