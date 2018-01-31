package cc.whe.school.controller;

import cc.whe.school.pojo.Student;
import cc.whe.school.service.StudentService;
import cc.whe.school.utils.DataImportAndExport;
import cc.whe.school.utils.XmlParse;
import com.alibaba.fastjson.JSON;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

@Controller
@RequestMapping("/")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 查询
     * @param student
     * @return
     */
    @RequestMapping(value = {"/","find"})
    public ModelAndView find(Student student,Model model, @RequestParam(name = "selects", required = false) String name,@RequestParam(name = "sreach" , required = false)  String sreach) throws Exception {
        if(name!=null){
            String newName=name.replaceFirst(name.substring(0, 1), name.substring(0, 1)
                    .toUpperCase());
            Type type = student.getClass().getDeclaredField(name).getType();
            Method m = student.getClass().getMethod("set"+newName,Class.forName(type.getTypeName()));
            if (type.getTypeName().equals("java.lang.String"))
            {
                // 调用setter方法获取属性值
                m.invoke(student,sreach);
            }
        }
        ModelAndView mav =new ModelAndView();
        mav.addObject("StudentList", studentService.findByCondition(student));
        mav.setViewName("home");
        return mav;
    }

    /**
     * 更新或保存
     * @param student
     * @return
     */
    @RequestMapping("addOrUpdate")
    public String addOrUpdate(Student student){
        if(student.getId()!=null && student.getId()!=0){
            studentService.update(student);
        }else {
            studentService.add(student);
        }
        return "redirect:find";
    }

    /**
     * 页面跳转
     * @param id
     * @return
     */
    @RequestMapping("edit")
    public ModelAndView edit(Integer id){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("edit");
        if(id!=null&&id!=0){
            mav.addObject("student",studentService.get(id));
        }
        return mav;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("delete")
    public String delete(Integer id){
        studentService.delete(id);
        return "redirect:find";
    }
    // 导出
    @RequestMapping("/download")
    public void download(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<Student> page = studentService.findByCondition(null);
        String[] titles = {"学生编号", "学生姓名", "是否在校", "最高学历编码", "最高学历名称", "高考部分", "院校", "专业", "年级", "班级"};
        HSSFWorkbook work = DataImportAndExport._export(page, titles);
        //web浏览通过MIME类型判断文件是excel类型
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        // 对文件名进行处理。防止文件名乱码
        String fileName = "student-info.xls";
        // Content-disposition属性设置成以附件方式进行下载
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        OutputStream os = response.getOutputStream();
        work.write(os);
        os.flush();
        os.close();
    }
    @ResponseBody
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload( @RequestParam("file") MultipartFile file){
        try {
           List<Student> list=  XmlParse.parse(file.getInputStream(),Student.class);
           studentService.addList(list);
        }catch (Exception e){
            e.printStackTrace();
        }
        List<Student> list = studentService.findByCondition(null);
        return JSON.toJSONString(list);
    }
}
