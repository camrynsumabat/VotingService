/* Camryn Sumabat | CS 3560 A1 | Voter Simulation (Like Kahoot or Mentimeter)
 * Question Interface
 * 
 * Configures questions, answer options, and correct answer options
 */

public interface Question {
	
	void setQuestion(String q);
	String getQuestion();
	void createAnswerOptions(int length);
	void populateAnswerOptions(int index, String answerOption);
	void setCorrectSingleAnswer(int sAnswer);
	int getCorrectSingleAnswer();
	void createCorrectMultiAnswerArray(int[] correctAnswers);
	void setCorrectMultiAnswer(int index, int correctAnswerIndex);
	int[] getCorrectMultiAnswer();

}
