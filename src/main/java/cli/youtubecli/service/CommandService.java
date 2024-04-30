package cli.youtubecli.service;

import cli.youtubecli.model.Video;
import java.util.List;
import org.springframework.shell.table.TableBuilder;

public interface CommandService {
    TableBuilder listToArrayTableModel(List<Video> videos);
}
