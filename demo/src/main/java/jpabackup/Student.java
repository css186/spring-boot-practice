package jpabackup;

import javax.persistence.*;

@Entity
@Table(name="student") // match table name in db
public class Student {

    // @Column -> match variables with columns
    // @Id -> for primary key
    // @GenerateValue -> for auto_increment

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Integer id;

    @Column(name="name")
    String name;

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
}
