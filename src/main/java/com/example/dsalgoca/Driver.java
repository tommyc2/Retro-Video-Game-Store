package com.example.dsalgoca;


import controller.SystemAPI;
import model.GameMachine;
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
        GameMachine gameMachine = new GameMachine("Xbox","Sony","Console", "Playstation","media",2001,400,"www.sony.com");
        GameMachine gameMachine1 = new GameMachine("Playstation12","Sony","Console", "Playstation","media",2001,400,"www.sony.com");
        GameMachine gameMachine2 = new GameMachine("Playstation12312","Sony","Console", "Playstation","media",2001,400,"www.sony.com");
        GameMachine gameMachine3 = new GameMachine("Playstation1321312","Sony","Console", "Playstation","media",2001,400,"www.sony.com");

        systemAPI.addMachine(gameMachine);
        systemAPI.addMachine(gameMachine1);
        systemAPI.addMachine(gameMachine2);
        systemAPI.addMachine(gameMachine3);

        System.out.println(systemAPI.sortMachinesByNameAscending());


    }
}