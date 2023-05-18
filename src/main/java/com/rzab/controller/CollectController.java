package com.rzab.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rzab.pojo.Appoint;
import com.rzab.pojo.Collect;
import com.rzab.pojo.Msg;
import com.rzab.service.CollectService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author 热着爱吧
 * @create 2021-05-09 9:02
 **/

@Controller
@RequestMapping("/collect")
public class CollectController {

    @Autowired
    private CollectService collectService;

    @RequestMapping("/selectPreCollect")
    @ResponseBody
    public Msg selectPreCollect() {
        List<Collect> collectList = collectService.selectPreCollect();
        if (!collectList.isEmpty()) {
            Collect collect = collectList.get(0);
            return Msg.success().add("collect", collect);
        } else return Msg.fail();
    }


    @RequestMapping("/insertCollect")
    @ResponseBody
    public Msg insertCollect(String id, String name, String sex, String class_grade, String idcard_number,
                             String phone_number, String parent_phone_number, String dormitory,
                             String home_loc, String traveling_loc) {

        Collect collect = new Collect(Integer.parseInt(id), name, sex, class_grade, idcard_number, phone_number, parent_phone_number, dormitory, home_loc, traveling_loc);
        collectService.insertCollect(collect);
        return Msg.success();
    }


    @RequestMapping("/selectAllCollect")
    @ResponseBody
    public Msg selectAllCollect(@RequestParam(required = true, defaultValue = "1") Integer page) {
        //page：当前页
        PageHelper.startPage(page, 10);
        List<Collect> collectList = collectService.selectAllCollect();
        if (!collectList.isEmpty()) {
            //将收集list封装为收集页list
            PageInfo<Collect> collectPageInfo = new PageInfo<>(collectList);
            return Msg.success().add("collectPageInfo", collectPageInfo);
        } else return Msg.fail();
    }


    //下载全部excel
    @RequestMapping("/downloadAllCollect")
    @ResponseBody
    public String downloadAllCollect(HttpServletResponse response) throws IOException {
        // 文件名称
        String fileName = URLEncoder.encode("全部收集项目.xlsx", "utf-8");
        // 通过response设置Content-Type、Content-Disposition
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition",
                "attachment;filename*=utf-8'zh_cn'" + fileName);

        //生成workBook
        //	HSSFWorkbook workbook = createWorkbook();
        OutputStream outputStream = null;
        HSSFWorkbook workBook = null;

