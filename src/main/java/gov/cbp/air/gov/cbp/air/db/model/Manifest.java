/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.cbp.air.gov.cbp.air.db.model;

import gov.cbp.air.model.Amendment;
import gov.cbp.air.model.ArrivalInfo;
import gov.cbp.air.model.WayBill;
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

    private Collection<String> airWayBillNumbers = new ArrayList<String>();

    private String originAirPort;

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

    public Collection<String> getAirWayBillNumbers() {
        return airWayBillNumbers;
    }

    public void setAirWayBillNumbers(Collection<String> airWayBillNumbers) {
        this.airWayBillNumbers = airWayBillNumbers;
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
}
