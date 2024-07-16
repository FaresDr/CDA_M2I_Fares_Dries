package org.example.tp_spring_react.dto.vacancesDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VacancesDTOPost {
    private int idemployee;
    private String beggining;
    private String end;
}
