package pl.codelearn.JoinTheFootprints.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "excursions")
public class Excursion extends GenericEntityID {

    @Column(length = 100, nullable = false)
    @NotBlank
    private String title;

    @Column(nullable = false)
    @Fetch(FetchMode.SUBSELECT)
    @NotEmpty
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Country> countries;

//    @DecimalMax("99999.99")
//    @DecimalMin("00.00")
    @Column(precision = 5, scale = 2, nullable = false)
    private Double expense;

//    @Column(columnDefinition = "varchar(255) default 'null'")
    private String description;

    @Column(name = "max_members", precision = 2, nullable = false)
    @Range(min = 1, max = 99)
    private Integer maxMembers;

//    @Future
    @Column(name = "departure_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfDeparture;

//    @Future
    @Column(name = "arrival_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfArrival;

    //Kolumna na zdjęcie - ustaw też domyślne

    @Column(name = "phone")
    private String  phoneNumber;

    @ManyToOne
    @NotNull
    private User organizer;

    @ManyToMany
    private List<User> members;

    @Fetch(FetchMode.SUBSELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Category> categories;

    @OneToOne
    @JoinColumn(name = "image_id", unique = true)
    private Image image;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime created;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime updated;

    public Excursion() {
        this.categories = new ArrayList<>();
        this.members = new ArrayList<>();
        this.countries = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public Double getExpense() {
        return expense;
    }

    public void setExpense(Double expense) {
        this.expense = expense;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMaxMembers() {
        return maxMembers;
    }

    public void setMaxMembers(Integer maxMembers) {
        this.maxMembers = maxMembers;
    }

    public LocalDate getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(LocalDate dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public LocalDate getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(LocalDate dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User getOrganizer() {
        return organizer;
    }

    public void setOrganizer(User organizer) {
        this.organizer = organizer;
    }

//    public String getTestExpense() {
//        return testExpense;
//    }
//
//    public void setTestExpense(String testExpense) {
//        this.testExpense = testExpense;
//    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @PrePersist
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
//    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    public void setCreated() {
        this.created = LocalDateTime.now();
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    @PreUpdate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
//    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    public void setUpdated() {
        this.updated = LocalDateTime.now();
    }
}
