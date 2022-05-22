package com.inc.admin.service.biz.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.inc.admin.dao.biz.BatchDao;
import com.inc.admin.dao.biz.BatchSql;
import com.inc.admin.domain.biz.Batch;
import com.inc.admin.service.biz.BatchService;
import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectModel;
import org.mybatis.dynamic.sql.util.Buildable;
import org.springframework.stereotype.Service;

@Service("batchService")
public class BatchServiceImpl implements BatchService {
    @Resource
    private BatchDao batchDao;

    /**
     * 分页查询
     */
    @Override
    public PageInfo<Batch> listByPage(Batch req) {
        PageHelper.startPage(req.getPageNo(), req.getPageSize());
        SelectDSLCompleter completer = buildCompleter(req);
        return new PageInfo<>(batchDao.select(completer));
    }

    /**
     * 查询list
     */
    @Override
    public List<Batch> getList(Batch req) {
        return batchDao.select(buildCompleter(req));
    }

    /**
     * 单个查询
     */
    @Override
    public Batch getOne(Batch req) {
        Optional<Batch> batch = batchDao.selectOne(buildCompleter(req));
        return batch.orElse(null);
    }

    /**
     * 新增
     */
    @Override
    public int insert(Batch req) {
        return batchDao.insertSelective(req);
    }


    /**
     * 新增
     */
    @Override
    public int save(Batch req) {
        return batchDao.save(req);
    }
    /**
     * 根据主键更新不为空的值
     */
    @Override
    public int update(Batch req) {
        return batchDao.updateByPrimaryKeySelective(req);
    }

    /**
     * 根据主键删除该记录
     */
    @Override
    public int delete(Integer id) {
        return batchDao.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     */
    private SelectDSLCompleter buildCompleter(Batch req) {
        SelectDSLCompleter completer = new SelectDSLCompleter() {
            @Override
            public Buildable<SelectModel> apply(QueryExpressionDSL<SelectModel> selectModelQueryExpressionDSL) {
                QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder where = selectModelQueryExpressionDSL.where();
                Object id = req.getId();
                if (id != null) {
                    where.and(BatchSql.id, SqlBuilder.isEqualTo(req.getId()));
                }
                Object details = req.getDetails();
                if (details != null) {
                    where.and(BatchSql.details, SqlBuilder.isEqualTo(req.getDetails()));
                }
                Object score = req.getScore();
                if (score != null) {
                    where.and(BatchSql.score, SqlBuilder.isEqualTo(req.getScore()));
                }
                Object recommendation = req.getRecommendation();
                if (recommendation != null) {
                    where.and(BatchSql.recommendation, SqlBuilder.isEqualTo(req.getRecommendation()));
                }
                Object status = req.getStatus();
                if (status != null) {
                    where.and(BatchSql.status, SqlBuilder.isEqualTo(req.getStatus()));
                }
                Object createtime = req.getCreatetime();
                if (createtime != null) {
                    where.and(BatchSql.createtime, SqlBuilder.isEqualTo(req.getCreatetime()));
                }
                Object updatetime = req.getUpdatetime();
                if (updatetime != null) {
                    where.and(BatchSql.updatetime, SqlBuilder.isEqualTo(req.getUpdatetime()));
                }
                Object operator = req.getOperator();
                if (operator != null) {
                    where.and(BatchSql.operator, SqlBuilder.isEqualTo(req.getOperator()));
                }
                return where;
            }
        };
        return completer;
    }
}
