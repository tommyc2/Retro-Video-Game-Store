package controller;
import model.GamePort;
import model.OriginalGame;
import model.GameMachine;
import dataStructures.CustomLinkedList.*;
import utils.Utilities;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import java.io.*;




public class SystemAPI {

    private CustomLinkedList<GameMachine> gameMachines = new CustomLinkedList<>();

    public SystemAPI() {
    }

    public CustomLinkedList<GameMachine> getGameMachines() {
        return gameMachines;
    }

    //-----------------\\
    //     CRUD        \\
    //-----------------\\

    public boolean addGameToMachine(String machineName, OriginalGame newGame) {
        for (GameMachine gameMachine : gameMachines) {
            if (gameMachine.getName().contains(machineName)) {
                gameMachine.addGame(newGame);
                return true;
            }
        }
        return false;
    }

    public boolean deleteGame(String machineName, int indexOfGameToDelete) {
        for (GameMachine gameMachine : gameMachines) {
            if (gameMachine.getName().contains(machineName)) {
                gameMachine.removeGame(indexOfGameToDelete);
                return true;
            }
        }
        return false;
    }

    public boolean updateGame(OriginalGame updatedGameObj, String machineName, int indexOfGameToUpdate) {
        for (GameMachine gameMachine : gameMachines) {
            if (gameMachine.getName().contains(machineName)) {
                boolean isUpdated = gameMachine.updateGame(updatedGameObj, indexOfGameToUpdate);
                if (isUpdated) return true;
                return false;
            }
        }
        return false;
    }

    /* GAME PORT CRUD */
    public boolean addGamePort(String portedToMachineName, String gameTitle, GamePort newGamePort){
        for(GameMachine gameMachine : gameMachines){
            if (gameMachine.getName().contains(portedToMachineName)){
                return gameMachine.addGamePort(gameTitle,newGamePort);
            }
        }
        return false;
    }

    public boolean deleteGamePort(String machineName, int indexOfGamePort) {
        for(GameMachine gameMachine : gameMachines){
            if(gameMachine.getName().contains(machineName)){
             return gameMachine.removeGamePort(indexOfGamePort);
            }
        }
        return false;
    }

    public boolean updateGamePort(GamePort updatedGamePort, String machineName, int indexOfPortedGame) {
        for (GameMachine gameMachine : gameMachines) {
            if (gameMachine.getName().contains(machineName)) {
                boolean isUpdated = gameMachine.updatePortedGame(updatedGamePort, indexOfPortedGame);
                if (isUpdated) return true;
                return false;
            }
        }
        return false;
    }

    public void addMachine(GameMachine newGameMachine) {
        gameMachines.add(newGameMachine);
    }

    public boolean updateMachine(GameMachine updatedDetails, int machineName) {
        GameMachine machineToUpdate = gameMachines.get(machineName);

        if (machineToUpdate != null) {
            machineToUpdate.setPrice(updatedDetails.getPrice());
            machineToUpdate.setName(updatedDetails.getName());
            machineToUpdate.setMedia(updatedDetails.getMedia());
            machineToUpdate.setType(updatedDetails.getType());
            machineToUpdate.setManufacturer(updatedDetails.getManufacturer());
            machineToUpdate.setDescription(updatedDetails.getDescription());
            machineToUpdate.setURL(updatedDetails.getURL());
            machineToUpdate.setInitialLaunchYear(updatedDetails.getInitialLaunchYear());
            return true;
        }
        return false;
    }

    public boolean deleteGameMachine(int indexOfMachine) {
        if (Utilities.isValidIndex(gameMachines, indexOfMachine)) {
            gameMachines.remove(indexOfMachine);
            return true;
        }
        return false;
    }


    //-----------------\\
    // Listing/Searching \\
    //-----------------\\

    public String searchForGameTitle(String searchGameTitle){
        String listOfSearchResults = "";
        for(GameMachine gameMachine : gameMachines){
            if(gameMachine.getGames().getValuePair(searchGameTitle)!=null){
                listOfSearchResults += gameMachine.getGames().getValuePair(searchGameTitle).toString() + "\n";
            }
            if(gameMachine.getPortedGames().getValuePair(searchGameTitle)!=null){
                listOfSearchResults += gameMachine.getPortedGames().getValuePair(searchGameTitle).toString() + "\n";
            }
        }
        if(listOfSearchResults.isEmpty()) return "Couldn't find game by that title. Please try again.";
        return listOfSearchResults;
    }

