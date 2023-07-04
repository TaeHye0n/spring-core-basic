package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    //자동 빈등록 vs 자동 빈등록: ConflictingBeanDefinitionException 예외 발생
    //수동 빈등록 vs 자동 빈등록: 수동 빈이 자동 빈을 오버라이딩 해버린다. 하지만 스프링부트에선 오류가 발생나도록 처리함
    @Bean(name = "memoryMemberRepository")
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
