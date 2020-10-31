package sample.cau1;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Cau1Controller {

    public void goBack(ActionEvent e){
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../sample.fxml"));

        try {
            Parent sample = loader.load();
            Scene scene = new Scene(sample);
            stage.setScene(scene);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
