package modelTest;

import model.OriginalGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OriginalGameTest {

    private OriginalGame originalGame;

    @BeforeEach
    void setUp() {
        // Create a new OriginalGame instance before each test
        originalGame = new OriginalGame("TestTitle", "TestPublisher", "TestDescription", "TestDeveloper", 2022, "http://cover-art.com");
    }

    @Test
    void testGetTitle() {
        assertEquals("TestTitle", originalGame.getTitle());
    }

    @Test
    void testSetTitle() {
        // Set a new title
        originalGame.setTitle("NewTitle");

        // Verify that the title is set
        assertEquals("NewTitle", originalGame.getTitle());
    }

    @Test
    void testGetPublisher() {
        assertEquals("TestPublisher", originalGame.getPublisher());
    }

    @Test
    void testSetPublisher() {
        // Set a new publisher
        originalGame.setPublisher("NewPublisher");

        // Verify that the publisher is set
        assertEquals("NewPublisher", originalGame.getPublisher());
    }

    @Test
    void testGetDescription() {
        assertEquals("TestDescription", originalGame.getDescription());
    }

    @Test
    void testSetDescription() {
        // Set a new description
        originalGame.setDescription("NewDescription");

        // Verify that the description is set
        assertEquals("NewDescription", originalGame.getDescription());
    }

    @Test
    void testGetOrginalDeveloper() {
        assertEquals("TestDeveloper", originalGame.getOrginalDeveloper());
    }

    @Test
    void testSetOrginalDeveloper() {
        // Set a new original developer
        originalGame.setOrginalDeveloper("NewDeveloper");

        // Verify that the original developer is set
        assertEquals("NewDeveloper", originalGame.getOrginalDeveloper());
    }

    @Test
    void testGetYearReleased() {
        assertEquals(2022, originalGame.getYearReleased());
    }

    @Test
    void testSetYearReleased() {
        // Set a new year released
        originalGame.setYearReleased(2023);

        // Verify that the year released is set
        assertEquals(2023, originalGame.getYearReleased());
    }

    @Test
    void testGetURL() {
        assertEquals("http://cover-art.com", originalGame.getURL());
    }

    @Test
    void testSetURL() {
        // Set a new URL
        originalGame.setURL("http://new-cover-art.com");

        // Verify that the URL is set
        assertEquals("http://new-cover-art.com", originalGame.getURL());
    }

}

