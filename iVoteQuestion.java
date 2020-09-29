/* Camryn Sumabat | CS 3560 A1 | Voter Simulation (Like Kahoot or Mentimeter)
 * Implements Question Interface
 * 
 */

public class iVoteQuestion implements Question {

	private String question;
	private String[] answerOptions;
	private int singleAnswer;
	private int[] multiAnswer;

	
	@Override
	public void setQuestion(String q) {
		this.question = q;
	}

	@Override
	public String getQuestion() {
		return question;
	}

	@Override
	public void createAnswerOptions(int length) {
		answerOptions = new String[length];
	}
	
	public void populateAnswerOptions(int index, String answerOption) {
		answerOptions[index] = answerOption;
	}

	@Override
	public void setCorrectSingleAnswer(int sAnswer) {
		this.singleAnswer = sAnswer;
	}

	@Override
	public int getCorrectSingleAnswer() {
		return singleAnswer;
	}
	
	//for debugging
	public void printCorrectSingleAnswer() {
		System.out.println("There is one correct answer: " + answerOptions[singleAnswer]);
	}

	public void createCorrectMultiAnswerArray(int[] correctAnswers) {
		this.multiAnswer = correctAnswers;
	}
	
	@Override
	public void setCorrectMultiAnswer(int index, int correctAnswerIndex) {
		multiAnswer[index] = correctAnswerIndex;
	}

	@Override
	public int[] getCorrectMultiAnswer() {
		return multiAnswer;
	}
	
	//for debugging
	public void printCorrectMultiAnswer() {
		String result = "";
		for (int i = 0; i < multiAnswer.length-1; i++) {
			result += answerOptions[multiAnswer[i]] + ", " ;
		}
		result += answerOptions[multiAnswer[multiAnswer.length-1]];
		System.out.println("There are " + multiAnswer.length + " correct answers: " + result);
	}

}
