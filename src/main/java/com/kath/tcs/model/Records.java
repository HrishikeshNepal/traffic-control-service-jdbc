package com.kath.tcs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Records {
    private String yearsOfDriving;
    private List<Violations> violations;
    private List<Claims> claims;
    private String penalty;
}
