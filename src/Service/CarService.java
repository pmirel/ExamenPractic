package Service;

import Domain.Car;
import Repository.IRepository;

import java.util.ArrayList;
import java.util.List;

public class CarService  {
    private IRepository<Car> carRepository;

    public CarService(IRepository<Car> carRepository) {
        this.carRepository = carRepository;
    }

    /**
     * adds car
     * @param id
     * @param model
     * @param kmBuy
     * @param pricePerDay
     */
    public void insert(String id, String model, int kmBuy, int pricePerDay) {
        Car car = new Car(id, model,kmBuy, pricePerDay);
        carRepository.insert(car);
    }
    public List<Car> getAll() {
        return carRepository.getAll();
    }

    /**
     * get km from id
     * @param id
     * @return
     */
    public int getKilometers (String id){
        List<Car> found = new ArrayList<>();
        for (Car b : carRepository.getAll()) { //id, idMovie, idCard, date, time
            if (!b.getId().contains(id) ) {
               throw new CarServiceException("Car id dosen't exist!");
            }
        }
        int km = 0;
        for (Car b : carRepository.getAll()) {
            if (id == b.getId()) {
                km = b.getKmBuy();
            }
        }
        return km;
    }
}
