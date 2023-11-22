package controller;
import model.Game;
import model.GameMachine;
import dataStructures.CustomLinkedList.*;

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