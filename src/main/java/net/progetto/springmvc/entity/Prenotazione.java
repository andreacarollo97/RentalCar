package net.progetto.springmvc.entity;


import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "prenotazioni")
public class Prenotazione {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "dateStart")
    private LocalDate dateStart;

    @Column(name = "dateEnd")
    private LocalDate dateEnd;

    @Column(name = "stato")
    private int stato;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "auto_id")
    private Auto auto;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {

        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getStato() {
        return stato;
    }

    public void setStato(int stato) {
        this.stato = stato;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    private Date getDateWithoutTimeUsingFormat(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(
                "dd/MM/yyyy");
            return new Date(date.getYear(), date.getMonth(), date.getDay());
            //return formatter.(formatter.format(date));
    }


    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", stato=" + stato +
                '}';
    }
}