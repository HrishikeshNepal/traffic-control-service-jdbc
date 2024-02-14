package com.kath.tcs.service;

import com.kath.tcs.model.DriverInfo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TCSService {
    Logger LOGGER = LoggerFactory.getLogger(TCSService.class);
    private final JdbcTemplate tcsJdbcTemplate;
    private final DataSource tcsDataSource;

    @Autowired
    public TCSService(JdbcTemplate tcsJdbcTemplate, DataSource tcsDataSource) {
        this.tcsJdbcTemplate = tcsJdbcTemplate;
        this.tcsDataSource = tcsDataSource;
    }

    public List<DriverInfo> getAllDrivers() {
        // Implementation of RowMapper interface
        String query = "SELECT * FROM DRIVER_INFO";
        LOGGER.info("Making database call for query: {}", query);
        List<DriverInfo> driverInfo = null;
        try {
            driverInfo = tcsJdbcTemplate.query(query, new DriverInfoRowMapper());
        } catch (Exception e) {
            LOGGER.info("Exception while running query: {}", e.getMessage());
            return null;
        }

        LOGGER.info("The returned list of drivers from database is: {}", driverInfo);
        return driverInfo;
    }

    public List<DriverInfo> getDriversByName(String name) {
        String query = "Select * from DRIVER_INFO where first_name = ? ";
        PreparedStatement ps = null;
        List<DriverInfo> list = new ArrayList<>();
        try {
            Connection connection = tcsDataSource.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DriverInfo driverInfo = DriverInfo.builder()
                        .firstName(rs.getString(1))
                        .middleName(rs.getString(2))
                        .lastName(rs.getString(3))
                        .phone(rs.getString(4))
                        .email(rs.getString(5))
                        .address(rs.getString(6))
                        .build();
                list.add(driverInfo);
            }

            // Close the connection
            connection.close();
        } catch (Exception e) {
            LOGGER.info("Exception while running query: {}", e.getMessage());
            return null;
        }
        return list;
    }

    public void uploadDrivers(DriverInfo driverInfo){
        String query = "INSERT INTO DRIVER_INFO (FIRST_NAME, MIDDLE_NAME, LAST_NAME, PHONE, EMAIL, ADDRESS)" +
                "VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            LOGGER.info("Adding driver info into database for driver : {}", driverInfo.getFirstName());
            Connection connection = tcsDataSource.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, driverInfo.getFirstName());
            ps.setString(2, driverInfo.getMiddleName());
            ps.setString(3, driverInfo.getLastName());
            ps.setString(4, driverInfo.getPhone());
            ps.setString(5, driverInfo.getEmail());
            ps.setString(6, driverInfo.getAddress());
            ps.executeUpdate();
            // Close the connection
            connection.close();
        } catch (Exception e) {
            LOGGER.info("Exception while running insert query: {}", e.getMessage());
        }
    }

    public void updateDriverInformation(DriverInfo driverInfo){
        String query = "UPDATE DRIVER_INFO SET FIRST_NAME = ?, MIDDLE_NAME = ?, LAST_NAME = ?," +
                " PHONE = ?, EMAIL = ?, ADDRESS = ? WHERE FIRST_NAME = ?";
        PreparedStatement ps = null;
        try {
            LOGGER.info("Updating driver info into database for driver : {}", driverInfo.getFirstName());
            Connection connection = tcsDataSource.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, driverInfo.getFirstName());
            ps.setString(2, driverInfo.getMiddleName());
            ps.setString(3, driverInfo.getLastName());
            ps.setString(4, driverInfo.getPhone());
            ps.setString(5, driverInfo.getEmail());
            ps.setString(6, driverInfo.getAddress());
            ps.setString(7, driverInfo.getFirstName());
            ps.executeUpdate();
            // Close the connection
            connection.close();
        } catch (Exception e) {
            LOGGER.info("Exception while running update query: {}", e.getMessage());
        }
    }

    public void deleteDriver(String firstName, String lastName){
        String query = "DELETE FROM DRIVER_INFO WHERE first_name = ? AND last_name = ?";
        PreparedStatement ps = null;
        try {
            LOGGER.info("Deleting driver info from database where driver is : {}", firstName, lastName);
            Connection connection = tcsDataSource.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.executeUpdate();
            // Close the connection
            connection.close();
        } catch (Exception e) {
            LOGGER.info("Exception while running delete query: {}", e.getMessage());
        }
    }
}
