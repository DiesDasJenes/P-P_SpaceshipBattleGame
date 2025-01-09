public class Behavior {
    private final Configuration configuration;

    Behavior(Configuration confShip) {
        this.configuration = confShip;
    }

    int doDamage(Ship enemy) {
        if (enemy == null) {
            return 0;
        }
        int hitProbability = getHitProbability(enemy.getConfiguration().getEV());
        int hitNumber = getRandNumber();
        boolean isHit = isHit(hitNumber, hitProbability);
        boolean isCrit = isCriticalHit(hitNumber, hitProbability);
        int damage = configuration.getDMG();
        double otherShieldPower = enemy.getConfiguration().getSP();
        double totalDamage = isCrit ? (((damage * otherShieldPower) / 100.0) * 2) : ((damage * otherShieldPower) / 100.0);

        return isHit ? (int)totalDamage : 0;
    }

    int getHitProbability(double otherEV) {
        int hitProbability = (int)((configuration.getEV() + configuration.getAV()) - otherEV);
        return Math.min(Math.max(hitProbability, 0), 100);
    }

    private int getRandNumber() {
        return (int)(Math.random() * 100.0);
    }

    private boolean isHit(int random, double hitProbability) {
        return random <= hitProbability;
    }

    private boolean isCriticalHit(int random, double hitProbability) {
        return random <= ((hitProbability / 10.0) * 2);
    }

    public void raiseAccuracyValue() {
        double currentAV = configuration.getAV();
        if (currentAV <= 90) {
            configuration.setAV(currentAV + 10);
        }
    }

    public void raiseEvasionValue() {
        double currentEV = configuration.getEV();
        if (currentEV <= 55) {
            configuration.setEV(currentEV + 10);
        }
    }

    public void raiseShieldPower() {
        double currentSP = configuration.getSP();
        if (currentSP <= 90) {
            configuration.setSP(currentSP + 10);
        }
    }
}
