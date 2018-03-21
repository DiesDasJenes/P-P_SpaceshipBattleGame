

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class ShipTest_ChangeStats {
    Ship testShip;
    Ship baddyShip;

    @org.junit.Before
    void Before(){
        ShipConfiguration conf = new ShipConfiguration();
        conf.setType(ShipType.Corvette);
        testShip = new Ship(conf);
        testShip.getConfiguration().setShipName("Testo");
        baddyShip = new Ship(conf);
        baddyShip.getConfiguration().setShipName("Baddy");
    }

    @org.junit.Test
    public void fire() {
    }

    @org.junit.Test
    public void reduceHealth() {
    }

    @org.junit.Test
    public void raiseAccuracyValue() {
    }

    @org.junit.Test
    public void raiseEvasionValue() {
    }

    @org.junit.Test
    public void raiseShieldPower() {
    }
}
