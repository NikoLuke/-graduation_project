package labwork3;

import com.jfoenix.controls.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

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

    @FXML
    private Button buttonModel;

    @FXML
    private JFXTabPane mainTabPane;

    private Tab tab1 = new Tab("1-я группа");
    private Tab tab2 = new Tab("2-я группа");
    private Tab tab3 = new Tab("3-я группа");

    private Tab tab01 = new Tab("1-я группа");
    private Tab tab02 = new Tab("2-я группа");
    private Tab tab03 = new Tab("3-я группа");
    private Tab tab04 = new Tab("4-я группа");

    private BorderPane mainBorderPane = new BorderPane();

    private TableView<String[]> tableView = new TableView();

    private ObservableList<String> laws = FXCollections.observableArrayList("Exponential", "Rayleigh", "Normal");
    private ObservableList<String> reserve = FXCollections.observableArrayList("Без резерва", "Ненагруженное резервирование без восстановления", "Ненагруженное резервирование с восстановлением", "Нагруженное резервирование без восстановления", "Нагруженное резервирование с восстановлением");

    private JFXComboBox jfxComboBox = new JFXComboBox<>(laws);

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

        tableView.setItems(observableList);
    }


    private void NenagrReservBezVost(int count, double laws) {
        for (int i = 0; i < count; i++) {
            String.valueOf(laws);
        }
    }



    @FXML
    public void initialize(URL location, ResourceBundle resources) {

        Boolean conditionNumTest = numTest.getText() != null && !numTest.getText().isEmpty();
        Boolean conditionNumIntervals = numIntervals.getText() != null && !numIntervals.getText().isEmpty();
        Boolean conditionNumGroups = numGroups.getText() != null && !numGroups.getText().isEmpty();

        buttonModel.setOnAction(event -> {
            tableView.getColumns().clear();
            Tab tab = new Tab("Смоделированные данные");
            mainTabPane.getTabs().add(tab);
            mainTabPane.getSelectionModel().select(tab);
            tableView.setLayoutX(60);
            tableView.setLayoutY(60);
            tableView.setMaxSize(700, 300);
            tab.setContent(tableView);

            String[] columnsName = {"Номер опыта", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};

            for (int i = 0; i < columnsName.length; i++) {
                TableColumn<String[], String> headersTableView = new TableColumn<>(columnsName[i]);
                headersTableView.setSortable(false);
                headersTableView.setReorderable(false);

                final int colIndex = i;

                headersTableView.setCellValueFactory(p -> new SimpleStringProperty(p.getValue()[colIndex]));

                tableView.getColumns().add(headersTableView);
            }

//            mainTabPane.getTabs().remove(0);
            getEmptyTable();
        });


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

//        for (int i = 0; i < 15; i++) {
//            double a = Exponential(0.1);
//            double aa = Exponential(0.1);
//
//            double repairA = Exponential(0.1);
//            double repairAA = Exponential(0.1);
//
//            double max = Math.max(a, aa);
//            double min = Math.min(a, aa);
//
////            do {
////
////
////
////            } while ( max > (min + repairA) | max > (min + repairAA) );
////
////            if (a < aa) {
////                double firstElement = a + repairA;
////                if (firstElement < aa) {
////                    double fElement = firstElement + a;
////                }
////                else {
////                    System.out.println("Система неисправна");
////                }
////            }
////            else {
////                double secondElement = aa + repairAA;
////            }
//
//
//            double b = Rayleigh(20);
//            double bb = Rayleigh(20);
//            double bbb = Rayleigh(20);
//
//            double c = Normal(50, 10);
//            double cc = Normal(50, 10);
//
//            double swtch = Normal(100, 10);
//
//            System.out.println(a);
//            System.out.println(aa);
//            System.out.println("\n");
//
//        }

    }


    private void setViews() {
        Label labelSwitchLaw = new Label("Вид и параметры закона переключателя");
        JFXComboBox switchLaw = new JFXComboBox<>(laws);
        JFXTextField jfxTextField = new JFXTextField();
        jfxTextField.setPrefSize(80, 26);
        jfxTextField.setPadding(new Insets(0, 0, 0, 20));
        VBox vBox = new VBox();
        HBox hBox = new HBox();
        hBox.getChildren().addAll(switchLaw, jfxTextField);

        Label labelReserve = new Label("Вид резервирования в группе");
        JFXComboBox cbReserve = new JFXComboBox<>(reserve);
        labelReserve.setPadding(new Insets(50, 0, 10, 0));

        Label labelProbability = new Label("Вероятность обнаружения отказа переключателем");
        JFXTextField tfProbability = new JFXTextField();
        tfProbability.setPrefWidth(80);
        tfProbability.setPadding(new Insets(0, 0, 0, 20));
        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(labelProbability, tfProbability);
        hBox1.setPadding(new Insets(50, 0, 0, 0));

        UnaryOperator<TextFormatter.Change> filter = change -> {
            String string = change.getText();

            if (string.matches("0?[.,]?[0-9]?")) {  // \\u002E - точка
                return change;
            }

            return null;
        };

        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        tfProbability.setTextFormatter(textFormatter);

        vBox.getChildren().addAll(labelSwitchLaw, hBox, labelReserve, cbReserve, hBox1);
        vBox.setPadding(new Insets(0, 0, 0, 60));
//        vBox.setStyle("-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.4), 10, 0.5, 0.0, 0.0);" + "-fx-background-color: white;");
//        vBox.setMaxWidth(350);
//        vBox.setMaxHeight(60);
        mainBorderPane.setCenter(vBox);
    }


    private void getBackupElements(JFXComboBox<String> jfxComboBox, BorderPane borderPane) {
        jfxComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.contains("Exponential")) {
                borderPane.getChildren().remove(borderPane.getCenter());

                HBox hBox = new HBox();
                JFXTextField jfxTextField = new JFXTextField();
                jfxTextField.setMaxSize(30, 26);
                jfxTextField.setPadding(new Insets(0, 0, 0, 5));
                hBox.getChildren().addAll(jfxTextField);
                borderPane.setCenter(hBox);
            }
            else if (newValue.contains("Normal")) {
                borderPane.getChildren().remove(borderPane.getCenter());

                HBox hBox = new HBox();
                JFXTextField jfxTextField = new JFXTextField();
                JFXTextField jfxTextField1 = new JFXTextField();
                jfxTextField.setPrefSize(30, 26);
                jfxTextField1.setPrefSize(30, 26);
                jfxTextField.setPadding(new Insets(0, 0, 0, 5));
                jfxTextField1.setPadding(new Insets(0, 0, 0, 5));
                hBox.getChildren().addAll(jfxTextField, jfxTextField1);
                borderPane.setCenter(hBox);
            }
            else if (newValue.contains("Rayleigh")) {
                borderPane.getChildren().remove(borderPane.getCenter());

                HBox hBox = new HBox();
                JFXTextField jfxTextField = new JFXTextField();
                jfxTextField.setMaxSize(30, 26);
                jfxTextField.setPadding(new Insets(0, 0, 0, 5));
                hBox.getChildren().addAll(jfxTextField);
                borderPane.setCenter(hBox);
            }
        });
    }

    private void getBaseElements(JFXComboBox<String> jfxComboBox, BorderPane borderPane) {
        jfxComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.contains("Exponential")) {
                borderPane.getChildren().remove(borderPane.getRight());

                JFXTextField jfxTextField = new JFXTextField();
                jfxTextField.setPrefSize(30, 26);
                jfxTextField.setPadding(new Insets(0, 0, 0, 5));
                borderPane.setRight(jfxTextField);
            }
            else if (newValue.contains("Normal")) {
                borderPane.getChildren().remove(borderPane.getRight());

                HBox hBox = new HBox();
                JFXTextField jfxTextField = new JFXTextField();
                JFXTextField jfxTextField1 = new JFXTextField();
                jfxTextField.setPrefSize(30, 26);
                jfxTextField1.setPrefSize(30, 26);
                jfxTextField.setPadding(new Insets(0, 0, 0, 5));
                jfxTextField1.setPadding(new Insets(0, 0, 0, 5));
                hBox.getChildren().addAll(jfxTextField, jfxTextField1);
                borderPane.setRight(hBox);
            }
            else if (newValue.contains("Rayleigh")) {
                borderPane.getChildren().remove(borderPane.getRight());

                JFXTextField jfxTextField = new JFXTextField();
                jfxTextField.setPrefSize(30, 26);
                jfxTextField.setPadding(new Insets(0, 0, 0, 5));
                borderPane.setRight(jfxTextField);
            }
        });
    }



    private void getThirdPane() {

        ToggleGroup group = new ToggleGroup();

        group.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {
            if (group.getSelectedToggle() != null) {
                RadioButton button = (RadioButton) group.getSelectedToggle();
                String string = button.getText();

                switch (string) {
                    case "1 элемент":   JFXComboBox<String> jfxComboBox1 = new JFXComboBox<>(laws);
                                        JFXComboBox<String> jfxComboBox11 = new JFXComboBox<>(laws);
                                        mainBorderPane.getChildren().remove(mainBorderPane.getRight());
                                        mainBorderPane.getChildren().remove(mainBorderPane.getBottom());

                                        BorderPane borderPane1 = new BorderPane();
                                        mainBorderPane.setRight(borderPane1);
                                        borderPane1.setLeft(jfxComboBox1);

                                        BorderPane borderPane11 = new BorderPane();
                                        borderPane11.setPadding(new Insets(0, 0, 70, 0));
                                        mainBorderPane.setBottom(borderPane11);
                                        Label label1 = new Label("Резервные элементы");
                                        borderPane11.setTop(label1);
                                        borderPane11.setLeft(jfxComboBox11);

                                        getBaseElements(jfxComboBox1, borderPane1);
                                        getBackupElements(jfxComboBox11, borderPane11);
                    break;
                    case "2 элемента":  JFXComboBox<String> jfxComboBox2 = new JFXComboBox<>(laws);
                                        JFXComboBox<String> jfxComboBox22 = new JFXComboBox<>(laws);
                                        mainBorderPane.getChildren().remove(mainBorderPane.getRight());
                                        mainBorderPane.getChildren().remove(mainBorderPane.getBottom());

                                        BorderPane borderPane2 = new BorderPane();
                                        mainBorderPane.setRight(borderPane2);
                                        borderPane2.setLeft(jfxComboBox2);

                                        BorderPane borderPane22 = new BorderPane();
                                        borderPane22.setPadding(new Insets(0, 0, 70, 0));
                                        mainBorderPane.setBottom(borderPane22);
                                        Label label22 = new Label("Резервные элементы");
                                        borderPane22.setTop(label22);
                                        borderPane22.setLeft(jfxComboBox22);

                                        getBaseElements(jfxComboBox2, borderPane2);
                                        getBackupElements(jfxComboBox22, borderPane22);
                    break;
                    case "3 элемента":  JFXComboBox<String> jfxComboBox3 = new JFXComboBox<>(laws);
                                        JFXComboBox<String> jfxComboBox33 = new JFXComboBox<>(laws);
                                        mainBorderPane.getChildren().remove(mainBorderPane.getRight());
                                        mainBorderPane.getChildren().remove(mainBorderPane.getBottom());

                                        BorderPane borderPane3 = new BorderPane();
                                        mainBorderPane.setRight(borderPane3);
                                        borderPane3.setLeft(jfxComboBox3);

                                        BorderPane borderPane33 = new BorderPane();
                                        borderPane33.setPadding(new Insets(0, 0, 70, 0));
                                        mainBorderPane.setBottom(borderPane33);
                                        Label label33 = new Label("Резервные элементы");
                                        borderPane33.setTop(label33);
                                        borderPane33.setLeft(jfxComboBox33);

                                        getBaseElements(jfxComboBox3, borderPane3);
                                        getBackupElements(jfxComboBox33, borderPane33);
                    break;
                    case "4 элемента":  JFXComboBox<String> jfxComboBox4 = new JFXComboBox<>(laws);
                                        JFXComboBox<String> jfxComboBox44 = new JFXComboBox<>(laws);
                                        mainBorderPane.getChildren().remove(mainBorderPane.getRight());
                                        mainBorderPane.getChildren().remove(mainBorderPane.getBottom());

                                        BorderPane borderPane4 = new BorderPane();
                                        mainBorderPane.setRight(borderPane4);
                                        borderPane4.setLeft(jfxComboBox4);

                                        BorderPane borderPane44 = new BorderPane();
                                        borderPane44.setPadding(new Insets(0, 0, 70, 0));
                                        mainBorderPane.setBottom(borderPane44);
                                        Label label44 = new Label("Резервные элементы");
                                        borderPane44.setTop(label44);
                                        borderPane44.setLeft(jfxComboBox44);

                                        getBaseElements(jfxComboBox4, borderPane4);
                                        getBackupElements(jfxComboBox44, borderPane44);
                    break;
                    case "5 элементов": JFXComboBox<String> jfxComboBox5 = new JFXComboBox<>(laws);
                                        JFXComboBox<String> jfxComboBox55 = new JFXComboBox<>(laws);
                                        mainBorderPane.getChildren().remove(mainBorderPane.getRight());
                                        mainBorderPane.getChildren().remove(mainBorderPane.getBottom());

                                        BorderPane borderPane5 = new BorderPane();
                                        mainBorderPane.setRight(borderPane5);
                                        borderPane5.setLeft(jfxComboBox5);

                                        BorderPane borderPane55 = new BorderPane();
                                        borderPane55.setPadding(new Insets(0, 0, 70, 0));
                                        mainBorderPane.setBottom(borderPane55);
                                        Label label55 = new Label("Резервные элементы");
                                        borderPane55.setTop(label55);
                                        borderPane55.setLeft(jfxComboBox55);

                                        getBaseElements(jfxComboBox5, borderPane5);
                                        getBackupElements(jfxComboBox55, borderPane55);
                    break;
                    case "без резерва": JFXComboBox<String> jfxComboBox0 = new JFXComboBox<>(laws);
                                        mainBorderPane.getChildren().remove(mainBorderPane.getRight());
                                        mainBorderPane.getChildren().remove(mainBorderPane.getBottom());

                                        BorderPane borderPane0 = new BorderPane();
                                        mainBorderPane.setRight(borderPane0);
                                        borderPane0.setLeft(jfxComboBox0);

                                        getBaseElements(jfxComboBox0, borderPane0);
                    break;
                }

            }
        });


        JFXRadioButton zeroItem = new JFXRadioButton("без резерва");
        zeroItem.setToggleGroup(group);
        zeroItem.setPrefHeight(30);

        JFXRadioButton firstItem = new JFXRadioButton("1 элемент");
        firstItem.setToggleGroup(group);
        firstItem.setPrefHeight(30);

        JFXRadioButton secondItem = new JFXRadioButton("2 элемента");
        secondItem.setToggleGroup(group);
        secondItem.setPrefHeight(30);

        JFXRadioButton thirdItem = new JFXRadioButton("3 элемента");
        thirdItem.setToggleGroup(group);
        thirdItem.setPrefHeight(30);

        JFXRadioButton forthItem = new JFXRadioButton("4 элемента");
        forthItem.setToggleGroup(group);
        forthItem.setPrefHeight(30);

        JFXRadioButton fifthItem = new JFXRadioButton("5 элементов");
        fifthItem.setToggleGroup(group);
        fifthItem.setPrefHeight(30);

        VBox vBox = new VBox(6);
        vBox.getChildren().addAll(zeroItem, firstItem, secondItem, thirdItem, forthItem, fifthItem);

        mainBorderPane.setLeft(vBox);
        mainBorderPane.setPadding(new Insets(30, 0, 0, 0));

        setViews();


        tab1.setContent(mainBorderPane);

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
            tabPane.getTabs().addAll(tab01, tab02, tab03, tab04);
        }
        else if (tabPane.getTabs().size() == 3) {
            tabPane.getTabs().clear();
            tabPane.getTabs().addAll(tab01, tab02, tab03, tab04);
        }
    }

}
