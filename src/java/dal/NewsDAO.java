/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import entity.News;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class NewsDAO {

    public News getNewsById(int id) throws Exception{

        DBContext db = new DBContext();
        Connection connection = null;
        PreparedStatement prestm = null;
        ResultSet rs = null;
        
        try {
            String sql = "SELECT [id],[title],[image],[description],"
                    + "[newsContent],[writer],[datePublished] "
                    + "FROM [News] where id=?";
            connection = db.getConnection();
            prestm = connection.prepareStatement(sql);
            prestm.setInt(1, id);
            rs = prestm.executeQuery();
            if (rs.next()) {
                News news = new News(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("image"),
                        rs.getString("description"),
                        rs.getString("newsContent"),
                        rs.getString("writer"),
                        rs.getTimestamp("datePublished"));
                return news;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, prestm, connection);
        }
        return null;
    }

    public News getMostRecentNews() throws Exception{
        DBContext db = new DBContext();
        Connection connection = null;
        PreparedStatement prestm = null;
        ResultSet rs = null;
        
        try {
            String sql = "SELECT top 1 [id],[title],[image],[description],"
                    + "[newsContent],[writer],[datePublished] "
                    + "FROM [News] "
                    + "ORDER BY datePublished DESC";
            connection = db.getConnection();
            prestm = connection.prepareStatement(sql);
            rs = prestm.executeQuery();
            if (rs.next()) {
                News news = new News(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("image"),
                        rs.getString("description"),
                        rs.getString("newsContent"),
                        rs.getString("writer"),
                        rs.getTimestamp("datePublished"));
                return news;
            }
        } catch (Exception ex) {
            throw  ex;
        } finally {
            db.closeConnection(rs, prestm, connection);
        }
        return null;
    }

    public List<News> get5RecentNews() throws Exception {
        DBContext db = new DBContext();
        Connection connection = null;
        PreparedStatement prestm = null;
        ResultSet rs = null;
        
        try {
            List<News> listNews = new ArrayList<>();
            String sql = "SELECT top 5 [id],[title],[image],[description],"
                    + "[newsContent],[writer],[datePublished] "
                    + "FROM [News] "
                    + "ORDER BY datePublished DESC";
            connection = db.getConnection();
            prestm = connection.prepareStatement(sql);
            rs = prestm.executeQuery();
            while (rs.next()) {
                News news = new News(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("image"),
                        rs.getString("description"),
                        rs.getString("newsContent"),
                        rs.getString("writer"),
                        rs.getTimestamp("datePublished"));
                listNews.add(news);
            }
            return listNews;
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, prestm, connection);
        }
    }

    public List<News> searchNews(String txtSearch) throws Exception {
        DBContext db = new DBContext();
        Connection connection = null;
        PreparedStatement prestm = null;
        ResultSet rs = null;
        try {
            List<News> listNews = new ArrayList<>();
            String sql = "SELECT [id],[title],[image],[description],"
                    + "[newsContent],[writer],[datePublished] "
                    + "FROM [News] "
                    + "WHERE title LIKE CONCAT( '%',?,'%')";
            connection = db.getConnection();
            prestm = connection.prepareStatement(sql);
            prestm.setString(1, txtSearch);
            rs = prestm.executeQuery();
            
            while (rs.next()) {
                News news = new News(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("image"),
                        rs.getString("description"),
                        rs.getString("newsContent"),
                        rs.getString("writer"),
                        rs.getTimestamp("datePublished"));
                listNews.add(news);
            }
            return listNews;
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, prestm, connection);
        }
    }

    public List<News> getNewsByPage(List<News> list, int start, int end) {
        List<News> newsOnPage = new ArrayList<>();
        for (int i = start; i < end; i++) {
            newsOnPage.add(list.get(i));
        }
        return newsOnPage;
    }
}
