import java.util.ArrayList;
/**
 * Class to create sample quiz
 *
 * @author Ari
 * @version 5/15/2019
 */
public class SampleQuiz
{
    private Quiz sampleQuiz;

    /**
     * Constructor for objects of class SampleQuiz
     */
    public SampleQuiz()
    {
        sampleQuiz = new Quiz();
        addSampleQuestions();
    }

    /**
     * Add the questions to the quiz. fields of addQuestion from Quiz are:
     * question, answer, firstWrong, secondWrong
     */
    public void addSampleQuestions()
    {
        sampleQuiz.addQuestion("In the Friday the 13th movies, what is the name of the masked killer?",
                               "Jason", "Freddy", "He has no name");
        sampleQuiz.addQuestion("Julie Andrews won the Academy Award for best actress in what film?",
                               "Marry Poppins", "The Sound of Music", "Victor/Victoria");
        sampleQuiz.addQuestion("What is wrong with the Grinch's heart in How the Grinch Stole Christmas",
                               "It's two sizes too small", "It's missing", "It's cold as ice");
    }
    
    public Quiz getSampleQuiz()
    {
        return sampleQuiz;
    }
}
