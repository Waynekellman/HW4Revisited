package com.nyc.hw4revisited;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button ans1,ans2,ans3,ans4,play;
    private TextView questionText,score;
    private HashMap<String,List<String>> questionKey = new HashMap<>();
    private List<String> answers1,answers2,answers3,answers4;
    private List<String> questionList;
    private String answer;
    private int currentScore = 0;
    private boolean toggle = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiateViews();
        setQuestion();
    }

    public void initiateViews(){
        ans1 = (Button) findViewById(R.id.ans_1);
        ans2 = (Button) findViewById(R.id.ans_2);
        ans3 = (Button) findViewById(R.id.ans_3);
        ans4 = (Button) findViewById(R.id.ans_4);
        play = (Button) findViewById(R.id.play);
        score = (TextView) findViewById(R.id.score);
        questionText = (TextView) findViewById(R.id.question);
        ans1.setVisibility(View.INVISIBLE);
        ans2.setVisibility(View.INVISIBLE);
        ans3.setVisibility(View.INVISIBLE);
        ans4.setVisibility(View.INVISIBLE);
    }

    public void buttonPress(View view){

        switch (view.getId()){
            case R.id.play:
                setViewTexts();
                toggleVisibility();
                break;
            case R.id.ans_1:
                if (answer.equals(ans1.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    increaseScore();
                }
                setViewTexts();
                break;
            case R.id.ans_2:
                if (answer.equals(ans2.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    increaseScore();
                }
                setViewTexts();
                break;

            case R.id.ans_3:
                if (answer.equals(ans3.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    increaseScore();
                }
                setViewTexts();
                break;
            case R.id.ans_4:
                if (answer.equals(ans4.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    increaseScore();
                }
                setViewTexts();
                break;

        }
    }

    public void toggleVisibility(){
        play.setVisibility(View.INVISIBLE);
        ans1.setVisibility(View.VISIBLE);
        ans2.setVisibility(View.VISIBLE);
        ans3.setVisibility(View.VISIBLE);
        ans4.setVisibility(View.VISIBLE);
    }

    public void increaseScore(){
        currentScore++;
        String update = "Score = " + String.valueOf(currentScore);
        score.setText(update);
    }

    public void setViewTexts(){
        Random random = new Random();
        int quizNum = random.nextInt(questionKey.size());
        questionText.setText(questionList.get(quizNum));
        ans1.setText(questionKey.get(questionList.get(quizNum)).get(0));
        ans2.setText(questionKey.get(questionList.get(quizNum)).get(1));
        ans3.setText(questionKey.get(questionList.get(quizNum)).get(2));
        ans4.setText(questionKey.get(questionList.get(quizNum)).get(3));
        answer = questionKey.get(questionList.get(quizNum)).get(4);
    }

    public void setQuestion(){
        answers1 = new ArrayList<>();
        answers2 = new ArrayList<>();
        answers3 = new ArrayList<>();
        answers4 = new ArrayList<>();
        questionList = new LinkedList<>();

        answers1.add("Mood");
        answers1.add("Behavior");
        answers1.add("Initialization");
        answers1.add("Quantity");
        answers1.add("Behavior");
        questionList.add("Fields and methods of a class describe the _______ of an object.");
        questionKey.put("Fields and methods of a class describe the _______ of an object.", answers1);
        answers2.add("public class <T> Generic{}");
        answers2.add("<T> public class Generic{}");
        answers2.add("public <T> class Generic{}");
        answers2.add("public class Generic<T>{}");
        answers2.add("public class Generic<T>{}");
        questionList.add("Where does <T> go to make a class generic?");
        questionKey.put("Where does <T> go to make a class generic?",answers2);
        answers3.add("If (x = 0) System.out.print(\"Zero\");");
        answers3.add("If {x = 0} System.out.print(\"Zero\");");
        answers3.add("If (x == 0) System.out.print(\"Zero\");");
        answers3.add("If x = 0 : System.out.print(\"Zero\");");
        answers3.add("If (x == 0) System.out.print(\"Zero\");");
        questionList.add("What is the proper format of an if statment?");
        questionKey.put("What is the proper format of an if statment?", answers3);
        answers4.add("end;");
        answers4.add("discontinue;");
        answers4.add("continue;\")");
        answers4.add("break;");
        answers4.add("break;");
        questionList.add("What do you put in a while statement that is always true to get out of it.");
        questionKey.put("What do you put in a while statement that is always true to get out of it.", answers4);


    }
}


/**
 System.out.println("Question number: " + questionNumber);
 System.out.println("What do you put in a while statement that is always true to get out of it.");
 System.out.println("a. end;");
 System.out.println("b. discontinue;");
 System.out.println("c. continue;");
 System.out.println("d. break;");
 noReRun[questionNumber - 1] = 4;
 questionNumber++;
 //d is the answer
 return "d";
 case 5:
 System.out.println("A data structure is a specialized format designed to ____ and ____ data providing");
 System.out.println("a means of managing large amount of data efficiently.");
 System.out.println("a. Store and organize");
 System.out.println("b. construct and initialise");
 System.out.println("c. use and Quantify");
 System.out.println("d. view and save");
 noReRun[questionNumber - 1] = 5;
 questionNumber++;
 //a. is the answer
 return "a";
 case 6:
 System.out.println("Usage of efficient data structure is not key to designing efficient algorithms.");
 System.out.println("a. True");
 System.out.println("b. false");
 System.out.println("c. not enough information");
 System.out.println("d. Truthy");
 noReRun[questionNumber - 1] = 6;
 questionNumber++;
 //b. is the answer
 return "b";
 case 7:
 System.out.println("A ___ is a code block which is referred to by name and can be invoked");
 System.out.println("at any point in a program simply by calling or utilizing the ___ name.");
 System.out.println("a. Import");
 System.out.println("b. String");
 System.out.println("c. Method");
 System.out.println("d. Byte");
 noReRun[questionNumber - 1] = 7;
 questionNumber++;
 //c. is the answer
 return "c";
 case 8:
 System.out.println("public string static void main (String[] args {");
 System.out.println("From left to right what word or words represents a method.");
 System.out.println("a. public string");
 System.out.println("b. static");
 System.out.println("c. void");
 System.out.println("d. main");
 noReRun[questionNumber - 1] = 8;
 questionNumber++;
 //d. is th answer
 return "d";
 }
 return "";
 }
 void startQuiz(){
 Scanner userInput = new Scanner(System.in);
 int correct = 0;
 int wrong = 0;
 System.out.println("Welcome to the Java Quiz!");
 System.out.println();
 for (int i = 0; i < 8; i++) {
 String correctAnswer = questionKey();
 String answer = userInput.nextLine();
 if (correctAnswer.equals(answer.toLowerCase())) {
 System.out.println("Correct");
 correct++;
 System.out.println("");
 } else {
 System.out.println("Sorry incorrect. The correct answer is " + correctAnswer);
 wrong++;
 System.out.println("");
 }
 }
 System.out.println("You got " + correct + " answers correct");
 System.out.println("and " + wrong + " answers wrong.");
 }
 }**/
