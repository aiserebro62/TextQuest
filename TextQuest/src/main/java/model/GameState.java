package model;


import lombok.Getter;
import lombok.Setter;

@Getter
public class GameState {
    // Getters and Setters
    @Setter
    private String currentSituation;
    private String playerName;
    private int gamesPlayed;
    @Setter
    private boolean gameOver;
    @Setter
    private boolean victory;

    public GameState(String playerName) {
        this.playerName = playerName;
        this.gamesPlayed = 0;
        this.gameOver = false;
        this.victory = false;
    }

    public void incrementGamesPlayed() {
        this.gamesPlayed++;
    }

}



