package application.model;

import javafx.beans.property.*;

import java.sql.Date;

public class Information {

    private SimpleObjectProperty<Date> date;
    private StringProperty post, lastName, firstName, middleName, town, contact,
            description, organization, postIndex;
    private IntegerProperty id, idFC, idType;
    private StringProperty typeFace;

    public Information() {
        this.post = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty();
        this.firstName = new SimpleStringProperty();
        this.middleName = new SimpleStringProperty();
        this.town = new SimpleStringProperty();
        this.contact = new SimpleStringProperty();
        this.description = new SimpleStringProperty();
        this.date = new SimpleObjectProperty<>();
        this.organization = new SimpleStringProperty();
        this.postIndex = new SimpleStringProperty();
        this.id = new SimpleIntegerProperty();
        this.idFC = new SimpleIntegerProperty();
        this.idType = new SimpleIntegerProperty();
        this.typeFace = new SimpleStringProperty();
    }

    public Date getDate() {
        return date.get();
    }

    public SimpleObjectProperty<Date> dateProperty() {
        return date;
    }

    public void setDate(Date date) {
        this.date.set(date);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getMiddleName() {
        return middleName.get();
    }

    public StringProperty middleNameProperty() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName.set(middleName);
    }

    public String getTown() {
        return town.get();
    }

    public StringProperty townProperty() {
        return town;
    }

    public void setTown(String town) {
        this.town.set(town);
    }

    public String getContact() {
        return contact.get();
    }

    public StringProperty contactProperty() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact.set(contact);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getIdFC() {
        return idFC.get();
    }

    public IntegerProperty idFCProperty() {
        return idFC;
    }

    public void setIdFC(int idFC) {
        this.idFC.set(idFC);
    }

    public int getIdType() {
        return idType.get();
    }

    public IntegerProperty idTypeProperty() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType.set(idType);
    }

    public String getPostIndex() {
        return postIndex.get();
    }

    public StringProperty postIndexProperty() {
        return postIndex;
    }

    public void setPostIndex(String postIndex) {
        this.postIndex.set(postIndex);
    }

    public String getPost() {
        return post.get();
    }

    public StringProperty postProperty() {
        return post;
    }

    public void setPost(String post) {
        this.post.set(post);
    }

    public String getOrganization() {
        return organization.get();
    }

    public StringProperty organizationProperty() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization.set(organization);
    }

    public String getTypeFace() {
        return typeFace.get();
    }

    public StringProperty typeFaceProperty() {
        return typeFace;
    }

    public void setTypeFace(String typeFace) {
        this.typeFace.set(typeFace);
    }
}
