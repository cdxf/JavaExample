package spring.Repository;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Snoob on 9/3/2016.
 */
@Entity
public class Person {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment",strategy = "increment")
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "TOWN_ID")
    private Town town;
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }
    private void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!id.equals(person.id)) return false;
        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
        return age != null ? age.equals(person.age) : person.age == null;

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
