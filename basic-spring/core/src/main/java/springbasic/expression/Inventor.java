package springbasic.expression;

public class Inventor {
    public String name;
    private Long time;
    private String nationality;

    public Inventor() {
    }

    public Inventor(String name, Long time, String nationality) {
        this.name = name;
        this.time = time;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
