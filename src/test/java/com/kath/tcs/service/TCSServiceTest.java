//package com.kath.tcs.service;
//
//import com.kath.tcs.model.DriverInfo;
//import org.junit.Before;
//import org.junit.internal.runners.JUnit4ClassRunner;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.ArgumentMatchers;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import javax.sql.DataSource;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//public class TCSServiceTest {
//    @Mock
//    private JdbcTemplate tcsJdbcTemplate;
//    @Mock
//    private DataSource tcsDataSource;
//    private TCSService tcsService;
//    private DriverInfo driverInfo;
//    private List<DriverInfo> driverInfoList;
//
//    @Before
//    public void setUp(){
//        tcsService = new TCSService(tcsJdbcTemplate, tcsDataSource);
//        driverInfo = DriverInfo.builder()
//                .firstName("test_first_name")
//                .lastName("test_last_name")
//                .middleName("test_middle_name")
//                .email("test_email")
//                .phone("87677656456465")
//                .address("900 test address, Denver, CO")
//                .build();
//        driverInfoList.add(driverInfo);
//    }
//
//    @Test
//    public void test_getAllDrivers(){
//        when(tcsJdbcTemplate.query(anyString(), ArgumentMatchers.any(DriverInfoRowMapper.class))).thenReturn(driverInfoList);
//        List<DriverInfo> actualDriverInfoList = tcsService.getAllDrivers();
//        assertEquals(actualDriverInfoList.size(), 1);
//    }
//}
