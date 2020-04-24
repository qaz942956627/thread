package com.lu.thread.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tb_order", schema = "leyou", catalog = "")
public class TbOrder {
    private Long orderId;
    private Long totalPay;
    private Long actualPay;
    private String promotionIds;
    private byte paymentType;
    private Long postFee;
    private Timestamp createTime;
    private String shippingName;
    private String shippingCode;
    private String userId;
    private String buyerMessage;
    private String buyerNick;
    private Byte buyerRate;
    private String receiverState;
    private String receiverCity;
    private String receiverDistrict;
    private String receiverAddress;
    private String receiverMobile;
    private String receiverZip;
    private String receiver;
    private Integer invoiceType;
    private Integer sourceType;

    @Id
    @Column(name = "order_id")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "total_pay")
    public Long getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(Long totalPay) {
        this.totalPay = totalPay;
    }

    @Basic
    @Column(name = "actual_pay")
    public Long getActualPay() {
        return actualPay;
    }

    public void setActualPay(Long actualPay) {
        this.actualPay = actualPay;
    }

    @Basic
    @Column(name = "promotion_ids")
    public String getPromotionIds() {
        return promotionIds;
    }

    public void setPromotionIds(String promotionIds) {
        this.promotionIds = promotionIds;
    }

    @Basic
    @Column(name = "payment_type")
    public byte getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(byte paymentType) {
        this.paymentType = paymentType;
    }

    @Basic
    @Column(name = "post_fee")
    public Long getPostFee() {
        return postFee;
    }

    public void setPostFee(Long postFee) {
        this.postFee = postFee;
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
    @Column(name = "shipping_name")
    public String getShippingName() {
        return shippingName;
    }

    public void setShippingName(String shippingName) {
        this.shippingName = shippingName;
    }

    @Basic
    @Column(name = "shipping_code")
    public String getShippingCode() {
        return shippingCode;
    }

    public void setShippingCode(String shippingCode) {
        this.shippingCode = shippingCode;
    }

    @Basic
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "buyer_message")
    public String getBuyerMessage() {
        return buyerMessage;
    }

    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage;
    }

    @Basic
    @Column(name = "buyer_nick")
    public String getBuyerNick() {
        return buyerNick;
    }

    public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick;
    }

    @Basic
    @Column(name = "buyer_rate")
    public Byte getBuyerRate() {
        return buyerRate;
    }

    public void setBuyerRate(Byte buyerRate) {
        this.buyerRate = buyerRate;
    }

    @Basic
    @Column(name = "receiver_state")
    public String getReceiverState() {
        return receiverState;
    }

    public void setReceiverState(String receiverState) {
        this.receiverState = receiverState;
    }

    @Basic
    @Column(name = "receiver_city")
    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    @Basic
    @Column(name = "receiver_district")
    public String getReceiverDistrict() {
        return receiverDistrict;
    }

    public void setReceiverDistrict(String receiverDistrict) {
        this.receiverDistrict = receiverDistrict;
    }

    @Basic
    @Column(name = "receiver_address")
    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    @Basic
    @Column(name = "receiver_mobile")
    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    @Basic
    @Column(name = "receiver_zip")
    public String getReceiverZip() {
        return receiverZip;
    }

    public void setReceiverZip(String receiverZip) {
        this.receiverZip = receiverZip;
    }

    @Basic
    @Column(name = "receiver")
    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @Basic
    @Column(name = "invoice_type")
    public Integer getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    @Basic
    @Column(name = "source_type")
    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbOrder tbOrder = (TbOrder) o;
        return orderId == tbOrder.orderId &&
                totalPay == tbOrder.totalPay &&
                actualPay == tbOrder.actualPay &&
                paymentType == tbOrder.paymentType &&
                postFee == tbOrder.postFee &&
                Objects.equals(promotionIds, tbOrder.promotionIds) &&
                Objects.equals(createTime, tbOrder.createTime) &&
                Objects.equals(shippingName, tbOrder.shippingName) &&
                Objects.equals(shippingCode, tbOrder.shippingCode) &&
                Objects.equals(userId, tbOrder.userId) &&
                Objects.equals(buyerMessage, tbOrder.buyerMessage) &&
                Objects.equals(buyerNick, tbOrder.buyerNick) &&
                Objects.equals(buyerRate, tbOrder.buyerRate) &&
                Objects.equals(receiverState, tbOrder.receiverState) &&
                Objects.equals(receiverCity, tbOrder.receiverCity) &&
                Objects.equals(receiverDistrict, tbOrder.receiverDistrict) &&
                Objects.equals(receiverAddress, tbOrder.receiverAddress) &&
                Objects.equals(receiverMobile, tbOrder.receiverMobile) &&
                Objects.equals(receiverZip, tbOrder.receiverZip) &&
                Objects.equals(receiver, tbOrder.receiver) &&
                Objects.equals(invoiceType, tbOrder.invoiceType) &&
                Objects.equals(sourceType, tbOrder.sourceType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, totalPay, actualPay, promotionIds, paymentType, postFee, createTime, shippingName, shippingCode, userId, buyerMessage, buyerNick, buyerRate, receiverState, receiverCity, receiverDistrict, receiverAddress, receiverMobile, receiverZip, receiver, invoiceType, sourceType);
    }
}
