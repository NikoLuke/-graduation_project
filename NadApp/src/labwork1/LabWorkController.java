package labwork1;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.*;

import static labwork1.Laws.getString;
import static labwork1.Laws.rndMain;

public class LabWorkController implements Initializable {

    @FXML
    private TableView<String[]> tableView1;

    @FXML
    private Label label;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String[] strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Число отказов в 10 опытах"};
        String[] columnsName = {"Номер опыта", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        ArrayList<String> colName = new ArrayList<>();
        Collections.addAll(colName, columnsName);

        int[] lst1 = rndMain();
        int[] lst2 = rndMain();
        int[] lst3 = rndMain();
        int[] lst4 = rndMain();
        int[] lst5 = rndMain();
        int[] lst6 = rndMain();
        int[] lst7 = rndMain();
        int[] lst8 = rndMain();
        int[] lst9 = rndMain();
        int[] lst10 = rndMain();


        String[] strings1 = new String[12];
        String[] strings2 = new String[12];
        String[] strings3 = new String[12];
        String[] strings4 = new String[12];
        String[] strings5 = new String[12];
        String[] strings6 = new String[12];
        String[] strings7 = new String[12];
        String[] strings8 = new String[12];
        String[] strings9 = new String[12];
        String[] strings10 = new String[12];
        String[] strings11 = new String[12];
        int[] sum = new int[12];

        for (int i = 0; i < 12; i++) {
            sum[i] = lst1[i] + lst2[i] + lst3[i] + lst4[i] + lst5[i] + lst6[i] + lst7[i] + lst8[i] + lst9[i] + lst10[i];
            strings1[i] = String.valueOf(lst1[i]);
            strings2[i] = String.valueOf(lst2[i]);
            strings3[i] = String.valueOf(lst3[i]);
            strings4[i] = String.valueOf(lst4[i]);
            strings5[i] = String.valueOf(lst5[i]);
            strings6[i] = String.valueOf(lst6[i]);
            strings7[i] = String.valueOf(lst7[i]);
            strings8[i] = String.valueOf(lst8[i]);
            strings9[i] = String.valueOf(lst9[i]);
            strings10[i] = String.valueOf(lst10[i]);
            strings11[i] = String.valueOf(sum[i]);
        }

        ArrayList<String> wer = new ArrayList<>();
        wer.add(Arrays.toString(getString()));
//        wer.add(0, strings[0]);
//        String[] wer2 = wer.toArray(new String[0]);
//        System.out.println(wer);

        ArrayList<String> wer3 = new ArrayList<>();
        wer3.add(Arrays.toString(getString()));


        List<String> list1 = Arrays.asList(strings1);
        ArrayList<String> arrayList1 = new ArrayList<>(list1);
        arrayList1.add(0, strings[0]);
        String[] str1 = arrayList1.toArray(new String[0]);

        List<String> list2 = Arrays.asList(strings2);
        ArrayList<String> arrayList2 = new ArrayList<>(list2);
        arrayList2.add(0, strings[1]);
        String[] str2 = arrayList2.toArray(new String[0]);

        List<String> list3 = Arrays.asList(strings3);
        ArrayList<String> arrayList3 = new ArrayList<>(list3);
        arrayList3.add(0, strings[2]);
        String[] str3 = arrayList3.toArray(new String[0]);

        List<String> list4 = Arrays.asList(strings4);
        ArrayList<String> arrayList4 = new ArrayList<>(list4);
        arrayList4.add(0, strings[3]);
        String[] str4 = arrayList4.toArray(new String[0]);

        List<String> list5 = Arrays.asList(strings5);
        ArrayList<String> arrayList5 = new ArrayList<>(list5);
        arrayList5.add(0, strings[4]);
        String[] str5 = arrayList5.toArray(new String[0]);

        List<String> list6 = Arrays.asList(strings6);
        ArrayList<String> arrayList6 = new ArrayList<>(list6);
        arrayList6.add(0, strings[5]);
        String[] str6 = arrayList6.toArray(new String[0]);

        List<String> list7 = Arrays.asList(strings7);
        ArrayList<String> arrayList7 = new ArrayList<>(list7);
        arrayList7.add(0, strings[6]);
        String[] str7 = arrayList7.toArray(new String[0]);

        List<String> list8 = Arrays.asList(strings8);
        ArrayList<String> arrayList8 = new ArrayList<>(list8);
        arrayList8.add(0, strings[7]);
        String[] str8 = arrayList8.toArray(new String[0]);

        List<String> list9 = Arrays.asList(strings9);
        ArrayList<String> arrayList9 = new ArrayList<>(list9);
        arrayList9.add(0, strings[8]);
        String[] str9 = arrayList9.toArray(new String[0]);

        List<String> list10 = Arrays.asList(strings10);
        ArrayList<String> arrayList10 = new ArrayList<>(list10);
        arrayList10.add(0, strings[9]);
        String[] str10 = arrayList10.toArray(new String[0]);

        List<String> list11 = Arrays.asList(strings11);
        ArrayList<String> arrayList11 = new ArrayList<>(list11);
        arrayList11.add(0, strings[10]);
        String[] str11 = arrayList11.toArray(new String[0]);
//
////        for (int i = 0; i < list1.size(); i++) {
////            tableView1.getItems().add(i);
////        }
//
//
//        List<List<String>> tableArray = new ArrayList<>();
//        tableArray.add(columnsName);
//        tableArray.add(arrayList1);
//        tableArray.add(arrayList2);
//        tableArray.add(arrayList3);
//        tableArray.add(arrayList4);
//        tableArray.add(arrayList5);
//        tableArray.add(arrayList6);
//        tableArray.add(arrayList7);
//        tableArray.add(arrayList8);
//        tableArray.add(arrayList9);
//        tableArray.add(arrayList10);
//        tableArray.add(arrayList11);

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
                                str11};

