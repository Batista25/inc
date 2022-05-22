package com.inc.admin.controller.biz;

import com.inc.admin.domain.biz.Business;
import com.inc.admin.service.biz.BusinessService;
import com.inc.admin.utils.R;
import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 管理 控制器
 * @author chenshi
 * @date 2022-05-21 23:27:04
*/
@RestController
@RequestMapping("/business")
public class BusinessController {
    @Resource
    private BusinessService businessService;

    /**
     * 分页查询 列表
     */
    @PostMapping("/listByPage")
    public R listByPage(@RequestBody Business req) {
        return R.ok().put("page", businessService.listByPage(req));
    }

    /**
     * 分页查询 我的商机列表
     */
    @PostMapping("/myBusiness")
    public R myBusiness(@RequestBody Business req) {
        return R.ok().put("page", businessService.myBusiness(req));
    }
    /**
     * 添加 信息
     */
    @PostMapping("/insert")
    public R insert(@RequestBody Business req) {
        return R.operate(businessService.insert(req)>0);
    }

    /**
     * Excel上传
     */
    @PostMapping("/upLoad")
    public R upLoad(@RequestBody List<Business> req) {
        return R.operate(businessService.upLoad(req)>0);
    }

    /**
     * 更新 信息
     */
    @PostMapping("/update")
    public R update(@RequestBody Business req) {
        return R.operate(businessService.update(req)>0);
    }

    /**
     * 抢占商机
     */
    @PostMapping("/seize")
    public R seize(@Validated @NotNull(message = "编号不能为空") @RequestParam("id") @RequestBody Integer id) {
        return R.operate(businessService.seize(id)>0);
    }

    /**
     * 删除 信息
     */
    @PostMapping("/delete")
    public R delete(@Validated @NotNull(message = "编号不能为空") @RequestParam("id") @RequestBody Integer id) {
        return R.operate(businessService.delete(id)>0);
    }
}
