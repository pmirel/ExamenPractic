package Service;

import Domain.Car;
import Domain.Rent;
import Repository.IRepository;

import java.util.List;

public class RentService {
    private IRepository <Car> carRepository;
    private IRepository <Rent> rentRepository;

    public RentService(IRepository<Rent> rentRepository,IRepository<Car> carRepository) {

        this.rentRepository = rentRepository;
        this.carRepository = carRepository;
    }

    /**
     * inseert
     * @param id
     * @param carId
     * @param days
     * @param traveledKm
     */
    public void insert(String id, String carId, int days, int traveledKm){
        Rent rent = new Rent(id,carId,days,traveledKm);
        if (rentRepository.getAll().contains(rent.getId()))
            throw new RentServiceException(String.format("A rent with the ID %s already exists!", id));
//        if(carRepository.getAll().contains(carRepository.getById(carId)))
//            throw new RentServiceException(String.format("Car id dosen't exist!", carId));
        rentRepository.insert(rent);


    }

    /**
     * getAll
     * @return
     */
    public List<Rent> getAll() {
        return rentRepository.getAll();
    }
}
