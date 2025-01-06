import request from '@/utils/request'

// 查询退票记录列表
export function listRefunds(query) {
  return request({
    url: '/aviation/refunds/list',
    method: 'get',
    params: query
  })
}

// 查询退票记录详细
export function getRefunds(refundId) {
  return request({
    url: '/aviation/refunds/' + refundId,
    method: 'get'
  })
}

// 新增退票记录
export function addRefunds(data) {
  return request({
    url: '/aviation/refunds',
    method: 'post',
    data: data
  })
}

// 修改退票记录
export function updateRefunds(data) {
  return request({
    url: '/aviation/refunds',
    method: 'put',
    data: data
  })
}

// 删除退票记录
export function delRefunds(refundId) {
  return request({
    url: '/aviation/refunds/' + refundId,
    method: 'delete'
  })
}
