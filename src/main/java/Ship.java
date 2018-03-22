public class Ship {
    private ShipConfiguration Configuration;
    private ShipBehavior Behavior;
    Ship(ShipConfiguration confShip) {
        this.Configuration = confShip;
        Behavior = new ShipBehavior(Configuration);
    }

    public ShipConfiguration getConfiguration() {
        return Configuration;
    }

    public ShipBehavior getBehavior() {
        return Behavior;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "Name=" + Configuration.getShipName() +
                ", HEALTH=" + Configuration.getHEALTH() +
                ", DMG=" + Configuration.getDMG() +
                ", ShieldP=" + (int) Configuration.getSP() +
                ", EvasionV=" + (int) Configuration.getEV() +
                ", AccuracyV=" + (int) Configuration.getAV()  +
                '}';
    }
}
