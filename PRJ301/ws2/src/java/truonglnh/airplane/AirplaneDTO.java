/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truonglnh.airplane;

import java.io.Serializable;

/**
 *
 * @author lnhtr
 */
public class AirplaneDTO implements Serializable{
    private String id;
    private String fightNumber;
    private String destination;
    private String departureAttributesTime;
    private String status;

    public AirplaneDTO() {
    }

    public AirplaneDTO(String id, String fightNumber, String destination, String departureAttributesTime, String status) {
        this.id = id;
        this.fightNumber = fightNumber;
        this.destination = destination;
        this.departureAttributesTime = departureAttributesTime;
        this.status = status;
    }

    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the fightNumber
     */
    public String getFightNumber() {
        return fightNumber;
    }

    /**
     * @param fightNumber the fightNumber to set
     */
    public void setFightNumber(String fightNumber) {
        this.fightNumber = fightNumber;
    }

    /**
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * @return the departureAttributesTime
     */
    public String getDepartureAttributesTime() {
        return departureAttributesTime;
    }

    /**
     * @param departureAttributesTime the departureAttributesTime to set
     */
    public void setDepartureAttributesTime(String departureAttributesTime) {
        this.departureAttributesTime = departureAttributesTime;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
