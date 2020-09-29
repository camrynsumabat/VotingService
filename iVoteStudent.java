/* Camryn Sumabat | CS 3560 A1 | Voter Simulation (Like Kahoot or Mentimeter)
 * Implements Student Interface
 * 
 */

public class iVoteStudent extends iVoteVotingService implements Student {
	private int studentId;
	private int singleAnswer;
	private int[] multiAnswer;
	
	
	@Override
	public void setStudentId(int id) {
		this.studentId = id;
	}

	@Override
	public int getStudentId() {
		return studentId;
	}
	
	@Override
	public void setSingleAnswer(int sAnswer) {
		this.singleAnswer = sAnswer;
	}
	
	@Override
	public int getSingleAnswer() {
		return singleAnswer;
	}
	
	//for debugging
	public void printCorrectSingleAnswer() {
		System.out.println("There is 1 answer from student " + studentId + ": " + singleAnswer);
	}
	
	@Override
	public void setMultiAnswer(int[] mAnswer) {
		this.multiAnswer = mAnswer;
	}

	@Override
	public int[] getMultiAnswer() {
		return multiAnswer;
	}
	
	public int getMultiAnswer(int index) {
		return multiAnswer[index];
	}
	
	//for debugging
	public void printCorrectMultiAnswer() {
		String result = "";
		for (int i = 0; i < multiAnswer.length-1; i++) {
			result += multiAnswer[i] + ", " ;
		}
		System.out.println("There are " + multiAnswer.length + " answers from student " + studentId + ": " + result + multiAnswer[multiAnswer.length-1]);
	}

}
