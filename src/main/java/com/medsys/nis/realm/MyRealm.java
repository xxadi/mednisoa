package com.medsys.nis.realm;


import com.medsys.nis.maintain.bean.Permissions;
import com.medsys.nis.maintain.bean.Role;
import com.medsys.nis.maintain.bean.User;
import com.medsys.nis.maintain.controller.StorageController;
import com.medsys.nis.maintain.service.LoginService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 自定义Realm
 * @author zjt
 *
 */
public class MyRealm extends AuthorizingRealm{

	/**
	 * 日志
	 */
	private static final Logger LOG = LoggerFactory.getLogger(StorageController.class);
	@Autowired
	private LoginService loginService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		//获取登录用户名
		String name = (String) principalCollection.getPrimaryPrincipal();
		System.out.println("获取"+name);
		//根据用户名去数据库查询用户信息
		User user = loginService.getUserByName(name);

		//添加角色和权限
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		for (Role role : user.getRoles()) {
			//添加角色
			simpleAuthorizationInfo.addRole(role.getRoleName());
			LOG.info("正在添加角色：【"+role.getRoleName()+"】");
			//添加权限
			for (Permissions permissions : role.getPermissions()) {
				LOG.info("正在添加权限：【"+permissions.getPermissionsName()+"】");
				simpleAuthorizationInfo.addStringPermission(permissions.getPermissionsName());
			}
		}

		return simpleAuthorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		//加这一步的目的是在Post请求的时候会先进认证，然后在到请求
		if (authenticationToken.getPrincipal() == null) {
			return null;
		}
		//获取用户信息
		String name = authenticationToken.getPrincipal().toString();
		System.out.println("认证"+name);
		User user = loginService.getUserByName(name);
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = servletRequestAttributes.getRequest();
		HttpSession  session=  request.getSession();
		session.setAttribute("asd",user);

		if (user == null) {
			//这里返回后会报出对应异常
			return null;
		} else {
			//这里验证authenticationToken和simpleAuthenticationInfo的信息
			SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, user.getPassWord().toString(), getName());
			return simpleAuthenticationInfo;
		}
	}
//	@Resource
//	private TuserMapper tuserMapper;
//
//	@Resource
//	private TroleMapper troleMapper;
//
//	@Resource
//	private TuserroleMapper tuserroleMapper;
//
//	@Resource
//	private TmenuMapper tmenuMapper;
//
//	/**
//	 * 授权
//	 */
//	@Override
//	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		String userName=(String) SecurityUtils.getSubject().getPrincipal();
//
//		//User user=userRepository.findByUserName(userName);
//		//根据用户名查询出用户记录
//		Example tuserExample=new Example(Tuser.class);
//		tuserExample.or().andEqualTo("userName",userName);
//		Tuser user=tuserMapper.selectByExample(tuserExample).get(0);
//
//
//		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
//
//		//List<Role> roleList=roleRepository.findByUserId(user.getId());
//		List<Trole> roleList = troleMapper.selectRolesByUserId(user.getId());
//
//		Set<String> roles=new HashSet<String>();
//		if(roleList.size()>0){
//			for(Trole role:roleList){
//				roles.add(role.getName());
//				//List<Tmenu> menuList=menuRepository.findByRoleId(role.getId());
//				//根据角色id查询所有资源
//				List<Tmenu> menuList=tmenuMapper.selectMenusByRoleId(role.getId());
//				for(Tmenu menu:menuList){
//					info.addStringPermission(menu.getName()); // 添加权限
//				}
//			}
//		}
//		info.setRoles(roles);
//		return info;
//	}
//
//	/**
//	 * 权限认证
//				*/
//		@Override
//		protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//			String userName=(String)token.getPrincipal();
//			//User user=userRepository.findByUserName(userName);
//			Example tuserExample=new Example(Tuser.class);
//			tuserExample.or().andEqualTo("userName",userName);
//			Tuser user=tuserMapper.selectByExample(tuserExample).get(0);
//			if(user!=null){
//				AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(),"xxx");
//				return authcInfo;
//			}else{
//				return null;
//			}
//	}

}
