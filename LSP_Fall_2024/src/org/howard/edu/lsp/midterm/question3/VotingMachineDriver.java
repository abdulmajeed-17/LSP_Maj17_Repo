package org.howard.edu.lsp.midterm.question3;

/**
 * The VotingMachineDriver class demonstrates how to use the VotingMachine class.
 * It adds candidates, casts votes for them, and displays the voting results.
 */
public class VotingMachineDriver {
    /**
     * The main method serves as the entry point of the application.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Create a new instance of VotingMachine
        VotingMachine vm = new VotingMachine();

        // Add candidates to the voting machine
        vm.addCandidate("Alsobrooks");
        vm.addCandidate("Hogan");

        // Cast votes for the candidates
        vm.castVote("Alsobrooks"); // Alsobrooks receives their first vote
        vm.castVote("Alsobrooks"); // Alsobrooks receives their second vote
        vm.castVote("Hogan");       // Hogan receives their first vote

        // Display the voting results
        System.out.println(vm.toString());
        /*
         * Voting Results:
         * Alsobrooks: 2 vote(s)
         * Hogan: 1 vote(s)
         */
    }
}
