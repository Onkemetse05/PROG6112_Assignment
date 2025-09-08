
package tvseries;


public class SeriesModel {
     
 String SeriesID;
 String SeriesName;
 String SeriesAge;
 String SeriesNumberOfEpisodes;


    public String getSeriesID() {
        return SeriesID;
    }

    public void setSeriesID(String SeriesID) {
        this.SeriesID = SeriesID;
    }

    public String getSeriesName() {
        return SeriesName;
    }

    public void setSeriesName(String SeriesName) {
        this.SeriesName = SeriesName;
    }

    public String getSeriesAge() {
        return SeriesAge;
    }

    public void setSeriesAge(String SeriesAge) {
        this.SeriesAge = SeriesAge;
    }

    public String getSeriesNumberOfEpisodes() {
        return SeriesNumberOfEpisodes;
    }

    public void setSeriesNumberOfEpisodes(String SeriesNumberOfEpisodes) {
        this.SeriesNumberOfEpisodes = SeriesNumberOfEpisodes;
    }
    @Override
    public String toString() {
        return "ID: " + SeriesID +
               ", Name: " + SeriesName +
               ", Age Restriction: " + SeriesAge +
               ", Episodes: " + SeriesNumberOfEpisodes;
    }
}
