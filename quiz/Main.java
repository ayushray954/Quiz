package quiz;
import java.util.*;
import user.*;
import question.*;
import result.*;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the size of questions");
		int size = input.nextInt();
		input.nextLine();
		String[] questionTexts = new String[size];
		String[][] options = new String[size][4];
		String[] answer = new String[size];
		Student[] studentArray = new Student[10];
		long[] time = {0,0,0,0,0,0,0};
		int index = 0;
		// Input questions and options
		for(int i = 0; i < questionTexts.length; i++){
			System.out.println("Enter question " + (i+1) + " : ");
			questionTexts[i] = input.nextLine();
			for(int j = 0; j < 4; j++) {
				System.out.println("Enter option " + (j+1) + " : ");
				options[i][j] = input.nextLine();
			}
			System.out.println("Enter Correct answer(1-4) : ");
			answer[i] = input.next();
			input.nextLine();
		}

		int[] resultArray = new int[studentArray.length];

		// Collect students answers and results
		while(index < studentArray.length) {
			int result = 0;
			System.out.println("Do you want to attempt the quiz\nEnter 1 to attempt else enter 0");
			String choice = input.next();
			if(choice.equals("1")) {
				input.nextLine();
				System.out.println("Enter your name: ");
				String userName = input.nextLine();
				Student student = new Student(userName);
				studentArray[index] = student;

				for(int i = 0; i < questionTexts.length; i++){
					Question question = new Question(questionTexts[i],options[i],answer[i]);
					System.out.println(question);
					long startTime = (System.currentTimeMillis());
					String userAnswer = input.next();
					long endTime = (System.currentTimeMillis());

					Score score = new Score(question,userAnswer);
					if(time[i]<(endTime-startTime)){
						time[i] = (endTime-startTime);
					}

					result += score.getScore();
				}
				student.setResult(result);
				resultArray[index] = result;
				index++;
				System.out.println("Your test is submitted : \n" + student);
			} else {
				System.out.println("THANK YOU");
				break;
			}
		}

		for (int i = 0; i < resultArray.length - 1; i++) {
			for (int j = 0; j < resultArray.length - i - 1; j++) {
				if (resultArray[j] < resultArray[j + 1]) {
					// Swap results
					int tempResult = resultArray[j];
					resultArray[j] = resultArray[j + 1];
					resultArray[j + 1] = tempResult;

					Student tempStudent = studentArray[j];
					studentArray[j] = studentArray[j + 1];
					studentArray[j + 1] = tempStudent;
				}
			}
		}
		System.out.println("\nTop 5 Students:");
		for (int i = 0; i < 5 && studentArray[i] != null; i++) {
			System.out.print ( studentArray[i].getName());
			System.out.print(",");
		}
		System.out.println();

		int maxScore = resultArray[0]; // Highest score
		for (int i = maxScore; i >= 0; i--) {
			for (int j = 0; j < 5 && studentArray[j] != null; j++) {

				if (resultArray[j] >= i) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		for (int i = 0; i < questionTexts.length - 1; i++) {
			for (int j = 0; j < questionTexts.length - i - 1; j++) {
				if (time[j] < time[j + 1]) {
					// Swap results
					long tempResult = time[j];
					time[j] = time[j + 1];
					time[j + 1] = tempResult;

					String tempQuestion = (questionTexts[j]);
					questionTexts[j] = questionTexts[j + 1];
					questionTexts[j + 1] = tempQuestion;
				}
			}
		}
		for(int i = 0; i < questionTexts.length; i++){
			System.out.println(questionTexts[i]);
		}
	}
}
