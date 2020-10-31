package com.odiesta;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        VBox root = new VBox();
//
//        Path path = new Path();
//
//        MoveTo moveTo = new MoveTo();
//        moveTo.setX(50.0);
//        moveTo.setY(50.0);
//
//        CubicCurveTo cubicCurveTo = new CubicCurveTo();
//        cubicCurveTo.setControlX1(50.0);
//        cubicCurveTo.setControlX2(50.0);
//        cubicCurveTo.setControlY1(50.0);
//        cubicCurveTo.setControlY2(50.0);
//        cubicCurveTo.setX(150.0);
//        cubicCurveTo.setY(150.0);
//
//        ClosePath closePath = new ClosePath();
//
//        path.getElements().addAll(moveTo, cubicCurveTo, closePath);
//
//        root.getChildren().add(path);
//
//        Scene scene = new Scene(root, 500, 400);
//        primaryStage.setTitle("Path test");
//        primaryStage.setScene(scene);
//        primaryStage.show();


        Parent root = FXMLLoader.load(getClass().getResource("pathElement.fxml"));
        primaryStage.setTitle("Path Element Creator");
        primaryStage.setScene(new Scene(root, 700, 575));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
