<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="主航班ID" prop="flightId">
        <el-input
          v-model="queryParams.flightId"
          placeholder="请输入主航班ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="中转机场" prop="transitAircom">
        <el-input
          v-model="queryParams.transitAircom"
          placeholder="请输入中转机场"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="中转城市" prop="transitCity">
        <el-input
          v-model="queryParams.transitCity"
          placeholder="请输入中转城市"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="中转起飞时间" prop="departureTime">
        <el-date-picker clearable
          v-model="queryParams.departureTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择中转起飞时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="中转到达时间" prop="arrivalTime">
        <el-date-picker clearable
          v-model="queryParams.arrivalTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择中转到达时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="中转顺序" prop="transitOrder">
        <el-input
          v-model="queryParams.transitOrder"
          placeholder="请输入中转顺序"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="该段行程的座位数" prop="totalSeats">
        <el-input
          v-model="queryParams.totalSeats"
          placeholder="请输入该段行程的座位数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="该段行程的票价" prop="price">
        <el-input
          v-model="queryParams.price"
          placeholder="请输入该段行程的票价"
          clearable
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['aviation:transit_flights:add']"
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
          v-hasPermi="['aviation:transit_flights:edit']"
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
          v-hasPermi="['aviation:transit_flights:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['aviation:transit_flights:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="transit_flightsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="中转ID" align="center" prop="transitId" />
      <el-table-column label="主航班ID" align="center" prop="flightId" />
      <el-table-column label="中转机场" align="center" prop="transitAircom" />
      <el-table-column label="中转城市" align="center" prop="transitCity" />
      <el-table-column label="中转起飞时间" align="center" prop="departureTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.departureTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="中转到达时间" align="center" prop="arrivalTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.arrivalTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="中转顺序" align="center" prop="transitOrder" />
      <el-table-column label="该段行程的座位数" align="center" prop="totalSeats" />
      <el-table-column label="该段行程的票价" align="center" prop="price" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['aviation:transit_flights:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['aviation:transit_flights:remove']"
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

    <!-- 添加或修改中转航班信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="主航班ID" prop="flightId">
          <el-input v-model="form.flightId" placeholder="请输入主航班ID" />
        </el-form-item>
        <el-form-item label="中转机场" prop="transitAircom">
          <el-input v-model="form.transitAircom" placeholder="请输入中转机场" />
        </el-form-item>
        <el-form-item label="中转城市" prop="transitCity">
          <el-input v-model="form.transitCity" placeholder="请输入中转城市" />
        </el-form-item>
        <el-form-item label="中转起飞时间" prop="departureTime">
          <el-date-picker clearable
            v-model="form.departureTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择中转起飞时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="中转到达时间" prop="arrivalTime">
          <el-date-picker clearable
            v-model="form.arrivalTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择中转到达时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="中转顺序" prop="transitOrder">
          <el-input v-model="form.transitOrder" placeholder="请输入中转顺序" />
        </el-form-item>
        <el-form-item label="该段行程的座位数" prop="totalSeats">
          <el-input v-model="form.totalSeats" placeholder="请输入该段行程的座位数" />
        </el-form-item>
        <el-form-item label="该段行程的票价" prop="price">
          <el-input v-model="form.price" placeholder="请输入该段行程的票价" />
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
import { listTransit_flights, getTransit_flights, delTransit_flights, addTransit_flights, updateTransit_flights } from "@/api/aviation/transit_flights";

export default {
  name: "Transit_flights",
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
      // 中转航班信息表格数据
      transit_flightsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        flightId: null,
        transitAircom: null,
        transitCity: null,
        departureTime: null,
        arrivalTime: null,
        transitOrder: null,
        totalSeats: null,
        price: null,
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
    /** 查询中转航班信息列表 */
    getList() {
      this.loading = true;
      listTransit_flights(this.queryParams).then(response => {
        this.transit_flightsList = response.rows;
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
        transitId: null,
        flightId: null,
        transitAircom: null,
        transitCity: null,
        departureTime: null,
        arrivalTime: null,
        transitOrder: null,
        totalSeats: null,
        price: null,
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
      this.ids = selection.map(item => item.transitId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加中转航班信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const transitId = row.transitId || this.ids
      getTransit_flights(transitId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改中转航班信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.transitId != null) {
            updateTransit_flights(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTransit_flights(this.form).then(response => {
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
      const transitIds = row.transitId || this.ids;
      this.$modal.confirm('是否确认删除中转航班信息编号为"' + transitIds + '"的数据项？').then(function() {
        return delTransit_flights(transitIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('aviation/transit_flights/export', {
        ...this.queryParams
      }, `transit_flights_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
