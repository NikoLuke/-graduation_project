package labwork1;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.*;

import static labwork1.Laws.getString;

public class LabWorkController implements Initializable {

    @FXML
    private TableView<Integer> tableView1;

    @FXML
    private TableView<List> tableView2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<String> list1 = Arrays.asList(getString());
        List<String> list2 = Arrays.asList(getString());
        List<String> list3 = Arrays.asList(getString());
        List<String> list4 = Arrays.asList(getString());
        List<String> list5 = Arrays.asList(getString());
        List<String> list6 = Arrays.asList(getString());
        List<String> list7 = Arrays.asList(getString());
        List<String> list8 = Arrays.asList(getString());
        List<String> list9 = Arrays.asList(getString());
        List<String> list10 = Arrays.asList(getString());

        for (int i = 0; i < list1.size(); i++) {
            tableView1.getItems().add(i);
        }

        TableColumn<Integer, String> testNumber = new TableColumn<>("Число отказавших элементов за интервал");
        TableColumn<Integer, String> col1 = new TableColumn<>("1");
        TableColumn<Integer, String> col2 = new TableColumn<>("2");
        TableColumn<Integer, String> col3 = new TableColumn<>("3");
        TableColumn<Integer, String> col4 = new TableColumn<>("4");
        TableColumn<Integer, String> col5 = new TableColumn<>("5");
        TableColumn<Integer, String> col6 = new TableColumn<>("6");
        TableColumn<Integer, String> col7 = new TableColumn<>("7");
        TableColumn<Integer, String> col8 = new TableColumn<>("8");
        TableColumn<Integer, String> col9 = new TableColumn<>("9");
        TableColumn<Integer, String> col10 = new TableColumn<>("10");

        testNumber.setCellValueFactory((TableColumn.CellDataFeatures<Integer, String> cellData) -> {
//            Integer rowIndex = cellData.getValue();
            return new ReadOnlyStringWrapper(list1.get(0));
        });

        col1.setCellValueFactory((TableColumn.CellDataFeatures<Integer, String> cellData) -> {
            Integer rowIndex = cellData.getValue();
            return new ReadOnlyStringWrapper(list1.get(rowIndex));
        });

        col2.setCellValueFactory((TableColumn.CellDataFeatures<Integer, String> cellData) -> {
            Integer rowIndex = cellData.getValue();
            return new ReadOnlyStringWrapper(list2.get(rowIndex));
        });

        col3.setCellValueFactory((TableColumn.CellDataFeatures<Integer, String> cellData) -> {
            Integer rowIndex = cellData.getValue();
            return new ReadOnlyStringWrapper(list3.get(rowIndex));
        });

        col4.setCellValueFactory((TableColumn.CellDataFeatures<Integer, String> cellData) -> {
            Integer rowIndex = cellData.getValue();
            return new ReadOnlyStringWrapper(list4.get(rowIndex));
        });

        col5.setCellValueFactory((TableColumn.CellDataFeatures<Integer, String> cellData) -> {
            Integer rowIndex = cellData.getValue();
            return new ReadOnlyStringWrapper(list5.get(rowIndex));
        });

        col6.setCellValueFactory((TableColumn.CellDataFeatures<Integer, String> cellData) -> {
            Integer rowIndex = cellData.getValue();
            return new ReadOnlyStringWrapper(list6.get(rowIndex));
        });

        col7.setCellValueFactory((TableColumn.CellDataFeatures<Integer, String> cellData) -> {
            Integer rowIndex = cellData.getValue();
            return new ReadOnlyStringWrapper(list7.get(rowIndex));
        });

        col8.setCellValueFactory((TableColumn.CellDataFeatures<Integer, String> cellData) -> {
            Integer rowIndex = cellData.getValue();
            return new ReadOnlyStringWrapper(list8.get(rowIndex));
        });

        col9.setCellValueFactory((TableColumn.CellDataFeatures<Integer, String> cellData) -> {
            Integer rowIndex = cellData.getValue();
            return new ReadOnlyStringWrapper(list9.get(rowIndex));
        });

        col10.setCellValueFactory((TableColumn.CellDataFeatures<Integer, String> cellData) -> {
            Integer rowIndex = cellData.getValue();
            return new ReadOnlyStringWrapper(list10.get(rowIndex));
        });

        tableView1.getColumns().addAll(testNumber, col1, col2, col3, col4, col5, col6, col7, col8, col9, col10);



    }

}
