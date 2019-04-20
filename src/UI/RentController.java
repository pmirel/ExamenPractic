package UI;

import Service.RentService;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.*;

public class RentController {
    public Spinner spnId;
    public Spinner spnCarId;
    public TextField txtDays;
    public TextField txtTraveledKm;

    public Button btnAdd;
    //public Button btnUpdate;
    public Button btnCancel;
    public RentService rentService;

    public void setService(RentService rentService) {
        this.rentService = rentService;
    }

    public void btnAddClick(ActionEvent actionEvent) {
        try {
            String id = String.valueOf(spnId.getValue());
            String carId = String.valueOf(spnCarId.getValue());
            int days = Integer.parseInt(txtDays.getText());
            int traveledKm = Integer.parseInt(txtTraveledKm.getText());

            rentService.insert(id, carId, days, traveledKm);
            btnCancelClick(actionEvent);
        } catch (RuntimeException rex) {
            UI.Common.showValidationError(rex.getMessage());
        }
    }

    public void btnCancelClick(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
}
