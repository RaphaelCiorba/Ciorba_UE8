package Main;
/*******************
Autor: Raphael Ciorba
Übung: 8
 *******************/
import javafx.application.Application;
import javafx.stage.Stage;
import welcomescreen.WelcomeController;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        WelcomeController.show(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
