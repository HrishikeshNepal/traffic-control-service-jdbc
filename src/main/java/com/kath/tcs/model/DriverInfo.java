package com.kath.tcs.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Driver Information")
public class DriverInfo {
    //private Name name;
    @Schema(description = "first_name")
    private String firstName;
    @Schema(description = "middle_name")
    private String middleName;
    @Schema(description = "last_name")
    private String lastName;
    @Schema(description = "phone")
    private String phone;
    @Schema(description = "email")
    private String email;
    @Schema(description = "address")
    //private Address address;
    private String address;
}
