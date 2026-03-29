package org.example;

import java.util.ArrayList;
import java.util.List;

public class Scoreboard {

    private final List<String> matches = new ArrayList<>();

    public void startMatch(String homeTeam, String awayTeam) {
        matches.add(homeTeam + " 0 - " + awayTeam + " 0");
    }

    public List<String> getSummary() {
        return new ArrayList<>(matches);
    }
}