<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="乘客ID" prop="passengerId">
        <el-input
          v-model="queryParams.passengerId"
          placeholder="请输入乘客ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="航班号" prop="flightId">
        <el-input
          v-model="queryParams.flightId"
          placeholder="请输入航班号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="中转航班号" prop="transitId">
        <el-input
          v-model="queryParams.transitId"
          placeholder="请输入中转航班号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="价格ID" prop="priceId">
        <el-input
          v-model="queryParams.priceId"
          placeholder="请输入价格ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="座位号" prop="seatNumber">
        <el-input
          v-model="queryParams.seatNumber"
          placeholder="请输入座位号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="下单时间" prop="orderTime">
        <el-date-picker clearable
          v-model="queryParams.orderTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择下单时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="支付时间" prop="paymentTime">
        <el-date-picker clearable
          v-model="queryParams.paymentTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择支付时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="订单总额" prop="totalAmount">
        <el-input
          v-model="queryParams.totalAmount"
          placeholder="请输入订单总额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="支付宝交易号" prop="alino">
        <el-input
          v-model="queryParams.alino"
          placeholder="请输入支付宝交易号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="记录创建时间" prop="createdTime">
        <el-date-picker clearable
          v-model="queryParams.createdTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择记录创建时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="记录更新时间" prop="updatedTime">
        <el-date-picker clearable
          v-model="queryParams.updatedTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择记录更新时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['aviation:orders:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['aviation:orders:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['aviation:orders:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['aviation:orders:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="ordersList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="订单号" align="center" prop="orderId" />
      <el-table-column label="乘客ID" align="center" prop="passengerId" />
      <el-table-column label="航班号" align="center" prop="flightId" />
      <el-table-column label="中转航班号" align="center" prop="transitId" />
      <el-table-column label="价格ID" align="center" prop="priceId" />
      <el-table-column label="座位号" align="center" prop="seatNumber" />
      <el-table-column label="订单状态" align="center" prop="orderStatus" />
      <el-table-column label="下单时间" align="center" prop="orderTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.orderTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="支付时间" align="center" prop="paymentTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.paymentTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="订单总额" align="center" prop="totalAmount" />
      <el-table-column label="支付宝交易号" align="center" prop="alino" />
      <el-table-column label="记录创建时间" align="center" prop="createdTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createdTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="记录更新时间" align="center" prop="updatedTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updatedTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['aviation:orders:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['aviation:orders:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改订单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="乘客ID" prop="passengerId">
          <el-input v-model="form.passengerId" placeholder="请输入乘客ID" />
        </el-form-item>
        <el-form-item label="航班号" prop="flightId">
          <el-input v-model="form.flightId" placeholder="请输入航班号" />
        </el-form-item>
        <el-form-item label="中转航班号" prop="transitId">
          <el-input v-model="form.transitId" placeholder="请输入中转航班号" />
        </el-form-item>
        <el-form-item label="价格ID" prop="priceId">
          <el-input v-model="form.priceId" placeholder="请输入价格ID" />
        </el-form-item>
        <el-form-item label="座位号" prop="seatNumber">
          <el-input v-model="form.seatNumber" placeholder="请输入座位号" />
        </el-form-item>
        <el-form-item label="下单时间" prop="orderTime">
          <el-date-picker clearable
            v-model="form.orderTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择下单时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="支付时间" prop="paymentTime">
          <el-date-picker clearable
            v-model="form.paymentTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择支付时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="订单总额" prop="totalAmount">
          <el-input v-model="form.totalAmount" placeholder="请输入订单总额" />
        </el-form-item>
        <el-form-item label="支付宝交易号" prop="alino">
          <el-input v-model="form.alino" placeholder="请输入支付宝交易号" />
        </el-form-item>
        <el-form-item label="记录创建时间" prop="createdTime">
          <el-date-picker clearable
            v-model="form.createdTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择记录创建时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="记录更新时间" prop="updatedTime">
          <el-date-picker clearable
            v-model="form.updatedTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择记录更新时间">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listOrders, getOrders, delOrders, addOrders, updateOrders } from "@/api/aviation/orders";

export default {
  name: "Orders",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 订单表格数据
      ordersList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        passengerId: null,
        flightId: null,
        transitId: null,
        priceId: null,
        seatNumber: null,
        orderStatus: null,
        orderTime: null,
        paymentTime: null,
        totalAmount: null,
        alino: null,
        createdTime: null,
        updatedTime: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询订单列表 */
    getList() {
      this.loading = true;
      listOrders(this.queryParams).then(response => {
        this.ordersList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        orderId: null,
        passengerId: null,
        flightId: null,
        transitId: null,
        priceId: null,
        seatNumber: null,
        orderStatus: null,
        orderTime: null,
        paymentTime: null,
        totalAmount: null,
        alino: null,
        createdTime: null,
        updatedTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.orderId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加订单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const orderId = row.orderId || this.ids
      getOrders(orderId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改订单";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.orderId != null) {
            updateOrders(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addOrders(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const orderIds = row.orderId || this.ids;
      this.$modal.confirm('是否确认删除订单编号为"' + orderIds + '"的数据项？').then(function() {
        return delOrders(orderIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('aviation/orders/export', {
        ...this.queryParams
      }, `orders_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
