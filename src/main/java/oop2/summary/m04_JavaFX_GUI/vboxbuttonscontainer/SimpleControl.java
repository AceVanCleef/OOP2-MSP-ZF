package oop2.summary.m04_JavaFX_GUI.vboxbuttonscontainer;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 * Created by Degonas on 29.06.2017.
 */
public class SimpleControl extends HBox {

    /* Rechtsbündiger Button: "Mit Buttons: Wenn ein Button: Button soll über die ganze Breite gehen; wenn zwei Button, dann einer immer Rechtsbündig" */

    private Button button01;
    private Button button02;
    private Button button03;    //Rechtsbündiger Button

    //#Spacer: makes sure that button03 will always stay at the right side.
    private HBox spacer;

    public SimpleControl(){
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
        this.setPrefWidth(500);    //to see a gap between button02 and button03 at the beginning.
    }

    private void initializeParts() {
        button01 = new Button("Button01: left");
        button02 = new Button("Button02: left");
        button03 = new Button("Button03: right");

        spacer = new HBox();
    }

    private void layoutParts(){
        //#Spacer: This is the core piece. It makes sure that the gap between controls to the left and to the right
        //          dynamically growths or shrinks.
        HBox.setHgrow(spacer, Priority.ALWAYS);

        //Pay attention to the order of the arguments:
        this.getChildren().addAll(button01, button02, spacer, button03);

        //optional gaps between each button
        this.setSpacing(10);
    }

    private void addEventHandlers(){
    }

    private void addValueChangedListeners(){
    }

    private void setupBindings(){
    }

}
