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
        int trafic[] = {0,0,0,0,0,0,0,0,0,0,1,1,1,1,2,2,2,1,1,0,0,0,0,0};
        Location tir = new Location("Tirana", 40, 50);
        Location durr = new Location("Durres", 60, 50);
        Location elb = new Location("Elbasan", 70, 60);
        
        Location_Timetravel tiran = new Location_Timetravel(tir, trafic);
        Location_Timetravel durres = new Location_Timetravel(durr, trafic);
        Location_Timetravel elbasan = new Location_Timetravel(elb, trafic); 
        
        Location_Timetravel loc[] = {tiran,durres,elbasan};
        
        int vertices = 3;
        WeightedGraph.Graph graph = new WeightedGraph.Graph(loc);
        graph.addEgde(1, 0, 35, 60);
        graph.addEgde(1, 2, 50, 80);
        graph.addEgde(0, 2, 40, 90);
        
        Dijkstra djk = new Dijkstra(graph);
        djk.dijkstra_GetMinDistances(0, vertices);
        
    }

}
