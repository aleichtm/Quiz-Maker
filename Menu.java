import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Main class to run the quiz. Calls all the other classes
 *
 * @author Ari
 * @version 5/15/2019
 */
public class Menu
{
    private Scanner reader = new Scanner(System.in);
    private Quiz userQuiz;
    private SampleQuiz sampleQuiz;
    
    //true means userQuiz is selected, false means sampleQuiz is selected
    private boolean userOrSample;

    /**
     * Constructor for objects of class Menu
     */
    public Menu()
    {
        userQuiz = new Quiz();
        sampleQuiz = new SampleQuiz();
        userOrSample = true;
    }

    /**
     * 
     */
    public void start()
    {
        int choice;
        int highest = 6;
        while(true) {
            System.out.println("");
            System.out.println("MENU");
            System.out.println("Choose from the following options (type the number)");
            System.out.println("1. Add Question to your quiz.");
            System.out.println("2. Add the sample questions to your quiz.");
            
            System.out.print("3. ");
            if(userOrSample) {
                System.out.println("Switch to sample Quiz.");
            } else {
                System.out.println("Switch back to user Quiz.");
            }
            
            System.out.println("4. Start Quiz");
            System.out.println("5. Print menu again.");
            System.out.println(highest + ". Quit");
            choice = Integer.parseInt(reader.nextLine());
            while(true) {
                if(choice == 42) {
                    System.out.println("Congratulations! You have discovered the Ultimate Answer to Life, The Universe, and Everything. You win");
                    return;
                } else if((choice < 1) || (choice > highest)) {
                    System.out.println("Please choose one of the options. Type 5 to display the menu again.");
                    choice = Integer.parseInt(reader.nextLine());
                } else if(choice == 1) {
                    userQuiz.addQuestionUser();
                    break;
                } else if(choice == 2) {
                    for(Question question : sampleQuiz.getSampleQuiz().getQuiz()) {
                        userQuiz.getQuiz().add(question);
                    }
                    break;
                } else if(choice == 3) {
                    if(userOrSample) {
                        userOrSample = false;
                    } else {
                        userOrSample = true;
                    }
                    break;
                } else if(choice == 4) {
                    startQuiz();
                    return;
                } else if(choice == 5) {
                    break;
                } else if(choice == 6) {
                    return;
                } else {
                    System.out.println("ERROR");
                    break;
                }
            }
        }
    }
    
    public void startQuiz()
    {
        ArrayList<Question> quiz;
        if(userOrSample) {
            quiz = userQuiz.getQuiz();
        } else {
            quiz = sampleQuiz.getSampleQuiz().getQuiz();
        }
        Collections.shuffle(quiz);
        quiz.add(new Question("What is the Ultimate Answer to Life, The Universe and Everything?", "42",
                              "Nobody exists on purpose, nobody belongs anywhere, everybody's gonna die. Come watch tv?",
                              "The first season of Lost on DVD"));
        
        System.out.println("");
        System.out.println("For each question, type the number of the answer to submit");
        ArrayList<String> answers = new ArrayList<>();
        int i = 1;
        int answer;
        int correct = 0;
        for(Question question : quiz) {
            System.out.println("");
            System.out.println(question.getQuestion());
            answers.add(question.getAnswer());
            answers.add(question.getFirstWrong());
            answers.add(question.getSecondWrong());
            Collections.shuffle(answers);
            while(i < 4) {
                System.out.println(i + ". " + answers.get(i - 1));
                i++;
            }
            answer = Integer.parseInt(reader.nextLine());
            if(answers.get(answer - 1).equals(question.getAnswer())) {
                System.out.println("Correct!");
                correct++;
            } else {
                System.out.println("Incorrect. The correct answer was:");
                System.out.println(question.getAnswer());
            }
            i = 1;
            answers.clear();
        }
        System.out.println("Congratulations! You got " + correct + " out of " + quiz.size() + " answers correct!");
    }
}
