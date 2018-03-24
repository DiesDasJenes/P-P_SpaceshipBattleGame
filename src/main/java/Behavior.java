public class Behavior {
    Configuration configuration;

    Behavior(Configuration confShip) {
        this.configuration = confShip;
    }

    int doDamage(Ship Enemy) {
        int HP = getHitProbability(Enemy.getConfiguration().getEV());
        int HitNumber = getHitNumber();
        boolean isHit = isHit(HitNumber,HP);
        boolean isCrit = isCriticalHit(HitNumber,HP);
        int DMG = configuration.getDMG();
        double otherSP = Enemy.getConfiguration().getSP();
        double totalDMG = isCrit ? (((DMG * otherSP) / 100)*2) : ((DMG * otherSP) / 100);

        return isHit ? (int)totalDMG: 0;
    }

    int getHitProbability(double otherEV){
        int HP = (int)(((configuration.getEV())+configuration.getAV()) - otherEV);
        return HP <= 0 ? 0 : HP >= 100 ? 100 : HP ;
    }

    private int getHitNumber(){
        return (int)(Math.random()*100);
    }

    private boolean isHit(int Hit, double HP){
        return Hit <= HP;
    }

    private boolean isCriticalHit(int Hit, double HP){
        return Hit <= ((HP/10)*2);
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
