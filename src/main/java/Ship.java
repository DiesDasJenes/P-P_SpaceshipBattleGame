public class Ship {
    private int DMG;
    private double SP;
    private double EV;
    private double AV;
    private int HEALTH;
    private String Name;

    Ship(String Name, int HEALTH, int DMG, double SP, double EV, double AV) {
        this.DMG = DMG;
        this.SP = SP;
        this.EV = EV;
        this.AV = AV;
        this.HEALTH = HEALTH;
        this.Name = Name;
    }

    int fire(int DMG, double SP, double EV, double AV) {
        //System.out.println("Berechnung: " + DMG + " SP: " + SP + " EV ENEMY: " + EV + "SHIP AV: " + AV);
        //System.out.println(((DMG * SP) / 100) / AV - EV);
        double totalDMG = ((DMG * SP) / 100) / AV - EV;
        this.reduceShieldPower();
        System.out.println("Totaler Schaden: " + (int)totalDMG);
        return (int)totalDMG;
    }

    public int getDMG() {
        return DMG;
    }

    public void setDMG(int DMG) {
        this.DMG = DMG;
    }

    public double getSP() {
        return SP;
    }

    public void setSP(double SP) {
        this.SP = SP;
    }

    public double getEV() {
        this.reduceEvasionValue();
        return EV;
    }

    public void setEV(double EV) {
        this.EV = EV;
    }

    public double getAV() {
        this.reduceAccuracyValue();
        return AV;
    }

    public void setAV(double AV) {
        if (AV <= 100) {
            this.AV = AV;
        }
    }

    public double getHEALTH() {
        return HEALTH;
    }

    public void setHEALTH(int HEALTH) {
        this.HEALTH = HEALTH;
    }

    public void reduceHealth(double HEALTH) {
        this.HEALTH += HEALTH;
    }

    public void raiseAccuracyValue() {
        if(this.AV <= 90)
        this.AV += 10;
    }

    public void raiseEvasionValue() {
        if(this.EV <= 50)
        this.EV += 10;
    }

    public void raiseShieldPower() {
        if(this.SP <= 100)
        this.SP += 10;
    }

    private void reduceShieldPower() {
        if (this.SP >= 0) {
            this.SP -= Math.random() * 20;
        }
    }

    void reduceAccuracyValue() {
        if (this.AV >= 10) {
            this.AV -= Math.random() * 20;
        }
    }

    void reduceEvasionValue() {
        if (this.EV >= 10) {
            this.EV -= Math.random() * 20;
        }
    }


    @Override
    public String toString() {
        return "Ship{" +
                "Name=" + Name +
                ", HEALTH=" + HEALTH +
                ", DMG=" + DMG +
                ", ShieldP=" + (int) SP +
                ", EvasionV=" + (int)EV +
                ", AccuracyV=" + (int) AV  +
                '}';
    }


}
