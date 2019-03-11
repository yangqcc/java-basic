package zm;

import java.util.Date;
import lombok.Data;

/**
 * Created by yangqc on 2017/10/22
 */
@Data
public class ModelClass {

  private int id;

  private Date date;
  private String title;
  private String author;

  /**
   * 期刊
   */
  private String periodical;

  private String region;
  private String province;
  private String address;
  private String address1;
  private String address2;
  private String address3;
  private String address4;
}
