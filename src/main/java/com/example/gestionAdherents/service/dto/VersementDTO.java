package com.example.gestionAdherents.service.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VersementDTO {
    private String id;
    private String type;
    public VersementDTO(String id){
        this.id=id;
    }
}
