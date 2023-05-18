package com.rzab.controller;

import com.rzab.pojo.Appoint;
import com.rzab.pojo.Msg;
import com.rzab.service.AppointService;
import com.rzab.service.NoticeService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @author 热着爱吧
 * @create 2021-04-26 9:30
 **/

@Controller
@RequestMapping("/appoint")
public class AppointController {

    @Autowired
    private AppointService appointService;

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/insertAppointNa")
    @ResponseBody
    public Msg insertAppointNa(String appoint_userid, String appoint_username, String appoint_phonenum,
                               String appoint_project) {

        //格式化时间格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Appoint appoint = new Appoint();
        appoint.setAppoint_userid(Integer.parseInt(appoint_userid));
        appoint.setAppoint_username(appoint_username);
        appoint.setAppoint_phonenum(appoint_phonenum);
        appoint.setAppoint_project(appoint_project);
        appoint.setAppoint_time(formatter.format(new Date()));
        appoint.setAppoint_status("预约成功");

        appointService.insertAppoint(appoint);
        //没有限制，直接预约成功
        return Msg.success();
    }

    @RequestMapping("/insertAppointVac")
    @ResponseBody
    public Msg insertAppointVac(String appoint_userid, String appoint_username, String appoint_phonenum,
                                String appoint_project) {
        //格式化时间格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Appoint appoint = new Appoint();
        appoint.setAppoint_userid(Integer.parseInt(appoint_userid));
        appoint.setAppoint_username(appoint_username);
        appoint.setAppoint_phonenum(appoint_phonenum);
        appoint.setAppoint_project(appoint_project);
        appoint.setAppoint_time(formatter.format(new Date()));

        //查找是否有疫苗信息
        if (noticeService.selectVaccine_count() != null) {
            //判断疫苗剩余数量
            if (noticeService.selectVaccine_count().getVaccine_count() > 0) {
                //判断该用户是否预约过
                Appoint appoint1 = appointService.selectAppointById(Integer.parseInt(appoint_userid));
                if (appoint1 == null) {
                    appoint.setAppoint_status("预约成功");
                    appointService.insertAppoint(appoint);

                    //疫苗-1
                    noticeService.updateVaccine_count(noticeService.selectVaccine_count().getNotice_id());

                    //没有限制，直接预约成功
                    return Msg.success();
                } else {
                    appoint.setAppoint_status("预约失败：已预约");
                    appointService.insertAppoint(appoint);
                    return Msg.fail().add("already", '1');
                }
            }
        } else {
            appoint.setAppoint_status("预约失败：暂无接种疫苗");
            appointService.insertAppoint(appoint);
            return Msg.fail().add("already", '0');
        }
        return Msg.fail();
    }

    @RequestMapping("/selectAllAppoint")
    @ResponseBody
    public Msg selectAllAppoint() {
        List<Appoint> appointList = appointService.selectAllAppoint();
        if (!appointList.isEmpty()) {
            return Msg.success().add("appointList", appointList);
        } else return Msg.fail();
    }

    //下载excel
    @RequestMapping("/downloadAllAppoint")
    @ResponseBody
    public String reprotRecord(HttpServletResponse response) throws IOException {
        // 文件名称
        String fileName = URLEncoder.encode("刷卡记录.xlsx", "utf-8");
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
            workBook = downloadAllAppoint();
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
    public HSSFWorkbook downloadAllAppoint() throws IOException {
        ///创建个空白的workbook[name:workbook]
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建个空白的sheet[name:appoint]
        HSSFSheet sheet = workbook.createSheet("appoint");
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
        cell.setCellValue("预约编号");
        cell = row.createCell(1);
        cell.setCellValue("预约用户账号");
        cell = row.createCell(2);
        cell.setCellValue("用户名");
        cell = row.createCell(3);
        cell.setCellValue("手机号");
        cell = row.createCell(4);
        cell.setCellValue("预约项目");
        cell = row.createCell(5);
        cell.setCellValue("预约时间");
        cell = row.createCell(6);
        cell.setCellValue("预约状态");

        //查询所有预约信息
        List<Appoint> appointList = appointService.selectAllAppoint();
        //开始循环

        for (Appoint appoint : appointList) {
            i++;
            row = sheet.createRow(i);
            cell = row.createCell(0);
            cell.setCellValue(appoint.getAppoint_id());
            cell = row.createCell(1);
            cell.setCellValue(appoint.getAppoint_userid());
            cell = row.createCell(2);
            cell.setCellValue(appoint.getAppoint_username());
            cell = row.createCell(3);
            cell.setCellValue(appoint.getAppoint_phonenum());
            cell = row.createCell(4);
            cell.setCellValue(appoint.getAppoint_project());
            cell = row.createCell(5);
            cell.setCellValue(appoint.getAppoint_time());
            cell = row.createCell(6);
            cell.setCellValue(appoint.getAppoint_status());
        }
        System.out.println("orderCondition.xls--[status:success]!");
        return workbook;
    }

}
