package com.example.dsalgoca;


import controller.SystemAPI;
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
        //launch();
        GameMachine xbox = new GameMachine("Xbox","Sony","Console", "Playstation","media",2001,400,"www.sony.com");
        GameMachine playstation2 = new GameMachine("Playstation2","Sony","Console", "Playstation","media",2001,400,"www.sony.com");

        systemAPI.addMachine(xbox);
        systemAPI.addMachine(playstation2);

        OriginalGame zeldaGame = new OriginalGame("Zelda", "publisher", "desc", "origDev", 2019,"www");
        OriginalGame gtaGame = new OriginalGame("GTA 5", "publisher", "desc", "origDev", 2021,"www");
        OriginalGame minecraft = new OriginalGame("Minecraft", "publisher", "desc", "origDev", 2008,"www");
        OriginalGame pokemon = new OriginalGame("Pokemon", "publisher", "desc", "origDev", 2023,"www");
        OriginalGame ufc = new OriginalGame("UFC", "publisher", "desc", "origDev", 2003,"www");
        OriginalGame fifa = new OriginalGame("Fifa", "publisher", "desc", "origDev", 2007,"www");
        OriginalGame diablo = new OriginalGame("Diablo", "publisher", "desc", "origDev", 2020,"www");

        GamePort gamePortZelda = new GamePort(zeldaGame, "zeldamakers",2019,"urlexample");
        GamePort gamePortGTA = new GamePort(gtaGame, "gtadevs",2021,"urlexample");
        GamePort gamePortMinecraft = new GamePort(minecraft, "zeldamakers",2008,"urlexample");
        GamePort gamePortPokemon = new GamePort(pokemon, "gtadevs",2023,"urlexample");

        xbox.addGame(zeldaGame);
        xbox.addGame(gtaGame);
        xbox.addGame(minecraft);
        xbox.addGame(pokemon);
        xbox.addGame(ufc);
        xbox.addGame(diablo);
        xbox.addGame(fifa);

        playstation2.addGamePort("Zelda", gamePortZelda);
        playstation2.addGamePort("GTA 5", gamePortGTA);
        playstation2.addGamePort("Minecraft", gamePortMinecraft);
        playstation2.addGamePort("Pokemon", gamePortPokemon);

        reset();
        save();
        System.out.println(systemAPI.getGameMachines().listElements());

        //String foundGameTitle = systemAPI.searchForGameTitle("UFC");
        //System.out.println(foundGameTitle);

        //playstation2.addGame(gtaGame);
        //playstation2.addGamePort("Zelda",gamePort1);

        //System.out.println(systemAPI.listGamesAndPortedGames());

    }

    // Persistence //

    private void save(){

        try
        {
            System.out.println("Saving...");
            systemAPI.save();
        }
        catch (Exception e)
        {
            System.err.println("Error writing to this file --> " + e);
        }

    }

    private void load(){

        try
        {
            System.out.println("Loading system....");
            systemAPI.load();
        }

        catch (Exception e)
        {
            System.err.println("Error while loading --> " + e.toString());
        }

    }

    private void reset(){
        try{
            System.out.println("Resetting current system....");
            systemAPI.reset();
        }
        catch (Exception error){
            System.err.println("Error while resetting --> " + error);
        }
    }


}