package labwork1;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.*;

import static labwork1.Laws.getReplacementElements;
import static labwork1.Laws.rndMain;

public class LabWorkController implements Initializable, InitialData {

    @FXML
    private JFXButton buttonEnter;

    @FXML
    private JFXButton btnEnter;

    @FXML
    private JFXTextField textField;

    @FXML
    private TableView<String[]> tableView1;

    @FXML
    private TableView<String[]> tableView2;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

        buttonEnter.setOnAction(event -> {

            if (textField.getText() != null && !textField.getText().isEmpty()) {
                int time = Integer.parseInt(textField.getText());

                switch (time) {
                    case T1: populateTable(T1);
                        break;
                    case T2: populateTable(T2);
                        break;
                    case T3: populateTable(T3);
                        break;
                    case T4: populateTable(T4);
                        break;
                    case T5: populateTable(T5);
                        break;
                    case T6: populateTable(T6);
                        break;
                    case T7: populateTable(T7);
                        break;
                    case T8: populateTable(T8);
                        break;
                    case T9: populateTable(T9);
                        break;
                    case T10: populateTable(T10);
                        break;
                }

            }

        });


        btnEnter.setOnAction(event -> popTable());


        String[] columnsName = {"Номер опыта", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};

        for (int i = 0; i < columnsName.length; i++) {
            TableColumn<String[], String> headersTableView = new TableColumn<>(columnsName[i]);
            headersTableView.setSortable(false);
            headersTableView.setReorderable(false);

            final int colIndex = i;

            headersTableView.setCellValueFactory(p -> new SimpleStringProperty(p.getValue()[colIndex]));

            tableView1.getColumns().add(headersTableView);
        }

        for (int i = 0; i < columnsName.length; i++) {
            TableColumn<String[], String> headersTableView = new TableColumn<>(columnsName[i]);
            headersTableView.setSortable(false);
            headersTableView.setReorderable(false);

            final int colIndex = i;

            headersTableView.setCellValueFactory(p -> new SimpleStringProperty(p.getValue()[colIndex]));

            tableView2.getColumns().add(headersTableView);
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

        tableView1.setItems(observableList);
        tableView2.setItems(observableList);

    }


    private void popTable() {

        int[] ints = getReplacementElements();
        String[] strings = new String[13];
        for (int i = 0; i < ints.length; i++) strings[i + 1] = String.valueOf(ints[i]);
        strings[0] = "1";

        int[] ints1 = getReplacementElements();
        String[] strings1 = new String[13];
        for (int i = 0; i < ints1.length; i++) strings1[i + 1] = String.valueOf(ints1[i]);
        strings1[0] = "2";

        int[] ints2 = getReplacementElements();
        String[] strings2 = new String[13];
        for (int i = 0; i < ints1.length; i++) strings2[i + 1] = String.valueOf(ints2[i]);
        strings2[0] = "3";

        int[] ints3 = getReplacementElements();
        String[] strings3 = new String[13];
        for (int i = 0; i < ints1.length; i++) strings3[i + 1] = String.valueOf(ints3[i]);
        strings3[0] = "4";

        int[] ints4 = getReplacementElements();
        String[] strings4 = new String[13];
        for (int i = 0; i < ints1.length; i++) strings4[i + 1] = String.valueOf(ints4[i]);
        strings4[0] = "5";

        int[] ints5 = getReplacementElements();
        String[] strings5 = new String[13];
        for (int i = 0; i < ints1.length; i++) strings5[i + 1] = String.valueOf(ints5[i]);
        strings5[0] = "6";

        int[] ints6 = getReplacementElements();
        String[] strings6 = new String[13];
        for (int i = 0; i < ints1.length; i++) strings6[i + 1] = String.valueOf(ints6[i]);
        strings6[0] = "7";

        int[] ints7 = getReplacementElements();
        String[] strings7 = new String[13];
        for (int i = 0; i < ints1.length; i++) strings7[i + 1] = String.valueOf(ints7[i]);
        strings7[0] = "8";

        int[] ints8 = getReplacementElements();
        String[] strings8 = new String[13];
        for (int i = 0; i < ints1.length; i++) strings8[i + 1] = String.valueOf(ints8[i]);
        strings8[0] = "9";

        int[] ints9 = getReplacementElements();
        String[] strings9 = new String[13];
        for (int i = 0; i < ints1.length; i++) strings9[i + 1] = String.valueOf(ints9[i]);
        strings9[0] = "10";

        int[] sumInts = new int[12];
        for (int i = 0; i < ints1.length; i++)
            sumInts[i] = ints[i] + ints1[i] + ints2[i] + ints3[i] + ints4[i] + ints5[i] + ints6[i] + ints7[i] + ints8[i] + ints9[i];
        String[] sumStrings = new String[13];
        for (int i = 0; i < sumInts.length; i++) sumStrings[i + 1] = String.valueOf(sumInts[i]);
        sumStrings[0] = "Число отказов в 10 опытах";


        String[][] arrayStr = { strings, strings1, strings2, strings3, strings4, strings5, strings6, strings7, strings8, strings9, sumStrings };

        ObservableList<String[]> obsList = FXCollections.observableArrayList();
        obsList.addAll(arrayStr);

        tableView2.setItems(obsList);

    }


