import Domain.*;

import Repository.IRepository;
import Repository.JsonFileRepository;
import Service.CarService;
import Service.RentService;

import UI.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/UI/mainWindow.fxml"));
        Parent root = fxmlLoader.load();

        MainController mainController = fxmlLoader.getController();

        IValidator<Car> carValidator = new CarValidator();
        IValidator<Rent> rentValidator = new RentValidator();

        IRepository<Car> carsRepository = new JsonFileRepository<>(carValidator, "cars.json", Car.class);
        IRepository<Rent> rentRepository = new JsonFileRepository<>(rentValidator, "rents.json", Rent.class);

        CarService carService = new CarService(carsRepository);


        RentService rentService = new RentService(rentRepository,carsRepository);


//        carService.insert("1", "bmw", 120, 25);
//        carService.insert("2", "vw", 100, 75);
//        carService.insert("3", "opel", 150, 80);
//        carService.insert("4", "subaru", 160, 20);
//        carService.insert("5", "bmw", 170, 30);
//        rentService.insert("1", "1",5, 50);
//        rentService.insert("2", "2",5, 60);
//        rentService.insert("3", "3",5, 70);
//        rentService.insert("4", "4",5, 80);
//        rentService.insert("5", "5",5, 90);



        mainController.setServices(carService,rentService);

        primaryStage.setTitle("Service manager");
        primaryStage.setScene(new Scene(root, 1100, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}