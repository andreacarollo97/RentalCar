package net.progetto.springmvc.entity;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "auto")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "targa")
    private String targa;

    @Column(name = "modello")
    private String modello;

    @Column(name = "marca")
    private String marca;

    @OneToMany(mappedBy = "auto")
    private List<Prenotazione> prenotazioni;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "User [id=" + id
                + ", targa=" + targa
                + ", modello=" + modello
                + ", marca=" + marca
                + "]";
    }
}