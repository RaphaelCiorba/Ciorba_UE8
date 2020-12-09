package Main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import welcomescreen.WelcomeController;
import Model.Model;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController implements Initializable {

    @FXML
    private TextField question_field;
    @FXML
    private Label question_label;


    private String myData = "";

    public void setMyData(String myData) {
        this.myData = myData;
        System.out.println("(main.MainController) Data received: " + this.myData);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public static void show(Stage stage, String greeting) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("main.fxml"));
            Parent root = fxmlLoader.load();

            //send data to main.MainController
            MainController ctrl = fxmlLoader.getController();
            ctrl.setMyData(greeting);

            Stage mainStage = new Stage();
            mainStage.setTitle("Magic 8 Ball");
            mainStage.setScene(new Scene(root, 500, 500));
            mainStage.show();
        } catch (IOException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Something wrong with main.fxml!");
            ex.printStackTrace(System.err);
            System.exit(1);
        }

    }
        @FXML
        private void ask () {
            String question = question_field.getText();

            if (question.contains("?")) {

                Model model = new Model();

                String answer = model.getRandomAnswer(question);

                question_label.setText(answer);
            }
            else {
                question_field.setText("");
                question_field.setPromptText("question must have a ?");
            }
        }

}

