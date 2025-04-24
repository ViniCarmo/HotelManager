package Model.Entities;

public class Room {
    private Integer roomNumber;
    private Double pricePerNight;
    private String status;

    public Room(Integer roomNumber, Double pricePerNight, String status) {
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.status = status;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
