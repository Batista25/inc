package com.inc.admin.domain.biz;

import com.inc.admin.domain.sys.BaseEntity;

/**
 * 
 * 表名：business_details
 * @author tanzibiao
 * @date 2022-05-23 01:02:50
 */
public class Business extends BaseEntity {
    /**商机id*/
    private Object id;

    /**批次id*/
    private Object batchid;

    /**商机类型（存款、贷款、开户）*/
    private Object type;

    /**客户*/
    private Object customer;

    /**是否存量客户（1-是，0-否）*/
    private Object stock;

    /**联系人*/
    private Object contacts;

    /**联系电话*/
    private Object phone;

    /**地址*/
    private Object address;

    /**商机详情*/
    private Object details;

    /**综合评分*/
    private Object score;

    /**推荐指数*/
    private Object recommendation;

    /**状态*/
    private Object status;

    /**创建时间*/
    private Object createtime;

    /**更新时间*/
    private Object updatetime;

    /**跟进人*/
    private Object owner;

    /**
     * 获取 商机id
     * @return java.lang.Object
     */
    public Object getId() {
        return id;
    }

    /**
     * 设置 商机id
     * @param id
     */
    public void setId(Object id) {
        this.id = id;
    }

    /**
     * 获取 批次id
     * @return java.lang.Object
     */
    public Object getBatchid() {
        return batchid;
    }

    /**
     * 设置 批次id
     * @param batchid
     */
    public void setBatchid(Object batchid) {
        this.batchid = batchid;
    }

    /**
     * 获取 商机类型（存款、贷款、开户）
     * @return java.lang.Object
     */
    public Object getType() {
        return type;
    }

    /**
     * 设置 商机类型（存款、贷款、开户）
     * @param type
     */
    public void setType(Object type) {
        this.type = type;
    }

    /**
     * 获取 客户
     * @return java.lang.Object
     */
    public Object getCustomer() {
        return customer;
    }

    /**
     * 设置 客户
     * @param customer
     */
    public void setCustomer(Object customer) {
        this.customer = customer;
    }

    /**
     * 获取 是否存量客户（1-是，0-否）
     * @return java.lang.Object
     */
    public Object getStock() {
        return stock;
    }

    /**
     * 设置 是否存量客户（1-是，0-否）
     * @param stock
     */
    public void setStock(Object stock) {
        this.stock = stock;
    }

    /**
     * 获取 联系人
     * @return java.lang.Object
     */
    public Object getContacts() {
        return contacts;
    }

    /**
     * 设置 联系人
     * @param contacts
     */
    public void setContacts(Object contacts) {
        this.contacts = contacts;
    }

    /**
     * 获取 联系电话
     * @return java.lang.Object
     */
    public Object getPhone() {
        return phone;
    }

    /**
     * 设置 联系电话
     * @param phone
     */
    public void setPhone(Object phone) {
        this.phone = phone;
    }

    /**
     * 获取 地址
     * @return java.lang.Object
     */
    public Object getAddress() {
        return address;
    }

    /**
     * 设置 地址
     * @param address
     */
    public void setAddress(Object address) {
        this.address = address;
    }

    /**
     * 获取 商机详情
     * @return java.lang.Object
     */
    public Object getDetails() {
        return details;
    }

    /**
     * 设置 商机详情
     * @param details
     */
    public void setDetails(Object details) {
        this.details = details;
    }

    /**
     * 获取 综合评分
     * @return java.lang.Object
     */
    public Object getScore() {
        return score;
    }

    /**
     * 设置 综合评分
     * @param score
     */
    public void setScore(Object score) {
        this.score = score;
    }

    /**
     * 获取 推荐指数
     * @return java.lang.Object
     */
    public Object getRecommendation() {
        return recommendation;
    }

    /**
     * 设置 推荐指数
     * @param recommendation
     */
    public void setRecommendation(Object recommendation) {
        this.recommendation = recommendation;
    }

    /**
     * 获取 状态
     * @return java.lang.Object
     */
    public Object getStatus() {
        return status;
    }

    /**
     * 设置 状态
     * @param status
     */
    public void setStatus(Object status) {
        this.status = status;
    }

    /**
     * 获取 创建时间
     * @return java.lang.Object
     */
    public Object getCreatetime() {
        return createtime;
    }

    /**
     * 设置 创建时间
     * @param createtime
     */
    public void setCreatetime(Object createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取 更新时间
     * @return java.lang.Object
     */
    public Object getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置 更新时间
     * @param updatetime
     */
    public void setUpdatetime(Object updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 获取 跟进人
     * @return java.lang.Object
     */
    public Object getOwner() {
        return owner;
    }

    /**
     * 设置 跟进人
     * @param owner
     */
    public void setOwner(Object owner) {
        this.owner = owner;
    }
}