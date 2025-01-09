import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Engine {
    //Change List to Map<String,Ship> = new Hashmap<>()
    private List<Ship> playerInformation;

    Engine(List<Ship> playerInformation) {
        this.playerInformation = playerInformation;
    }

    Engine(){}

    public void run() {
        System.out.println("Es werden nun " + playerInformation.size() + " Schiffe gegeneinander kämpfen");
        Ship currentShip = playerInformation.get((int)(Math.random()*playerInformation.size()));
        System.out.println("Wer wird gewinnen? Es beginnt: " + currentShip.getConfiguration().getShipName());
        
        Querist querist = new Querist(System.in, System.out);
        int turn = 0;
        
        while (playerInformation.stream().allMatch(ship -> ship.getConfiguration().getHEALTH() > 0)) {
            currentShip = playerInformation.get(turn % playerInformation.size());
            System.out.println("\nEs ist dran: " + currentShip.getConfiguration().getShipName());
            printAllShipNames();  // Print status of all ships
            
            try {
                Method action = chooseAction(querist);
                if (action.getName().equals("doDamage")) {
                    System.out.println("Welches Schiff angreifen?");
                    Ship target = chooseShip(querist);
                    int damage = (int) action.invoke(currentShip.getBehavior(), target);
                    System.out.println(currentShip.getConfiguration().getShipName() + 
                        " verursacht " + damage + " Schaden bei " + 
                        target.getConfiguration().getShipName());
                } else {
                    action.invoke(currentShip.getBehavior());
                    System.out.println(action.getName() + " wurde ausgeführt");
                }
            } catch (Exception e) {
                System.out.println("Fehler bei der Aktion: " + e.getMessage());
            }
            
            turn++;
        }
        
        Ship winner = playerInformation.stream()
            .filter(ship -> ship.getConfiguration().getHEALTH() > 0)
            .findFirst()
            .orElse(null);
            
        if (winner != null) {
            System.out.println("\nGewinner ist: " + winner.getConfiguration().getShipName());
        } else {
            System.out.println("\nUnentschieden!");
        }
    }

    boolean isHealthoverZero(Ship ship){
        return ship.getConfiguration().getHEALTH() >= 0;
    }

    //http://tutorials.jenkov.com/java-reflection/private-fields-and-methods.html
    //https://stackoverflow.com/questions/34571/how-do-i-test-a-private-function-or-a-class-that-has-private-methods-fields-or
    private Method chooseAction(Querist querist) throws NoSuchMethodException{
        System.out.println("Was möchten sie tun?");
        char c = querist.ask("(A)ngreifen?\n(S)childe aufladen?\n(Z)ielgenauigkeit verstärken?\n(B)ooster verstärken?").toString().charAt(0);
        switch (c){
            case 'Z' : Method raiseAccuracyValue = Behavior.class.getDeclaredMethod("raiseAccuracyValue"); raiseAccuracyValue.setAccessible(true); return raiseAccuracyValue;
            case 'S' : Method raiseShieldPower = Behavior.class.getDeclaredMethod("raiseShieldPower"); raiseShieldPower.setAccessible(true); return raiseShieldPower;
            case 'B' : Method raiseEvasionValue = Behavior.class.getDeclaredMethod("raiseEvasionValue"); raiseEvasionValue.setAccessible(true); return raiseEvasionValue;
            case 'A' : Method doDamage = Behavior.class.getDeclaredMethod("doDamage", Ship.class); doDamage.setAccessible(true); return doDamage;
            default: System.out.println("Eingabe war inkorrekt.\n"); return chooseAction(querist);
        }
    }

    private Ship chooseShip(Querist querist) {
        printAllShipNames();
        String targetName = querist.ask("Gib den Namen des Zielschiffs ein:").toString();
        return playerInformation.stream()
            .filter(ship -> ship.getConfiguration().getShipName().equals(targetName))
            .findFirst()
            .orElseGet(() -> {
                System.out.println("Schiff nicht gefunden, bitte erneut versuchen.");
                return chooseShip(querist);
            });
    }

    private void printAllShipNames() {
        System.out.println("\nAktueller Status:");
        for (Ship ship : playerInformation) {
            System.out.println(ship.toString());
        }
        System.out.println();
    }
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
