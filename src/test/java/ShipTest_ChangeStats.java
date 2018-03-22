import static org.junit.Assert.*;

public class ShipTest_ChangeStats {
    Ship testShip;
    Ship baddyShip;

    @org.junit.Before
    public void Before(){
        ShipConfiguration conf = new ShipConfiguration();
        conf.setType(ShipType.Corvette);
        testShip = new Ship(conf);
        testShip.getConfiguration().setShipName("Testo");
        testShip.getConfiguration().setAV(100);
        baddyShip = new Ship(conf);
        baddyShip.getConfiguration().setShipName("Baddy");
        baddyShip.getConfiguration().setEV(10);
    }

    private boolean greaterThanorEqual(double a, double b){
        return a >= b;
    }

    private boolean lessThan(double a, double b){
        return a <= b;
    }

    @org.junit.Test
    public void fire() {
        int damage = testShip.getBehavior().fire(testShip.getConfiguration().getDMG(),baddyShip.getConfiguration().getSP(),baddyShip.getConfiguration().getEV(),testShip.getConfiguration().getAV());
        assertNotNull(damage);
        assertTrue("Should have been over or 0", greaterThanorEqual(damage,0));
    }

    @org.junit.Test
    public void reduceHealth() {
        int damage = testShip.getBehavior().fire(testShip.getConfiguration().getDMG(),baddyShip.getConfiguration().getSP(),baddyShip.getConfiguration().getEV(),testShip.getConfiguration().getAV());
        assertTrue("Should be over or 0", greaterThanorEqual(damage,0));
        double basicHealth = baddyShip.getConfiguration().getHEALTH();
        baddyShip.getConfiguration().reduceHealth(damage);
        assertTrue("Should be less than start value",lessThan(baddyShip.getConfiguration().getHEALTH(),basicHealth));
    }

    @org.junit.Test
    public void reduceEvasiveValue_to_negativeValue() {
        baddyShip.getConfiguration().setEV(10);
        baddyShip.getConfiguration().reduceEvasionValue();
        assertTrue("Should be over or 0", greaterThanorEqual(baddyShip.getConfiguration().getEV(),0));
    }

    @org.junit.Test
    public void reduceAccuracyValue_to_negativeValue() {
        baddyShip.getConfiguration().setAV(10);
        baddyShip.getConfiguration().reduceAccuracyValue();
        assertTrue("Should be over or 0", greaterThanorEqual(baddyShip.getConfiguration().getAV(),0));
    }

    @org.junit.Test
    public void raiseAccuracyValue_over_100() {
        baddyShip.getConfiguration().setAV(90);
        baddyShip.getBehavior().raiseAccuracyValue();
        assertTrue("Should be less than 100 or 100",lessThan(baddyShip.getConfiguration().getAV(),100));
    }

    @org.junit.Test
    public void raiseEvasionValue_over_100() {
        baddyShip.getConfiguration().setEV(85);
        baddyShip.getBehavior().raiseEvasionValue();
        assertTrue("Should be less than 90 or 90",lessThan(baddyShip.getConfiguration().getEV(),90));
    }

    @org.junit.Test
    public void raiseShieldPower_over_100() {
        baddyShip.getConfiguration().setSP(90);
        baddyShip.getBehavior().raiseShieldPower();
        assertTrue("Should be less than 100 or 100",lessThan(baddyShip.getConfiguration().getSP(),100));
    }

}
