package com.airportassessment.model;

import java.util.HashMap;
import java.util.Map;

public class Country{
  private int id;
  private String code;
  private String name;
  private String continent;
  private String wikipediaLink;
  private String keywords;

  private Map<String, Airport> airportMap;

  public Country(int id, String code, String name, String continent, String wikipediaLink, String keywords){
    this.id = id;
    this.code = code;
    this.name = name;
    this.continent = continent;
    this.wikipediaLink = wikipediaLink;
    this.keywords = keywords;
    this.airportMap = new HashMap<>();
  }

  public Country(String[] attrs){
    this.id = Integer.parseInt(attrs[0]);
    this.code = attrs[1];
    this.name = attrs[2];
    this.continent = attrs[3];
    this.wikipediaLink = attrs[4];
    this.keywords = attrs[5];
    this.airportMap = new HashMap<>();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContinent() {
    return continent;
  }

  public void setContinent(String continent) {
    this.continent = continent;
  }

  public String getWikipediaLink() {
    return wikipediaLink;
  }

  public void setWikipediaLink(String wikipediaLink) {
    this.wikipediaLink = wikipediaLink;
  }

  public String getKeywords() {
    return keywords;
  }

  public void setKeywords(String keywords) {
    this.keywords = keywords;
  }

  public Map<String, Airport> getAirportMap() {
    return airportMap;
  }

  public void setAirportMap(Map<String, Airport> airportMap) {
    this.airportMap = airportMap;
  }

  public void addAirportToMap(String id, Airport airport) {
    airportMap.put(id, airport);
  }

  @Override
  public String toString() {
    return "Country{" +
            "id=" + id +
            ", code='" + code + '\'' +
            ", name='" + name + '\'' +
            ", continent='" + continent + '\'' +
            ", wikipediaLink='" + wikipediaLink + '\'' +
            ", keywords='" + keywords + '\'' +
            '}';
  }
}
