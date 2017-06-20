package gov.cbp.air.model;

import java.util.Date;

/**
 * Created by ramchalasani on 3/27/17.
 */
public class ArrivalInfo {

      private Date dateOfArrivalAtDestinationPort;
      private String importingCarrier;
      private String flightNumber;
      private Date scheduledArrivalDate;
      private String partArrivalReference;
      private String boardedQuantityUOM;
      private Integer boardedQuantity;
      private String weightCode;
      private Double weight;

    public Date getDateOfArrivalAtDestinationPort() {
        return dateOfArrivalAtDestinationPort;
    }

    public void setDateOfArrivalAtDestinationPort(Date dateOfArrivalAtDestinationPort) {
        this.dateOfArrivalAtDestinationPort = dateOfArrivalAtDestinationPort;
    }

    public String getImportingCarrier() {
        return importingCarrier;
    }

    public void setImportingCarrier(String importingCarrier) {
        this.importingCarrier = importingCarrier;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getScheduledArrivalDate() {
        return scheduledArrivalDate;
    }

    public void setScheduledArrivalDate(Date scheduledArrivalDate) {
        this.scheduledArrivalDate = scheduledArrivalDate;
    }

    public String getPartArrivalReference() {
        return partArrivalReference;
    }

    public void setPartArrivalReference(String partArrivalReference) {
        this.partArrivalReference = partArrivalReference;
    }

    public String getBoardedQuantityUOM() {
        return boardedQuantityUOM;
    }

    public void setBoardedQuantityUOM(String boardedQuantityUOM) {
        this.boardedQuantityUOM = boardedQuantityUOM;
    }

    public Integer getBoardedQuantity() {
        return boardedQuantity;
    }

    public void setBoardedQuantity(Integer boardedQuantity) {
        this.boardedQuantity = boardedQuantity;
    }

    public String getWeightCode() {
        return weightCode;
    }

    public void setWeightCode(String weightCode) {
        this.weightCode = weightCode;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "ArrivalInfo{" +
                "dateOfArrivalAtDestinationPort=" + dateOfArrivalAtDestinationPort +
                ", importingCarrier='" + importingCarrier + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", scheduledArrivalDate=" + scheduledArrivalDate +
                ", partArrivalReference='" + partArrivalReference + '\'' +
                ", boardedQuantityUOM='" + boardedQuantityUOM + '\'' +
                ", boardedQuantity=" + boardedQuantity +
                ", weightCode='" + weightCode + '\'' +
                ", weight=" + weight +
                '}';
    }
}
