<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="航空公司" prop="airlineCompany">
        <el-input
          v-model="queryParams.airlineCompany"
          placeholder="请输入航空公司"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="出发城市" prop="departureCity">
        <el-input
          v-model="queryParams.departureCity"
          placeholder="请输入出发城市"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="到达城市" prop="arrivalCity">
        <el-input
          v-model="queryParams.arrivalCity"
          placeholder="请输入到达城市"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="出发时间" prop="departureTime">
        <el-date-picker clearable
          v-model="queryParams.departureTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择出发时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="到达时间" prop="arrivalTime">
        <el-date-picker clearable
          v-model="queryParams.arrivalTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择到达时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="总座位数" prop="totalSeats">
        <el-input
          v-model="queryParams.totalSeats"
          placeholder="请输入总座位数"
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
          v-hasPermi="['aviation:flights:add']"
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
          v-hasPermi="['aviation:flights:edit']"
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
          v-hasPermi="['aviation:flights:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['aviation:flights:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="flightsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="航班号" align="center" prop="flightId" />
      <el-table-column label="航空公司" align="center" prop="airlineCompany" />
      <el-table-column label="出发城市" align="center" prop="departureCity" />
      <el-table-column label="到达城市" align="center" prop="arrivalCity" />
      <el-table-column label="出发时间" align="center" prop="departureTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.departureTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="到达时间" align="center" prop="arrivalTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.arrivalTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="飞机型号" align="center" prop="aircraftType" />
      <el-table-column label="总座位数" align="center" prop="totalSeats" />
      <el-table-column label="航班状态" align="center" prop="status" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['aviation:flights:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['aviation:flights:remove']"
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

    <!-- 添加或修改航班信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="航空公司" prop="airlineCompany">
          <el-input v-model="form.airlineCompany" placeholder="请输入航空公司" />
        </el-form-item>
        <el-form-item label="出发城市" prop="departureCity">
          <el-input v-model="form.departureCity" placeholder="请输入出发城市" />
        </el-form-item>
        <el-form-item label="到达城市" prop="arrivalCity">
          <el-input v-model="form.arrivalCity" placeholder="请输入到达城市" />
        </el-form-item>
        <el-form-item label="出发时间" prop="departureTime">
          <el-date-picker clearable
            v-model="form.departureTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择出发时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="到达时间" prop="arrivalTime">
          <el-date-picker clearable
            v-model="form.arrivalTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择到达时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="总座位数" prop="totalSeats">
          <el-input v-model="form.totalSeats" placeholder="请输入总座位数" />
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
import { listFlights, getFlights, delFlights, addFlights, updateFlights } from "@/api/aviation/flights";

export default {
  name: "Flights",
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
      // 航班信息表格数据
      flightsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        airlineCompany: null,
        departureCity: null,
        arrivalCity: null,
        departureTime: null,
        arrivalTime: null,
        aircraftType: null,
        totalSeats: null,
        status: null,
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
    /** 查询航班信息列表 */
    getList() {
      this.loading = true;
      listFlights(this.queryParams).then(response => {
        this.flightsList = response.rows;
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
        flightId: null,
        airlineCompany: null,
        departureCity: null,
        arrivalCity: null,
        departureTime: null,
        arrivalTime: null,
        aircraftType: null,
        totalSeats: null,
        status: null,
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
      this.ids = selection.map(item => item.flightId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加航班信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const flightId = row.flightId || this.ids
      getFlights(flightId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改航班信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.flightId != null) {
            updateFlights(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addFlights(this.form).then(response => {
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
      const flightIds = row.flightId || this.ids;
      this.$modal.confirm('是否确认删除航班信息编号为"' + flightIds + '"的数据项？').then(function() {
        return delFlights(flightIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('aviation/flights/export', {
        ...this.queryParams
      }, `flights_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
