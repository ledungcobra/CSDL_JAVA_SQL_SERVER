package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements  Initializable{

    public void Action(ActionEvent a){
        Platform.exit();
        System.exit(0);
    }

    @FXML
    private TableView<Student> table;

    @FXML
    private TableColumn<Student,Integer> idColumn;

    @FXML
    private TableColumn<Student,String> name;


    @FXML
    private TableColumn<Student,String> email;
    @FXML
    private TableColumn<Student,String> age;

    ObservableList<Student> studentList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentList = FXCollections.observableArrayList(new Student(1,"Dung","Dungle@gmail.com","10"),new Student(1,"Dung","Dungle@gmail.com","10"));

        idColumn.setCellValueFactory(new PropertyValueFactory<Student,Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        email.setCellValueFactory(new PropertyValueFactory<Student,String>("email"));
        age.setCellValueFactory(new PropertyValueFactory<Student,String>("age"));
        table.setItems(studentList);



    }

//    public void nextScreeen(ActionEvent e){
//        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("cau1/cau1.fxml"));
//
//        try {
//            Parent studentViewParent = loader.load();
//            Scene scene = new Scene(studentViewParent);
//            stage.setScene(scene);
//
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        }
//
//    }
}