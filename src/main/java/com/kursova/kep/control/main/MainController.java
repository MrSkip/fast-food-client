package com.kursova.kep.control.main;

import com.kursova.kep.custom.CustomProperties;
import com.kursova.kep.custom.table.TableColumnsGenerator;
import com.kursova.kep.entity.*;
import com.kursova.kep.rest.Client;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.lang.reflect.Array;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Mr. Skip.
 */

public class MainController implements Initializable{
    public TableView<Object> table;
    private static Class currentClassObject;
    private static BaseEntity addedEntity;

    public Button
            butMenu,
            butInstitution,
            buttonDelete,
            buttonAdd;

    public TextArea textArea;

    public Label labCurrentTable;
    public List<String> labelStrings;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        currentClassObject = Menu.class;

        List<Menu> list = Client.get("menu", Menu[].class).build();
        TableColumnsGenerator.setTableView(table).generateColumns(list, Menu.class);
        Client.setTextArea(textArea);

        buttonsHandler();
        taskLabelsHandler();
    }

    private void taskLabelsHandler(){
        labelStrings = new ArrayList<>();
        
    }

    private void buttonsHandler() {
        buttonDelete.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
            if (event.getButton() == MouseButton.PRIMARY
                    && table.getSelectionModel().getSelectedItem() != null){
                BaseEntity entity = (BaseEntity) table.getSelectionModel().getSelectedItem();
                Client.delete(currentClassObject.getSimpleName().toLowerCase() + "/" + entity.getId(), currentClassObject);
                table.getItems().remove(table.getSelectionModel().getSelectedItem());
            }
        });

        buttonAdd.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
            if (event.getButton() == MouseButton.PRIMARY){
                try {
                    if (buttonAdd.getText().equals("Зберегти зміни")) {
                        Client.post(currentClassObject.getSimpleName().toLowerCase(), currentClassObject)
                                .setRequest(table.getItems().get(table.getItems().size() - 1))
                                .build();
                        addedEntity = null;

                        buttonAdd.setText("Додати");
                        buttonAdd.setPrefWidth(120);
                    }
                    else if (buttonAdd.getText().equals("Додати")) {
                        buttonAdd.setText("Зберегти зміни");
                        buttonAdd.setPrefWidth(200);

                        addedEntity = (BaseEntity) Class.forName(currentClassObject.getPackage().getName() + "." + currentClassObject.getSimpleName())
                                .newInstance();
                        addedEntity.setId((long)table.getItems().size() + 1);
                        table.getItems().add(addedEntity);
                        table.getSelectionModel().select((long) table.getItems().size() - 1);
                    }
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                    e.printStackTrace();
                }
            }
        });

        butInstitution.addEventFilter(MouseEvent.MOUSE_CLICKED, this::buttonObjectHandler);
        butMenu.addEventFilter(MouseEvent.MOUSE_CLICKED, this::buttonObjectHandler);
    }

    private void buttonObjectHandler(MouseEvent e){
        if (e.getButton() == MouseButton.PRIMARY){
            addedEntity = null;
            buttonAdd.setText("Додати");
            String objectName = ((Button) e.getSource()).getText();

            currentClassObject = CustomProperties.getClassFromHeaderButtons(objectName);

            if (!table.getColumns().isEmpty()) {
                table.getColumns().clear();
                if (!table.getItems().isEmpty())
                    table.getItems().clear();
            }
            labCurrentTable.setText(objectName);
            List list = null;
            try {
                list = Client.get(currentClassObject.getSimpleName().toLowerCase(),
                        Class.forName("[L" + currentClassObject.getPackage().getName() + "." + currentClassObject.getSimpleName() + ";")).build();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
            TableColumnsGenerator.setTableView(table).generateColumns(list, currentClassObject);
        }
    }

}
