package com.inc.admin.controller.biz;

import com.inc.admin.domain.biz.Batch;
import com.inc.admin.service.biz.BatchService;
import com.inc.admin.utils.R;
import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 管理 控制器
 * @author chenshi
 * @date 2022-05-23 02:04:56
*/
@RestController
@RequestMapping("/batch")
public class BatchController {
    @Resource
    private BatchService batchService;

    /**
     * 分页查询 列表
     */
    @PostMapping("/listByPage")
    public R listByPage(@RequestBody Batch req) {
        return R.ok().put("page", batchService.listByPage(req));
    }

    /**
     * 添加 信息
     */
    @PostMapping("/insert")
    public R insert(@RequestBody Batch req) {
        return R.operate(batchService.insert(req)>0);
    }

    /**
     * 更新 信息
     */
    @PostMapping("/update")
    public R update(@RequestBody Batch req) {
        return R.operate(batchService.update(req)>0);
    }

    /**
     * 删除 信息
     */
    @PostMapping("/delete")
    public R delete(@Validated @NotNull(message = "编号不能为空") @RequestParam("id") @RequestBody Integer id) {
        return R.operate(batchService.delete(id)>0);
    }
}