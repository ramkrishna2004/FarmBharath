package crop;
public class Crop {
    private String phone;
    private String cropName; 
    private String quantity;
    private String pincode;
    private String state;
    public Crop(String phone, String cropName,  String quantity,String pincode,String state) {
        this.phone = phone;
        this.cropName = cropName; 
        this.quantity = quantity;
        this.pincode=pincode;
        this.state=state;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

   
    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    public String getPincode() {
        return pincode;
    }
    public String getState() {
        return state;
    }
    public void setPincode(String pincode) {
    	this.pincode=pincode;
    }
    public void setState(String state) {
    	this.state=state;
    }
}


