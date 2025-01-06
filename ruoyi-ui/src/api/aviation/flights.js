import request from '@/utils/request'

// 查询航班信息列表
export function listFlights(query) {
  return request({
    url: '/aviation/flights/list',
    method: 'get',
    params: query
  })
}

// 查询航班信息详细
export function getFlights(flightId) {
  return request({
    url: '/aviation/flights/' + flightId,
    method: 'get'
  })
}

// 新增航班信息
export function addFlights(data) {
  return request({
    url: '/aviation/flights',
    method: 'post',
    data: data
  })
}

// 修改航班信息
export function updateFlights(data) {
  return request({
    url: '/aviation/flights',
    method: 'put',
    data: data
  })
}

// 删除航班信息
export function delFlights(flightId) {
  return request({
    url: '/aviation/flights/' + flightId,
    method: 'delete'
  })
}
