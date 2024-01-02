package modelTest;
import model.GamePort;
import model.OriginalGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GamePortTest {

    private GamePort gamePort;
    private OriginalGame originalGame;

    @BeforeEach
    void setUp() {
        // Create a new OriginalGame instance before each test
        originalGame = new OriginalGame("TestTitle", "TestPublisher", "TestDescription", "TestDeveloper", 2022, "http://game-cover-art.com");

        // Create a new GamePort instance before each test
        gamePort = new GamePort(originalGame, "TestDeveloper", 2023, "http://cover-art.com");
    }

    @Test
    void testSetOriginalGame() {
        // Create a new OriginalGame
        OriginalGame newOriginalGame = new OriginalGame("NewTitle", "NewPublisher", "NewDescription", "NewDeveloper", 2023, "http://new-cover-art.com");

        // Set the OriginalGame in the GamePort
        gamePort.setOriginalGame(newOriginalGame);

        // Verify that the OriginalGame is set
        assertEquals(newOriginalGame, gamePort.getOriginalGame());
    }

    @Test
    void testGetGamePortDeveloper() {
        assertEquals("TestDeveloper", gamePort.getGamePortDeveloper());
    }

    @Test
    void testSetGamePortDeveloper() {
        // Set a new GamePortDeveloper
        gamePort.setGamePortDeveloper("NewDeveloper");

        // Verify that the GamePortDeveloper is set
        assertEquals("NewDeveloper", gamePort.getGamePortDeveloper());
    }

    @Test
    void testGetReleaseYear() {
        assertEquals(2023, gamePort.getReleaseYear());
    }

    @Test
    void testSetReleaseYear() {
        // Set a new release year
        gamePort.setReleaseYear(2024);

        // Verify that the release year is set
        assertEquals(2024, gamePort.getReleaseYear());
    }

    @Test
    void testGetCoverArtImageURL() {
        assertEquals("http://cover-art.com", gamePort.getCoverArtImageURL());
    }

    @Test
    void testSetCoverArtImageURL() {
        // Set a new cover art image URL
        gamePort.setCoverArtImageURL("http://new-cover-art.com");

        // Verify that the cover art image URL is set
        assertEquals("http://new-cover-art.com", gamePort.getCoverArtImageURL());
    }

}


