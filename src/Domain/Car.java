package Domain;

public class Car extends Entity{
    private String model;
    private int kmBuy;
    private  int pricePerDay;

    public Car(String id, String model, int kmBuy, int pricePerDay) {
        super(id);
        this.model = model;
        this.kmBuy = kmBuy;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", kmBuy=" + kmBuy +
                ", pricePerDay=" + pricePerDay +
                ", id='" + id + '\'' +
                '}';
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getKmBuy() {
        return kmBuy;
    }

    public void setKmBuy(int kmBuy) {
        this.kmBuy = kmBuy;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}
