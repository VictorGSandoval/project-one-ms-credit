package com.dvivasva.credit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Credit {
    @Id
    private String id;
    private String accountId;
    private String nameProduct;
    private double amountTotal;
    private int numberDueTotal; //dues
    private int numberDuePending; //deduct numberDueTotal

}
