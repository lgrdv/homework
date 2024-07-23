package ru.gordeeva.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Response {
   private boolean status;
   private String message;
}
