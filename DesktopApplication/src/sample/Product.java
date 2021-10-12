package sample;

public class Product {
    String productColumn;
    String featureColumn;
    double priceColumn;

    public Product() {
    }

    public Product(String productColumn, String featureColumn, double priceColumn) {
        this.productColumn = productColumn;
        this.featureColumn = featureColumn;
        this.priceColumn = priceColumn;
    }

    public String getProductColumn() {
        return productColumn;
    }

    public void setProductColumn(String productColumn) {
        this.productColumn = productColumn;
    }

    public String getFeatureColumn() {
        return featureColumn;
    }

    public void setFeatureColumn(String featureColumn) {
        this.featureColumn = featureColumn;
    }

    public double getPriceColumn() {
        return priceColumn;
    }

    public void setPriceColumn(double priceColumn) {
        this.priceColumn = priceColumn;
    }
}
