package ru.gordeeva.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table
@NoArgsConstructor
public class Task {
    @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private LocalDateTime dateTime;


}
