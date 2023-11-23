package controller;
import model.Game;
import model.GameMachine;
import dataStructures.CustomLinkedList.*;
import utils.Utilities;

public class SystemAPI {

    private CustomLinkedList<GameMachine> gameMachines = new CustomLinkedList<>();

    public SystemAPI(){
    }


    //-----------------\\
    //     CRUD        \\
    //-----------------\\

    public void addMachine(GameMachine newGameMachine){
        gameMachines.add(newGameMachine);
    }

    public boolean addGameToMachine(String machineName, Game newGame){
        for(GameMachine gameMachine : gameMachines){
            if (gameMachine.getName().contains(machineName)){
                gameMachine.addGame(newGame);
                return true;
            }
        }
        return false;
    }
    public void addGamePort(){}

    public boolean updateMachine(GameMachine updatedDetails, int indexOfMachine){
        GameMachine machineToUpdate = gameMachines.get(indexOfMachine);

        if(machineToUpdate!=null){
            machineToUpdate = updatedDetails;
            return true;
        }
        return false;
    }

    public boolean deleteGameMachine(int indexOfMachine){
        if(Utilities.isValidIndex(gameMachines,indexOfMachine)){
            gameMachines.remove(indexOfMachine);
            return true;
        }
        return false;
    }

    //TODO - CRUD
    /*
    public boolean deleteGame(){}
    public boolean deleteGamePort(){}
    public boolean updateGame(){}
    public boolean updateGamePort(){}
    */


    //-----------------\\
    // Listing/Searching \\
    //-----------------\\

    public String listAllMachines(){
        String listOfMachines = gameMachines.listElements();
        if(listOfMachines.isEmpty()) return "No machines added";
        return listOfMachines;
    }

    public String listAllGames(){
        String list = "";
        for(GameMachine gameMachine : gameMachines){
            list += gameMachine.listGamesInGameMachine() + "\n";
        }
        if(list.isEmpty()) return "No games added";
        return list;
    }


}