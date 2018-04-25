package labwork3;

import com.jfoenix.controls.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.DoubleStream;

public class DeterminingSystemReliabilityController extends Laws implements Initializable, Data {

    @FXML
    private JFXButton buttonData;

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

    private JFXComboBox<String> jfxComboBox = new JFXComboBox<>(laws);

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

    }


//    private void setViews() {
//        Label labelSwitchLaw = new Label("Вид и параметры закона переключателя");
//        JFXComboBox switchLaw = new JFXComboBox<>(laws);
//        JFXTextField jfxTextField = new JFXTextField();
//        jfxTextField.setPrefSize(80, 26);
//        jfxTextField.setPadding(new Insets(0, 0, 0, 20));
//        VBox vBox = new VBox();
//        HBox hBox = new HBox();
//        hBox.getChildren().addAll(switchLaw, jfxTextField);
//
//        Label labelReserve = new Label("Вид резервирования в группе");
//        JFXComboBox cbReserve = new JFXComboBox<>(reserve);
//        labelReserve.setPadding(new Insets(50, 0, 10, 0));
//
//        Label labelProbability = new Label("Вероятность обнаружения отказа переключателем");
//        JFXTextField tfProbability = new JFXTextField();
//        tfProbability.setPrefWidth(80);
//        tfProbability.setPadding(new Insets(0, 0, 0, 20));
//        HBox hBox1 = new HBox();
//        hBox1.getChildren().addAll(labelProbability, tfProbability);
//        hBox1.setPadding(new Insets(50, 0, 0, 0));
//
//        UnaryOperator<TextFormatter.Change> filter = change -> {
//            String string = change.getText();
//
//            if (string.matches("0?[.,]?[0-9]?")) {  // \\u002E - точка
//                return change;
//            }
//
//            return null;
//        };
//
//        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
//        tfProbability.setTextFormatter(textFormatter);
//
//        vBox.getChildren().addAll(labelSwitchLaw, hBox, labelReserve, cbReserve, hBox1);
//        vBox.setPadding(new Insets(0, 0, 0, 60));
////        vBox.setStyle("-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.4), 10, 0.5, 0.0, 0.0);" + "-fx-background-color: white;");
////        vBox.setMaxWidth(350);
////        vBox.setMaxHeight(60);
//        mainBorderPane.setCenter(vBox);
//    }


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


    private void getThirdPane() {

//        Основной элемент

        BorderPane borderPane = new BorderPane();
        mainBorderPane.setRight(borderPane);
        borderPane.setLeft(jfxComboBox);

        JFXTextField jfxTextField = new JFXTextField();
        JFXTextField jfxTextField1 = new JFXTextField();

        jfxComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.contains("Exponential")) {
                borderPane.getChildren().remove(borderPane.getRight());

                jfxTextField.clear();
                jfxTextField.setPrefSize(30, 26);
                jfxTextField.setPadding(new Insets(0, 0, 0, 5));
                borderPane.setRight(jfxTextField);
            }
            else if (newValue.contains("Normal")) {
                borderPane.getChildren().remove(borderPane.getRight());

                HBox hBox = new HBox();
                jfxTextField.clear();
                jfxTextField.setPrefSize(30, 26);
                jfxTextField1.setPrefSize(30, 26);
                jfxTextField.setPadding(new Insets(0, 0, 0, 5));
                jfxTextField1.setPadding(new Insets(0, 0, 0, 5));
                hBox.getChildren().addAll(jfxTextField, jfxTextField1);
                borderPane.setRight(hBox);
            }
            else if (newValue.contains("Rayleigh")) {
                borderPane.getChildren().remove(borderPane.getRight());

                jfxTextField.clear();
                jfxTextField.setPrefSize(30, 26);
                jfxTextField.setPadding(new Insets(0, 0, 0, 5));
                borderPane.setRight(jfxTextField);
            }
        });


        ToggleGroup group = new ToggleGroup();

        group.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {
            if (group.getSelectedToggle() != null) {
                RadioButton button = (RadioButton) group.getSelectedToggle();
                String string = button.getText();
                switch (string) {
                    case "1 элемент":   JFXComboBox<String> jfxComboBox11 = new JFXComboBox<>(laws);

                                        mainBorderPane.getChildren().remove(mainBorderPane.getBottom());

                                        BorderPane borderPane11 = new BorderPane();
                                        borderPane11.setPadding(new Insets(0, 0, 70, 0));
                                        mainBorderPane.setBottom(borderPane11);
                                        Label label1 = new Label("Резервные элементы");
                                        borderPane11.setTop(label1);
                                        borderPane11.setLeft(jfxComboBox11);

                                        getBackupElements(jfxComboBox11, borderPane11);
                        break;
                    case "2 элемента":  JFXComboBox<String> jfxComboBox22 = new JFXComboBox<>(laws);
                                        mainBorderPane.getChildren().remove(mainBorderPane.getBottom());

                                        BorderPane borderPane22 = new BorderPane();
                                        borderPane22.setPadding(new Insets(0, 0, 70, 0));
                                        mainBorderPane.setBottom(borderPane22);
                                        Label label22 = new Label("Резервные элементы");
                                        borderPane22.setTop(label22);
                                        borderPane22.setLeft(jfxComboBox22);

                                        getBackupElements(jfxComboBox22, borderPane22);
                        break;
                    case "3 элемента":  JFXComboBox<String> jfxComboBox33 = new JFXComboBox<>(laws);
                                        mainBorderPane.getChildren().remove(mainBorderPane.getBottom());

                                        BorderPane borderPane33 = new BorderPane();
                                        borderPane33.setPadding(new Insets(0, 0, 70, 0));
                                        mainBorderPane.setBottom(borderPane33);
                                        Label label33 = new Label("Резервные элементы");
                                        borderPane33.setTop(label33);
                                        borderPane33.setLeft(jfxComboBox33);

                                        getBackupElements(jfxComboBox33, borderPane33);
                        break;
                    case "4 элемента":  JFXComboBox<String> jfxComboBox44 = new JFXComboBox<>(laws);
                                        mainBorderPane.getChildren().remove(mainBorderPane.getBottom());

                                        BorderPane borderPane44 = new BorderPane();
                                        borderPane44.setPadding(new Insets(0, 0, 70, 0));
                                        mainBorderPane.setBottom(borderPane44);
                                        Label label44 = new Label("Резервные элементы");
                                        borderPane44.setTop(label44);
                                        borderPane44.setLeft(jfxComboBox44);

                                        getBackupElements(jfxComboBox44, borderPane44);
                        break;
                    case "5 элементов": JFXComboBox<String> jfxComboBox55 = new JFXComboBox<>(laws);
                                        mainBorderPane.getChildren().remove(mainBorderPane.getBottom());

                                        BorderPane borderPane55 = new BorderPane();
                                        borderPane55.setPadding(new Insets(0, 0, 70, 0));
                                        mainBorderPane.setBottom(borderPane55);
                                        Label label55 = new Label("Резервные элементы");
                                        borderPane55.setTop(label55);
                                        borderPane55.setLeft(jfxComboBox55);

                                        getBackupElements(jfxComboBox55, borderPane55);
                    break;
                    case "без резерва": mainBorderPane.getChildren().remove(mainBorderPane.getBottom());
                        break;
                }
            }
        });


        JFXRadioButton zeroItem = new JFXRadioButton("без резерва");
        zeroItem.setId("1");
        zeroItem.setToggleGroup(group);
        zeroItem.setPrefHeight(30);

        JFXRadioButton firstItem = new JFXRadioButton("1 элемент");
        firstItem.setId("2");
        firstItem.setToggleGroup(group);
        firstItem.setPrefHeight(30);

        JFXRadioButton secondItem = new JFXRadioButton("2 элемента");
        secondItem.setId("3");
        secondItem.setToggleGroup(group);
        secondItem.setPrefHeight(30);

        JFXRadioButton thirdItem = new JFXRadioButton("3 элемента");
        thirdItem.setId("4");
        thirdItem.setToggleGroup(group);
        thirdItem.setPrefHeight(30);

        JFXRadioButton forthItem = new JFXRadioButton("4 элемента");
        forthItem.setId("5");
        forthItem.setToggleGroup(group);
        forthItem.setPrefHeight(30);

        JFXRadioButton fifthItem = new JFXRadioButton("5 элементов");
        fifthItem.setId("6");
        fifthItem.setToggleGroup(group);
        fifthItem.setPrefHeight(30);

        VBox vBox = new VBox(6);
        vBox.getChildren().addAll(zeroItem, firstItem, secondItem, thirdItem, forthItem, fifthItem);

        mainBorderPane.setLeft(vBox);
        mainBorderPane.setPadding(new Insets(30, 0, 0, 0));




