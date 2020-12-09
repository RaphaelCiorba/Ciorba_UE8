package Model;
//Hinweis: Hier hat mir Falkenberg geholfen, weil ich alleine nicht zurecht kam

import Main.MainController;
import javafx.stage.Stage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Model {

    public Model(){}
    public boolean isCorrectLogin(String name, String password){
        try {
            Scanner sc = new Scanner(new File("./login_files/login_data.txt"));
            ArrayList<String> login_data = new ArrayList<String>();
            while (sc.hasNextLine()) {
                login_data.add(sc.nextLine());
            }
            login_data.removeAll(Arrays.asList("", null));

            for (int i = 0; i < login_data.size() - 1; i++) {
                if (name.equals(login_data.get(i)) && i % 2 == 0 && password.equals(login_data.get(i + 1))) {
                    return true;
                }
            }
        }
        catch (Exception e){
            System.err.println("Something is wrong: " + e.getMessage());
            e.printStackTrace(System.err);
        }
        return false;
    }

    public ArrayList readFile(String pathname){
        try {
            Scanner sc = new Scanner(new File(pathname));
            ArrayList<String> file_data = new ArrayList<String>();
            while (sc.hasNextLine()) {
                file_data.add(sc.nextLine());
            }
            return file_data;
        }
        catch (Exception e){
            System.err.println("Something is wrong with path: " + e.getMessage());
            e.printStackTrace(System.err);
        }
        return null;
    }

    public String getRandomAnswer(String question) {

        try {
            ArrayList standard_answers = readFile("./answers/answers.txt");
            standard_answers.removeAll(Arrays.asList("", null));
            int bonus = 0;

            Random r = new Random();
            int rNum = r.nextInt(standard_answers.size());

            int index = rNum + bonus;
            if (index >= standard_answers.size())
                index = standard_answers.size() - 1;

            return standard_answers.get(index).toString();
        }
        catch (Exception e) {
            System.err.println("Something is wrong: " + e.getMessage());
            e.printStackTrace(System.err);
        }
        return null;
    }
}

