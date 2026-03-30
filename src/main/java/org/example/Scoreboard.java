package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Scoreboard {

    private final List<Match> matches = new ArrayList<>();

    public void startMatch(String homeTeam, String awayTeam) {
        matches.add(new Match(homeTeam, awayTeam));
    }

    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        matches.stream()
                .filter(m -> m.getHomeTeam().equals(homeTeam) && m.getAwayTeam().equals(awayTeam))
                .findFirst()
                .ifPresent(match -> match.updateScore(homeScore, awayScore));
    }

    public void finishMatch(String homeTeam, String awayTeam) {
        Match match = findMatch(homeTeam, awayTeam)
                .orElseThrow(() -> new IllegalArgumentException("Match not found"));
        matches.remove(match);
    }

    private Optional<Match> findMatch(String homeTeam, String awayTeam) {
        return matches.stream()
                .filter(m -> m.getHomeTeam().equals(homeTeam) && m.getAwayTeam().equals(awayTeam))
                .findFirst();
    }

    public List<String> getSummary() {
        List<String> summary = new ArrayList<>();
        for (Match match : matches) {
            summary.add(match.toString());
        }
        return summary;
    }
}