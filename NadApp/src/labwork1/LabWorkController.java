package labwork1;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.*;

import static labwork1.Laws.rndMain;

public class LabWorkController implements Initializable, InitialData {

    @FXML
    private JFXButton buttonEnter;

    @FXML
    private JFXTextField textField;

    @FXML
    private TableView<String[]> tableView1;

    @FXML
    private TableView<String[]> tableView2;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

//        buttonEnter.setOnAction(event -> {
//            if (textField.getText() != null && !textField.getText().isEmpty()) {
//                int time = Integer.parseInt(textField.getText());
//                switch (time) {
//                    case T1: setDataToTable(rndMain(T1));
//                        break;
//                    case T2: setDataToTable(rndMain(T2));
//                        break;
//
//                    }
//            }
//        });





        String[] rowsName = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Число отказов в 10 опытах"};
        String[] columnsName = {"Номер опыта", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};

        int[] lst1 = rndMain(T1);
        String[] str1 = new String[13];
        for (int i = 0; i < lst1.length; i++) str1[i + 1] = String.valueOf(lst1[i]);
        str1[0] = rowsName[0];

        int[] lst2 = rndMain(T1);
        String[] str2 = new String[13];
        for (int i = 0; i < lst2.length; i++) str2[i + 1] = String.valueOf(lst2[i]);
        str2[0] = rowsName[1];

        int[] lst3 = rndMain(T1);
        String[] str3 = new String[13];
        for (int i = 0; i < lst3.length; i++) str3[i + 1] = String.valueOf(lst3[i]);
        str3[0] = rowsName[2];

        int[] lst4 = rndMain(T1);
        String[] str4 = new String[13];
        for (int i = 0; i < lst4.length; i++) str4[i + 1] = String.valueOf(lst4[i]);
        str4[0] = rowsName[3];

        int[] lst5 = rndMain(T1);
        String[] str5 = new String[13];
        for (int i = 0; i < lst5.length; i++) str5[i + 1] = String.valueOf(lst5[i]);
        str5[0] = rowsName[4];

        int[] lst6 = rndMain(T1);
        String[] str6 = new String[13];
        for (int i = 0; i < lst6.length; i++) str6[i + 1] = String.valueOf(lst6[i]);
        str6[0] = rowsName[5];

        int[] lst7 = rndMain(T1);
        String[] str7 = new String[13];
        for (int i = 0; i < lst7.length; i++) str7[i + 1] = String.valueOf(lst7[i]);
        str7[0] = rowsName[6];

        int[] lst8 = rndMain(T1);
        String[] str8 = new String[13];
        for (int i = 0; i < lst8.length; i++) str8[i + 1] = String.valueOf(lst8[i]);
        str8[0] = rowsName[7];

        int[] lst9 = rndMain(T1);
        String[] str9 = new String[13];
        for (int i = 0; i < lst9.length; i++) str9[i + 1] = String.valueOf(lst9[i]);
        str9[0] = rowsName[8];

        int[] lst10 = rndMain(T1);
        String[] str10 = new String[13];
        for (int i = 0; i < lst10.length; i++) str10[i + 1] = String.valueOf(lst10[i]);
        str10[0] = rowsName[9];

        int[] sumLst = new int[12];
        for (int i = 0; i < 12; i++)
            sumLst[i] = lst1[i] + lst2[i] + lst3[i] + lst4[i] + lst5[i] + lst6[i] + lst7[i] + lst8[i] + lst9[i] + lst10[i];
        String[] sumStr = new String[13];
        for (int i = 0; i < sumLst.length; i++) sumStr[i + 1] = String.valueOf(sumLst[i]);
        sumStr[0] = rowsName[10];

//        ArrayList<Integer> arrInt1 = new ArrayList<>();
//        for (int i: lst1) arrInt1.add(i);
//
//        ArrayList<String> arrStr1 = new ArrayList<>();
//        for (Integer i : arrInt1) arrStr1.add(String.valueOf(i));
//
//        arrStr1.add(0, rowsName[0]);
//        String[] str1 = arrStr1.toArray(new String[0]);

        String[][] arrayTable = {columnsName,
                                str1,
                                str2,
                                str3,
                                str4,
                                str5,
                                str6,
                                str7,
                                str8,
                                str9,
                                str10,
                                sumStr};

        ObservableList<String[]> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(arrayTable));
        data.remove(0);

        for (int i = 0; i < columnsName.length; i++) {
            TableColumn<String[], String> tableColumn = new TableColumn<>(columnsName[i]);
            tableColumn.setSortable(false);
            tableColumn.setReorderable(false);
            tableColumn.setResizable(true);
//            tableColumn.setPrefWidth(40);

            final int colIndex = i;

            tableColumn.setCellValueFactory(p -> new SimpleStringProperty(p.getValue()[colIndex]));

            tableView1.getColumns().add(tableColumn);
        }

        tableView1.setItems(data);

    }


//    private void setDataToTable(int[] a) {
//        String rowsName = "1";
//        int[] lst1 = a;
//        String[] str1 = new String[13];
//        for (int i = 0; i < lst1.length; i++) str1[i + 1] = String.valueOf(lst1[i]);
//        str1[0] = rowsName;
//
//    }

}
