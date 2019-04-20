package UI;

import Domain.Car;
import Service.CarService;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class IdToKmController {
    public Label result;
    public TextField textIdToSearch;
    public Button btnSearch;
    public Button btnCancel;
    public CarService carService;

    public void setService(CarService carService) {
        this.carService = carService;

    }

    public void btnCancelClick(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    public void btnSearchClick(ActionEvent actionEvent) {
        String txt = textIdToSearch.getText();
        String found = txt + " found here:\n" + carSearch(txt);
        if(txt.length()>=1)
            result.setText(found);
    }


    private String carSearch(String text) {
        String moviesTextFound = "";
        int km = carService.getKilometers(text);
         moviesTextFound = ""+km;


        return moviesTextFound;
    }
}