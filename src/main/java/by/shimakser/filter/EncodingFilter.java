package by.shimakser.filter;

import java.io.IOException;

// фильтр кодировки, любой запрос пришедший на сервер для сервера имеет не известную кодировку,
// этот фильтр говорит серверу что это utf-8
public class EncodingFilter implements javax.servlet.Filter {

    public void init(javax.servlet.FilterConfig config) {

    }

    public void doFilter(javax.servlet.ServletRequest req, javax.servlet.ServletResponse resp, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, IOException {
        req.setCharacterEncoding("UTF-8");// устанавливваем кодировку
        chain.doFilter(req, resp); // продолжаем выполнение
    }

    public void destroy() {

    }
}