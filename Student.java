/* Camryn Sumabat | CS 3560 A1 | Voter Simulation (Like Kahoot or Mentimeter)
 * Student Interface
 * 
 * Generates student ID's and answers
 */

public interface Student {
	
	void setStudentId(int id);
	int getStudentId();
	void setSingleAnswer(int sAnswer);
	int getSingleAnswer();
	void setMultiAnswer(int[] mAnswer);
	int[] getMultiAnswer();
	
}
