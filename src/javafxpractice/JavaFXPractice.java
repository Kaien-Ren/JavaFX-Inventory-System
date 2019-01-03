/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

/**
 *
 * @author lethv
 */

public class JavaFXPractice extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        // // // // // // // // // // // // // // // // //
        // Initializing Inventory, Products, and Parts  //
        // // // // // // // // // // // // // // // // //
        
        Inventory inventory = new Inventory();
        
        Part part1 = new Part();
        part1.setPartID(1);
        Part part2 = new Part();
        part2.setPartID(2);
        Part part3 = new Part();
        part3.setPartID(3);
        Part part4 = new Part();
        part4.setPartID(4);
        Part part5 = new Part();
        part5.setPartID(5);
        Part part6 = new Part();
        part6.setPartID(6);
        Part part7 = new Part();
        part7.setPartID(7);
        Part part8 = new Part();
        part8.setPartID(8);
        Part part9 = new Part();
        part9.setPartID(9);
        
        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();
        
        product1.addAssociatedPart(part1);
        product1.addAssociatedPart(part2);
        product1.addAssociatedPart(part3);
        
        product2.addAssociatedPart(part4);
        product2.addAssociatedPart(part5);
        
        product3.addAssociatedPart(part6);
        product3.addAssociatedPart(part7);
        
        product4.addAssociatedPart(part8);
        product4.addAssociatedPart(part9);
        
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
        // Initializing Observable Lists //
        // // // // // // // // // // // //
        
        ObservableList<Integer> partIDObList = FXCollections.observableArrayList();
        inventory.getPartsList().iterator().forEachRemaining((n) -> partIDObList.add(n.getPartID()));
        
        ObservableList<String> partNameObList = FXCollections.observableArrayList();
        inventory.getPartsList().iterator().forEachRemaining((n) -> partNameObList.add(n.getName()));
        
        ObservableList<Integer> partInvObList = FXCollections.observableArrayList();
        inventory.getPartsList().iterator().forEachRemaining((n) -> partInvObList.add(n.getInStock()));
        
        ObservableList<Double> partPPUObList = FXCollections.observableArrayList();
        inventory.getPartsList().iterator().forEachRemaining((n) -> partPPUObList.add(n.getPrice()));
        
        ObservableList<Integer> productIDObList = FXCollections.observableArrayList();
        inventory.getProductsList().iterator().forEachRemaining((n) -> productIDObList.add(n.getProductID()));
        
        ObservableList<String> productNameObList = FXCollections.observableArrayList();
        inventory.getProductsList().iterator().forEachRemaining((n) -> productNameObList.add(n.getName()));
        
        ObservableList<Integer> productInvObList = FXCollections.observableArrayList();
        inventory.getProductsList().iterator().forEachRemaining((n) -> productInvObList.add(n.getInStock()));
        
        ObservableList<Double> productPPUObList = FXCollections.observableArrayList();
        inventory.getProductsList().iterator().forEachRemaining((n) -> productPPUObList.add(n.getPrice()));
        
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

        Label addPartIDLBL = new Label("ID");
        addPartIDLBL.setPrefWidth(160);
        GridPane.setMargin(addPartIDLBL, new Insets(20, 0, 10, 20));
        GridPane.setConstraints(addPartIDLBL, 0, 0);

        TextField addPartIDField = new TextField();
        addPartIDField.setPrefWidth(240);
        GridPane.setHgrow(addPartIDField, Priority.ALWAYS);
        GridPane.setMargin(addPartIDField, new Insets(20, 20, 10, 0));
        GridPane.setConstraints(addPartIDField, 1, 0);

        Label addPartNameLBL = new Label("Name");
        addPartNameLBL.setPrefWidth(160);
        GridPane.setMargin(addPartNameLBL, new Insets(10, 0, 10, 20));
        GridPane.setConstraints(addPartNameLBL, 0, 1);

        TextField addPartNameField = new TextField();
        addPartNameField.setPrefWidth(240);
        GridPane.setHgrow(addPartNameField, Priority.ALWAYS);
        GridPane.setMargin(addPartNameField, new Insets(10, 20, 10, 0));
        GridPane.setConstraints(addPartNameField, 1, 1);

        Label addPartStockLBL = new Label("Inventory");
        addPartStockLBL.setPadding(new Insets(10, 20, 10, 20));
        addPartStockLBL.setPrefWidth(160);
        GridPane.setConstraints(addPartStockLBL, 0, 2);

        TextField addPartStockField = new TextField();
        addPartStockField.setPrefWidth(240);
        GridPane.setHgrow(addPartStockField, Priority.ALWAYS);
        GridPane.setMargin(addPartStockField, new Insets(10, 20, 10, 0));
        GridPane.setConstraints(addPartStockField, 1, 2);

        Label addPartPPULBL = new Label("Price per Unit");
        addPartPPULBL.setPadding(new Insets(10, 20, 10, 20));
        addPartPPULBL.setPrefWidth(160);
        GridPane.setConstraints(addPartPPULBL, 0, 3);

        TextField addPartPPUField = new TextField();
        addPartPPUField.setPrefWidth(240);
        GridPane.setHgrow(addPartPPUField, Priority.ALWAYS);
        GridPane.setMargin(addPartPPUField, new Insets(10, 20, 10, 0));
        GridPane.setConstraints(addPartPPUField, 1, 3);

        Label addPartMaxLBL = new Label("Max");
        addPartMaxLBL.setPadding(new Insets(10, 20, 10, 20));
        addPartMaxLBL.setPrefWidth(160);
        GridPane.setConstraints(addPartMaxLBL, 0, 4);

        TextField addPartMaxField = new TextField();
        addPartMaxField.setPrefWidth(240);
        GridPane.setHgrow(addPartMaxField, Priority.ALWAYS);
        GridPane.setMargin(addPartMaxField, new Insets(10, 20, 10, 0));
        GridPane.setConstraints(addPartMaxField, 1, 4);

        Label addPartMinLBL = new Label("Min");
        addPartMinLBL.setPadding(new Insets(10, 20, 10, 20));
        addPartMinLBL.setPrefWidth(160);
        GridPane.setConstraints(addPartMinLBL, 0, 5);

        TextField addPartMinField = new TextField();
        addPartMinField.setPrefWidth(240);
        GridPane.setHgrow(addPartMinField, Priority.ALWAYS);
        GridPane.setMargin(addPartMinField, new Insets(10, 20, 10, 0));
        GridPane.setConstraints(addPartMinField, 1, 5);

        Label addPartMachIDLBL = new Label("Machine ID");
        addPartMachIDLBL.setPadding(new Insets(10, 20, 20, 20));
        addPartMachIDLBL.setPrefWidth(160);
        GridPane.setConstraints(addPartMachIDLBL, 0, 6);

        TextField addPartMachIDField = new TextField();
        addPartMachIDField.setPrefWidth(240);
        GridPane.setHgrow(addPartMachIDField, Priority.ALWAYS);
        GridPane.setMargin(addPartMachIDField, new Insets(10, 20, 20, 0));
        GridPane.setConstraints(addPartMachIDField, 1, 6);

        Label addPartCompNameLBL = new Label("Company Name");
        addPartCompNameLBL.setPadding(new Insets(10, 20, 20, 20));
        addPartCompNameLBL.setPrefWidth(160);
        GridPane.setConstraints(addPartCompNameLBL, 0, 6);

        TextField addPartCompNameField = new TextField();
        addPartCompNameField.setPrefWidth(240);
        GridPane.setHgrow(addPartCompNameField, Priority.ALWAYS);
        GridPane.setMargin(addPartCompNameField, new Insets(10, 20, 20, 0));
        GridPane.setConstraints(addPartCompNameField, 1, 6);

        addPartGrid.getChildren().addAll(addPartIDField, addPartNameField, addPartStockField, addPartPPUField, addPartMaxField, addPartMinField, addPartMachIDField);
        addPartGrid.getChildren().addAll(addPartIDLBL, addPartNameLBL, addPartStockLBL, addPartPPULBL, addPartMaxLBL, addPartMinLBL, addPartMachIDLBL);

        addPartRadio1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                addPartGrid.getChildren().removeAll(addPartCompNameLBL, addPartCompNameField);
                addPartGrid.getChildren().addAll(addPartMachIDLBL, addPartMachIDField);
            }
        });

        addPartRadio2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                addPartGrid.getChildren().removeAll(addPartMachIDLBL, addPartMachIDField);
                addPartGrid.getChildren().addAll(addPartCompNameLBL, addPartCompNameField);
            }
        });

        addPartBottom.setAlignment(Pos.CENTER_RIGHT);

        Button addPartSaveBTN = new Button("Save");
        HBox.setMargin(addPartSaveBTN, new Insets(20, 0, 0, 0));
        addPartSaveBTN.setPrefWidth(80);
        addPartSaveBTN.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                // Add Part to Relevant ArrayList
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

        Label addProductIDLBL = new Label("ID");
        GridPane.setConstraints(addProductIDLBL, 0, 0, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setMargin(addProductIDLBL, new Insets(100, 5, 5, 5));

        TextField addProductIDField = new TextField();
        GridPane.setConstraints(addProductIDField, 1, 0, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setMargin(addProductIDField, new Insets(100, 60, 5, 5));

        Label addProductNameLBL = new Label("Name");
        GridPane.setConstraints(addProductNameLBL, 0, 1, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setMargin(addProductNameLBL, new Insets(5));

        TextField addProductNameField = new TextField();
        GridPane.setConstraints(addProductNameField, 1, 1, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setMargin(addProductNameField, new Insets(5, 60, 5, 5));

        Label addProductStockLBL = new Label("Inventory");
        GridPane.setConstraints(addProductStockLBL, 0, 2, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setMargin(addProductStockLBL, new Insets(5));

        TextField addProductStockField = new TextField();
        GridPane.setConstraints(addProductStockField, 1, 2, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setMargin(addProductStockField, new Insets(5, 60, 5, 5));

        Label addProductPriceLBL = new Label("Price");
        GridPane.setConstraints(addProductPriceLBL, 0, 3, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setMargin(addProductPriceLBL, new Insets(5));

        TextField addProductPriceField = new TextField();
        GridPane.setConstraints(addProductPriceField, 1, 3, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setMargin(addProductPriceField, new Insets(5, 60, 5, 5));

        Label addProductMaxLBL = new Label("Max");
        GridPane.setConstraints(addProductMaxLBL, 0, 4, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setMargin(addProductMaxLBL, new Insets(5));

        TextField addProductMaxField = new TextField();
        GridPane.setConstraints(addProductMaxField, 1, 4, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setMargin(addProductMaxField, new Insets(5, 60, 5, 5));

        Label addProductMinLBL = new Label("Min");
        GridPane.setConstraints(addProductMinLBL, 0, 5, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setMargin(addProductMinLBL, new Insets(5));

        TextField addProductMinField = new TextField();
        GridPane.setConstraints(addProductMinField, 1, 5, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setMargin(addProductMinField, new Insets(5, 60, 5, 5));

        addProductLeft.getChildren().addAll(addProductIDLBL, addProductNameLBL, addProductStockLBL, addProductPriceLBL, addProductMaxLBL, addProductMinLBL);
        addProductLeft.getChildren().addAll(addProductIDField, addProductNameField, addProductStockField, addProductPriceField, addProductMaxField, addProductMinField);

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

        Label addProductAddPartStockHeader = new Label("Inventory Level");
        addProductAddPartStockHeader.setPadding(new Insets(5, 0, 5, 10));
        GridPane.setConstraints(addProductAddPartStockHeader, 2, 1);
        addProductAddPartStockHeader.prefWidthProperty().bind(addProductCenter.widthProperty());
        addProductAddPartStockHeader.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        ListView addProductAddPartStockList = new ListView();
        GridPane.setConstraints(addProductAddPartStockList, 2, 2);

        Label addProductAddPartPPUHeader = new Label("Price per Unit");
        addProductAddPartPPUHeader.setPadding(new Insets(5, 0, 5, 10));
        GridPane.setMargin(addProductAddPartPPUHeader, new Insets(0, 20, 0, 0));
        GridPane.setConstraints(addProductAddPartPPUHeader, 3, 1);
        addProductAddPartPPUHeader.prefWidthProperty().bind(addProductCenter.widthProperty());
        addProductAddPartPPUHeader.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        ListView addProductAddPartPPUList = new ListView();
        GridPane.setMargin(addProductAddPartPPUList, new Insets(0, 20, 0, 0));
        GridPane.setConstraints(addProductAddPartPPUList, 3, 2);

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

        Label addProductRemovePartStockHeader = new Label("Inventory Level");
        addProductRemovePartStockHeader.setPadding(new Insets(5, 0, 5, 10));
        GridPane.setConstraints(addProductRemovePartStockHeader, 2, 5);
        addProductRemovePartStockHeader.prefWidthProperty().bind(addProductCenter.widthProperty());
        addProductRemovePartStockHeader.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        ListView addProductRemovePartStockList = new ListView();
        GridPane.setConstraints(addProductRemovePartStockList, 2, 6);

        Label addProductRemovePartPPUHeader = new Label("Price per Unit");
        addProductRemovePartPPUHeader.setPadding(new Insets(5, 0, 5, 10));
        GridPane.setMargin(addProductRemovePartPPUHeader, new Insets(0, 20, 0, 0));
        GridPane.setConstraints(addProductRemovePartPPUHeader, 3, 5);
        addProductRemovePartPPUHeader.prefWidthProperty().bind(addProductCenter.widthProperty());
        addProductRemovePartPPUHeader.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        ListView addProductRemovePartPPUList = new ListView();
        GridPane.setMargin(addProductRemovePartPPUList, new Insets(0, 20, 0, 0));
        GridPane.setConstraints(addProductRemovePartPPUList, 3, 6);

        Button addProductRemovePartBTN = new Button("Delete");
        GridPane.setConstraints(addProductRemovePartBTN, 0, 7, 4, 1, HPos.RIGHT, VPos.CENTER);
        GridPane.setMargin(addProductRemovePartBTN, new Insets(10, 40, 20, 40));
        addProductRemovePartBTN.setPrefWidth(80);

        addProductCenter.getChildren().addAll(addProductSearchBTN, addProductSearchField);
        addProductCenter.getChildren().addAll(addProductAddPartIDHeader, addProductAddPartNameHeader, addProductAddPartStockHeader, addProductAddPartPPUHeader);
        addProductCenter.getChildren().addAll(addProductRemovePartIDHeader, addProductRemovePartNameHeader, addProductRemovePartStockHeader, addProductRemovePartPPUHeader);
        addProductCenter.getChildren().addAll(addProductAddPartIDList, addProductAddPartNameList, addProductAddPartStockList, addProductAddPartPPUList);
        addProductCenter.getChildren().addAll(addProductRemovePartIDList, addProductRemovePartNameList, addProductRemovePartStockList, addProductRemovePartPPUList);
        addProductCenter.getChildren().addAll(addProductAddPartBTN, addProductRemovePartBTN);

        Button addProductSaveBTN = new Button("Save");
        HBox.setMargin(addProductSaveBTN, new Insets(20, 0, 0, 0));
        addProductSaveBTN.setPrefWidth(80);
        addProductSaveBTN.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                // Add Product to Relevant ArrayList
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

        Label firstPartListLabel = new Label("Part ID");
        firstPartListLabel.setPadding(new Insets(5, 0, 5, 10));
        firstPartListLabel.prefWidthProperty().bind(partVBox1.widthProperty());
        firstPartListLabel.setAlignment(Pos.CENTER_LEFT);
        firstPartListLabel.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        ListView<Integer> partIDListView = new ListView<>(partIDObList);
        partIDListView.prefHeightProperty().bind(partVBox1.heightProperty());

        partVBox1.getChildren().addAll(firstPartListLabel, partIDListView);

        Label secondPartListLabel = new Label("Part Name");
        secondPartListLabel.setPadding(new Insets(5, 0, 5, 10));
        secondPartListLabel.prefWidthProperty().bind(partVBox2.widthProperty());
        secondPartListLabel.setAlignment(Pos.CENTER_LEFT);
        secondPartListLabel.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        ObservableList<String> partNameObservableList = FXCollections.observableArrayList("One", "Two", "Three", "Four", "Five");
        ListView<String> partNameListView = new ListView<>(partNameObservableList);
        partNameListView.prefHeightProperty().bind(partVBox2.heightProperty());

        partVBox2.getChildren().addAll(secondPartListLabel, partNameListView);

        Label thirdPartListLabel = new Label("Inventory Level");
        thirdPartListLabel.setPadding(new Insets(5, 0, 5, 10));
        thirdPartListLabel.prefWidthProperty().bind(partVBox3.widthProperty());
        thirdPartListLabel.setAlignment(Pos.CENTER_LEFT);
        thirdPartListLabel.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        ObservableList<Integer> partStockObservableList = FXCollections.observableArrayList(5, 5, 25, 10, 10);
        ListView<Integer> partStockListView = new ListView<>(partStockObservableList);
        partStockListView.prefHeightProperty().bind(partVBox3.heightProperty());

        partVBox3.getChildren().addAll(thirdPartListLabel, partStockListView);

        Label fourthPartListLabel = new Label("Price per Unit");
        fourthPartListLabel.setPadding(new Insets(5, 0, 5, 10));
        fourthPartListLabel.prefWidthProperty().bind(partVBox4.widthProperty());
        fourthPartListLabel.setAlignment(Pos.CENTER_LEFT);
        fourthPartListLabel.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        ObservableList<String> partPPUObservableList = FXCollections.observableArrayList("$5", "$5", "$25", "$10", "$10");
        ListView<String> partPPUListView = new ListView<>(partPPUObservableList);
        partPPUListView.prefHeightProperty().bind(partVBox4.heightProperty());

        partVBox4.getChildren().addAll(fourthPartListLabel, partPPUListView);

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
        // Make event, delete selected part

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

        Label firstProductListLabel = new Label("Product ID");
        firstProductListLabel.setPadding(new Insets(5, 0, 5, 10));
        firstProductListLabel.prefWidthProperty().bind(productVBox1.widthProperty());
        firstProductListLabel.setAlignment(Pos.CENTER_LEFT);
        firstProductListLabel.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        ObservableList<Integer> productIDObservableList = FXCollections.observableArrayList(1, 2, 3, 4, 5);
        ListView<Integer> productIDListView = new ListView<>(productIDObservableList);
        productIDListView.prefHeightProperty().bind(productVBox1.heightProperty());

        productVBox1.getChildren().addAll(firstProductListLabel, productIDListView);

        Label secondProductListLabel = new Label("Product Name");
        secondProductListLabel.setPadding(new Insets(5, 0, 5, 10));
        secondProductListLabel.prefWidthProperty().bind(productVBox1.widthProperty());
        secondProductListLabel.setAlignment(Pos.CENTER_LEFT);
        secondProductListLabel.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        ObservableList<String> productNameObservableList = FXCollections.observableArrayList("One", "Two", "Three", "Four", "Five");
        ListView<String> productNameListView = new ListView<>(productNameObservableList);
        productNameListView.prefHeightProperty().bind(productVBox1.heightProperty());

        productVBox2.getChildren().addAll(secondProductListLabel, productNameListView);

        Label thirdProductListLabel = new Label("Inventory Level");
        thirdProductListLabel.setPadding(new Insets(5, 0, 5, 10));
        thirdProductListLabel.prefWidthProperty().bind(productVBox1.widthProperty());
        thirdProductListLabel.setAlignment(Pos.CENTER_LEFT);
        thirdProductListLabel.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        ObservableList<Integer> productStockObservableList = FXCollections.observableArrayList(5, 5, 25, 10, 10);
        ListView<Integer> productStockListView = new ListView<>(productStockObservableList);
        productStockListView.prefHeightProperty().bind(productVBox1.heightProperty());

        productVBox3.getChildren().addAll(thirdProductListLabel, productStockListView);

        Label fourthProductListLabel = new Label("Price per Unit");
        fourthProductListLabel.setPadding(new Insets(5, 0, 5, 10));
        fourthProductListLabel.prefWidthProperty().bind(productVBox1.widthProperty());
        fourthProductListLabel.setAlignment(Pos.CENTER_LEFT);
        fourthProductListLabel.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

        ObservableList<String> productPPUObservableList = FXCollections.observableArrayList("$5", "$5", "$25", "$10", "$10");
        ListView<String> productPPUListView = new ListView<>(productPPUObservableList);
        productPPUListView.prefHeightProperty().bind(productVBox1.heightProperty());

        productVBox4.getChildren().addAll(fourthProductListLabel, productPPUListView);

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
