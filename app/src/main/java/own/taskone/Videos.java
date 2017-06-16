package own.taskone;

/**
 * Created by USER on 12-06-2017.
 */

public class Videos {
    String videolink,videotitle,videoduration,videodes;
    Videos(String videolink,String videotitle,String videoduration, String videodes){
        this.videolink= videolink;this.videotitle=videotitle;this.videoduration = videoduration;
        this.videodes = videodes;
    }

    public String getVideodes() {
        return videodes;
    }

    public String getVideoduration() {
        return videoduration;
    }

    public String getVideolink() {
        return videolink;
    }

    public String getVideotitle() {
        return videotitle;
    }
}
