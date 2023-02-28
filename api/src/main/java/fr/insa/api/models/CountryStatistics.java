package fr.insa.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CountryStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private long confirmed;
    private long dead;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name=name;
    }

    public long getConfirmed(){
        return this.confirmed;
    }

    public void setConfirmed(long confirmed){
        this.confirmed = confirmed;
    }

    public long getDead(){
        return this.dead;
    }

    public void setDead(long dead){
        this.dead = dead;
    }
}
