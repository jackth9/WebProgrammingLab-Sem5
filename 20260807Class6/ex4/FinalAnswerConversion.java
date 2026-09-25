public class FinalAnswerConversion {

    public static String finalAnswers(String answers) {

        answers = answers.replace('e', 'b');
        answers = answers.replace('E', 'A');

        answers = answers.replace('f', 'c');
        answers = answers.replace('F', 'D');

        answers = answers.toLowerCase();

        return answers;
    }

    public static void main(String[] args) {

	String answers = DecodeAnswers.getAnswer();

        String finalKey =
            finalAnswers(answers);

        System.out.println(
            "Original answers: " + answers
        );

        System.out.println(
            "Final answers: " + finalKey
        );
    }
}