package Model.Entities;

public class Hospede {
    private Integer id;
    private String name;
    private String cpf;
    private String phone;

    public Hospede() {
    }

    public Hospede(Integer id, String name, String CPF, String phone) {
        this.id = id;
        this.name = name;
        this.cpf = CPF;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String CPF) {
        this.cpf = CPF;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Hospede " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", phone='" + phone;
    }
}
