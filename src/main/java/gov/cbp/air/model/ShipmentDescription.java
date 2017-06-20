package gov.cbp.air.model;

/**
 * Created by ramchalasani on 3/27/17.
 */
public class ShipmentDescription {

    private String originOfGoods;
    private Double declaredValue;
    private String currencyCode;
    private String htsCode;


    public String getOriginOfGoods() {
        return originOfGoods;
    }

    public void setOriginOfGoods(String originOfGoods) {
        this.originOfGoods = originOfGoods;
    }

    public Double getDeclaredValue() {
        return declaredValue;
    }

    public void setDeclaredValue(Double declaredValue) {
        this.declaredValue = declaredValue;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getHtsCode() {
        return htsCode;
    }

    public void setHtsCode(String htsCode) {
        this.htsCode = htsCode;
    }

    @Override
    public String toString() {
        return "ShipmentDescription{" +
                "originOfGoods='" + originOfGoods + '\'' +
                ", declaredValue=" + declaredValue +
                ", currencyCode='" + currencyCode + '\'' +
                ", htsCode='" + htsCode + '\'' +
                '}';
    }
}
