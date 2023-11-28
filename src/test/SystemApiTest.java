
import controller.SystemAPI;
import model.Game;
import model.GameMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    public class SystemApiTest {

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
            assertTrue(systemAPI.listAllMachines().contains("TestMachine"));
        }

        @Test
        void testAddGameToMachine() {
            // Create a new machine
            GameMachine newGameMachine = new GameMachine("TestMachine", "TestManufacturer", "TestDescription", "TestCategory", "TestMedia", 2022, 99.99, "http://example.com");
            systemAPI.addMachine(newGameMachine);

            // Add a new game to the machine
            Game newGame = new Game("TestGame", "TestPublisher", "TestDescription", "TestDeveloper", 2022, "http://game-cover-art.com");
            assertTrue(systemAPI.addGameToMachine("TestMachine", newGame));

            // Verify that the game is added to the machine
            assertTrue(systemAPI.listAllGames().contains("TestGame"));
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
            assertTrue(systemAPI.listAllMachines().contains("UpdatedMachine"));
        }

        @Test
        void testDeleteGameMachine() {
            // Create a new machine
            GameMachine newGameMachine = new GameMachine("TestMachine", "TestManufacturer", "TestDescription", "TestCategory", "TestMedia", 2022, 99.99, "http://example.com");
            systemAPI.addMachine(newGameMachine);

            // Delete the machine
            assertTrue(systemAPI.deleteGameMachine(0));

            // Verify that the machine is deleted
            assertEquals("No machines added", systemAPI.listAllMachines());
        }
        }
