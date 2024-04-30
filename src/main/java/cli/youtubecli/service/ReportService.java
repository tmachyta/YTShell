package cli.youtubecli.service;

import cli.youtubecli.model.TeamTabRow;
import cli.youtubecli.model.Video;
import java.util.List;

public interface ReportService {
    List<TeamTabRow> videosToTeamTabRows(List<Video> videos);
}
