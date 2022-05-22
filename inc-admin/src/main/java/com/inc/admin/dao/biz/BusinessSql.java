package com.inc.admin.dao.biz;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class BusinessSql {
    public static final Business business = new Business();

    /**商机id*/
    public static final SqlColumn<Object> id = business.id;

    /**批次id*/
    public static final SqlColumn<Object> batchid = business.batchid;

    /**商机类型（存款、贷款、开户）*/
    public static final SqlColumn<Object> type = business.type;

    /**客户*/
    public static final SqlColumn<Object> customer = business.customer;

    /**是否存量客户（1-是，0-否）*/
    public static final SqlColumn<Object> stock = business.stock;

    /**联系人*/
    public static final SqlColumn<Object> contacts = business.contacts;

    /**联系电话*/
    public static final SqlColumn<Object> phone = business.phone;

    /**地址*/
    public static final SqlColumn<Object> address = business.address;

    /**商机详情*/
    public static final SqlColumn<Object> details = business.details;

    /**综合评分*/
    public static final SqlColumn<Object> score = business.score;

    /**推荐指数*/
    public static final SqlColumn<Object> recommendation = business.recommendation;

    /**创建时间*/
    public static final SqlColumn<Object> createtime = business.createtime;

    /**更新时间*/
    public static final SqlColumn<Object> updatetime = business.updatetime;

    /**跟进人*/
    public static final SqlColumn<Object> owner = business.owner;

    public static final class Business extends SqlTable {
        public final SqlColumn<Object> id = column("id", JDBCType.OTHER);

        public final SqlColumn<Object> batchid = column("batchId", JDBCType.OTHER);

        public final SqlColumn<Object> type = column("type", JDBCType.OTHER);

        public final SqlColumn<Object> customer = column("customer", JDBCType.OTHER);

        public final SqlColumn<Object> stock = column("stock", JDBCType.OTHER);

        public final SqlColumn<Object> contacts = column("contacts", JDBCType.OTHER);

        public final SqlColumn<Object> phone = column("phone", JDBCType.OTHER);

        public final SqlColumn<Object> address = column("address", JDBCType.OTHER);

        public final SqlColumn<Object> details = column("details", JDBCType.OTHER);

        public final SqlColumn<Object> score = column("score", JDBCType.OTHER);

        public final SqlColumn<Object> recommendation = column("recommendation", JDBCType.OTHER);

        public final SqlColumn<Object> createtime = column("createTime", JDBCType.OTHER);

        public final SqlColumn<Object> updatetime = column("updateTime", JDBCType.OTHER);

        public final SqlColumn<Object> owner = column("owner", JDBCType.OTHER);

        public Business() {
            super("business_details");
        }
    }
}