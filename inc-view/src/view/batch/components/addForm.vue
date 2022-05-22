<template>
  <span>
    <el-button :type="type" :size="size" :icon="icon" @click="showAddDialog">{{title}}</el-button>
    <el-col :span="24" class="warp-main" v-loading="loading" element-loading-text="拼命加载中">
      <!--新增界面-->
      <el-dialog :title="title" :visible.sync="addFormVisible" :close-on-click-modal="false">
        <el-form :model="data" label-width="80px" :rules="addFormRules" ref="addForm">
          <el-form-item label="批次详情" prop="details">
            <el-input size="mini" v-model="data.details" auto-complete="off"></el-input>
          </el-form-item>
          <el-form-item label="综合评分" prop="score">
            <el-input size="mini" v-model="data.score" auto-complete="off"></el-input>
          </el-form-item>
          <el-form-item label="推荐指数" prop="recommendation">
            <el-input size="mini" v-model="data.recommendation" auto-complete="off"></el-input>
          </el-form-item>
          <el-form-item label="状态" prop="status">
            <el-input size="mini" v-model="data.status" auto-complete="off"></el-input>
          </el-form-item>
          <el-form-item label="创建时间" prop="createtime">
            <el-input size="mini" v-model="data.createtime" auto-complete="off"></el-input>
          </el-form-item>
          <el-form-item label="更新时间" prop="updatetime">
            <el-input size="mini" v-model="data.updatetime" auto-complete="off"></el-input>
          </el-form-item>
          <el-form-item label="操作人" prop="operator">
            <el-input size="mini" v-model="data.operator" auto-complete="off"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click.native="addFormVisible = false">取消</el-button>
          <el-button type="primary" :loading="loading" @click.native="addSubmit">提交</el-button>
        </div>
      </el-dialog>
    </el-col>
  </span>
</template>
<script>
  import api from '@/api/apiBatch';

  export default {
    //属性，父组件传参
    props: {
      //按钮图标
      icon:{
        type: String,
        default: ''
      },
      //按钮类型
      type:{
        type: String,
        default: ''
      },
      //按钮大小
      size:{
        type: String,
        default: ''
      },
      //编辑的参数
      data:{
        type: Object,
        default() {
          return {};
        }
      },
      //执行成功回调
      call:{
        type: Function,
        default:function (){}
      },
      //按钮、表单标题
      title:{
        type: String,
        default: '新增'
      }
    },
    data() {
      return {
        loading: false,
        //新增相关数据
        addFormVisible: false,//新增界面是否显示
        addFormRules: {
          details: [
            {required: true, message: '请输入批次详情', trigger: 'blur'}
          ],
          score: [
            {required: true, message: '请输入综合评分', trigger: 'blur'}
          ],
          recommendation: [
            {required: true, message: '请输入推荐指数', trigger: 'blur'}
          ],
          status: [
            {required: true, message: '请输入状态', trigger: 'blur'}
          ],
          createtime: [
            {required: true, message: '请输入创建时间', trigger: 'blur'}
          ],
          updatetime: [
            {required: true, message: '请输入更新时间', trigger: 'blur'}
          ],
          operator: [
            {required: true, message: '请输入操作人', trigger: 'blur'}
          ],
        },

      }
    },
    methods: {
      showAddDialog: function () {
        this.addFormVisible = true;
      },
      //新增
      addSubmit: function () {
        let that = this;
        this.$refs. addForm.validate((valid) => {
          if (valid) {
            that.loading = true;
            let params = Object.assign({}, this.data);
            if (params.id) {
              //编辑
              api.update(params, (result) => {
                that.loading = false;
                if (result && result.code == '0') {
                  that.$message.success({showClose: true, message: '修改成功', duration: 2000});
                  that.$refs['addForm'].resetFields();
                  that.addFormVisible = false;
                  that.call();
                } else {
                  that.$message. error({showClose: true, message: result.msg, duration: 2000});
                }
              });
            } else {
              //新增
              api.insert(params, (result) => {
                that.loading = false;
                if (result && result.code == '0') {
                  that.$message.success({showClose: true, message: '新增成功', duration: 2000});
                  that.$refs['addForm'].resetFields();
                  that.addFormVisible = false;
                  that.call();
                } else {
                  that.$message. error({showClose: true, message: result.msg, duration: 2000});
                }
              });
            }
          }
        });
      },
    },
    mounted() {
    }
  }
</script>

