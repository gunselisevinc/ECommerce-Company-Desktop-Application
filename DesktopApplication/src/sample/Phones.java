package sample;

public class Phones {
    private String computerModel; //phone model
    private String computerBrand; //phone brand
    private String computerScreenSize; //phone scree
    private String screenResolution; //this is internal memory
    private Double computerPrice; //phone price
    private String storageCapacity;
    private String memory;
    private Double ali;


    public Phones() {
    }

    public Phones(String computerModel, String computerBrand, String computerScreenSize, String screenResolution, Double computerPrice) {
        this.computerModel = computerModel;
        this.computerBrand = computerBrand;
        this.computerScreenSize = computerScreenSize;
        this.screenResolution = screenResolution;
        this.computerPrice = computerPrice;
        this.storageCapacity="";
        this.memory="";
        this.ali=null;
    }

    public String getComputerModel() {
        return computerModel;
    }

    public void setComputerModel(String computerModel) {
        this.computerModel = computerModel;
    }

    public String getComputerBrand() {
        return computerBrand;
    }

    public void setComputerBrand(String computerBrand) {
        this.computerBrand = computerBrand;
    }

    public String getComputerScreenSize() {
        return computerScreenSize;
    }

    public void setComputerScreenSize(String computerScreenSize) {
        this.computerScreenSize = computerScreenSize;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public Double getComputerPrice() {
        return computerPrice;
    }

    public void setComputerPrice(Double computerPrice) {
        this.computerPrice = computerPrice;
    }
}
