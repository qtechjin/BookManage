package com.xiaomi.example.other.model;

/**
 * Created by Qiushi on 2017/7/12.
 *
 * 上报平台中以合同维度划分的数据结构
 */
public class ReportContractInfo {

    private long instructionId;
    private long contractId;
    private int tradeCode;
    private long encashAmount;
    private int contractStatus;
    private long intSettleTime;
    private long termEndTime;
    private long lastDayEndTime;
    private long clearTime;
    private int termNo;
    private int unpaidTermNum;
    private int gracefulDay;
    private long rate;
    private int maxOvdDays;
    private int maxOvdTimes;
    private int currentOvdDays;
    private int currentOvdTimes;
    private int fiveCategoryLevel;
    private int nextRepayDay;
    private long unpaidAmount;
    private long ovdUnpaidPrin;
    private long unpaidInterest;
    private long ovdUnpaidInterest;
    private long ovdUnpaidPrinPena;
    private long ovdUnpaidInterestPena;
    private long unpaidFee;
    private long ovdUnpaidFee;
    private long unpaidSpecialFee;
    private long unpaidExtensionFee;
    private long accruedInterest;
    private long accruedInterestPena;
    private long accruedInterestPrinPena;
    private long paidPrin;
    private long paidInterest;
    private long paidInterestPena;
    private long paidPrinPena;
    private long paidFee;
    private long paidSpecialFee;
    private long paidExtensionFee;
    private long paidInterestFreePrin;
    private long paidInterestFreeInterest;
    private long strikedInterestFreeIntrest;
    private long currentTime;
    private int unclearTermNum;

    /**
     * @param contractRollBackInfo
     */
    public ReportContractInfo() {

        this.gracefulDay = gracefulDay;
        this.rate = rate;
        this.maxOvdDays = maxOvdDays;
        this.maxOvdTimes = maxOvdTimes;
        this.currentOvdDays = currentOvdDays;
        this.currentOvdTimes = currentOvdTimes;
        this.fiveCategoryLevel = fiveCategoryLevel;
        this.nextRepayDay = nextRepayDay;
        this.unpaidAmount = unpaidAmount;
        this.ovdUnpaidPrin = ovdUnpaidPrin;
        this.unpaidInterest = unpaidInterest;
        this.ovdUnpaidInterest = ovdUnpaidInterest;
        this.ovdUnpaidPrinPena = ovdUnpaidPrinPena;
        this.ovdUnpaidInterestPena = ovdUnpaidInterestPena;
        this.unpaidFee = unpaidFee;
        this.ovdUnpaidFee = ovdUnpaidFee;
        this.unpaidSpecialFee = unpaidSpecialFee;
        this.unpaidExtensionFee = unpaidExtensionFee;
        this.accruedInterest = accruedInterest;
        this.accruedInterestPena = accruedInterestPena;
        this.accruedInterestPrinPena = accruedInterestPrinPena;
        this.paidPrin = paidPrin;
        this.paidInterest = paidInterest;
        this.paidInterestPena = paidInterestPena;
        this.paidPrinPena = paidPrinPena;
        this.paidFee = paidFee;
        this.paidSpecialFee = paidSpecialFee;
        this.paidExtensionFee = paidExtensionFee;
        this.paidInterestFreePrin = paidInterestFreePrin;
        this.paidInterestFreeInterest = paidInterestFreeInterest;
        this.strikedInterestFreeIntrest = strikedInterestFreeIntrest;
        this.currentTime = currentTime;
        this.unclearTermNum = unclearTermNum;
    }
}
