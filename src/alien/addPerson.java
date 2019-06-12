
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
    public class addPerson {
    ArrayList<Location> loc;
    public addPerson(ArrayList<Location> loc) {
        this.loc = loc;
    }

    public void show(Stage st) {
        Label emer = new Label("Name: ");
        Label mbiemer = new Label("Surname: ");
        Label age = new Label("Age:");
        Label time = new Label("Arrival Time: ");
        Label phon = new Label("Source: ");
        Label salr = new Label("Destination: ");
        TextField emer1 = new TextField();
        TextField mbie1 = new TextField();
        TextField age1 = new TextField();
        TextField time1 = new TextField();
        ObservableList<Location> srcss = FXCollections.observableList(loc);
        ObservableList<Location> dest = FXCollections.observableList(loc);
        ComboBox src = new ComboBox(srcss);
        ComboBox dst = new ComboBox(dest);
        CheckBox urgent = new CheckBox("Urgent");
        HBox bx1 = new HBox();
        bx1.getChildren().addAll(emer, emer1);
        bx1.setSpacing(5);
        bx1.setAlignment(Pos.CENTER);
        HBox bx2 = new HBox();
        bx2.getChildren().addAll(mbiemer, mbie1);
        bx2.setSpacing(5);
        bx2.setAlignment(Pos.CENTER);
        HBox bx3 = new HBox();
        bx3.getChildren().addAll(age, age1);
        bx3.setSpacing(5);
        bx3.setAlignment(Pos.CENTER);
        HBox bx4 = new HBox();
        bx4.getChildren().addAll(time, time1);
        bx4.setSpacing(5);
        bx4.setAlignment(Pos.CENTER);
        HBox bx5 = new HBox();
        bx5.getChildren().addAll(phon, src);
        bx5.setSpacing(5);
        bx5.setAlignment(Pos.CENTER);
        HBox bx6 = new HBox();
        bx6.getChildren().addAll(salr, dst);
        bx6.setSpacing(5);
        bx6.setAlignment(Pos.CENTER);
        HBox bx7 = new HBox();
        bx7.getChildren().addAll(urgent);
        bx7.setSpacing(5);
        bx7.setAlignment(Pos.CENTER);
        Button create = new Button("Create");
        Button back = new Button("Back");
        HBox bx8 = new HBox();
        bx8.getChildren().addAll(create, back);
        bx8.setSpacing(5);
        bx8.setAlignment(Pos.CENTER);
        VBox vb = new VBox();
        vb.getChildren().addAll(bx1, bx2, bx3, bx4, bx5, bx6, bx7, bx8);
        vb.setSpacing(5);
        vb.setAlignment(Pos.CENTER);
        Scene sc = new Scene(vb, 400, 400);
        
        st.setScene(sc);
        st.setTitle("Register New Person");
        st.show();
        create.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                try {
                    PerRW erw = new PerRW();
                    String name2, surn2;
                    int time,age;
                    boolean urg;
                    Location src1,dst1;
                    name2 = emer1.getText();
                    surn2 = mbie1.getText();
                    age = Integer.parseInt(age1.getText());
                    time = Integer.parseInt(time1.getText());
                    urg = urgent.isSelected();
                    src1 = (Location) src.getSelectionModel().getSelectedItem();
                    dst1 = (Location) dst.getSelectionModel().getSelectedItem();
                    Person per = new Person(name2, surn2, age, time, src1, dst1, urg);
                    erw.add(per);
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
