package cli.youtubecli.command;

import cli.youtubecli.model.TeamTabRow;
import cli.youtubecli.model.Video;
import cli.youtubecli.service.*;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.shell.table.TableBuilder;

@ShellComponent
@RequiredArgsConstructor
public class YouTubeStatsCommand {
    private final VideoService videoService;
    private final CommandService commandService;
    private final ReportService reportService;

    @ShellMethod(key = "recent", value = "List recent videos by max count ||"
            + " command useful: recent --max max")
    public void recent(@ShellOption(help = "Enter the max amount of videos to filter videos") Integer max) {
        List<Video> videos = videoService.findRecent(max);
        TableBuilder tableBuilder = commandService.listToArrayTableModel(videos);
        System.out.println(tableBuilder.build().render(120));

    }

    @ShellMethod(key = "filter-by-year", value = "List videos by year ||"
            + " command useful: filter-by-year --year year")
    public void byYear(@ShellOption(help = "Enter the year to filter videos") Integer year) {
        List<Video> videos = videoService.findAllByYear(year);
        TableBuilder tableBuilder = commandService.listToArrayTableModel(videos);
        System.out.println(tableBuilder.build().render(120));
    }

    @ShellMethod(key = "report", value = "Run a report based on all of the videos of the current year")
    public void report() {
        List<Video> videos = videoService.findAllByYear(LocalDate.now().getYear());
        List<TeamTabRow> teamTabRows = reportService.videosToTeamTabRows(videos);
        teamTabRows.forEach(TeamTabRow::print);
    }


    @ShellMethod(key = "filter-by-first-letter", value = "List videos by first letter title"
            + " || command useful: filter-by-first-letter --letter letter")
    public void byFirstLetter(@ShellOption(help = "Enter the first letter to filter videos") String letter) {
        List<Video> videos = videoService.findAllByFirstLetter(letter);
        TableBuilder tableBuilder = commandService.listToArrayTableModel(videos);
        System.out.println(tableBuilder.build().render(120));
    }

    @ShellMethod(key = "filter-by-views", value = "List videos by views ||"
            + " command useful: filter-by-views --views views")
    public void byViews(@ShellOption(help = "Enter the amount of views to filter videos") Integer views) {
        List<Video> videos = videoService.findAllByViews(views);
        TableBuilder tableBuilder = commandService.listToArrayTableModel(videos);
        System.out.println(tableBuilder.build().render(120));
    }

    @ShellMethod(key = "filter-by-likes", value = "List videos by likes ||"
            + " command useful: filter-by-likes --likes likes")
    public void byLikes(@ShellOption(help = "Enter the amount of likes to filter videos") Integer likes) {
        List<Video> videos = videoService.findAllByLikes(likes);
        TableBuilder tableBuilder = commandService.listToArrayTableModel(videos);
        System.out.println(tableBuilder.build().render(120));
    }
}
