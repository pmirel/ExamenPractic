package UI;

import Service.CarService;
import UI.Common;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.TextField;


public class CarController {
    public Spinner spnId;
    public TextField txtModel;
    public TextField txtKmBuy;
    public TextField txtPricePerDay;
    public Button btnAdd;
    public Button btnCancel;
    public CarService carService;

    public void setService(CarService carService) {
        this.carService = carService;
    }

    /**
     * button add
     * @param actionEvent
     */
    public void btnAddClick(ActionEvent actionEvent) {
        try {
            String id = String.valueOf(spnId.getValue());
            String model = txtModel.getText();
            int kmBuy = Integer.parseInt(txtKmBuy.getText());
            int pricePerDay = Integer.parseInt(txtPricePerDay.getText());

            carService.insert(id, model, kmBuy, pricePerDay);
           btnCancelClick(actionEvent);
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnCancelClick(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
}
