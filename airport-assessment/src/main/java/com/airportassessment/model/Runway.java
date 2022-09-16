package com.airportassessment.model;

public class Runway {
  private int id;
  private String airport_ref;
  private String airport_ident;


  public Runway(int id, String airport_ref, String airport_ident){
    this.id = id;
    this.airport_ref = airport_ref;
    this.airport_ident = airport_ident;
  }

  public Runway(String[] attrs){
    this.id = Integer.parseInt(attrs[0]);
    this.airport_ref = attrs[1];
    this.airport_ident = attrs[2];
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getAirport_ref() {
    return airport_ref;
  }

  public void setAirport_ref(String airport_ref) {
    this.airport_ref = airport_ref;
  }

  public String getAirport_ident() {
    return airport_ident;
  }

  public void setAirport_ident(String airport_ident) {
    this.airport_ident = airport_ident;
  }

  @Override
  public String toString() {
    return "Runaway{" +
            "id=" + id +
            ", airport_ref='" + airport_ref + '\'' +
            ", airport_ident='" + airport_ident + '\'' +
            '}';
  }
}
