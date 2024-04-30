package cli.youtubecli.service;

import cli.youtubecli.model.TeamTabRow;
import cli.youtubecli.model.Video;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {

    @Override
    public List<TeamTabRow> videosToTeamTabRows(List<Video> videos) {
        return videos.stream()
                .map(video -> new TeamTabRow(video.snippet().title(),
                        "YouTube",
                        video.snippet().publishedAt().toLocalDate(),
                        video.snippet().publishedAt().toLocalDate(),
                        "Virtual",
                        "Y",
                        0,
                        video.statistics().viewCount(),
                        "https://www.youtube.com/watch?v=" + video.id(),
                        "",
                        ""))
                .toList();
    }
}
