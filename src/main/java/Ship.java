public class Ship {
    private Configuration Configuration;
    private Behavior Behavior;
    Ship(Configuration confShip) {
        this.Configuration = confShip;
        Behavior = new Behavior(Configuration);
    }

    public Configuration getConfiguration() {
        return Configuration;
    }

    public Behavior getBehavior() {
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
