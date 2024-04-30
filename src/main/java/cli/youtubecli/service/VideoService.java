package cli.youtubecli.service;

import cli.youtubecli.model.Video;
import java.util.List;

public interface VideoService {
    List<Video> findAllByYear(Integer year);

    List<Video> findRecent(Integer max);

    void loadAllVideosThisYear(String pageToken);

    List<Video> findAllByFirstLetter(String letter);

    List<Video> findAllByViews(Integer view);

    List<Video> findAllByLikes(Integer like);
}
