package Controller;

import Model.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.Arrays;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;

public class AddItemFormController {

    public TextField txtCode;
    public TextField txtQty;
    public TextField txtName;
    public TextField txtPrice;
    public TextField txtDesc;
    public TableView tblItems;
    public TableColumn colCode;
    public TableColumn colName;
    public TableColumn colQty;
    public TableColumn colPrice;
    public TableColumn colDesc;
    public Button btnDelete;


    ArrayList<Item> itemArrayList= new ArrayList<>();

    public void btnAddItemOnAction(ActionEvent actionEvent) {


        String code = txtCode.getText();
        String name = txtName.getText();
        String desc = txtDesc.getText();
        String qty = txtQty.getText();
        double price= Double.parseDouble(txtPrice.getText());

        if (code.isEmpty() || name.isEmpty() || qty.isEmpty() || price==0){

            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.WARNING);
            a.show();
            a.setTitle("Warning");
            a.setHeaderText("Please Fill out the fields!");
            return;
        } else {

            itemArrayList.add(new Item(code, name, desc, qty, price));

            System.out.println(itemArrayList);

            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.CONFIRMATION);
            a.show();
            a.setTitle("Item Added");
            a.setHeaderText("Item Added!");
            a.setContentText("Item has been successfully added.");
        }


    }


    private void loadTable(){

        ObservableList<Item> itemObservableList= FXCollections.observableArrayList();

        itemArrayList.forEach(obj->{
            itemObservableList.add(obj);
        });

        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("desc"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        tblItems.setItems(itemObservableList);


    }

    public void btnViewItemsOnAction(ActionEvent actionEvent) {
        loadTable();
    }

    public void btnDeleteItemOnAction(ActionEvent actionEvent) {
        TableView.TableViewSelectionModel<Item> selectionModel = tblItems.getSelectionModel();
        if(selectionModel.isEmpty()){
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.ERROR);
            a.show();
            a.setTitle("Error");
            a.setHeaderText("Please select an item before deleting!");
        }

        ObservableList<Integer> list = selectionModel.getSelectedIndices();
        Integer[] selectedIndices = new Integer[list.size()];
        selectedIndices = list.toArray(selectedIndices);

        Arrays.sort(selectedIndices);

        for(int i = selectedIndices.length - 1; i >= 0; i--){
            selectionModel.clearSelection(selectedIndices[i].intValue());
            tblItems.getItems().remove(selectedIndices[i].intValue());
        }


    }
}
