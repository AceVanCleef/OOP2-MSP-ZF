package oop2.summary.m04_JavaFX_GUI.borderpanebased.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import oop2.summary.m04_JavaFX_GUI.borderpanebased.presentationmodel.RootPM;

/**
 * Created by Degonas on 28.06.2017.
 */
public class RootPane extends BorderPane {

    private final RootPM pm;

    /* Controls */
    private Label       label1;
    private Label       label2;
    private TextField   tf1;
    private TextField   tf2;
    private Button      button;

    /* Intermediate Pane (could be a separate class if necessary) */
    private VBox center;

    public RootPane(RootPM pm){
        this.pm = pm;

        //In ViewMixin - interface:
        initializeSelf();               //default
        initializeParts();              //abstract
        layoutParts();                  //abstract
        addEventHandlers();             //default
        addValueChangedListeners();     //default
        setupBindings();                //default
        //..and are summarized in the method body of "default void init()"
        //Tip: When overriding from an interface, methods must be declared public.
    }


    private void initializeSelf() {
    }

    private void initializeParts(){
        label1 = new Label("Titel");
        label2 = new Label("label1");

        tf1 = new TextField();
        tf2 = new TextField();

        button = new Button("What does it do?");

        center = new VBox();
    }

    private void layoutParts(){
        /* Gridpane: */
        this.setTop(label1);
        this.setCenter(center);
        this.setBottom(button);     //button immer ganz unten

        /* VBox center: */
        center.getChildren().addAll(tf1, tf2, label2);

        /* Resizing: Maximale Breite für Controls */
        button.setMaxWidth(Double.MAX_VALUE);   //button width = pane width
        //Da die Textfelder Kinder der VBox center sind -> nutzen bereits volle breite aus.

        /* Beautification */
        //Abstand zwischen Kindern. Bei VBox in vertikaler Richtung.
        center.setSpacing(10);
        //Padding - Abstand zwischen VBox und seinen Kindern:
        //center.setPadding(new Insets(5, 0, 5, 0));
        //Auch einzelne Controls können Paddings haben:
        label1.setPadding(new Insets(5));
    }

    private  void addEventHandlers() {
        button.setOnAction(event -> {
            //do stuff
        });
    }

    private void addValueChangedListeners() {
        //todo: a good example. anything that makes sense.
    }

    private void setupBindings() {
        //todo
       // tf1.textProperty().bindBidirectional(...);
       // tf2.textProperty().bindBidirectional(...);
    }
}
