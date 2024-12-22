package dev.retrotv.framework.foundation.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 서비스 계층 클래스의 공통적인 기능을 정의한 추상 클래스
 * !중요: 모든 서비스 계층은 이 클래스를 상속받아 구현해야 합니다
 * EX) class SampleService extends AbstractService { ... }
 *
 * @since 1.0.0
 * @version 1.0.0
 */
public abstract class AbstractService {
    protected Logger log = LoggerFactory.getLogger(this.getClass());
}
