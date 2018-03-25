public class Pen_and_Paper_SpaceshipBattleGame {
    public static void main(String[] args) {
        Setup GameConf = new Setup();
        Engine GameEngine = new Engine(GameConf.getPlayerInformation());
        GameEngine.run();
    }
}

