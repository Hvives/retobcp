package com.esvr.retobcp.exception;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.reactivex.Single;

@JsonAutoDetect(
        creatorVisibility = JsonAutoDetect.Visibility.NONE,
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RetoBcpException extends RuntimeException {
    @JsonProperty
    private String code;
    @JsonProperty
    private String description;
    @JsonProperty
    private String errorType;

    @JsonCreator
    RetoBcpException(@JsonProperty(value = "code",required = true) String code, @JsonProperty(value = "description",required = true) String description, @JsonProperty("errorType") String errorType) {
        this.code = code;
        this.description = description;
        this.errorType = errorType;
    }

    RetoBcpException(String code, String description, String errorType, Throwable cause) {
        super(description, cause);
        this.code = code;
        this.description = description;
        this.errorType = errorType;
    }

    public Single<RetoBcpException> asSingle() {
        return Single.just(this);
    }

    public static RetoBcpExceptionBuilder builder() {
        return new RetoBcpExceptionBuilder();
    }
    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public String getErrorType() {
        return this.errorType;
    }
}
