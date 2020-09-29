/* Camryn Sumabat | CS 3560 A1 | Voter Simulation (Like Kahoot or Mentimeter)
 * Voting Service Interface
 * 
 * Configures Question Objects, Student Objects, checks Student answers, displays the results in console
 */

import java.util.List;

public interface VotingService {
	void configureQuestionsAndAnswers(); //sets hard coded questions and answers
	void setStudents(int n); //generates n student objects, creating unique ids for each and answers
	List<iVoteStudent> getStudents(); //gets an array of the Student objects (call it studentArray)
	int[] checkAnswers(); //studentArray[i].getAnswer() == question.getCorrectAnswer() -> numCorrect[i]++
	void printResults(int[] r); //takes the array from checkAnswers and outputs it in a UI friendly way, "1. Correct: 20, 2. Incorrect: 1" etc.
}
