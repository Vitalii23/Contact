package application.dao;

import application.model.Information;
import javafx.collections.ObservableList;

public interface InformationDAO {

    void addEntity(String organization, String post, String lastName, String firstName,
                          String middleName, String town, String date, String contact, String description,
                          String postIndex);

    void addIndividual(String lastName, String firstName, String middleName, String town,
                       String date, String contact, String description, String postIndex);

    void showDetails(Information in);

    void edit(Information information);

    void delete(String id);

    void selectData(ObservableList<Information> list);
}
