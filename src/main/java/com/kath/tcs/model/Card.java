package com.kath.tcs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private Name nameOnCard;
    private String cardNumber;
    private String cvv;
    private ExpirationDate expirationDate;
    private String cardType;
}
