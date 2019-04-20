package UI;

import Domain.Car;
import Domain.Rent;
import Service.CarService;
import Service.RentService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;




public class MainController {
    public TableView tableViewCars;
    public TableColumn tableColumnIdCar;
    public TableColumn tableColumnModelCar;
    public TableColumn tableColumnKmBuyCar;
    public TableColumn tableColumnPricePerDayCar;

    public TableView tableViewRents;
    public TableColumn tableColumnIdRent;
    public TableColumn tableColumnCarIdRent;
    public TableColumn tableColumnDaysRent;
    public TableColumn tableColumnTraveledKmRent;

    private CarService carService;
    private RentService rentService;

    private ObservableList<Car> cars = FXCollections.observableArrayList();
    private ObservableList<Rent> rents = FXCollections.observableArrayList();

    public void setServices(CarService carService, RentService rentService) {
        this.carService = carService;
        this.rentService = rentService;
    }

    @FXML
    private void initialize() {
        Platform.runLater(() -> {
            cars.addAll(carService.getAll());
            tableViewCars.setItems(cars);
            rents.addAll(rentService.getAll());
            tableViewRents.setItems(rents);

        });
    }

    public void btnAddCarClick(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/UI/carAdd.fxml"));
        upsertCar(fxmlLoader, "Car add");
    }

    public void upsertCar(FXMLLoader fxmlLoader, String title) {
        try {
            Scene scene = new Scene(fxmlLoader.load(), 600, 200);
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            CarController controller = fxmlLoader.getController();
            controller.setService(carService);
            stage.showAndWait();
            cars.clear();
            cars.addAll(carService.getAll());
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window: Car update.", e);
        }
    }

    public void btnAddRentClick(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/UI/rentAdd.fxml"));
        upsertRent(fxmlLoader, "Rent add");
    }

    public void upsertRent(FXMLLoader fxmlLoader, String title) {
        try {
            Scene scene = new Scene(fxmlLoader.load(), 600, 300);
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            RentController controller = fxmlLoader.getController();
            controller.setService(rentService);
            stage.showAndWait();
            rents.clear();
            rents.addAll(rentService.getAll());
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window: Rent ", e);
        }
    }

    public void IdToKm (ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/UI/idToKm.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
            Stage stage = new Stage();
            stage.setTitle("Id to Km search");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            IdToKmController controller = fxmlLoader.getController();
            controller.setService(carService);
            stage.showAndWait();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window: Full Text Search add.", e);
        }
    }
}