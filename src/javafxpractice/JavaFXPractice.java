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
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;

/**
 *
 * @author lethv
 */

public class JavaFXPractice extends Application {

    @Override
    public void start(Stage primaryStage) {

        Insets defaultPadding = new Insets(20);

        // Start Defining Base Panes
        //

        BorderPane root = new BorderPane();
        root.setPadding(defaultPadding);

        BorderPane addPartPane = new BorderPane();
        addPartPane.setPadding(defaultPadding);

        BorderPane addProductPane = new BorderPane();
        addProductPane.setPadding(defaultPadding);

        //
        // Finished Defining Base Panes

        // Start Defining Scenes
        //

        Scene mainScene = new Scene(root, 1200, 600);

        Scene addPartScene = new Scene(addPartPane, 480, 440);

        Scene addProductScene =  new Scene(addProductPane, 1200, 600);

        //
        // Finished Defining Scenes

        // Start Filling addPartPane
        //

        // Inside addPartPane
        HBox addPartTop = new HBox();
        GridPane addPartGrid = new GridPane();
        HBox addPartBottom = new HBox(20);

        addPartPane.setTop(addPartTop);
        addPartPane.setCenter(addPartGrid);
        addPartPane.setBottom(addPartBottom);

        // Inside addPartTop
        Label addPartHeader = new Label("Add Part");
        addPartHeader.setPadding(new Insets(0, 60, 40, 0));

        ToggleGroup addPartRadio = new ToggleGroup();

        RadioButton addPartRadio1 = new RadioButton("In-House");
        addPartRadio1.setPadding(new Insets(0, 20, 40, 0));
        addPartRadio1.setToggleGroup(addPartRadio);
        addPartRadio1.setSelected(true);

        RadioButton addPartRadio2 = new RadioButton("Outsourced");
        addPartRadio2.setPadding(new Insets(0, 0, 40, 0));
        addPartRadio2.setToggleGroup(addPartRadio);

        addPartTop.getChildren().addAll(addPartHeader, addPartRadio1, addPartRadio2);

        // Inside addPartGrid
        Label addPartIDLBL = new Label("ID");
        addPartIDLBL.setPadding(new Insets(10, 20, 10, 20));
        addPartIDLBL.setPrefWidth(180);
        GridPane.setConstraints(addPartIDLBL, 0, 0);

        TextField addPartIDField = new TextField();
        addPartIDField.setPrefWidth(240);
        GridPane.setConstraints(addPartIDField, 1, 0);

        Label addPartNameLBL = new Label("Name");
        addPartNameLBL.setPadding(new Insets(10, 20, 10, 20));
        addPartNameLBL.setPrefWidth(180);
        GridPane.setConstraints(addPartNameLBL, 0, 1);

        TextField addPartNameField = new TextField();
        addPartNameField.setPrefWidth(240);
        GridPane.setConstraints(addPartNameField, 1, 1);

        Label addPartStockLBL = new Label("Inventory");
        addPartStockLBL.setPadding(new Insets(10, 20, 10, 20));
        addPartStockLBL.setPrefWidth(180);
        GridPane.setConstraints(addPartStockLBL, 0, 2);

        TextField addPartStockField = new TextField();
        addPartStockField.setPrefWidth(240);
        GridPane.setConstraints(addPartStockField, 1, 2);

        Label addPartPPULBL = new Label("Price per Unit");
        addPartPPULBL.setPadding(new Insets(10, 20, 10, 20));
        addPartPPULBL.setPrefWidth(180);
        GridPane.setConstraints(addPartPPULBL, 0, 3);

        TextField addPartPPUField = new TextField();
        addPartPPUField.setPrefWidth(240);
        GridPane.setConstraints(addPartPPUField, 1, 3);

        Label addPartMaxLBL = new Label("Max");
        addPartMaxLBL.setPadding(new Insets(10, 20, 10, 20));
        addPartMaxLBL.setPrefWidth(180);
        GridPane.setConstraints(addPartMaxLBL, 0, 4);

        TextField addPartMaxField = new TextField();
        addPartMaxField.setPrefWidth(240);
        GridPane.setConstraints(addPartMaxField, 1, 4);

        Label addPartMinLBL = new Label("Min");
        addPartMinLBL.setPadding(new Insets(10, 20, 10, 20));
        addPartMinLBL.setPrefWidth(180);
        GridPane.setConstraints(addPartMinLBL, 0, 5);

        TextField addPartMinField = new TextField();
        addPartMinField.setPrefWidth(240);
        GridPane.setConstraints(addPartMinField, 1, 5);

        Label addPartMachIDLBL = new Label("Machine ID");
        addPartMachIDLBL.setPadding(new Insets(10, 20, 10, 20));
        addPartMachIDLBL.setPrefWidth(180);
        GridPane.setConstraints(addPartMachIDLBL, 0, 6);

        TextField addPartMachIDField = new TextField();
        addPartMachIDField.setPrefWidth(240);
        GridPane.setConstraints(addPartMachIDField, 1, 6);

        Label addPartCompNameLBL = new Label("Company Name");
        addPartCompNameLBL.setPadding(new Insets(10, 20, 10, 20));
        addPartCompNameLBL.setPrefWidth(180);
        GridPane.setConstraints(addPartCompNameLBL, 0, 6);

        TextField addPartCompNameField = new TextField();
        addPartCompNameField.setPrefWidth(240);
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

        // Inside addPartBottom
        addPartBottom.setAlignment(Pos.CENTER_RIGHT);

        Button addPartSaveBTN = new Button("Save");
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
        addPartCancelBTN.setPrefWidth(80);
        addPartCancelBTN.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(mainScene);
                primaryStage.show();
            }
        });

        addPartBottom.getChildren().addAll(addPartSaveBTN, addPartCancelBTN);

        //
        // Finished Filling addPartPane

        // Start Filling addProductPane
        //

        // Inside addProductPane
        HBox addProductTop = new HBox();
        GridPane addProductLeft = new GridPane();
        GridPane addProductCenter = new GridPane();
        HBox addProductBottom = new HBox(20);

        addProductPane.setTop(addProductTop);
        addProductPane.setLeft(addProductLeft);
        addProductPane.setCenter(addProductCenter);
        addProductPane.setBottom(addProductBottom);

        // Inside addProductTop
        Label addProductHeader = new Label("Add Product");

        addProductTop.getChildren().addAll(addProductHeader);

        // Inside addProductLeft
        Label addProductIDLBL = new Label("ID");
        GridPane.setConstraints(addProductIDLBL, 0, 0);

        TextField addProductIDField = new TextField();
        GridPane.setConstraints(addProductIDField, 1, 0);

        Label addProductNameLBL = new Label("Name");
        GridPane.setConstraints(addProductNameLBL, 0, 1);

        TextField addProductNameField = new TextField();
        GridPane.setConstraints(addProductNameField, 1, 1);

        Label addProductStockLBL = new Label("Inventory");
        GridPane.setConstraints(addProductStockLBL, 0, 2);

        TextField addProductStockField = new TextField();
        GridPane.setConstraints(addProductStockField, 1, 2);

        Label addProductPriceLBL = new Label("Price");
        GridPane.setConstraints(addProductPriceLBL, 0, 3);

        TextField addProductPriceField = new TextField();
        GridPane.setConstraints(addProductPriceField, 1, 3);

        Label addProductMaxLBL = new Label("Max");
        GridPane.setConstraints(addProductMaxLBL, 0, 4);

        TextField addProductMaxField = new TextField();
        GridPane.setConstraints(addProductMaxField, 1, 4);

        Label addProductMinLBL = new Label("Min");
        GridPane.setConstraints(addProductMinLBL, 0, 5);

        TextField addProductMinField = new TextField();
        GridPane.setConstraints(addProductMinField, 1, 5);

        addProductLeft.getChildren().addAll(addProductIDLBL, addProductNameLBL, addProductStockLBL, addProductPriceLBL, addProductMaxLBL, addProductMinLBL);
        addProductLeft.getChildren().addAll(addProductIDField, addProductNameField, addProductStockField, addProductPriceField, addProductMaxField, addProductMinField);

        // Inside addProductCenter
        Label addProductAddPartIDHeader = new Label("Part ID");
        GridPane.setConstraints(addProductAddPartIDHeader, 0, 0);

        ListView addProductAddPartIDList = new ListView();
        GridPane.setConstraints(addProductAddPartIDList, 0, 1);

        Label addProductAddPartNameHeader = new Label("Part Name");
        GridPane.setConstraints(addProductAddPartNameHeader, 1, 0);

        ListView addProductAddPartNameList = new ListView();
        GridPane.setConstraints(addProductAddPartNameList, 1, 1);

        Label addProductAddPartStockHeader = new Label("Inventory Level");
        GridPane.setConstraints(addProductAddPartStockHeader, 2, 0);

        ListView addProductAddPartStockList = new ListView();
        GridPane.setConstraints(addProductAddPartStockList, 2, 1);

        Label addProductAddPartPPUHeader = new Label("Price per Unit");
        GridPane.setConstraints(addProductAddPartPPUHeader, 3, 0);

        ListView addProductAddPartPPUList = new ListView();
        GridPane.setConstraints(addProductAddPartPPUList, 3, 1);

        Button addProductAddPartBTN = new  Button("Add");
        GridPane.setConstraints(addProductAddPartBTN, 3, 2);

        Label addProductRemovePartIDHeader = new Label("Part ID");
        GridPane.setConstraints(addProductRemovePartIDHeader, 0, 4);

        ListView addProductRemovePartIDList = new ListView();
        GridPane.setConstraints(addProductRemovePartIDList, 0, 5);

        Label addProductRemovePartNameHeader = new Label("Part Name");
        GridPane.setConstraints(addProductRemovePartNameHeader, 1, 4);

        ListView addProductRemovePartNameList = new ListView();
        GridPane.setConstraints(addProductRemovePartNameList, 1, 5);

        Label addProductRemovePartStockHeader = new Label("Inventory Level");
        GridPane.setConstraints(addProductRemovePartStockHeader, 2, 4);

        ListView addProductRemovePartStockList = new ListView();
        GridPane.setConstraints(addProductRemovePartStockList, 2, 5);

        Label addProductRemovePartPPUHeader = new Label("Price per Unit");
        GridPane.setConstraints(addProductRemovePartPPUHeader, 3, 4);

        ListView addProductRemovePartPPUList = new ListView();
        GridPane.setConstraints(addProductRemovePartPPUList, 3, 5);

        Button addProductRemovePartBTN = new Button("Delete");
        GridPane.setConstraints(addProductRemovePartBTN, 3, 6);

        addProductCenter.getChildren().addAll(addProductAddPartIDHeader, addProductAddPartNameHeader, addProductAddPartStockHeader, addProductAddPartPPUHeader);
        addProductCenter.getChildren().addAll(addProductRemovePartIDHeader, addProductRemovePartNameHeader, addProductRemovePartStockHeader, addProductRemovePartPPUHeader);
        addProductCenter.getChildren().addAll(addProductAddPartIDList, addProductAddPartNameList, addProductAddPartStockList, addProductAddPartPPUList);
        addProductCenter.getChildren().addAll(addProductRemovePartIDList, addProductRemovePartNameList, addProductRemovePartStockList, addProductRemovePartPPUList);
        addProductCenter.getChildren().addAll(addProductAddPartBTN, addProductRemovePartBTN);

        // Inside addProductBottom
        Button addProductSaveBTN = new Button("Save");
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
        addProductCancelBTN.setPrefWidth(80);
        addProductCancelBTN.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(mainScene);
                primaryStage.show();
            }
        });

        addProductBottom.getChildren().addAll(addProductSaveBTN, addProductCancelBTN);

        //
        // Finished Filling addProductPane

        // Start Filling root
        //

        Label rootHeader = new Label("Inventory Management System");
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

        //
        // Finished Filling root

        // Start Filling rootCenter
        //

        BorderPane partPane = new BorderPane();
        partPane.setPadding(defaultPadding);
        partPane.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderStroke.THIN)));
        BorderPane.setAlignment(partPane, Pos.CENTER);

        BorderPane productPane = new BorderPane();
        productPane.setPadding(defaultPadding);
        productPane.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderStroke.THIN)));
        BorderPane.setAlignment(productPane, Pos.CENTER);

        rootCenter.getChildren().addAll(partPane, productPane);

        //
        // Finished Filling rootCenter

        // Start Filling partPane
        //

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

        //
        // Finished Filling partPane

            // Start Creating partPaneTop
            //

            Label partLabel = new Label("Parts");
            HBox.setMargin(partLabel, new Insets(0, 60, 0, 20));

            Button partSearchBTN = new Button("Search");
            partSearchBTN.setPrefWidth(80);
            // Make event to search for part in relevant text field

            TextField partSearchField = new TextField();
            HBox.setHgrow(partSearchField, Priority.ALWAYS);

            partPaneTop.getChildren().addAll(partLabel, partSearchBTN, partSearchField);

            //
            // Finished Creating partPaneTop

            // Start Filling partListView
            //

            VBox partVBox1 = new VBox();
            HBox.setHgrow(partVBox1, Priority.ALWAYS);
            VBox partVBox2 = new VBox();
            HBox.setHgrow(partVBox2, Priority.ALWAYS);
            VBox partVBox3 = new VBox();
            HBox.setHgrow(partVBox3, Priority.ALWAYS);
            VBox partVBox4 = new VBox();
            HBox.setHgrow(partVBox4, Priority.ALWAYS);

            partListView.getChildren().addAll(partVBox1, partVBox2, partVBox3, partVBox4);

            //
            // Finished Filling partListView

                // Start Filling partVBox1
                //

                Label firstPartListLabel = new Label("Part ID");
                firstPartListLabel.setPadding(new Insets(5, 0, 5, 10));
                firstPartListLabel.prefWidthProperty().bind(partVBox1.widthProperty());
                firstPartListLabel.setAlignment(Pos.CENTER_LEFT);
                firstPartListLabel.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

                ObservableList<Integer> partIDObservableList = FXCollections.observableArrayList(1, 2, 3, 4, 5);
                ListView<Integer> partIDListView = new ListView<>(partIDObservableList);
                partIDListView.prefHeightProperty().bind(partVBox1.heightProperty());

                partVBox1.getChildren().addAll(firstPartListLabel, partIDListView);

                //
                // Finished Filling partVBox1

                // Start Filling partVBox2
                //

                Label secondPartListLabel = new Label("Part Name");
                secondPartListLabel.setPadding(new Insets(5, 0, 5, 10));
                secondPartListLabel.prefWidthProperty().bind(partVBox2.widthProperty());
                secondPartListLabel.setAlignment(Pos.CENTER_LEFT);
                secondPartListLabel.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

                ObservableList<String> partNameObservableList = FXCollections.observableArrayList("One", "Two", "Three", "Four", "Five");
                ListView<String> partNameListView = new ListView<>(partNameObservableList);
                partNameListView.prefHeightProperty().bind(partVBox2.heightProperty());

                partVBox2.getChildren().addAll(secondPartListLabel, partNameListView);

                //
                // Finished Filling partVBox2

                // Start Filling partVBox3
                //

                Label thirdPartListLabel = new Label("Inventory Level");
                thirdPartListLabel.setPadding(new Insets(5, 0, 5, 10));
                thirdPartListLabel.prefWidthProperty().bind(partVBox3.widthProperty());
                thirdPartListLabel.setAlignment(Pos.CENTER_LEFT);
                thirdPartListLabel.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

                ObservableList<Integer> partStockObservableList = FXCollections.observableArrayList(5, 5, 25, 10, 10);
                ListView<Integer> partStockListView = new ListView<>(partStockObservableList);
                partStockListView.prefHeightProperty().bind(partVBox3.heightProperty());

                partVBox3.getChildren().addAll(thirdPartListLabel, partStockListView);

                //
                // Finished Filling partVBox3

                // Start Filling partVBox4
                //

                Label fourthPartListLabel = new Label("Price per Unit");
                fourthPartListLabel.setPadding(new Insets(5, 0, 5, 10));
                fourthPartListLabel.prefWidthProperty().bind(partVBox4.widthProperty());
                fourthPartListLabel.setAlignment(Pos.CENTER_LEFT);
                fourthPartListLabel.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

                ObservableList<String> partPPUObservableList = FXCollections.observableArrayList("$5", "$5", "$25", "$10", "$10");
                ListView<String> partPPUListView = new ListView<>(partPPUObservableList);
                partPPUListView.prefHeightProperty().bind(partVBox4.heightProperty());

                partVBox4.getChildren().addAll(fourthPartListLabel, partPPUListView);

                //
                // Finished Filling partVBox4

            // Start Creating partPaneBottom
            //

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

            //
            // Finished Creating partPaneBottom

        // Start Creating productPane
        //

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

        //
        // Finished Creating productPane

            // Start Creating productPaneTop
            //

            Label productLabel = new Label("Products");
            HBox.setMargin(productLabel, new Insets(0, 60, 0, 20));

            Button productSearchBTN = new Button("Search");
            productSearchBTN.setPrefWidth(80);
            // Make event to search for product in relevant text field

            TextField productSearchField = new TextField();
            HBox.setHgrow(productSearchField, Priority.ALWAYS);

            productPaneTop.getChildren().addAll(productLabel, productSearchBTN, productSearchField);

            //
            // Finished Creating productPaneTop

            // Start Filling productListView
            //

            VBox productVBox1 = new VBox();
            HBox.setHgrow(productVBox1, Priority.ALWAYS);
            VBox productVBox2 = new VBox();
            HBox.setHgrow(productVBox2, Priority.ALWAYS);
            VBox productVBox3 = new VBox();
            HBox.setHgrow(productVBox3, Priority.ALWAYS);
            VBox productVBox4 = new VBox();
            HBox.setHgrow(productVBox4, Priority.ALWAYS);

            productListView.getChildren().addAll(productVBox1, productVBox2, productVBox3, productVBox4);

            //
            // Finished Filling productListView

                // Start Filling productVBox1
                //

                Label firstProductListLabel = new Label("Product ID");
                firstProductListLabel.setPadding(new Insets(5, 0, 5, 10));
                firstProductListLabel.prefWidthProperty().bind(productVBox1.widthProperty());
                firstProductListLabel.setAlignment(Pos.CENTER_LEFT);
                firstProductListLabel.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

                ObservableList<Integer> productIDObservableList = FXCollections.observableArrayList(1, 2, 3, 4, 5);
                ListView<Integer> productIDListView = new ListView<>(productIDObservableList);
                productIDListView.prefHeightProperty().bind(productVBox1.heightProperty());

                productVBox1.getChildren().addAll(firstProductListLabel, productIDListView);

                //
                // Finished Filling productVBox1

                // Start Filling productVBox2
                //

                Label secondProductListLabel = new Label("Product Name");
                secondProductListLabel.setPadding(new Insets(5, 0, 5, 10));
                secondProductListLabel.prefWidthProperty().bind(productVBox1.widthProperty());
                secondProductListLabel.setAlignment(Pos.CENTER_LEFT);
                secondProductListLabel.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

                ObservableList<String> productNameObservableList = FXCollections.observableArrayList("One", "Two", "Three", "Four", "Five");
                ListView<String> productNameListView = new ListView<>(productNameObservableList);
                productNameListView.prefHeightProperty().bind(productVBox1.heightProperty());

                productVBox2.getChildren().addAll(secondProductListLabel, productNameListView);

                //
                // Finished Filling productVBox2

                // Start Filling productVBox3
                //

                Label thirdProductListLabel = new Label("Inventory Level");
                thirdProductListLabel.setPadding(new Insets(5, 0, 5, 10));
                thirdProductListLabel.prefWidthProperty().bind(productVBox1.widthProperty());
                thirdProductListLabel.setAlignment(Pos.CENTER_LEFT);
                thirdProductListLabel.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

                ObservableList<Integer> productStockObservableList = FXCollections.observableArrayList(5, 5, 25, 10, 10);
                ListView<Integer> productStockListView = new ListView<>(productStockObservableList);
                productStockListView.prefHeightProperty().bind(productVBox1.heightProperty());

                productVBox3.getChildren().addAll(thirdProductListLabel, productStockListView);

                //
                // Finished Filling productVBox3

                // Start Filling productVBox4
                //

                Label fourthProductListLabel = new Label("Price per Unit");
                fourthProductListLabel.setPadding(new Insets(5, 0, 5, 10));
                fourthProductListLabel.prefWidthProperty().bind(productVBox1.widthProperty());
                fourthProductListLabel.setAlignment(Pos.CENTER_LEFT);
                fourthProductListLabel.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.THIN)));

                ObservableList<String> productPPUObservableList = FXCollections.observableArrayList("$5", "$5", "$25", "$10", "$10");
                ListView<String> productPPUListView = new ListView<>(productPPUObservableList);
                productPPUListView.prefHeightProperty().bind(productVBox1.heightProperty());

                productVBox4.getChildren().addAll(fourthProductListLabel, productPPUListView);

                //
                // Finished Filling productVBox4

            // Start Creating productPaneBottom
            //

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

            //
            // Finished Creating productPaneBottom

        // Start Showing mainScene
        //

        primaryStage.setTitle("Inventory Management System");
        primaryStage.setScene(mainScene);
        primaryStage.show();

        //
        // Finished Showing mainScene
    }

    public static void main(String[] args) {
        launch(args);
    }
}
