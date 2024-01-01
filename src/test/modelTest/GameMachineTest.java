package modelTest;

import model.GameMachine;
import model.GamePort;
import model.OriginalGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameMachineTest {

    private GameMachine gameMachine;

    @BeforeEach
    void setUp() {
        // Create a new GameMachine instance before each test
        gameMachine = new GameMachine("TestMachine", "TestManufacturer", "TestDescription", "TestCategory", "TestMedia", 2022, 99.99, "http://example.com");
    }

    @Test
    void testGettersAndSetters() {
        // Test getters
        assertEquals("TestMachine", gameMachine.getName());
        assertEquals("TestManufacturer", gameMachine.getManufacturer());
        assertEquals("TestDescription", gameMachine.getDescription());
        assertEquals("TestCategory", gameMachine.getType());
        assertEquals("TestMedia", gameMachine.getMedia());
        assertEquals(2022, gameMachine.getInitialLaunchYear());
        assertEquals(99.99, gameMachine.getPrice());
        assertEquals("http://example.com", gameMachine.getURL());

        // Test setters
        gameMachine.setName("UpdatedName");
        gameMachine.setManufacturer("UpdatedManufacturer");
        gameMachine.setDescription("UpdatedDescription");
        gameMachine.setType("UpdatedType");
        gameMachine.setMedia("UpdatedMedia");
        gameMachine.setInitialLaunchYear(2023);
        gameMachine.setPrice(49.99);
        gameMachine.setURL("http://updated-url.com");

        // Verify that the setters worked correctly
        assertEquals("UpdatedName", gameMachine.getName());
        assertEquals("UpdatedManufacturer", gameMachine.getManufacturer());
        assertEquals("UpdatedDescription", gameMachine.getDescription());
        assertEquals("UpdatedType", gameMachine.getType());
        assertEquals("UpdatedMedia", gameMachine.getMedia());
        assertEquals(2023, gameMachine.getInitialLaunchYear());
        assertEquals(49.99, gameMachine.getPrice());
        assertEquals("http://updated-url.com", gameMachine.getURL());
    }

    @Test
    void testAddGame() {
        // Create a new OriginalGame
        OriginalGame originalGame = new OriginalGame("TestOriginalGame", "TestPublisher", "TestDescription", "TestDeveloper", 2022, "http://game-cover-art.com");

        // Add the game to the machine
        gameMachine.addGame(originalGame);

        // Verify that the game is added
        assertEquals(originalGame, gameMachine.getGames().getValuePair("TestOriginalGame"));
    }

    @Test
    void testAddGamePort() {
        // Create a new OriginalGame
        OriginalGame originalGame = new OriginalGame("TestOriginalGame", "TestPublisher", "TestDescription", "TestDeveloper", 2022, "http://game-cover-art.com");

        // Add the game to the machine
        gameMachine.addGame(originalGame);

        // Create a new GamePort
        GamePort gamePort = new GamePort(originalGame, "TestGamePortDeveloper", 2023, "http://cover-art-port.com");

        // Add the ported game to the machine
        assertTrue(gameMachine.addGamePort("TestOriginalGame", gamePort));

        // Verify that the ported game is added
        assertEquals(gamePort, gameMachine.getPortedGames().getValuePair("TestOriginalGame"));
    }
}
