package labwork3;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import org.controlsfx.control.Notifications;
import org.w3c.dom.events.Event;

import java.beans.EventHandler;
import java.net.URL;
import java.util.ResourceBundle;

public class DeterminingSystemReliabilityController implements Initializable, Data {

    @FXML
    private JFXTextField numTest;

    @FXML
    private JFXTextField numIntervals;

    @FXML
    private JFXTextField numGroups;

    @FXML
    private JFXButton button;

    @FXML
    private JFXTabPane tabPane;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {

        Boolean conditionNumTest = numTest.getText() != null && !numTest.getText().isEmpty();
        Boolean conditionNumIntervals = numIntervals.getText() != null && !numIntervals.getText().isEmpty();
        Boolean conditionNumGroups = numGroups.getText() != null && !numGroups.getText().isEmpty();

        button.setOnAction(event -> {
            if (numGroups.getText() != null && !numGroups.getText().isEmpty()) {
                int groups = Integer.parseInt(numGroups.getText());

                    switch (groups) {
                        case thirdGroup: getThirdPane();
                            break;
                        case fourthGroup: getFourthPane();
                            break;
                        default: Notifications.create()
                                .darkStyle()
                                .title("Ошибка")
                                .text("Введите корректное количество групп")
                                .showWarning();
                    }

            }
        });

    }

    private void getThirdPane() {
        Tab tab1 = new Tab("1-я группа");
        Tab tab2 = new Tab("2-я группа");
        Tab tab3 = new Tab("3-я группа");

        tab1.setContent(new Button("fdgdrg"));

        if (tabPane.getTabs().size() < 2) {
            tabPane.getTabs().addAll(tab1, tab2, tab3);
        }
        else if (tabPane.getTabs().size() == 4) {
            tabPane.getTabs().clear();
//            tabPane.getTabs().remove(0, 4);
            tabPane.getTabs().addAll(tab1, tab2, tab3);
        }

    }

    private void getFourthPane() {
        if (tabPane.getTabs().size() < 2) {
            tabPane.getTabs().addAll(new Tab("1-я группа"), new Tab("2-я группа"), new Tab("3-я группа"), new Tab("4-я группа"));
        }
        else if (tabPane.getTabs().size() == 3) {
            tabPane.getTabs().remove(0, 3);
            tabPane.getTabs().addAll(new Tab("1-я группа"), new Tab("2-я группа"), new Tab("3-я группа"), new Tab("4-я группа"));
        }

    }

}
