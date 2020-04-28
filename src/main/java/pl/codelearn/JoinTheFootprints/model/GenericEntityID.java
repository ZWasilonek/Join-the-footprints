package pl.codelearn.JoinTheFootprints.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public abstract class GenericEntityID {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object entity) {
        if (this == entity) return true;
        if (entity.getClass() != getClass() || entity == null) return false;
        GenericEntityID that = (GenericEntityID) entity;
        return Objects.equals(that.id, id);
    }
}