        try {
            // 获取输出流
            outputStream = response.getOutputStream();
            // 生成workBook
            workBook = downloadAll_Collect();
            workBook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭
            if (outputStream != null) {
                outputStream.close();
            }
        }
        return null;
    }

    //下载上一次excel
    @RequestMapping("/downloadPreCollect")
    @ResponseBody
    public String downloadPreCollect(HttpServletResponse response) throws IOException {
        // 文件名称
        String fileName = URLEncoder.encode("上一次收集项目.xlsx", "utf-8");
        // 通过response设置Content-Type、Content-Disposition
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition",
                "attachment;filename*=utf-8'zh_cn'" + fileName);

        //生成workBook
        //	HSSFWorkbook workbook = createWorkbook();
        OutputStream outputStream = null;
        HSSFWorkbook workBook = null;

        try {
            // 获取输出流
            outputStream = response.getOutputStream();
            // 生成workBook
            workBook = downloadPre_Collect();
            workBook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭
            if (outputStream != null) {
                outputStream.close();
            }
        }
        return null;
    }
    public HSSFWorkbook downloadAll_Collect() throws IOException {
        ///创建个空白的workbook[name:workbook]
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建个空白的sheet[name:appoint]
        HSSFSheet sheet = workbook.createSheet("collect");
        //行
        HSSFRow row;
        //单元格
        HSSFCell cell;
        //创建行循环标签
        int i = 0;
        //创建行
        row = sheet.createRow(i);
        //列名标柱
        cell = row.createCell(0);
        cell.setCellValue("编号项目");
        cell = row.createCell(1);
        cell.setCellValue("姓名");
        cell = row.createCell(2);
        cell.setCellValue("性别");
        cell = row.createCell(3);
        cell.setCellValue("班级");
        cell = row.createCell(4);
        cell.setCellValue("身份证号码");
        cell = row.createCell(5);
        cell.setCellValue("手机号");
        cell = row.createCell(6);
        cell.setCellValue("父母手机号");
        cell = row.createCell(7);
        cell.setCellValue("宿舍号");
        cell = row.createCell(8);
        cell.setCellValue("家庭住址");
        cell = row.createCell(9);
        cell.setCellValue("旅行史");
        //查询所有预约信息
        List<Collect> collectList = collectService.selectAllCollect();
        //开始循环

        for (Collect collect : collectList) {
            i++;
            row = sheet.createRow(i);
            cell = row.createCell(0);
            cell.setCellValue(collect.getId());
            cell = row.createCell(1);
            cell.setCellValue(collect.getName());
            cell = row.createCell(2);
            cell.setCellValue(collect.getSex());
            cell = row.createCell(3);
            cell.setCellValue(collect.getClass_grade());
            cell = row.createCell(4);
            cell.setCellValue(collect.getIdcard_number());
            cell = row.createCell(5);
            cell.setCellValue(collect.getPhone_number());
            cell = row.createCell(6);
            cell.setCellValue(collect.getParent_phone_number());
            cell = row.createCell(7);
            cell.setCellValue(collect.getDormitory());
            cell = row.createCell(8);
            cell.setCellValue(collect.getHome_loc());
            cell = row.createCell(9);
            cell.setCellValue(collect.getTraveling_loc());
        }
        System.out.println("collect.xlsx--[status:success]!");
        return workbook;
    }

    public HSSFWorkbook downloadPre_Collect() throws IOException {
        ///创建个空白的workbook[name:workbook]
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建个空白的sheet[name:appoint]
        HSSFSheet sheet = workbook.createSheet("collect");
        //行
        HSSFRow row;
        //单元格
        HSSFCell cell;
        //创建行循环标签
        int i = 0;
        //创建行
        row = sheet.createRow(i);
        //列名标柱
        cell = row.createCell(0);
        cell.setCellValue("编号项目");
        cell = row.createCell(1);
        cell.setCellValue("姓名");
        cell = row.createCell(2);
        cell.setCellValue("性别");
        cell = row.createCell(3);
        cell.setCellValue("班级");
        cell = row.createCell(4);
        cell.setCellValue("身份证号码");
        cell = row.createCell(5);
        cell.setCellValue("手机号");
        cell = row.createCell(6);
        cell.setCellValue("父母手机号");
        cell = row.createCell(7);
        cell.setCellValue("宿舍号");
        cell = row.createCell(8);
        cell.setCellValue("家庭住址");
        cell = row.createCell(9);
        cell.setCellValue("旅行史");
        //查询所有预约信息
        List<Collect> collectList = collectService.selectPreCollect();
        //开始循环

        for (Collect collect : collectList) {
            i++;
            row = sheet.createRow(i);
            cell = row.createCell(0);
            cell.setCellValue(collect.getId());
            cell = row.createCell(1);
            cell.setCellValue(collect.getName());
            cell = row.createCell(2);
            cell.setCellValue(collect.getSex());
            cell = row.createCell(3);
            cell.setCellValue(collect.getClass_grade());
            cell = row.createCell(4);
            cell.setCellValue(collect.getIdcard_number());
            cell = row.createCell(5);
            cell.setCellValue(collect.getPhone_number());
            cell = row.createCell(6);
            cell.setCellValue(collect.getParent_phone_number());
            cell = row.createCell(7);
            cell.setCellValue(collect.getDormitory());
            cell = row.createCell(8);
            cell.setCellValue(collect.getHome_loc());
            cell = row.createCell(9);
            cell.setCellValue(collect.getTraveling_loc());
        }
        System.out.println("collect.xlsx--[status:success]!");
        return workbook;
    }
}
