package com.pathz.boot.rest.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ItemRequestDTO {
    private String name;
    private Integer quantity;
    private Integer price;
}
