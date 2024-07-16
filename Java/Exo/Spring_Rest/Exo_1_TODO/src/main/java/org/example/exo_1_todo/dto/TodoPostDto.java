package org.example.exo_1_todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoPostDto {
    private String title;
    private String description;
    private String createdAt;
}
