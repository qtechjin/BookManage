package com.xiaomi.example.pojo;

/**
 * Created by mi on 2017/2/15.
 */
public class Order {

    private int orderId;
    private String orderNo;
    private int userId;
    private String bookIsbn;
    private int count;
    private String remark;

    public Order() {
    }

    public Order(int orderId, String orderNo, int userId, String bookIsbn, int count, String remark) {
        this.orderId = orderId;
        this.orderNo = orderNo;
        this.userId = userId;
        this.bookIsbn = bookIsbn;
        this.count = count;
        this.remark = remark;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
