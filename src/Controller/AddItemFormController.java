package Controller;

import Model.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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


    ArrayList<Item> itemArrayList= new ArrayList<>();

    public void btnAddItemOnAction(ActionEvent actionEvent) {



        System.out.println("Add Item Event");

        String code = txtCode.getText();
        String name = txtName.getText();
        String desc = txtDesc.getText();
        String qty = txtQty.getText();
        double price= Double.parseDouble(txtPrice.getText());

        itemArrayList.add(new Item(code,name,desc,qty,price));

        System.out.println(itemArrayList);


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
            System.out.println("You need select a data before deleting.");
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
