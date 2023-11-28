import model.Game;
import model.GameMachine;
import model.GamePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {


    @Test
    void testConstructor() {
        // Create a new Game instance using the constructor
        Game game = new Game("TestTitle", "TestPublisher", "TestDescription", "TestDeveloper", 2022, "http://cover-art-url.com");

        // Verify that the attributes are set correctly
        assertEquals("TestTitle", game.getTitle());
        assertEquals("TestPublisher", game.getPublisher());
        assertEquals("TestDescription", game.getDescription());
        assertEquals("TestDeveloper", game.getOrginalDeveloper());
        assertEquals(2022, game.getYearReleased());
        assertEquals("http://cover-art-url.com", game.getURL());
    }

    @Test
    void testGetTitle() {
        // Create a Game instance
        Game game = new Game("TestTitle", "TestPublisher", "TestDescription", "TestDeveloper", 2022, "http://cover-art-url.com");

        // Verify that the getTitle method returns the correct value
        assertEquals("TestTitle", game.getTitle());
    }

    @Test
    void testSetTitle() {
        // Create a Game instance
        Game game = new Game("TestTitle", "TestPublisher", "TestDescription", "TestDeveloper", 2022, "http://cover-art-url.com");

        // Set a new title using setTitle method
        game.setTitle("UpdatedTitle");

        // Verify that the title is updated correctly
        assertEquals("UpdatedTitle", game.getTitle());
    }



    @Test
    void testGetYearReleased() {
        // Create a Game instance
        Game game = new Game("TestTitle", "TestPublisher", "TestDescription", "TestDeveloper", 2022, "http://cover-art-url.com");

        // Verify that the getYearReleased method returns the correct value
        assertEquals(2022, game.getYearReleased());
    }

    @Test
    void testSetYearReleased() {
        // Create a Game instance
        Game game = new Game("TestTitle", "TestPublisher", "TestDescription", "TestDeveloper", 2022, "http://cover-art-url.com");

        // Set a new yearReleased using setYearReleased method
        game.setYearReleased(2023);

        // Verify that the yearReleased is updated correctly
        assertEquals(2023, game.getYearReleased());
    }



}
