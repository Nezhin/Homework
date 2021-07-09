package root.fx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AuthorizationWindowController {

    @FXML
    TextField usernameTextField;
    @FXML
    PasswordField passwordField;

    @FXML
    private void authorize() throws IOException {
        // TODO AUTHORIZE
        Stage stage = (Stage) passwordField.getScene().getWindow();
        stage.close();
        showMainWindow();
    }

    private void showMainWindow() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fxml/mainWindow.fxml")));
        stage.setTitle("Main");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void showRegistrationForm() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fxml/registrationWindow.fxml")));
        stage.setTitle("Registration");
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }

}
