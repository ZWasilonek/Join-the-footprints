package pl.codelearn.JoinTheFootprints.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import pl.codelearn.JoinTheFootprints.model.Category;
import pl.codelearn.JoinTheFootprints.model.Country;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExcursionDTO {

    private List<Country> countries;

    private Double minExpense;

    private Double maxExpense;

    private Integer maxMembers;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfDeparture;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfArrival;

    //Kolumna na zdjęcie - ustaw też domyślne

    private List<Category> categories;

    public ExcursionDTO() {
        this.categories = new ArrayList<>();
        this.countries = new ArrayList<>();
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Double getMinExpense() {
        return minExpense;
    }

    public void setMinExpense(Double minExpense) {
        if (minExpense == null) {
            minExpense = 1.0;
        }
        this.minExpense = minExpense;
    }

    public Double getMaxExpense() {
        return maxExpense;
    }

    public void setMaxExpense(Double maxExpense) {
        if (maxExpense == null) {
            maxExpense = 99999.0;
        }
        this.maxExpense = maxExpense;
    }

}

