package com.xiaomi.example.other.model;

/**
 * Created by Qiushi on 2017/7/12.
 *
 * 上报平台中以分期维度划分的数据结构
 */
public class ReportTermInfo {

    private long contractId;
    private int termNo;
    private long currentTime;
    private long termStartTime;
    private long termEndTime;
    private int termStatus;
    private long clearTime;
    private long prinToOvdTime;
    private long interestToOvdTime;
    private int ovdDays;
    private long ovdUnpaidPrinPena;
    private long ovdUnpaidInterestPena;
    private long unpaidExtensionFee;
    private long unpaidSpecialFee;
    private long unpaidFee;
    private long paidPrin;
    private long paidInterest;
    private long paidFee;
    private long paidPrinPena;
    private long paidInterestPena;
    private long paidAdditionalFee;
    private long paidInterestFreePrin;
    private long paidInterestFreeInterest;
    private long strikedInterestFreeInterest;

    /**
     *
     * @param contractRollBackInfo
     */
    public ReportTermInfo( ) {
    }

}
