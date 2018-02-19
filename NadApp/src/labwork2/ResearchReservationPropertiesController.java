package labwork2;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import labwork1.LabWorkController;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.util.ResourceBundle;

public class ResearchReservationPropertiesController extends LabWorkController implements Initializable, InitialDataResProp {

    @FXML
    private TableView<String[]> jfxTableView;

    @FXML
    private JFXButton jfxButton;

    @FXML
    private JFXTextField jfxTextField;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {

        jfxButton.setOnAction(event -> {
            if (jfxTextField.getText() != null && !jfxTextField.getText().isEmpty()) {
                int time = Integer.parseInt(jfxTextField.getText());

                switch (time) {
                    case t1: completeTable(t1);
                        break;
                    case t2: completeTable(t2);
                        break;
                    case t3: completeTable(t3);
                        break;
                    case t4: completeTable(t4);
                        break;
                    case t5: completeTable(t5);
                        break;
                    case t6: completeTable(t6);
                        break;
                    case t7: completeTable(t7);
                        break;
                    case t8: completeTable(t8);
                        break;
                    case t9: completeTable(t9);
                        break;
                    case t10: completeTable(t10);
                        break;
                    case t11: completeTable(t11);
                        break;
                    case t12: completeTable(t12);
                        break;
                    case t13: completeTable(t13);
                        break;
                    case t14: completeTable(t14);
                        break;
                    case t15: completeTable(t15);
                        break;
                    case t16: completeTable(t16);
                        break;
                    case t17: completeTable(t17);
                        break;
                    case t18: completeTable(t18);
                        break;
                    case t19: completeTable(t19);
                        break;
                    case t20: completeTable(t20);
                        break;
                    case t21: completeTable(t21);
                        break;
                    case t22: completeTable(t22);
                        break;
                    default: Notifications.create()
                            .darkStyle()
                            .title("Ошибка")
                            .text("Введите корректное время")
                            .showWarning();
                }
            }
        });

        String[] columnsName = {"Номер опыта", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};

        for (int i = 0; i < columnsName.length; i++) {
            TableColumn<String[], String> headersTableView = new TableColumn<>(columnsName[i]);
            headersTableView.setSortable(false);
            headersTableView.setReorderable(false);

            final int colIndex = i;

            headersTableView.setCellValueFactory(p -> new SimpleStringProperty(p.getValue()[colIndex]));

            jfxTableView.getColumns().add(headersTableView);
        }

        getEmptyTable();

    }

    private void getEmptyTable() {

        String[] strings1 = {"1", "    ", "    ", "    ", "    ", "    ", "    ", "    ", "    ", "    ", "    ", "    ", "    "};
        String[] strings2 = {"2", "", "", "", "", "", "", "", "", "", "", "", ""};
        String[] strings3 = {"3", "", "", "", "", "", "", "", "", "", "", "", ""};
        String[] strings4 = {"4", "", "", "", "", "", "", "", "", "", "", "", ""};
        String[] strings5 = {"5", "", "", "", "", "", "", "", "", "", "", "", ""};
        String[] strings6 = {"6", "", "", "", "", "", "", "", "", "", "", "", ""};
        String[] strings7 = {"7", "", "", "", "", "", "", "", "", "", "", "", ""};
        String[] strings8 = {"8", "", "", "", "", "", "", "", "", "", "", "", ""};
        String[] strings9 = {"9", "", "", "", "", "", "", "", "", "", "", "", ""};
        String[] strings10 = {"10", "", "", "", "", "", "", "", "", "", "", "", ""};
        String[] strings11 = {"Число отказов в 10 опытах", "", "", "", "", "", "", "", "", "", "", "", ""};

        String[][] strings = {strings1, strings2, strings3, strings4, strings5, strings6, strings7, strings8, strings9, strings10, strings11};

        ObservableList<String[]> observableList = FXCollections.observableArrayList();
        observableList.addAll(strings);

        jfxTableView.setItems(observableList);

    }

    private void completeTable(int T) {
        jfxTableView.setItems(getData(T));
    }

}
