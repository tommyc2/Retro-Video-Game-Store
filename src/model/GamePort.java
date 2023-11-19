package model;
import utils.Utilities;
public class GamePort {

    /* Hierarchy for Model Classes yet to be decided */

    private Game gameBeingPorted;
    private GameMachine portedToGamesMachine;
    private String gamePortDeveloper = "";
    private int releaseYear = 2023;
    private String coverArtImageURL = "";

    public GamePort(Game gameBeingPorted, GameMachine portedToGamesMachine, String gamePortDeveloper, int releaseYear, String coverArtImageURL) {
        // Game
        // Games Machine
        setGamePortDeveloper(gamePortDeveloper);
        setReleaseYear(releaseYear);
        setCoverArtImageURL(coverArtImageURL);
    }

    // -------------------------------------------------------------------///
    // Getter and setters for games machine and game yet to be added //
    // -------------------------------------------------------------------///

    public String getGamePortDeveloper() {
        return gamePortDeveloper;
    }

    public void setGamePortDeveloper(String gamePortDeveloper) {
        this.gamePortDeveloper = Utilities.truncateString(gamePortDeveloper,30);
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        /* if (releaseYear < game release year)
        {
        this.releaseYear = releaseYear;
        }
        */
    }

    public String getCoverArtImageURL() {
        return coverArtImageURL;
    }

    public void setCoverArtImageURL(String coverArtImageURL) {
        this.coverArtImageURL = Utilities.truncateString(coverArtImageURL,90);
    }

    @Override
    public String toString(){
        return "";
    }
}
