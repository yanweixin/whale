package me.whale.data.dbms.domain.system.log;

import me.whale.common.enums.general.LogLevel;
import me.whale.common.enums.system.AppModule;
import me.whale.data.dbms.domain.BaseEntity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

public class ManualLog extends BaseEntity {
    private LogLevel logLevel;
    @NotNull
    @Enumerated(EnumType.STRING)
    private AppModule appModule;
    private String message;
    private String traceId;

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public AppModule getAppModule() {
        return appModule;
    }

    public void setAppModule(AppModule appModule) {
        this.appModule = appModule;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }
}
