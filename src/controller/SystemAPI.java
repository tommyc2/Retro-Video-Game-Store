package controller;
import model.Game;
import model.GameMachine;
import java.util.LinkedList;

public class SystemAPI {

    private LinkedList<GameMachine> gameMachines = new LinkedList<>();

    public SystemAPI(){
    }

    //TODO
    public void addGameMachine(GameMachine newGameMachine){
        gameMachines.add(newGameMachine);
    }

    //TODO
    public String listMachines(){
      //  return gameMachines.listElements();
        return "";
    }

    //TODO
    public void addGameToMachine(String machineName, Game newGame){
        for(GameMachine gameMachine : gameMachines){
            if (gameMachine.getName().contains(machineName)){
                gameMachine.addGame(newGame);
            }
        }
    }



}