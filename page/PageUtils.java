package demo.page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 分页工具
 *
 * @author zhenggc
 * @date 2019/2/21
 */
public class PageUtils {
    /**
     * 对List中不是对象的数据进行分页
     *
     * @param list    需要分页的集合
     * @param current 当前页数
     * @param size    每页数据量
     * @return 分页结果
     * @author zhenggc
     * @date 2019/2/22
     */
    public static <T> Page<T> getListPage(List<T> list, int current, int size) {
        //创建分页对象
        Page<T> page = new Page<>();
        //计算数据总数
        int total = list.size();
        //计算开始数据位置
        int start = (current - 1) * size;
        //计算截止数据位置
        int end = total - start < size ? total : start + size;
        //返回数据集合
        List<T> data = new ArrayList<>();
        for (; start < end; start++) {
            data.add(list.get(start));
        }
        page.setRecords(data);
        page.setTotal(total);
        page.setSize(size);
        page.setCurrent(current);
        if (size == 0) {
            page.setPages(0);
        }
        int pages = total / size;
        if (total % size != 0) {
            pages++;
        }
        page.setPages(pages);
        return page;
    }

    /**
     * 对List中的数据进行分页
     *
     * @param list    需要分页的集合
     * @param current 当前页数
     * @param size    每页数据量
     * @return 分页结果
     * @author zhenggc
     * @date 2019/2/22
     */
    public static <T> Page<T> getPage(List<T> list, int current, int size) {
        //创建分页对象
        Page<T> page = new Page<>();
        //计算数据总数
        int total = list.size();
        //计算开始数据位置
        int start = (current - 1) * size;
        //计算截止数据位置
        int end = total - start < size ? total : start + size;
        //返回数据集合
        List<T> data = list.stream()
                .skip(start)
                .limit(size)
                .collect(Collectors.toList());
        page.setRecords(data);
        page.setTotal(total);
        page.setSize(size);
        page.setCurrent(current);
        if (size == 0) {
            page.setPages(0);
        }
        int pages = total / size;
        if (total % size != 0) {
            pages++;
        }
        page.setPages(pages);
        return page;
    }
}
