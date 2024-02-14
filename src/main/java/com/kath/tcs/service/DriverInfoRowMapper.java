package com.kath.tcs.service;

import com.kath.tcs.model.DriverInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DriverInfoRowMapper implements RowMapper<DriverInfo> {

    public DriverInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        DriverInfo driver = new DriverInfo();
        driver.setFirstName(rs.getString(1));
        driver.setMiddleName(rs.getString(2));
        driver.setLastName(rs.getString(3));
        driver.setPhone(rs.getString(4));
        driver.setEmail(rs.getString(5));
        driver.setAddress(rs.getString(6));
        return driver;
    }
}
