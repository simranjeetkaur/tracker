package io.egen.simran.entity;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NamedQueries({
        @NamedQuery(name = "Vehicle.loadVehicles",
                query = "Select vehicle from Vehicle vehicle ORDER BY vehicle.vinNo DESC"),
        @NamedQuery(name = "Vehicle.findByVin", query = "SELECT vehicle FROM Vehicle vehicle WHERE vehicle.vinNo=:paramVin")

})
public class Vehicle {

    /*
    {
    "vin": "1HGCR2F3XFA027534",
    "make": "HONDA",
    "model": "ACCORD",
    "year": 2015,
    "redlineRpm": 5500,
    "maxFuelVolume": 15,
    "lastServiceDate": "2017-05-25T17:31:25.268Z"
 }
     */

    @Id
   // @Column(columnDefinition = "VARCHAR(36)")
    private String vinNo;

    private String vehicleMake;
    private String vehicleModel;
    private String vehicleYear;
    private String vehicleRedLineRPM;
    private String maxFuelVol;
    private String vehicleLastServiceDate;

    public String getVinNo() {
        return vinNo;
    }

    public void setVinNo(String vinNo) {
        this.vinNo = vinNo;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(String vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public String getVehicleRedLineRPM() {
        return vehicleRedLineRPM;
    }

    public void setVehicleRedLineRPM(String vehicleRedLineRPM) {
        this.vehicleRedLineRPM = vehicleRedLineRPM;
    }

    public String getMaxFuelVol() {
        return maxFuelVol;
    }

    public void setMaxFuelVol(String maxFuelVol) {
        this.maxFuelVol = maxFuelVol;
    }

    public String getVehicleLastServiceDate() {
        return vehicleLastServiceDate;
    }

    public void setVehicleLastServiceDate(String vehicleLastServiceDate) {
        this.vehicleLastServiceDate = vehicleLastServiceDate;
    }
}
