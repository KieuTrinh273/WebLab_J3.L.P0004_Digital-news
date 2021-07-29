/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.DBContext;
import dal.NewsDAO;
import entity.News;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
public class SearchServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            //get imagePath
            DBContext bContext = new DBContext();
            String imagePath = bContext.getImagePath();
            request.setAttribute("imagePath", imagePath);

            //get list of news that title contain txtSearch
            String txtSearch = request.getParameter("txtSearch");
            NewsDAO nDAO = new NewsDAO();
            
            List<News> listNews = nDAO.searchNews(txtSearch);
            int numberOfNews = listNews.size();
            
            //display the result, each page contain 4 news
            int newsPerPage = 4;
            
            //if the number of news is divisible by 4 => numberOfPages = numberOfNews/4
            // else => numberOfPages = numberOfNews/4 +1
            int numberOfPages = numberOfNews / newsPerPage + (numberOfNews % newsPerPage == 0 ? 0 : 1);
            
            //get the index of page from URL
            //if the number>number of pages OR the number is invalid => show error
            String pageRaw = request.getParameter("page");
            int page;
            try {
                if (pageRaw==null) page = 1;
                else
                    page = Integer.parseInt(pageRaw);
            } catch (Exception e) {
                page=numberOfPages+1;
            }
            
            //determine the index of first/last news on the page
            int start, end;
            start = (page - 1) * newsPerPage;
            if (page * newsPerPage > numberOfNews) {
                end = numberOfNews;
            } else {
                end = page * newsPerPage;
            }
            
            //get content of page
            List<News> newsOnPage = nDAO.getNewsByPage(listNews, start, end);

            //get top1, top5 (right)
            News top1 = nDAO.getMostRecentNews();
            List<News> top5 = nDAO.get5RecentNews();
            request.setAttribute("top1", top1);
            request.setAttribute("top5", top5);

            request.setAttribute("numberOfPages", numberOfPages);
            request.setAttribute("page", page);
            request.setAttribute("txtSearch", txtSearch);
            request.setAttribute("newsOnPage", newsOnPage);
            request.getRequestDispatcher("search.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("msg", "There was an error while searching");
            request.getRequestDispatcher("error.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
