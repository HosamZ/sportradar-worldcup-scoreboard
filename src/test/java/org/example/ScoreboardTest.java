package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class ScoreboardTest {

    @Test
    void shouldStartNewMatchWithInitialScoreZeroZero() {

        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startMatch("Mexico", "Canada");

        List<String> summary = scoreboard.getSummary();
        assertEquals(1, summary.size());
        assertEquals("Mexico 0 - Canada 0", summary.get(0));
    }

    @Test
    void shouldUpdateScoreOfExistingMatch() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startMatch("Mexico", "Canada");
        scoreboard.updateScore("Mexico", "Canada", 0, 5);

        List<String> summary = scoreboard.getSummary();
        assertEquals("Mexico 0 - Canada 5", summary.get(0));
    }
}