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
          System.out.println("Es werden nun " +  playerInformation.size() + " Schiffe gegeneinander kämpfen");
          System.out.println("Wer wird gewinnen? Es beginnt: " + playerInformation.get((int)(Math.random()*playerInformation.size())).getConfiguration().getShipName());
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

    private Ship chooseShip(Querist querist){
        return new Ship(new Configuration());
    }

    private void printAllShipNames(){
        for(int i = 0; i < playerInformation.size(); i++) {
            if(i%5==0){
                System.out.println("\n");
            }
            System.out.print(" " + playerInformation.get(i) + " ");
        }
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
