package demo.page;

import java.util.List;

/**
 * 分页对象
 *
 * @author zhenggc
 * @date 2019/2/22
 */
public class Page<T> {

    /**
     * 数据总数
     */
    private int total;
    /**
     * 每页数量
     */
    private int size;
    /**
     * 当前页数
     */
    private int current;
    /**
     * 总页数
     */
    private int pages;
    /**
     * 数据集合
     */
    private List<T> records;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
