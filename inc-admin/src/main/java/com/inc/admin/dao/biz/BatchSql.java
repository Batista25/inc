package com.inc.admin.dao.biz;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class BatchSql {
    public static final Batch batch = new Batch();

    /**批次id*/
    public static final SqlColumn<Object> id = batch.id;

    /**批次详情*/
    public static final SqlColumn<Object> details = batch.details;

    /**综合评分*/
    public static final SqlColumn<Object> score = batch.score;

    /**推荐指数*/
    public static final SqlColumn<Object> recommendation = batch.recommendation;

    /**状态*/
    public static final SqlColumn<Object> status = batch.status;

    /**创建时间*/
    public static final SqlColumn<Object> createtime = batch.createtime;

    /**更新时间*/
    public static final SqlColumn<Object> updatetime = batch.updatetime;

    /**操作人*/
    public static final SqlColumn<Object> operator = batch.operator;

    public static final class Batch extends SqlTable {
        public final SqlColumn<Object> id = column("id", JDBCType.OTHER);

        public final SqlColumn<Object> details = column("details", JDBCType.OTHER);

        public final SqlColumn<Object> score = column("score", JDBCType.OTHER);

        public final SqlColumn<Object> recommendation = column("recommendation", JDBCType.OTHER);

        public final SqlColumn<Object> status = column("status", JDBCType.OTHER);

        public final SqlColumn<Object> createtime = column("createTime", JDBCType.OTHER);

        public final SqlColumn<Object> updatetime = column("updateTime", JDBCType.OTHER);

        public final SqlColumn<Object> operator = column("operator", JDBCType.OTHER);

        public Batch() {
            super("business_batch");
        }
    }
}