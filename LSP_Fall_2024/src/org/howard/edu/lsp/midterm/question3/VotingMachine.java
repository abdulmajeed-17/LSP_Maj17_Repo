package org.howard.edu.lsp.midterm.question3;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages candidates and their vote counts.
 */
public class VotingMachine {
    private Map<String, Integer> candidates;

    /**
     * Initializes the voting machine with no candidates.
     */
    public VotingMachine() {
        candidates = new HashMap<>();
    }

    /**
     * Adds a new candidate.
     *
     * @param name The candidate's name.
     * @throws IllegalArgumentException if the name is null, empty, or already exists.
     */
    public void addCandidate(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Candidate name cannot be empty.");
        }
        if (candidates.containsKey(name)) {
            throw new IllegalArgumentException("Candidate \"" + name + "\" already exists.");
        }
        candidates.put(name, 0);
    }

    /**
     * Casts a vote for a candidate.
     *
     * @param name The candidate's name.
     * @throws IllegalArgumentException if the candidate does not exist.
     */
    public void castVote(String name) {
        if (!candidates.containsKey(name)) {
            throw new IllegalArgumentException("Candidate \"" + name + "\" does not exist.");
        }
        candidates.put(name, candidates.get(name) + 1);
    }

    /**
     * Returns the voting results.
     *
     * @return A string listing each candidate and their vote count.
     */
    @Override
    public String toString() {
        StringBuilder results = new StringBuilder("Voting Results:\n");
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            results.append(entry.getKey())
                   .append(": ")
                   .append(entry.getValue())
                   .append(" vote(s)\n");
        }
        return results.toString();
    }
}
