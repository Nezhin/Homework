package root.fx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import root.Client;
import root.data.DataPackage;

import java.io.IOException;

public class MainWindowController {

    private Client client;

    @FXML
    TextField pathField;

    @FXML
    Button addFileButton;

    @FXML
    public void initialize()  {
        client = new Client();
    }

    @FXML
    private void back(){
        // TODO
    }

    @FXML
    private void showFolderCreateForm(){
        // TODO
    }

    @FXML
    private void addFile(){
        // TODO
        System.out.println("test");
        client.sendPackage(new DataPackage("FILE"));
    }



}
