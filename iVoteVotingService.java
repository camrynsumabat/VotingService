/* Camryn Sumabat | CS 3560 A1 | Voter Simulation (Like Kahoot or Mentimeter)
 * Implements VotingService Interface
 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class iVoteVotingService implements VotingService {
	
	private final int STUDENT_COUNT = 10; //student count can be changed and program will still run
	private List<iVoteStudent> s = new ArrayList<iVoteStudent>();
	
	//questions and answers can be altered and program will still run, be sure to have question count match number of questions in questionBank
	private final int QUESTION_COUNT = 5;
	
	private String[] questionBank = {"What is my name?", 
									"How old am I?", 
									"What do I like to do?", 
									"How many classes am I taking at CPP?", 
									"What is my graduation year?"};
	
	private String[][] questionAnswerOptions = { {"Camryn", "Cam", "Nic", "Joey"}, 
													{"Nineteen", "Eighteen", "Twenty-One", "Twenty"}, 
													{"Run", "Code", "Bake", "Paint"}, 
													{"4", "5", "6", "3"},
													{"2024", "2020", "2021", "2022"} };
	
	private int[][] correctAnswers = { {0, 1},
									{3}, 
									{2, 3}, 
									{1}, 
									{3} };

	
	//runs voting service
	public void start() {
		setStudents(STUDENT_COUNT);
		configureQuestionsAndAnswers();
		displayQuestionsAndAnswerOptions();
		
		//first answers
		for (int i = 0; i < STUDENT_COUNT; i++) {
			setStudentAnswers(s.get(i));
		}
		
		printResults(checkAnswers());
		
		//re-voting
		System.out.println("Re-vote\n");
		
		for (int i = 0; i < STUDENT_COUNT; i++) {
			setStudentAnswers(s.get(i));
		}
		
		printResults(checkAnswers());
	}
	
	
	//creates array of objects iVoteQuestion and populates each iVoteQuestion with given questions and answers
	@Override
	public void configureQuestionsAndAnswers() {
				
		iVoteQuestion[] questionObjBank = new iVoteQuestion[QUESTION_COUNT];
		
		for (int i = 0; i < QUESTION_COUNT; i++) {
			iVoteQuestion q = new iVoteQuestion();
			q.setQuestion(questionBank[i]);
			q.createAnswerOptions(QUESTION_COUNT);
			
			for (int j = 0; j < questionAnswerOptions[i].length; j++)
				q.populateAnswerOptions(j, questionAnswerOptions[i][j]);
			
			if (correctAnswers[i].length == 1) {						//handles single or multiple answer questions
				q.setCorrectSingleAnswer(correctAnswers[i][0]);
				//q.printCorrectSingleAnswer();							//uncomment to debug - see correct single answer answers
			}
			else {
				q.createCorrectMultiAnswerArray(correctAnswers[i]);
				//q.printCorrectMultiAnswer();							//uncomment to debug - see correct multi answer answers
			}
			questionObjBank[i] = q;
		}
	}
	
	//populates list of iVoteStudent objects with their ID #
	@Override
	public void setStudents(int n) {
		for (int i = 0; i < n; i++) {
			iVoteStudent student = new iVoteStudent();
			s.add(student);
			s.get(i).setStudentId(i);
		}
	}

	@Override
	public List<iVoteStudent> getStudents() {
		return s;
	}
	
	//prints student ID's (for debugging)
		public void printStudentIds() {
			for (int i = 0; i < s.size(); i++) {
				System.out.println("Student " + i + ": " + s.get(i).getStudentId());
			}
		}
	
	
	//sets iVoteStudent answers
	public iVoteStudent setStudentAnswers(iVoteStudent student) {
		for (int i = 0; i < QUESTION_COUNT; i++) {
			int correctAnswerLength = correctAnswers[i].length,
				answerOptionLength = questionAnswerOptions[i].length,
						answer;
			int[] multiAnswer;
			Random r = new Random();

			if (correctAnswerLength == 1) {
				answer = r.nextInt(answerOptionLength);
				student.setSingleAnswer(answer);
				//student.printCorrectSingleAnswer();				//uncomment to debug - see student's single answer answers
			}
			else {
				multiAnswer = new int[correctAnswerLength];
				for (int j = 0; j < correctAnswerLength; j++) {
					multiAnswer[j] = r.nextInt(answerOptionLength);
				}
				student.setMultiAnswer(multiAnswer);
				//student.printCorrectMultiAnswer();				//uncomment to debug - see student's multi answer answers
			}
		}
		return student;
	}
	
	//checks student answers with question answers
	@Override
	public int[] checkAnswers() {
		int[] numCorrect = new int[QUESTION_COUNT];
		
		for (int i = 0; i < QUESTION_COUNT; i++) {
			int numOfCorrectAnswers = correctAnswers[i].length;
			
			for (int k = 0; k < STUDENT_COUNT; k++) {
				
				if (numOfCorrectAnswers == 1 && (s.get(k).getSingleAnswer() == correctAnswers[i][0])) {
					numCorrect[i]++;
				}
				else {
					int check = 0;
					for (int j = 0; j < numOfCorrectAnswers; j++) {
						if (s.get(k).getMultiAnswer(j) == correctAnswers[i][j])
							check++;
					}
					
					if (check == numOfCorrectAnswers) {
						numCorrect[i]++;
					}
				}
			}
			
		}
		
		return numCorrect;
	}
	
	//prints questions and answer options for UI
	public void displayQuestionsAndAnswerOptions() {
		for (int i = 0; i < QUESTION_COUNT; i++) {
			System.out.println("Question " + (i+1) + ": " + questionBank[i]);
			for (int j = 0; j < questionAnswerOptions[i].length; j++) {
				System.out.print(j + ": " + questionAnswerOptions[i][j] + "     ");
			}
			System.out.println("\n");
		}
	}	

	//prints overall quiz results
	@Override
	public void printResults(int[] r) {
		for (int i = 0; i < QUESTION_COUNT; i++) {
			System.out.println("Question " + (i+1) + "\nCorrect: " + r[i] + " Incorrect: " + (STUDENT_COUNT-r[i]) + "\n");
		}
	}

}
