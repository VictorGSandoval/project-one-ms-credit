package com.dvivasva.credit.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditDto {
    private String id;
    private String accountId;
    private String nameProduct;
    private double amountTotal;
    private int numberDueTotal;
    private int numberDuePending;
}
