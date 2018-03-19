package labwork3;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.ToggleGroup;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.util.ResourceBundle;

public class DeterminingSystemReliabilityController extends Laws implements Initializable, Data {

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

    private Tab tab1 = new Tab("1-я группа");
    private Tab tab2 = new Tab("2-я группа");
    private Tab tab3 = new Tab("3-я группа");
    private Tab tab4 = new Tab("4-я группа");

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

        for (int i = 0; i < 15; i++) {
            double a = Exponential(0.1);
            double aa = Exponential(0.1);

            double repairA = Exponential(0.1);
            double repairAA = Exponential(0.1);

            double max = Math.max(a, aa);
            double min = Math.min(a, aa);

//            do {
//
//
//
//            } while ( max > (min + repairA) | max > (min + repairAA) );
//
//            if (a < aa) {
//                double firstElement = a + repairA;
//                if (firstElement < aa) {
//                    double fElement = firstElement + a;
//                }
//                else {
//                    System.out.println("Система неисправна");
//                }
//            }
//            else {
//                double secondElement = aa + repairAA;
//            }


            double b = Rayleigh(20);
            double bb = Rayleigh(20);
            double bbb = Rayleigh(20);

            double c = Normal(50, 10);
            double cc = Normal(50, 10);

            double swtch = Normal(100, 10);

            System.out.println(a);
            System.out.println(aa);
            System.out.println("\n");

        }






    }

    private void getThirdPane() {
        ObservableList<String> laws = FXCollections.observableArrayList("Exponential", "Rayleigh", "Normal");
        String s2 = "Rayleigh";
        String s3 = "Normal";

        ToggleGroup toggleGroup = new ToggleGroup();
        JFXRadioButton exp = new JFXRadioButton("exp");
        exp.setToggleGroup(toggleGroup);

        JFXRadioButton rel = new JFXRadioButton("rel");
        rel.setToggleGroup(toggleGroup);

        JFXRadioButton norm = new JFXRadioButton("norm");
        norm.setToggleGroup(toggleGroup);

        JFXComboBox jfxComboBox = new JFXComboBox<>(laws);

        tab1.setContent(exp);

        if (tabPane.getTabs().size() < 2) {
            tabPane.getTabs().addAll(tab1, tab2, tab3);
        }
        else if (tabPane.getTabs().size() == 4) {
            tabPane.getTabs().clear();
            tabPane.getTabs().addAll(tab1, tab2, tab3);
        }
    }

    private void getFourthPane() {
        if (tabPane.getTabs().size() < 2) {
            tabPane.getTabs().addAll(tab1, tab2, tab3, tab4);
        }
        else if (tabPane.getTabs().size() == 3) {
            tabPane.getTabs().clear();
            tabPane.getTabs().addAll(tab1, tab2, tab3, tab4);
        }
    }

}
