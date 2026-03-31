package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScoreboardTest {
    private Scoreboard scoreboard;

    @BeforeEach
    void setUp() {
        scoreboard = new Scoreboard();
    }

    @Test
    void testMatchLifeCycle() {
        scoreboard.startMatch("Mexico", "Canada");

        //1. assuming initial score 0 – 0 and adding it the scoreboard.
        List<Match> initialSummary = scoreboard.getSummary();
        assertEquals("Mexico 0 - Canada 0", initialSummary.get(0).toString());

        //2. Update score.
        scoreboard.updateScore("Mexico", "Canada", 0, 5);

        List<Match> summary = scoreboard.getSummary();
        assertEquals(1, summary.size());
        assertEquals("Mexico 0 - Canada 5", summary.get(0).toString());

        //3. Finish match currently in progress.
        scoreboard.finishMatch("Mexico", "Canada");
        assertTrue(scoreboard.getSummary().isEmpty());
    }

    @Test
    void testMatchesSummaryInTheCorrectOrder() {
        //4. Get a summary of matches in progress ordered by their total score.
        scoreboard.startMatch("Mexico", "Canada");
        scoreboard.updateScore("Mexico", "Canada", 0, 5);

        scoreboard.startMatch("Spain", "Brazil");
        scoreboard.updateScore("Spain", "Brazil", 10, 2);

        scoreboard.startMatch("Germany", "France");
        scoreboard.updateScore("Germany", "France", 2, 2);

        scoreboard.startMatch("Uruguay", "Italy");
        scoreboard.updateScore("Uruguay", "Italy", 6, 6);

        scoreboard.startMatch("Argentina", "Australia");
        scoreboard.updateScore("Argentina", "Australia", 3, 1);

        List<Match> summary = scoreboard.getSummary();
        // I only use this for myself
        // summary.forEach(System.out::println);
        assertAll(
                () -> assertEquals("Uruguay 6 - Italy 6", summary.get(0).toString()),
                () -> assertEquals("Spain 10 - Brazil 2", summary.get(1).toString()),
                () -> assertEquals("Mexico 0 - Canada 5", summary.get(2).toString()),
                () -> assertEquals("Argentina 3 - Australia 1", summary.get(3).toString()),
                () -> assertEquals("Germany 2 - France 2", summary.get(4).toString())
        );
    }

}