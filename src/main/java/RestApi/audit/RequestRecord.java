package RestApi.audit;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.Timestamp;

@DatabaseTable(tableName = "requests")
public class RequestRecord {
    @DatabaseField(generatedId= true)
    private int id;

   @DatabaseField(canBeNull = false)
    private  int rangeMin;

    @DatabaseField(canBeNull = false)
    private  int rangeMax;

    @DatabaseField(canBeNull = false)
    private String algorithmChosen;

    @DatabaseField(canBeNull = false)
    private int numberOfPrimesReturned;

    @DatabaseField(canBeNull = false)
    private String ip;

    @DatabaseField(canBeNull = false)
    private long timeElapsed; // in milliseconds

    @DatabaseField(canBeNull = false)
    private Timestamp timestamp;

    public RequestRecord() { }

    public Timestamp getTimestamp() { return timestamp; }

    public void setTimestamp(final Timestamp timestamp) { this.timestamp = timestamp; }

    public long getTimeElapsed() { return timeElapsed; }

    public void setTimeElapsed(final long timeElapsed) { this.timeElapsed = timeElapsed; }

    public String getIp() { return ip; }

    public void setIp(final String ip) { this.ip = ip; }

    public int getId() { return id; }

    public void setId(final int id) { this.id = id; }

    public int getRangeMin() { return rangeMin; }

    public void setRangeMin(final int rangeMin) { this.rangeMin = rangeMin; }

    public int getRangeMax() { return rangeMax; }

    public void setRangeMax(final int rangeMax) { this.rangeMax = rangeMax; }

    public String getAlgorithmChosen() { return algorithmChosen; }

    public void setAlgorithmChosen(final String algorithmChosen) { this.algorithmChosen = algorithmChosen; }

    public int getNumberOfPrimesReturned() { return numberOfPrimesReturned; }

    public void setNumberOfPrimesReturned(final int numberOfPrimesReturned) { this.numberOfPrimesReturned = numberOfPrimesReturned; }
}
