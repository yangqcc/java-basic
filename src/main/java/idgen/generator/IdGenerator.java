package idgen.generator;

/**
 * <p>title:Id 生成接口.</p>
 * <p>description:Id 生成接口.</p>
 *
 * @author: yangqc
 * @date Created in 2017-5-12
 */
public interface IdGenerator {

  /**
   * 生成Id.
   *
   * @param key
   * @return 返回生成的Id, 返回值应为@{@link Number}对象或者为@{@link String}对象
   */
  Number generateId(String key);
}
