/**
 *
 */
package com.page.impl;

import com.page.IGenericPage;

import java.util.Collections;
import java.util.List;

/**
 * @param <T>
 * @author Oliver.Liu
 */
public class GenericDefaultPage<T> implements IGenericPage<T> {
    /**
     * ����һ��ҳ
     *
     * @see #emptyPage()
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static final GenericDefaultPage EMPTY_PAGE = new GenericDefaultPage(
            0, 0, Collections.emptyList(), 0);
    /**
     * ��ǰҳ�����б�
     */
    private List<T> elements;
    /**
     * ҳ��С��ÿҳ���ݸ�����
     */
    private int pageSize;
    /**
     * ��ǰҳ��
     */
    private int pageNo;
    /**
     * �����ܸ���
     */
    private int totalCount = 0;

    /**
     * ���ݵ�ǰҳ�š�ҳ��С��ÿҳ���ݸ���������ǰҳ�����б������ܸ��������ҳ���ݶ����ʵ����
     *
     * @param pageNo     ��ǰҳ��
     * @param pageSize   ҳ��С��ÿҳ���ݸ�����
     * @param elements   ��ǰҳ�����б�
     * @param totalCount �����ܸ���
     */
    public GenericDefaultPage(
            int pageNo, int pageSize, List<T> elements, int totalCount) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.elements = elements;
        this.totalCount = totalCount;
    }

    /**
     * ��ȡһ��ҳ
     */
    @SuppressWarnings("unchecked")
    public static <E> GenericDefaultPage<E> emptyPage() {
        return (GenericDefaultPage<E>) EMPTY_PAGE;
    }

    /**
     * ����ҳ��С��ÿҳ���ݸ�������ȡ����ҳ�ŵĵ�һ���������������е�λ�ã���1��ʼ��
     *
     * @param pageNo   ������ҳ��
     * @param pageSize ҳ��С��ÿҳ���ݸ�����
     * @return ����ҳ�ŵĵ�һ���������������е�λ�ã���1��ʼ��
     */
    public static int getStartOfPage(int pageNo, int pageSize) {
        int startIndex = (pageNo - 1) * pageSize + 1;
        if (startIndex < 1) startIndex = 1;
        return startIndex;
    }

    /* (non-Javadoc)
     * @see com.harmony.framework.query.generic.IGenericPage#isFirstPage()
     */
    public boolean isFirstPage() {
        return getPageNo() == 0;
    }

    /* (non-Javadoc)
     * @see com.harmony.framework.query.generic.IGenericPage#isLastPage()
     */
    public boolean isLastPage() {
        return getPageNo() >= getLastPageNo();
    }

    /* (non-Javadoc)
     * @see com.harmony.framework.query.generic.IGenericPage#hasNextPage()
     */
    public boolean hasNextPage() {
        return elements == null ? false : elements.size() > getPageSize();
    }

    /* (non-Javadoc)
     * @see com.harmony.framework.query.generic.IGenericPage#hasPreviousPage()
     */
    public boolean hasPreviousPage() {
        return getPageNo() > 0;
    }

    /* (non-Javadoc)
     * @see com.harmony.framework.query.generic.IGenericPage#getLastPageNo()
     */
    public int getLastPageNo() {
        double totalResults = new Integer(getTotalCount())
                .doubleValue();
        return (totalResults % getPageSize() == 0) ? new Double(Math.floor(totalResults / getPageSize())).intValue() : (new Double(Math.floor(totalResults / getPageSize())).intValue() + 1);
    }

    /* (non-Javadoc)
     * @see com.harmony.framework.query.generic.IGenericPage#getThisPageElements()
     */
    public List<T> getThisPageElements() {
        return hasNextPage() ? elements.subList(0, getPageSize()) : elements;
    }

    /* (non-Javadoc)
     * @see com.harmony.framework.query.generic.IGenericPage#getTotalCount()
     */
    public int getTotalCount() {
        return totalCount;
    }

    /* (non-Javadoc)
     * @see com.harmony.framework.query.generic.IGenericPage#getThisPageFirstElementNumber()
     */
    public int getThisPageFirstElementNumber() {
        return getPageNo() * getPageSize() + 1;
    }

    /* (non-Javadoc)
     * @see com.harmony.framework.query.generic.IGenericPage#getThisPageLastElementNumber()
     */
    public int getThisPageLastElementNumber() {
        int fullPage = getThisPageFirstElementNumber() + getPageSize() - 1;
        return getTotalCount() < fullPage
                ? getTotalCount() : fullPage;
    }

    /* (non-Javadoc)
     * @see com.harmony.framework.query.generic.IGenericPage#getNextPageNo()
     */
    public int getNextPageNo() {
        return getPageNo() + 1;
    }

    /* (non-Javadoc)
     * @see com.harmony.framework.query.generic.IGenericPage#getPreviousPageNo()
     */
    public int getPreviousPageNo() {
        return getPageNo() - 1;
    }

    /* (non-Javadoc)
     * @see com.harmony.framework.query.generic.IGenericPage#getPageSize()
     */
    public int getPageSize() {
        return pageSize;
    }

    /* (non-Javadoc)
     * @see com.harmony.framework.query.generic.IGenericPage#getPageNo()
     */
    public int getPageNo() {
        return pageNo;
    }
}
