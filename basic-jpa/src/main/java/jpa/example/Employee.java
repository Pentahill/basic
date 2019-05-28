package jpa.example;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Collection;

import static javax.persistence.GenerationType.TABLE;

@Entity
@Table(name="EMPL")
@SecondaryTable(name = "EMP_SALARY",
    pkJoinColumns = @PrimaryKeyJoinColumn(name = "EMP_ID", referencedColumnName = "ID")
)
public class Employee implements Serializable {
    private Integer id;
    private int version;
    private String name;
    private Address address;
    private Collection phoneNumbers;
    private Collection<Project> projects;
    private Long salary;
    private EmploymentPeriod period;

    @Id
    @GeneratedValue(strategy=TABLE)
    public Integer getId() { return id; }
    protected void setId(Integer id) { this.id = id; }

    @Version
    @Column(name = "EMP_VERSION", nullable = false)
    public int getVersion() { return version; }
    protected void setVersion(int version) {
        this.version = version;
    }

    @Column(name="EMP_NAME", length=80)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "ADDR_ID", referencedColumnName = "ID", nullable = false)
    public Address getAddress() { return address; }
    public void setAddress(Address address) {
        this.address = address;
    }

    @OneToMany(targetEntity = PhoneNumber.class, cascade = CascadeType.ALL, mappedBy = "employee")
    public Collection getPhoneNumbers() { return phoneNumbers; }
    public void setPhoneNumbers(Collection phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "employees")
    @JoinTable(name = "EMP_PROJ",
                joinColumns = @JoinColumn(name = "EMP_ID", referencedColumnName = "ID"),
                inverseJoinColumns = @JoinColumn(name = "PROJ_ID", referencedColumnName = "ID"))
    public Collection<Project> getProjects() { return projects; }
    public void setProjects(Collection<Project> projects) {
        this.projects = projects;
    }

    @Column(name = "EMP_SAL", table = "EMP_SALARY")
    public Long getSalary() { return salary; }
    public void setSalary(Long salary) {
        this.salary = salary;
    }

    @Embedded
    @AttributeOverrides({
         @AttributeOverride(name = "startDate", column = @Column(name = "EMP_START")),
         @AttributeOverride(name = "endDate", column = @Column(name = "EMP_END"))
    })
    public EmploymentPeriod getEmploymentPeriod() {
        return period;
    }
    public void setEmploymentPeriod(EmploymentPeriod period) {
        this.period = period;
    }
}
