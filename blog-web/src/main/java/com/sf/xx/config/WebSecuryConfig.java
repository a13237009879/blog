package com.sf.xx.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecuryConfig extends WebSecurityConfigurerAdapter
{

	 /**
     * 重写该方法，添加自定义用户
     * */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
        .withUser("admin").password("admin").roles("ADMIN")
        .and()
        .withUser("terry").password("terry").roles("USER")
        .and()
        .withUser("larry").password("larry").roles("USER");
    }
	
	/*@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		 http.csrf().disable().cors().disable().headers().disable()//禁止以上过滤器
					 .authorizeRequests().antMatchers("/","/static/**").permitAll()//可访问的地址
					 .anyRequest().authenticated()// 其他地址需要授权后访问
					 .and()
					 .formLogin().loginPage("/login")// 登录地址
			         .defaultSuccessUrl("/admin")//登录后跳转地址
					 .permitAll()
					 .and().logout().logoutSuccessUrl("/login").permitAll();//配置注销成功后页面
	}*/
	
}
