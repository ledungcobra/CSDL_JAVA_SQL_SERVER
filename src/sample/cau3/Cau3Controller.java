package sample.cau3;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.JDBCConnector;
import sample.Student;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;



public class Cau3Controller implements Initializable {

    @FXML
    private TableView<SalaryContainer> table;

    @FXML
    private TableColumn<SalaryContainer, Integer> id;

    @FXML
    private TableColumn<SalaryContainer, Float> salary;
    @FXML
    private TableColumn<SalaryContainer, Integer> year;
    ObservableList<SalaryContainer> studentList;


    public void Action(ActionEvent a) {
        Platform.exit();
        System.exit(0);
    }

    public void onQuery(ActionEvent event) {
        JDBCConnector jdbcConnector = new JDBCConnector("jdbc:sqlserver://localhost:1433;"
                + "databaseName=EmployeeMng2012;", "sa", "");

        try {
            var result = jdbcConnector.query("SELECT * FROM dbo.CALC_SALARY_FOR_EVERY_EMPLOYEE()");
            while (result.next()) {
                studentList.add(parseItem(result));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public SalaryContainer parseItem(ResultSet r) throws SQLException {
        return new SalaryContainer(r.getInt(1),r.getInt(2),r.getFloat(3));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        id.setCellValueFactory(new PropertyValueFactory<SalaryContainer, Integer>("id"));
        year.setCellValueFactory(new PropertyValueFactory<SalaryContainer, Integer>("year"));
        salary.setCellValueFactory(new PropertyValueFactory<SalaryContainer, Float>("salary"));
        studentList = FXCollections.observableArrayList();
        table.setItems(studentList);


    }

    public void nextScreeen(ActionEvent e) {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("cau1/cau1.fxml"));

        try {
            Parent studentViewParent = loader.load();
            Scene scene = new Scene(studentViewParent);
            stage.setScene(scene);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}

