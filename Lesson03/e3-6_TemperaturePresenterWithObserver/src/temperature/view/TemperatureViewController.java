package temperature.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TemperatureViewController implements PropertyChangeListener
{
   @FXML private Label outputLabel;
   @FXML private Label t0;
   @FXML private Label t1;
   @FXML private TextField filterField;
   @FXML private Label filterLabel;

   private ViewHandler viewHandler;
   private Region root;
   private TemperaturViewModel viewModel;

   public TemperatureViewController()
   {
   }

   public void init(ViewHandler viewHandler, TemperaturViewModel viewModel, Region root)
   {
      this.viewHandler = viewHandler;
      this.viewModel = viewModel;
      this.root = root;
      t0.textProperty().bind(viewModel.temperaturProperty());
      t1.textProperty().bind(viewModel.temperaturProperty());

      outputLabel.textProperty().bind(viewModel.temperaturProperty());
      filterLabel.textProperty().bind(viewModel.filterProperty());
      filterField.textProperty().bindBidirectional(viewModel.filterProperty());
   }

   public void reset()
   {
      // empty
   }

   public Region getRoot()
   {
      return root;
   }

   @FXML private void updateButtonPressed()
   {
    viewModel.update();
   }

   @FXML private void onFilter()
   {
   viewModel.unFilter();
   }

   @FXML private void show()
   {
      viewModel.show();
   }


   @Override public void propertyChange(PropertyChangeEvent evt)
   {

   }
   public void nextpage(ActionEvent actionEvent) {
      viewHandler.openView("temperature2");
   }

}
