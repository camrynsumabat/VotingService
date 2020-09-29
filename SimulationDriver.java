/* Camryn Sumabat | CS 3560 Object Oriented Programming Assignment 1 | Voting Simulation | Last updated: 9/27/2020
 * Driver Class
 * 
 * Similar to Kahoot/Mentimeter, create a program that allows the user to create questions and assign correct answers.
 * Randomly generate a number of students and their answers
 * Submit the answers to the voting service
 * Call the voting service output to display the results
 */

public class SimulationDriver {

	public static void main(String[] args) {
		
		iVoteVotingService a = new iVoteVotingService();
		a.start();
		
	} 

}
