import java.util.Scanner;

public class FightSimulation {

    public static void main(String[] args) throws InterruptedException {
        Ship shipHero = new Ship("Heros", 200, 30, 80, 30, 50);
        Ship shipBaddy = new Ship("Baddies", 200, 40, 80, 10, 50);
        Ship[] shipA = {shipHero,shipBaddy};
        System.out.println("Guten Abend zur Kampfsimulation");
        System.out.println("es werden nun zwei Schiffe gegeneinander kämpfen");
        int turn = 0;
        int enemy;
        while(shipBaddy.getHEALTH() >=0 || shipHero.getHEALTH() >= 0){
            System.out.println("Es ist drann: " + shipA[turn]);
            System.out.println("Was möchten sie tun?");
            System.out.println("(A)ngreifen?\n(S)childe aufladen?\n(Z)ielgenauigkeit verstärken?\n(B)ooster verstärken?");
            Scanner sc = new Scanner(System.in);
            String eingabe = sc.next();
            enemy = turn == 0 ? 1 : 0;
            switch (Character.toUpperCase(eingabe.charAt(0))){
                case 'A':
                    shipA[enemy].reduceHealth(shipA[turn].fire(shipA[turn].getDMG(),shipA[enemy].getSP(),shipA[enemy].getEV(),shipA[turn].getAV())); break;
                case 'S':shipA[turn].raiseShieldPower(); break;
                case 'Z': shipA[turn].raiseAccuracyValue();break;
                case 'B': shipA[turn].raiseEvasionValue();break;
            }
            turn = turn < shipA.length-1 ? turn + 1 : turn - 1;
        }
    }


}

