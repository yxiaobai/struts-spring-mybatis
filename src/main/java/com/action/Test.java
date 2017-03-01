package com.action;

import com.entity.mapper.StudentMapper;
import lombok.Data;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Component("aaaa")
@Data
public class Test {
    private int id;
    public void execute() throws IOException {
        HttpServletResponse resp = ServletActionContext.getResponse();
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print("<!DOCTYPE html>");
        out.print("\n<html lang=\"zh\">");
        out.print("\n<head>\n<meta charset=\"utf-8\">\n<title>webrx</title>\n<body>");
        out.print("\n<h1>hello-struts2.5.10-中文</h1>");
        out.print("\n</body>");
        out.print("\n</html>");
        out.flush();
        out.close();
    }
    @Autowired  //自动注入spring ioc 中的 studentMapper
    private StudentMapper studentMapper;
    public String show(){
        /*
        List<Student> sts = studentMapper.query();
        for(Student s : sts){
            System.out.println(s.getName());
            System.out.println(s.getAddress());
        }
        System.out.println("show....................");
        */
        ServletActionContext.getContext().put("sts",studentMapper.query());
        return "success";
    }
    public String delete(){
        studentMapper.delById(id);
        return "success";
    }
}
