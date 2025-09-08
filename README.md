# PROG6112_Assignment

This repository consists of two coded applications Java based, TvSeries and TeacherPortal


>TvSeries
This code consists of capturing a Tv series(CaptureSeries()),updating it(UpdateSeries()), searching for it(SearchSeries()), deleting it(DeleteSeries()), show a report of the captured series(SeriesReport()) and exit the application(ExitSeriesApplication).It aslo includes a a storage space(SeriesModel()) which stores all the captured information which can be accessed.

>CaptureSeries()
This is where a user captures a new series, they will be to first enter a series ID which must be in numeric form, anything else won't be captured and will return an error.After entering a valid series ID they will be asked to enter the name of the name of the series which cannot be left blank.After entering the name, the will be asked to enter te aage restriction, between 2 and 18, anything other than those numbers will be returned as an error.They will then be asked to enter the number of episodes and then will the series be added to the memory in SeriesModel().

>UpdateSeries()
A user is asked the enter the series ID of the series they are looking for, but will not show if they have entered ainvalid ID.After finding the series they will be asked to update the following: Age restriction,the name and number of episodes.

>
