package Controller;

import Model.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class AddItemFormController {

    public TextField txtCode;
    public TextField txtQty;
    public TextField txtName;
    public TextField txtPrice;
    public TableView tblItems;
    public TableColumn colCode;
    public TableColumn colName;
    public TableColumn colQty;
    public TableColumn colPrice;

    ArrayList<Item> itemArrayList= new ArrayList<>();

    public void btnAddItemOnAction(ActionEvent actionEvent) {



        System.out.println("Add Item Event");

        String code = txtCode.getText();
        String name = txtName.getText();
        String qty = txtQty.getText();
        double price= Double.parseDouble(txtPrice.getText());

        itemArrayList.add(new Item(code,name,qty,price));

        System.out.println(itemArrayList);

        loadTable();
    }


    private void loadTable(){

        ObservableList<Item> itemObservableList= FXCollections.observableArrayList();

        itemArrayList.forEach(obj->{
            itemObservableList.add(obj);
        });

        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        tblItems.setItems(itemObservableList);


    }

}
