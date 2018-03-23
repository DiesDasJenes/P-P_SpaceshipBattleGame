

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FightSimulation {

    private List<Ship> ships;

    private void init() {
        ships = new ArrayList<Ship>();
        System.out.println("Wie viele spielen mit?");
        Integer players = Integer.parseInt(getInput());
        for (int i = 0; i < players; ++i) {
            ships.add(initShipConfiguration());
        }
    }

    private Ship initShipConfiguration() {
        Configuration config = askForConfiguration();
        Ship s = new Ship(config);
        return s;
    }

    private Configuration askForConfiguration(){
        Configuration config = new Configuration();

        System.out.println("Wie ist der Name des Raumschiffes?");
        config.setShipName(getInput());

        System.out.println("Diese Modelle von Raumschiffen stehen zur Auswahl.");
        for (ShipType type : ShipType.values()) {
            System.out.println(type.toString());
        }
        System.out.println("Welches Modell ist das gewünschte Raumschiff?");
        System.out.println("Bitte schreibe den Namen der Klasse");
        String shipType = getInput();
        for (ShipType type : ShipType.values()) {
            if(shipType.equals(type.getTypeName())){
                config.setType(type);
            }
        }
        while (config.getType()==null){
            System.out.println("Der Name der Klasse ergab keinen Treffer");
            System.out.println("Bitte schreibe den Namen der Klasse");
            shipType = getInput();
            for (ShipType type : ShipType.values()) {
                if(shipType.equals(type.getTypeName())){
                    config.setType(type);
                }
            }
        }
        return config;
    }

    private String getInput() {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        return input;
    }

    public static void main(String[] args) {
      FightSimulation FS = new FightSimulation();
      FS.init();
    }

//  Ship shipHero = new Ship("Heros", 200, 30, 80, 30, 50);
    //  Ship shipBaddy = new Ship("Baddies", 150, 40, 80, 20, 70);
    //  Ship[] shipA = {shipHero,shipBaddy};
    //  System.out.println("Guten Abend zur Kampfsimulation");
    //  System.out.println("es werden nun zwei Schiffe gegeneinander kämpfen");
    //  int turn = 0;
    //  int enemy;
    //    while(shipBaddy.getHEALTH() >=0 && shipHero.getHEALTH() >= 0){
    //       System.out.println("Es ist drann: " + shipA[turn]);
    //    System.out.println("Was möchten sie tun?");
    //    System.out.println("(A)ngreifen?\n(S)childe aufladen?\n(Z)ielgenauigkeit verstärken?\n(B)ooster verstärken?");
    //     Scanner sc = new Scanner(System.in);
    //     String eingabe = sc.next();
    //     enemy = turn == 0 ? 1 : 0;
    //      switch (Character.toUpperCase(eingabe.charAt(0))){
    //           case 'A':
    //               shipA[enemy].reduceHealth(shipA[turn].fire(shipA[turn].getDMG(),shipA[enemy].getSP(),shipA[enemy].getEV(),shipA[turn].getAV())); shipA[enemy].reduceEvasionValue(); break;
    //           case 'S':shipA[turn].raiseShieldPower(); break;
    //        case 'Z': shipA[turn].raiseAccuracyValue();break;
    //        case 'B': shipA[turn].raiseEvasionValue();break;
    //   }
    //     turn = turn < shipA.length-1 ? turn + 1 : turn - 1;
    //   }
}