//        setViews();
        Label labelSwitchLaw = new Label("Вид и параметры закона переключателя");
        JFXComboBox switchLaw = new JFXComboBox<>(laws);
        JFXTextField jfxTextFieldLaw = new JFXTextField();
        jfxTextFieldLaw.setPrefSize(80, 26);
        jfxTextFieldLaw.setPadding(new Insets(0, 0, 0, 20));
        VBox vBox1 = new VBox();
        HBox hBox = new HBox();
        hBox.getChildren().addAll(switchLaw, jfxTextFieldLaw);

        Label labelReserve = new Label("Вид резервирования в группе");
        JFXComboBox<String> cbReserve = new JFXComboBox<>(reserve);
        labelReserve.setPadding(new Insets(50, 0, 10, 0));

        Label labelProbability = new Label("Вероятность обнаружения отказа переключателем");
        JFXTextField tfProbability = new JFXTextField();
        tfProbability.setPrefWidth(80);
        tfProbability.setPadding(new Insets(0, 0, 0, 20));
        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(labelProbability, tfProbability);
        hBox1.setPadding(new Insets(50, 0, 0, 0));

        UnaryOperator<TextFormatter.Change> filter = change -> {
            String string1 = change.getText();

            if (string1.matches("0?[.,]?[0-9]?")) {  // \\u002E - точка
                return change;
            }

            return null;
        };

        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        tfProbability.setTextFormatter(textFormatter);

