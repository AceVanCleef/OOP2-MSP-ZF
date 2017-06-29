package oop2.summary.m04_JavaFX_GUI.gridpanebased.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import oop2.summary.m04_JavaFX_GUI.gridpanebased.presentationmodel.RootPM;

/**
 * Created by Degonas on 28.06.2017.
 */
public class RootPane extends GridPane {

    private final RootPM pm;

    /* Controls */
    private Label       titleLabel;
    private Label       previewLabel;
    private TextField   tf1;
    private TextField   tf2;
    private Button      button;


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

    }

    private void layoutParts(){
        /*** Gridpane: ***/


        /*** #Abstände ***/


        // Growth vertically (Höhe)
        RowConstraints rc = new RowConstraints();
        rc.setVgrow(Priority.ALWAYS);
        getRowConstraints().addAll(rc, rc, rc, rc); //Usually: amount of rc has to be equal to the amount of rows

        // Growth horizontally (Breite)
        ColumnConstraints cc = new ColumnConstraints();
        cc.setHgrow(Priority.ALWAYS);
        getColumnConstraints().addAll(cc);  //amount of cc has to be equal to the amount of columns

        //adding labels     columnIndex X, rowIndex Y, colspan M, rowspan N
        add(titleLabel,     0,0, 1, 1);
        add(tf1,            0,1, 1, 1);
        add(tf2,            0,2, 1, 1);
        add(previewLabel,   0,3, 1, 1);
        add(button,         0,4, 1, 1);

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
