/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class addLoctime {

    public addLoctime() {
    }

    public void show(Stage st) {
        Label emer = new Label("Name: ");
        Label mbiemer = new Label("X: ");
        Label age = new Label("Y:");
        Label time = new Label("time indexes: ");
        TextField emer1 = new TextField();
        TextField mbie1 = new TextField();
        TextField age1 = new TextField();
        TextField time1 = new TextField();
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
        Button create = new Button("Create");
        Button back = new Button("Back");
        HBox bx8 = new HBox();
        bx8.getChildren().addAll(create, back);
        bx8.setSpacing(5);
        bx8.setAlignment(Pos.CENTER);
        VBox vb = new VBox();
        vb.getChildren().addAll(bx1, bx2, bx3, bx4, bx8);
        vb.setSpacing(5);
        vb.setAlignment(Pos.CENTER);
        Scene sc = new Scene(vb, 300, 400);
        st.setScene(sc);
        st.setTitle("Register New Location_Timetravel");
        st.show();
        create.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                try {
                    LocRW erw = new LocRW();
                    String name2,time;
                    float age, sur;
                    boolean urg;
                    Location src1, dst1;
                    name2 = emer1.getText();
                    sur = Float.parseFloat(mbie1.getText());
                    age = Float.parseFloat(age1.getText());
                    time = time1.getText();
                    String[] str = time.split(" ");
                    int size = str.length;
                    int[] arr = new int[size];
                    for (int i = 0; i < size; i++) {
                        arr[i] = Integer.parseInt(str[i]);
                    }
                    Location lo = new Location(name2, sur,age);
                    Location_Timetravel per = new Location_Timetravel(lo,arr);
                    erw.add(per);
                    back.fire();
                } catch (Exception e) {
                    System.err.println(e);
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
