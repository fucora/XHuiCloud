package com.xhuicloud.common.security.utils;

import cn.hutool.core.util.StrUtil;
import com.xhuicloud.common.security.service.XHuiUser;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.xhuicloud.common.core.constant.AuthorizationConstants.ROLE_PREFIX;

/**
 * @program: XHuiCloud
 * @description:  SpringSecurity工具类
 * @author: Sinda
 * @create: 2020-01-01 18:21
 */
@UtilityClass
public class SecurityHolder {
	/**
	 * 获取Authentication
	 */
	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	/**
	 * 获取用户
	 */
	public XHuiUser getUser(Authentication authentication) {
		Object principal = authentication.getPrincipal();
		if (principal instanceof XHuiUser) {
			return (XHuiUser) principal;
		}
		return null;
	}

	/**
	 * 获取用户
	 */
	public XHuiUser getUser() {
		Authentication authentication = getAuthentication();
		return getUser(authentication);
	}

	/**
	 * 获取用户Id
	 */
	public Integer getUserId() {
		return getUser().getId();
	}

	/**
	 * 获取用户角色信息
	 *
	 * @return 角色集合
	 */
	public List<Integer> getRoles() {
		Authentication authentication = getAuthentication();
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

		List<Integer> roleIds = new ArrayList<>();
		authorities.stream()
				.filter(granted -> StrUtil.startWith(granted.getAuthority(), ROLE_PREFIX))
				.forEach(granted -> {
					String id = StrUtil.removePrefix(granted.getAuthority(), ROLE_PREFIX);
					roleIds.add(Integer.parseInt(id));
				});
		return roleIds;
	}

}
