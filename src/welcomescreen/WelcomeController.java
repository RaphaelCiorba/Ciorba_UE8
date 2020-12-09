package welcomescreen;

import Main.MainController;
import Model.Model;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WelcomeController implements Initializable {

    private Stage stage;
    @FXML
    private TextField username;
    @FXML
    private TextField password;

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

            stage.setTitle("LoginScreen");
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
    public void login() {
        Model model = new Model();

        String usrName = username.getText();
        String pwd = password.getText();

        boolean loginProvided = model.isCorrectLogin(usrName, pwd);

        if(loginProvided == true) {
            System.out.println("Login successful ...");

            MainController.show(new Stage(),"Welcome");
            stage.close();
        }
        else
            System.out.println("Login was unsuccessful");
    }
}