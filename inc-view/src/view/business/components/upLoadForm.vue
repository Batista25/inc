<template>
  <div>
    <ele-import
      :append="append"
      :fields="fields"
      :filepath="filepath"
      :formatter="formatter"
      :requestFn="requestFn"
      :rules="rules"
      :tips="tips"
      :title="title"
      :visible.sync="visible"
      @close="handleCloseImport"
      @finish="handleFinishImport"
    />
    <el-button
      @click="handleOpen"
      type="primary"
    >点我打开</el-button>
    <div>{{tableData}}</div>
  </div>
</template>

<script>
  import api from '@/api/apiBusiness';
  export default {
    name: 'App',
    data () {
      return {
        title: '导入商机',
        tips: ['仅支持Excel文件导入', '模式必填（当前仅支持抢单模式）'],
        fields: {
          type: '商机类型（存款、贷款、开户）',
          customer: '客户',
          stock: '是否存量客户（1-是，0-否）',
          contacts: '联系人',
          phone: '联系电话',
          address: '地址',
          details: '商机详情',
          score: '综合评分',
          recommendation: '推荐指数',
          owner: '跟进人'
    },
        // append: {
        //   company: '民生银行天津分行',
        //   leader: '陈实'
        // },
        // formatter: {
        //   city: {
        //     1: '深圳',
        //     2: '广州'
        //   },
        //   age: function (value, row) {
        //     return value + 1
        //   }
        // },
        // rules: {
        //   name: { type: 'string', required: true, message: '名字必填' },
        //   age: [
        //     { type: 'number', message: '年龄必须为数字' },
        //     { required: true, message: '年龄必须填写' }
        //   ]
        // },
        filepath: 'https://raw.githubusercontent.com/dream2023/vue-ele-import/master/public/user.xlsx',
        visible: false,
        tableData: ''
      }
    },
    methods: {
      async requestFn (data) {
        this.tableData = JSON.stringify(data)
        this.upLoad(data)
        console.log(data)
        // eslint-disable-next-line
        // return Promise.reject({ 1: { age: '名字错了' } })
        return Promise.resolve()
      },
      handleCloseImport () {
        console.log('弹窗关闭了~')
      },
      handleFinishImport () {
        console.log('导入完毕了~')
      },
      handleOpen () {
        this.visible = true
      },
      //新增
      upLoad: function (data) {
        let params = Object.assign([], data);
        //新增
        api.upLoad(params, (result) => {

        })
      },
    },
    mounted () {}
  }
</script>
