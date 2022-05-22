package com.inc.admin.service.biz;

import com.github.pagehelper.PageInfo;
import com.inc.admin.domain.biz.Book;
import java.util.List;

/**
 * 管理 service
 * @author chenshi
 * @date 2022-05-23 02:04:56
*/
public interface BatchService {
    /**
     * 分页查询
     */
    PageInfo<com.inc.admin.domain.biz.Batch> listByPage(com.inc.admin.domain.biz.Batch req);

    /**
     * 查询列表
     */
    List<com.inc.admin.domain.biz.Batch> getList(com.inc.admin.domain.biz.Batch req);

    /**
     * 单个查询
     */
    com.inc.admin.domain.biz.Batch getOne(com.inc.admin.domain.biz.Batch req);

    /**
     * 新增
     */
    int insert(com.inc.admin.domain.biz.Batch req);

    /**
     * 新增
     */
    int save(com.inc.admin.domain.biz.Batch req);

    /**
     * 根据主键修改
     */
    int update(com.inc.admin.domain.biz.Batch req);

    /**
     * 根据主键删除
     */
    int delete(Integer id);
}
