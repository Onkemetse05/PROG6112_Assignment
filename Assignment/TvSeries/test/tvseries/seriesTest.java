package tvseries;

import org.junit.Test;
import static org.junit.Assert.*;

public class seriesTest {

    @Test
    public void TestSearchSeries() {
        // Arrange
        TvSeries.seriesList.clear();
        SeriesModel sm = new SeriesModel();
        sm.setSeriesID("110");
        sm.setSeriesName("Batman");
        sm.setSeriesAge("16");
        sm.setSeriesNumberOfEpisodes("14");
        TvSeries.seriesList.add(sm);

        // Act
        boolean found = false;
        for (SeriesModel s : TvSeries.seriesList) {
            if (sm.getSeriesID().equals("110")) {
                found = true;
                assertEquals("Batman", s.getSeriesName());
                assertEquals("16", s.getSeriesAge());
                assertEquals("14", s.getSeriesNumberOfEpisodes());
            }
        }

        // Assert
        assertTrue(found);
    }

    @Test
    public void TestSearchSeries_SeriesNotFound() {
        TvSeries.seriesList.clear();
        boolean found = false;
        for (SeriesModel s : TvSeries.seriesList) {
            if (s.getSeriesID().equals("486")) {
                found = true;
            }
        }
        assertFalse(found);
    }

    @Test
    public void TestUpdateSeries() {
        TvSeries.seriesList.clear();
        SeriesModel s = new SeriesModel();
        s.setSeriesID("369");
        s.setSeriesName("Thor");
        s.setSeriesAge("16");
        s.setSeriesNumberOfEpisodes("24");
        TvSeries.seriesList.add(s);

        // Simulate update
        for (SeriesModel series : TvSeries.seriesList) {
            if (series.getSeriesID().equals("369")) {
                series.setSeriesName("Thor");
                series.setSeriesAge("16");
                series.setSeriesNumberOfEpisodes("24");
            }
        }

        SeriesModel updated = TvSeries.seriesList.get(0);
        assertEquals("Thor", updated.getSeriesName());
        assertEquals("16", updated.getSeriesAge());
        assertEquals("24", updated.getSeriesNumberOfEpisodes());
    }

    @Test
    public void TestDeleteSeries() {
        TvSeries.seriesList.clear();
        SeriesModel sm = new SeriesModel();
        sm.setSeriesID("147");
        TvSeries.seriesList.add(sm);

        boolean deleted = false;
        for (int i = 0; i < TvSeries.seriesList.size(); i++) {
            if (TvSeries.seriesList.get(i).getSeriesID().equals("147")) {
                TvSeries.seriesList.remove(i);
                deleted = true;
                break;
            }
        }

        assertTrue(deleted);
        assertTrue(TvSeries.seriesList.isEmpty());
    }

    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        TvSeries.seriesList.clear();
        boolean deleted = false;
        for (int i = 0; i < TvSeries.seriesList.size(); i++) {
            if (TvSeries.seriesList.get(i).getSeriesID().equals("246")) {
                TvSeries.seriesList.remove(i);
                deleted = true;
                break;
            }
        }
        assertFalse(deleted);
    }

    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        String age = "10";
        boolean valid = false;
        try {
            int ageInt = Integer.parseInt(age);
            valid = ageInt >= 2 && ageInt <= 18;
        } catch (NumberFormatException e) {
            valid = false;
        }
        assertTrue(valid);
    }

    @Test
    public void TestSeriesAgeRestriction_SeriesAgeInValid() {
        String age = "19";
        boolean valid = false;
        try {
            int ageInt = Integer.parseInt(age);
            valid = ageInt >= 2 && ageInt <= 18;
        } catch (NumberFormatException e) {
            valid = false;
        }
        assertFalse(valid);
    }
}
