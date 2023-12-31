package com.example.dsalgoca;


import controller.SystemAPI;
import model.GameMachine;
import model.GamePort;
import model.OriginalGame;
import utils.ScannerInput;




public class Driver /* extends Application */ {

    private SystemAPI systemAPI = new SystemAPI();



    public static void main(String[] args) {
        new Driver();
    }



    public Driver(){
        runMenu();


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

        System.out.println(systemAPI.listGamesAndPortedGames());


    }
    private void runMenu(){
        int option=mainMenu();
        while (option!=0){
            switch (option){
                case 1->addGameMachine(systemAPI);
                case 2->addGame(systemAPI);
                case 3->addGamePort(systemAPI);
                case 4->updateGameMachine(systemAPI);
                case 5->updateGame(systemAPI);
                case 6->updateGamePort(systemAPI);
                case 7->deleteGameMachine(systemAPI);
                case 8->deleteGame(systemAPI);
                case 9->deleteGamePort(systemAPI);
                case 10->listAllMachines(systemAPI);
                case 11->listAllGames(systemAPI);
                case 12->listGamesAndPortedGames(systemAPI);
                case 13->sortGameByYearReleasedAscending(systemAPI);
                case 14->sortGamesByTitleAscending(systemAPI);
                case 15->sortPortedGamesByYearReleasedAscending(systemAPI);
                case 16->sortPortedGamesByGameTitleAscending(systemAPI);
                case 17->searchForGameTitle(systemAPI);
                case 18->save();
                case 19->load();
                case 20->reset();
                default -> System.out.println("Invalid option entered: " + option);
            }
            ScannerInput.readNextLine("\n Press enter key to continue... ");
            option=mainMenu();
        }
        System.out.println("Exiting...bye");
        System.exit(0);
    }

    private int mainMenu(){
        return ScannerInput.readNextInt("""
                |----------------------------------------|
                |  Retro Video Games Information System  |
                |----------------------------------------|
                |---------------Add Options--------------|
                |----------------------------------------|
                |           1) add game machine          |
                |              2) add game               |
                |              3) port game              |
                |----------------------------------------|
                |--------------Update Options------------|
                |----------------------------------------|
                |           4) update game machine       |
                |              5) update game            |
                |           6) update ported game        |
                |----------------------------------------|
                |--------------Delete Options------------|
                |----------------------------------------|
                |           7) delete game machine       |
                |              8) delete game            |
                |           9) delete ported game        |
                |----------------------------------------|
                |---------------List Options-------------|
                |----------------------------------------|
                |           10) List all machines        |
                |            11) List all Games          |
                |      12) list games and ported games   |
                |----------------------------------------|
                |-------------Sorting Options------------|
                |----------------------------------------|
                |     13) Sort Games By Year Ascending   |
                |     14) Sort Games by title Ascending  |
                | 15) Sort Ported Games by Year Ascending|
                |16) Sort Ported Games by title Ascending|
                |----------------------------------------|
                |------------Searching Options-----------|
                |----------------------------------------|
                |        17) Search for Game Title       |
                |----------------------------------------|
                |------------Persistence/Reset-----------|
                |----------------------------------------|
                |               18) Save                 |
                |               19) Load                 |
                |               20) Reset                |
                |                0) Exit                 |
                |----------------------------------------|
               ==>
                """);
    }

    private void addGameMachine(SystemAPI systemAPI){
        System.out.println("Enter the Game Machine Details: ");

        String GmName = ScannerInput.readNextLine("Enter the Game Machine Name: ");
        String manufacturer = ScannerInput.readNextLine("Enter the Game Machine Manufacturer: ");
        String description = ScannerInput.readNextLine("Write a small description for the game machine: ");
        String type = ScannerInput.readNextLine("What type of game Machine: ");
        String media = ScannerInput.readNextLine("What media does it use: ");
        int launchYear = ScannerInput.readNextInt("What year did it launch: ");
        double price = ScannerInput.readNextDouble("How much does it cost: ");
        String URL = ScannerInput.readNextLine("Insert a URL: ");

        GameMachine newGameMachine = new GameMachine(GmName,manufacturer,description,type,media,launchYear,price,URL);
       systemAPI.addMachine(newGameMachine);

        System.out.println("Game machine added successfully");

    }

