package Model.Entities;

public class Room {
    private Integer id;
    private Integer roomNumber;
    private Double pricePerNight;
    private RoomStatus status;

    public Room(){}

    public Room(Integer id, Integer roomNumber, Double pricePerNight, RoomStatus status) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }
}
