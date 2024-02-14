package com.kath.tcs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Claims {
    private String id;
    private String claimType;
    private String description;
    private String decision;
}