    private void updateGameMachine(SystemAPI systemAPI){

        String listOfMachines = systemAPI.listAllMachines();
        System.out.println(listOfMachines);
        int machineIndex = ScannerInput.readNextInt("Enter the index of the Game Machine to update: ");

        String updatedName = ScannerInput.readNextLine("Enter the updated name: ");
        String manufacturer = ScannerInput.readNextLine("Enter the updated manufacturer: ");
        String description = ScannerInput.readNextLine("Enter the updated description: ");
        String type = ScannerInput.readNextLine("Enter the updated type: ");
        String media = ScannerInput.readNextLine("Enter the updated media: ");
        int launchYear = ScannerInput.readNextInt("Enter the updated launch Year: ");
        double price = ScannerInput.readNextDouble("Enter the updated price: ");
        String URL = ScannerInput.readNextLine("Enter the updated URL: ");

        GameMachine updatedDetails = new GameMachine(updatedName,manufacturer,description,type,media,launchYear,price,URL);

        boolean updated = systemAPI.updateMachine(updatedDetails,machineIndex);

        if (updated){
            System.out.println("Game Machine updated Successfully");
        }else {
            System.out.println("Failed to update the game machine.Machine not found.");
        }
    }

    private void deleteGameMachine(SystemAPI systemAPI){

        String listOfMachines = systemAPI.listAllMachines();
        System.out.println(listOfMachines);
        int indexOfMachine = ScannerInput.readNextInt("Enter the Game Machine index to delete: ");

        boolean deleted = systemAPI.deleteGameMachine(indexOfMachine);

        if (deleted){
            System.out.println("Game Machine Deleted successfully");
        }else {
            System.out.println("Failed to delete the game machine.Machine not found");
        }
    }

    private void addGame(SystemAPI systemAPI){
        System.out.println("Enter the Game details");

        String listOfMachines = systemAPI.listAllMachines();
        System.out.println(listOfMachines);

        String machineName = ScannerInput.readNextLine("Enter the Game Machine Name: ");
        String title = ScannerInput.readNextLine("Game Title: ");
        String publisher = ScannerInput.readNextLine("Game Publisher: ");
        String description = ScannerInput.readNextLine("Game description: ");
        String originalDev = ScannerInput.readNextLine("Games original Developer: ");
        int launchYear = ScannerInput.readNextInt("Game Launch Year: ");
        String URL = ScannerInput.readNextLine("Insert a URL: ");

        OriginalGame newGame = new OriginalGame(title,publisher,description,originalDev,launchYear,URL);
        systemAPI.addGameToMachine(machineName,newGame);

        boolean added = systemAPI.addGameToMachine(machineName,newGame);

        if (added){
            System.out.println("Game Added successfully to the machine.");
        }else {
            System.out.println("Failed to add the game.Machine not Found");
        }
    }

    private void updateGame(SystemAPI systemAPI){
        String listOfMachines = systemAPI.listAllMachines();
        System.out.println(listOfMachines);

        int indexOfMachine = ScannerInput.readNextInt("Enter the index of the machine: ");
        String machineName = ScannerInput.readNextLine("Enter the Game machine name:" );
        String gameTitle = ScannerInput.readNextLine("Enter the Game Title to update: ");
        String publisher = ScannerInput.readNextLine("Enter the updated publisher: ");
        String description = ScannerInput.readNextLine("Enter the updated description: ");
        String originalDev = ScannerInput.readNextLine("Enter the updated Original developer: ");
        int yearReleased=ScannerInput.readNextInt("Enter the updated Release date: ");
        String URL = ScannerInput.readNextLine("Enter the updated URL: ");

        OriginalGame updatedGame = new OriginalGame(gameTitle,publisher,description,originalDev,yearReleased,URL);

        boolean updated = systemAPI.updateGame(updatedGame,machineName,indexOfMachine);

        if (updated){
            System.out.println("Game updated successfully");
        }else {
            System.out.println("Failed to update the game. Machine or game not found");
        }
    }

