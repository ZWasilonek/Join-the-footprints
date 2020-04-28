package pl.codelearn.JoinTheFootprints.model;

import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends GenericEntityID {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}