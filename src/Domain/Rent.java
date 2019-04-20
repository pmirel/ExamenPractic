package Domain;

public class Rent extends Entity {
    private String carId;
    private int days;
    private int traveledKm;

    public Rent(String id, String carId, int days, int traveledKm) {
        super(id);
        this.carId = carId;
        this.days = days;
        this.traveledKm = traveledKm;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "carId='" + carId + '\'' +
                ", days=" + days +
                ", traveledKm=" + traveledKm +
                ", id='" + id + '\'' +
                '}';
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getTraveledKm() {
        return traveledKm;
    }

    public void setTraveledKm(int traveledKm) {
        this.traveledKm = traveledKm;
    }
}
