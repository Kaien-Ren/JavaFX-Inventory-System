/*****************
 * @author lethv *
 *****************/

package javafxpractice;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.paint.Color;

public class JavaFXPractice extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        // // // // // // // // // // // // // // // // //
        // Initializing Inventory, Products, and Parts  //
        // // // // // // // // // // // // // // // // //
        
        Part part1 = new Part(1, "One", 1.5, 5, 1, 5);
        Part part2 = new Part(2, "Two", 3.0, 5, 1, 5);
        Part part3 = new Part(3, "Three", 4.5, 5, 1, 5);
        Part part4 = new Part(4, "Four", 6.0, 5, 1, 5);
        Part part5 = new Part(5, "Five", 9.99, 5, 1, 5);
        Part part6 = new Part(6, "Six", 100, 5, 1, 5);
        Part part7 = new Part(7, "Seven", 100, 5, 1, 5);
        Part part8 = new Part(8, "Eight", 2, 5, 1, 5);
        Part part9 = new Part(9, "Nine", 2, 5, 1, 5);
        
        Product product1 = new Product(1, "Ones", 1.5, 5, 1, 5);
        Product product2 = new Product(2, "Twos", 2.5, 5, 1, 5);
        Product product3 = new Product(3, "Threes", 3.5, 5, 1, 5);
        Product product4 = new Product(4, "Fours", 4.5, 5, 1, 5);
        
        Inventory inventory = new Inventory();
        
        inventory.addPart(part1);
        inventory.addPart(part2);
        inventory.addPart(part3);
        inventory.addPart(part4);
        inventory.addPart(part5);
        inventory.addPart(part6);
        inventory.addPart(part7);
        inventory.addPart(part8);
        inventory.addPart(part9);
        
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);
        inventory.addProduct(product4);
        
        // // // // // // // // // // // //
        // Initializing Default Values   //
        // // // // // // // // // // // //
        
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
                addPartIDField.clear();
                String partToAddName = addPartNameField.getCharacters().toString();
                addPartNameField.clear();
                Double partToAddPrice = Double.parseDouble(addPartPriceField.getCharacters().toString());
                addPartPriceField.clear();
                int partToAddInventory = Integer.parseInt(addPartInventoryField.getCharacters().toString());
                addPartInventoryField.clear();
                int partToAddMin = Integer.parseInt(addPartMinField.getCharacters().toString());
                addPartMinField.clear();
                int partToAddMax = Integer.parseInt(addPartMaxField.getCharacters().toString());
                addPartMaxField.clear();
                Part partToAdd = new Part(partToAddID, partToAddName, partToAddPrice, partToAddInventory, partToAddMin, partToAddMax);
                inventory.addPart(partToAdd);
                primaryStage.setScene(mainScene);
                primaryStage.show();
            }
        });

        Button addPartCancelBTN = new Button("Cancel");
        HBox.setMargin(addPartCancelBTN, new Insets(20, 0, 0, 0));
        addPartCancelBTN.setPrefWidth(80);
        addPartCancelBTN.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                inventory.updatePart(1);
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

        ListView addProductAddPartIDList = new ListView();
        GridPane.setMargin(addProductAddPartIDList, new Insets(0, 0, 0, 20));
        GridPane.setConstraints(addProductAddPartIDList, 0, 2);
        
        Label addProductAddPartNameHeader = new Label("Part Name");
        addProductAddPartNameHeader.setPadding(new Insets(5, 0, 5, 10));
        GridPane.setConstraints(addProductAddPartNameHeader, 1, 1);
        addProductAddPartNameHeader.prefWidthProperty().bind(addProductCenter.widthProperty());
        addProductAddPartNameHeader.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        ListView addProductAddPartNameList = new ListView();
        GridPane.setConstraints(addProductAddPartNameList, 1, 2);

        Label addProductAddPartInventoryHeader = new Label("Inventory Level");
        addProductAddPartInventoryHeader.setPadding(new Insets(5, 0, 5, 10));
        GridPane.setConstraints(addProductAddPartInventoryHeader, 2, 1);
        addProductAddPartInventoryHeader.prefWidthProperty().bind(addProductCenter.widthProperty());
        addProductAddPartInventoryHeader.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        ListView addProductAddPartInventoryList = new ListView();
        GridPane.setConstraints(addProductAddPartInventoryList, 2, 2);

        Label addProductAddPartPriceHeader = new Label("Price per Unit");
        addProductAddPartPriceHeader.setPadding(new Insets(5, 0, 5, 10));
        GridPane.setMargin(addProductAddPartPriceHeader, new Insets(0, 20, 0, 0));
        GridPane.setConstraints(addProductAddPartPriceHeader, 3, 1);
        addProductAddPartPriceHeader.prefWidthProperty().bind(addProductCenter.widthProperty());
        addProductAddPartPriceHeader.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        ListView addProductAddPartPriceList = new ListView();
        GridPane.setMargin(addProductAddPartPriceList, new Insets(0, 20, 0, 0));
        GridPane.setConstraints(addProductAddPartPriceList, 3, 2);

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

        ListView addProductRemovePartIDList = new ListView();
        GridPane.setMargin(addProductRemovePartIDList, new Insets(0, 0, 0, 20));
        GridPane.setConstraints(addProductRemovePartIDList, 0, 6);

        Label addProductRemovePartNameHeader = new Label("Part Name");
        addProductRemovePartNameHeader.setPadding(new Insets(5, 0, 5, 10));
        GridPane.setConstraints(addProductRemovePartNameHeader, 1, 5);
        addProductRemovePartNameHeader.prefWidthProperty().bind(addProductCenter.widthProperty());
        addProductRemovePartNameHeader.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        ListView addProductRemovePartNameList = new ListView();
        GridPane.setConstraints(addProductRemovePartNameList, 1, 6);

        Label addProductRemovePartInventoryHeader = new Label("Inventory Level");
        addProductRemovePartInventoryHeader.setPadding(new Insets(5, 0, 5, 10));
        GridPane.setConstraints(addProductRemovePartInventoryHeader, 2, 5);
        addProductRemovePartInventoryHeader.prefWidthProperty().bind(addProductCenter.widthProperty());
        addProductRemovePartInventoryHeader.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        ListView addProductRemovePartInventoryList = new ListView();
        GridPane.setConstraints(addProductRemovePartInventoryList, 2, 6);

        Label addProductRemovePartPriceHeader = new Label("Price per Unit");
        addProductRemovePartPriceHeader.setPadding(new Insets(5, 0, 5, 10));
        GridPane.setMargin(addProductRemovePartPriceHeader, new Insets(0, 20, 0, 0));
        GridPane.setConstraints(addProductRemovePartPriceHeader, 3, 5);
        addProductRemovePartPriceHeader.prefWidthProperty().bind(addProductCenter.widthProperty());
        addProductRemovePartPriceHeader.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        ListView addProductRemovePartPriceList = new ListView();
        GridPane.setMargin(addProductRemovePartPriceList, new Insets(0, 20, 0, 0));
        GridPane.setConstraints(addProductRemovePartPriceList, 3, 6);

        Button addProductRemovePartBTN = new Button("Delete");
        GridPane.setConstraints(addProductRemovePartBTN, 0, 7, 4, 1, HPos.RIGHT, VPos.CENTER);
        GridPane.setMargin(addProductRemovePartBTN, new Insets(10, 40, 20, 40));
        addProductRemovePartBTN.setPrefWidth(80);

        addProductCenter.getChildren().addAll(addProductSearchBTN, addProductSearchField);
        addProductCenter.getChildren().addAll(addProductAddPartIDHeader, addProductAddPartNameHeader, addProductAddPartInventoryHeader, addProductAddPartPriceHeader);
        addProductCenter.getChildren().addAll(addProductRemovePartIDHeader, addProductRemovePartNameHeader, addProductRemovePartInventoryHeader, addProductRemovePartPriceHeader);
        addProductCenter.getChildren().addAll(addProductAddPartIDList, addProductAddPartNameList, addProductAddPartInventoryList, addProductAddPartPriceList);
        addProductCenter.getChildren().addAll(addProductRemovePartIDList, addProductRemovePartNameList, addProductRemovePartInventoryList, addProductRemovePartPriceList);
        addProductCenter.getChildren().addAll(addProductAddPartBTN, addProductRemovePartBTN);

        Button addProductSaveBTN = new Button("Save");
        HBox.setMargin(addProductSaveBTN, new Insets(20, 0, 0, 0));
        addProductSaveBTN.setPrefWidth(80);
        addProductSaveBTN.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                int productToAddID = Integer.parseInt(addProductIDField.getCharacters().toString());
                addProductIDField.clear();
                String productToAddName = addProductNameField.getCharacters().toString();
                addProductNameField.clear();
                Double productToAddPrice = Double.parseDouble(addProductPriceField.getCharacters().toString());
                addProductPriceField.clear();
                int productToAddInventory = Integer.parseInt(addProductInventoryField.getCharacters().toString());
                addProductInventoryField.clear();
                int productToAddMin = Integer.parseInt(addProductMinField.getCharacters().toString());
                addProductMinField.clear();
                int productToAddMax = Integer.parseInt(addProductMaxField.getCharacters().toString());
                addProductMaxField.clear();
                Part productToAdd = new Part(productToAddID, productToAddName, productToAddPrice, productToAddInventory, productToAddMin, productToAddMax);
                inventory.addPart(productToAdd);
                primaryStage.setScene(mainScene);
                primaryStage.show();
            }
        });
        
        Button addProductCancelBTN = new Button("Cancel");
        HBox.setMargin(addProductCancelBTN, new Insets(20, 0, 0, 0));
        addProductCancelBTN.setPrefWidth(80);
        addProductCancelBTN.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(mainScene);
                primaryStage.show();
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
        // Make event to search for part in relevant text field

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

        Button partAddBTN = new Button("Add");
        partAddBTN.setPrefWidth(80);
        partAddBTN.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(addPartScene);
                primaryStage.show();
            }
        });

            Button partModifyBTN = new Button("Modify");
            partModifyBTN.setPrefWidth(80);
            partModifyBTN.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    primaryStage.setScene(addPartScene);
                    primaryStage.show();
                }
            });

        Button partDeleteBTN = new Button("Delete");
        partDeleteBTN.setPrefWidth(80);
        partDeleteBTN.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    inventory.deletePart(inventory.lookUpPart(partIDListView.getFocusModel().getFocusedItem()));
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

        ListView<Integer> productStockListView = new ListView<>(inventory.getAllProductInventoryObList());
        productStockListView.prefHeightProperty().bind(productVBox1.heightProperty());

        productVBox3.getChildren().addAll(productInventoryLabel, productStockListView);

        Label productPriceLabel = new Label("Price per Unit");
        productPriceLabel.setPadding(new Insets(5, 0, 5, 10));
        productPriceLabel.prefWidthProperty().bind(productVBox1.widthProperty());
        productPriceLabel.setAlignment(Pos.CENTER_LEFT);
        productPriceLabel.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        ListView<String> productPPUListView = new ListView<>(inventory.getAllProductPriceObList());
        productPPUListView.prefHeightProperty().bind(productVBox1.heightProperty());

        productVBox4.getChildren().addAll(productPriceLabel, productPPUListView);

        Button productAddBTN = new Button("Add");
        productAddBTN.setPrefWidth(80);
        productAddBTN.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(addProductScene);
                primaryStage.show();
            }
        });

        Button productModifyBTN = new Button("Modify");
        productModifyBTN.setPrefWidth(80);
        productModifyBTN.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(addProductScene);
                primaryStage.show();
            }
        });

        Button productDeleteBTN = new Button("Delete");
        productDeleteBTN.setPrefWidth(80);
        // Make event, delete selected product

        productPaneBottom.getChildren().addAll(productAddBTN, productModifyBTN, productDeleteBTN);

        // // // // // // // // // // // //
        // Show Main Scene on Primary Stage   //
        // // // // // // // // // // // //
        
        primaryStage.setTitle("Inventory Management System");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