//        Ограничиваем ввод целыми числами (числовое поле)
//        tfProbability.textProperty().addListener((observable, oldValue, newValue) -> {
//            if (!newValue.matches("\\d*")) {
//                tfProbability.setText(newValue.replaceAll("[^\\d]", ""));
//            }
//        });

        vBox1.getChildren().addAll(labelSwitchLaw, hBox, labelReserve, cbReserve, hBox1);
        vBox1.setPadding(new Insets(0, 0, 0, 60));
//        vBox.setStyle("-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.4), 10, 0.5, 0.0, 0.0);" + "-fx-background-color: white;");
//        vBox.setMaxWidth(350);
//        vBox.setMaxHeight(60);
        mainBorderPane.setCenter(vBox1);



//впринципе, можно не использовать слушатель повторно (getSelectionModel() ежжи!)
        jfxComboBox.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            buttonData.setOnAction(event -> {
                if (group.getSelectedToggle() != null & cbReserve.getSelectionModel() != null) {
                    RadioButton button = (RadioButton) group.getSelectedToggle();

                    int numBackup = Integer.parseInt(button.getId());

                    String str = cbReserve.getSelectionModel().getSelectedItem();
                    if (str.contains("Ненагруженное резервирование без восстановления")) {
                        switch (newValue) {
                            case "Exponential":
                                if (jfxTextField.getText() != null && !jfxTextField.getText().isEmpty()) {
                                    double parseDoubleExponential = Double.parseDouble(jfxTextField.getText());
                                    double sumExponential = 0;
                                    double[] numExponential = new double[numBackup];
                                    for (int i = 0; i < numBackup; i++) {
                                        numExponential[i] = Exponential(parseDoubleExponential);
                                        sumExponential = DoubleStream.of(numExponential).sum();
                                    }
                                    System.out.println("Exponential");
                                    System.out.println(Arrays.toString(numExponential));
                                    System.out.println(sumExponential);
                                }
                                break;
                            case "Rayleigh":
                                if (jfxTextField.getText() != null && !jfxTextField.getText().isEmpty()) {
                                    int parseIntRayleigh = Integer.parseInt(jfxTextField.getText());
                                    double sumRayleigh = 0;
                                    double[] numRayleigh = new double[numBackup];
                                    for (int i = 0; i < numBackup; i++) {
                                        numRayleigh[i] = Rayleigh(parseIntRayleigh);
                                        sumRayleigh = DoubleStream.of(numRayleigh).sum();
                                    }
                                    System.out.println("Rayleigh");
                                    System.out.println(Arrays.toString(numRayleigh));
                                    System.out.println(sumRayleigh);
                                }
                                break;
                            case "Normal":
                                if (jfxTextField.getText() != null && !jfxTextField.getText().isEmpty() && jfxTextField1.getText() != null && !jfxTextField1.getText().isEmpty()) {
                                    int parseIntNormal = Integer.parseInt(jfxTextField.getText());
                                    int parseIntNormal1 = Integer.parseInt(jfxTextField1.getText());
                                    double sumNormal = 0;
                                    double[] numNormal = new double[numBackup];
                                    for (int i = 0; i < numBackup; i++) {
                                        numNormal[i] = Normal(parseIntNormal, parseIntNormal1);
                                        sumNormal = DoubleStream.of(numNormal).sum();
                                    }
                                    System.out.println("Normal");
                                    System.out.println(Arrays.toString(numNormal));
                                    System.out.println(sumNormal);
                                }
                                break;
                        }
                    }
                    else if (str.contains("Нагруженное резервирование без восстановления")) {
                        switch (newValue) {
                            case "Exponential":
                                if (jfxTextField.getText() != null && !jfxTextField.getText().isEmpty()) {
                                    double parseDoubleExponential = Double.parseDouble(jfxTextField.getText());
                                    double[] numExponential = new double[numBackup];
                                    for (int i = 0; i < numBackup; i++) {
                                        numExponential[i] = Exponential(parseDoubleExponential);
                                    }
                                    double maxExponential = numExponential[0];
                                    for (int i = 0; i < numBackup; i++) maxExponential = Math.max(maxExponential, numExponential[i]);
                                    System.out.println("Exponential");
                                    System.out.println(Arrays.toString(numExponential));
                                    System.out.println(maxExponential);
                                }
                                break;
                            case "Rayleigh":
                                if (jfxTextField.getText() != null && !jfxTextField.getText().isEmpty()) {
                                    int parseIntRayleigh = Integer.parseInt(jfxTextField.getText());
                                    double[] numRayleigh = new double[numBackup];
                                    for (int i = 0; i < numBackup; i++) {
                                        numRayleigh[i] = Rayleigh(parseIntRayleigh);
                                    }
                                    double maxRayleigh = numRayleigh[0];
                                    for (int i = 0; i < numBackup; i++) maxRayleigh = Math.max(maxRayleigh, numRayleigh[i]);
                                    System.out.println("Rayleigh");
                                    System.out.println(Arrays.toString(numRayleigh));
                                    System.out.println(maxRayleigh);
                                }
                                break;
                            case "Normal":
                                if (jfxTextField.getText() != null && !jfxTextField.getText().isEmpty() && jfxTextField1.getText() != null && !jfxTextField1.getText().isEmpty()) {
                                    int parseIntNormal = Integer.parseInt(jfxTextField.getText());
                                    int parseIntNormal1 = Integer.parseInt(jfxTextField1.getText());
                                    double[] numNormal = new double[numBackup];
                                    for (int i = 0; i < numBackup; i++) {
                                        numNormal[i] = Normal(parseIntNormal, parseIntNormal1);
                                    }
                                    double maxNormal = numNormal[0];
                                    for (int i = 0; i < numBackup; i++) maxNormal = Math.max(maxNormal, numNormal[i]);
                                    System.out.println("Normal");
                                    System.out.println(Arrays.toString(numNormal));
                                    System.out.println(maxNormal);
                                }
                                break;
                        }
                    }
                    else if (str.contains("Ненагруженное резервирование с восстановлением")) {
                        switch (newValue) {
                            case "Exponential":
                                if (jfxTextField.getText() != null && !jfxTextField.getText().isEmpty()) {
                                    double parseDoubleExponential = Double.parseDouble(jfxTextField.getText());
                                    double[] numExponential = new double[numBackup];
                                    double[] secondGroup = new double[numBackup];
                                    double[] recoveryTime = new double[numBackup];
                                    for (int i = 0; i < numBackup; i++) {
                                        numExponential[i] = Exponential(parseDoubleExponential);
                                        secondGroup[i] = Exponential(parseDoubleExponential);
                                        recoveryTime[i] = Exponential(parseDoubleExponential);
                                    }
                                    System.out.println("Exponential");
                                    System.out.println(Arrays.toString(numExponential));
                                    double sumExponential = DoubleStream.of(numExponential).sum();

                                    switch (numBackup) {
                                        case 1:
                                            System.out.println("без резерва " + sumExponential);
                                            break;
                                        case 2: get2(sumExponential, recoveryTime, numExponential, secondGroup);
                                            break;
                                        case 3: get3(sumExponential, recoveryTime, numExponential, secondGroup);
                                            break;
                                        case 4: get4(sumExponential, recoveryTime, numExponential, secondGroup);
                                            break;
                                    }
                                }
                                break;
                            case "Rayleigh":
                                if (jfxTextField.getText() != null && !jfxTextField.getText().isEmpty()) {
                                    int parseIntRayleigh = Integer.parseInt(jfxTextField.getText());
                                    double[] numRayleigh = new double[numBackup];
                                    double[] secondGroup = new double[numBackup];
                                    double[] recoveryTime = new double[numBackup];
                                    for (int i = 0; i < numBackup; i++) {
                                        numRayleigh[i] = Rayleigh(parseIntRayleigh);
                                        secondGroup[i] = Rayleigh(parseIntRayleigh);
                                        recoveryTime[i] = Rayleigh(parseIntRayleigh);
                                    }
                                    System.out.println("Rayleigh");
                                    System.out.println(Arrays.toString(numRayleigh));
                                    double sumRayleigh = DoubleStream.of(numRayleigh).sum();

                                    switch (numBackup) {
                                        case 1:
                                            System.out.println("без резерва " + sumRayleigh);
                                            break;
                                        case 2: get2(sumRayleigh, recoveryTime, numRayleigh, secondGroup);
                                            break;
                                        case 3: get3(sumRayleigh, recoveryTime, numRayleigh, secondGroup);
                                            break;
                                        case 4: get4(sumRayleigh, recoveryTime, numRayleigh, secondGroup);
                                            break;
                                    }
                                }
                                break;
                            case "Normal":
                                if (jfxTextField.getText() != null && !jfxTextField.getText().isEmpty() && jfxTextField1.getText() != null && !jfxTextField1.getText().isEmpty()) {
                                    int parseIntNormal = Integer.parseInt(jfxTextField.getText());
                                    int parseIntNormal1 = Integer.parseInt(jfxTextField1.getText());
                                    double[] numNormal = new double[numBackup];
                                    double[] secondGroup = new double[numBackup];
                                    double[] recoveryTime = new double[numBackup];
                                    for (int i = 0; i < numBackup; i++) {
                                        numNormal[i] = Normal(parseIntNormal, parseIntNormal1);
                                        secondGroup[i] = Normal(parseIntNormal, parseIntNormal1);
                                        recoveryTime[i] = Normal(parseIntNormal, parseIntNormal1);
                                    }
                                    System.out.println("Normal");
                                    System.out.println(Arrays.toString(numNormal));

                                    double sumNormal = DoubleStream.of(numNormal).sum();

                                    switch (numBackup) {
                                        case 1:
                                            System.out.println("без резерва " + sumNormal);
                                            break;
                                        case 2: get2(sumNormal, recoveryTime, numNormal, secondGroup);
                                            break;
                                        case 3: get3(sumNormal, recoveryTime, numNormal, secondGroup);
                                            break;
                                        case 4: get4(sumNormal, recoveryTime, numNormal, secondGroup);
                                            break;
                                    }
                                }
                                break;
                        }
                    }
                    else if (str.contains("Нагруженное резервирование с восстановлением")) {
                        switch (newValue) {
                            case "Exponential":
                                if (jfxTextField.getText() != null && !jfxTextField.getText().isEmpty()) {
                                    double parseDoubleExponential = Double.parseDouble(jfxTextField.getText());
                                    double[] numExponential = new double[numBackup];
                                    double[] secondGroup = new double[numBackup];
                                    double[] thirdGroup = new double[numBackup];
                                    double[] recoveryTime = new double[numBackup];
                                    for (int i = 0; i < numBackup; i++) {
                                        numExponential[i] = Exponential(parseDoubleExponential);
                                        secondGroup[i] = Exponential(parseDoubleExponential);
                                        thirdGroup[i] = Exponential(parseDoubleExponential);
                                        recoveryTime[i] = Exponential(parseDoubleExponential);
                                    }

                                    double maxExponential = numExponential[0];
                                    double[] firstRecoveryElements = new double[numBackup];
                                    double[] secondNumExponential = new double[numBackup];
                                    double[] secondRecoveryElements = new double[numBackup];
                                    double[] thirdNumExponential = new double[numBackup];
                                    for (int i = 0; i < numBackup; i++) {
                                        maxExponential = Math.max(maxExponential, numExponential[i]);
                                        firstRecoveryElements[i] = numExponential[i] + recoveryTime[i];
                                        secondNumExponential[i] = firstRecoveryElements[i] + secondGroup[i];
                                        secondRecoveryElements[i] = secondNumExponential[i] + recoveryTime[i];
                                        thirdNumExponential[i] = secondRecoveryElements[i] + thirdGroup[i];
                                    }

                                    getNagrVost(maxExponential, numExponential, firstRecoveryElements, secondNumExponential, secondRecoveryElements, thirdNumExponential);
// для 3 элементов
//                                    if (maxExponential != numExponential[0] & maxExponential > firstRecoveryElements[0]) {
//                                        double time = firstRecoveryElements[0] + secondGroup[0];
//                                        if (time > firstRecoveryElements[1] & time < secondNumExponential[1]) {
//                                            double t = secondNumExponential[1];
//                                            if (t > secondRecoveryElements[0] & t < thirdNumExponential[0]) {
//                                                double tt = secondRecoveryElements[0] + thirdGroup[0];
//                                                System.out.println("проработал 3 раза " + tt);
//                                            }
//                                            else if (t > secondRecoveryElements[2] & t < thirdNumExponential[2]) {
//                                                double tt = secondRecoveryElements[2] + thirdGroup[2];
//                                                System.out.println("проработал 3 раза " + tt);
//                                            } else System.out.println("проработал 2 раза " + t);
//                                        }
//                                        else if (time > firstRecoveryElements[2] & time < secondNumExponential[2]) {
//                                            double t = secondNumExponential[2];
//                                            if (t > secondRecoveryElements[0] & t < thirdNumExponential[0]) {
//                                                double tt = secondRecoveryElements[0] + thirdGroup[0];
//                                                System.out.println("проработал 3 раза " + tt);
//                                            }
//                                            else if (t > secondRecoveryElements[1] & t < thirdNumExponential[1]) {
//                                                double tt = secondRecoveryElements[1] + thirdGroup[1];
//                                                System.out.println("проработал 3 раза " + tt);
//                                            } else System.out.println("проработал 2 раза " + t);
//                                        }
//                                        else System.out.println(time);
//                                    }
//                                    else if (maxExponential != numExponential[1] & maxExponential > firstRecoveryElements[1]) {
//                                        double time = firstRecoveryElements[1] + secondGroup[1];
//                                        if (time > firstRecoveryElements[0] & time < secondNumExponential[0]) {
//                                            double t = secondNumExponential[0];
//                                            if (t > secondRecoveryElements[1] & t < thirdNumExponential[1]) {
//                                                double tt = secondRecoveryElements[1] + thirdGroup[1];
//                                                System.out.println("проработал 3 раза " + tt);
//                                            }
//                                            else if (t > secondRecoveryElements[2] & t < thirdNumExponential[2]) {
//                                                double tt = secondRecoveryElements[2] + thirdGroup[2];
//                                                System.out.println("проработал 3 раза " + tt);
//                                            } else System.out.println("проработал 2 раза " + t);
//                                        }
//                                        else if (time > firstRecoveryElements[2] & time < secondNumExponential[2]) {
//                                            double t = secondNumExponential[2];
//                                            if (t > secondRecoveryElements[0] & t < thirdNumExponential[0]) {
//                                                double tt = secondRecoveryElements[0] + thirdGroup[0];
//                                                System.out.println("проработал 3 раза " + tt);
//                                            }
//                                            else if (t > secondRecoveryElements[1] & t < thirdNumExponential[1]) {
//                                                double tt = secondRecoveryElements[1] + thirdGroup[1];
//                                                System.out.println("проработал 3 раза " + tt);
//                                            } else System.out.println("проработал 2 раза " + t);
//                                        }
//                                        else System.out.println(time);
//                                    }
//                                    else if (maxExponential != numExponential[2] & maxExponential > firstRecoveryElements[2]) {
//                                        double time = firstRecoveryElements[2] + secondGroup[2];
//                                        if (time > firstRecoveryElements[0] & time < secondNumExponential[0]) {
//                                            double t = secondNumExponential[0];
//                                            if (t > secondRecoveryElements[1] & t < thirdNumExponential[1]) {
//                                                double tt = secondRecoveryElements[1] + thirdGroup[1];
//                                                System.out.println("проработал 3 раза " + tt);
//                                            }
//                                            else if (t > secondRecoveryElements[2] & t < thirdNumExponential[2]) {
//                                                double tt = secondRecoveryElements[2] + thirdGroup[2];
//                                                System.out.println("проработал 3 раза " + tt);
//                                            } else System.out.println("проработал 2 раза " + t);
//                                        }
//                                        else if (time > firstRecoveryElements[1] & time < secondNumExponential[1]) {
//                                            double t = secondNumExponential[1];
//                                            if (t > secondRecoveryElements[0] & t < thirdNumExponential[0]) {
//                                                double tt = secondRecoveryElements[0] + thirdGroup[0];
//                                                System.out.println("проработал 3 раза " + tt);
//                                            }
//                                            else if (t > secondRecoveryElements[2] & t < thirdNumExponential[2]) {
//                                                double tt = secondRecoveryElements[2] + thirdGroup[2];
//                                                System.out.println("проработал 3 раза " + tt);
//                                            } else System.out.println("проработал 2 раза " + t);
//                                        }
//                                        else System.out.println(time);
//                                    }
//                                    else System.out.println("отказ системы " + maxExponential);

                                    System.out.println("Exponential");
                                    System.out.println("1 время работы" + Arrays.toString(numExponential));
                                    System.out.println("время восстановления" + Arrays.toString(recoveryTime));
                                    System.out.println("2 время работы" + Arrays.toString(secondGroup));
                                    System.out.println("время восстановления" + Arrays.toString(recoveryTime));
                                    System.out.println("3 время работы" + Arrays.toString(thirdGroup));
                                }
                                break;
                            case "Rayleigh":
                                if (jfxTextField.getText() != null && !jfxTextField.getText().isEmpty()) {
                                    int parseIntRayleigh = Integer.parseInt(jfxTextField.getText());
                                    double[] numRayleigh = new double[numBackup];
                                    double[] secondGroup = new double[numBackup];
                                    double[] thirdGroup = new double[numBackup];
                                    double[] recoveryTime = new double[numBackup];
                                    for (int i = 0; i < numBackup; i++) {
                                        numRayleigh[i] = Rayleigh(parseIntRayleigh);
                                        secondGroup[i] = Rayleigh(parseIntRayleigh);
                                        thirdGroup[i] = Rayleigh(parseIntRayleigh);
                                        recoveryTime[i] = Rayleigh(parseIntRayleigh);
                                    }

                                    double maxRayleigh = numRayleigh[0];
                                    double[] firstRecoveryElements = new double[numBackup];
                                    double[] secondNumRayleigh = new double[numBackup];
                                    double[] secondRecoveryElements = new double[numBackup];
                                    double[] thirdNumRayleigh = new double[numBackup];
                                    for (int i = 0; i < numBackup; i++) {
                                        maxRayleigh = Math.max(maxRayleigh, numRayleigh[i]);
                                        firstRecoveryElements[i] = numRayleigh[i] + recoveryTime[i];
                                        secondNumRayleigh[i] = firstRecoveryElements[i] + secondGroup[i];
                                        secondRecoveryElements[i] = secondNumRayleigh[i] + recoveryTime[i];
                                        thirdNumRayleigh[i] = secondRecoveryElements[i] + thirdGroup[i];
                                    }

                                    getNagrVost(maxRayleigh, numRayleigh, firstRecoveryElements, secondNumRayleigh, secondRecoveryElements, thirdNumRayleigh);

                                    System.out.println("Rayleigh");
                                    System.out.println("1 время работы" + Arrays.toString(numRayleigh));
                                    System.out.println("время восстановления" + Arrays.toString(recoveryTime));
                                    System.out.println("2 время работы" + Arrays.toString(secondGroup));
                                    System.out.println("время восстановления" + Arrays.toString(recoveryTime));
                                    System.out.println("3 время работы" + Arrays.toString(thirdGroup));
                                }
                                break;
                            case "Normal":
                                if (jfxTextField.getText() != null && !jfxTextField.getText().isEmpty() && jfxTextField1.getText() != null && !jfxTextField1.getText().isEmpty()) {
                                    int parseIntNormal = Integer.parseInt(jfxTextField.getText());
                                    int parseIntNormal1 = Integer.parseInt(jfxTextField1.getText());
                                    double[] numNormal = new double[numBackup];
                                    double[] secondGroup = new double[numBackup];
                                    double[] thirdGroup = new double[numBackup];
                                    double[] recoveryTime = new double[numBackup];
                                    for (int i = 0; i < numBackup; i++) {
                                        numNormal[i] = Normal(parseIntNormal, parseIntNormal1);
                                        secondGroup[i] = Normal(parseIntNormal, parseIntNormal1);
                                        thirdGroup[i] = Normal(parseIntNormal, parseIntNormal1);
                                        recoveryTime[i] = Normal(parseIntNormal, parseIntNormal1);
                                    }

                                    double maxNormal = numNormal[0];
                                    double[] firstRecoveryElements = new double[numBackup];
                                    double[] secondNumNormal = new double[numBackup];
                                    double[] secondRecoveryElements = new double[numBackup];
                                    double[] thirdNumNormal = new double[numBackup];
                                    for (int i = 0; i < numBackup; i++) {
                                        maxNormal = Math.max(maxNormal, numNormal[i]);
                                        firstRecoveryElements[i] = numNormal[i] + recoveryTime[i];
                                        secondNumNormal[i] = firstRecoveryElements[i] + secondGroup[i];
                                        secondRecoveryElements[i] = secondNumNormal[i] + recoveryTime[i];
                                        thirdNumNormal[i] = secondRecoveryElements[i] + thirdGroup[i];
                                    }

                                    getNagrVost(maxNormal, numNormal, firstRecoveryElements, secondNumNormal, secondRecoveryElements, thirdNumNormal);

                                    System.out.println("Normal");
                                    System.out.println("1 время работы" + Arrays.toString(numNormal));
                                    System.out.println("время восстановления" + Arrays.toString(recoveryTime));
                                    System.out.println("2 время работы" + Arrays.toString(secondGroup));
                                    System.out.println("время восстановления" + Arrays.toString(recoveryTime));
                                    System.out.println("3 время работы" + Arrays.toString(thirdGroup));
                                }
                                break;
                        }
                    }
                }
            });
        });





        tab1.setContent(mainBorderPane);

        if (tabPane.getTabs().size() < 2) {
            tabPane.getTabs().addAll(tab1, tab2, tab3);
        }
        else if (tabPane.getTabs().size() == 4) {
            tabPane.getTabs().clear();
            tabPane.getTabs().addAll(tab1, tab2, tab3);
        }
    }

