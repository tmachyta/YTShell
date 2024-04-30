package cli.youtubecli.service;

import cli.youtubecli.client.YouTubeDataClient;
import cli.youtubecli.config.YouTubeConfigProps;
import cli.youtubecli.model.SearchListResponse;
import cli.youtubecli.model.SearchResult;
import cli.youtubecli.model.Video;
import cli.youtubecli.model.VideoListResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {

    private final List<Video> videos = new ArrayList<>();
    private final YouTubeDataClient client;
    private final YouTubeConfigProps youtubeConfig;

    public VideoServiceImpl(YouTubeDataClient client, YouTubeConfigProps youtubeConfig) {
        this.client = client;
        this.youtubeConfig = youtubeConfig;
        this.loadAllVideosThisYear("");
    }

    @Override
    public void loadAllVideosThisYear(String pageToken) {
        SearchListResponse search = client.searchByPublishedAfter(youtubeConfig.channelId(), youtubeConfig.key(), 50, pageToken, "2023-01-01T00:00:00Z");
        for(SearchResult result : search.items()) {
            if(result.id().kind().equals("youtube#video")) {
                VideoListResponse videoListResponse = client.getVideo(result.id().videoId(), youtubeConfig.key());
                videos.addAll(videoListResponse.items());
            }
        }

        if(search.nextPageToken() != null && !search.nextPageToken().isEmpty()) {
            loadAllVideosThisYear(search.nextPageToken());
        }

    }

    @Override
    public List<Video> findAllByFirstLetter(String letter) {
        return videos.stream()
                .filter(v -> v.snippet().title().startsWith(letter))
                .toList();
    }

    @Override
    public List<Video> findAllByViews(Integer view) {
        return videos.stream()
                .filter(v -> v.statistics().viewCount() >= view)
                .toList();
    }

    @Override
    public List<Video> findAllByLikes(Integer like) {
        return videos.stream()
                .filter(v -> v.statistics().likeCount() >= like)
                .toList();
    }


    @Override
    public List<Video> findRecent(Integer max) {
        return videos.stream()
                .limit(max)
                .toList();
    }

    @Override
    public List<Video> findAllByYear(Integer year) {
        return videos.stream()
                .filter(v -> v.snippet().publishedAt().getYear() == year)
                .toList();
    }
}
