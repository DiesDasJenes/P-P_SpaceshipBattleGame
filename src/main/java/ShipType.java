public enum ShipType {
    Jumper("Jumper",200, 30, 80, 30, 50),
    Corvette("Corvette", 150, 40, 80, 20, 70),
    Freighter("Freighter",200, 30, 40, 10, 20);

    private String TypeName;
    private int DMG;
    private double SP;
    private double EV;
    private double AV;
    private int HEALTH;

    ShipType(String TypeName, int HEALTH, int DMG, double SP, double EV, double AV){
        this.TypeName = TypeName;
        this.HEALTH = HEALTH;
        this.DMG = DMG;
        this.SP = SP;
        this.EV = EV;
        this.AV = AV;
    }

    @Override
    public String toString() {
        return  "Raumschiffklasse:'" + TypeName + '\'' +
                ", Schaden=" + DMG +
                ", Schildstärke=" + SP +
                ", Basis-Beschleunigung=" + EV +
                ", Basis-Zielgenauigkeit=" + AV +
                ", Gesundheit=" + HEALTH ;
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
        return EV;
    }

    public void setEV(double EV) {
        this.EV = EV;
    }

    public double getAV() {
        return AV;
    }

    public void setAV(double AV) {
        this.AV = AV;
    }

    public int getHEALTH() {
        return HEALTH;
    }

    public void setHEALTH(int HEALTH) {
        this.HEALTH = HEALTH;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String typeName) {
        TypeName = typeName;
    }
}
