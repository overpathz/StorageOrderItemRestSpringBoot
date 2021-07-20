package com.pathz.boot.rest.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class OrderRequestDTO {
    private Integer price;
    private Integer quantity;
    private Integer itemId;
}
