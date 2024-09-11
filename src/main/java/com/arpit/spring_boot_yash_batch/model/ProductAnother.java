package com.arpit.spring_boot_yash_batch.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class ProductAnother {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;
  private int price;
  private String Description;

  @Lob
  @Column(name = "image", columnDefinition = "LONGBLOB")
  private byte[] image;


  public ProductAnother(Long id, String name, int price, String Description) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.Description = Description;
  }

  public ProductAnother() {
  }


  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return this.price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getDescription() {
    return this.Description;
  }

  public void setDescription(String Description) {
    this.Description = Description;
  }

  public byte[] getImage() {
    return this.image;
  }

  public void setImage(byte[] image) {
    this.image = image;
  }


  @Override
  public String toString() {
    return "Name " + name
            + "Id " + id
            + "Description " + Description
            + "Price " + price;
  }

}
