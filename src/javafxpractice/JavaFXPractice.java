/*****************
 * @author lethv *
 *****************/

package javafxpractice;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class JavaFXPractice extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        // // // // // // // // // // // // // // // // //
        // Initializing Inventory, Products, and Parts  //
        // // // // // // // // // // // // // // // // //
        
        Inhouse part1 = new Inhouse(1, "One", 1.5, 5, 1, 5, 100);
        Inhouse part2 = new Inhouse(2, "Two", 3.0, 5, 1, 5, 100);
        Inhouse part3 = new Inhouse(3, "Three", 4.5, 5, 1, 5, 200);
        Inhouse part4 = new Inhouse(4, "Four", 6.0, 5, 1, 5, 200);
        Outsourced part5 = new Outsourced(5, "Five", 9.99, 5, 1, 5, "Google");
        Outsourced part6 = new Outsourced(6, "Six", 100, 5, 1, 5, "Google");
        Outsourced part7 = new Outsourced(7, "Seven", 100, 5, 1, 5, "Microsoft");
        Outsourced part8 = new Outsourced(8, "Eight", 2, 5, 1, 5, "Microsoft");
        
        Product product1 = new Product(1, "Ones", 1.5, 5, 1, 5, part1);
        Product product2 = new Product(2, "Twos", 2.5, 5, 1, 5, part3);
        Product product3 = new Product(3, "Threes", 3.5, 5, 1, 5, part5);
        Product product4 = new Product(4, "Fours", 4.5, 5, 1, 5, part7);
        
        Inventory inventory = new Inventory();
        
        inventory.addPart(part1);
        inventory.addPart(part2);
        inventory.addPart(part3);
        inventory.addPart(part4);
        inventory.addPart(part5);
        inventory.addPart(part6);
        inventory.addPart(part7);
        inventory.addPart(part8);
        
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);
        inventory.addProduct(product4);
        
        // // // // // // // // // // // //
        // Initializing Default Values   //
        // // // // // // // // // // // //
        
        Alert minMaxAlert = new Alert(AlertType.WARNING, "The minimum value cannot be greater than the maximum value.");
        Alert cancelConfirmAlert = new Alert(AlertType.CONFIRMATION, "The minimum value cannot be greater than the maximum value.");
        Alert deleteConfirmAlert = new Alert(AlertType.CONFIRMATION, "The minimum value cannot be greater than the maximum value.");
        
        Insets defaultPadding = new Insets(20);
        Insets defaultMargin = new Insets(20);

        // // // // // // // // // //
        // Initializing Base Panes //
        // // // // // // // // // //

        BorderPane root = new BorderPane();
        root.setPadding(defaultPadding);

        BorderPane addPartPane = new BorderPane();
        addPartPane.setPadding(defaultPadding);

        BorderPane addProductPane = new BorderPane();
        addProductPane.setPadding(defaultPadding);
        
        // // // // // // // // //
        // Initializing Scenes  //
        // // // // // // // // //

        Scene mainScene = new Scene(root, 1200, 600);

        Scene addPartScene = new Scene(addPartPane, 500, 520);

        Scene addProductScene =  new Scene(addProductPane, 1200, 600);

        // // // // // // // // // // // // // //
        // Pane for Adding & Modifying Parts   //
        // // // // // // // // // // // // // //
        
        HBox addPartTop = new HBox();
        GridPane addPartGrid = new GridPane();
        addPartGrid.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderStroke.THIN)));
        HBox addPartBottom = new HBox(20);

        addPartPane.setTop(addPartTop);
        addPartPane.setCenter(addPartGrid);
        addPartPane.setBottom(addPartBottom);

        Label addPartHeader = new Label("Add Part");
        addPartHeader.setStyle("-fx-font: normal bold 18px 'monospace' ");
        HBox.setMargin(addPartHeader, new Insets(0, 40, 20, 20));

        ToggleGroup addPartRadio = new ToggleGroup();

        RadioButton addPartRadio1 = new RadioButton("In-House");
        HBox.setMargin(addPartRadio1, new Insets(0, 20, 20, 0));
        addPartRadio1.setToggleGroup(addPartRadio);
        addPartRadio1.setSelected(true);

        RadioButton addPartRadio2 = new RadioButton("Outsourced");
        HBox.setMargin(addPartRadio2, new Insets(0, 10, 20, 0));
        addPartRadio2.setToggleGroup(addPartRadio);

        addPartTop.getChildren().addAll(addPartHeader, addPartRadio1, addPartRadio2);

        Label addPartIDLabel = new Label("ID");
        addPartIDLabel.setPrefWidth(160);
        GridPane.setMargin(addPartIDLabel, new Insets(20, 0, 10, 20));
        GridPane.setConstraints(addPartIDLabel, 0, 0);

        TextField addPartIDField = new TextField();
        addPartIDField.setPrefWidth(240);
        GridPane.setHgrow(addPartIDField, Priority.ALWAYS);
        GridPane.setMargin(addPartIDField, new Insets(20, 20, 10, 0));
        GridPane.setConstraints(addPartIDField, 1, 0);
        addPartIDField.setStyle("-fx-control-inner-background: lightgray;");
        addPartIDField.setDisable(true);
                
        Label addPartNameLabel = new Label("Name");
        addPartNameLabel.setPrefWidth(160);
        GridPane.setMargin(addPartNameLabel, new Insets(10, 0, 10, 20));
        GridPane.setConstraints(addPartNameLabel, 0, 1);

        TextField addPartNameField = new TextField();
        addPartNameField.setPrefWidth(240);
        GridPane.setHgrow(addPartNameField, Priority.ALWAYS);
        GridPane.setMargin(addPartNameField, new Insets(10, 20, 10, 0));
        GridPane.setConstraints(addPartNameField, 1, 1);

        Label addPartInventoryLabel = new Label("Inventory");
        addPartInventoryLabel.setPadding(new Insets(10, 20, 10, 20));
        addPartInventoryLabel.setPrefWidth(160);
        GridPane.setConstraints(addPartInventoryLabel, 0, 2);

        TextField addPartInventoryField = new TextField();
        addPartInventoryField.setPrefWidth(240);
        GridPane.setHgrow(addPartInventoryField, Priority.ALWAYS);
        GridPane.setMargin(addPartInventoryField, new Insets(10, 20, 10, 0));
        GridPane.setConstraints(addPartInventoryField, 1, 2);

        Label addPartPriceLabel = new Label("Price per Unit");
        addPartPriceLabel.setPadding(new Insets(10, 20, 10, 20));
        addPartPriceLabel.setPrefWidth(160);
        GridPane.setConstraints(addPartPriceLabel, 0, 3);

        TextField addPartPriceField = new TextField();
        addPartPriceField.setPrefWidth(240);
        GridPane.setHgrow(addPartPriceField, Priority.ALWAYS);
        GridPane.setMargin(addPartPriceField, new Insets(10, 20, 10, 0));
        GridPane.setConstraints(addPartPriceField, 1, 3);

        Label addPartMaxLabel = new Label("Max");
        addPartMaxLabel.setPadding(new Insets(10, 20, 10, 20));
        addPartMaxLabel.setPrefWidth(160);
        GridPane.setConstraints(addPartMaxLabel, 0, 4);

        TextField addPartMaxField = new TextField();
        addPartMaxField.setPrefWidth(240);
        GridPane.setHgrow(addPartMaxField, Priority.ALWAYS);
        GridPane.setMargin(addPartMaxField, new Insets(10, 20, 10, 0));
        GridPane.setConstraints(addPartMaxField, 1, 4);

        Label addPartMinLabel = new Label("Min");
        addPartMinLabel.setPadding(new Insets(10, 20, 10, 20));
        addPartMinLabel.setPrefWidth(160);
        GridPane.setConstraints(addPartMinLabel, 0, 5);

        TextField addPartMinField = new TextField();
        addPartMinField.setPrefWidth(240);
        GridPane.setHgrow(addPartMinField, Priority.ALWAYS);
        GridPane.setMargin(addPartMinField, new Insets(10, 20, 10, 0));
        GridPane.setConstraints(addPartMinField, 1, 5);

        Label addPartMachineIDLabel = new Label("Machine ID");
        addPartMachineIDLabel.setPadding(new Insets(10, 20, 20, 20));
        addPartMachineIDLabel.setPrefWidth(160);
        GridPane.setConstraints(addPartMachineIDLabel, 0, 6);

        TextField addPartMachineIDField = new TextField();
        addPartMachineIDField.setPrefWidth(240);
        GridPane.setHgrow(addPartMachineIDField, Priority.ALWAYS);
        GridPane.setMargin(addPartMachineIDField, new Insets(10, 20, 20, 0));
        GridPane.setConstraints(addPartMachineIDField, 1, 6);

        Label addPartCompanyNameLabel = new Label("Company Name");
        addPartCompanyNameLabel.setPadding(new Insets(10, 20, 20, 20));
        addPartCompanyNameLabel.setPrefWidth(160);
        GridPane.setConstraints(addPartCompanyNameLabel, 0, 6);

        TextField addPartCompanyNameField = new TextField();
        addPartCompanyNameField.setPrefWidth(240);
        GridPane.setHgrow(addPartCompanyNameField, Priority.ALWAYS);
        GridPane.setMargin(addPartCompanyNameField, new Insets(10, 20, 20, 0));
        GridPane.setConstraints(addPartCompanyNameField, 1, 6);

        addPartGrid.getChildren().addAll(addPartIDField, addPartNameField, addPartInventoryField, addPartPriceField, addPartMaxField, addPartMinField, addPartMachineIDField);
        addPartGrid.getChildren().addAll(addPartIDLabel, addPartNameLabel, addPartInventoryLabel, addPartPriceLabel, addPartMaxLabel, addPartMinLabel, addPartMachineIDLabel);

        addPartRadio1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                addPartGrid.getChildren().removeAll(addPartCompanyNameLabel, addPartCompanyNameField);
                addPartGrid.getChildren().addAll(addPartMachineIDLabel, addPartMachineIDField);
            }
        });

        addPartRadio2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                addPartGrid.getChildren().removeAll(addPartMachineIDLabel, addPartMachineIDField);
                addPartGrid.getChildren().addAll(addPartCompanyNameLabel, addPartCompanyNameField);
            }
        });

        addPartBottom.setAlignment(Pos.CENTER_RIGHT);

        Button addPartSaveBTN = new Button("Save");
        HBox.setMargin(addPartSaveBTN, new Insets(20, 0, 0, 0));
        addPartSaveBTN.setPrefWidth(80);
        addPartSaveBTN.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                int partToAddID = Integer.parseInt(addPartIDField.getCharacters().toString());
                String partToAddName = addPartNameField.getCharacters().toString();
                Double partToAddPrice = Double.parseDouble(addPartPriceField.getCharacters().toString());
                int partToAddInventory = Integer.parseInt(addPartInventoryField.getCharacters().toString());
                int partToAddMin = Integer.parseInt(addPartMinField.getCharacters().toString());
                int partToAddMax = Integer.parseInt(addPartMaxField.getCharacters().toString());
                
                if (partToAddMin > partToAddMax) {
                    minMaxAlert.showAndWait();
                }
                
                else {
                    if (addPartRadio1.isDisabled() == false) {
                        if (addPartRadio1.isSelected()) {
                            int partToAddMachineID = Integer.parseInt(addPartMachineIDField.getCharacters().toString());
                            Inhouse inhouseToAdd = new Inhouse(partToAddID, partToAddName, partToAddPrice, partToAddInventory, partToAddMin, partToAddMax, partToAddMachineID);
                            inventory.addPart(inhouseToAdd);
                        }
                        else {
                            String partToAddCompanyName = addPartCompanyNameField.getCharacters().toString();
                            Outsourced outsourcedToAdd = new Outsourced(partToAddID, partToAddName, partToAddPrice, partToAddInventory, partToAddMin, partToAddMax, partToAddCompanyName);
                            inventory.addPart(outsourcedToAdd);
                        }
                    }
                    else {
                        Part partToModify = inventory.lookUpPart(Integer.parseInt(addPartIDField.getCharacters().toString()));
                        if (inventory.isOutsourced(partToModify)) {
                            inventory.lookUpOutsourced(partToModify.getPartID()).setName(partToAddName);
                            inventory.lookUpOutsourced(partToModify.getPartID()).setInStock(partToAddInventory);
                            inventory.lookUpOutsourced(partToModify.getPartID()).setPrice(partToAddPrice);
                            inventory.lookUpOutsourced(partToModify.getPartID()).setMax(partToAddMax);
                            inventory.lookUpOutsourced(partToModify.getPartID()).setMin(partToAddMin);
                            inventory.lookUpOutsourced(partToModify.getPartID()).setCompanyName(addPartCompanyNameField.getCharacters().toString());
                            inventory.updatePartObList();
                        }
                        else {
                            inventory.lookUpInhouse(partToModify.getPartID()).setName(partToAddName);
                            inventory.lookUpInhouse(partToModify.getPartID()).setInStock(partToAddInventory);
                            inventory.lookUpInhouse(partToModify.getPartID()).setPrice(partToAddPrice);
                            inventory.lookUpInhouse(partToModify.getPartID()).setMax(partToAddMax);
                            inventory.lookUpInhouse(partToModify.getPartID()).setMin(partToAddMin);
                            inventory.lookUpInhouse(partToModify.getPartID()).setMachineID(Integer.parseInt(addPartMachineIDField.getCharacters().toString()));
                            inventory.updatePartObList();
                        }
                    }
                
                addPartIDField.clear();
                addPartNameField.clear();
                addPartPriceField.clear();
                addPartInventoryField.clear();
                addPartMinField.clear();
                addPartMaxField.clear();
                addPartMachineIDField.clear();
                addPartCompanyNameField.clear();
                addPartRadio1.setDisable(false);
                addPartRadio2.setDisable(false);
                primaryStage.setScene(mainScene);
                primaryStage.show();
                
                }
            }
        });

        Button addPartCancelBTN = new Button("Cancel");
        HBox.setMargin(addPartCancelBTN, new Insets(20, 0, 0, 0));
        addPartCancelBTN.setPrefWidth(80);
        addPartCancelBTN.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                addPartIDField.clear();
                addPartNameField.clear();
                addPartPriceField.clear();
                addPartInventoryField.clear();
                addPartMinField.clear();
                addPartMaxField.clear();
                addPartMachineIDField.clear();
                addPartCompanyNameField.clear();
                addPartRadio1.setDisable(false);
                addPartRadio2.setDisable(false);
                
                new Alert(AlertType.CONFIRMATION, "You have canceled adding/modifying a part.").showAndWait();
                
                primaryStage.setScene(mainScene);
                primaryStage.show();
            }
        });

        addPartBottom.getChildren().addAll(addPartSaveBTN, addPartCancelBTN);
        
        // // // // // // // // // // // // // // //
        // Pane for Adding & Modifying Products   //
        // // // // // // // // // // // // // // //
        
        HBox addProductTop = new HBox();
        GridPane addProductLeft = new GridPane();
        GridPane addProductCenter = new GridPane();
        addProductCenter.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderStroke.THIN)));
        HBox addProductBottom = new HBox(20);
        addProductBottom.setAlignment(Pos.CENTER_RIGHT);

        addProductPane.setTop(addProductTop);
        addProductPane.setLeft(addProductLeft);
        addProductPane.setCenter(addProductCenter);
        addProductPane.setBottom(addProductBottom);

        Label addProductHeader = new Label("Add Product");
        addProductHeader.setStyle("-fx-font: normal bold 18px 'monospace' ");
        addProductHeader.setPadding(new Insets(0, 0, 0, 20));

        addProductTop.getChildren().addAll(addProductHeader);

        Label addProductIDLabel = new Label("ID");
        GridPane.setConstraints(addProductIDLabel, 0, 0, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setMargin(addProductIDLabel, new Insets(100, 5, 5, 5));

        TextField addProductIDField = new TextField();
        GridPane.setConstraints(addProductIDField, 1, 0, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setMargin(addProductIDField, new Insets(100, 60, 5, 5));
        addProductIDField.setDisable(true);

        Label addProductNameLabel = new Label("Name");
        GridPane.setConstraints(addProductNameLabel, 0, 1, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setMargin(addProductNameLabel, new Insets(5));

        TextField addProductNameField = new TextField();
        GridPane.setConstraints(addProductNameField, 1, 1, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setMargin(addProductNameField, new Insets(5, 60, 5, 5));

        Label addProductInventoryLabel = new Label("Inventory");
        GridPane.setConstraints(addProductInventoryLabel, 0, 2, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setMargin(addProductInventoryLabel, new Insets(5));

        TextField addProductInventoryField = new TextField();
        GridPane.setConstraints(addProductInventoryField, 1, 2, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setMargin(addProductInventoryField, new Insets(5, 60, 5, 5));

        Label addProductPriceLabel = new Label("Price");
        GridPane.setConstraints(addProductPriceLabel, 0, 3, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setMargin(addProductPriceLabel, new Insets(5));

        TextField addProductPriceField = new TextField();
        GridPane.setConstraints(addProductPriceField, 1, 3, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setMargin(addProductPriceField, new Insets(5, 60, 5, 5));

        Label addProductMaxLabel = new Label("Max");
        GridPane.setConstraints(addProductMaxLabel, 0, 4, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setMargin(addProductMaxLabel, new Insets(5));

        TextField addProductMaxField = new TextField();
        GridPane.setConstraints(addProductMaxField, 1, 4, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setMargin(addProductMaxField, new Insets(5, 60, 5, 5));

        Label addProductMinLabel = new Label("Min");
        GridPane.setConstraints(addProductMinLabel, 0, 5, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setMargin(addProductMinLabel, new Insets(5));

        TextField addProductMinField = new TextField();
        GridPane.setConstraints(addProductMinField, 1, 5, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setMargin(addProductMinField, new Insets(5, 60, 5, 5));

        addProductLeft.getChildren().addAll(addProductIDLabel, addProductNameLabel, addProductInventoryLabel, addProductPriceLabel, addProductMaxLabel, addProductMinLabel);
        addProductLeft.getChildren().addAll(addProductIDField, addProductNameField, addProductInventoryField, addProductPriceField, addProductMaxField, addProductMinField);

        Button addProductSearchBTN = new Button("Search");
        GridPane.setMargin(addProductSearchBTN, defaultMargin);
        GridPane.setConstraints(addProductSearchBTN, 0, 0, 2, 1, HPos.RIGHT, VPos.CENTER);
        addProductSearchBTN.setPrefWidth(80);
        
        TextField addProductSearchField = new TextField();
        GridPane.setMargin(addProductSearchField, new Insets(20, 40, 20, 20));
        GridPane.setConstraints(addProductSearchField, 2, 0, 2, 1);
        
        Label addProductAddPartIDHeader = new Label("Part ID");
        addProductAddPartIDHeader.setPadding(new Insets(5, 0, 5, 10));
        GridPane.setMargin(addProductAddPartIDHeader, new Insets(0, 0, 0, 20));
        GridPane.setConstraints(addProductAddPartIDHeader, 0, 1);
        addProductAddPartIDHeader.prefWidthProperty().bind(addProductCenter.widthProperty());
        addProductAddPartIDHeader.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));
        
        Label addProductAddPartNameHeader = new Label("Part Name");
        addProductAddPartNameHeader.setPadding(new Insets(5, 0, 5, 10));
        GridPane.setConstraints(addProductAddPartNameHeader, 1, 1);
        addProductAddPartNameHeader.prefWidthProperty().bind(addProductCenter.widthProperty());
        addProductAddPartNameHeader.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        Label addProductAddPartInventoryHeader = new Label("Inventory Level");
        addProductAddPartInventoryHeader.setPadding(new Insets(5, 0, 5, 10));
        GridPane.setConstraints(addProductAddPartInventoryHeader, 2, 1);
        addProductAddPartInventoryHeader.prefWidthProperty().bind(addProductCenter.widthProperty());
        addProductAddPartInventoryHeader.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        Label addProductAddPartPriceHeader = new Label("Price per Unit");
        addProductAddPartPriceHeader.setPadding(new Insets(5, 0, 5, 10));
        GridPane.setMargin(addProductAddPartPriceHeader, new Insets(0, 20, 0, 0));
        GridPane.setConstraints(addProductAddPartPriceHeader, 3, 1);
        addProductAddPartPriceHeader.prefWidthProperty().bind(addProductCenter.widthProperty());
        addProductAddPartPriceHeader.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        Button addProductAddPartBTN = new  Button("Add");
        GridPane.setConstraints(addProductAddPartBTN, 0, 3, 4, 1, HPos.RIGHT, VPos.CENTER);
        GridPane.setMargin(addProductAddPartBTN, new Insets(10, 40, 10, 40));
        addProductAddPartBTN.setPrefWidth(80);

        Label addProductRemovePartIDHeader = new Label("Part ID");
        addProductRemovePartIDHeader.setPadding(new Insets(5, 0, 5, 10));
        GridPane.setMargin(addProductRemovePartIDHeader, new Insets(0, 0, 0, 20));
        GridPane.setConstraints(addProductRemovePartIDHeader, 0, 5);
        addProductRemovePartIDHeader.prefWidthProperty().bind(addProductCenter.widthProperty());
        addProductRemovePartIDHeader.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        Label addProductRemovePartNameHeader = new Label("Part Name");
        addProductRemovePartNameHeader.setPadding(new Insets(5, 0, 5, 10));
        GridPane.setConstraints(addProductRemovePartNameHeader, 1, 5);
        addProductRemovePartNameHeader.prefWidthProperty().bind(addProductCenter.widthProperty());
        addProductRemovePartNameHeader.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        Label addProductRemovePartInventoryHeader = new Label("Inventory Level");
        addProductRemovePartInventoryHeader.setPadding(new Insets(5, 0, 5, 10));
        GridPane.setConstraints(addProductRemovePartInventoryHeader, 2, 5);
        addProductRemovePartInventoryHeader.prefWidthProperty().bind(addProductCenter.widthProperty());
        addProductRemovePartInventoryHeader.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        Label addProductRemovePartPriceHeader = new Label("Price per Unit");
        addProductRemovePartPriceHeader.setPadding(new Insets(5, 0, 5, 10));
        GridPane.setMargin(addProductRemovePartPriceHeader, new Insets(0, 20, 0, 0));
        GridPane.setConstraints(addProductRemovePartPriceHeader, 3, 5);
        addProductRemovePartPriceHeader.prefWidthProperty().bind(addProductCenter.widthProperty());
        addProductRemovePartPriceHeader.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        Button addProductRemovePartBTN = new Button("Delete");
        GridPane.setConstraints(addProductRemovePartBTN, 0, 7, 4, 1, HPos.RIGHT, VPos.CENTER);
        GridPane.setMargin(addProductRemovePartBTN, new Insets(10, 40, 20, 40));
        addProductRemovePartBTN.setPrefWidth(80);

        ListView<Integer> addProductAddPartIDList = new ListView<>(inventory.getAllPartNumberObList());
        GridPane.setMargin(addProductAddPartIDList, new Insets(0, 0, 0, 20));
        GridPane.setConstraints(addProductAddPartIDList, 0, 2);
        
        ListView<String> addProductAddPartNameList = new ListView(inventory.getAllPartNameObList());
        GridPane.setConstraints(addProductAddPartNameList, 1, 2);
        
        ListView<Integer> addProductAddPartInventoryList = new ListView(inventory.getAllPartInventoryObList());
        GridPane.setConstraints(addProductAddPartInventoryList, 2, 2);
        
        ListView<String> addProductAddPartPriceList = new ListView(inventory.getAllPartPriceObList());
        GridPane.setMargin(addProductAddPartPriceList, new Insets(0, 20, 0, 0));
        GridPane.setConstraints(addProductAddPartPriceList, 3, 2);
        
        ListView<Integer> addProductRemovePartIDList = new ListView(inventory.getTemporaryAssociatedPartNumberObList());
        GridPane.setMargin(addProductRemovePartIDList, new Insets(0, 0, 0, 20));
        GridPane.setConstraints(addProductRemovePartIDList, 0, 6);
        
        ListView<String> addProductRemovePartNameList = new ListView(inventory.getTemporaryAssociatedPartNameObList());
        GridPane.setConstraints(addProductRemovePartNameList, 1, 6);
        
        ListView<Integer> addProductRemovePartInventoryList = new ListView(inventory.getTemporaryAssociatedPartInventoryObList());
        GridPane.setConstraints(addProductRemovePartInventoryList, 2, 6);
        
        ListView<String> addProductRemovePartPriceList = new ListView(inventory.getTemporaryAssociatedPartPriceObList());
        GridPane.setMargin(addProductRemovePartPriceList, new Insets(0, 20, 0, 0));
        GridPane.setConstraints(addProductRemovePartPriceList, 3, 6);
        
        addProductCenter.getChildren().addAll(addProductSearchBTN, addProductSearchField);
        addProductCenter.getChildren().addAll(addProductAddPartIDHeader, addProductAddPartNameHeader, addProductAddPartInventoryHeader, addProductAddPartPriceHeader);
        addProductCenter.getChildren().addAll(addProductRemovePartIDHeader, addProductRemovePartNameHeader, addProductRemovePartInventoryHeader, addProductRemovePartPriceHeader);
        addProductCenter.getChildren().addAll(addProductAddPartIDList, addProductAddPartNameList, addProductAddPartInventoryList, addProductAddPartPriceList);
        addProductCenter.getChildren().addAll(addProductRemovePartIDList, addProductRemovePartNameList, addProductRemovePartInventoryList, addProductRemovePartPriceList);
        addProductCenter.getChildren().addAll(addProductAddPartBTN, addProductRemovePartBTN);

        // Clicking on any ListView cell selects all relevant cells //
        addProductAddPartIDList.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                int selectedIndex = addProductAddPartIDList.getSelectionModel().getSelectedIndex();
                addProductAddPartNameList.getSelectionModel().select(selectedIndex);
                addProductAddPartInventoryList.getSelectionModel().select(selectedIndex);
                addProductAddPartPriceList.getSelectionModel().select(selectedIndex);
            }
        });
        
        // Clicking on any ListView cell selects all relevant cells //
        addProductAddPartNameList.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                int selectedIndex = addProductAddPartNameList.getSelectionModel().getSelectedIndex();
                addProductAddPartIDList.getSelectionModel().select(selectedIndex);
                addProductAddPartInventoryList.getSelectionModel().select(selectedIndex);
                addProductAddPartPriceList.getSelectionModel().select(selectedIndex);
            }
        });
        
        // Clicking on any ListView cell selects all relevant cells //
        addProductAddPartInventoryList.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                int selectedIndex = addProductAddPartInventoryList.getSelectionModel().getSelectedIndex();
                addProductAddPartNameList.getSelectionModel().select(selectedIndex);
                addProductAddPartIDList.getSelectionModel().select(selectedIndex);
                addProductAddPartPriceList.getSelectionModel().select(selectedIndex);
            }
        });
        
        // Clicking on any ListView cell selects all relevant cells //
        addProductAddPartPriceList.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                int selectedIndex = addProductAddPartPriceList.getSelectionModel().getSelectedIndex();
                addProductAddPartNameList.getSelectionModel().select(selectedIndex);
                addProductAddPartInventoryList.getSelectionModel().select(selectedIndex);
                addProductAddPartIDList.getSelectionModel().select(selectedIndex);
            }
        });
        
        // Clicking on any ListView cell selects all relevant cells //
        addProductRemovePartIDList.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                int selectedIndex = addProductRemovePartIDList.getSelectionModel().getSelectedIndex();
                addProductRemovePartNameList.getSelectionModel().select(selectedIndex);
                addProductRemovePartInventoryList.getSelectionModel().select(selectedIndex);
                addProductRemovePartPriceList.getSelectionModel().select(selectedIndex);
            }
        });
        
        // Clicking on any ListView cell selects all relevant cells //
        addProductRemovePartNameList.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                int selectedIndex = addProductRemovePartNameList.getSelectionModel().getSelectedIndex();
                addProductRemovePartIDList.getSelectionModel().select(selectedIndex);
                addProductRemovePartInventoryList.getSelectionModel().select(selectedIndex);
                addProductRemovePartPriceList.getSelectionModel().select(selectedIndex);
            }
        });
        
        // Clicking on any ListView cell selects all relevant cells //
        addProductRemovePartInventoryList.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                int selectedIndex = addProductRemovePartInventoryList.getSelectionModel().getSelectedIndex();
                addProductRemovePartNameList.getSelectionModel().select(selectedIndex);
                addProductRemovePartIDList.getSelectionModel().select(selectedIndex);
                addProductRemovePartPriceList.getSelectionModel().select(selectedIndex);
            }
        });
        
        // Clicking on any ListView cell selects all relevant cells //
        addProductRemovePartPriceList.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                int selectedIndex = addProductRemovePartPriceList.getSelectionModel().getSelectedIndex();
                addProductRemovePartNameList.getSelectionModel().select(selectedIndex);
                addProductRemovePartInventoryList.getSelectionModel().select(selectedIndex);
                addProductRemovePartIDList.getSelectionModel().select(selectedIndex);
            }
        });
        
        Button addProductSaveBTN = new Button("Save");
        HBox.setMargin(addProductSaveBTN, new Insets(20, 0, 0, 0));
        addProductSaveBTN.setPrefWidth(80);
        
        addProductSearchBTN.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String textToSearch = addProductSearchField.getCharacters().toString().toLowerCase();
                inventory.getAllPartNumberObList().clear();
                inventory.getAllPartNameObList().clear();
                inventory.getAllPartInventoryObList().clear();
                inventory.getAllPartPriceObList().clear();
                        
                for (Part partToSearch : inventory.getPartsList()) {
                    if (partToSearch.getName().toLowerCase().contains(textToSearch)) {
                    inventory.getAllPartNumberObList().add(partToSearch.getPartID());
                    inventory.getAllPartNameObList().add(partToSearch.getName());
                    inventory.getAllPartInventoryObList().add(partToSearch.getInStock());
                    inventory.getAllPartPriceObList().add("$ " + Double.toString(partToSearch.getPrice()));
                    }
                }
            }
        });
        
        addProductSaveBTN.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                int productToAddID = Integer.parseInt(addProductIDField.getCharacters().toString());
                String productToAddName = "";
                Double productToAddPrice = 0.0;
                int productToAddInventory = 0;
                int productToAddMax = 0;
                int productToAddMin = 0;
                
                boolean minMaxCheck = false;
                boolean sumPriceCheck = false;
                
                if (addProductNameField.getCharacters().toString().isEmpty() || addProductPriceField.getCharacters().toString().isEmpty() || addProductInventoryField.getCharacters().toString().isEmpty() || addProductMaxField.getCharacters().toString().isEmpty() || addProductMinField.getCharacters().toString().isEmpty()) {
                    new Alert(AlertType.WARNING, "Please fill out all fields.").showAndWait();
                }
                else {
                    productToAddName = addProductNameField.getCharacters().toString();
                    productToAddPrice = Double.parseDouble(addProductPriceField.getCharacters().toString());
                    productToAddInventory = Integer.parseInt(addProductInventoryField.getCharacters().toString());
                    productToAddMax = Integer.parseInt(addProductMaxField.getCharacters().toString());
                    productToAddMin = Integer.parseInt(addProductMinField.getCharacters().toString());
                    
                    if (productToAddMin > productToAddMax) {
                    minMaxAlert.showAndWait();
                    }
                    else {
                        minMaxCheck = true;
                    }

                    double sumOfPrices = 0;
                    for (Part part : inventory.getTemporaryAssociatedPartsList()) {
                        sumOfPrices += part.getPrice();
                        System.out.println(sumOfPrices);
                    }

                    if (sumOfPrices > productToAddPrice) {
                        new Alert(AlertType.WARNING, "The product's price cannot be lower than the sum of its part's prices.").showAndWait();
                    }
                    else {
                        sumPriceCheck = true;
                    }
                }
                
                if ((minMaxCheck == false) || (sumPriceCheck == false)) {
                    
                }
                else {
                    if (inventory.getProductsList().contains(inventory.lookUpProduct(productToAddID))) {
                    inventory.lookUpProduct(productToAddID).setName(productToAddName);
                    inventory.lookUpProduct(productToAddID).setPrice(productToAddPrice);
                    inventory.lookUpProduct(productToAddID).setInStock(productToAddInventory);
                    inventory.lookUpProduct(productToAddID).setMax(productToAddMax);
                    inventory.lookUpProduct(productToAddID).setMin(productToAddMin);
                    inventory.lookUpProduct(productToAddID).getAssociatedPartsList().clear();
                    inventory.lookUpProduct(productToAddID).addAssociatedParts(inventory.getTemporaryAssociatedPartsList());
                    }
                    
                    else {
                        Product productToAdd = new Product(productToAddID, productToAddName, productToAddPrice, productToAddInventory, productToAddMin, productToAddMax, inventory.getTemporaryAssociatedPartsList());
                        inventory.addProduct(productToAdd);
                    }
                
                    addProductIDField.clear();
                    addProductNameField.clear();
                    addProductPriceField.clear();
                    addProductInventoryField.clear();
                    addProductMinField.clear();
                    addProductMaxField.clear();
                    inventory.getTemporaryAssociatedPartsList().clear();
                    inventory.updateTempList();

                    primaryStage.setScene(mainScene);
                    primaryStage.show();
                }
            }
        });
        
        Button addProductCancelBTN = new Button("Cancel");
        HBox.setMargin(addProductCancelBTN, new Insets(20, 0, 0, 0));
        addProductCancelBTN.setPrefWidth(80);
        addProductCancelBTN.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                addProductIDField.clear();
                addProductNameField.clear();
                addProductPriceField.clear();
                addProductInventoryField.clear();
                addProductMinField.clear();
                addProductMaxField.clear();
                inventory.getTemporaryAssociatedPartsList().clear();
                inventory.updateTempList();
                
                inventory.getAllPartNumberObList().clear();
                inventory.getAllPartNameObList().clear();
                inventory.getAllPartInventoryObList().clear();
                inventory.getAllPartPriceObList().clear();
                        
                for (Part part : inventory.getPartsList()) {
                    inventory.getAllPartNumberObList().add(part.getPartID());
                    inventory.getAllPartNameObList().add(part.getName());
                    inventory.getAllPartInventoryObList().add(part.getInStock());
                    inventory.getAllPartPriceObList().add("$ " + Double.toString(part.getPrice()));
                }
                
                new Alert(AlertType.CONFIRMATION, "You have canceled adding/modifying a product.").showAndWait();
                
                primaryStage.setScene(mainScene);
                primaryStage.show();
            }
        });
        
        addProductAddPartBTN.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Part partToAdd = inventory.lookUpPart(addProductAddPartIDList.getFocusModel().getFocusedItem());
                inventory.addPartToTempList(partToAdd);
            }
        });
                
        addProductRemovePartBTN.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Part partToRemove = inventory.lookUpPart(addProductRemovePartIDList.getFocusModel().getFocusedItem());
                inventory.removePartFromTempList(partToRemove);
                new Alert(AlertType.CONFIRMATION, "You have disassociated a part.").showAndWait();
            }
        });

        addProductBottom.getChildren().addAll(addProductSaveBTN, addProductCancelBTN);
        
        // // // // // //
        // Root Pane   //
        // // // // // //

        Label rootHeader = new Label("Inventory Management System");
        rootHeader.setStyle("-fx-font: normal bold 18px 'monospace' ");
        rootHeader.setPadding(new Insets(0, 0, 20, 20));
        BorderPane.setAlignment(rootHeader, Pos.CENTER_LEFT);

        HBox rootCenter = new HBox(40);
        rootCenter.setPadding(new Insets(0, 0, 20, 0));

        Button exitBTN = new Button("Exit");
        exitBTN.setPrefWidth(100);
        BorderPane.setMargin(exitBTN, new Insets(0, 40, 0, 0));
        BorderPane.setAlignment(exitBTN, Pos.CENTER_RIGHT);
        exitBTN.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });

        root.setTop(rootHeader);
        root.setCenter(rootCenter);
        root.setBottom(exitBTN);
        
        BorderPane partPane = new BorderPane();
        partPane.setPadding(defaultPadding);
        partPane.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderStroke.THIN)));
        BorderPane.setAlignment(partPane, Pos.CENTER);

        BorderPane productPane = new BorderPane();
        productPane.setPadding(defaultPadding);
        productPane.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderStroke.THIN)));
        BorderPane.setAlignment(productPane, Pos.CENTER);

        rootCenter.getChildren().addAll(partPane, productPane);

        // // // // // // // // // // // //
        // Root Pane's Part List Section // 
        // // // // // // // // // // // //
        
        HBox partPaneTop = new HBox(10);
        partPaneTop.setPadding(new Insets(0, 0, 0, 0));
        partPaneTop.setAlignment(Pos.CENTER);

        HBox partListView = new HBox(0);
        partListView.setPadding(new Insets(10, 0, 0, 0));

        HBox partPaneBottom = new HBox(20);
        partPaneBottom.setPadding(new Insets(10, 0, 0, 0));
        partPaneBottom.setAlignment(Pos.CENTER_RIGHT);

        partPane.setTop(partPaneTop);
        partPane.setCenter(partListView);
        partPane.setBottom(partPaneBottom);
        
        Label partLabel = new Label("Parts");
        partLabel.setStyle("-fx-font: normal bold 18px 'monospace' ");
        HBox.setMargin(partLabel, new Insets(0, 60, 0, 20));

        Button partSearchBTN = new Button("Search");
        partSearchBTN.setPrefWidth(80);

        TextField partSearchField = new TextField();
        HBox.setHgrow(partSearchField, Priority.ALWAYS);

        partPaneTop.getChildren().addAll(partLabel, partSearchBTN, partSearchField);

        VBox partVBox1 = new VBox();
        HBox.setHgrow(partVBox1, Priority.ALWAYS);
        VBox partVBox2 = new VBox();
        HBox.setHgrow(partVBox2, Priority.ALWAYS);
        VBox partVBox3 = new VBox();
        HBox.setHgrow(partVBox3, Priority.ALWAYS);
        VBox partVBox4 = new VBox();
        HBox.setHgrow(partVBox4, Priority.ALWAYS);

        partListView.getChildren().addAll(partVBox1, partVBox2, partVBox3, partVBox4);

        Label partIDLabel = new Label("Part ID");
        partIDLabel.setPadding(new Insets(5, 0, 5, 10));
        partIDLabel.prefWidthProperty().bind(partVBox1.widthProperty());
        partIDLabel.setAlignment(Pos.CENTER_LEFT);
        partIDLabel.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        ListView<Integer> partIDListView = new ListView<>(inventory.getAllPartNumberObList());
        partIDListView.prefHeightProperty().bind(partVBox1.heightProperty());

        partVBox1.getChildren().addAll(partIDLabel, partIDListView);

        Label partNameLabel = new Label("Part Name");
        partNameLabel.setPadding(new Insets(5, 0, 5, 10));
        partNameLabel.prefWidthProperty().bind(partVBox2.widthProperty());
        partNameLabel.setAlignment(Pos.CENTER_LEFT);
        partNameLabel.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        ListView<String> partNameListView = new ListView<>(inventory.getAllPartNameObList());
        partNameListView.prefHeightProperty().bind(partVBox2.heightProperty());

        partVBox2.getChildren().addAll(partNameLabel, partNameListView);

        Label partInventoryLabel = new Label("Inventory Level");
        partInventoryLabel.setPadding(new Insets(5, 0, 5, 10));
        partInventoryLabel.prefWidthProperty().bind(partVBox3.widthProperty());
        partInventoryLabel.setAlignment(Pos.CENTER_LEFT);
        partInventoryLabel.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        ListView<Integer> partInventoryListView = new ListView<>(inventory.getAllPartInventoryObList());
        partInventoryListView.prefHeightProperty().bind(partVBox3.heightProperty());

        partVBox3.getChildren().addAll(partInventoryLabel, partInventoryListView);

        Label partPriceLabel = new Label("Price per Unit");
        partPriceLabel.setPadding(new Insets(5, 0, 5, 10));
        partPriceLabel.prefWidthProperty().bind(partVBox4.widthProperty());
        partPriceLabel.setAlignment(Pos.CENTER_LEFT);
        partPriceLabel.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        ListView<String> allPartPriceListView = new ListView<>(inventory.getAllPartPriceObList());
        allPartPriceListView.prefHeightProperty().bind(partVBox4.heightProperty());

        partVBox4.getChildren().addAll(partPriceLabel, allPartPriceListView);
        
        // Clicking on any ListView cell selects all relevant cells //
        partIDListView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                int selectedIndex = partIDListView.getSelectionModel().getSelectedIndex();
                partNameListView.getSelectionModel().select(selectedIndex);
                partInventoryListView.getSelectionModel().select(selectedIndex);
                allPartPriceListView.getSelectionModel().select(selectedIndex);
            }
        });
        
        // Clicking on any ListView cell selects all relevant cells //
        partNameListView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                int selectedIndex = partNameListView.getSelectionModel().getSelectedIndex();
                partIDListView.getSelectionModel().select(selectedIndex);
                partInventoryListView.getSelectionModel().select(selectedIndex);
                allPartPriceListView.getSelectionModel().select(selectedIndex);
            }
        });
        
        // Clicking on any ListView cell selects all relevant cells //
        partInventoryListView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                int selectedIndex = partInventoryListView.getSelectionModel().getSelectedIndex();
                partNameListView.getSelectionModel().select(selectedIndex);
                partIDListView.getSelectionModel().select(selectedIndex);
                allPartPriceListView.getSelectionModel().select(selectedIndex);
            }
        });
        
        // Clicking on any ListView cell selects all relevant cells //
        allPartPriceListView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                int selectedIndex = allPartPriceListView.getSelectionModel().getSelectedIndex();
                partNameListView.getSelectionModel().select(selectedIndex);
                partInventoryListView.getSelectionModel().select(selectedIndex);
                partIDListView.getSelectionModel().select(selectedIndex);
            }
        });
        
        //** Search Function **//
        
        partSearchBTN.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String textToSearch = partSearchField.getCharacters().toString().toLowerCase();
                inventory.getAllPartNumberObList().clear();
                inventory.getAllPartNameObList().clear();
                inventory.getAllPartInventoryObList().clear();
                inventory.getAllPartPriceObList().clear();
                        
                for (Part partToSearch : inventory.allParts) {
                    if (partToSearch.getName().toLowerCase().contains(textToSearch)) {
                        inventory.getAllPartNumberObList().add(partToSearch.getPartID());
                        inventory.getAllPartNameObList().add(partToSearch.getName());
                        inventory.getAllPartInventoryObList().add(partToSearch.getInStock());
                        inventory.getAllPartPriceObList().add("$ " + Double.toString(partToSearch.getPrice()));
                    }
                    else {
                        
                    }
                }
            }
        });

        Button partAddBTN = new Button("Add");
        partAddBTN.setPrefWidth(80);
        partAddBTN.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                addPartHeader.setText("Add Part");
                int resPartID = 1;
                for (Part temporaryPart : inventory.allParts) {
                    if (temporaryPart.getPartID() == resPartID) {
                        resPartID++;
                    }
                    else {
                        break;
                    }
                }
                addPartIDField.setText(Integer.toString(resPartID));
                primaryStage.setScene(addPartScene);
                primaryStage.show();
            }
        });

            Button partModifyBTN = new Button("Modify");
            partModifyBTN.setPrefWidth(80);
            partModifyBTN.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    addPartHeader.setText("Modify Part");
                    if (partIDListView.getSelectionModel().isSelected(partIDListView.getSelectionModel().getSelectedIndex())) {
                        Part partToModify = inventory.lookUpPart(partIDListView.getSelectionModel().getSelectedItem());
                        if (inventory.isOutsourced(partToModify)) {
                            addPartRadio2.fire();
                            addPartRadio1.setDisable(true);
                            addPartRadio2.setDisable(true);
                            Outsourced outsourcedToModify = (Outsourced) partToModify;
                            addPartIDField.setText(Integer.toString(outsourcedToModify.getPartID()));
                            addPartNameField.setText(outsourcedToModify.getName());
                            addPartInventoryField.setText(Integer.toString(outsourcedToModify.getInStock()));
                            addPartPriceField.setText(Double.toString(outsourcedToModify.getPrice()));
                            addPartMaxField.setText(Integer.toString(outsourcedToModify.getMax()));
                            addPartMinField.setText(Integer.toString(outsourcedToModify.getMin()));
                            addPartCompanyNameField.setText(outsourcedToModify.getCompanyName());
                            primaryStage.setScene(addPartScene);
                            primaryStage.show();
                        }
                        else {
                            addPartRadio1.fire();
                            addPartRadio1.setDisable(true);
                            addPartRadio2.setDisable(true);
                            Inhouse inhouseToModify = (Inhouse) partToModify;
                            addPartIDField.setText(Integer.toString(partToModify.getPartID()));
                            addPartNameField.setText(partToModify.getName());
                            addPartInventoryField.setText(Integer.toString(partToModify.getInStock()));
                            addPartPriceField.setText(Double.toString(partToModify.getPrice()));
                            addPartMaxField.setText(Integer.toString(partToModify.getMax()));
                            addPartMinField.setText(Integer.toString(partToModify.getMin()));
                            addPartMachineIDField.setText(Integer.toString(inhouseToModify.getMachineID()));
                            primaryStage.setScene(addPartScene);
                            primaryStage.show();
                        }
                    }
                }
            });

        Button partDeleteBTN = new Button("Delete");
        partDeleteBTN.setPrefWidth(80);
        partDeleteBTN.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    inventory.deletePart(inventory.lookUpPart(partIDListView.getFocusModel().getFocusedItem()));
                    new Alert(AlertType.CONFIRMATION, "You have deleted a part.").showAndWait();
                }
            });

        partPaneBottom.getChildren().addAll(partAddBTN, partModifyBTN, partDeleteBTN);

        // // // // // // // // // // // // //
        // Root Pane's Product List Section //
        // // // // // // // // // // // // //
        
        HBox productPaneTop = new HBox(10);
        productPaneTop.setPadding(new Insets(0, 0, 0, 0));
        productPaneTop.setAlignment(Pos.CENTER);

        HBox productListView = new HBox(0);
        productListView.setPadding(new Insets(10, 0, 0, 0));

        HBox productPaneBottom = new HBox(20);
        productPaneBottom.setPadding(new Insets(10, 0, 0, 0));
        productPaneBottom.setAlignment(Pos.CENTER_RIGHT);

        productPane.setTop(productPaneTop);
        productPane.setCenter(productListView);
        productPane.setBottom(productPaneBottom);

        Label productLabel = new Label("Products");
        productLabel.setStyle("-fx-font: normal bold 18px 'monospace' ");
        HBox.setMargin(productLabel, new Insets(0, 60, 0, 20));

        Button productSearchBTN = new Button("Search");
        productSearchBTN.setPrefWidth(80);
        // Make event to search for product in relevant text field

        TextField productSearchField = new TextField();
        HBox.setHgrow(productSearchField, Priority.ALWAYS);

        productPaneTop.getChildren().addAll(productLabel, productSearchBTN, productSearchField);

        VBox productVBox1 = new VBox();
        HBox.setHgrow(productVBox1, Priority.ALWAYS);
        VBox productVBox2 = new VBox();
        HBox.setHgrow(productVBox2, Priority.ALWAYS);
        VBox productVBox3 = new VBox();
        HBox.setHgrow(productVBox3, Priority.ALWAYS);
        VBox productVBox4 = new VBox();
        HBox.setHgrow(productVBox4, Priority.ALWAYS);

        productListView.getChildren().addAll(productVBox1, productVBox2, productVBox3, productVBox4);

        Label productIDLabel = new Label("Product ID");
        productIDLabel.setPadding(new Insets(5, 0, 5, 10));
        productIDLabel.prefWidthProperty().bind(productVBox1.widthProperty());
        productIDLabel.setAlignment(Pos.CENTER_LEFT);
        productIDLabel.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        ListView<Integer> productIDListView = new ListView<>(inventory.allProductNumberObList);
        productIDListView.prefHeightProperty().bind(productVBox1.heightProperty());

        productVBox1.getChildren().addAll(productIDLabel, productIDListView);

        Label productNameLabel = new Label("Product Name");
        productNameLabel.setPadding(new Insets(5, 0, 5, 10));
        productNameLabel.prefWidthProperty().bind(productVBox1.widthProperty());
        productNameLabel.setAlignment(Pos.CENTER_LEFT);
        productNameLabel.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        ListView<String> productNameListView = new ListView<>(inventory.getAllProductNameObList());
        productNameListView.prefHeightProperty().bind(productVBox1.heightProperty());

        productVBox2.getChildren().addAll(productNameLabel, productNameListView);

        Label productInventoryLabel = new Label("Inventory Level");
        productInventoryLabel.setPadding(new Insets(5, 0, 5, 10));
        productInventoryLabel.prefWidthProperty().bind(productVBox1.widthProperty());
        productInventoryLabel.setAlignment(Pos.CENTER_LEFT);
        productInventoryLabel.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        ListView<Integer> productInventoryListView = new ListView<>(inventory.getAllProductInventoryObList());
        productInventoryListView.prefHeightProperty().bind(productVBox1.heightProperty());

        productVBox3.getChildren().addAll(productInventoryLabel, productInventoryListView);

        Label productPriceLabel = new Label("Price per Unit");
        productPriceLabel.setPadding(new Insets(5, 0, 5, 10));
        productPriceLabel.prefWidthProperty().bind(productVBox1.widthProperty());
        productPriceLabel.setAlignment(Pos.CENTER_LEFT);
        productPriceLabel.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        ListView<String> productPriceListView = new ListView<>(inventory.getAllProductPriceObList());
        productPriceListView.prefHeightProperty().bind(productVBox1.heightProperty());

        productVBox4.getChildren().addAll(productPriceLabel, productPriceListView);
        
        // Clicking on any ListView cell selects all relevant cells //
        productIDListView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                int selectedIndex = productIDListView.getSelectionModel().getSelectedIndex();
                productNameListView.getSelectionModel().select(selectedIndex);
                productInventoryListView.getSelectionModel().select(selectedIndex);
                productPriceListView.getSelectionModel().select(selectedIndex);
            }
        });
        
        // Clicking on any ListView cell selects all relevant cells //
        productNameListView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                int selectedIndex = productNameListView.getSelectionModel().getSelectedIndex();
                productIDListView.getSelectionModel().select(selectedIndex);
                productInventoryListView.getSelectionModel().select(selectedIndex);
                productPriceListView.getSelectionModel().select(selectedIndex);
            }
        });
        
        // Clicking on any ListView cell selects all relevant cells //
        productInventoryListView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                int selectedIndex = productInventoryListView.getSelectionModel().getSelectedIndex();
                productNameListView.getSelectionModel().select(selectedIndex);
                productIDListView.getSelectionModel().select(selectedIndex);
                productPriceListView.getSelectionModel().select(selectedIndex);
            }
        });
        
        // Clicking on any ListView cell selects all relevant cells //
        productPriceListView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                int selectedIndex = productPriceListView.getSelectionModel().getSelectedIndex();
                productNameListView.getSelectionModel().select(selectedIndex);
                productInventoryListView.getSelectionModel().select(selectedIndex);
                productIDListView.getSelectionModel().select(selectedIndex);
            }
        });
        
        productSearchBTN.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String textToSearch = productSearchField.getCharacters().toString().toLowerCase();
                inventory.getAllProductNumberObList().clear();
                inventory.getAllProductNameObList().clear();
                inventory.getAllProductInventoryObList().clear();
                inventory.getAllProductPriceObList().clear();
                        
                for (Product productToSearch : inventory.getProductsList()) {
                    if (productToSearch.getName().toLowerCase().contains(textToSearch)) {
                        inventory.getAllProductNumberObList().add(productToSearch.getProductID());
                        inventory.getAllProductNameObList().add(productToSearch.getName());
                        inventory.getAllProductInventoryObList().add(productToSearch.getInStock());
                        inventory.getAllProductPriceObList().add("$ " + Double.toString(productToSearch.getPrice()));
                    }
                    else {
                        
                    }
                }
            }
        });

        Button productAddBTN = new Button("Add");
        productAddBTN.setPrefWidth(80);
        productAddBTN.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                addProductHeader.setText("Add Product");
                
                inventory.getAllPartNumberObList().clear();
                inventory.getAllPartNameObList().clear();
                inventory.getAllPartInventoryObList().clear();
                inventory.getAllPartPriceObList().clear();
                        
                for (Part part : inventory.getPartsList()) {
                    inventory.getAllPartNumberObList().add(part.getPartID());
                    inventory.getAllPartNameObList().add(part.getName());
                    inventory.getAllPartInventoryObList().add(part.getInStock());
                    inventory.getAllPartPriceObList().add("$ " + Double.toString(part.getPrice()));
                }
                
                int resProductID = 1;
                for (Product temporaryProduct : inventory.products) {
                    if (temporaryProduct.getProductID() == resProductID) {
                        resProductID++;
                    }
                    else {
                        break;
                    }
                }
                addProductIDField.setText(Integer.toString(resProductID));
                
                primaryStage.setScene(addProductScene);
                primaryStage.show();
            }
        });

        Button productModifyBTN = new Button("Modify");
        productModifyBTN.setPrefWidth(80);
        productModifyBTN.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                addProductHeader.setText("Modify Product");
                
                inventory.getAllPartNumberObList().clear();
                inventory.getAllPartNameObList().clear();
                inventory.getAllPartInventoryObList().clear();
                inventory.getAllPartPriceObList().clear();
                        
                for (Part part : inventory.getPartsList()) {
                    inventory.getAllPartNumberObList().add(part.getPartID());
                    inventory.getAllPartNameObList().add(part.getName());
                    inventory.getAllPartInventoryObList().add(part.getInStock());
                    inventory.getAllPartPriceObList().add("$ " + Double.toString(part.getPrice()));
                }
                
                Product productToModify = inventory.lookUpProduct(productIDListView.getSelectionModel().getSelectedItem());
                
                addProductIDField.setText(Integer.toString(productToModify.getProductID()));
                addProductNameField.setText(productToModify.getName());
                addProductInventoryField.setText(Integer.toString(productToModify.getInStock()));
                addProductPriceField.setText(Double.toString(productToModify.getPrice()));
                addProductMaxField.setText(Integer.toString(productToModify.getMax()));
                addProductMinField.setText(Integer.toString(productToModify.getMin()));
                
                for (Part part : productToModify.getAssociatedPartsList()) {
                    inventory.addPartToTempList(part);
                }
                
                primaryStage.setScene(addProductScene);
                primaryStage.show();
            }
        });

        Button productDeleteBTN = new Button("Delete");
        productDeleteBTN.setPrefWidth(80);
        productDeleteBTN.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                inventory.removeProduct(productIDListView.getFocusModel().getFocusedItem());
                new Alert(AlertType.CONFIRMATION, "You have deleted a product.").showAndWait();
            }
        });

        productPaneBottom.getChildren().addAll(productAddBTN, productModifyBTN, productDeleteBTN);

        // // // // // // // // // // // // //
        // Show Main Scene on Primary Stage //
        // // // // // // // // // // // // //
        
        primaryStage.setTitle("Inventory Management System");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
