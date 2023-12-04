package model;
import utils.Utilities;
public class GamePort {
    private String gamePortDeveloper = "";
    private int releaseYear = 2023;
    private String coverArtImageURL = "";

    private OriginalGame originalGame;

    public GamePort(OriginalGame game,String gamePortDeveloper, int releaseYear, String coverArtImageURL) {
        setGamePortDeveloper(gamePortDeveloper);
        setReleaseYear(releaseYear);
        setCoverArtImageURL(coverArtImageURL);
        setOriginalGame(game);
    }

    public void setOriginalGame(OriginalGame originalGame) {
        this.originalGame = originalGame;
    }

    public OriginalGame getOriginalGame() {
        return originalGame;
    }

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
        /* Validation in driver */
        this.releaseYear = releaseYear;
    }

    public String getCoverArtImageURL() {
        return coverArtImageURL;
    }

    public void setCoverArtImageURL(String coverArtImageURL) {
        this.coverArtImageURL = Utilities.truncateString(coverArtImageURL,90);
    }

    @Override
    public String toString() {
        return "GamePort {" + "original Game: " + originalGame + " }" +
                ", gamePortDeveloper = " + gamePortDeveloper +
                ", releaseYear = " + releaseYear +
                ", coverArtImageURL = " + coverArtImageURL +
                '}';
    }
}
