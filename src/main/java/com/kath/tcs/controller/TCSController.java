package com.kath.tcs.controller;

import com.kath.tcs.model.DriverInfo;
import com.kath.tcs.service.TCSService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/controlsystem/v1")
@Tag(name = "controlsystem", description = "Control system v1 controller")
public class TCSController {
    Logger LOGGER = LoggerFactory.getLogger(TCSController.class);
    private final TCSService tcsService;

    @Autowired
    public TCSController(TCSService tcsService) {
        this.tcsService = tcsService;
    }

    @Operation(description = "gets all list of drivers from DB")
    @GetMapping(value = "/getdrivers/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DriverInfo>> findAllDrivers() {
        List<DriverInfo> driverInfo = tcsService.getAllDrivers();
        LOGGER.info("The returned list of drivers from database is: {}", driverInfo);
        return new ResponseEntity<>(driverInfo, HttpStatus.OK);
    }

    @Operation(description = "gets driver information for given name from DB")
    @GetMapping(value = "/getdrivers/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DriverInfo>> getDriversByName(@PathVariable String name) {
        List<DriverInfo> driverInfo = tcsService.getDriversByName(name);
        LOGGER.info("The returned list of drivers from database for : {}", driverInfo);
        return new ResponseEntity<>(driverInfo, HttpStatus.OK);
    }

    @Operation(description = "add another driver information in the DB")
    @PostMapping(value = "/uploadDriver", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void addDriver(@RequestBody DriverInfo driverInfo) {
        tcsService.uploadDrivers(driverInfo);
        LOGGER.info("Driver information is updated for driver name : {}", driverInfo.getFirstName());
    }

    @Operation(description = "update the driver information from DB")
    @PutMapping(value = "/updateDriver", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> updateDriverInformation(@RequestBody DriverInfo driverInfo) {
        ResponseEntity<Integer> responseEntity = null;
        try {
            tcsService.updateDriverInformation(driverInfo);
            LOGGER.info("Updated driver information into database");
            return new ResponseEntity<>(1, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.info("Failed to update data into database");
            return new ResponseEntity<>(-1, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(description = "delete a driver from DB with given first name and last name")
    @DeleteMapping(value = "/deleteDriver/firstName={firstName}&lastName={lastName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteDriver(@PathVariable String firstName, @PathVariable String lastName) {
        tcsService.deleteDriver(firstName, lastName);
        LOGGER.info("Deleted driver from database!");
    }
}