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
    private Label       titleLabel;
    private Label       previewLabel;
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
        titleLabel = new Label("Epic String Concatinator");
        previewLabel = new Label();

        tf1 = new TextField();
        tf2 = new TextField();

        button = new Button("Print to Console");

        center = new VBox();
    }

    private void layoutParts(){
        /*** Gridpane: ***/
        this.setTop(titleLabel);
        this.setCenter(center);
        this.setBottom(button);     //button immer ganz unten
        /*** VBox center: ***/
        center.getChildren().addAll(tf1, tf2, previewLabel);


        /*** #Abstände ***/
        //Abstand zwischen Kindern. Bei VBox in vertikaler Richtung. Bei HBox in horizontaler.
        center.setSpacing(10);
        //Padding - Abstand zwischen VBox und seinen Kindern:
        center.setPadding(new Insets(5, 0, 5, 0));
        //Auch einzelne Controls können Paddings haben:
        titleLabel.setPadding(new Insets(5));


        //#enable/disableV02 (Logik im View [deprecated]): Button am Anfang disablen:
       // button.setDisable(true);


        /*** #ButtonMaxWidth: Maximale Breite für Controls ***/
        button.setMaxWidth(Double.MAX_VALUE);   //button width = pane width
        //Da die Textfelder Kinder der VBox center sind, wird ihre Breite autom. angepasst.
    }

    private  void addEventHandlers() {
        button.setOnAction(event -> {
            pm.printToConsole();
            //do other stuff / trigger logic
        });
    }


    private void addValueChangedListeners() {
        //#enable/disableV02 (Logik im View [deprecated]):  Wenn tf1.textProperty() und/oder tf2.textProperty() == "", dann disable button
//        tf1.textProperty().addListener((observable, oldValue, newValue) -> {
//            if(newValue.length() == 0){
//                button.setDisable(true);
//            } else if(tf2.getText().length() > 0) {
//                button.setDisable(false);
//            }
//        });
//        tf2.textProperty().addListener((observable, oldValue, newValue) -> {
//            if(newValue.length() == 0){
//                button.setDisable(true);
//            } else if(tf1.getText().length() > 0) {
//                button.setDisable(false);
//            }
//        });

        /** [Hinweis: newValue, oldValue]
         *  Von newValue (und oldValue) den gewünschten Datentyp erhalten:
         *  - StringProperty -> newValue = String
         *  - DoubleProperty -> newValue.doubleValue() = Double
         *  - IntegerProperty -> newValue.intValue() = Integer
         * */

        /** [Hinweis: #enable/disableV01 (Via bindings zum View) ]
         *  Wenn die Disablelogik (in dieser Methode) in den PM verschoben werden soll, dann braucht RootPM
         *  folgenden Code:
         *      - BooleanProperty disableButton = new SimpleBooleanProperty(true);
         *      - Den EventListenerCode
         *      - Ein Binding hier in der View zur pm.disableProperty
         */

    }

    private void setupBindings() {
        /** [Hinweis: Number to String Convertion - Bindings:]
         *      populationField.textProperty().bindBidirectional(currentCountry.populationProperty(), new NumberStringConverter());
         *      populationField.textProperty().unbindBidirectional(previousCountry.populationProperty().asString());
         *
         *      area.textProperty().bind(pm.getCountryProxy().areaProperty().asString());
         *      area.textProperty().unbind();
         *      Source: CountryFX
         *
         ** [Syntax:] aProperty.bind(bProperty)   -> aProperty gets updated by bProperty.
         * */


        //Mit PM-properties binden:
        tf1.textProperty().bindBidirectional(pm.string01Property());    //String zu String - Binding
        tf2.textProperty().bindBidirectional(pm.string02Property());

        previewLabel.textProperty().bind(pm.concatinatedStringProperty());


        //#enable/disableV01 (Via bindings zum View)
        button.disableProperty().bind(pm.disableButtonProperty());
    }
}
