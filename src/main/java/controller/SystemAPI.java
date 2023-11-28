package controller;
import model.OriginalGame;
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


    public boolean addGameToMachine(String machineName, OriginalGame newGame){
        for(GameMachine gameMachine : gameMachines){
            if (gameMachine.getName().contains(machineName)){
                gameMachine.addGame(newGame);
                return true;
            }
        }
        return false;
    }


    //TODO - CRUD

    public boolean deleteGame(String machineName, int indexOfGameToDelete){
        for(GameMachine gameMachine : gameMachines){
            if(gameMachine.getName().contains(machineName)){
                gameMachine.removeGame(indexOfGameToDelete);
                return true;
            }
        }
        return false;
    }

    public boolean updateGame(OriginalGame updatedGameObj, String machineName, int indexOfGameToUpdate){
        for(GameMachine gameMachine : gameMachines) {
            if(gameMachine.getName().contains(machineName)){
               boolean isDeleted = gameMachine.updateGame(updatedGameObj,indexOfGameToUpdate);
               if(isDeleted) return true;
               return false;
            }
        }
        return false;
    }

    /* GAME PORT CRUD */
    public void addGamePort(){}
    public boolean deleteGamePort(){
        return false;
    }
    public boolean updateGamePort(){
        return false;
    }
    /*******************\


    public void addMachine(GameMachine newGameMachine){
        gameMachines.add(newGameMachine);
    }

    public boolean updateMachine(GameMachine updatedDetails, int indexOfMachine){
        GameMachine machineToUpdate = gameMachines.get(indexOfMachine);

        if(machineToUpdate!=null){
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

    public boolean deleteGameMachine(int indexOfMachine){
        if(Utilities.isValidIndex(gameMachines,indexOfMachine)){
            gameMachines.remove(indexOfMachine);
            return true;
        }
        return false;
    }





    //-----------------\\
    // Listing/Searching \\
    //-----------------\\

    public String listAllMachines(){
        String listOfMachines = gameMachines.listElements();
        if(listOfMachines.isEmpty()) return "No machines added";
        return listOfMachines;
    }

    public String listAllGames(){
        // sort games
        String list = "";
        for(GameMachine gameMachine : gameMachines){
            list += gameMachine.listGamesInGameMachine() + "\n";
        }
        if(list.isEmpty()) return "No games added";
        return list;
    }

    /*public String listAllGamesWithGamePorts(){

    }
    */



}