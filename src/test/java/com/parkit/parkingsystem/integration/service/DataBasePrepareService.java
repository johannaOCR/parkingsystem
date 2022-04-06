package com.parkit.parkingsystem.integration.service;

import com.parkit.parkingsystem.integration.config.DataBaseTestConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DataBasePrepareService {

    DataBaseTestConfig dataBaseTestConfig = new DataBaseTestConfig();

    public void clearDataBaseEntries(){
        Connection connection = null;
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        try{
            connection = dataBaseTestConfig.getConnection();

            //set parking entries to available
            ps = connection.prepareStatement("update parking set available = true");
            ps.execute();

            //clear ticket entries;
            ps1 = connection.prepareStatement("truncate table ticket");
            ps1.execute();

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            dataBaseTestConfig.closeConnection(connection);
            dataBaseTestConfig.closePreparedStatement(ps);
            dataBaseTestConfig.closePreparedStatement(ps1);
        }
    }


}
