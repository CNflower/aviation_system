import request from '@/utils/request'

// 查询机票价格列表
export function listPrices(query) {
  return request({
    url: '/aviation/prices/list',
    method: 'get',
    params: query
  })
}

// 查询机票价格详细
export function getPrices(priceId) {
  return request({
    url: '/aviation/prices/' + priceId,
    method: 'get'
  })
}

// 新增机票价格
export function addPrices(data) {
  return request({
    url: '/aviation/prices',
    method: 'post',
    data: data
  })
}

// 修改机票价格
export function updatePrices(data) {
  return request({
    url: '/aviation/prices',
    method: 'put',
    data: data
  })
}

// 删除机票价格
export function delPrices(priceId) {
  return request({
    url: '/aviation/prices/' + priceId,
    method: 'delete'
  })
}
