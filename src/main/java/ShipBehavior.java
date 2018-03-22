public class ShipBehavior {
    ShipConfiguration configuration;

    ShipBehavior(ShipConfiguration confShip) {
        this.configuration = confShip;
    }

    int fire(int DMG, double SP, double EV, double AV) {
        double totalDMG = ((DMG * SP) / 100) / AV - EV;
        return (int)totalDMG < 0 ? 0 : (int)totalDMG;
    }


    public void raiseAccuracyValue() {
        double currentAV = configuration.getAV();
        if(currentAV <= 90)
            configuration.setAV(currentAV+10);
    }

    public void raiseEvasionValue() {
        double currentEV = configuration.getEV();
        if(currentEV <= 55)
            configuration.setEV(currentEV+10);
    }

    public void raiseShieldPower() {
        double currentSP = configuration.getSP();
        if(currentSP <= 90)
            configuration.setSP(currentSP+10);
    }
}
