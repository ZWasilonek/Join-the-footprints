package pl.codelearn.JoinTheFootprints.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment extends GenericEntityID {

    @Column(nullable = false, columnDefinition = "TEXT", length = 300)
    private String content;

    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")
    private LocalDateTime created;

    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")
    private LocalDateTime updated;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "excursion_id")
    private Excursion excursion;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Excursion getExcursion() {
        return excursion;
    }

    public void setExcursion(Excursion excursion) {
        this.excursion = excursion;
    }
}
