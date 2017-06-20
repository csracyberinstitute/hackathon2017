package gov.cbp.air.model;

/**
 * Created by ramchalasani on 3/27/17.
 */
public class Transfer {

    private String destinationAirPort;
    private String transferIdentifier;
    private String bondedCarrierId;
    private String onwardCarrierId;
    private String bondedPremisesId;
    private String inbondControlNumber;


    public String getDestinationAirPort() {
        return destinationAirPort;
    }

    public void setDestinationAirPort(String destinationAirPort) {
        this.destinationAirPort = destinationAirPort;
    }

    public String getTransferIdentifier() {
        return transferIdentifier;
    }

    public void setTransferIdentifier(String transferIdentifier) {
        this.transferIdentifier = transferIdentifier;
    }

    public String getBondedCarrierId() {
        return bondedCarrierId;
    }

    public void setBondedCarrierId(String bondedCarrierId) {
        this.bondedCarrierId = bondedCarrierId;
    }

    public String getOnwardCarrierId() {
        return onwardCarrierId;
    }

    public void setOnwardCarrierId(String onwardCarrierId) {
        this.onwardCarrierId = onwardCarrierId;
    }

    public String getBondedPremisesId() {
        return bondedPremisesId;
    }

    public void setBondedPremisesId(String bondedPremisesId) {
        this.bondedPremisesId = bondedPremisesId;
    }

    public String getInbondControlNumber() {
        return inbondControlNumber;
    }

    public void setInbondControlNumber(String inbondControlNumber) {
        this.inbondControlNumber = inbondControlNumber;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "destinationAirPort='" + destinationAirPort + '\'' +
                ", transferIdentifier='" + transferIdentifier + '\'' +
                ", bondedCarrierId='" + bondedCarrierId + '\'' +
                ", onwardCarrierId='" + onwardCarrierId + '\'' +
                ", bondedPremisesId='" + bondedPremisesId + '\'' +
                ", inbondControlNumber='" + inbondControlNumber + '\'' +
                '}';
    }
}
