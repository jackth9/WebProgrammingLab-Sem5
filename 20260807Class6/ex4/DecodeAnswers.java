import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DecodeAnswers {
	public static String getAnswer() {
	    String answers = "";
       try {
            Scanner scan =
                new Scanner(new File("CodedAnswerKey.txt"));

            while (scan.hasNextLine()) {

                String line = scan.nextLine();

                if (line.matches("[a-fA-F]")) {

                    answers += line;
                }
            }
	    scan.close();
	     
	} catch (FileNotFoundException e) {

            System.out.println(
                "Error: CodedAnswerKey file not found."
            );
        }
	return(answers);
      }

public static void main(String[] args) {

        String answers = "";

        try {

            Scanner scan =
                new Scanner(new File("CodedAnswerKey.txt"));

            while (scan.hasNextLine()) {

                String line = scan.nextLine();

                if (line.matches("[a-fA-F]")) {

                    answers += line;
                }
            }

            scan.close();

            System.out.println(
                "Decoded answers: " + answers
            );

        }
        catch (FileNotFoundException e) {

            System.out.println(
                "Error: CodedAnswerKey file not found."
            );
        }
    }
}