    public OriginalGame searchForOriginalGame(String searchGameTitle) {
        for (GameMachine gameMachine : gameMachines) {
            OriginalGame originalGame = gameMachine.getGames().getValuePair(searchGameTitle);
            if (originalGame != null) {
                return originalGame;
            }

            GamePort portedGame = gameMachine.getPortedGames().getValuePair(searchGameTitle);
            if (portedGame != null) {
                return portedGame.getOriginalGame();
            }
        }

        return null;
    }


    public String listAllMachines(){
        // sort Machines
        String listOfMachines = gameMachines.listElements();
        if (listOfMachines.isEmpty()) return "No machines added";
        return listOfMachines;
    }

    public String listAllGames() {
        // sort games
        String list = "";
        for (GameMachine gameMachine : gameMachines) {
            list += gameMachine.listGamesInGameMachine() + "\n";
        }
        if (list.isEmpty()) return "No games added";
        return list;
    }

    public String listGamesAndPortedGames(){
        // sort Games and Ported Games
        String listOfGamesWithPortedGameVersions = "";

        for(GameMachine gameMachine : gameMachines){
            listOfGamesWithPortedGameVersions += "(Machine: " + gameMachine.getName() + ")\n" + gameMachine.listGamesInGameMachine() + "\n"
                    + "(Ported Games)\n" + gameMachine.listPortedGamesForMachine() + "\n";
        }

        if(listOfGamesWithPortedGameVersions.isEmpty()){
            return "No games/ports. Please add some";
        }
        return listOfGamesWithPortedGameVersions;
    }

    /*

                                        Come back to this at later stage

    public String listOfGamesWithGamePorts() {
        String listOfGamesWithPortedGameVersions = "";

        for (GameMachine gameMachine : gameMachines)
        {
            if (gameMachine.getGames().size() > 0)
            {
                listOfGamesWithPortedGameVersions += "(Machine: " + gameMachine.getName() + " )\n";
                for (int i = 0; i < gameMachine.getGames().size(); i++)
                {
                    if (gameMachine.getGames().getByIndex(i) != null)
                    {
                        OriginalGame game = gameMachine.getGames().getByIndex(i);
                        listOfGamesWithPortedGameVersions += "*** (Original Game) ==> " + game + "\n";

                        // ---------------------------------------- \\
                        for (GameMachine gameMachine1 : gameMachines)
                        {
                            if (gameMachine1.getPortedGames().listTableElements().contains(game.toString()))
                            {
                                listOfGamesWithPortedGameVersions += "(Ported Game): " + gameMachine1.getPortedGames().getValuePair(game.getTitle()) + "\n";
                            }
                        }
                        // ---------------------------------------- \\

                    }
                }
                listOfGamesWithPortedGameVersions += "(Machine: " + gameMachine.getName() + " )\n" + "No Games/Ports for this machine" + "\n\n";
            }

        }
        return listOfGamesWithPortedGameVersions;
    }
    */

    //-----------------\\
    //    Sorting      \\
    //-----------------\\

    public void sortGamesByYearReleasedAscending(){
        for(GameMachine gameMachine : gameMachines){
            gameMachine.sortGamesByYearReleasedAscending();
        }
    }
    public void sortGamesByTitleAscending(){
        for(GameMachine gameMachine : gameMachines){
            gameMachine.sortGamesByTitleAscending();
        }
    }
    public void sortPortedGamesByYearReleasedAscending(){
        for(GameMachine gameMachine : gameMachines){
            gameMachine.sortPortedGamesByYearReleasedAscending();
        }
    }
    public void sortPortedGamesByGameTitleAscending(){
        for(GameMachine gameMachine : gameMachines){
            gameMachine.sortPortedGamesByGameTitleAscending();
        }
    }

    //----------------------//
    //   Persistence/Reset  //
    //---------------------//

    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("retrovideogamesystem.xml"));

        out.writeObject(gameMachines);
        out.close();
    }

    @SuppressWarnings("unchecked")
    public void load() throws Exception {

        Class<?>[] classes = new Class[]{OriginalGame.class, GamePort.class, GameMachine.class};

        //Creating XStream obj w/ classes
        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);

        /* Source: https://x-stream.github.io/security.html#framework
         * Fixing security/permission set bug --> 04/12/2023
         * */
        xstream.addPermission(AnyTypePermission.ANY);

        ObjectInputStream in = xstream.createObjectInputStream(new FileReader("retrovideogamesystem.xml"));
        gameMachines = (CustomLinkedList<GameMachine>) in.readObject();
        in.close();
    }


    public void reset() {
        gameMachines.resetList();
        try {
            save(); // Reset overrides system, resetting XML file also
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}





