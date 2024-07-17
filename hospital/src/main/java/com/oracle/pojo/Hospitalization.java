package com.oracle.pojo;

public class Hospitalization {
    private Integer hospitalizationId;
    private Integer patientId;
    private String roomNumber;
    private Float cost;
    private String patientName;
    private String patientPhone;

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    private String paymentStatus;
    private Integer isInsured;

    public Integer getIsInsured() {
        return isInsured;
    }

    public void setIsInsured(Integer isInsured) {
        this.isInsured = isInsured;
    }

    private String hospitalizationStatus;

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getHospitalizationStatus() {
        return hospitalizationStatus;
    }

    public void setHospitalizationStatus(String hospitalizationStatus) {
        this.hospitalizationStatus = hospitalizationStatus;
    }

    public Hospitalization() {
    }



    public Integer getHospitalizationId() {
        return hospitalizationId;
    }

    public void setHospitalizationId(Integer hospitalizationId) {
        this.hospitalizationId = hospitalizationId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Hospitalization{" +
                "hospitalizationId=" + hospitalizationId +
                ", patientId=" + patientId +
                ", roomNumber='" + roomNumber + '\'' +
                ", cost=" + cost +
                ", patientName='" + patientName + '\'' +
                ", isInsured=" + isInsured +
                '}';
    }

    public Hospitalization(Integer hospitalizationId, Integer patientId, String roomNumber, Float cost, String patientName, String patientPhone, String paymentStatus, Integer isInsured, String hospitalizationStatus) {
        this.hospitalizationId = hospitalizationId;
        this.patientId = patientId;
        this.roomNumber = roomNumber;
        this.cost = cost;
        this.patientName = patientName;
        this.patientPhone = patientPhone;
        this.paymentStatus = paymentStatus;
        this.isInsured = isInsured;
        this.hospitalizationStatus = hospitalizationStatus;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}
