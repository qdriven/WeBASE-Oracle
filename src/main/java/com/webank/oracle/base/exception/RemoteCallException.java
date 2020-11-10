package com.webank.oracle.base.exception;

import com.webank.oracle.base.enums.ReqStatusEnum;

public class RemoteCallException extends BaseException {
    public RemoteCallException(ReqStatusEnum reqStatusEnum,Object ... paramArray){
        super(reqStatusEnum,paramArray);
    }
}
