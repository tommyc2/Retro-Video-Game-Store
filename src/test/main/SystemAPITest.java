package main ;

import controller.SystemAPI;
import model.GameMachine;
import model.GamePort;
import model.OriginalGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SystemAPITest {

    private SystemAPI systemAPI;

    @BeforeEach
    void setUp() {
        // Create a new SystemAPI instance before each test
        systemAPI = new SystemAPI();
    }

    @Test
    void testAddMachine() {
        GameMachine newGameMachine = new GameMachine("TestMachine", "TestManufacturer", "TestDescription", "TestCategory", "TestMedia", 2022, 99.99, "http://example.com");

        // Add a new machine
        systemAPI.addMachine(newGameMachine);

        // Verify that the machine is added
        assertEquals("TestMachine", systemAPI.getGameMachines().get(0).getName());
    }

    @Test
    void testUpdateMachine() {
        // Create a new machine
        GameMachine newGameMachine = new GameMachine("TestMachine", "TestManufacturer", "TestDescription", "TestCategory", "TestMedia", 2022, 99.99, "http://example.com");
        systemAPI.addMachine(newGameMachine);

        // Create updated details for the machine
        GameMachine updatedDetails = new GameMachine("UpdatedMachine", "UpdatedManufacturer", "UpdatedDescription", "UpdatedCategory", "UpdatedMedia", 2023, 129.99, "http://updated-url.com");

        // Update the machine
        assertTrue(systemAPI.updateMachine(updatedDetails, 0));

        // Verify that the machine is updated
        assertEquals("UpdatedMachine", systemAPI.getGameMachines().get(0).getName());
    }

    @Test
    void testDeleteGameMachine() {
        // Create a new machine
        GameMachine newGameMachine = new GameMachine("TestMachine", "TestManufacturer", "TestDescription", "TestCategory", "TestMedia", 2022, 99.99, "http://example.com");
        systemAPI.addMachine(newGameMachine);

        // Delete the machine
        assertTrue(systemAPI.deleteGameMachine(0));

        // Verify that the machine is deleted
        assertEquals(0, systemAPI.getGameMachines().size());
    }

    @Test
    void testAddGameToMachine() {
        // Create a new machine
        GameMachine newGameMachine = new GameMachine("TestMachine", "TestManufacturer", "TestDescription", "TestCategory", "TestMedia", 2022, 99.99, "http://example.com");
        systemAPI.addMachine(newGameMachine);

        OriginalGame newGame = new OriginalGame("TestGame", "TestPublisher", "TestDescription", "TestDeveloper", 2022, "http://game-cover-art.com");

        // Add a new game to the machine
        assertTrue(systemAPI.addGameToMachine("TestMachine", newGame));

        // Verify that the game is added to the machine
        assertTrue(systemAPI.getGameMachines().get(0).getGames().listTableElements().contains("TestGame"));
    }

    @Test
    void testListAllGames() {
        // Create a new machine
        GameMachine newGameMachine = new GameMachine("TestMachine", "TestManufacturer", "TestDescription", "TestCategory", "TestMedia", 2022, 99.99, "http://example.com");
        systemAPI.addMachine(newGameMachine);

        // Add a new game to the machine
        OriginalGame newGame = new OriginalGame("TestGame", "TestPublisher", "TestDescription", "TestDeveloper", 2022, "http://game-cover-art.com");
        systemAPI.addGameToMachine("TestMachine", newGame);

        // List all games
        String gamesList = systemAPI.listAllGames();

        // Verify that the games are listed
        assertTrue(gamesList.contains("TestGame"));
    }

    @Test
    void testSearchForGameTitle() {
        // Create a new machine
        GameMachine newGameMachine = new GameMachine("TestMachine", "TestManufacturer", "TestDescription", "TestCategory", "TestMedia", 2022, 99.99, "http://example.com");
        systemAPI.addMachine(newGameMachine);

        // Add a new game to the machine
        OriginalGame newGame = new OriginalGame("TestGame", "TestPublisher", "TestDescription", "TestDeveloper", 2022, "http://game-cover-art.com");
        systemAPI.addGameToMachine("TestMachine", newGame);

        // Search for the game by title
        String searchResults = systemAPI.searchForGameTitle("TestGame");

        // Verify that the game is found
        assertTrue(searchResults.contains("TestGame"));
    }



}

