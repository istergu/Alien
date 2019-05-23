package alien;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Alien extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Pershendetje !");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Check out Tirana");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Check out Tirana");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        // launch(args);
        Location tir = new Location("Tirana", 40, 50, 0);
        Location durr = new Location("Durres", 60, 50, 45);
        Location elbasan = new Location("Elbasan", 70, 60, 35);
        int vertices = 3;
        WeightedGraph.Graph graph = new WeightedGraph.Graph(vertices);
        graph.addEgde(0, 1, 30, 45, tir);
        graph.addEgde(0, 2, 35, 60, tir);
        graph.addEgde(1, 0, 30, 45, durr);
        graph.addEgde(2, 0, 35, 60, elbasan);
        graph.printGraph();
    }

}
