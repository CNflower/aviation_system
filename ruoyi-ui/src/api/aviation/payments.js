import request from '@/utils/request'

// 查询支付记录列表
export function listPayments(query) {
  return request({
    url: '/aviation/payments/list',
    method: 'get',
    params: query
  })
}

// 查询支付记录详细
export function getPayments(paymentId) {
  return request({
    url: '/aviation/payments/' + paymentId,
    method: 'get'
  })
}

// 新增支付记录
export function addPayments(data) {
  return request({
    url: '/aviation/payments',
    method: 'post',
    data: data
  })
}

// 修改支付记录
export function updatePayments(data) {
  return request({
    url: '/aviation/payments',
    method: 'put',
    data: data
  })
}

// 删除支付记录
export function delPayments(paymentId) {
  return request({
    url: '/aviation/payments/' + paymentId,
    method: 'delete'
  })
}
