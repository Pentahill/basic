package jpa.example;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.TABLE;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DISC")
@DiscriminatorValue("Proj")
public class Project {

    private Integer projId;
    private int version;
    private String name;
    private Set<Employee> employees;

    @Id @GeneratedValue(strategy=TABLE)
    public Integer getId() { return projId; }
    protected void setId(Integer id) { this.projId = id; }

    @Version
    public int getVersion() { return version; }
    protected void setVersion(int version) { this.version = version; }

    @Column(name="PROJ_NAME")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @ManyToMany(mappedBy="projects")
    public Set<Employee> getEmployees() { return employees; }
    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
