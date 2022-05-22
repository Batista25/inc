import httpClient from '../utils/httpClient';

export default {

  //分页查询
  listByPage: (data,callback) => {
    return httpClient('/business/listByPage', {method:'post',data,}, callback);
  },

  //分页查询
  myBusiness: (data,callback) => {
    return httpClient('/business/myBusiness', {method:'post',data,}, callback);
  },

  //添加
  insert: (data,callback) => {
    return httpClient('/business/insert', {method:'post',data,}, callback);
  },

  //上传
  upLoad: (data,callback) => {
    return httpClient('/business/upLoad', {method:'post',data,}, callback);
  },

  //修改
  update: (data,callback) => {
    return httpClient('/business/update', {method:'post',data,}, callback);
  },

  //修改
  seize: (data,callback) => {
    return httpClient('/business/seize', {method:'post',params:data,}, callback);
  },

  //删除
  delete: (data,callback) => {
    return httpClient('/business/delete', {method:'post',params:data,}, callback);
  },
}