    private void populateTable(int T) {

        String[] rowsName = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Число отказов в 10 опытах"};

        int[] lst1 = rndMain(T);
        String[] str1 = new String[13];
        for (int i = 0; i < lst1.length; i++) str1[i + 1] = String.valueOf(lst1[i]);
        str1[0] = rowsName[0];

        int[] lst2 = rndMain(T);
        String[] str2 = new String[13];
        for (int i = 0; i < lst2.length; i++) str2[i + 1] = String.valueOf(lst2[i]);
        str2[0] = rowsName[1];

        int[] lst3 = rndMain(T);
        String[] str3 = new String[13];
        for (int i = 0; i < lst3.length; i++) str3[i + 1] = String.valueOf(lst3[i]);
        str3[0] = rowsName[2];

        int[] lst4 = rndMain(T);
        String[] str4 = new String[13];
        for (int i = 0; i < lst4.length; i++) str4[i + 1] = String.valueOf(lst4[i]);
        str4[0] = rowsName[3];

        int[] lst5 = rndMain(T);
        String[] str5 = new String[13];
        for (int i = 0; i < lst5.length; i++) str5[i + 1] = String.valueOf(lst5[i]);
        str5[0] = rowsName[4];

        int[] lst6 = rndMain(T);
        String[] str6 = new String[13];
        for (int i = 0; i < lst6.length; i++) str6[i + 1] = String.valueOf(lst6[i]);
        str6[0] = rowsName[5];

        int[] lst7 = rndMain(T);
        String[] str7 = new String[13];
        for (int i = 0; i < lst7.length; i++) str7[i + 1] = String.valueOf(lst7[i]);
        str7[0] = rowsName[6];

        int[] lst8 = rndMain(T);
        String[] str8 = new String[13];
        for (int i = 0; i < lst8.length; i++) str8[i + 1] = String.valueOf(lst8[i]);
        str8[0] = rowsName[7];

        int[] lst9 = rndMain(T);
        String[] str9 = new String[13];
        for (int i = 0; i < lst9.length; i++) str9[i + 1] = String.valueOf(lst9[i]);
        str9[0] = rowsName[8];

        int[] lst10 = rndMain(T);
        String[] str10 = new String[13];
        for (int i = 0; i < lst10.length; i++) str10[i + 1] = String.valueOf(lst10[i]);
        str10[0] = rowsName[9];

        int[] sumLst = new int[12];
        for (int i = 0; i < 12; i++)
            sumLst[i] = lst1[i] + lst2[i] + lst3[i] + lst4[i] + lst5[i] + lst6[i] + lst7[i] + lst8[i] + lst9[i] + lst10[i];
        String[] sumStr = new String[13];
        for (int i = 0; i < sumLst.length; i++) sumStr[i + 1] = String.valueOf(sumLst[i]);
        sumStr[0] = rowsName[10];


        String[][] arrStr = { str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, sumStr };

        ObservableList<String[]> observableList = FXCollections.observableArrayList();
        observableList.addAll(arrStr);

        tableView1.setItems(observableList);

    }

}
