package alien;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Arrays;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.control.TextArea;

public class Alien extends Application {

    @Override
    public void start(Stage st) {
        LocRW lrw = new LocRW();
        PerRW prw = new PerRW();
        EdgeRW edrw = new EdgeRW();
        ArrayList<Location_Timetravel> loctime = lrw.read();
        ArrayList<Person> pers = prw.read();
        ArrayList<WeightedGraph.Edge> edg = edrw.read();
        ArrayList<Location> loc = new ArrayList<Location>();
        for (Location_Timetravel x : loctime) {
            loc.add(x.getLocation());
        }
        TableView table1 = new TableView();
        table1.setEditable(true);
        TableColumn<Person, String> stock1 = new TableColumn("Name");
        stock1.setMinWidth(100);
        stock1.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getName()));
        TableColumn<Person, String> moq1 = new TableColumn("Surname");
        moq1.setMinWidth(100);
        moq1.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getSurname()));
        TableColumn<Person, String> pro1 = new TableColumn("Age");
        pro1.setMinWidth(100);
        pro1.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(Integer.toString(cellData.getValue().getAge())));
        TableColumn<Person, String> cat1 = new TableColumn("Arrival Time");
        cat1.setMinWidth(100);
        cat1.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(Integer.toString(cellData.getValue().getArrival_time())));
        TableColumn<Person, String> purd1 = new TableColumn("Source");
        purd1.setMinWidth(100);
        purd1.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getSource().getName()));

        TableColumn<Person, String> expd1 = new TableColumn("Destination");
        expd1.setMinWidth(100);
        expd1.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getDestination().getName()));
        TableColumn<Person, String> purp1 = new TableColumn("Urgent");
        purp1.setMinWidth(100);
        purp1.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(Boolean.toString(cellData.getValue().isUrgent())));
        table1.getColumns().addAll(stock1, moq1, pro1, cat1, purd1, expd1, purp1);
        
        table1.setItems(FXCollections.observableArrayList(
                pers
        ));
        Button add = new Button("Add New Person");
        Button del = new Button("Delete Person");
        Button opt = new Button("Optimization");
        HBox hb = new HBox();
        hb.setSpacing(5);
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().addAll(add, del, opt);
        VBox vb = new VBox();
        vb.setSpacing(5);
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(table1, hb);

        ////////////////////////////////////
        ////////////////////////////////////
        TableView<Location_Timetravel> table2 = new TableView();
        table2.setEditable(true);
        TableColumn<Location_Timetravel, String> stock2 = new TableColumn("Name");
        stock2.setMinWidth(100);
        stock2.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getLocation().getName()));
        
        TableColumn<Location_Timetravel, String> moq2 = new TableColumn("X-coordinate");
        moq2.setMinWidth(100);
        moq2.setCellValueFactory(cellData -> new ReadOnlyStringWrapper( Float.toString(cellData.getValue().getLocation().getX())));
        
        TableColumn<Location_Timetravel, String> pro2 = new TableColumn("Y-coordinate");
        pro2.setMinWidth(100);
        pro2.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(Float.toString(cellData.getValue().getLocation().getY())));
        
        TableColumn<Location_Timetravel, String> cat2 = new TableColumn("Trafic times");
        cat2.setMinWidth(100);
        cat2.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(Arrays.toString(cellData.getValue().getTrafic())));
        
        table2.getColumns().addAll(stock2, moq2, pro2, cat2);
        table2.setItems(FXCollections.observableArrayList(
                loctime
        ));
        Button add2 = new Button("Add time_travel");
        Button del2 = new Button("Delete time_travel");
        HBox hb1 = new HBox();
        hb1.setSpacing(5);
        hb1.setAlignment(Pos.CENTER);
        hb1.getChildren().addAll(add2, del2);
        VBox vb1 = new VBox();
        vb1.setSpacing(5);
        vb1.setAlignment(Pos.CENTER);
        vb1.getChildren().addAll(table2, hb1);

        /////////////////////////////////////////
        TableView table3 = new TableView();
        table3.setEditable(true);
        TableColumn<WeightedGraph.Edge, String> stock3 = new TableColumn("Source");
        stock3.setMinWidth(100);
        stock3.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(loc.get(cellData.getValue().source).getName()));
        TableColumn<WeightedGraph.Edge, String> moq3 = new TableColumn("Destination");
        moq3.setMinWidth(100);
        moq3.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(loc.get(cellData.getValue().destination).getName()));
        TableColumn<WeightedGraph.Edge, String> pro3 = new TableColumn("Time");
        pro3.setMinWidth(100);
        pro3.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(Integer.toString(cellData.getValue().time)));
        TableColumn<WeightedGraph.Edge, String> cat3 = new TableColumn("Distance");
        cat3.setMinWidth(100);
        cat3.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(Integer.toString(cellData.getValue().distance)));
        table3.getColumns().addAll(stock3, moq3, pro3, cat3);
        table3.setItems(FXCollections.observableArrayList(
                edg
        ));
        Button add3 = new Button("Add Edge");
        Button del3 = new Button("Delete Edge");
        HBox hb2 = new HBox();
        hb2.setSpacing(5);
        hb2.setAlignment(Pos.CENTER);
        hb2.getChildren().addAll(add3, del3);
        VBox vb2 = new VBox();
        vb2.setSpacing(5);
        vb2.setAlignment(Pos.CENTER);
        vb2.getChildren().addAll(table3, hb2);
        TextArea txa = new TextArea();
        VBox vb3 = new VBox();
        vb3.setSpacing(5);
        vb3.setAlignment(Pos.CENTER);
        vb3.getChildren().addAll(txa);
        ///////////////////////////////////////////////////////
        TabPane tabs = new TabPane();
        tabs.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        Tab tabpro = new Tab();
        tabpro.setText("Persons");
        tabpro.setContent(vb);
        Tab tabpro1 = new Tab();
        tabpro1.setText("Time-travel");
        tabpro1.setContent(vb1);
        Tab tabpro2 = new Tab();
        tabpro2.setText("Edges");
        tabpro2.setContent(vb2);
        Tab dij = new Tab();
        dij.setText("Optimization");
        dij.setContent(vb3);
        tabs.getTabs().addAll(tabpro, tabpro1, tabpro2, dij);

        BorderPane bp = new BorderPane();
        bp.setCenter(tabs);
        Scene sc = new Scene(bp, 1000, 600);
        st.setScene(sc);
        st.setX(100);
        st.setResizable(false);
        st.setY(100);
        st.setTitle("Alien travel");
        st.show();
        opt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                WeightedGraph.Graph graph = new WeightedGraph.Graph(loctime.size());
                graph.addEgdes(edg);
                int sele = table1.getSelectionModel().getSelectedIndex();
                Person prs = pers.get(sele);
                Dijkstra djk = new Dijkstra(graph,loctime,prs);
                for(WeightedGraph.Edge x : edg){
                 if( loc.get(x.source).getName().equals(prs.source.getName()) ) sele = x.source;
                }
                if (!prs.urgent){
                    djk.dijkstra_GetMinDistances(sele, loctime.size());
                } else {
                    djk.dijkstra_GetMinTime(sele, loctime.size());
                }
                txa.setText(djk.temp);
                tabs.getSelectionModel().selectLast();
            }
        });

        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                (new addPerson(loc)).show(st);
            }
        });

        add2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                (new addLoctime()).show(st);
            }
        });
        
        add3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                (new addEdge(loc)).show(st);
            }
        });
        
        del2.setOnAction( new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event
            ) {
                loctime.remove(table2.getSelectionModel().getSelectedIndex());
                LocRW lorw = new LocRW();
                lorw.setLoc(loctime);
                table2.setItems(FXCollections.observableArrayList(
                        loctime
                ));
                table2.refresh();
            }
        }
        );
        
        del.setOnAction( new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event
            ) {
                pers.remove(table1.getSelectionModel().getSelectedIndex());
                PerRW lorw = new PerRW();
                lorw.setPers(pers);
                table1.setItems(FXCollections.observableArrayList(
                      pers  
                ));
                table1.refresh();
            }
        }
        );
        
        del3.setOnAction( new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event
            ) {
                edg.remove(table3.getSelectionModel().getSelectedIndex());
                EdgeRW lorw = new EdgeRW();
                lorw.setEdge(edg);
                table3.setItems(FXCollections.observableArrayList(
                      edg
                ));
                table3.refresh();
            }
        }
        );
    }

    public static void main(String[] args) {
        launch(args);
//        int trafic[] = {0,0,0,0,0,0,0,0,0,0,1,1,1,1,2,2,2,1,1,0,0,0,0,0};
//        Location tir = new Location("Tirana", 40, 50);
//        Location durr = new Location("Durres", 60, 50);
//        Location elb = new Location("Elbasan", 70, 60);
//        
//        Location_Timetravel tiran = new Location_Timetravel(tir, trafic);
//        Location_Timetravel durres = new Location_Timetravel(durr, trafic);
//        Location_Timetravel elbasan = new Location_Timetravel(elb, trafic); 
//        
//        Location_Timetravel loc[] = {tiran,durres,elbasan};
//        
//        int vertices = 3;
//        WeightedGraph.Graph graph = new WeightedGraph.Graph(loc);
//        graph.addEgde(1, 0, 35, 60);
//        graph.addEgde(1, 2, 50, 80);
//        graph.addEgde(0, 2, 40, 90);
//        
//        Dijkstra djk = new Dijkstra(graph);
//        djk.dijkstra_GetMinDistances(0, vertices);

    }

}
