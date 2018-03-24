public class Configuration {
    private int DMG;
    private double SP;
    private double EV;
    private double AV;
    private int HEALTH;
    private String ShipName;
    private ShipType type;

    Configuration() {
    }

    protected void reduceShieldPower() {
        if (this.SP >= 20) {
            this.SP -= Math.random() * 20;
        }
    }

    protected void reduceAccuracyValue() {
        if (this.AV >= 20) {
            this.AV -= Math.random() * 20;
        }
    }

    protected void reduceEvasionValue() {
        if (this.EV >= 20) {
            this.EV -= Math.random() * 20;
        }
    }
    public void reduceHealth(double HEALTH) {
        this.HEALTH -= HEALTH;
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
            this.AV = AV;
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
