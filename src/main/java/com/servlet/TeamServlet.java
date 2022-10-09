package com.servlet;

import com.dao.ProjectReportsDao;
import com.dao.ProjectsDao;
import com.dao.impl.ProjectReportsDaoImpl;
import com.dao.impl.ProjectsDaoImpl;
import com.pojo.Project;
import com.pojo.Project_Report;
import com.pojo.User;
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.FileItemFactory;
//import org.apache.commons.fileupload.FileUploadException;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/team.do")
public class TeamServlet extends UserServlet {
    /**
     * 填写项目报告
     * url /team.do?operate=writeReport
     * 前端需要提供的参数:
     * report 项目报告内容
     * projects_pid 项目id
     */
    public void writeReport(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        User currentUser = getCurrentUser(req.getSession());

        // 从前端获取项目报告
        String reportContent = req.getParameter("report");
        String strPid = req.getParameter("projects_pid");
        ProjectReportsDao projectReportsDao = new ProjectReportsDaoImpl();
        int tid = currentUser.getTeams_tid();
        int pid = Integer.parseInt(strPid);
        Project_Report project_report = projectReportsDao.loadProjectReport(tid, pid);

        int res;
        if (project_report == null) {
            project_report = new Project_Report(tid, pid, reportContent);
            res = projectReportsDao.addProjectReport(project_report);
        } else {
            project_report.setReportContent(reportContent);
            res = projectReportsDao.setProjectReport(project_report);
        }

        if (res == 1) {
            // 前端返回成功
            req.getRequestDispatcher("success.jsp").forward(req, resp);
        } else {
            // 失败，换成弹窗
            System.out.println("[ERROR]修改项目报告失败! 无效的项目或未加入团队");
        }
    }

    /**
     * 上传文件
     * projects_pid 目标项目pid
     */
//    public void uploadFile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if (ServletFileUpload.isMultipartContent(req)) {
//            FileItemFactory fileItemFactory = new DiskFileItemFactory();
//            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
//            try {
//                List<FileItem> list = servletFileUpload.parseRequest(req);
//
//                for (FileItem fileItem : list) {
//                    if (fileItem.isFormField()) {
//                        // 普通表单项
//                    } else {
//                        // 上传的文件
//
//                    }
//                }
//            } catch (FileUploadException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }

    /*
     * 获取该团队所有项目报告
     * 估计没用
     * url /team.do?operate=showAllProjectReports
     */
//    public void showAllProjectReports(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        req.setCharacterEncoding("utf-8");
//        User currentUser = getCurrentUser(req.getSession());
//
//        ProjectReportsDao projectReportsDao = new ProjectReportsDaoImpl();
//        int tid = currentUser.getTeams_tid();
//        List<Project_Report> project_reports = projectReportsDao.getProjectReports(tid);
//
//        if (project_reports != null) {
//            req.setAttribute("project_reports", project_reports);
//            for (Project_Report project_report : project_reports) {
//                System.out.println("[DEBUG]报告信息:" + project_report);
//            }
//            req.getRequestDispatcher("team_display.jsp").forward(req, resp);
//        } else {
//            System.out.println("[ERROR]该团队无项目报告");
//        }
//    }

    /**
     * 显示所有项目
     * url /team.do?operate=showProjects
     */
    public void showProjects(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        User currentUser = getCurrentUser(req.getSession());

        ProjectsDao projectsDao = new ProjectsDaoImpl();
        List<Project> projects = projectsDao.getAllProjects();

        req.setAttribute("projects", projects);
        req.getRequestDispatcher("team_display.jsp").forward(req, resp);
    }

    /**
     * 显示一个项目报告
     * url /team.do?operate=showProjectReport
     * 前端提供的参数:
     * projects_pid 目标project的pid
     */
    public void showProjectReport(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        User currentUser = getCurrentUser(req.getSession());

        String strPid = req.getParameter("projects_pid");
        ProjectReportsDao projectReportsDao = new ProjectReportsDaoImpl();
        int tid = currentUser.getTeams_tid();
        int pid = Integer.parseInt(strPid);
        Project_Report project_report = projectReportsDao.loadProjectReport(tid, pid);

        if (project_report != null) {
            req.setAttribute("project_report", project_report);
            req.getRequestDispatcher("team_display.jsp").forward(req, resp);
            System.out.println("[DEBUG]报告信息: " + project_report);
        } else {
            //失败
            System.out.println("[ERROR]不存在此项目报告");
        }
    }

    /**
     * 暂存项目报告
     * url /team.do?operate=tmpSaveReport
     * 前端提供的参数：
     * projects_pid 目标project的pid
     * content 暂存项目报告的内容
     */
    public void tmpSaveReport(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        User currentUser = getCurrentUser(session);
        int tid = currentUser.getTeams_tid();
        int pid = Integer.parseInt(req.getParameter("projects_pid"));
        String content = req.getParameter("content");
        Map<Integer, String> map;
        map = (Map<Integer, String>) session.getAttribute("tmp_report");
        if (map == null) {
            map = new HashMap<>();
            map.put(pid, content);
            // 讲报告暂存在session中
            session.setAttribute("tmp_report", map);
        } else {
            map.put(pid, content);
        }
        req.getRequestDispatcher("team_display.jsp").forward(req, resp);
    }

    /**
     * 查看暂存的任务报告
     * url /team.do?operate=showTmpReport
     * 前端需要提供的参数:
     * projects_pid 目标project的pid
     */
    public void showTmpReport(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        User currentUser = getCurrentUser(session);
        int pid = Integer.parseInt(req.getParameter("projects_pid"));

        Map<Integer, String> map = (Map<Integer, String>) session.getAttribute("tmp_report");
        String content = null;
        if (map != null) {
            content = map.get(pid);
            if (content != null) {
                System.out.println("[DEBUG]报告内容: " + content);
                req.setAttribute("tmp_content", content);
            }
        }
        if (content == null) {
            System.out.println("[INFO]无暂存报告");
        }
        req.getRequestDispatcher("team_display.jsp").forward(req, resp);
    }
}
