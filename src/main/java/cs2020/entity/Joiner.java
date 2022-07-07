package cs2020.entity;

public class Joiner {
    private Integer id;
    private String name;
    private String leader;
    private double fee;
    private double tfee;
    private String people;

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

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getTfee() {
        return tfee;
    }

    public void setTfee(double tfee) {
        this.tfee = tfee;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }
}
