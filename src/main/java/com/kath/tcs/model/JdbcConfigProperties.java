package com.kath.tcs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JdbcConfigProperties {
    private String url;
    private String dbName;
    private String userName;
    private String password;
    private int retryDelay;
    private int retryCount;
    private String validationQuery;

    public String getUrl() {
        return url;
    }

    public String getDbName() {
        return dbName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getRetryDelay() {
        return retryDelay;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public String getValidationQuery() {
        return validationQuery;
    }
}
