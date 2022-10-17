package com.example.emailapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Base {
    @Id
    String id;
}
