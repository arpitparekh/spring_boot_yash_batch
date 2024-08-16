package com.arpit.spring_boot_yash_batch.model;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1

import java.util.ArrayList;

import lombok.Data;

@Data
class CountryData{
    public String city;
    public String country;
    public ArrayList<PopulationCount> populationCounts;
}

@Data
class PopulationCount{
    public String year;
    public String value;
    public String sex;
    public String reliabilty;
}

@Data
public class Country{
    public boolean error;
    public String msg;
    public ArrayList<CountryData> data;
}


