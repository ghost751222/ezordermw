package com.macaron.ezordermw.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Table(name = "ORDER_LIST")
@Entity
public class OrderList {

    @Id
    @Column(name = "UUID")
    private String uuid;

    @Column(name = "ORDER_NO")
    private String order_no;

    @Column(name = "CUSTOM_PHONE")
    private String custom_phone;

    @Column(name = "AGENT_PHONE")
    private String agent_phone;

    @Column(name = "SMS_TAG")
    private String sms_tag;


    @Column(name = "UPLOAD_TIME")
    private LocalDateTime upload_time;

    @Column(name = "SMS_TIME")
    private LocalDateTime sms_time;

    @Column(name = "MODIFY_TIME")
    private LocalDateTime modify_time;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getCustom_phone() {
        return custom_phone;
    }

    public void setCustom_phone(String custom_phone) {
        this.custom_phone = custom_phone;
    }

    public String getAgent_phone() {
        return agent_phone;
    }

    public void setAgent_phone(String agent_phone) {
        this.agent_phone = agent_phone;
    }

    public String getSms_tag() {
        return sms_tag;
    }

    public void setSms_tag(String sms_tag) {
        this.sms_tag = sms_tag;
    }

    public LocalDateTime getUpload_time() {
        return upload_time;
    }

    public void setUpload_time(LocalDateTime upload_time) {
        this.upload_time = upload_time;
    }

    public LocalDateTime getSms_time() {
        return sms_time;
    }

    public void setSms_time(LocalDateTime sms_time) {
        this.sms_time = sms_time;
    }

    public LocalDateTime getModify_time() {
        return modify_time;
    }

    public void setModify_time(LocalDateTime modify_time) {
        this.modify_time = modify_time;
    }
}