    private void deleteGame(SystemAPI systemAPI){
        String listOfMachines = systemAPI.listAllMachines();
        System.out.println(listOfMachines);
        String machineName = ScannerInput.readNextLine("Enter the Game machine name:" );

        String listOfGames = systemAPI.listAllGames();
        System.out.println(listOfGames);
        int indexOfGame = ScannerInput.readNextInt("Enter the game index that u wish to delete: ");

        boolean deleted = systemAPI.deleteGame(machineName,indexOfGame);
        if (deleted){
            System.out.println("Game deleted successfully");
        }else {
            System.out.println("Failed to delete the game. Machine or game not found");
        }

    }

    private void addGamePort(SystemAPI systemAPI){
        System.out.println("Enter the Game Port Details: ");

        String listOfMachines = systemAPI.listAllMachines();
        System.out.println(listOfMachines);
        String machineName = ScannerInput.readNextLine("Enter original machine name: ");


        String listOfGames = systemAPI.listAllGames();
        System.out.println(listOfGames);
        String gameTitle = ScannerInput.readNextLine("Enter the Original game title: ");


        String portDev = ScannerInput.readNextLine("Enter the Port Developer: ");
        int launchYear = ScannerInput.readNextInt("Enter the launch Year: ");
        String CoverArtUrl = ScannerInput.readNextLine("Enter the URL for the cover: ");

        OriginalGame originalGame = systemAPI.searchForOriginalGame(gameTitle);
        GamePort newGamePort = new GamePort(originalGame,portDev,launchYear,CoverArtUrl);
        systemAPI.addGamePort(machineName,gameTitle,newGamePort);

    }

    private void updateGamePort(SystemAPI systemAPI){
        int indexOfMachine = ScannerInput.readNextInt("Enter the Index of the machine: ");
        String machineName = ScannerInput.readNextLine("Enter the Machine Name: ");
        String gameTitle = ScannerInput.readNextLine("Enter the game title: ");
        String gamePortDev = ScannerInput.readNextLine("Enter the Game Developer");
        int releaseYear = ScannerInput.readNextInt("Enter the updated release date");
        String CoverArtURL =ScannerInput.readNextLine("Enter the updated URL: ");

        OriginalGame originalGame = systemAPI.searchForOriginalGame(gameTitle);
        GamePort newPort = new GamePort(originalGame,gamePortDev,releaseYear,CoverArtURL);

        boolean updated = systemAPI.updateGamePort(newPort,machineName,indexOfMachine);

        if (updated){
            System.out.println("Ported Game updated successfully");
        }else {
            System.out.println("Failed to update the ported game.Machine or game not found");
        }
    }

    private  void deleteGamePort(SystemAPI systemAPI){
        String machineName = ScannerInput.readNextLine("Enter the name of the machine: ");
        int indexOfGamePort = ScannerInput.readNextInt("Enter the index of the game port you wish to delete: ");

        boolean deleted = systemAPI.deleteGamePort(machineName,indexOfGamePort);

        if (deleted){
            System.out.println("Game port deleted successfully");
        }else {
            System.out.println("Failed to delete the game port. Machine or game port not found");
        }
    }



    private void listAllMachines(SystemAPI systemAPI){
        System.out.println(systemAPI.listAllMachines());
    }

    private void listAllGames(SystemAPI systemAPI){
        System.out.println(systemAPI.listAllGames());
    }

    private void listGamesAndPortedGames(SystemAPI systemAPI){
        System.out.println(systemAPI.listGamesAndPortedGames());
    }



    private void sortGameByYearReleasedAscending(SystemAPI systemAPI){
        systemAPI.sortGamesByYearReleasedAscending();
    }

    private void sortGamesByTitleAscending(SystemAPI systemAPI){
        systemAPI.sortGamesByTitleAscending();
    }

    private void sortPortedGamesByYearReleasedAscending(SystemAPI systemAPI){
        systemAPI.sortPortedGamesByYearReleasedAscending();
    }

    private void sortPortedGamesByGameTitleAscending(SystemAPI systemAPI){
        systemAPI.sortPortedGamesByGameTitleAscending();
    }

    private void searchForGameTitle(SystemAPI systemAPI){
        String searchGameTitle = ScannerInput.readNextLine("Enter the game title to search: ");
        String searchResult = systemAPI.searchForGameTitle(searchGameTitle);
        System.out.println(searchResult);
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