        ArrayList<ArrayList<String>> stringArr = new ArrayList<>();
        stringArr.add(wer);
        stringArr.add(wer3);
        System.out.println(stringArr);





        ObservableList<String[]> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(arrayTable));
        data.remove(0);
        for (int i = 0; i < strings1.length; i++) {
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

//
//        TableColumn<Integer, String> testNumber = new TableColumn<>("Число отказавших элементов за интервал");
//        testNumber.setSortable(false);
//        TableColumn<Integer, String> col1 = new TableColumn<>("1");
//        col1.setSortable(false);
//        col1.setReorderable(false);
//        col1.setResizable(false);
//        col1.setMaxWidth(30);
//        TableColumn<Integer, String> col2 = new TableColumn<>("2");
//        col2.setSortable(false);
//        TableColumn<Integer, String> col3 = new TableColumn<>("3");
//        col3.setSortable(false);
//        TableColumn<Integer, String> col4 = new TableColumn<>("4");
//        col4.setSortable(false);
//        TableColumn<Integer, String> col5 = new TableColumn<>("5");
//        col5.setSortable(false);
//        TableColumn<Integer, String> col6 = new TableColumn<>("6");
//        col6.setSortable(false);
//        TableColumn<Integer, String> col7 = new TableColumn<>("7");
//        col7.setSortable(false);
//        TableColumn<Integer, String> col8 = new TableColumn<>("8");
//        col8.setSortable(false);
//        TableColumn<Integer, String> col9 = new TableColumn<>("9");
//        col9.setSortable(false);
//        TableColumn<Integer, String> col10 = new TableColumn<>("10");
//        col10.setSortable(false);
//        TableColumn<Integer, String> sumRejections = new TableColumn<>("Число отказов в 10 опытах");
//        sumRejections.setSortable(false);
//
//        testNumber.setCellValueFactory((TableColumn.CellDataFeatures<Integer, String> cellData) -> {
//            Integer rowIndex = cellData.getValue();
//            return new ReadOnlyStringWrapper(list.get(rowIndex));
//        });
//
//        col1.setCellValueFactory((TableColumn.CellDataFeatures<Integer, String> cellData) -> {
//            Integer rowIndex = cellData.getValue();
//            return new ReadOnlyStringWrapper(list1.get(rowIndex));
//        });
//
//        col2.setCellValueFactory((TableColumn.CellDataFeatures<Integer, String> cellData) -> {
//            Integer rowIndex = cellData.getValue();
//            return new ReadOnlyStringWrapper(list2.get(rowIndex));
//        });
//
//        col3.setCellValueFactory((TableColumn.CellDataFeatures<Integer, String> cellData) -> {
//            Integer rowIndex = cellData.getValue();
//            return new ReadOnlyStringWrapper(list3.get(rowIndex));
//        });
//
//        col4.setCellValueFactory((TableColumn.CellDataFeatures<Integer, String> cellData) -> {
//            Integer rowIndex = cellData.getValue();
//            return new ReadOnlyStringWrapper(list4.get(rowIndex));
//        });
//
//        col5.setCellValueFactory((TableColumn.CellDataFeatures<Integer, String> cellData) -> {
//            Integer rowIndex = cellData.getValue();
//            return new ReadOnlyStringWrapper(list5.get(rowIndex));
//        });
//
//        col6.setCellValueFactory((TableColumn.CellDataFeatures<Integer, String> cellData) -> {
//            Integer rowIndex = cellData.getValue();
//            return new ReadOnlyStringWrapper(list6.get(rowIndex));
//        });
//
//        col7.setCellValueFactory((TableColumn.CellDataFeatures<Integer, String> cellData) -> {
//            Integer rowIndex = cellData.getValue();
//            return new ReadOnlyStringWrapper(list7.get(rowIndex));
//        });
//
//        col8.setCellValueFactory((TableColumn.CellDataFeatures<Integer, String> cellData) -> {
//            Integer rowIndex = cellData.getValue();
//            return new ReadOnlyStringWrapper(list8.get(rowIndex));
//        });
//
//        col9.setCellValueFactory((TableColumn.CellDataFeatures<Integer, String> cellData) -> {
//            Integer rowIndex = cellData.getValue();
//            return new ReadOnlyStringWrapper(list9.get(rowIndex));
//        });
//
//        col10.setCellValueFactory((TableColumn.CellDataFeatures<Integer, String> cellData) -> {
//            Integer rowIndex = cellData.getValue();
//            return new ReadOnlyStringWrapper(list10.get(rowIndex));
//        });
//
//        sumRejections.setCellValueFactory((TableColumn.CellDataFeatures<Integer, String> cellData) -> {
//            Integer rowIndex = cellData.getValue();
//            return new ReadOnlyStringWrapper(list11.get(rowIndex));
//        });
//
//        tableView1.getColumns().addAll(testNumber, col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, sumRejections);
//


    }

}
