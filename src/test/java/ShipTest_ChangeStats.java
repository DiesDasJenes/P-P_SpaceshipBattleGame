import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class ShipTest_ChangeStats {
    private Ship testShip;
    private Ship baddyShip;

    @BeforeEach
    public void setUp() {
        Configuration conf = new Configuration();
        conf.setType(ShipType.Corvette);
        testShip = new Ship(conf);
        testShip.getConfiguration().setShipName("Testo");
        testShip.getConfiguration().setAV(100);
        baddyShip = new Ship(conf);
        baddyShip.getConfiguration().setShipName("Baddy");
        baddyShip.getConfiguration().setEV(10);
    }

    @Test
    public void fire() {
        int damage = testShip.getBehavior().doDamage(baddyShip);
        assertTrue(damage >= 0, "Damage should be zero or positive");
    }

    @Test
    public void reduceHealth() {
        int damage = testShip.getBehavior().doDamage(baddyShip);
        assertTrue(damage >= 0, "Damage should be zero or positive");
        double initialHealth = baddyShip.getConfiguration().getHEALTH();
        baddyShip.getConfiguration().reduceHealth(damage);
        assertTrue(baddyShip.getConfiguration().getHEALTH() < initialHealth, 
            "Health should be reduced");
    }

    @Test
    public void reduceEvasiveValue_to_negativeValue() {
        baddyShip.getConfiguration().setEV(10);
        baddyShip.getConfiguration().reduceEvasionValue();
        assertTrue(baddyShip.getConfiguration().getEV() >= 0, 
            "Evasion value should not be negative");
    }

    @Test
    public void reduceAccuracyValue_to_negativeValue() {
        baddyShip.getConfiguration().setAV(10);
        baddyShip.getConfiguration().reduceAccuracyValue();
        assertTrue(baddyShip.getConfiguration().getAV() >= 0, 
            "Accuracy value should not be negative");
    }

    @Test
    public void raiseAccuracyValue_over_100() {
        baddyShip.getConfiguration().setAV(90);
        baddyShip.getBehavior().raiseAccuracyValue();
        assertTrue(baddyShip.getConfiguration().getAV() <= 100, 
            "Accuracy value should not exceed 100");
    }

    @Test
    public void raiseEvasionValue_over_90() {
        baddyShip.getConfiguration().setEV(85);
        baddyShip.getBehavior().raiseEvasionValue();
        assertTrue(baddyShip.getConfiguration().getEV() <= 90, 
            "Evasion value should not exceed 90");
    }

    @Test
    public void raiseShieldPower_over_100() {
        baddyShip.getConfiguration().setSP(90);
        baddyShip.getBehavior().raiseShieldPower();
        assertTrue(baddyShip.getConfiguration().getSP() <= 100, 
            "Shield power should not exceed 100");
    }
}
