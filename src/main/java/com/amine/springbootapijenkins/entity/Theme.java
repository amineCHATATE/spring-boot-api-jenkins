package com.amine.springbootapijenkins.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Theme {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  @NotEmpty
  private String name;
  @NotEmpty
  private String description;

  public Theme(String name, String description) {
    this.name = name;
    this.description = description;
  }

}