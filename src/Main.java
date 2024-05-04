import sample.DateSorter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<LocalDate> dates = new ArrayList<>();
        generateDatesToList(dates);

        DateSorter dateSorter = new DateSorter();
        Collection<LocalDate> sortedDates = dateSorter.sortDates(dates);
        System.out.println(sortedDates);
    }

    private static void generateDatesToList(List<LocalDate> dates) {
        DateTimeFormatter dfm = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            dates.add(LocalDate.parse("2004-07-01", dfm));
            dates.add(LocalDate.parse("2005-01-02", dfm));
            dates.add(LocalDate.parse("2007-01-01", dfm));
            dates.add(LocalDate.parse("2032-05-03", dfm));
//            dates.add(LocalDate.parse("2032-28-03", dfm)); // it is for provoking exception
        } catch (DateTimeParseException e) {
            System.out.println("Invalid Date format: " + e.getMessage());
        }
    }
}