package oit.is.pachimon.kaizi.pachimon.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class PachimonAuthConfiguration {

  /**
   * 認証処理に関する設定（誰がどのようなロールでログインできるか）
   *
   * @return
   */
  @Bean
  public InMemoryUserDetailsManager userDetailsService() {
    // このクラスの下部にあるPasswordEncoderを利用して，ユーザのビルダ（ログインするユーザを作成するオブジェクト）を作成する
    UserBuilder users = User.builder();

    // UserBuilder usersにユーザ名，パスワード，ロールを指定してbuildする
    // このときパスワードはBCryptでハッシュ化されている．
    // ハッシュ化されたパスワードを得るには，この授業のbashターミナルで下記のように末尾にユーザ名とパスワードを指定すると良い(要VPN)
    // ロールを複数追加することもできる
    UserDetails user1 = users //sshrun htpasswd -nbBC 10 user1 honou
        .username("z0894")
        .password("$2y$10$KboAueMMnh1IxS7Y/3KJtuv5QcjU3Mb0dpDYZ3u5c.iSPXK/MGdkC")
        .roles("ADMIN")
        .build();
    UserDetails user2 = users //sshrun htpasswd -nbBC 10 user2 mizu
        .username("z0909")
        .password("$2y$10$4ZjCMNonU57LmzEP.WHkGu6WlmPJTgZ2JLSDTiLplN6tdOKDlbJ7a")
        .roles("USER")
        .build();
    UserDetails user3 = users // sshrun htpasswd -nbBC 10 user3 kusa
        .username("z1343")
        .password("$2y$10$n8eMgSoNQBWEbiqgaisISOLxmitnnvbVS0cGsqB.ZOBhz8eFSgKR.")
        .roles("USER")
        .build();
    UserDetails user4 = users // sshrun htpasswd -nbBC 10 user4 denki
        .username("z1198")
        .password("$2y$10$lvT.6U5k/IGkRMMOacZUXeL6c86fHbMkifAQGuFLU5U7L1l8.6TS6")
        .roles("USER")
        .build();
    /*// $ sshrun htpasswd -nbBC 10 customer2 p@ss
    UserDetails customer2 = users
        .username("customer2")
        .password("$2y$10$ngxCDmuVK1TaGchiYQfJ1OAKkd64IH6skGsNw1sLabrTICOHPxC0e")
        .roles("CUSTOMER")
        .build();
    // $ sshrun htpasswd -nbBC 10 seller p@ss
    UserDetails seller = users
        .username("seller")
        .password("$2y$10$ngxCDmuVK1TaGchiYQfJ1OAKkd64IH6skGsNw1sLabrTICOHPxC0e")
        .roles("SELLER")
        .build();
    */

    // 生成したユーザをImMemoryUserDetailsManagerに渡す（いくつでも良い）
    return new InMemoryUserDetailsManager(user1, user2, user3, user4);
  }

  /**
   * 認可処理に関する設定（認証されたユーザがどこにアクセスできるか）
   *
   * @param http
   * @return
   * @throws Exception
   */
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    // Spring Securityのフォームを利用してログインを行う（自前でログインフォームを用意することも可能）
    http.formLogin();
    // http://localhost:8000/sample3 で始まるURLへのアクセスはログインが必要
    // mvcMatchers().authenticated()がmvcMatchersに指定されたアクセス先に認証処理が必要であることを示す
    // authenticated()の代わりにpermitAll()と書くと認証不要となる
    http.authorizeHttpRequests()
        .mvcMatchers("/pachimon/**").authenticated();
        //.mvcMatchers("/sample4/**").authenticated()
        //.mvcMatchers("/sample5/**").authenticated()
        //.mvcMatchers("/sample58*").authenticated()
    http.logout().logoutSuccessUrl("/"); // ログアウト時は "http://localhost:8000/" に戻る
    /**
     * 以下2行はh2-consoleを利用するための設定なので，開発が完了したらコメントアウトすることが望ましい
     * CSRFがONになっているとフォームが対応していないためアクセスできない
     * HTTPヘッダのX-Frame-OptionsがDENYになるとiframeでlocalhostでのアプリが使えなくなるので，H2DBのWebクライアントのためだけにdisableにする必要がある
     */
    http.csrf().disable();
    http.headers().frameOptions().disable();
    return http.build();
  }

  /**
   *
   * UserBuilder users = User.builder();で利用するPasswordEncoderを指定する．
   *
   * @return BCryptPasswordEncoderを返す
   */
  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
