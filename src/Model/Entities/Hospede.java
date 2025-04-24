package Model.Entities;

public class Hospede {
    private String Name;
    private Integer CPF;
    private Integer phone;

    public Hospede(String name, Integer CPF, Integer phone) {
        Name = name;
        this.CPF = CPF;
        this.phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getCPF() {
        return CPF;
    }

    public void setCPF(Integer CPF) {
        this.CPF = CPF;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
}
