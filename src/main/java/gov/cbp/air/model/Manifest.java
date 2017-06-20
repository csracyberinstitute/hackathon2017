/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.cbp.air.model;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author chrismoran
 */
public class Manifest {

    private String typeCode;
    private String transmitterCode;
    private String airportOfArrival;
    private String cargoTerminalOperator;

    private Collection<WayBill> airWayBills;

    @ApiModelProperty(name = "Airport Code", required = true)
    @Size(min=2, max=3, message="{airport.code.invalid}")
    private String originAirPort;

    @ApiModelProperty(name = "Airport Code", required = true)
    @Size(min=2, max=3, message="{airport.code.invalid}")
    private String destinationAirport;

    private ArrivalInfo arrivalInfo;

    private String agentParticipationCode;

    private Amendment reasonForAmendment;

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTransmitterCode() {
        return transmitterCode;
    }

    public void setTransmitterCode(String transmitterCode) {
        this.transmitterCode = transmitterCode;
    }

    public String getAirportOfArrival() {
        return airportOfArrival;
    }

    public void setAirportOfArrival(String airportOfArrival) {
        this.airportOfArrival = airportOfArrival;
    }

    public String getCargoTerminalOperator() {
        return cargoTerminalOperator;
    }

    public void setCargoTerminalOperator(String cargoTerminalOperator) {
        this.cargoTerminalOperator = cargoTerminalOperator;
    }

    public Collection<WayBill> getAirWayBills() {
        return airWayBills;
    }

    public void setAirWayBills(Collection<WayBill> airWayBills) {
        this.airWayBills = airWayBills;
    }

    public void addAirWayBill(WayBill wayBill) {
        if (this.airWayBills == null) {
           this.airWayBills = new ArrayList<WayBill>();
        }
        this.airWayBills.add(wayBill);
    }

    public String getOriginAirPort() {
        return originAirPort;
    }

    public void setOriginAirPort(String originAirPort) {
        this.originAirPort = originAirPort;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public ArrivalInfo getArrivalInfo() {
        return arrivalInfo;
    }

    public void setArrivalInfo(ArrivalInfo arrivalInfo) {
        this.arrivalInfo = arrivalInfo;
    }

    public String getAgentParticipationCode() {
        return agentParticipationCode;
    }

    public void setAgentParticipationCode(String agentParticipationCode) {
        this.agentParticipationCode = agentParticipationCode;
    }

    public Amendment getReasonForAmendment() {
        return reasonForAmendment;
    }

    public void setReasonForAmendment(Amendment reasonForAmendment) {
        this.reasonForAmendment = reasonForAmendment;
    }


    @Override
    public String toString() {
        return "Manifest{" +
                "typeCode='" + typeCode + '\'' +
                ", transmitterCode='" + transmitterCode + '\'' +
                ", airportOfArrival='" + airportOfArrival + '\'' +
                ", cargoTerminalOperator='" + cargoTerminalOperator + '\'' +
                ", airWayBills=" + airWayBills +
                ", originAirPort='" + originAirPort + '\'' +
                ", destinationAirport='" + destinationAirport + '\'' +
                ", arrivalInfo=" + arrivalInfo +
                ", agentParticipationCode='" + agentParticipationCode + '\'' +
                ", reasonForAmendment=" + reasonForAmendment +
                '}';
    }
}
