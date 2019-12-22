
/**
 * Question items for quiz ArrayLists
 *
 * @author Ari
 * @version 5/15/2019
 */
public class Question
{
    private String question;
    private String answer;
    private String firstWrong;
    private String secondWrong;

    /**
     * Constructor for objects of class Question
     */
    public Question(String question, String answer, String firstWrong, String secondWrong)
    {
        this.question = question;
        this.answer = answer;
        this.firstWrong = firstWrong;
        this.secondWrong = secondWrong;
    }
    
    public String getQuestion()
    {
        return question;
    }
    
    public String getAnswer()
    {
        return answer;
    }
    
    public String getFirstWrong()
    {
        return firstWrong;
    }
    
    public String getSecondWrong()
    {
        return secondWrong;
    }
}
