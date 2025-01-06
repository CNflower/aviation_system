import request from '@/utils/request'

// 查询乘客信息列表
export function listUser(query) {
  return request({
    url: '/aviation/user/list',
    method: 'get',
    params: query
  })
}

// 查询乘客信息详细
export function getUser(userId) {
  return request({
    url: '/aviation/user/' + userId,
    method: 'get'
  })
}

// 新增乘客信息
export function addUser(data) {
  return request({
    url: '/aviation/user',
    method: 'post',
    data: data
  })
}

// 修改乘客信息
export function updateUser(data) {
  return request({
    url: '/aviation/user',
    method: 'put',
    data: data
  })
}

// 删除乘客信息
export function delUser(userId) {
  return request({
    url: '/aviation/user/' + userId,
    method: 'delete'
  })
}
