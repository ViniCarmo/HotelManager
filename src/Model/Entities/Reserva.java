package Model.Entities;

public class Reserva {
    private Integer id;
    private Hospede hospede;
    private Room room;
    private Integer nights;
    private Double totalValue;

    public Reserva(){

    }

    public Reserva(Integer id, Hospede hospede, Room room, Integer nights, Double totalValue) {
        this.id = id;
        this.hospede = hospede;
        this.room = room;
        this.nights = nights;
        this.totalValue = totalValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Integer getNights() {
        return nights;
    }

    public void setNights(Integer nights) {
        this.nights = nights;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    @Override
    public String toString() {
        return "Reserva: " +
                "id=" + id +
                ", hospede= " + hospede.getName() +
                ", room= " + room.getRoomNumber() +
                ", nights= " + nights +
                ", totalValue= " + totalValue +
                '}';
    }
}
