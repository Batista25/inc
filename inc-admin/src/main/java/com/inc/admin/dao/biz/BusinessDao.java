package com.inc.admin.dao.biz;

import static com.inc.admin.dao.biz.BusinessSql.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.inc.admin.domain.biz.Business;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface BusinessDao {
    BasicColumn[] selectList = BasicColumn.columnList(id, batchid, type, customer, stock, contacts, phone, address, details, score, recommendation, createtime, updatetime, owner);

    /**
     * 查询  数量
     * @param selectStatement
     * @return long
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    /**
     * 删除 
     * @param deleteStatement
     * @return int
     */
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    /**
     * 添加 
     * @param insertStatement
     * @return int
     */
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Business> insertStatement);

    /**
     * 批量添加 
     * @param multipleInsertStatement
     * @return int
     */
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Business> multipleInsertStatement);

    /**
     * 查询单条 
     * @param selectStatement
     * @return java.util.Optional<com.inc.admin.domain.biz.Business>
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("BusinessResult")
    Optional<Business> selectOne(SelectStatementProvider selectStatement);

    /**
     * 查询多条 
     * @param selectStatement
     * @return java.util.List<com.inc.admin.domain.biz.Business>
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="BusinessResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.OTHER, id=true),
        @Result(column="batchId", property="batchid", jdbcType=JdbcType.OTHER),
        @Result(column="type", property="type", jdbcType=JdbcType.OTHER),
        @Result(column="customer", property="customer", jdbcType=JdbcType.OTHER),
        @Result(column="stock", property="stock", jdbcType=JdbcType.OTHER),
        @Result(column="contacts", property="contacts", jdbcType=JdbcType.OTHER),
        @Result(column="phone", property="phone", jdbcType=JdbcType.OTHER),
        @Result(column="address", property="address", jdbcType=JdbcType.OTHER),
        @Result(column="details", property="details", jdbcType=JdbcType.OTHER),
        @Result(column="score", property="score", jdbcType=JdbcType.OTHER),
        @Result(column="recommendation", property="recommendation", jdbcType=JdbcType.OTHER),
        @Result(column="createTime", property="createtime", jdbcType=JdbcType.OTHER),
        @Result(column="updateTime", property="updatetime", jdbcType=JdbcType.OTHER),
        @Result(column="owner", property="owner", jdbcType=JdbcType.OTHER)
    })
    List<Business> selectMany(SelectStatementProvider selectStatement);

    /**
     * 更新 
     * @param updateStatement
     * @return int
     */
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    /**
     * 查询  数量
     * @param completer
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, business, completer);
    }

    /**
     * 删除 
     * @param completer
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, business, completer);
    }

    /**
     * 根据主键删除 
     */
    default int deleteByPrimaryKey(Object id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    /**
     * 添加 
     */
    default int insert(Business record) {
        return MyBatis3Utils.insert(this::insert, record, business, c ->
            c.map(id).toProperty("id")
            .map(batchid).toProperty("batchid")
            .map(type).toProperty("type")
            .map(customer).toProperty("customer")
            .map(stock).toProperty("stock")
            .map(contacts).toProperty("contacts")
            .map(phone).toProperty("phone")
            .map(address).toProperty("address")
            .map(details).toProperty("details")
            .map(score).toProperty("score")
            .map(recommendation).toProperty("recommendation")
            .map(createtime).toProperty("createtime")
            .map(updatetime).toProperty("updatetime")
            .map(owner).toProperty("owner")
        );
    }

    /**
     * 批量添加 
     */
    default int insertMultiple(Collection<Business> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, business, c ->
            c.map(id).toProperty("id")
            .map(batchid).toProperty("batchid")
            .map(type).toProperty("type")
            .map(customer).toProperty("customer")
            .map(stock).toProperty("stock")
            .map(contacts).toProperty("contacts")
            .map(phone).toProperty("phone")
            .map(address).toProperty("address")
            .map(details).toProperty("details")
            .map(score).toProperty("score")
            .map(recommendation).toProperty("recommendation")
            .map(createtime).toProperty("createtime")
            .map(updatetime).toProperty("updatetime")
            .map(owner).toProperty("owner")
        );
    }

    /**
     * 插入值不为空的列 
     */
    default int insertSelective(Business record) {
        return MyBatis3Utils.insert(this::insert, record, business, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(batchid).toPropertyWhenPresent("batchid", record::getBatchid)
            .map(type).toPropertyWhenPresent("type", record::getType)
            .map(customer).toPropertyWhenPresent("customer", record::getCustomer)
            .map(stock).toPropertyWhenPresent("stock", record::getStock)
            .map(contacts).toPropertyWhenPresent("contacts", record::getContacts)
            .map(phone).toPropertyWhenPresent("phone", record::getPhone)
            .map(address).toPropertyWhenPresent("address", record::getAddress)
            .map(details).toPropertyWhenPresent("details", record::getDetails)
            .map(score).toPropertyWhenPresent("score", record::getScore)
            .map(recommendation).toPropertyWhenPresent("recommendation", record::getRecommendation)
            .map(createtime).toPropertyWhenPresent("createtime", record::getCreatetime)
            .map(updatetime).toPropertyWhenPresent("updatetime", record::getUpdatetime)
            .map(owner).toPropertyWhenPresent("owner", record::getOwner)
        );
    }

    /**
     * 查询单条 
     * @param completer
     */
    default Optional<Business> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, business, completer);
    }

    /**
     * 查询多条 
     * @param completer
     */
    default List<Business> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, business, completer);
    }

    /**
     * 去重查询 
     * @param completer
     */
    default List<Business> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, business, completer);
    }

    /**
     * 根据主键查询 
     */
    default Optional<Business> selectByPrimaryKey(Object id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    /**
     * 更新 
     * @param completer
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, business, completer);
    }

    /**
     * 更新所有列 
     */
    static UpdateDSL<UpdateModel> updateAllColumns(Business record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(batchid).equalTo(record::getBatchid)
                .set(type).equalTo(record::getType)
                .set(customer).equalTo(record::getCustomer)
                .set(stock).equalTo(record::getStock)
                .set(contacts).equalTo(record::getContacts)
                .set(phone).equalTo(record::getPhone)
                .set(address).equalTo(record::getAddress)
                .set(details).equalTo(record::getDetails)
                .set(score).equalTo(record::getScore)
                .set(recommendation).equalTo(record::getRecommendation)
                .set(createtime).equalTo(record::getCreatetime)
                .set(updatetime).equalTo(record::getUpdatetime)
                .set(owner).equalTo(record::getOwner);
    }

    /**
     * 更新值不为空的列 
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Business record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(batchid).equalToWhenPresent(record::getBatchid)
                .set(type).equalToWhenPresent(record::getType)
                .set(customer).equalToWhenPresent(record::getCustomer)
                .set(stock).equalToWhenPresent(record::getStock)
                .set(contacts).equalToWhenPresent(record::getContacts)
                .set(phone).equalToWhenPresent(record::getPhone)
                .set(address).equalToWhenPresent(record::getAddress)
                .set(details).equalToWhenPresent(record::getDetails)
                .set(score).equalToWhenPresent(record::getScore)
                .set(recommendation).equalToWhenPresent(record::getRecommendation)
                .set(createtime).equalToWhenPresent(record::getCreatetime)
                .set(updatetime).equalToWhenPresent(record::getUpdatetime)
                .set(owner).equalToWhenPresent(record::getOwner);
    }

    /**
     * 根据主键更新 
     */
    default int updateByPrimaryKey(Business record) {
        return update(c ->
            c.set(batchid).equalTo(record::getBatchid)
            .set(type).equalTo(record::getType)
            .set(customer).equalTo(record::getCustomer)
            .set(stock).equalTo(record::getStock)
            .set(contacts).equalTo(record::getContacts)
            .set(phone).equalTo(record::getPhone)
            .set(address).equalTo(record::getAddress)
            .set(details).equalTo(record::getDetails)
            .set(score).equalTo(record::getScore)
            .set(recommendation).equalTo(record::getRecommendation)
            .set(createtime).equalTo(record::getCreatetime)
            .set(updatetime).equalTo(record::getUpdatetime)
            .set(owner).equalTo(record::getOwner)
            .where(id, isEqualTo(record::getId))
        );
    }

    /**
     * 根据主键更新值不为空的列 
     */
    default int updateByPrimaryKeySelective(Business record) {
        return update(c ->
            c.set(batchid).equalToWhenPresent(record::getBatchid)
            .set(type).equalToWhenPresent(record::getType)
            .set(customer).equalToWhenPresent(record::getCustomer)
            .set(stock).equalToWhenPresent(record::getStock)
            .set(contacts).equalToWhenPresent(record::getContacts)
            .set(phone).equalToWhenPresent(record::getPhone)
            .set(address).equalToWhenPresent(record::getAddress)
            .set(details).equalToWhenPresent(record::getDetails)
            .set(score).equalToWhenPresent(record::getScore)
            .set(recommendation).equalToWhenPresent(record::getRecommendation)
            .set(createtime).equalToWhenPresent(record::getCreatetime)
            .set(updatetime).equalToWhenPresent(record::getUpdatetime)
            .set(owner).equalToWhenPresent(record::getOwner)
            .where(id, isEqualTo(record::getId))
        );
    }
}