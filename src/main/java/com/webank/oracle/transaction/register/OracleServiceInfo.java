package com.webank.oracle.transaction.register;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.collections4.CollectionUtils;
import org.fisco.bcos.web3j.tuples.generated.Tuple10;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */

@Slf4j
@Data
public class OracleServiceInfo {
    private BigInteger index;
    private String oracleServiceAddress;
    private List<String> publicKeyList;
    private String keyHash;
    private String operator;
    private String url;
    private BigInteger creatTime;
    private BigInteger latestRequstProcessedTime;
    private boolean status;
    private BigInteger processedRequestAmount;


    public static OracleServiceInfo build(Tuple10<BigInteger, String, List<BigInteger>, byte[], String, String,
            BigInteger, BigInteger, Boolean, BigInteger> tuple10){
        OracleServiceInfo oracleServiceInfo = new OracleServiceInfo();
        oracleServiceInfo.index = tuple10.getValue1();
        oracleServiceInfo.oracleServiceAddress = tuple10.getValue2();
        List<BigInteger> publicKey = tuple10.getValue3();

        oracleServiceInfo.keyHash = Hex.encodeHexString(tuple10.getValue4());
        oracleServiceInfo.operator = tuple10.getValue5();
        oracleServiceInfo.url = tuple10.getValue6();
        oracleServiceInfo.creatTime = tuple10.getValue7();
        oracleServiceInfo.latestRequstProcessedTime = tuple10.getValue8();
        oracleServiceInfo.status = tuple10.getValue9();
        oracleServiceInfo.processedRequestAmount = tuple10.getValue10();

        // public key
        if (CollectionUtils.size(publicKey) == 2)
            oracleServiceInfo.publicKeyList = Arrays.asList(new String[]{
                    Hex.encodeHexString(publicKey.get(0).toByteArray()),
                    Hex.encodeHexString(publicKey.get(1).toByteArray())
            });


        return oracleServiceInfo;
    }

}