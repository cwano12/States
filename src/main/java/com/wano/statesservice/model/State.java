package com.wano.statesservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String abbreviation;
    private String admissionDate;
    private String capital;
    private String population;
    private long area;

    public State(){}

    public State(long id, String name, String abbreviation, String admissionDate, String capital, String population,
                 long area) {
        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation;
        this.admissionDate = admissionDate;
        this.capital = capital;
        this.population = population;
        this.area = area;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return id == state.id &&
                area == state.area &&
                Objects.equals(name, state.name) &&
                Objects.equals(abbreviation, state.abbreviation) &&
                Objects.equals(admissionDate, state.admissionDate) &&
                Objects.equals(capital, state.capital) &&
                Objects.equals(population, state.population);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, abbreviation, admissionDate, capital, population, area);
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", admissionDate='" + admissionDate + '\'' +
                ", capital='" + capital + '\'' +
                ", population='" + population + '\'' +
                ", area=" + area +
                '}';
    }
}
