# PROG6112_Assignment

This repository consists of two coded applications Java based, TvSeries and TeacherPortal


>TvSeries
This code consists of capturing a Tv series(CaptureSeries()),updating it(UpdateSeries()), searching for it(SearchSeries()), deleting it(DeleteSeries()), show a report of the captured series(SeriesReport()) and exit the application(ExitSeriesApplication).It aslo includes a a storage space(SeriesModel()) which stores all the captured information which can be accessed.

>CaptureSeries()
This is where a user captures a new series, they will be to first enter a series ID which must be in numeric form, anything else won't be captured and will return an error.After entering a valid series ID they will be asked to enter the name of the name of the series which cannot be left blank.After entering the name, the will be asked to enter te aage restriction, between 2 and 18, anything other than those numbers will be returned as an error.They will then be asked to enter the number of episodes and then will the series be added to the memory in SeriesModel().

>UpdateSeries()
A user is asked the enter the series ID of the series they are looking for, but will not show if they have entered ainvalid ID.After finding the series they will be asked to update the following: Age restriction,the name and number of episodes.

>SearchSeries()
This will seatch for a existing series using its ID and will diplay all the information of that series such as, name, age restriction, ID and number of episodes.

>DeleteSeries()
This is where a user enteres the series ID which will be used to delete the captured series and remove it from memory.

>SeriesReport()
This method will display all the captured serie sin the order which they were captured.


*TEACHER PORTAL
This is where teachers captures the marks of learners, searches for them, updates the marks and prints the top achiever.

>CaptureMarks
A teacher is required to first enter the studens name then surname. Which will then automatically generate a six digit student ID. After they will go the the getValidMark method which loops through the seven subjects and insures that they are between 0 and 100.This information will then be stored on the Student_Information class and can be retrieved.

>SearchLearner
A teacher is required to enter the students name and all the the name, surname, student id and marks will be shown.

>SearchStudentNumber
A teacher will search for a learner using their student id and then their name, surname and student id will be shown

>UpdateMarks
A teacher is required to enter the name of the student which will then print that learners information and teachers will be able to adjust their marks.

>PrintTopAchiever()
This method will get the average o all the learners captured and print the highest one.

