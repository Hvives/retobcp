package com.esvr.retobcp.exception;

import io.reactivex.*;
import org.apache.commons.lang3.StringUtils;

public final class RetoBcpExceptionBuilder {
    private String systemCode;
    private String description;
    private String errorType;

    public RetoBcpExceptionBuilder errorType(String errorType) {
        if (StringUtils.isNotBlank(errorType)) {
            this.errorType = errorType;
        }

        return this;
    }

    public static RetoBcpExceptionBuilder builder() {
        return new RetoBcpExceptionBuilder();
    }

    public RetoBcpExceptionBuilder description(String description) {
        if (StringUtils.isNotBlank(description)) {
            this.description = description;
        }

        return this;
    }

    public RetoBcpExceptionBuilder systemCode(String systemCode) {
        if (StringUtils.isNotBlank(systemCode)) {
            this.systemCode = systemCode;
        }

        return this;
    }
    public RetoBcpException build() {
        return new RetoBcpException(this.systemCode, this.description, this.errorType);
    }

    public Completable buildAsCompletable() {
        return Completable.error(this.build());
    }

    public <T> Single<T> buildAsSingle() {
        return Single.error(this.build());
    }

    public <T> Maybe<T> buildAsMaybe() {
        return Maybe.error(this.build());
    }

    public <T> Observable<T> buildAsObservable() {
        return Observable.error(this.build());
    }

    public <T> Flowable<T> buildAsFlowable() {
        return Flowable.error(this.build());
    }
    RetoBcpExceptionBuilder() {
    }
}