import java.util.*;

class QuizQuestion {
    private String question;
    private List<String> options;
    private int correctOptionIndex;

    public QuizQuestion(String question, List<String> options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}

public class QuizGame {
    private List<QuizQuestion> quizQuestions;
    private int currentQuestionIndex;
    private int userScore;

    public QuizGame(List<QuizQuestion> quizQuestions) {
        this.quizQuestions = quizQuestions;
        this.currentQuestionIndex = 0;
        this.userScore = 0;
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Quiz Game!");

        for (QuizQuestion question : quizQuestions) {
            displayQuestion(question);
            System.out.print("Enter your choice (1-" + question.getOptions().size() + "): ");

            int userChoice = scanner.nextInt();

            if (userChoice == question.getCorrectOptionIndex() + 1) {
                System.out.println("Correct!\n");
                userScore++;
            } else {
                System.out.println("Incorrect. The correct answer is: " +
                        (question.getCorrectOptionIndex() + 1) + ".\n");
            }
        }

        displayResult();
        scanner.close();
    }

    private void displayQuestion(QuizQuestion question) {
        System.out.println(question.getQuestion());
        List<String> options = question.getOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    private void displayResult() {
        System.out.println("Quiz completed!");
        System.out.println("Your Score: " + userScore + "/" + quizQuestions.size());
    }

    public static void main(String[] args) {
        // Example quiz questions
        List<QuizQuestion> questions = new ArrayList<>();
        questions.add(new QuizQuestion("What is the capital of France?",
                Arrays.asList("Berlin", "Madrid", "Paris", "Rome"), 2));
        questions.add(new QuizQuestion("Which planet is known as the Red Planet?",
                Arrays.asList("Venus", "Mars", "Jupiter", "Saturn"), 2));
        questions.add(new QuizQuestion("What is the largest mammal?",
                Arrays.asList("Elephant", "Whale Shark", "Blue Whale", "Giraffe"), 2));

        QuizGame quizGame = new QuizGame(questions);
        quizGame.startQuiz();
    }
}
