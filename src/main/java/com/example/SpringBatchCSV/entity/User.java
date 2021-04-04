package com.example.SpringBatchCSV.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class User {

  @Id private Integer id;
  private String name;
  private String dept;
  private Integer salary;
}
