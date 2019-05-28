package jpa.entity;

import javax.persistence.*;

@NamedQuery(name = "findAllUsersWithName",
        query = "SELECT u FROM User u WHERE u.name LIKE :custName")
//@SqlResultSetMapping(name = "UserResults", entities = @EntityResult(entityClass = User.class))
@SqlResultSetMapping(name = "UserAgeResults", entities = {
        @EntityResult(entityClass = User.class, fields = {
                @FieldResult(name = "id",column = "id"),
                @FieldResult(name = "name",column = "name")
        }),
        @EntityResult(entityClass = Age.class)
})
@Entity
@Table(name = "user")
public class User {
    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    private int id;
    private String name;
//    @Column(name = "age_id")
//    int ageId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "age_id", referencedColumnName = "user_id")
    Age age;

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    @PrePersist
    protected void validateId() {
        System.out.println("id是：" + id);
    }
}
