package question;

import java.time.LocalDateTime;

public class Question {
	private String id = null;
	private String questionText = null;
	private String[] options = new String[4];
	private String answer = null;
	public Question(String questionText, String[] options,String answer){
		this.questionText = questionText;
		this.options = options;
		this.answer = answer;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public String[] getOptions() {
		return options;
	}
	public void setOptions(String[] options) {
		this.options = options;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String toString() {
		String print = "Q: " + this.questionText;
		print += "\n1. " + this.options[0] + "\n2. " + this.options[1] + "\n3. " + this.options[2] + "\n4. " + this.options[3];
		print += "\nEnter your Answer(1-4) : ";		
		return print;
	}
}
