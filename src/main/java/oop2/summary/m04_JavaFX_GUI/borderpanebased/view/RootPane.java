package oop2.summary.m04_JavaFX_GUI.borderpanebased.view;

import javafx.scene.layout.BorderPane;
import oop2.summary.m04_JavaFX_GUI.borderpanebased.presentationmodel.RootPM;

/**
 * Created by Degonas on 28.06.2017.
 */
public class RootPane extends BorderPane {

    private final RootPM pm;

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
    }

    private void layoutParts(){
    }

    private  void addEventHandlers() {
    }

    private void addValueChangedListeners() {
    }

    private void setupBindings() {
    }
}