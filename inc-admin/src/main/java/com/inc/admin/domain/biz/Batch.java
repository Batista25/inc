package com.inc.admin.domain.biz;

import com.inc.admin.domain.sys.BaseEntity;

/**
 * 
 * 表名：business_batch
 * @author tanzibiao
 * @date 2022-05-23 02:04:56
 */
public class Batch extends BaseEntity {
    /**批次id*/
    private Object id;

    /**批次详情*/
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

    /**操作人*/
    private Object operator;

    /**
     * 获取 批次id
     * @return java.lang.Object
     */
    public Object getId() {
        return id;
    }

    /**
     * 设置 批次id
     * @param id
     */
    public void setId(Object id) {
        this.id = id;
    }

    /**
     * 获取 批次详情
     * @return java.lang.Object
     */
    public Object getDetails() {
        return details;
    }

    /**
     * 设置 批次详情
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
     * 获取 操作人
     * @return java.lang.Object
     */
    public Object getOperator() {
        return operator;
    }

    /**
     * 设置 操作人
     * @param operator
     */
    public void setOperator(Object operator) {
        this.operator = operator;
    }
}