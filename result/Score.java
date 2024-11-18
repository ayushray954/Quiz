package result;
import question.*;
public class Score{
	private int score = 0;
	private String answer = null;
	private String userAnswer = null;
	public Score(Question qu,String userAnswer) {
		this.answer = qu.getAnswer();
		this.userAnswer = userAnswer;
		calculate();
	}
	public int getScore() {
		return score;
	}
	private void calculate() {
		if(answer.equals(userAnswer)) {
			score += 1;
		}
		else {
			score -= 0;
		}
	}
}