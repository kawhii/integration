package com.carl.framework.core.third.wx.auth;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Carl
 * @date 2017/2/18
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class WXAuthorizingRealm extends JdbcRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        WXAuthenticationToken wxAuthenticationToken = (WXAuthenticationToken) token;
        Connection conn = null;
        try {
            conn = dataSource.getConnection();

            boolean exists = getPasswordForUser(dataSource.getConnection(), wxAuthenticationToken.getOpenId())[0] != null;
            if (!exists) {
                throw new AuthenticationException("openid不存在数据库中");
            }

        } catch (SQLException e) {

            // Rethrow any SQL errors as an authentication exception
            throw new AuthenticationException("用户不存在", e);
        } finally {
            JdbcUtils.closeConnection(conn);
        }
        return new WXAuthenticationInfo(wxAuthenticationToken);
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token != null && WXAuthenticationToken.class.isAssignableFrom(token.getClass());
    }

    private String[] getPasswordForUser(Connection conn, String openid) throws SQLException {

        String[] result = new String[1];
        boolean returningSeparatedSalt = false;

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(authenticationQuery);
            ps.setString(1, openid);

            // Execute query
            rs = ps.executeQuery();

            // Loop over results - although we are only expecting one result, since usernames should be unique
            boolean foundResult = false;
            while (rs.next()) {

                // Check to ensure only one row is processed
                if (foundResult) {
                    throw new AuthenticationException("More than one openid row found for user [" + openid + "]. Usernames must be unique.");
                }

                result[0] = rs.getString(1);
                if (returningSeparatedSalt) {
                    result[1] = rs.getString(2);
                }

                foundResult = true;
            }
        } finally {
            JdbcUtils.closeResultSet(rs);
            JdbcUtils.closeStatement(ps);
        }

        return result;
    }
}
