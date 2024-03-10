package admin;

public class CropPrice {
    private String cropName;
    private double basePrice;

    // Constructors
    public CropPrice() {
    }

    public CropPrice(String cropName, double basePrice) {
        this.cropName = cropName;
        this.basePrice = basePrice;
    }

    // Getters and setters
    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
}
