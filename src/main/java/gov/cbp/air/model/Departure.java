package gov.cbp.air.model;

import java.util.Date;

/**
 * Created by ramchalasani on 3/27/17.
 */
public class Departure {

    private String importingCarrier;
    private String flightNumber;
    private Date scheduledArrivalDate;
    private Date liftOffDate;
    private String actualImportingCarrier;
    private String actualFlightNumber;

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

    public Date getLiftOffDate() {
        return liftOffDate;
    }

    public void setLiftOffDate(Date liftOffDate) {
        this.liftOffDate = liftOffDate;
    }

    public String getActualImportingCarrier() {
        return actualImportingCarrier;
    }

    public void setActualImportingCarrier(String actualImportingCarrier) {
        this.actualImportingCarrier = actualImportingCarrier;
    }

    public String getActualFlightNumber() {
        return actualFlightNumber;
    }

    public void setActualFlightNumber(String actualFlightNumber) {
        this.actualFlightNumber = actualFlightNumber;
    }

    @Override
    public String toString() {
        return "Departure{" +
                "importingCarrier='" + importingCarrier + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", scheduledArrivalDate=" + scheduledArrivalDate +
                ", liftOffDate=" + liftOffDate +
                ", actualImportingCarrier='" + actualImportingCarrier + '\'' +
                ", actualFlightNumber='" + actualFlightNumber + '\'' +
                '}';
    }
}
