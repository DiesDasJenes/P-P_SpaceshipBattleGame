
import java.util.ArrayList;
import java.util.List;

public class Setup {
    private List<Ship> playerInformation;

    Setup() {
        Querist querist = new Querist(System.in,System.out);
        playerInformation = new ArrayList<>();
        getPlayersConfiguration(getPlayerCount(querist),querist);
    }

    int getPlayerCount(Querist querist) {
        String input = querist.ask("Wie viele spielen mit?").toString();
        if (checkOnlyNumbers(input)) {
            int count = Integer.parseInt(input);
            return count < 2 ? getPlayerCount(querist) : count;
        } else {
            return getPlayerCount(querist);
        }
    }

    private boolean checkOnlyNumbers(String input){
        boolean b;
        for (int j = 0; j < input.length(); j++) {
            char c = input.charAt(j);
            b = '0' <= c && c <= '9';
            if (!b) {
                return false;
            }
        }
        return true;
    }

    private void getPlayersConfiguration(int playerCount,Querist querist){
        for (int i = 0; i < playerCount; i++) {
            playerInformation.add(initShipConfiguration(querist));
        }
    }

    private Ship initShipConfiguration(Querist querist) {
        Configuration config = askForConfiguration(querist);
        return new Ship(config);
    }

    private Configuration askForConfiguration(Querist querist){
        Configuration config = new Configuration();
        config.setShipName(this.getShipName(querist));
        config.setType(this.getShipType(querist));
        return config;
    }

    private String getShipName(Querist querist){
        return querist.ask("Wie ist der Name des Raumschiffes?").toString();
    }

    private ShipType getShipType(Querist querist){
        printShipTypes();
        boolean firstRun = true;
        while (true){
            System.out.println(firstRun ? "Welches Modell ist das gewünschte Raumschiff?" : "Der Name des Schiffmodell ergab keinen Treffer");
            String shipType = querist.ask("Bitte schreibe den Namen des Schiffmodell").toString();
            for (ShipType type : ShipType.values()) {
                if(shipType.equals(type.getTypeName())){
                    return type;
                }
            }
            firstRun=false;
        }
    }

    private void printShipTypes(){
        System.out.println("Diese Modelle von Raumschiffen stehen zur Auswahl.");
        for (ShipType type : ShipType.values()) {
            System.out.println(type.toString());
        }
    }

    public List<Ship> getPlayerInformation() {
        return playerInformation;
    }
}
