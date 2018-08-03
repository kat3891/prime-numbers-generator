package RestApi;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import static Calculator.PrimeNumberCalculator.getAlgorithmName;
import static RestApi.CustomLogger.getStackTrace;

class Audit {
    private Dao<RequestRecord, String> requestDao;

    Audit(String databaseURL, CustomLogger logger) {
        ConnectionSource connectionSource;
        try {
            connectionSource = new JdbcConnectionSource(databaseURL);
            TableUtils.createTableIfNotExists(connectionSource, RequestRecord.class);
            this.requestDao = DaoManager.createDao(connectionSource, RequestRecord.class);
        } catch (SQLException e) {
            logger.logger.severe(getStackTrace(e));
        }
    }

    void recordRequest(int algoChosen, int min, int max, List<Integer> res, String ip, long timeElapsed) throws SQLException {
        RequestRecord request = new RequestRecord();
        request.setNumberOfPrimesReturned(res.size());
        request.setAlgorithmChosen(getAlgorithmName(algoChosen));
        request.setRangeMin(min);
        request.setRangeMax(max);
        request.setIp(ip);
        request.setTimeElapsed(timeElapsed); // time elapsed in milliseconds
        request.setTimestamp(new Timestamp(System.currentTimeMillis()));
        this.requestDao.create(request);

    }
}
