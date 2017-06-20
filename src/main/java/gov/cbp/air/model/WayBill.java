/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.cbp.air.model;

import java.util.Collection;

/**
 *
 * @author chrismoran
 */
public class WayBill {

      private String wayBillNumber;
      private String partArrivalReference;
      private Integer NoOfPieces;
      private String weightCode;
      private Double weight;
      private String cargoDescription;
      private String fdaIndicator;

      private Entity shipper;
      private Entity consignee;

      private EntryDetail customEntryDetail;

      private ShipmentDescription customShipmentDescription;

      private Collection<Transfer> transfers;

      private transient String manifestId;


    public String getWayBillNumber() {
        return wayBillNumber;
    }

    public void setWayBillNumber(String wayBillNumber) {
        this.wayBillNumber = wayBillNumber;
    }

    public String getPartArrivalReference() {
        return partArrivalReference;
    }

    public void setPartArrivalReference(String partArrivalReference) {
        this.partArrivalReference = partArrivalReference;
    }

    public Integer getNoOfPieces() {
        return NoOfPieces;
    }

    public void setNoOfPieces(Integer noOfPieces) {
        NoOfPieces = noOfPieces;
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

    public String getCargoDescription() {
        return cargoDescription;
    }

    public void setCargoDescription(String cargoDescription) {
        this.cargoDescription = cargoDescription;
    }

    public String getFdaIndicator() {
        return fdaIndicator;
    }

    public void setFdaIndicator(String fdaIndicator) {
        this.fdaIndicator = fdaIndicator;
    }

    public Entity getShipper() {
        return shipper;
    }

    public void setShipper(Entity shipper) {
        this.shipper = shipper;
    }

    public Entity getConsignee() {
        return consignee;
    }

    public void setConsignee(Entity consignee) {
        this.consignee = consignee;
    }

    public EntryDetail getCustomEntryDetail() {
        return customEntryDetail;
    }

    public void setCustomEntryDetail(EntryDetail customEntryDetail) {
        this.customEntryDetail = customEntryDetail;
    }

    public ShipmentDescription getCustomShipmentDescription() {
        return customShipmentDescription;
    }

    public void setCustomShipmentDescription(ShipmentDescription customShipmentDescription) {
        this.customShipmentDescription = customShipmentDescription;
    }

    public Collection<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(Collection<Transfer> transfers) {
        this.transfers = transfers;
    }

    public String getManifestId() {
        return manifestId;
    }

    public void setManifestId(String manifestId) {
        this.manifestId = manifestId;
    }

    @Override
    public String toString() {
        return "WayBill{" +
                "wayBillNumber='" + wayBillNumber + '\'' +
                ", partArrivalReference='" + partArrivalReference + '\'' +
                ", NoOfPieces=" + NoOfPieces +
                ", weightCode='" + weightCode + '\'' +
                ", weight=" + weight +
                ", cargoDescription='" + cargoDescription + '\'' +
                ", fdaIndicator='" + fdaIndicator + '\'' +
                ", shipper=" + shipper +
                ", consignee=" + consignee +
                ", customEntryDetail=" + customEntryDetail +
                ", customShipmentDescription=" + customShipmentDescription +
                ", transfers=" + transfers +
                ", manifestId='" + manifestId + '\'' +
                '}';
    }
}
