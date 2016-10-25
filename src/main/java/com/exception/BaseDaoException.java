/**
 *
 */
package com.exception;

/**
 * @author Oliver.Liu
 */
@SuppressWarnings("serial")
public class BaseDaoException extends BaseException {
    /**
     * ����һ��DAO���ݷ��ʲ��쳣����.
     *
     * @param message ��Ϣ����
     */
    public BaseDaoException(String message) {
        super(message);
    }

    /**
     * ����һ��DAO���ݷ��ʲ��쳣����.
     *
     * @param errorCode �������
     * @param message   ��Ϣ����
     */
    public BaseDaoException(String errorCode, String message) {
        super(errorCode, message, true);
    }

    /**
     * ����һ��DAO���ݷ��ʲ��쳣����.
     *
     * @param errorCode     �������
     * @param message       ��Ϣ����
     * @param propertiesKey ��Ϣ�Ƿ�Ϊ�����ļ��е�Key
     */
    public BaseDaoException(String errorCode, String message, boolean propertiesKey) {
        super(errorCode, message, propertiesKey);
    }

    /**
     * ����һ��DAO���ݷ��ʲ��쳣����.
     *
     * @param message ��Ϣ����
     * @param cause   ���쳣�ࣨ���Դ����κ��쳣��
     */
    public BaseDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
