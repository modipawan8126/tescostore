package tesco.pm.tescostore.identity;

import java.util.List;

/**
 * Created by has7 on 8/29/2017.
 */

public class IdentityServiceResponse {

    private Claims[] Claims;

    private String scope;

    private String expires_in;

    private String token_type;

    private String refresh_token;

    private String access_token;

    public Claims[] getClaims ()
    {
        return Claims;
    }

    public void setClaims (Claims[] Claims)
    {
        this.Claims = Claims;
    }

    public String getScope ()
    {
        return scope;
    }

    public void setScope (String scope)
    {
        this.scope = scope;
    }

    public String getExpires_in ()
    {
        return expires_in;
    }

    public void setExpires_in (String expires_in)
    {
        this.expires_in = expires_in;
    }

    public String getToken_type ()
    {
        return token_type;
    }

    public void setToken_type (String token_type)
    {
        this.token_type = token_type;
    }

    public String getRefresh_token ()
    {
        return refresh_token;
    }

    public void setRefresh_token (String refresh_token)
    {
        this.refresh_token = refresh_token;
    }

    public String getAccess_token ()
    {
        return access_token;
    }

    public void setAccess_token (String access_token)
    {
        this.access_token = access_token;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Claims = "+Claims+", scope = "+scope+", expires_in = "+expires_in+", token_type = "+token_type+", refresh_token = "+refresh_token+", access_token = "+access_token+"]";
    }
   /* private String accessToken;


    private String tokenType;


    private String expiresIn;


    private String refreshToken;


    private String scope;


    private List<IdentityServiceClaim> identityServiceClaims;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public List<IdentityServiceClaim> getIdentityServiceClaims() {
        return identityServiceClaims;
    }

    public void setIdentityServiceClaims(List<IdentityServiceClaim> identityServiceClaims) {
        this.identityServiceClaims = identityServiceClaims;
    }*/
}
