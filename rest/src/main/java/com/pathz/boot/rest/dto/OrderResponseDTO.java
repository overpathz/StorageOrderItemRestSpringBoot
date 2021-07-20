package com.pathz.boot.rest.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class OrderResponseDTO {
    private Integer id;
    private Integer price;
    private Integer quantity;
    private String item;
}
