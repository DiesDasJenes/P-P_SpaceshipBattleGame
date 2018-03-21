public class ShipConfiguration {
    private int DMG;
    private double SP;
    private double EV;
    private double AV;
    private int HEALTH;
    private String ShipName;
    private double maxValue = 100;
    private ShipType type;

    ShipConfiguration() {
    }


    private double check_and_correct_to_maximum_value(double value) {
        return value <= maxValue ? value : maxValue;
    }

    private void reduceShieldPower() {
        if (this.SP >= 0) {
            this.SP -= Math.random() * 20;
        }
    }

    private void reduceAccuracyValue() {
        if (this.AV >= 10) {
            this.AV -= Math.random() * 20;
        }
    }

    private void reduceEvasionValue() {
        if (this.EV >= 10) {
            this.EV -= Math.random() * 20;
        }
    }
    public void reduceHealth(double HEALTH) {
        this.HEALTH += HEALTH;
    }


    public int getDMG() {
        return DMG;
    }

    private void setDMG(int DMG) {
        this.DMG = DMG;
    }

    public double getSP() {
        return SP;
    }

    protected void setSP(double SP) {
        this.SP = SP;
    }

    public double getEV() {
        return EV;
    }

    protected void setEV(double EV) {
        this.EV = EV;
    }

    public double getAV() {
        return AV;
    }

    protected void setAV(double AV) {
        if (AV <= 100) {
            this.AV = AV;
        }
    }

    public double getHEALTH() {
        return HEALTH;
    }

    private void setHEALTH(int HEALTH) {
        this.HEALTH = HEALTH;
    }

    public void setShipName(String shipName) {
        this.ShipName = shipName;
    }

    public String getShipName() {
        return ShipName;
    }

    public ShipType getType() {
        return type;
    }

    public void setType(ShipType type) {
        this.type = type;
        setValues();
    }

    private void setValues(){
        setDMG(getType().getDMG());
        setEV(getType().getEV());
        setAV(getType().getAV());
        setHEALTH(getType().getHEALTH());
        setSP(getType().getSP());
    }
}
