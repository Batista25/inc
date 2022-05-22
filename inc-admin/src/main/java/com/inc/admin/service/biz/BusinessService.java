package com.inc.admin.service.biz;

import com.github.pagehelper.PageInfo;
import com.inc.admin.domain.biz.Book;
import com.inc.admin.domain.biz.Business;

import java.util.List;

/**
 * 管理 service
 * @author chenshi
 * @date 2022-05-21 23:27:04
*/
public interface BusinessService {
    /**
     * 分页查询
     */
    PageInfo<com.inc.admin.domain.biz.Business> listByPage(com.inc.admin.domain.biz.Business req);

    /**
     * 查询列表
     */
    List<com.inc.admin.domain.biz.Business> getList(com.inc.admin.domain.biz.Business req);

    /**
     * 单个查询
     */
    com.inc.admin.domain.biz.Business getOne(com.inc.admin.domain.biz.Business req);

    /**
     * 新增
     */
    int insert(com.inc.admin.domain.biz.Business req);

    /**
     * 根据主键修改
     */
    int update(com.inc.admin.domain.biz.Business req);

    /**
     * 根据主键删除
     */
    int delete(Integer id);

    int upLoad(List<Business> businessList);

    int seize(Integer id);

    PageInfo<Business>  myBusiness(Business req);

    int submit(Integer id);
}
