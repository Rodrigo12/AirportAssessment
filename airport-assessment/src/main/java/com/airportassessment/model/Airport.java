package com.airportassessment.model;

import java.util.HashMap;
import java.util.Map;

public class Airport{
  private int id;
  private String ident;
  private String type;
  private String name;
  private String continent;
  private String iso_country;
  private String iso_region;
  private String iata_code;

  private Map<String, Runway> runwayMap;

  public Airport(int id, String ident, String type, String name, String continent, String iso_country, String iso_region, String iata_code){
    this.id = id;
    this.ident = ident;
    this.type = type;
    this.name = name;
    this.continent = continent;
    this.iso_country = iso_country;
    this.iso_region = iso_region;
    this.iata_code = iata_code;
    this.runwayMap = new HashMap<>();
  }

  public Airport(String[] attrs){
    this.id = Integer.parseInt(attrs[0]);
    this.ident = attrs[1];
    this.type = attrs[2];
    this.name = attrs[3];
    this.continent = attrs[7];
    this.iso_country = attrs[8];
    this.iso_region = attrs[9];
    this.iata_code = attrs[13];
    this.runwayMap = new HashMap<>();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getIdent() {
    return ident;
  }

  public void setIdent(String ident) {
    this.ident = ident;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
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

  public String getIso_country() {
    return iso_country;
  }

  public void setIso_country(String iso_country) {
    this.iso_country = iso_country;
  }

  public String getIso_region() {
    return iso_region;
  }

  public void setIso_region(String iso_region) {
    this.iso_region = iso_region;
  }

  public String getIata_code() {
    return iata_code;
  }

  public void setIata_code(String iata_code) {
    this.iata_code = iata_code;
  }

  public Map<String, Runway> getRunwayMap() {
    return runwayMap;
  }

  public void setRunwayMap(Map<String, Runway> runwayMap) {
    this.runwayMap = runwayMap;
  }

  public void addRunwayToMap(String id, Runway runway) {
    runwayMap.put(id, runway);
  }

  @Override
  public String toString() {
    return "Airport{" +
            "id=" + id +
            ", ident='" + ident + '\'' +
            ", type='" + type + '\'' +
            ", name='" + name + '\'' +
            ", continent='" + continent + '\'' +
            ", iso_country='" + iso_country + '\'' +
            ", iso_region='" + iso_region + '\'' +
            ", iata_code='" + iata_code + '\'' +
            '}';
  }
}
