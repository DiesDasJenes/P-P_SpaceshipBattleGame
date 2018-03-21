import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class ShipTest_ChangeStats {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Ship.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Before
    void before(){
        Ship testShip = new Ship("Testo", 200,100,100,100,100);
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
