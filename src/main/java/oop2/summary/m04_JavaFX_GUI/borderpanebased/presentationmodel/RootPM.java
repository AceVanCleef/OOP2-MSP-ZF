package oop2.summary.m04_JavaFX_GUI.borderpanebased.presentationmodel;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Degonas on 28.06.2017.
 */
public class RootPM {


    private final StringProperty string01 = new SimpleStringProperty("");
    private final StringProperty string02 = new SimpleStringProperty("");

    private final StringProperty concatinatedString = new SimpleStringProperty("");

    //#enable/disableV01 (Via bindings zum View)
    private final BooleanProperty disableButton = new SimpleBooleanProperty(true);

    /************************** Constructors **************************/
    public RootPM(){
        addValueChangedListeners();
    }

    /************************** Logic **************************/

    private void addValueChangedListeners(){
        /** [Hinweis: newValue, oldValue]
         *  Von newValue (und oldValue) den gewünschten Datentyp erhalten:
         *  - StringProperty -> newValue = String
         *  - DoubleProperty -> newValue.doubleValue() = Double
         *  - IntegerProperty -> newValue.intValue() = Integer
         * */

        

        //updating concatinatedString
        string01Property().addListener((observable, oldValue, newValue) -> {
            setConcatinatedString( newValue + getString02() );
        });
        string02Property().addListener((observable, oldValue, newValue) -> {
            setConcatinatedString( getString01() + newValue );
        });



        //#enable/disableV01 (Via bindings zum View)
        this.string01Property().addListener((observable, oldValue, newValue) -> {
            if(newValue.length() == 0){
                setDisableButton(true);
            } else if(getString02().length() > 0) {
                setDisableButton(false);
            }
        });
        this.string02Property().addListener((observable, oldValue, newValue) -> {
            if(newValue.length() == 0){
                setDisableButton(true);
            } else if(getString01().length() > 0) {
                setDisableButton(false);
            }
        });
    }

    public void printToConsole(){
        System.out.println(getConcatinatedString());
    }

    /************************ setters and getters **************************/

    public String getString01() {
        return string01.get();
    }

    public StringProperty string01Property() {
        return string01;
    }

    public void setString01(String string01) {
        this.string01.set(string01);
    }

    public String getString02() {
        return string02.get();
    }

    public StringProperty string02Property() {
        return string02;
    }

    public void setString02(String string02) {
        this.string02.set(string02);
    }

    public String getConcatinatedString() {
        return concatinatedString.get();
    }

    public StringProperty concatinatedStringProperty() {
        return concatinatedString;
    }

    public void setConcatinatedString(String concatinatedString) {
        this.concatinatedString.set(concatinatedString);
    }

    public boolean isDisableButton() {
        return disableButton.get();
    }

    public BooleanProperty disableButtonProperty() {
        return disableButton;
    }

    public void setDisableButton(boolean disableButton) {
        this.disableButton.set(disableButton);
    }
}
