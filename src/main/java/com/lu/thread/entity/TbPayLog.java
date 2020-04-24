package com.lu.thread.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tb_pay_log", schema = "leyou", catalog = "")
public class TbPayLog {
    private long orderId;
    private Long totalFee;
    private Long userId;
    private String transactionId;
    private Byte status;
    private Byte payType;
    private String bankType;
    private Timestamp createTime;
    private Timestamp payTime;
    private Timestamp closedTime;
    private Timestamp refundTime;

    @Id
    @Column(name = "order_id")
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "total_fee")
    public Long getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Long totalFee) {
        this.totalFee = totalFee;
    }

    @Basic
    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "transaction_id")
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @Basic
    @Column(name = "status")
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Basic
    @Column(name = "pay_type")
    public Byte getPayType() {
        return payType;
    }

    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    @Basic
    @Column(name = "bank_type")
    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "pay_time")
    public Timestamp getPayTime() {
        return payTime;
    }

    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }

    @Basic
    @Column(name = "closed_time")
    public Timestamp getClosedTime() {
        return closedTime;
    }

    public void setClosedTime(Timestamp closedTime) {
        this.closedTime = closedTime;
    }

    @Basic
    @Column(name = "refund_time")
    public Timestamp getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Timestamp refundTime) {
        this.refundTime = refundTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbPayLog tbPayLog = (TbPayLog) o;
        return orderId == tbPayLog.orderId &&
                Objects.equals(totalFee, tbPayLog.totalFee) &&
                Objects.equals(userId, tbPayLog.userId) &&
                Objects.equals(transactionId, tbPayLog.transactionId) &&
                Objects.equals(status, tbPayLog.status) &&
                Objects.equals(payType, tbPayLog.payType) &&
                Objects.equals(bankType, tbPayLog.bankType) &&
                Objects.equals(createTime, tbPayLog.createTime) &&
                Objects.equals(payTime, tbPayLog.payTime) &&
                Objects.equals(closedTime, tbPayLog.closedTime) &&
                Objects.equals(refundTime, tbPayLog.refundTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, totalFee, userId, transactionId, status, payType, bankType, createTime, payTime, closedTime, refundTime);
    }
}
