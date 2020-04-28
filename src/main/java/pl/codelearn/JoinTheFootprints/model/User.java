package pl.codelearn.JoinTheFootprints.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends GenericEntityID {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(columnDefinition = "varchar(255) default 'null'")
    private String surname;

    @Email
    private String email;

//    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,20}$", message = "The password should contain 8-20 characters lowercase letter, uppercase letter and number")
    private String password;

    @Transient
    private String confirmPassword;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @ManyToMany(mappedBy = "members", fetch = FetchType.EAGER)
//    @JoinTable(name = "excursions_members", joinColumns = @JoinColumn(name = "member_id"), inverseJoinColumns = @JoinColumn(name = "excursion_id"))
    private List<Excursion> excursions;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Excursion> getExcursions() {
        return excursions;
    }

    public void setExcursions(List<Excursion> excursions) {
        this.excursions = excursions;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getFullName() {
        if (surname != null) {
            return firstName + " " + surname;
        } else return firstName;
    }
}