//   Метод для нагруженного резервирования с восстановлением
    private void getNagrVost(double maxExponential, double[] numExponential, double[] firstRecoveryElements, double[] secondNumExponential, double[] secondRecoveryElements, double[] thirdNumExponential) {
        if (maxExponential != numExponential[0] & maxExponential > firstRecoveryElements[0] & maxExponential < secondNumExponential[0]) {
            double time = secondNumExponential[0];
            if (time > firstRecoveryElements[1] & time < secondNumExponential[1]) {
                double t = secondNumExponential[1];
                if (t > secondRecoveryElements[0] & t < thirdNumExponential[0]) {
                    double tt = thirdNumExponential[0];
                    System.out.println("проработал 3 раза [0] " + tt);
                }
                else System.out.println("проработал 2 раза [1] " + t);
            }
            else System.out.println("проработал 2 раза [0] " + time);
        }
        else if (maxExponential != numExponential[1] & maxExponential > firstRecoveryElements[1] & maxExponential < secondNumExponential[1]) {
            double time = secondNumExponential[1];
            if (time > firstRecoveryElements[0] & time < secondNumExponential[0]) {
                double t = secondNumExponential[0];
                if (t > secondRecoveryElements[1] & t < thirdNumExponential[1]) {
                    double tt = thirdNumExponential[1];
                    System.out.println("проработал 3 раза [1] " + tt);
                }
                else System.out.println("проработал 2 раза [0] " + t);
            }
            else System.out.println("проработал 2 раза [1] " + time);
        }
        else System.out.println("проработал 1 раз " + maxExponential);
    }

