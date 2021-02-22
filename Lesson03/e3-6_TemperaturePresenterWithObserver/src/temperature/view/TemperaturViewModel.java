package temperature.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import temperature.mediator.TemperatureModel;
import temperature.model.Temperature;
import temperature.model.TemperatureList;

public class TemperaturViewModel {


    private final TemperatureModel model;
    private TemperatureList temperatureList;
    private StringProperty Temperatur;
    private StringProperty id;
    private StringProperty filterlabel;
    private StringProperty t0;
    private StringProperty t1;

    private String thermometerId;


    /*public void getLastTemp() {
    getLastTemp() = temperatureList.getLastTemperature();
        }*/

        public TemperaturViewModel(TemperatureModel model) {
            this.model=model;
            Temperatur = new SimpleStringProperty();
            id = new SimpleStringProperty();
            filterlabel = new SimpleStringProperty();
        }

    public StringProperty temperaturProperty() {
        return Temperatur;
    }

    public StringProperty filterProperty() {
        return id;
    }

    public StringProperty filterLabelProperty() {
        return filterlabel;
    }


    public void update() {
        Temperature t = model.getLastInsertedTemperature(thermometerId);
        if (t != null)
        {
         //  Temperatur.setValue(t.getValue() + t.getId());
            Temperatur.setValue(t.getId() + ": " + t.getValue());
        }
        else
        {
            Temperatur.setValue("");
        }

    }

    public void unFilter() {
        String oldValue = filterlabel.getValue();
       // if (oldValue.equals("All"))
        //{
        //    oldValue = null;
        //}
        thermometerId = id.getValue();
        if (thermometerId.isEmpty())
        {
            thermometerId = null;
            filterlabel.setValue("All");
        }
        else
        {
            filterlabel.setValue(thermometerId);
        }
        id.setValue(null);
        update();
    }

    public void show() {
        Temperature v = model.getLastInsertedTemperature(thermometerId);
        String old = t0.getValue();

        if (thermometerId== "t1")
        {
            //  Temperatur.setValue(t.getValue() + t.getId());
            Temperatur.setValue(t0.getValue());
        }
        else
        {
            Temperatur.setValue("");
        }
    }


    }
