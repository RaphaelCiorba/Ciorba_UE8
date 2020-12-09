package Main;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import welcomescreen.WelcomeController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController implements Initializable {

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
            FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("sample/main.fxml"));
            Parent root = fxmlLoader.load();

            //send data to main.MainController
            MainController ctrl = fxmlLoader.getController();
            ctrl.setMyData(greeting);

            Stage mainStage = new Stage();
            mainStage.setTitle("Main");
            mainStage.setScene(new Scene(root, 500, 500));
            mainStage.show();
        }
        catch (IOException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Something wrong with cmain.fxml!");
            ex.printStackTrace(System.err);
            System.exit(1);
        }
    }
}
