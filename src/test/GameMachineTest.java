import model.Game;
import model.GameMachine;
import model.GamePort;
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
    void testConstructor() {
        // Create a new GameMachine instance using the constructor
        GameMachine gameMachine = new GameMachine("TestMachine", "TestManufacturer", "TestDescription", "TestCategory", "TestMedia", 2022, 99.99, "http://example.com");

        // Verify that the attributes are set correctly
        assertEquals("TestMachine", gameMachine.getName());
        assertEquals("TestManufacturer", gameMachine.getManufacturer());
        assertEquals("TestDescription", gameMachine.getDescription());
        assertEquals("TestCategory", gameMachine.getType());
        assertEquals("TestMedia", gameMachine.getMedia());
        assertEquals(2022, gameMachine.getInitialLaunchYear());
        assertEquals(99.99, gameMachine.getPrice(), 0.01);
        assertEquals("http://example.com", gameMachine.getURL());
    }



    @Test
    void testGetName() {
        assertEquals("TestMachine", gameMachine.getName());
    }

    @Test
    void testSetName() {
        gameMachine.setName("UpdatedMachine");
        assertEquals("UpdatedMachine", gameMachine.getName());
    }

    @Test
    void testGetManufacturer() {
        assertEquals("TestManufacturer", gameMachine.getManufacturer());
    }

    @Test
    void testSetManufacturer() {
        gameMachine.setManufacturer("UpdatedManufacturer");
        assertEquals("UpdatedManufacturer", gameMachine.getManufacturer());
    }

    @Test
    void testGetDescription() {
        assertEquals("TestDescription", gameMachine.getDescription());
    }

    @Test
    void testSetDescription() {
        gameMachine.setDescription("UpdatedDescription");
        assertEquals("UpdatedDescription", gameMachine.getDescription());
    }

    @Test
    void testGetType() {
        assertEquals("TestCategory", gameMachine.getType());
    }

    @Test
    void testSetType() {
        gameMachine.setType("UpdatedCategory");
        assertEquals("UpdatedCategory", gameMachine.getType());
    }

    @Test
    void testGetMedia() {
        assertEquals("TestMedia", gameMachine.getMedia());
    }

    @Test
    void testSetMedia() {
        gameMachine.setMedia("UpdatedMedia");
        assertEquals("UpdatedMedia", gameMachine.getMedia());
    }

    @Test
    void testGetInitialLaunchYear() {
        assertEquals(2022, gameMachine.getInitialLaunchYear());
    }

    @Test
    void testSetInitialLaunchYear() {
        gameMachine.setInitialLaunchYear(2023);
        assertEquals(2023, gameMachine.getInitialLaunchYear());
    }

    @Test
    void testGetPrice() {
        assertEquals(99.99, gameMachine.getPrice(), 0.01);
    }

    @Test
    void testSetPrice() {
        gameMachine.setPrice(129.99);
        assertEquals(129.99, gameMachine.getPrice(), 0.01);
    }

    @Test
    void testGetURL() {
        assertEquals("http://example.com", gameMachine.getURL());
    }

    @Test
    void testSetURL() {
        gameMachine.setURL("http://updated-url.com");
        assertEquals("http://updated-url.com", gameMachine.getURL());
    }

    @Test
    void testListGamesInGameMachine() {
        // Initially, there should be no games in the machine
        assertEquals("No games in machine", gameMachine.listGamesInGameMachine());

        // Add a game to the machine
        Game game = new Game("TestGame", "TestDeveloper", "TestGenre", "TestPlayer", 2022, "http://game-url.com");
        gameMachine.addGame(game);

        // Check if the game is listed
        assertTrue(gameMachine.listGamesInGameMachine().contains("TestGame"));
    }

    @Test
    void testAddGame() {
        // Initially, there should be no games in the machine
        assertEquals("No games in machine", gameMachine.listGamesInGameMachine());

        // Add a game to the machine
        Game game = new Game("TestGame", "TestDeveloper", "TestGenre", "TestPlayer", 2022, "http://game-url.com");
        gameMachine.addGame(game);

        // Check if the game is added successfully
        assertTrue(gameMachine.listGamesInGameMachine().contains("TestGame"));
    }

    @Test
    void testListGamePortsForMachine() {
        // Initially, there should be no game ports in the machine
        assertEquals("", gameMachine.listGamePortsForMachine());

        // Add a game port to the machine
        GamePort gamePort = new GamePort("USB", 2002,"URL");
        gameMachine.addGamePort(gamePort);

        // Check if the game port is listed
        assertTrue(gameMachine.listGamePortsForMachine().contains("USB"));
    }



    @Test
    void testToString() {
        // Check if the toString method produces the expected output
        String expectedToString = "GameMachine { name='TestMachine', manufacturer='TestManufacturer', description='TestDescription', type='TestCategory', media='TestMedia', initialLaunchYear=2022, price=99.99, URL='http://example.com' }";
        assertEquals(expectedToString, gameMachine.toString());
    }
}
