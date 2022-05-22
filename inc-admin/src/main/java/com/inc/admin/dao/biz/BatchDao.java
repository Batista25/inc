package com.inc.admin.dao.biz;

import static com.inc.admin.dao.biz.BatchSql.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.inc.admin.domain.biz.Batch;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.inc.admin.domain.sys.RoleDO;
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
public interface BatchDao {
    BasicColumn[] selectList = BasicColumn.columnList(id, details, score, recommendation, status, createtime, updatetime, operator);

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
    int insert(InsertStatementProvider<Batch> insertStatement);

    /**
     * 批量添加
     * @param multipleInsertStatement
     * @return int
     */
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Batch> multipleInsertStatement);

    /**
     * 查询单条
     * @param selectStatement
     * @return java.util.Optional<com.inc.admin.domain.biz.Batch>
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("BatchResult")
    Optional<Batch> selectOne(SelectStatementProvider selectStatement);

    /**
     * 查询多条
     * @param selectStatement
     * @return java.util.List<com.inc.admin.domain.biz.Batch>
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="BatchResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.OTHER, id=true),
        @Result(column="details", property="details", jdbcType=JdbcType.OTHER),
        @Result(column="score", property="score", jdbcType=JdbcType.OTHER),
        @Result(column="recommendation", property="recommendation", jdbcType=JdbcType.OTHER),
        @Result(column="status", property="status", jdbcType=JdbcType.OTHER),
        @Result(column="createTime", property="createtime", jdbcType=JdbcType.OTHER),
        @Result(column="updateTime", property="updatetime", jdbcType=JdbcType.OTHER),
        @Result(column="operator", property="operator", jdbcType=JdbcType.OTHER)
    })
    List<Batch> selectMany(SelectStatementProvider selectStatement);

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
        return MyBatis3Utils.countFrom(this::count, batch, completer);
    }

    /**
     * 删除
     * @param completer
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, batch, completer);
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
    default int insert(Batch record) {
        return MyBatis3Utils.insert(this::insert, record, batch, c ->
            c.map(id).toProperty("id")
            .map(details).toProperty("details")
            .map(score).toProperty("score")
            .map(recommendation).toProperty("recommendation")
            .map(status).toProperty("status")
            .map(createtime).toProperty("createtime")
            .map(updatetime).toProperty("updatetime")
            .map(operator).toProperty("operator")
        );
    }

    int save(Batch record);

    /**
     * 批量添加
     */
    default int insertMultiple(Collection<Batch> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, batch, c ->
            c.map(id).toProperty("id")
            .map(details).toProperty("details")
            .map(score).toProperty("score")
            .map(recommendation).toProperty("recommendation")
            .map(status).toProperty("status")
            .map(createtime).toProperty("createtime")
            .map(updatetime).toProperty("updatetime")
            .map(operator).toProperty("operator")
        );
    }

    /**
     * 插入值不为空的列
     */
    default int insertSelective(Batch record) {
        return MyBatis3Utils.insert(this::insert, record, batch, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(details).toPropertyWhenPresent("details", record::getDetails)
            .map(score).toPropertyWhenPresent("score", record::getScore)
            .map(recommendation).toPropertyWhenPresent("recommendation", record::getRecommendation)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
            .map(createtime).toPropertyWhenPresent("createtime", record::getCreatetime)
            .map(updatetime).toPropertyWhenPresent("updatetime", record::getUpdatetime)
            .map(operator).toPropertyWhenPresent("operator", record::getOperator)
        );
    }

    /**
     * 查询单条
     * @param completer
     */
    default Optional<Batch> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, batch, completer);
    }

    /**
     * 查询多条
     * @param completer
     */
    default List<Batch> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, batch, completer);
    }

    /**
     * 去重查询
     * @param completer
     */
    default List<Batch> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, batch, completer);
    }

    /**
     * 根据主键查询
     */
    default Optional<Batch> selectByPrimaryKey(Object id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    /**
     * 更新
     * @param completer
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, batch, completer);
    }

    /**
     * 更新所有列
     */
    static UpdateDSL<UpdateModel> updateAllColumns(Batch record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(details).equalTo(record::getDetails)
                .set(score).equalTo(record::getScore)
                .set(recommendation).equalTo(record::getRecommendation)
                .set(status).equalTo(record::getStatus)
                .set(createtime).equalTo(record::getCreatetime)
                .set(updatetime).equalTo(record::getUpdatetime)
                .set(operator).equalTo(record::getOperator);
    }

    /**
     * 更新值不为空的列
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Batch record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(details).equalToWhenPresent(record::getDetails)
                .set(score).equalToWhenPresent(record::getScore)
                .set(recommendation).equalToWhenPresent(record::getRecommendation)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(createtime).equalToWhenPresent(record::getCreatetime)
                .set(updatetime).equalToWhenPresent(record::getUpdatetime)
                .set(operator).equalToWhenPresent(record::getOperator);
    }

    /**
     * 根据主键更新
     */
    default int updateByPrimaryKey(Batch record) {
        return update(c ->
            c.set(details).equalTo(record::getDetails)
            .set(score).equalTo(record::getScore)
            .set(recommendation).equalTo(record::getRecommendation)
            .set(status).equalTo(record::getStatus)
            .set(createtime).equalTo(record::getCreatetime)
            .set(updatetime).equalTo(record::getUpdatetime)
            .set(operator).equalTo(record::getOperator)
            .where(id, isEqualTo(record::getId))
        );
    }

    /**
     * 根据主键更新值不为空的列
     */
    default int updateByPrimaryKeySelective(Batch record) {
        return update(c ->
            c.set(details).equalToWhenPresent(record::getDetails)
            .set(score).equalToWhenPresent(record::getScore)
            .set(recommendation).equalToWhenPresent(record::getRecommendation)
            .set(status).equalToWhenPresent(record::getStatus)
            .set(createtime).equalToWhenPresent(record::getCreatetime)
            .set(updatetime).equalToWhenPresent(record::getUpdatetime)
            .set(operator).equalToWhenPresent(record::getOperator)
            .where(id, isEqualTo(record::getId))
        );
    }
}
