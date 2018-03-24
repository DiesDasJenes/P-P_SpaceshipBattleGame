import java.util.ArrayList;

public class HitStats {
    public static void main(String[] args) {
        double EVself ;
        double EVenemy;
        double AVself;
        ArrayList<double[]> HitStats = new ArrayList<>();
        int critcount = 0;
        for(int y = 0; y < 100; y+=10){
            EVself=y;
            for(int i = 0; i < 100; i+=10){
                EVenemy=y;
                for(int k = 0; k < 100; k+=10){
                    AVself=y;
                    int HP = getHP(EVself,EVenemy,AVself);
                    int Hit = getHit(HP);
                    boolean isCritHit = isCritHit(Hit,HP);
                    if(Hit<=HP){
                        if(isCritHit){
                            critcount++;
                        }else{
                            double[] hits = {EVself,EVenemy,AVself};
                            HitStats.add(hits);
                        }
                    }
                }
            }
        }

        System.out.println("CRITs:" + critcount);
        System.out.println("Hits:" + HitStats.size());
        for(int h = 414; h < HitStats.size()-200; h++){
            System.out.println("EVS:" + HitStats.get(h)[0] + " " + "EVE:" + HitStats.get(h)[1] + " " + "AVS:" + HitStats.get(h)[2]);
        }
    }


    private static int getHP(double EVself,double EVenemy,double AVself){
        int HP = (int)((EVself+AVself) - EVenemy);
        return HP <= 0 ? 0 : HP >= 100 ? 100 : HP ;
    }

    private static int getHit(double HP){
        return (int)(Math.random()*100);
    }

    private static boolean isCritHit(int Hit, double HP){
        return Hit <= ((HP/10)*2);
    }
}
