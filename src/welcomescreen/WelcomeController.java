package welcomescreen;

import Main.MainController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WelcomeController implements Initializable {

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public static void show(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(WelcomeController.class.getResource("welcome.fxml"));
            Parent root = fxmlLoader.load();

            //get controller which is connected to this fxml file
            WelcomeController ctrl = fxmlLoader.getController();
            ctrl.setStage(stage);

            stage.setTitle("Welcome");
            stage.setScene(new Scene(root, 400, 400));
            stage.show();
        }
        catch (IOException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Something wrong with welcome.fxml!");
            ex.printStackTrace(System.err);
            System.exit(1);
        }
    }


    @FXML
    private void next() {
        //navigate from welcome screen to main screen
        System.out.println("Navigation started ...");

        MainController.show(new Stage(), "Hello from Welcome Controller!");

        stage.close();
    }
}