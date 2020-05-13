package com.example.springrest.dto;

import java.io.Serializable;

public class CountryDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
    private String name;
    private String codeName;

    public CountryDto() {
    }

    public CountryDto(int id, String name, String codeName) {
        this.id = id;
        this.name = name;
        this.codeName = codeName;
    }

    public CountryDto(String name, String codeName) {
        this.name = name;
        this.codeName = codeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String toString() {
        return id + ". " + name + " (" + codeName + ")";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryDto country = (CountryDto) o;

        if (codeName != null ? !codeName.equals(country.codeName) : country.codeName != null) return false;
        if (name != null ? !name.equals(country.name) : country.name != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (codeName != null ? codeName.hashCode() : 0);
        return result;
    }
}
