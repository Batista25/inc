package com.inc.admin.service.biz.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.inc.admin.context.FilterContextHandler;
import com.inc.admin.dao.biz.BusinessDao;
import com.inc.admin.dao.biz.BusinessSql;
import com.inc.admin.domain.biz.Business;
import com.inc.admin.service.biz.BusinessService;

import java.util.Date;
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

@Service("businessService")
public class BusinessServiceImpl implements BusinessService {
    @Resource
    private BusinessDao businessDao;

    /**
     * 分页查询
     */
    @Override
    public PageInfo<Business> listByPage(Business req) {
        PageHelper.startPage(req.getPageNo(), req.getPageSize());
        SelectDSLCompleter completer = buildCompleter(req);
        return new PageInfo<>(businessDao.select(completer));
    }

    /**
     * 查询list
     */
    @Override
    public List<Business> getList(Business req) {
        return businessDao.select(buildCompleter(req));
    }

    /**
     * 单个查询
     */
    @Override
    public Business getOne(Business req) {
        Optional<Business> business = businessDao.selectOne(buildCompleter(req));
        return business.orElse(null);
    }

    /**
     * 新增
     */
    @Override
    public int insert(Business req) {
        req.setCreatetime(new Date());
        return businessDao.insertSelective(req);
    }

    /**
     * 根据主键更新不为空的值
     */
    @Override
    public int update(Business req) {
        return businessDao.updateByPrimaryKeySelective(req);
    }

    /**
     * 根据主键删除该记录
     */
    @Override
    public int delete(Integer id) {
        return businessDao.deleteByPrimaryKey(id);
    }

    @Override
    public int upLoad(List<Business> businessList) {
        int n =0 ;
        for (Business business : businessList) {
            insert(business);
            n++;
        }
        return n;
    }

    @Override
    public int seize(Integer id) {
        Business business = new Business();
        business.setId(id);
        business.setOwner(Integer.parseInt(FilterContextHandler.getUserID()));
        return update(business);
    }

    @Override
    public PageInfo<Business> myBusiness(Business req) {
        PageHelper.startPage(req.getPageNo(), req.getPageSize());
        req.setOwner(Integer.parseInt(FilterContextHandler.getUserID()));
        SelectDSLCompleter completer = buildCompleter(req);
        return new PageInfo<>(businessDao.select(completer));
    }

    /**
     * 构建查询条件
     */
    private SelectDSLCompleter buildCompleter(Business req) {
        SelectDSLCompleter completer = new SelectDSLCompleter() {
            @Override
            public Buildable<SelectModel> apply(QueryExpressionDSL<SelectModel> selectModelQueryExpressionDSL) {
                QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder where = selectModelQueryExpressionDSL.where();
                Object id = req.getId();
                if (id.toString().length() > 0) {
                    where.and(BusinessSql.id, SqlBuilder.isEqualTo(req.getId()));
                }
                Object batchid = req.getBatchid();
                if (batchid != null) {
                    where.and(BusinessSql.batchid, SqlBuilder.isEqualTo(req.getBatchid()));
                }
                Object type = req.getType();
                if (type != null) {
                    where.and(BusinessSql.type, SqlBuilder.isEqualTo(req.getType()));
                }
                Object customer = req.getCustomer();
                if (customer != null) {
                    where.and(BusinessSql.customer, SqlBuilder.isEqualTo(req.getCustomer()));
                }
                Object stock = req.getStock();
                if (stock != null) {
                    where.and(BusinessSql.stock, SqlBuilder.isEqualTo(req.getStock()));
                }
                Object contacts = req.getContacts();
                if (contacts != null) {
                    where.and(BusinessSql.contacts, SqlBuilder.isEqualTo(req.getContacts()));
                }
                Object phone = req.getPhone();
                if (phone != null) {
                    where.and(BusinessSql.phone, SqlBuilder.isEqualTo(req.getPhone()));
                }
                Object address = req.getAddress();
                if (address != null) {
                    where.and(BusinessSql.address, SqlBuilder.isEqualTo(req.getAddress()));
                }
                Object details = req.getDetails();
                if (details != null) {
                    where.and(BusinessSql.details, SqlBuilder.isEqualTo(req.getDetails()));
                }
                Object score = req.getScore();
                if (score != null) {
                    where.and(BusinessSql.score, SqlBuilder.isEqualTo(req.getScore()));
                }
                Object recommendation = req.getRecommendation();
                if (recommendation != null) {
                    where.and(BusinessSql.recommendation, SqlBuilder.isEqualTo(req.getRecommendation()));
                }
                Object createtime = req.getCreatetime();
                if (createtime != null) {
                    where.and(BusinessSql.createtime, SqlBuilder.isEqualTo(req.getCreatetime()));
                }
                Object updatetime = req.getUpdatetime();
                if (updatetime != null) {
                    where.and(BusinessSql.updatetime, SqlBuilder.isEqualTo(req.getUpdatetime()));
                }
                Object owner = req.getOwner();
                if (owner != null) {
                    where.and(BusinessSql.owner, SqlBuilder.isEqualTo(req.getOwner()));
                }
                return where;
            }
        };
        return completer;
    }
}
