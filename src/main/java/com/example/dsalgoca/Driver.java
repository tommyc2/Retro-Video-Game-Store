package com.example.dsalgoca;


import controller.SystemAPI;
import dataStructures.Hashing.HashTable;
import model.GameMachine;
import model.GamePort;
import model.OriginalGame;
/*
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
*/


public class Driver /* extends Application */ {

    private SystemAPI systemAPI = new SystemAPI();

   /*  @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Driver.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
*/
    public static void main(String[] args) {
        new Driver();
    }

    public Driver(){
        // launch();
        GameMachine xbox = new GameMachine("Xbox","Sony","Console", "Playstation","media",2001,400,"www.sony.com");
        GameMachine playstation2 = new GameMachine("Playstation2","Sony","Console", "Playstation","media",2001,400,"www.sony.com");

        systemAPI.addMachine(xbox);
        systemAPI.addMachine(playstation2);

        OriginalGame zeldaGame = new OriginalGame("Zelda", "publisher", "desc", "origDev", 2023,"www");
        OriginalGame gtaGame = new OriginalGame("GTA 5", "publisher", "desc", "origDev", 2023,"www");

        GamePort gamePort1 = new GamePort(zeldaGame, "zeldamakers",2023,"urlexample");
        GamePort gamePort2 = new GamePort(gtaGame, "gtadevs",2023,"urlexample");

        xbox.addGame(zeldaGame);

        playstation2.addGame(gtaGame);
        playstation2.addGamePort("Zelda",gamePort1);

        System.out.println(systemAPI.listGamesAndPortedGames());

        //systemAPI.addMachine(gameMachine2);
       // systemAPI.addMachine(gameMachine3);
/*
        System.out.println(systemAPI.sortMachinesByNameAscending());

         */

    }
}