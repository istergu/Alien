
package alien;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
    public class addEdge {
    ArrayList<Location> loc;
    public addEdge(ArrayList<Location> loc) {
        this.loc = loc;
    }

    public void show(Stage st) {
        Label src = new Label("Source: ");
        Label dest = new Label("Destination: ");
        Label time = new Label("Time:");
        Label dist = new Label("Distance: ");
        TextField time1 = new TextField();
        TextField dist1 = new TextField();
        ObservableList<Location> srcss = FXCollections.observableList(loc);
        ObservableList<Location> dest1 = FXCollections.observableList(loc);
        ComboBox src1 = new ComboBox(srcss);
        ComboBox dst1 = new ComboBox(dest1);
        HBox bx1 = new HBox();
        bx1.getChildren().addAll(src, src1);
        bx1.setSpacing(5);
        bx1.setAlignment(Pos.CENTER);
        HBox bx2 = new HBox();
        bx2.getChildren().addAll(dest, dst1);
        bx2.setSpacing(5);
        bx2.setAlignment(Pos.CENTER);
        HBox bx3 = new HBox();
        bx3.getChildren().addAll(time, time1);
        bx3.setSpacing(5);
        bx3.setAlignment(Pos.CENTER);
        HBox bx4 = new HBox();
        bx4.getChildren().addAll(dist, dist1);
        bx4.setSpacing(5);
        bx4.setAlignment(Pos.CENTER);
        Button create = new Button("Create");
        Button back = new Button("Back");
        HBox bx5 = new HBox();
        bx5.getChildren().addAll(create, back);
        bx5.setSpacing(5);
        bx5.setAlignment(Pos.CENTER);
        VBox vb = new VBox();
        vb.getChildren().addAll(bx1, bx2, bx3, bx4, bx5);
        vb.setSpacing(5);
        vb.setAlignment(Pos.CENTER);
        Scene sc = new Scene(vb, 400, 400);
        
        st.setScene(sc);
        st.setTitle("Add New Edge");
        st.show();
        create.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                try {
                    EdgeRW edg = new EdgeRW();
                    int src3,dst3,time3,dist3;
                    time3 = Integer.parseInt(time1.getText());
                    dist3 = Integer.parseInt(dist1.getText());
                    src3 = loc.indexOf(src1.getSelectionModel().getSelectedItem());
                    dst3 = loc.indexOf(dst1.getSelectionModel().getSelectedItem());
                    WeightedGraph.Edge ed = new WeightedGraph.Edge(src3, dst3, time3, dist3);
                    edg.add(ed);
                    back.fire();
                } catch (Exception e) {
                }
            }
        });
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                (new Alien()).start(st);
            }
        });
    }
}
