package org.proway.model.search;


import java.time.LocalDate;
import java.util.ArrayList;

public class FilterMovie extends FilterMedia {
    /*
    private int durationMinutes;
    */
    private Integer durationMinutesIntervalStart;
    private Integer durationMinutesIntervalEnd;

    public FilterMovie(ArrayList<String> midiaNamesToSarch, String synopsisSearchTerm, ArrayList<String> actorsToSearch, ArrayList<String> genreToSearch, double imdbScoreIntervalStart, double imdbScoreIntervalEnd, LocalDate releaseDateIntervalStart, LocalDate releaseDateIntervalEnd, Integer durationMinutesIntervalStart, Integer durationMinutesIntervalEnd) {
        super(midiaNamesToSarch, synopsisSearchTerm, actorsToSearch, genreToSearch, imdbScoreIntervalStart, imdbScoreIntervalEnd, releaseDateIntervalStart, releaseDateIntervalEnd);
        this.emptyAllFiltersMovie();
        this.durationMinutesIntervalStart = durationMinutesIntervalStart;
        this.durationMinutesIntervalEnd = durationMinutesIntervalEnd;
    }

    public FilterMovie() {
        this.emptyAllFiltersMovie();
    }

    public void emptyAllFiltersMovie()
    {
        durationMinutesIntervalStart = null;
        durationMinutesIntervalEnd = null;
    }

    public void setDurationMinutesInterval(Integer durationMinutesIntervalEnd) {
        this.durationMinutesIntervalEnd = durationMinutesIntervalEnd;
    }

    public void setDurationMinutesInterval(Integer durationMinutesIntervalStart, Integer durationMinutesIntervalEnd) {
        this.durationMinutesIntervalStart = durationMinutesIntervalStart;
        this.durationMinutesIntervalEnd = durationMinutesIntervalEnd;
    }

    public Integer getDurationMinutesIntervalStart() {
        return durationMinutesIntervalStart;
    }

    public void setDurationMinutesIntervalStart(Integer durationMinutesIntervalStart) {
        this.durationMinutesIntervalStart = durationMinutesIntervalStart;
    }

    public Integer getDurationMinutesIntervalEnd() {
        return durationMinutesIntervalEnd;
    }

    public void setDurationMinutesIntervalEnd(Integer durationMinutesIntervalEnd) {
        this.durationMinutesIntervalEnd = durationMinutesIntervalEnd;
    }
}
