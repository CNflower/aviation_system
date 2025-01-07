import request from '@/utils/request'

// 查询中转航班信息列表
export function listTransit_flights(query) {
  return request({
    url: '/aviation/transit_flights/list',
    method: 'get',
    params: query
  })
}

// 查询中转航班信息详细
export function getTransit_flights(transitId) {
  return request({
    url: '/aviation/transit_flights/' + transitId,
    method: 'get'
  })
}

// 新增中转航班信息
export function addTransit_flights(data) {
  return request({
    url: '/aviation/transit_flights',
    method: 'post',
    data: data
  })
}

// 修改中转航班信息
export function updateTransit_flights(data) {
  return request({
    url: '/aviation/transit_flights',
    method: 'put',
    data: data
  })
}

// 删除中转航班信息
export function delTransit_flights(transitId) {
  return request({
    url: '/aviation/transit_flights/' + transitId,
    method: 'delete'
  })
}
