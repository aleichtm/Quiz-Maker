import java.util.ArrayList;
import java.util.Scanner;
/**
 * Holds quiz ArrayList and has methods for adding Questions
 *
 * @author Ari
 * @version 5/15/2019
 */
public class Quiz
{
    private ArrayList<Question> quiz;
    private Scanner reader = new Scanner(System.in);

    /**
     * Constructor for objects of class Quiz
     */
    public Quiz()
    {
        quiz = new ArrayList<>();
    }

    /**
     * Add question to quiz from parameters
     */
    public void addQuestion(String question, String answer, String firstWrong, String secondWrong)
    {
        quiz.add(new Question(question, answer, firstWrong, secondWrong));
    }
    
    /**
     * Add question to quiz from user
     */
    public void addQuestionUser()
    {
        System.out.print("Question: ");
        String question = reader.nextLine();
        System.out.print("Answer: ");
        String answer = reader.nextLine();
        System.out.print("Wrong Option 1: ");
        String firstWrong = reader.nextLine();
        System.out.print("Wrong Option 2: ");
        String secondWrong = reader.nextLine();
        quiz.add(new Question(question, answer, firstWrong, secondWrong));
    }
    
    public ArrayList<Question> getQuiz()
    {
        return quiz;
    }
}
