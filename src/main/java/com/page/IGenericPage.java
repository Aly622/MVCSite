/**
 *
 */
package com.page;

import java.util.List;

/**
 * @author Oliver.Liu
 */
public interface IGenericPage<T> {

    /**
     * �Ƿ�Ϊ��һҳ
     *
     * @return �Ƿ�Ϊ��һҳ
     */
    boolean isFirstPage();

    /**
     * �Ƿ�Ϊ���һҳ
     *
     * @return �Ƿ�Ϊ���һҳ
     */
    boolean isLastPage();

    /**
     * ������һҳ
     *
     * @return ��(true)Ϊ����һҳ����(false)Ϊ��
     */
    boolean hasNextPage();

    /**
     * ������һҳ
     *
     * @return ��(true)Ϊ����һҳ����(false)Ϊ��
     */
    boolean hasPreviousPage();

    /**
     * �õ����һҳ��ҳ��
     *
     * @return ���һҳ��ҳ��
     */
    int getLastPageNo();

    /**
     * ��ȡ��ǰҳ�а���������
     *
     * @return ��ǰҳ�а���������
     */
    List<T> getThisPageElements();

    /**
     * �õ������ܸ���
     *
     * @return �����ܸ���
     */
    int getTotalCount();

    /**
     * ��ȡ��ǰҳ��һ����¼�����м�¼�ı�ţ��������Χ�ϱ�
     *
     * @return ��ǰҳ��һ����¼�����м�¼�ı��
     */
    int getThisPageFirstElementNumber();

    /**
     * ��ȡ��ǰҳ���һ����¼�����м�¼�ı��
     *
     * @return ��ǰҳ���һ����¼�����м�¼�ı��
     */
    int getThisPageLastElementNumber();

    /**
     * �õ���һҳ��ҳ��
     *
     * @return ��һҳ��ҳ��
     */
    int getNextPageNo();

    /**
     * �õ�ǰһҳ��ҳ��
     *
     * @return ǰһҳ��ҳ��
     */
    int getPreviousPageNo();

    /**
     * �õ��趨��ҳ��С��ÿҳ���ݸ�����
     *
     * @return ҳ��С ��ÿҳ���ݸ�����
     */
    int getPageSize();

    /**
     * �õ���ǰҳ��ҳ��
     *
     * @return ��ǰҳ��ҳ��
     */
    int getPageNo();
}
