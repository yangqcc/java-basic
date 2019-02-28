package zm;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by yangqc on 2017/10/22
 */
public class ModelClass {

    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String author;

    @Getter
    @Setter
    private String unit;

    @Getter
    @Setter
    private String periodical;

    @Getter
    @Setter
    private Date time;

    @Getter
    @Setter
    private String number;

    @Getter
    @Setter
    private String place;

    @Getter
    @Setter
    private String region;

    private String ishospital;

    public String getIshospital() {
        return ishospital;
    }

    public void setIshospital(String ishospital) {
        this.ishospital = ishospital;
    }

    @Override
    public String toString() {
        return "ModelClass{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", unit='" + unit + '\'' +
                ", periodical='" + periodical + '\'' +
                ", time=" + time +
                ", number='" + number + '\'' +
                ", place='" + place + '\'' +
                ", region='" + region + '\'' +
                ", isHospital=" + ishospital +
                '}';
    }
}