//  Методы для ненагруженного резервирования с восстановлением
    private void get4(double sumExponential, double[] recoveryTime, double[] numExponential, double[] secondGroup) {
        if (sumExponential > (recoveryTime[0] + numExponential[0])) {
            sumExponential = sumExponential + secondGroup[0];
            if (sumExponential > (recoveryTime[1] + numExponential[1])) {
                sumExponential = sumExponential + secondGroup[1];
                if (sumExponential > (recoveryTime[2] + numExponential[2])) {
                    sumExponential = sumExponential + secondGroup[2];
                    if (sumExponential > (recoveryTime[3] + numExponential[3])) {
                        sumExponential = sumExponential + secondGroup[3];
                        System.out.println("secondGroup[3]" + sumExponential);
                    }
                    else {
                        System.out.println("secondGroup[2]" + sumExponential);
                    }
                }
                else {
                    System.out.println("secondGroup[1]" + sumExponential);
                }
            }
            else {
                System.out.println("secondGroup[0]" + sumExponential);
            }
        }
        else  {
            System.out.println(sumExponential);
        }
    }

    private void get3(double sumExponential, double[] recoveryTime, double[] numExponential, double[] secondGroup) {
        if (sumExponential > (recoveryTime[0] + numExponential[0])) {
            sumExponential = sumExponential + secondGroup[0];
            if (sumExponential > (recoveryTime[1] + numExponential[1])) {
                sumExponential = sumExponential + secondGroup[1];
                if (sumExponential > (recoveryTime[2] + numExponential[2])) {
                    sumExponential = sumExponential + secondGroup[2];
                    System.out.println("secondGroup[2]" + sumExponential);
                }
                else {
                    System.out.println("secondGroup[1]" + sumExponential);
                }
            }
            else {
                System.out.println("secondGroup[0]" + sumExponential);
            }
        }
        else  {
            System.out.println(sumExponential);
        }
    }

    private void get2(double sumExponential, double[] recoveryTime, double[] numExponential, double[] secondGroup) {
        if (sumExponential > (recoveryTime[0] + numExponential[0])) {
            sumExponential = sumExponential + secondGroup[0];
            if (sumExponential > (recoveryTime[1] + numExponential[1])) {
                sumExponential = sumExponential + secondGroup[1];
                System.out.println("secondGroup[1]" + sumExponential);
            }
            else {
                System.out.println("secondGroup[0]" + sumExponential);
            }
        }
        else  {
            System.out.println(sumExponential);
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
