package daointerface.impl;

import daointerface.RecordDao;
import model.Records;
import utility.ConnectionDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecordDaoImpl extends ConnectionDAO implements RecordDao {

    @Override
    public List<Records> getAllRecords() {
        try {
            Connection connection = ConnectionDAO.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM records");

            List<Records> recordlist = new ArrayList<Records>();

            while (rs.next()) {
                Records r = new Records();
                r.setCatalogueNum(rs.getInt("catalogueNum"));
                r.setRecordName(rs.getString("recordName"));
                recordlist.add(r);
            }
            return recordlist;

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return null;
    }

    @Override
    public void saveRecord(List<Records> recordsList) {
        try {
            Connection connection = ConnectionDAO.getConnection();

             for (Records record : recordsList) {
                String sqlQuery = "INSERT INTO records(catalogueNum, recordName) VALUES(?, ?)";
                PreparedStatement ps = connection.prepareStatement(sqlQuery);
                ps.setInt(1, record.getCatalogueNum());
                ps.setString(2, record.getRecordName());

                int affectedRows = ps.executeUpdate();
                System.out.println(affectedRows + " record(s) inserted");
             }
            } catch (SQLException e) {
              e.printStackTrace();
              System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    @Override
    public boolean deleteRecord(int id) {
        try{
            Connection connection = ConnectionDAO.getConnection();
            PreparedStatement ps = connection.prepareStatement("DELETE FROM records WHERE id=?");

            ps.setInt(1, id);
            int i = ps.executeUpdate();
            if(i == 1){
                return true;
            }
        }catch (SQLException e){
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateRecord(Records record, int id) {
        try {
            Connection connection = ConnectionDAO.getConnection();

            String sqlQuery = "UPDATE records SET catalogueNum=?, recordName=? WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ps.setInt(1, record.getCatalogueNum());
            ps.setString(2, record.getRecordName());
            ps.setInt(3, id);

            int i = ps.executeUpdate();
            if (i == 1)
                return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
