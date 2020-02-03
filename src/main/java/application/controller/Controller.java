package application.controller;

import application.dao.InformationDAO;
import application.dao.InformationDAOImpl;
import application.dbconnection.DbConnection;
import application.model.Information;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Controller {

    private InformationDAO dao = new InformationDAOImpl();
    private ObservableList<Information> listData;
    private DbConnection dbConnection;
    private static ResultSet resultSet;
    private static PreparedStatement preparedStatement;

    // Main menu
    @FXML
    private MenuItem exitMenuItem;

    @FXML
    private TableView<Information> tableView;

    @FXML
    private TableColumn<Information, String> idTableColumn;

    @FXML
    private TableColumn<Information, String> familyTableColumn;

    @FXML
    private TableColumn<Information, String> nameTableColumn;

    @FXML
    private TableColumn<Information, String> middleTableColumn;

    @FXML
    private TableColumn<Information, String> postTableColumn;

    @FXML
    private TableColumn<Information, String> organizationTableColumn;

    @FXML
    private TableColumn<Information, String> townTableColumn;

    @FXML
    private TableColumn<Information, String> contactTableColumn;

    @FXML
    private TableColumn<Information, String> descriptionTableColumn;

    @FXML
    private TableColumn<Information, String> dateTableColumn;

    @FXML
    private TableColumn<Information, String> postIndexTableColumn;

    @FXML
    private Button addIndButton;

    @FXML
    private Button addEntButton;

    @FXML
    private Button editButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button resetButton;

    @FXML
    private ToggleButton fullAllToggleButton;

    @FXML
    private TextField idDeleteText;

    @FXML
    private Label townLabel;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private TextArea contactTextArea;

    @FXML
    private Label dataBirthdayLabel;

    @FXML
    private Label postIndexLabel;

    // Entity Window
    @FXML
    private AnchorPane entityAnchorPane;

    @FXML
    private TextField entityOrganizationText;

    @FXML
    private TextField entityPostText;

    @FXML
    private TextField entityLastNameText;

    @FXML
    private TextField entityFirstNameText;

    @FXML
    private TextField entityMiddleNameText;

    @FXML
    private TextField entityTownText;

    @FXML
    private Button entityCancelButton;

    @FXML
    private DatePicker entityDateBirthday;

    @FXML
    private TextArea entityContact;

    @FXML
    private TextArea entityDescription;

    @FXML
    private TextField entityPostIndex;


    // Individual Window
    @FXML
    private AnchorPane indAnchorPane;

    @FXML
    private TextField indLastNameText;

    @FXML
    private TextField indFirstNameText;

    @FXML
    private TextField indMiddleNameText;

    @FXML
    private Button indAcceptButton;

    @FXML
    private Button indCancelButton;

    @FXML
    private TextField indTownText;

    @FXML
    private DatePicker indDateBirthday;

    @FXML
    private TextArea indContact;

    @FXML
    private TextArea indDescription;

    @FXML
    private TextField indPostIndex;

    @FXML
    private void initialize() {
       dbConnection = new DbConnection();

    }

    // main menu action
    @FXML
    void addEntAction(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/gui/GUI_EntityWindow.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 470, 620);
            Stage stage = new Stage();
            stage.setTitle("Добавить данные");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

    @FXML
    void addIndAction(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/gui/GUI_IndividualWindow.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 470, 560);
            Stage stage = new Stage();
            stage.setTitle("Добавить данные");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

    @FXML
    void deleteAction(ActionEvent event) {
        dao.delete(idDeleteText.getText());
    }

    @FXML
    void editAction(ActionEvent event) {

    }

    @FXML
    void fullAllAction(ActionEvent event) {
        showPersonDetails(null);
        tableView.getSelectionModel().selectedItemProperty().addListener(
                ((observableValue, information, t1) -> showPersonDetails(t1)));
    }

    @FXML
    void exitAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public void resetButtonAction(ActionEvent actionEvent) {
        listData = FXCollections.observableArrayList();
        dao.selectData(listData);
        idTableColumn.setCellValueFactory((TableColumn.CellDataFeatures<Information, String> cellData) ->
                cellData.getValue().idProperty().asString());
        familyTableColumn.setCellValueFactory((TableColumn.CellDataFeatures<Information, String> cellData) ->
                cellData.getValue().lastNameProperty());
        nameTableColumn.setCellValueFactory((TableColumn.CellDataFeatures<Information, String> cellData) ->
                cellData.getValue().firstNameProperty());
        middleTableColumn.setCellValueFactory((TableColumn.CellDataFeatures<Information, String> cellData) ->
                cellData.getValue().middleNameProperty());
        organizationTableColumn.setCellValueFactory((TableColumn.CellDataFeatures<Information, String> cellData) ->
                cellData.getValue().organizationProperty());
        postTableColumn.setCellValueFactory((TableColumn.CellDataFeatures<Information, String> cellData) ->
                cellData.getValue().postProperty());
        townTableColumn.setCellValueFactory((TableColumn.CellDataFeatures<Information, String> cellData) ->
                cellData.getValue().townProperty());
        contactTableColumn.setCellValueFactory((TableColumn.CellDataFeatures<Information, String> cellData) ->
                cellData.getValue().contactProperty());
        descriptionTableColumn.setCellValueFactory((TableColumn.CellDataFeatures<Information, String> cellData) ->
                cellData.getValue().descriptionProperty());
        dateTableColumn.setCellValueFactory((TableColumn.CellDataFeatures<Information, String> cellData) ->
                cellData.getValue().dateProperty().asString());
        postIndexTableColumn.setCellValueFactory((TableColumn.CellDataFeatures<Information, String> cellData) ->
                cellData.getValue().postIndexProperty());
        tableView.setItems(listData);
    }

    // Entity action
    @FXML
    public void entityAcceptButtonAction(ActionEvent event) {
        dao.addEntity(
                entityOrganizationText.getText(),
                entityPostText.getText(),
                entityLastNameText.getText(),
                entityFirstNameText.getText(),
                entityMiddleNameText.getText(),
                entityTownText.getText(),
                entityDateBirthday.getEditor().getText(),
                entityContact.getText(),
                entityDescription.getText(),
                entityPostIndex.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Подтверждение");
        alert.setHeaderText(null);
        alert.setContentText("Объект занесен в базу данных");
        alert.showAndWait();
    }

    @FXML
    public void entityCancelButtonAction(ActionEvent event) {
        Stage stage = (Stage) entityCancelButton.getScene().getWindow();
        stage.close();
    }

    // Individual action
    // Action Button
    @FXML
    public void indAcceptButtonAction(ActionEvent event) {
        dao.addIndividual(
                entityLastNameText.getText(),
                entityFirstNameText.getText(),
                entityMiddleNameText.getText(),
                entityTownText.getText(),
                entityDateBirthday.getEditor().getText(),
                entityContact.getText(),
                entityDescription.getText(),
                entityPostIndex.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Подтверждение");
        alert.setHeaderText(null);
        alert.setContentText("Объект занесен в базу данных");
        alert.showAndWait();
    }

    @FXML
    public void indCancelButtonAction(ActionEvent event) {
        Stage stage = (Stage) indCancelButton.getScene().getWindow();
        stage.close();
    }

    public void showPersonDetails(Information in) {
        if (in != null) {
            townLabel.setText(in.getTown());
            contactTextArea.setEditable(false);
            contactTextArea.setText(in.getContact());
            descriptionTextArea.setEditable(false);
            descriptionTextArea.setText(in.getDescription());
            dataBirthdayLabel.setText(String.valueOf(in.getDate()));
            postIndexLabel.setText(String.valueOf(in.getPostIndex()));
        } else {
            townLabel.setText("");
            contactTextArea.setEditable(false);
            contactTextArea.setText("");
            descriptionTextArea.setEditable(false);
            descriptionTextArea.setText("");
            dataBirthdayLabel.setText("");
            postIndexLabel.setText("");

        }
    }
}
